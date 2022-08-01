package com.strategy.strategyfactorytest.stragegy;

import com.strategy.strategyfactorytest.common.StrategyName;
import org.springframework.stereotype.Component;

@Component
public class ProductStrategyB implements ProductStrategy{
    @Override
    public String doStuff() {
        return "ProductStrategyB";
    }

    @Override
    public StrategyName getStrategyName() {
        return StrategyName.StrategyB;
    }


}
