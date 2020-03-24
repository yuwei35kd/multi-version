package cn.com.proinnova.user.dao;

import cn.com.proinnova.user.bean.Datasource;

public interface DatasourceDao {
    Datasource getDatasourceByUserId(Integer userId);
}
