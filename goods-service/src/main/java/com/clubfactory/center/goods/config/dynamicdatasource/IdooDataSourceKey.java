package com.clubfactory.center.goods.config.dynamicdatasource;

/**
 * 描述:
 *  动态数据源切换
 * @author pangpeijie
 * @create 2018-05-21 19:02
 */
public enum IdooDataSourceKey {

    YUHANG(1,"余杭仓库"),
    XIAOSHAN(2,"萧山仓库"),
    XINYI(3,"心怡仓库");

    private Integer code;

    /**
     * 数据源描述
     */
    private String desc;

    IdooDataSourceKey(Integer code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public Integer getCode() {

        return code;
    }

}
