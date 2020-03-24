package cn.com.proinnova.user.controller;

import cn.com.proinnova.user.bean.User;
import cn.com.proinnova.user.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class LoginController {
    @Resource
    private UserService userService;

    /**
     * 登录
     *
     * @param userName 用户名
     * @param pwd 密码
     * @param tenantCode 公司名
     * @return
     */
    @GetMapping("/login")
    public User login(String userName, String pwd, String tenantCode) {
        return userService.getUser(userName, pwd, tenantCode);
    }
}
