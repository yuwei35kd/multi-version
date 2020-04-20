package cn.com.proinnova.epidemic.service.impl;

import cn.com.proinnova.epidemic.MyVersion;
import cn.com.proinnova.epidemic.bean.Epidemic;
import cn.com.proinnova.epidemic.config.ThreadLocalSysVal;
import cn.com.proinnova.epidemic.dao.EpidemicDao;
import cn.com.proinnova.epidemic.service.EpidemicService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("EpidemicService3")
@MyVersion(version = "3.0")
public class EpidemicServiceImpl3 implements EpidemicService {
    @Resource(name = "EpidemicService2")
    private EpidemicService epidemicService2;

    @Value("${deadnum}")
    private Integer deadNum;

    @Resource
    private EpidemicDao epidemicDao;

    @Override
    public List<Epidemic> listAddedDead(Integer top) {
        List<Epidemic> epidemicList = epidemicDao.listAddedDeadTop(ThreadLocalSysVal.get().getApp(),top);
        epidemicService2.setFlag(epidemicList);
        return epidemicList;
    }

}
