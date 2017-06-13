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
    private String data_time;
    private String name;
    private int number;
    @Generated(hash = 1072525349)
    public Time(Long id, String data_time, String name, int number) {
        this.id = id;
        this.data_time = data_time;
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
    public String getData_time() {
        return this.data_time;
    }
    public void setData_time(String data_time) {
        this.data_time = data_time;
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

    @Override
    public String toString() {
        return "Time{" +
                "id=" + id +
                ", data_time='" + data_time + '\'' +
                ", name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}
