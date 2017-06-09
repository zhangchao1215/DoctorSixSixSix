package jiyun.com.doctorsixsixsix.modle.htttp.biz;

import java.util.HashMap;
import java.util.Map;

import jiyun.com.doctorsixsixsix.modle.callback.MyCallBack;
import jiyun.com.doctorsixsixsix.modle.htttp.Factory;
import jiyun.com.doctorsixsixsix.modle.urlutils.URLUtils;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/6/9 20:42
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class ILoginModel implements LoginModel {
    @Override
    public void login(String password, String phonenum, MyCallBack callBack) {
        Map<String,String> map=new HashMap<>();
        map.put("password",password);
        map.put("phonenum",phonenum);
        Factory.create(Factory.OKHTTP).POST(URLUtils.LOGIN,map,"",callBack);
    }
}
