//package jiyun.com.doctorsixsixsix.view.activity.mftw;
//
//import android.app.DatePickerDialog;
//import android.app.TimePickerDialog;
//import android.widget.DatePicker;
//import android.widget.TimePicker;
//
//import java.text.DateFormat;
//import java.util.Calendar;
//import java.util.Locale;
//
//import jiyun.com.doctorsixsixsix.base.BaseActivity;
//
///**
// * 项目名称: 血压卫士
// * 类描述:
// * 创建人: admin
// * 创建时间: 2017/6/12 16:14
// * 修改人:
// * 修改内容:
// * 修改时间:
// */
//public class DataPickerActivity extends BaseActivity {
//
//    DateFormat fmtDate = new java.text.SimpleDateFormat("yyyy-MM-dd");
//
//    DateFormat fmtTime = new java.text.SimpleDateFormat("HH:mm:ss");
//
//    //获取一个日历对象
//    Calendar dateAndTime = Calendar.getInstance(Locale.CHINA);
//    @Override
//    protected int getLayoutId() {
//        return 0;
//    }
//
//    @Override
//    protected void initView() {
//
//    }
//
//    @Override
//    protected void initListener() {
//
//    }
//
//    @Override
//    protected void initData() {
//
//    }
//
//    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener()
//    {
//        @Override
//        public void onDateSet(DatePicker view, int year, int monthOfYear,
//                              int dayOfMonth) {
//            修改日历控件的年，月，日
//            这里的year,monthOfYear,dayOfMonth的值与DatePickerDialog控件设置的最新值一致
//            dateAndTime.set(Calendar.YEAR, year);
//            dateAndTime.set(Calendar.MONTH, monthOfYear);
//            dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
//            将页面TextView的显示更新为最新时间
//            upDateDate();
//
//        }
//    };
//
//    TimePickerDialog.OnTimeSetListener t = new TimePickerDialog.OnTimeSetListener() {
//
//        同DatePickerDialog控件
//        @Override
//        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
//            dateAndTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
//            dateAndTime.set(Calendar.MINUTE, minute);
//            upDateTime();
//
//        }
//    };
//    private void upDateDate() {
//        txtDate.setText(fmtDate.format(dateAndTime.getTime()));
//    }
//
//    private void upDateTime() {
//        txtTime.setText(fmtTime.format(dateAndTime.getTime()));
//    }
//
//}
