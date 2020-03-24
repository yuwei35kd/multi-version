package cn.com.proinnova.epidemic.dao;

import cn.com.proinnova.epidemic.bean.Epidemic;

import java.util.List;

public interface EpidemicDao {
    List<Epidemic> list();

    List<Epidemic> listAddedDead();

    List<Epidemic> listAddedDeadTop(Integer top);
}
