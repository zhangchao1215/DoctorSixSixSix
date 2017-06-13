package jiyun.com.doctorsixsixsix.modle.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/6/13 10:17
 * 修改人:
 * 修改内容:
 * 修改时间:
 */
@Entity
public class Time {
    @Id(autoincrement = true)
    private Long id;
    private String time;
    private String name;
    private int number;
    @Generated(hash = 1919486792)
    public Time(Long id, String time, String name, int number) {
        this.id = id;
        this.time = time;
        this.name = name;
        this.number = number;
    }
    @Generated(hash = 37380482)
    public Time() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTime() {
        return this.time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getNumber() {
        return this.number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
}
