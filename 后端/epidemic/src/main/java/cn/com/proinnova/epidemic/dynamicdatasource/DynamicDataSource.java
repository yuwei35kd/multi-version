package cn.com.proinnova.epidemic.dynamicdatasource;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 自定义动态数据源
 * 
 * @author daibo
 *
 */
public class DynamicDataSource extends AbstractRoutingDataSource implements ApplicationContextAware {

	// 全局context对象，用于动态注入数据源对象
	private ApplicationContext applicationContext;

	private static final String DATA_SOURCES_NAME = "targetDataSources";

	
	/**
	 * 框架在每次调用数据源时会先调用这个方法,以便知道使用哪个数据源
	 * @return
	 */
	@Override
	protected Object determineCurrentLookupKey() {
		DataSourceBean dataSourceBean = DataSourceHolder.getDataSource();
		if (dataSourceBean == null) {
			return null;
		}
		 //查看当前容器中是否存在
        try {
        	/*
        	 * 先从ThreadLocal中拿出要使用的数据源信息，然后看当前的targetDataSources中是否有了这个数据源。
        	 * 如果有直接返回。如果没有，创建一个这样的数据源，放到targetDataSources中然后返回。这个过程需要加锁，
        	 * 判断后插入场景，在多线程中会有线程安全问题，所以要加锁！
        	 */
            Map<Object,Object> map = getTargetDataSources();
            synchronized (this) {
                if (!map.keySet().contains(dataSourceBean.getBeanName())) {
                    map.put(dataSourceBean.getBeanName(), createDataSource(dataSourceBean));
                    super.afterPropertiesSet();//通知spring有bean更新
                }
            }   
            Set<Entry<Object, Object>> entrySet = map.entrySet();
//            for (Entry<Object, Object> entry : entrySet) {
//				System.out.println(entry.getKey());
//				System.out.println((HikariDataSource)entry.getValue());
//			}
//            System.out.println("currentDatabase->"+(HikariDataSource)map.get(dataSourceBean.getBeanName()));
            return dataSourceBean.getBeanName();
        } catch (Exception e) {
            e.printStackTrace();
        }

		return null;
	}
	
	
	private Object createDataSource(DataSourceBean dataSourceBean) throws IllegalAccessException {
        //在spring容器中创建并且声明bean
        ConfigurableApplicationContext context = (ConfigurableApplicationContext) applicationContext;
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) context.getBeanFactory();
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(HikariDataSource.class);
        
        //将dataSourceBean中的属性值赋给目标bean
        Map<String, Object> properties = getPropertyKeyValues(DataSourceBean.class, dataSourceBean);
        for (Entry<String, Object> entry : properties.entrySet()) {
            beanDefinitionBuilder.addPropertyValue((String) entry.getKey(), entry.getValue());
        }
        beanFactory.registerBeanDefinition(dataSourceBean.getBeanName(), beanDefinitionBuilder.getBeanDefinition());
        return applicationContext.getBean(dataSourceBean.getBeanName());
    }

	
	private <T> Map<String, Object> getPropertyKeyValues(Class<T> clazz, Object object) throws IllegalAccessException {
        Field[] fields = clazz.getDeclaredFields();
        Map<String, Object> result = new HashMap<String, Object>();
        for (Field field : fields) {
        	//去除不用属性，避免引起的错误
        	if (field.getName().equals("serialVersionUID")) {
				continue;
			}
            field.setAccessible(true);
            result.put(field.getName(), field.get(object));
        }
        result.remove("beanName");
        return result;
    }


	@SuppressWarnings({ "unchecked", "unused" })
	private Map<Object, Object> getTargetDataSources() throws NoSuchFieldException, IllegalAccessException {
		Field field = AbstractRoutingDataSource.class.getDeclaredField(DATA_SOURCES_NAME);
		field.setAccessible(true);
		return (Map<Object, Object>) field.get(this);
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}
