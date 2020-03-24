package cn.com.proinnova.epidemic.interceptor;

import cn.com.proinnova.epidemic.bean.Datasource;
import cn.com.proinnova.epidemic.config.ThreadLocalVersion;
import cn.com.proinnova.epidemic.dynamicdatasource.DataSourceBean;
import cn.com.proinnova.epidemic.dynamicdatasource.DataSourceHolder;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class Interceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Integer userId = Integer.parseInt(request.getParameter("userId"));
        Map<String,Integer> valMap = new HashMap<>();
        valMap.put("userId",userId);
        Datasource datasource = new RestTemplate().getForObject("http://localhost:8800/user/getDatasourceByUserId?userId="+userId, Datasource.class);
        //切换数据源
        DataSourceBean bean = new DataSourceBean();
        bean.setBeanName(datasource.getTenantCode());
        bean.setJdbcUrl(datasource.getUrl());
        bean.setUsername(datasource.getUsername());
        bean.setPassword(datasource.getPassword());
        bean.setDriverClassName(datasource.getDriverClass());
        DataSourceHolder.setDataSource(bean);

        //获取版本
        String version = new RestTemplate().getForObject("http://localhost:8800/user/version?userId="+userId, String.class);
        ThreadLocalVersion.put(version);
        return true;
    }
}
