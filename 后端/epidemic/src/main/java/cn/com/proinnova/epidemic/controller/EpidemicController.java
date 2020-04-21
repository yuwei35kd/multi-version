package cn.com.proinnova.epidemic.controller;

import cn.com.proinnova.epidemic.bean.Epidemic;
import cn.com.proinnova.epidemic.config.SpringBeanUtils;
import cn.com.proinnova.epidemic.config.ThreadLocalSysVal;
import cn.com.proinnova.epidemic.service.EpidemicService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EpidemicController {
    /**
     * 疫情列表
     *
     * @return
     */
    @GetMapping("/list")
    public List<Epidemic> list(){
        String version = ThreadLocalSysVal.get().getVersion();
        EpidemicService epidemicService = SpringBeanUtils.getService(version, EpidemicService.class);
        return epidemicService.list();
    }

    @GetMapping("/list/{top}")
    public List<Epidemic> list(@PathVariable Integer top){
        String version = ThreadLocalSysVal.get().getVersion();
        EpidemicService epidemicService = SpringBeanUtils.getService(version,EpidemicService.class);
        return epidemicService.listAddedDead(top);
    }
}
