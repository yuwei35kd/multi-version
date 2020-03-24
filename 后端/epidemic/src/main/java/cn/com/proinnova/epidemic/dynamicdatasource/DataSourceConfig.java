package cn.com.proinnova.epidemic.dynamicdatasource;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.HashMap;
import java.util.Map;


@Configuration
@EnableScheduling
@Slf4j
public class DataSourceConfig {

	
	@ConfigurationProperties(prefix = "spring.datasource")
	public HikariDataSource getHikariDataSource() {
		//按照目标数据源名称和目标数据源对象的映射存放在Map中
		HikariDataSource dataSource = new HikariDataSource();
		return dataSource;
	}
	
	@Bean(name = "dataSource")
	public DynamicDataSource dataSource() {
		//按照目标数据源名称和目标数据源对象的映射存放在Map中
		Map<Object, Object> targetDataSources = new HashMap<>();
		targetDataSources.put("defaultTargetDataSource", getHikariDataSource());
//		//采用是想AbstractRoutingDataSource的对象包装多数据源
		DynamicDataSource dataSource = new DynamicDataSource();
		dataSource.setTargetDataSources(targetDataSources);
		//设置默认的数据源，当拿不到数据源时，使用此配置
		dataSource.setDefaultTargetDataSource(getHikariDataSource());
		return dataSource;
	}
	
}
