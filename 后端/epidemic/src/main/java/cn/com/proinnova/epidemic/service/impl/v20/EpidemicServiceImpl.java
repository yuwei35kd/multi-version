package cn.com.proinnova.epidemic.service.impl.v20;

import cn.com.proinnova.epidemic.CodeVersion;
import cn.com.proinnova.epidemic.bean.Epidemic;
import cn.com.proinnova.epidemic.config.ThreadLocalSysVal;
import cn.com.proinnova.epidemic.dao.EpidemicDao;
import cn.com.proinnova.epidemic.service.EpidemicService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("EpidemicService2.0")
@CodeVersion(version = "2.0")
public class EpidemicServiceImpl implements EpidemicService {
    @Value("${deadnum}")
    private Integer deadNum;

    @Resource
    private EpidemicDao epidemicDao;

    @Override
    public List<Epidemic> list() {
        List<Epidemic> epidemicList = epidemicDao.listAddedDead(ThreadLocalSysVal.get().getApp());
        setFlag(epidemicList);
        return epidemicList;
    }

    /**
     * 死亡人数过多打标记
     *
     * @param epidemicList 疫情列表
     */
    @Override
    public void setFlag(List<Epidemic> epidemicList) {
        for (Epidemic epidemic : epidemicList) {
            if (epidemic.getDead() >= deadNum) {
                epidemic.setFlag(true);
            } else {
                epidemic.setFlag(false);
            }
        }
    }

}
