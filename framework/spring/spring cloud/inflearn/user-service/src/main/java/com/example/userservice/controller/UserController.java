package com.example.userservice.controller;

import com.example.userservice.dto.UserDTO;
import com.example.userservice.entity.UserEntity;
import com.example.userservice.service.UserService;
import com.example.userservice.vo.Gretting;
import com.example.userservice.vo.RequestUser;
import com.example.userservice.vo.ResponseUser;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {
    private Environment env;

    private UserService userService;

    @Autowired
    private Gretting gretting;

    @Autowired
    public UserController(Environment env, UserService userService) {
        this.env = env;
        this.userService = userService;
    }

    @GetMapping("/health-check")
    public String status(){

        return String.format("It's Working in User Service "
                        + " local.server.port = " + env.getProperty("local.server.port")
                        + " server.port = " + env.getProperty("server.port")
                        + " token.secret = " + env.getProperty("token.secret")
                        + " token.expiration_time = " + env.getProperty("token.expiration_time")
        );
    }

    @GetMapping("/welcome")
    public String welcome(){
//        return env.getProperty("gretting.message");
        return gretting.getMessage();
    }

    @PostMapping("/users")
    public String createUser(@RequestBody RequestUser user){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserDTO userDTO = mapper.map(user, UserDTO.class);

        userService.createUser(userDTO);

        return "Success Create User";
    }

    @GetMapping("/users")
    public ResponseEntity<List<ResponseUser>> getUsers(){
        Iterable<UserEntity> userList = userService.getUserByAll();

        List<ResponseUser> result = new ArrayList<>();
        userList.forEach(
                userEntity -> {
                    result.add(new ModelMapper().map(userEntity, ResponseUser.class));
                }
        );

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<ResponseUser> getUser(@PathVariable("userId") String userId){
        UserDTO userDTO = userService.getUserByUserId(userId);
        ResponseUser map = new ModelMapper().map(userDTO, ResponseUser.class);

        return ResponseEntity.status(HttpStatus.OK).body(map);
    }
}
