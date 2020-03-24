package cn.com.proinnova.user.service.impl;

import cn.com.proinnova.user.bean.Datasource;
import cn.com.proinnova.user.dao.DatasourceDao;
import cn.com.proinnova.user.service.DatasourceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DatasourceServiceImpl implements DatasourceService {
    @Resource
    private DatasourceDao datasourceDao;

    /**
     * 根据用户id获取数据源
     *
     * @param userId 用户id
     * @return
     */
    @Override
    public Datasource getDatasourceByUserId(Integer userId) {
        return datasourceDao.getDatasourceByUserId(userId);
    }
}
