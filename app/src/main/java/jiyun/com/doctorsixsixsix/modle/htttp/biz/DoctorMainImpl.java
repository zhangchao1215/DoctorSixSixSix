package jiyun.com.doctorsixsixsix.modle.htttp.biz;

import java.util.HashMap;
import java.util.Map;

import jiyun.com.doctorsixsixsix.modle.callback.MyCallBack;
import jiyun.com.doctorsixsixsix.modle.htttp.Factory;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/9 23:28
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class DoctorMainImpl implements IDoctorModel {


    @Override
    public void getMainDoctor(int Index, MyCallBack callBack) {
        Map<String, String> params = new HashMap<>();
        params.put("tag", "BloodAndroid");
        params.put("sign", "2c19b2821ebc5306c3ac37bac5b4288b");
        params.put("act", "zhuanjia");
        params.put("fun", "HotDoctor");
        params.put("pageNum", String.valueOf(Index));
        params.put("pageCount", "4");
        Factory.create(1).GET("http://api.wws.xywy.com/index.php", params, "", callBack);

    }
}
