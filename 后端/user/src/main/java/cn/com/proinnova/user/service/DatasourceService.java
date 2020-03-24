package cn.com.proinnova.user.service;

import cn.com.proinnova.user.bean.Datasource;

public interface DatasourceService {
    Datasource getDatasourceByUserId(Integer userId);
}
