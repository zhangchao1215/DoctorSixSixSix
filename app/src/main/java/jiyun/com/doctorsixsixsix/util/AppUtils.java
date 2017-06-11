package jiyun.com.doctorsixsixsix.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jiyun.com.doctorsixsixsix.App;

/**
 * Created by dell on 2017/6/9.
 */

public class AppUtils {
    public static String COOKIE="cookie";
    private static ProgressDialog dialog;
    private static SharedPreferences preferences=App.activity.getSharedPreferences("data", Context.MODE_PRIVATE);
    private static SharedPreferences.Editor editor=preferences.edit();

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

    public static void toast(String str){
        Toast.makeText(App.activity,str,Toast.LENGTH_SHORT).show();
    }

    public static SharedPreferences get(){
        return preferences;
    }

    public static SharedPreferences.Editor put(){
        return editor;
    }

    public static long stringToLong(String strTime, String formatType)
            throws ParseException {
        Date date = stringToDate(strTime, formatType); // String类型转成date类型
        if (date == null) {
            return 0;
        } else {
            long currentTime = dateToLong(date); // date类型转成long类型
            return currentTime;
        }
    }

    public static Date stringToDate(String strTime, String formatType)
            throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(formatType);
        Date date = null;
        date = formatter.parse(strTime);
        return date;
    }

    public static long dateToLong(Date date) {
        return date.getTime();
    }
}
