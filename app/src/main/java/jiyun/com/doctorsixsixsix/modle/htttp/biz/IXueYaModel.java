package jiyun.com.doctorsixsixsix.modle.htttp.biz;

import java.util.HashMap;
import java.util.Map;

import jiyun.com.doctorsixsixsix.modle.bean.XueYa;
import jiyun.com.doctorsixsixsix.modle.callback.MyCallBack;
import jiyun.com.doctorsixsixsix.modle.htttp.Factory;
import jiyun.com.doctorsixsixsix.modle.urlutils.URLUtils;

import static android.os.Build.VERSION_CODES.M;

/**
 * 项目名称: 血压卫士
 * 类描述: 血压资料上传
 * 创建人: 马杰
 * 创建时间: 2017/6/14 11:41
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class IXueYaModel implements XueYaModel {
    @Override
    public void uploadXueYa(String xywy_userid, String data,String datatime,String sn,MyCallBack callBack) {
        Map<String,String> map=new HashMap<>();
        map.put("app_username","xywy_tizhong");
        map.put("sn",sn);
        map.put("sort","xueya");
        map.put("xywy_userid",xywy_userid);
        map.put("datatime",datatime);
        map.put("data",data);
        Factory.create(Factory.OKHTTP).POST(URLUtils.XUEYA,map,null,callBack);
    }
}
