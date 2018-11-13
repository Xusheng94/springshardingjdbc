package com.demo.algorithm;

import com.dangdang.ddframe.rdb.sharding.api.ShardingValue;
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.SingleKeyTableShardingAlgorithm;
import com.google.common.collect.Range;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Description
 * @Author xusheng
 * @Create 2018-11-12 15:50
 * @Version 1.0
 **/
public class SingleKeyDynamicModuloTableShardingAlgorithm implements SingleKeyTableShardingAlgorithm<Date> {

    private final String tablePrefix="user_";

    @Override
    public String doEqualSharding(Collection<String> availableTargetNames, ShardingValue<Date> shardingValue) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMM");

        String tableName = tablePrefix + formatter.format(shardingValue.getValue());
        return tableName;
    }


    @Override
    public Collection<String> doInSharding(Collection<String> availableTargetNames, ShardingValue<Date> shardingValue) {
        Collection<String> result = new LinkedHashSet<>(shardingValue.getValues().size());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMM");
        for(Date value:shardingValue.getValues()){
            result.add(tablePrefix+formatter.format(value));
        }
        return result;
    }


    @Override
    public Collection<String> doBetweenSharding(Collection<String> availableTargetNames, ShardingValue<Date> shardingValue) {
        Collection<String> result = new LinkedList<>();
        DateFormat sdf = new SimpleDateFormat("yyyyMM");
        Range<Date> valueRange = shardingValue.getValueRange();
        Date startTime = valueRange.lowerEndpoint();
        Date endTime = valueRange.upperEndpoint();
        Calendar cal = Calendar.getInstance();
       while(startTime.getTime()<=endTime.getTime()){
           result.add(tablePrefix+sdf.format(startTime));
           cal.setTime(startTime);
           cal.add(Calendar.MONTH,1);
           startTime = cal.getTime();
       }

        return result;
    }
}
