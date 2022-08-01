package com.strategy.strategyfactorytest.service;

import com.strategy.strategyfactorytest.common.StrategyName;
import com.strategy.strategyfactorytest.factory.StrategyFactory;
import com.strategy.strategyfactorytest.stragegy.ProductStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
//    @Autowired
//    private StrategyFactory strategyFactory;
//
//
//    public void findSome() {
//        // 이름을 전달해서 전략을 가져올 수 있다.
//        ProductStrategy strategy = strategyFactory.findStrategy(StrategyName.StrategyA);
//        System.out.println(strategy);
//        // 이제 전략에 정의된 메소드를 호출할 수 있다.
//        strategy.doStuff();
//    }
}
