package com.demo.algorithm;

import com.dangdang.ddframe.rdb.sharding.api.ShardingValue;
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.SingleKeyTableShardingAlgorithm;

import java.util.Collection;

/**
 * @Description 分表规则
 * @Author xusheng
 * @Create 2018-11-12 13:58
 * @Version 1.0
 **/
public class TbAlgorithm implements SingleKeyTableShardingAlgorithm<Integer> {

    /**
     *
     *  sql between 规则
     *
     * @param availableTargetNames
     * @param shardingValue
     * @return
     */
    @Override
    public String doEqualSharding(Collection<String> availableTargetNames, ShardingValue<Integer> shardingValue) {
        int id = shardingValue.getValue();
        int index = id % 2;
        for (String item : availableTargetNames) {
            if (item.endsWith(index + "")) {
                return item;
            }
        }
        throw new UnsupportedOperationException();
    }

    /**
     * sql == 规则
     * @param collection
     * @param shardingValue
     * @return
     */
    @Override
    public Collection<String> doInSharding(Collection<String> collection, ShardingValue<Integer> shardingValue) {
        return null;
    }

    /**
     *
     * @param collection
     * @param shardingValue
     * @return
     */
    @Override
    public Collection<String> doBetweenSharding(Collection<String> collection, ShardingValue<Integer> shardingValue) {
        return null;
    }
}
