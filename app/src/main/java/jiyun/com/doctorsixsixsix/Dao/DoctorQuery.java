package jiyun.com.doctorsixsixsix.Dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 项目名称: 血压卫士
 * 类描述: 查询医生的数据库
 * 创建人: Administrator
 * 创建时间: 2017/6/15 11:19
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */
@Entity
public class DoctorQuery {
    @Id(autoincrement = true)
    private Long id;
    private String name;
    @Generated(hash = 551554307)
    public DoctorQuery(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    @Generated(hash = 1226230528)
    public DoctorQuery() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    


}
