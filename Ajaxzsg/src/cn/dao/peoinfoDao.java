package cn.dao;

import cn.pojo.peoinfo;

public interface peoinfoDao {
    /**
     * 查全部
     * @return
     */
    peoinfo selAll(String name);

    /**
     * 增删改通用方法
     * @param sql
     * @param obj
     * @return
     */
    int zsg(String sql, Object[]obj);
}
