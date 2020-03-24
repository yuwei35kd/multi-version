package cn.com.proinnova.epidemic.config;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import cn.com.proinnova.epidemic.MyVersion;
import com.google.common.collect.Lists;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringBeanUtils implements ApplicationContextAware{
    private static List<String> versionList = Lists.newArrayList("4.0","3.0","2.0");

    private static ApplicationContext applicationContext;

    @Override
    public  void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(SpringBeanUtils.applicationContext == null) {
            SpringBeanUtils.applicationContext = applicationContext;
        }
    }

    /**
     * 获取Service实现类
     *
     * @param versionId
     * @param cls
     * @param <T>
     * @return
     */
    public static <T> T getService(String versionId, Class<T> cls) {
		Map<String, T> beans = applicationContext.getBeansOfType(cls);
        // 遍历所有实现类
        Set<Entry<String, T>> entrySet = beans.entrySet();
        int index = versionList.indexOf(versionId);
        if(index >= 0){
            for (int i = index; i < versionList.size(); i++) {
                Iterator<Entry<String, T>> iterator = entrySet.iterator();
                while (iterator.hasNext()) {
                    Object interfaceServiceImpl = iterator.next().getValue();
                    // 获取实现类的所有注解
                    MyVersion serviceVersion = interfaceServiceImpl.getClass().getAnnotation(MyVersion.class);
                    if (null != serviceVersion) {
                        String version = serviceVersion.version();
                        if(versionList.get(i).equals(version)) {//根据版本号匹配
                            return (T)interfaceServiceImpl;
                        }
                    }
                }
            }
        }
        return getDefaultService(beans);
    }

    /**
     * 获取默认的service
     *
     * @param beans
     * @param <T>
     * @return
     */
    private static <T> T getDefaultService(Map<String, T> beans){
        Set<Entry<String, T>> entrySet = beans.entrySet();
        Iterator<Entry<String, T>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Object interfaceServiceImpl = iterator.next().getValue();
            MyVersion serviceVersion = interfaceServiceImpl.getClass().getAnnotation(MyVersion.class);
            if (null == serviceVersion) {
                return (T)interfaceServiceImpl;
            }
        }
        return null;
    }

    //获取applicationContext
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static <T> Map<String, T> getddd(Class<T> cls){
    	return applicationContext.getBeansOfType(cls);
    }
    
    //通过name获取 Bean.
    public static Object getBean(String name){
        return getApplicationContext().getBean(name);
    }

    //通过class获取Bean.
    public static <T> T getBean(Class<T> clazz){
        return getApplicationContext().getBean(clazz);
    }

    //通过name,以及Clazz返回指定的Bean
    public static <T> T getBean(String name,Class<T> clazz){
        return getApplicationContext().getBean(name, clazz);
    }
}