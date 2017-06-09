package jiyun.com.doctorsixsixsix.util;

import android.app.ProgressDialog;

import jiyun.com.doctorsixsixsix.App;

/**
 * Created by dell on 2017/6/9.
 */

public class AppUtils {
    public static String COOKIE="cookie";
    private static ProgressDialog dialog;

    public static void dialog(){
        dialog=new ProgressDialog(App.activity);
        dialog.setMax(100);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("请求数据");
        dialog.show();
    }
    public static void dismiss(){
        dialog.dismiss();
    }
}
