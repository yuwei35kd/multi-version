package cn.com.proinnova.epidemic.config;

public class ThreadLocalVersion {
    private static ThreadLocal<String> versionLocal = new ThreadLocal<>();

    public static void put(String version){
        versionLocal.set(version);
    }

    public static String get(){
        return versionLocal.get();
    }
}
