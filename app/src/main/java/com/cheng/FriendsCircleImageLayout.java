package com.cheng;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cheng.channelview.R;

import java.util.List;

/**
 * Created by zhaokun on 2019/3/12.
 */

public class FriendsCircleImageLayout extends ViewGroup {
    private final int space = 20;


    public FriendsCircleImageLayout(Context context) {
        this(context, null);
    }

    public FriendsCircleImageLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FriendsCircleImageLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int count = getChildCount();
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);

        if (count == 1 || count == 4 || count == 9) {
            height = width;
        } else if (count == 2) {
            height = (width - space) / 2;
        } else if (count == 3) {
            height = (width - 2 * space) / 3 * 2 + space;
        } else if (count == 5) {
            height = (width - 2 * space) / 3 * 3 + 2 * space;
        } else if (count == 6) {
            height = (width - 2 * space) / 3 * 2 + space;
        } else if (count == 7) {
            height = width - space + 2 * space + (width - 2 * space) / 3;
        } else if (count == 8) {
            height = (width - 2 * space) / 3 * 2 + 2 * space + (width - space) / 2;
        }

        super.onMeasure(MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY), MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY));
//        final int heightMode = MeasureSpec.getMode(heightMeasureSpec);
//        if (heightMode == MeasureSpec.AT_MOST || heightMode == MeasureSpec.UNSPECIFIED) {
//            heightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);
//        }
//
//        final int widthMode = MeasureSpec.getMode(widthMeasureSpec);
//        if (widthMode == MeasureSpec.AT_MOST || widthMode == MeasureSpec.UNSPECIFIED) {
//            super.onMeasure(MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY), heightMeasureSpec);
//        } else {
//            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        }
    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
//        Log.e("11111111", getWidth() + "@" + getHeight()+"@"+getPaddingLeft());
//        Log.e("222222", getLeft() + "@" + getTop() + "@" + getRight() + "@" + getBottom());
//        Log.e("222222", l + "@" + t + "@" + r + "@" + b);
        int width = getWidth();
        int height = getHeight();
        int indexWidth=0;//当前宽
        int indexHeight=0;//当前高
        int childCount = getChildCount();
        if (childCount == 1) {
            for (int i = 0; i < childCount; i++) {
                View childView = getChildAt(i);
                childView.layout(0, 0, getWidth(), getHeight());
            }
        } else if (childCount == 2) {

            for (int i = 0; i < childCount; i++) {
                View childView = getChildAt(i);
//                Log.e("111111111",l+i*(width-space)/2+i*space+"");
//                Log.e("222222222",l+i*space+(width-space)/2*(i+1)+"");
                childView.layout(i*(width-space)/2+i*space,0,i*space+(width-space)/2*(i+1),getHeight());
            }
        }else if (childCount ==3){
            for (int i = 0; i < childCount; i++) {
                View childView = getChildAt(i);
                if (i==0){
                    childView.layout(0, 0, getHeight(), getHeight());
                }else {
                    childView.layout(getHeight()+space,0+(i-1)*(getHeight()-space)/2+(i-1)*space,getWidth(),i*(getHeight()-space)/2+(i-1)*space);
                }

            }
        }else if (childCount==4){
            for (int i = 0; i < childCount; i++) {
                View childView = getChildAt(i);
                //每个的宽高
                int currWidth=(getWidth()-space)/2;
                if (i<2){
                    //前两个
                    childView.layout(0+i%2*space+i%2*currWidth,0,currWidth+i%2*space+i%2*currWidth,currWidth);
                }else {
                    childView.layout(0+i%2*space+i%2*currWidth,currWidth+space,currWidth+i%2*space+i%2*currWidth,2*currWidth+space);
                }
            }
        }else if (childCount==5){
            for (int i = 0; i < childCount; i++) {
                View childView = getChildAt(i);
                //每个的宽高
                int currWidth=(getWidth()-space)/2;
                if (i==0){
                    childView.layout(0+i%2*space+i%2*currWidth,0,currWidth+i%2*space+i%2*currWidth,currWidth);
                }else if (i==1||i==2){
                    
                }else {
                    childView.layout(0+i%2*space+i%2*currWidth,currWidth+space,currWidth+i%2*space+i%2*currWidth,2*currWidth+space);
                }
            }

        }else if (childCount==9){
            for (int i = 0; i < childCount; i++) {
                View childView = getChildAt(i);
                //每个的宽高
                int currWidth=(getWidth()-2*space)/3;
                if (i<3){
                    //前三个
                    childView.layout(0+i%3*space+i%3*currWidth,0,currWidth+i%3*space+i%3*currWidth,currWidth);
                }else if (3<=i&&i<6){
                    childView.layout(0+i%3*space+i%3*currWidth,currWidth+space,currWidth+i%3*space+i%3*currWidth,2*currWidth+space);
                } else if (i>=6){
                    childView.layout(0+i%3*space+i%3*currWidth,2*currWidth+2*space,currWidth+i%3*space+i%3*currWidth,3*currWidth+2*space);
                }
            }
        }

    }

    @Override
    protected void measureChild(View child, int parentWidthMeasureSpec, int parentHeightMeasureSpec) {
        final LayoutParams lp = child.getLayoutParams();
        //获取子控件的宽高约束规则
        final int childWidthMeasureSpec = getChildMeasureSpec(parentWidthMeasureSpec,
                getPaddingLeft() + getPaddingRight(), lp.width);
        final int childHeightMeasureSpec = getChildMeasureSpec(parentHeightMeasureSpec,
                getPaddingLeft() + getPaddingRight(), lp.height);

        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
    }

    /**
     * 显示图片
     */
    public void setImageUrls(final List<String> imageUrls) {
        removeAllViews();
        if (imageUrls == null && imageUrls.size() == 0) {
            return;
        }

        int count = imageUrls.size();

        for (int i = 0; i < imageUrls.size(); i++) {
            ImageView imageView = new ImageView(getContext());

            imageView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPrimary));
            addView(imageView);
            //点击查看大图

        }
    }

}
