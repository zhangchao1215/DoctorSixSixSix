package jiyun.com.doctorsixsixsix.view.activity.tixing.Service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: admin
 * 创建时间: 2017/6/13 17:05
 * 修改人:
 * 修改内容:
 * 修改时间:
 */
public class MyReceiver  extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        /* start another activity - MyAlarm to display the alarm */
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setClass(context, MyAlarm.class);
        context.startActivity(intent);
    }
}
