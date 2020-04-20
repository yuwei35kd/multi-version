package cn.com.proinnova.epidemic.config;

public class ThreadLocalSysVal {
    private static ThreadLocal<SysVal> sysValThreadLocal = new ThreadLocal<>();

    public static void put(SysVal sysVal){
        sysValThreadLocal.set(sysVal);
    }

    public static SysVal get(){
        return sysValThreadLocal.get();
    }

    public static class SysVal{
        private Integer userId;
        private String version;
        private Integer app;

        public SysVal(Integer userId, String version, Integer app) {
            this.userId = userId;
            this.version = version;
            this.app = app;
        }

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public Integer getApp() {
            return app;
        }

        public void setApp(Integer app) {
            this.app = app;
        }
    }
}
