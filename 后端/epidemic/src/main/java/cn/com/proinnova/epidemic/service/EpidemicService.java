package cn.com.proinnova.epidemic.service;

import cn.com.proinnova.epidemic.bean.Epidemic;

import java.util.List;

public interface EpidemicService {
    default List<Epidemic> list(){return null;}

    default List<Epidemic> listAddedDead(Integer top){return null;}

    default void setFlag(List<Epidemic> epidemicList){}
}
