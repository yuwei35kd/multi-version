package cn.com.proinnova.epidemic.dynamicdatasource;

import java.io.Serializable;

/**
 * 用于保存从那个默认数据库中拿出来的数据源信息,为了安全起见，使用了builder模式
 * @author daibo
 *
 */
public class DataSourceBean  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 2896676467127320271L;
	private String beanName;
    private String driverClassName;
    private String jdbcUrl;
    private String username;
    private String password;
 
    public DataSourceBean(){
    }
 
    
    public DataSourceBean(String beanName, String driverClassName, String jdbcUrl, String username, String password) {
		super();
		this.beanName = beanName;
		this.driverClassName = driverClassName;
		this.jdbcUrl = jdbcUrl;
		this.username = username;
		this.password = password;
	}


	public String getBeanName() {
		return beanName;
	}


	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}


	public String getDriverClassName() {
		return driverClassName;
	}


	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}



	public String getJdbcUrl() {
		return jdbcUrl;
	}


	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "DataSourceBean [beanName=" + beanName + ", driverClassName=" + driverClassName + ", url=" + jdbcUrl
				+ ", username=" + username + ", password=" + password + "]";
	}

    
}
