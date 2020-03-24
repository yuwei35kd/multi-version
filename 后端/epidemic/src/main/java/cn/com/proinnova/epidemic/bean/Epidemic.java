package cn.com.proinnova.epidemic.bean;

public class Epidemic {
    private String provinnce;//省份
    private Integer xcqz;//现存确诊
    private Integer ljqz;//累积确诊
    private Integer xz;//新增
    private Integer ljzy;//累积治愈
    private Integer dead;//死亡
    private boolean flag;//预警标记

    public String getProvinnce() {
        return provinnce;
    }

    public void setProvinnce(String provinnce) {
        this.provinnce = provinnce;
    }

    public Integer getXcqz() {
        return xcqz;
    }

    public void setXcqz(Integer xcqz) {
        this.xcqz = xcqz;
    }

    public Integer getLjqz() {
        return ljqz;
    }

    public void setLjqz(Integer ljqz) {
        this.ljqz = ljqz;
    }

    public Integer getXz() {
        return xz;
    }

    public void setXz(Integer xz) {
        this.xz = xz;
    }

    public Integer getLjzy() {
        return ljzy;
    }

    public void setLjzy(Integer ljzy) {
        this.ljzy = ljzy;
    }

    public Integer getDead() {
        return dead;
    }

    public void setDead(Integer dead) {
        this.dead = dead;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
