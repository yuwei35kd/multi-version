package cn.com.proinnova.epidemic.config;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import cn.com.proinnova.epidemic.CodeVersion;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 获取不同版本Bean工具类
 */
@Component
public class SpringBeanUtils implements ApplicationContextAware {
    private static List<String> versionList = Lists.newArrayList("4.0", "3.0", "2.0");

    private static ApplicationContext applicationContext;

    //service接口名-版本-实现类
    private static final Map<String, Map<String, Object>> classNameVersionBeanMap = Maps.newHashMap();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (SpringBeanUtils.applicationContext == null) {
            SpringBeanUtils.applicationContext = applicationContext;
        }
    }

    /**
     * 获取Service实现类
     *
     * 根据版本号降级获取Service实现类，获取不到则拿没有版本的实现类
     *
     * @param versionId
     * @param cls
     * @param <T>
     * @return
     */
    public static <T> T getService(String versionId, Class<T> cls) {
        Map<String, Object> versionBeanMap = getVersionBeanMap(cls);
        int index = versionList.indexOf(versionId);
        if (index >= 0) {
            for (int i = index; i < versionList.size(); i++) {
                Object interfaceServiceImpl = versionBeanMap.get(versionList.get(i));
                if(interfaceServiceImpl!=null){
                    return (T)interfaceServiceImpl;
                }
            }
        }
        return getDefaultService(versionBeanMap);
    }

    /**
     * 根据Service接口Class获取所有实现类中，版本与实现类的对应关系
     *
     * 首先从classNameVersionBeanMap变量中根据全限定类名获取，拿不到则从Spring上下文中获取
     * @param cls
     * @param <T>
     * @return
     */
    private static <T> Map<String, Object> getVersionBeanMap(Class<T> cls) {
        String className = cls.getPackage().getName()+"."+cls.getName();
        Map<String, Object> versionBeanMap = classNameVersionBeanMap.get(className);
        if (versionBeanMap == null) {
            versionBeanMap = Maps.newHashMap();
            Map<String, T> beans = applicationContext.getBeansOfType(cls);
            Set<Entry<String, T>> entrySet = beans.entrySet();
            Iterator<Entry<String, T>> iterator = entrySet.iterator();
            while (iterator.hasNext()) {
                Object interfaceServiceImpl = iterator.next().getValue();
                CodeVersion myVersion = interfaceServiceImpl.getClass().getAnnotation(CodeVersion.class);
                if (null != myVersion) {
                    String version = myVersion.version();
                    versionBeanMap.put(version, interfaceServiceImpl);
                } else {
                    versionBeanMap.put(null, interfaceServiceImpl);
                }
            }
        }
        return versionBeanMap;
    }

    /**
     * 获取默认的service
     *
     * @param versionBeanMap
     * @param <T>
     * @return
     */
    private static <T> T getDefaultService(Map<String, Object> versionBeanMap) {
        return (T) versionBeanMap.get(null);
    }

    //获取applicationContext
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static <T> Map<String, T> getddd(Class<T> cls) {
        return applicationContext.getBeansOfType(cls);
    }

    //通过name获取 Bean.
    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }

    //通过class获取Bean.
    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }

    //通过name,以及Clazz返回指定的Bean
    public static <T> T getBean(String name, Class<T> clazz) {
        return getApplicationContext().getBean(name, clazz);
    }
}