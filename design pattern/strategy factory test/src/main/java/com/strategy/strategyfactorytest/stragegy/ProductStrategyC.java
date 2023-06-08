package com.strategy.strategyfactorytest.stragegy;

import com.strategy.strategyfactorytest.common.StrategyName;
import org.springframework.stereotype.Component;

@Component
public class ProductStrategyC implements ProductStrategy{
    @Override
    public String doStuff() {
        return "ProductStrategyC";
    }

    @Override
    public StrategyName getStrategyName() {
        return StrategyName.StrategyC;
    }


}
