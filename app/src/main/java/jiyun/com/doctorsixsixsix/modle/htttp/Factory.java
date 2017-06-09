package jiyun.com.doctorsixsixsix.modle.htttp;

/**
 * Created by dell on 2017/6/9.
 */

public class Factory {
    public static final int OKHTTP=1;
    public static FactoryIn create(int type){
        switch (type){
            case OKHTTP:
                return OkHttpUtils.getInstance();
        }
        return null;
    }
}
