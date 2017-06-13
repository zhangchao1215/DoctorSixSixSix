package jiyun.com.doctorsixsixsix.view.activity.tixing.Service;

import android.app.Notification;
import android.app.NotificationManager;
import android.net.Uri;
import android.provider.MediaStore.Audio;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.base.BaseActivity;

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

    private Button mBtn;
    private TextView tv;

    public static final int NOTIFICATION_ID = 1;
    @BindView(R.id.guanbi)
    Button guanbi;

    @Override
    protected int getLayoutId() {
        return R.layout.my_alarm;
    }

    @Override
    protected void initView() {
        mBtn = (Button) findViewById(R.id.guanbi);
        tv = (TextView) findViewById(R.id.tongzhi);

        tv.setText("Hello, 该吃药了...");
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {



    }


    @OnClick(R.id.guanbi)
    public void onViewClicked(View v) {
        switch (v.getId()){
            case R.id.guanbi:
                // create the instance of NotificationManager
                final NotificationManager nm=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                // create the instance of Notification
                Notification n=new Notification();
        /* set the sound of the alarm. There are two way of setting the sound */
                // n.sound=Uri.parse("file:///sdcard/alarm.mp3");
                n.sound= Uri.withAppendedPath(Audio.Media.INTERNAL_CONTENT_URI, "20");
                // Post a notification to be shown in the status bar
                nm.notify(NOTIFICATION_ID, n);


                nm.cancel(NOTIFICATION_ID);
                finish();
        }
    }
}
