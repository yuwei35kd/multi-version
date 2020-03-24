package cn.com.proinnova.user.dao;

import cn.com.proinnova.user.bean.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    User findUser(@Param("userName") String userName, @Param("pwd") String pwd, @Param("tenantCode") String tenantCode);
}
