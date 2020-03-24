package cn.com.proinnova.user.controller;

import cn.com.proinnova.user.bean.Datasource;
import cn.com.proinnova.user.service.DatasourceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class DatasourceController {
    @Resource
    private DatasourceService datasourceService;

    /**
     * 根据用户id获取数据源
     *
     * @param userId 用户id
     * @return
     */
    @GetMapping("/getDatasourceByUserId")
    public Datasource getDatasourceByUserId(Integer userId){
        return datasourceService.getDatasourceByUserId(userId);
    }
}
