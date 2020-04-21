package cn.com.proinnova.user.dao;

import org.apache.ibatis.annotations.Param;

public interface VersionDao {
    String getVersion(@Param("userId") Integer userId, @Param("app") Integer app);
}
