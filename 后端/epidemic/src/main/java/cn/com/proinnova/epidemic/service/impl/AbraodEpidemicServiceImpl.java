package cn.com.proinnova.epidemic.service.impl;

import cn.com.proinnova.epidemic.bean.AbraodEpidemic;
import cn.com.proinnova.epidemic.config.ThreadLocalSysVal;
import cn.com.proinnova.epidemic.dao.AbraodEpidemicDao;
import cn.com.proinnova.epidemic.service.AbraodEpidemicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AbraodEpidemicServiceImpl implements AbraodEpidemicService {
    @Resource
    private AbraodEpidemicDao abraodEpidemicDao;

    public List<AbraodEpidemic> list(){
        return abraodEpidemicDao.list(ThreadLocalSysVal.get().getApp());
    }
}
