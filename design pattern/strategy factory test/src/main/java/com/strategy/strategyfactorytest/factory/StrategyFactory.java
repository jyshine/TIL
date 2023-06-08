package com.strategy.strategyfactorytest.factory;

import com.strategy.strategyfactorytest.common.StrategyName;
import com.strategy.strategyfactorytest.stragegy.ProductStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
@Slf4j
public class StrategyFactory {
    private Map<StrategyName, ProductStrategy> strategies;

    @Autowired
    public StrategyFactory(Set<ProductStrategy> strategySet) {
        log.info("strategySet : {} ",strategySet);
        createStrategy(strategySet);
    }

    public ProductStrategy findStrategy(StrategyName strategyName){
        log.info("strategyName : {}", strategyName);
        return strategies.get(strategyName);
    }

    private void createStrategy(Set<ProductStrategy> strategySet) {
        strategies = new HashMap<>();
        strategySet.forEach(
                strategy -> strategies.put(strategy.getStrategyName(), strategy)
        );
    }
}
