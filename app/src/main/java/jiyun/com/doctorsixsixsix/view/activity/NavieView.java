package jiyun.com.doctorsixsixsix.view.activity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/9 15:44
 * 修改人:  张超
 * 修改内: 自定义view 实现字母导航的效果
 * 修改时间:
 */

public class NavieView extends View {
    private Paint textPaint = new Paint();
    private String[] s = new String[]{"A", "B", "C", "D", "E", "F", "G",
            "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z", "#"};
    //鼠标点击、滑动时选择的字母
    private int choose = -1;


    public NavieView(Context context) {
        super(context);
    }

    public NavieView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public NavieView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    private void initPaint() {
        textPaint.setTextSize(20);
        textPaint.setAntiAlias(true);
        textPaint.setColor(Color.BLACK);
    }

    //画字母
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawtext(canvas);
    }

    private void drawtext(Canvas canvas) {
        //获取View的宽高
        int width = getWidth();
        int height = getHeight();
        //获取每个字母的高度
        int singleHeight = height / s.length;
        //画字母
        for (int i = 0; i < s.length; i++) {
            //画笔默认颜色
            initPaint();
            //高亮字母颜色
            if (choose == i) {
                textPaint.setColor(Color.RED);
            }
            //计算每个字母的坐标
            float x = (width - textPaint.measureText(s[i])) / 2;
            float y = (i + 1) * singleHeight;
            canvas.drawText(s[i], x, y, textPaint);
            //重置颜色
            textPaint.reset();
        }

    }

}

