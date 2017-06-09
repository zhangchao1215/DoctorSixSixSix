package jiyun.com.doctorsixsixsix.modle.htttp.biz;

import java.util.HashMap;
import java.util.Map;

import jiyun.com.doctorsixsixsix.modle.callback.MyCallBack;
import jiyun.com.doctorsixsixsix.modle.htttp.Factory;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/6/9 16:43
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class IPersonlModel implements PersonlModel {
    @Override
    public void upLoadImage( String path, String cookie, MyCallBack callBack) {
        Map<String,String> map=new HashMap<>();
        map.put("path",path);
        Factory.create(Factory.OKHTTP).POST("",map,cookie,callBack);
    }
}
