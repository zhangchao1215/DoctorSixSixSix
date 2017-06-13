package jiyun.com.doctorsixsixsix.view.activity.tixing.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.ResultSet;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: admin
 * 创建时间: 2017/6/13 8:16
 * 修改人:
 * 修改内容:
 * 修改时间:
 */
public class MyHepler extends SQLiteOpenHelper {


    public MyHepler(Context context) {
        super(context, "news.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table xueya(name varchar(30) primary key)";
        db.execSQL(sql);
        String sqlce = "create table celiang(date varchar(30),time varchar(30),name varchar(30),gaoya varchar(30),diya varchar(30))";
        db.execSQL(sqlce);
        String ssq = "create table news(data_time varchar(30),name varchar(30),number varchar(30))";
        db.execSQL(ssq);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }


    public static ResultSet getResultSet(String sql) {
        return null;
    }
}
