package com.strategy.strategyfactorytest.stragegy;

import com.strategy.strategyfactorytest.common.StrategyName;
import org.springframework.stereotype.Component;

@Component
public class ProductStrategyA implements ProductStrategy{
    @Override
    public String doStuff() {
        return "ProductStrategyA";
    }

    @Override
    public StrategyName getStrategyName() {
        return StrategyName.StrategyA;
    }


}
