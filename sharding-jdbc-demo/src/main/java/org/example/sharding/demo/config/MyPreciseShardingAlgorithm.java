package org.example.sharding.demo.config;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2021/1/6
 */
public class MyPreciseShardingAlgorithm implements PreciseShardingAlgorithm<Long> {
    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> preciseShardingValue) {
        for (String tableName : availableTargetNames) {
            if (tableName.endsWith(preciseShardingValue.getValue() % 4 + "")) {
                return tableName;
            }
        }
        throw new IllegalArgumentException();
    }
}
