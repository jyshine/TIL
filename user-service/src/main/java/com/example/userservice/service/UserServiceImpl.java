package com.example.userservice.service;

import com.example.userservice.dto.UserDTO;
import com.example.userservice.entity.UserEntity;
import com.example.userservice.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        userDTO.setUserId(UUID.randomUUID().toString());
        ModelMapper modelMapper = new ModelMapper();
        /*매칭 정보 셋팅*/
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);
        userEntity.setEncryptedPwd("encrypted_password");

        userRepository.save(userEntity);

        return null;
    }
}
