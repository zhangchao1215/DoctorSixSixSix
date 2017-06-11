package jiyun.com.doctorsixsixsix.modle.htttp.biz;

import java.util.HashMap;
import java.util.Map;

import jiyun.com.doctorsixsixsix.modle.callback.MyCallBack;
import jiyun.com.doctorsixsixsix.modle.htttp.Factory;
import jiyun.com.doctorsixsixsix.modle.urlutils.URLUtils;

/**
 * 项目名称: 血压卫士
 * 类描述:个人资料的上传
 * 创建人: 马杰
 * 创建时间: 2017/6/11 19:00
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class IDataModel implements DataModel {
    @Override
    public void upLoadData(String userid, String height, String app_id, String sex, String birthday, String keyword, String accountstr, MyCallBack callBack) {
        Map<String,String> map=new HashMap<>();
        map.put("userid",userid);
        map.put("height",height);
        map.put("app_id",app_id);
        map.put("sex",sex);
        map.put("birthday",birthday);
        map.put("keyword",keyword);
        map.put("accountstr",accountstr);
        Factory.create(Factory.OKHTTP).POST(URLUtils.DATA,map,null,callBack);
    }
}
