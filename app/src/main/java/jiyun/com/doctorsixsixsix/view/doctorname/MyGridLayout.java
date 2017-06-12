package jiyun.com.doctorsixsixsix.view.doctorname;

import android.animation.LayoutTransition;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.view.Gravity;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.List;

import jiyun.com.doctorsixsixsix.R;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: admin
 * 创建时间: 2017/6/10 11:41
 * 修改人:
 * 修改内容:
 * 修改时间:
 */
public class MyGridLayout extends GridLayout {

    // 被拖拽的View
    private View mDragedView;

    // 在XML里面声明该控件的style属性的时候调用
    public MyGridLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    // 在XML里面声明该控件的时候调用
    public MyGridLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    // 在代码里面new对象的时候调用
    public MyGridLayout(Context context) {
        this(context, null);
    }

    // 初始化当前GridLayout的条目个数和 条目动画
    private void init() {
        setColumnCount(3);
        setLayoutTransition(new LayoutTransition());
    }

    // 向外界提供的设置添加GridLayout条目的方法
    public void setItems(List<String> list) {
        for (String strItem : list) {
            addItem(strItem);
        }
    }

    private int mMargin = 5;
    private boolean mDragAble;

    // 向GridLayout里面添加条目
    private void addItem(String strItem) {
        TextView tv = new TextView(getContext());
        GridLayout.LayoutParams lp = new GridLayout.LayoutParams();
        lp.width = getResources().getDisplayMetrics().widthPixels / 4 - mMargin
                * 2;
        lp.height = GridLayout.LayoutParams.WRAP_CONTENT;
        lp.setMargins(mMargin, mMargin, mMargin, mMargin);

        tv.setLayoutParams(lp);
        tv.setGravity(Gravity.CENTER);
        tv.setPadding(mMargin, mMargin, mMargin, mMargin);
        tv.setText(strItem);
        tv.setBackgroundResource(R.drawable.tv_item_select);
        MyGridLayout.this.addView(tv);

        // 可以拖拽
        if (mDragAble) {
            tv.setOnLongClickListener(ocl);
            // 不能拖拽
        } else {
            tv.setOnLongClickListener(null);
        }

    }

    // TextView(MyGridLayout的条目)的长按事件
    private OnLongClickListener ocl = new OnLongClickListener() {

        @Override
        public boolean onLongClick(View v) {
            mDragedView = v;
            v.startDrag(null, new DragShadowBuilder(v), null, 0);
            v.setEnabled(false);
            return false;
        }
    };

    // 向外界提供是否能拖拽的方法
    public void setDragAble(boolean isDrage) {
        this.mDragAble = isDrage;
        if (mDragAble) {
            // 监听拖拽事件
            this.setOnDragListener(odl);
        } else {
            // 不监听拖拽事件
            this.setOnDragListener(null);
        }
    }

    // 拖拽监听器
    private OnDragListener odl = new OnDragListener() {

        @Override
        public boolean onDrag(View arg0, DragEvent event) {

            switch (event.getAction()) {
                // 开始拖拽
                case DragEvent.ACTION_DRAG_STARTED:
                    initRect();
                    break;

                // 实时监听拖拽事件
                case DragEvent.ACTION_DRAG_LOCATION:
                    int index = getIntouchIndex(event);
                    if (index > -1 && mDragedView != null
                            && mDragedView != getChildAt(index)) {
                        removeView(mDragedView);
                        addView(mDragedView, index);
                    }
                    break;

                // 停止拖拽
                case DragEvent.ACTION_DRAG_ENDED:
                    if (mDragedView != null) {
                        mDragedView.setEnabled(true);
                    }

                    break;
            }
            return true;
        }

    };

    private Rect[] mRectArr;

    // 将所有的条目都封装成矩形然后存入数组
    private void initRect() {
        int childViewCount = getChildCount();
        mRectArr = new Rect[childViewCount];
        for (int i = 0; i < childViewCount; i++) {
            View childView = getChildAt(i);
            Rect rect = new Rect(childView.getLeft(), childView.getTop(),
                    childView.getRight(), childView.getBottom());
            mRectArr[i] = rect;
        }

    }

    // 实时监听拖拽的点是否进入到了某一个子控件范围内
    private int getIntouchIndex(DragEvent event) {
        for (int i = 0; i < mRectArr.length; i++) {
            if (mRectArr[i].contains((int) event.getX(), (int) event.getY())) {
                return i;
            }
        }
        return -1;
    }
}
