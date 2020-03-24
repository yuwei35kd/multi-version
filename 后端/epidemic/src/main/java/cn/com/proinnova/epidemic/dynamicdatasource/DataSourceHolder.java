package cn.com.proinnova.epidemic.dynamicdatasource;


public final class DataSourceHolder {
    private static ThreadLocal<DataSourceBean> threadLocal=new ThreadLocal<DataSourceBean>();
 
    static DataSourceBean getDataSource(){
        return threadLocal.get();
    }
 
    public static void setDataSource(DataSourceBean bean){
        threadLocal.set(bean);
    }
 
 
    public static void clearDataSource(){
        threadLocal.remove();
    }
}
