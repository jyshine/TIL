package com.strategy.strategyfactorytest.stragegy;

import com.strategy.strategyfactorytest.common.StrategyName;

public interface ProductStrategy {
    String doStuff();

    StrategyName getStrategyName();

}
