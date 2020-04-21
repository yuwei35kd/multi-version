package cn.com.proinnova.user.controller;

import cn.com.proinnova.user.service.VersionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class VersionController {
    @Resource
    private VersionService versionService;

    /**
     * 获取版本号
     *
     * @param userId 用户id
     * @return
     */
    @GetMapping("/version")
    public String getVersion(Integer userId, Integer app) {
        return versionService.getVersion(userId, app);
    }
}
