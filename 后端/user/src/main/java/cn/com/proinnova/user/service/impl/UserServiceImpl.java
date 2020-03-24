package cn.com.proinnova.user.service.impl;

import cn.com.proinnova.user.bean.User;
import cn.com.proinnova.user.dao.UserDao;
import cn.com.proinnova.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    /**
     * 获取用户
     *
     * @param userName 用户名
     * @param pwd 密码
     * @param tenantCode 公司名
     * @return
     */
    @Override
    public User getUser(String userName, String pwd, String tenantCode) {
        return userDao.findUser(userName, pwd, tenantCode);
    }
}
