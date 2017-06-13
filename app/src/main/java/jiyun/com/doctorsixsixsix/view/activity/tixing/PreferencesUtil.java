package jiyun.com.doctorsixsixsix.view.activity.tixing;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.HashMap;
import java.util.Map;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: admin
 * 创建时间: 2017/6/12 21:13
 * 修改人:
 * 修改内容:
 * 修改时间:
 */
public class PreferencesUtil {

    private Context context;

    public PreferencesUtil(Context context) {
        this.context = context;
    }
    /**
     * 保存参数
     * @param name 药名
     * @param  number 剂量
     */
    public void save(String name, Integer number) {
        SharedPreferences preferences = context.getSharedPreferences("yaoming", Context.MODE_PRIVATE);
        Editor editor = preferences.edit();
        editor.putString("name", name);
        editor.putInt("number", number);
        editor.commit();
    }
    /**
     * 获取各项配置参数
     * @return
     */
    public Map<String, String> getPreferences(){
        Map<String, String> params = new HashMap<String, String>();
        SharedPreferences preferences = context.getSharedPreferences("yaoming", Context.MODE_PRIVATE);
        params.put("name", preferences.getString("name", ""));
        params.put("number", String.valueOf(preferences.getInt("number", 1)));
        return params;
    }
}
