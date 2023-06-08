package com.strategy.strategyfactorytest.controller;

import com.strategy.strategyfactorytest.common.StrategyName;
import com.strategy.strategyfactorytest.factory.StrategyFactory;
import com.strategy.strategyfactorytest.service.ProductService;
import com.strategy.strategyfactorytest.stragegy.ProductStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StategyController {

    @Autowired
    private StrategyFactory strategyFactory;


    @GetMapping("/hello")
    public String stategyService(StrategyName strategyName){
        ProductStrategy strategy = strategyFactory.findStrategy(strategyName);
        return strategy.doStuff();
    }
}
