package cn.com.proinnova.user.service;

import cn.com.proinnova.user.bean.User;

public interface UserService {
    User getUser(String userName, String pwd, String tenantCode);
}
