package com.clubfactory.core.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 描述:
 *  数学计算工具类
 * @author pangpeijie
 * @create 2018-05-23 10:14
 */
public class MathUtil {

    /**
     * double保留2位小数
     * @param value
     * @return
     */
    public static double doubleScale(double value) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }


}
