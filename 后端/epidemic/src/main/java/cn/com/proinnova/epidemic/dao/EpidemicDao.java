package cn.com.proinnova.epidemic.dao;

import cn.com.proinnova.epidemic.bean.Epidemic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EpidemicDao {
    List<Epidemic> list(Integer app);

    List<Epidemic> listAddedDead(Integer app);

    List<Epidemic> listAddedDeadTop(@Param("app")Integer app,@Param("top") Integer top);

    List<Epidemic> listAddedDeadTop2(Integer app);
}
