package jiyun.com.doctorsixsixsix.view.activity.tixing;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.NumberPicker.Formatter;
import android.widget.NumberPicker.OnScrollListener;
import android.widget.NumberPicker.OnValueChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.OnClick;
import jiyun.com.doctorsixsixsix.Dao.DaoMaster;
import jiyun.com.doctorsixsixsix.Dao.DaoSession;
import jiyun.com.doctorsixsixsix.Dao.TimeDao;
import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.base.BaseActivity;
import jiyun.com.doctorsixsixsix.modle.bean.Time;
import jiyun.com.doctorsixsixsix.util.AppUtils;
import jiyun.com.doctorsixsixsix.view.activity.tixing.Service.MyReceiver;

import static android.content.Context.ALARM_SERVICE;
import static java.lang.System.currentTimeMillis;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: admin
 * 创建时间: 2017/6/12 10:40
 * 修改人:
 * 修改内容:
 * 修改时间:
 */
public class AddRemindActivity extends BaseActivity implements OnValueChangeListener, Formatter, OnScrollListener{
    @BindView(R.id.addremind_back)
    ImageView addremindBack;
    @BindView(R.id.remind_Title)
    TextView remindTitle;
    @BindView(R.id.remind_add)
    TextView remindAdd;
    @BindView(R.id.addremind_relative)
    RelativeLayout addremindRelative;
    @BindView(R.id.fysj)
    TextView fysj;
    @BindView(R.id.show_num_picker1)
    NumberPicker showNumPicker1;
    @BindView(R.id.show_num_picker2)
    NumberPicker showNumPicker2;
    @BindView(R.id.txxq)
    TextView txxq;
    @BindView(R.id.yymc)
    TextView yymc;
    @BindView(R.id.yaopin_name)
    EditText yaopinName;
    @BindView(R.id.fyjl)
    TextView fyjl;
    @BindView(R.id.yaopin_number)
    EditText yaopinNumber;
    private NumberPicker mNumberPicker1;
    private NumberPicker mNumberPicker2;
    private int time;
    private Calendar mDate;
    private int mHour, mMinute,hourone,minute;
    private PreferencesUtil service;
    private SharedPreferences sharedPreferences;
    private TimeDao timeDao;
    private boolean reminder;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_addremind;
    }

    @Override
    protected void initView() {

        yaopinName = (EditText) findViewById(R.id.yaopin_name);
        yaopinNumber = (EditText) findViewById(R.id.yaopin_number);


        mNumberPicker1 = (NumberPicker) findViewById(R.id.show_num_picker1);
        mNumberPicker2 = (NumberPicker) findViewById(R.id.show_num_picker2);

        mNumberPicker1.setFormatter(this);
        mNumberPicker1.setMaxValue(23);
        mNumberPicker1.setMinValue(0);
        Calendar calendar = Calendar.getInstance();
        int currHour= calendar.get(Calendar.HOUR_OF_DAY)  ;
        mNumberPicker1.setValue(currHour);


        mNumberPicker2.setFormatter(this);
        mNumberPicker2.setMaxValue(59);
        mNumberPicker2.setMinValue(0);
        int currmin=calendar.get(Calendar.MINUTE);
        mNumberPicker2.setValue(currmin);
    }


    @Override
    protected void initListener() {
        mNumberPicker1.setOnValueChangedListener(new OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

                mHour = newVal;
                setTitle(mHour + ":" + mMinute);


            }
        });
        mNumberPicker2.setOnValueChangedListener(new OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

                mMinute = newVal;
                setTitle(mHour + ":" + mMinute);

            }
        });
    }

    @Override
    protected void initData() {

        long l = currentTimeMillis();
        String s = AppUtils.longToString(l, "hh:mm");

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "news.db", null);
        SQLiteDatabase database = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(database);
        DaoSession daoSession = daoMaster.newSession();
         timeDao = daoSession.getTimeDao();


    }


    @OnClick({R.id.addremind_back, R.id.remind_add, R.id.show_num_picker1, R.id.show_num_picker2, R.id.yaopin_name, R.id.yaopin_number})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.addremind_back:
                onBackPressed();
                break;
            case R.id.remind_add:

                String name = yaopinName.getText().toString().trim();
                String number = yaopinNumber.getText().toString().trim();
//                String tim = new SimpleDateFormat("hh:ss").format(new Date(currentTimeMillis()));

                Time time = new Time();
                time.setName(name);
                time.setData_time(mHour + ":" + mMinute);
                time.setNumber(Integer.parseInt(number));
                long insertRow = timeDao.insert(time);
                Toast.makeText(this, "添加了" + insertRow + "条提醒", Toast.LENGTH_LONG).show();
                onBackPressed();
                //设置提醒
                setReminder(true);

                break;
            case R.id.show_num_picker1:
                break;
            case R.id.show_num_picker2:
                break;
            case R.id.yaopin_name:
                break;
            case R.id.yaopin_number:
                break;
        }
    }



    public String format(int value) {
        String tmpStr = String.valueOf(value);
        if (value < 10) {
            tmpStr = "0" + tmpStr;
        }
        return tmpStr;
    }

    @Override
    public void onScrollStateChange(NumberPicker view, int scrollState) {
        switch (scrollState) {
            case OnScrollListener.SCROLL_STATE_FLING:

                break;
            case OnScrollListener.SCROLL_STATE_IDLE:

            case OnScrollListener.SCROLL_STATE_TOUCH_SCROLL:

                break;
        }
    }

    @Override
    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

    }

    public void setReminder(boolean b) {
        // get the AlarmManager instance
        AlarmManager am= (AlarmManager) getSystemService(ALARM_SERVICE);

        //Intent一般是用作Activity、Sercvice、BroadcastReceiver之间传递数据，而Pendingintent，一般用在 Notification上，
        // 可以理解为延迟执行的intent，PendingIntent是对Intent一个包装。
        PendingIntent pi= PendingIntent.getBroadcast(AddRemindActivity.this, 0, new Intent(this,MyReceiver.class), 0);

        if(b){
            // just use current time as the Alarm time.
            Calendar c=Calendar.getInstance();
            // schedule an alarm
            am.set(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pi);
        }
        else{
            // cancel current alarm
            am.cancel(pi);
        }

    }
}

