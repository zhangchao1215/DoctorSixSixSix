package jiyun.com.doctorsixsixsix.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import jiyun.com.doctorsixsixsix.base.BaseBean;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: 马杰
 * 创建时间: 2017/6/9 16:54
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class GsonUtils {
    public static List<BaseBean> getList(String json){
        Gson gson=new Gson();
        List<BaseBean> base = gson.fromJson(json, new TypeToken<List<BaseBean>>() {
        }.getType());
        return base;
    }
    public static BaseBean getBean(String json,Class bean){
        Gson gson=new Gson();
        BaseBean base = (BaseBean) gson.fromJson(json, bean);
        return base;
    }
}
