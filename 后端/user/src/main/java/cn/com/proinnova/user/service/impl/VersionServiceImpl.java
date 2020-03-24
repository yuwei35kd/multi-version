package cn.com.proinnova.user.service.impl;

import cn.com.proinnova.user.dao.VersionDao;
import cn.com.proinnova.user.service.VersionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class VersionServiceImpl implements VersionService {
    @Resource
    private VersionDao versionDao;

    /**
     * 根据用户id获取版本号
     *
     * @param userId 用户id
     * @return
     */
    @Override
    public String getVersion(Integer userId) {
        return versionDao.getVersion(userId);
    }
}
