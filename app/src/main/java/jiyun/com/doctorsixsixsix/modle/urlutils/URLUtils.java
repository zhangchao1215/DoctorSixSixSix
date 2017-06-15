package jiyun.com.doctorsixsixsix.modle.urlutils;

/**
 * Created by Administrator on 2017/6/8.
 */

public class URLUtils {
    public static final String PAGEINDEX = "1";
    public static final String PAGESIZE = "20";

    //GET
    public static final String BASEURL = "http://api.wws.xywy.com/index.php";
    //POST
    public static final String IMAGE="http://api.wws.xywy.com/upload_avatar.php";
    //POST
    public static final String LOGIN="http://api.wws.xywy.com/index.php?&tag=BloodAndroid&sign=2c19b2821ebc5306c3ac37bac5b4288b&act=kbb&fun=users&type=login";
    //GET
    public static final String USERS="http://api.wws.xywy.com/index.php";
    //POST
    public static final String PWDMODIFY="http://api.wws.xywy.com/index.php?act=kbb&fun=resetProperty&tag=BloodAndroid&sign=2c19b2821ebc5306c3ac37bac5b4288b";
    //POST
    public static final String DATA="http://api.wws.xywy.com/index.php?act=kbb&fun=resetProperty&tag=BloodAndroid&sign=2c19b2821ebc5306c3ac37bac5b4288b";
    //POST
    public static final String COLLECTION="http://api.yun.xywy.com/index.php/app/collect/list_data/111";
    //POST
    public static final String COLLECT="http://api.yun.xywy.com/index.php/app/collect/post/";
    //POST
    public static final String ISCOLLECT="http://api.yun.xywy.com/index.php/app/collect/is_collected/";
    //GET
    public static final String XUEYA="http://api.yun.xywy.com/index.php/api/setdata/data_all/";
    //POST
    public static final String FANKUI="http://api.wws.xywy.com/index.php?&tag=BloodAndroid&sign=2c19b2821ebc5306c3ac37bac5b4288b&act=kbb&fun=user_feedback";
}
