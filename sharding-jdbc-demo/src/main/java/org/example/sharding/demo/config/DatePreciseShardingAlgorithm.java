package org.example.sharding.demo.config;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.google.common.collect.Range;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2021/1/6
 */
public class DatePreciseShardingAlgorithm implements PreciseShardingAlgorithm<Date>, RangeShardingAlgorithm<Date> {

    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Date> preciseShardingValue) {
        Date value = preciseShardingValue.getValue();
        String mouth = DateUtil.format(value, "yyyyMM");
        for (String tableName : collection) {
            if (tableName.endsWith(mouth)) {
                return tableName;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, RangeShardingValue<Date> shardingValue) {
        Collection<String> collect = new ArrayList<String>();
        Range<Date> valueRange = shardingValue.getValueRange();
        String upperEndpoint = DateUtil.format(valueRange.upperEndpoint(), "yyyyMM");
        DateTime upperEndpointDate = DateUtil.parse(upperEndpoint, "yyyyMM");
        String lowerEndpoint = DateUtil.format(valueRange.lowerEndpoint(), "yyyyMM");
        DateTime lowerEndpointDate = DateUtil.parse(lowerEndpoint, "yyyyMM");
        for (String targetName : availableTargetNames) {
            String mouth = targetName.substring("person_attence_".length());
            DateTime yyyyMM = DateUtil.parse(mouth, "yyyyMM");
            if(!yyyyMM.isBefore(lowerEndpointDate) && !yyyyMM.isAfter(upperEndpointDate)){
                collect.add(targetName);
            }
        }
        return collect;
    }

    public static void main(String[] args) {
        System.out.println("person_attence_202001".substring("person_attence_".length()));
    }
}
