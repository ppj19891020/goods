package com.clubfactory.center.goods.config.dynamicdatasource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 描述:
 *  动态数据源切面
 * @author pangpeijie
 * @create 2018-05-21 19:24
 */
@Aspect
@Component
public class DynamicDataSourceAspect {

    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceAspect.class);


    @Pointcut("execution( * com.clubfactory.center.goods.dao.idoo.*.*(..))")
    public void daoAspect() {
    }

    /**
     * 重置数据源
     * @param point
     */
    @After("daoAspect())")
    public void restoreDataSource(JoinPoint point) {
        DynamicIdooDataSourceContextHolder.clearDataSourceKey();
        logger.info("Restore DataSource to [{}] in Method [{}]",
                DynamicIdooDataSourceContextHolder.getDataSourceKey(), point.getSignature());
    }

}
