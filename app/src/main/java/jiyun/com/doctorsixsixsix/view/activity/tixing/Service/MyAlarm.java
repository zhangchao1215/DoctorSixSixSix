package jiyun.com.doctorsixsixsix.view.activity.tixing.Service;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.Audio;
import android.support.v7.widget.AlertDialogLayout;
import android.view.View;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jiyun.com.doctorsixsixsix.App;
import jiyun.com.doctorsixsixsix.Dao.TimeDao;
import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.base.BaseActivity;
import jiyun.com.doctorsixsixsix.modle.bean.Time;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: admin
 * 创建时间: 2017/6/13 17:06
 * 修改人:
 * 修改内容:
 * 修改时间:
 */
public class MyAlarm extends BaseActivity {

    public static final int NOTIFICATION_ID = 1;

    @BindView(R.id.mydialog)
    AlertDialogLayout mydialog;

    private List<Time> lists;
    private String mTime;

    @Override
    protected int getLayoutId() {
        return R.layout.my_alarm;
    }

    @Override
    protected void initView() {
        mydialog = (AlertDialogLayout) findViewById(R.id.mydialog);

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

        TimeDao dbDao = App.getDaoInstant().getTimeDao();
        lists = dbDao.loadAll();
        new AlertDialog.Builder(MyAlarm.this).setIcon(R.drawable.ic_launcher)
                .setTitle("该吃药了").setMessage("时间到了，当前时间为:" + new SimpleDateFormat("HH:mm").format(new Date()))
                .setPositiveButton("关闭", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        MyAlarm.this.finish();
                    }
                }).show();


    }


    @OnClick(R.id.mydialog)
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.mydialog:
                // create the instance of NotificationManager
                final NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                // create the instance of Notification
                Notification n = new Notification();
                /* set the sound of the alarm. There are two way of setting the sound */
                // n.sound=Uri.parse("file:///sdcard/alarm.mp3");
                n.sound = Uri.withAppendedPath(Audio.Media.INTERNAL_CONTENT_URI, "20");
                // Post a notification to be shown in the status bar
                nm.notify(NOTIFICATION_ID, n);

                nm.cancel(NOTIFICATION_ID);
                finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
