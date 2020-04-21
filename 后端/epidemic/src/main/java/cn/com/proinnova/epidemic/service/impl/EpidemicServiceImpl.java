package cn.com.proinnova.epidemic.service.impl;

import cn.com.proinnova.epidemic.CodeVersion;
import cn.com.proinnova.epidemic.bean.Epidemic;
import cn.com.proinnova.epidemic.config.ThreadLocalSysVal;
import cn.com.proinnova.epidemic.dao.EpidemicDao;
import cn.com.proinnova.epidemic.service.EpidemicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EpidemicServiceImpl implements EpidemicService {
    @Resource
    private EpidemicDao epidemicDao;

    @Override
    public List<Epidemic> list() {
        return epidemicDao.list(ThreadLocalSysVal.get().getApp());
    }

}
