package com.demo.algorithm;

import com.dangdang.ddframe.rdb.sharding.api.ShardingValue;
import com.dangdang.ddframe.rdb.sharding.api.strategy.database.SingleKeyDatabaseShardingAlgorithm;

import java.util.Collection;

/**
 * @Description 分库规则
 * @Author xusheng
 * @Create 2018-11-12 13:56
 * @Version 1.0
 **/
public class DbAlgorithm implements SingleKeyDatabaseShardingAlgorithm<Integer> {
    @Override
    public String doEqualSharding(Collection<String> collection, ShardingValue<Integer> shardingValue) {
        int id = shardingValue.getValue();
        int index = id%2;

        for(String item:collection){
            if(item.endsWith(index+"")){
                return item;
            }
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<String> doInSharding(Collection<String> collection, ShardingValue<Integer> shardingValue) {

        return null;
    }

    @Override
    public Collection<String> doBetweenSharding(Collection<String> collection, ShardingValue<Integer> shardingValue) {
        return null;
    }
}
