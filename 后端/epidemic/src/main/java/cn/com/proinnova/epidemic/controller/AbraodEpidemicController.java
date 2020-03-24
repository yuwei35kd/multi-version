package cn.com.proinnova.epidemic.controller;

import cn.com.proinnova.epidemic.bean.AbraodEpidemic;
import cn.com.proinnova.epidemic.service.AbraodEpidemicService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/abraod")
public class AbraodEpidemicController {
    @Resource
    private AbraodEpidemicService abraodEpidemicService;

    /**
     * 国外疫情列表
     *
     * @return
     */
    @GetMapping("/list")
    public List<AbraodEpidemic> list(){
        return abraodEpidemicService.list();
    }
}
