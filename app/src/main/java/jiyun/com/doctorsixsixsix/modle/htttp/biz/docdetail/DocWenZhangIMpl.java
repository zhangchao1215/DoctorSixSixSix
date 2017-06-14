package jiyun.com.doctorsixsixsix.modle.htttp.biz.docdetail;

import java.util.HashMap;
import java.util.Map;

import jiyun.com.doctorsixsixsix.modle.callback.MyCallBack;
import jiyun.com.doctorsixsixsix.modle.htttp.Factory;
import jiyun.com.doctorsixsixsix.modle.urlutils.URLUtils;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/14 8:14
 * 修改人:  张超
 * 修改内容:  换一换医生的文章详情
 * 修改时间:
 */

public class DocWenZhangIMpl implements DoctorWenzhangModel {
    @Override
    public void WenZhang(String id,String cateid,  MyCallBack callBack) {
        Map<String,String> map = new HashMap<>();
        map.put("tag","BloodAndroid");
        map.put("sign","2c19b2821ebc5306c3ac37bac5b4288b");
        map.put("act","zhuanjia");
        map.put("fun","ArticleDetails");
        map.put("id",id);
        map.put("cateid",cateid);
        map.put("source","cdsb");
        Factory.create(1).GET(URLUtils.BASEURL,map,null,callBack);

    }
}
