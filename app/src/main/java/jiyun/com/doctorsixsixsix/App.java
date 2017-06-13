package jiyun.com.doctorsixsixsix;

import android.app.Activity;
import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import jiyun.com.doctorsixsixsix.Dao.DaoMaster;
import jiyun.com.doctorsixsixsix.Dao.DaoSession;
import jiyun.com.doctorsixsixsix.base.BaseActivity;

/**
 * Created by dell on 2017/6/9.
 */

public class App extends Application {
    public static BaseActivity activity;
    private static DaoSession daoSession;
    @Override
    public void onCreate() {
        super.onCreate();
        setupDatabase();
    }
    private void setupDatabase(){
        //创建数据库News.db
        DaoMaster.DevOpenHelper helper=new DaoMaster.DevOpenHelper(this,"news.db",null);
        //获取数据库操作.权限
        SQLiteDatabase db = helper.getWritableDatabase();
        //获取数据库对象
        DaoMaster daoMaster = new DaoMaster(db);
        //获取Dao对象管理者
        daoSession = daoMaster.newSession();
    }
    public static DaoSession getDaoInstant() {
        return daoSession;
    }
}
