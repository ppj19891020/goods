package com.clubfactory.center.goods.config.dynamicdatasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述:
 *  动态数据源切换
 * @author pangpeijie
 * @create 2018-05-21 19:00
 */
public class DynamicIdooDataSourceContextHolder {
    private static final Logger logger = LoggerFactory.getLogger(DynamicIdooDataSourceContextHolder.class);

    /**
     * 用于在切换数据源时保证不会被其他线程修改
     */
    private static Lock lock = new ReentrantLock();

    /**
     * Maintain variable for every thread, to avoid effect other thread
     */
    private static final ThreadLocal<Integer> CONTEXT_HOLDER = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return IdooDataSourceKey.YUHANG.getCode();
        }
    };


    /**
     * All DataSource List
     */
    public static List<Object> dataSourceKeys = new ArrayList<>();


    /**
     * To switch DataSource
     *
     * @param dataSourceKey the key
     */
    public static void setDataSourceKey(IdooDataSourceKey dataSourceKey) {
        try{
            lock.lock();
            CONTEXT_HOLDER.set(dataSourceKey.getCode());
        }finally {
            lock.unlock();
        }
    }

    /**
     * Get current DataSource
     *
     * @return data source key
     */
    public static Integer getDataSourceKey() {
        return CONTEXT_HOLDER.get();
    }

    /**
     * To set DataSource as default
     */
    public static void clearDataSourceKey() {
        CONTEXT_HOLDER.remove();
    }
}

