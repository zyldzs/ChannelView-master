package com.cheng;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.cheng.channelview.R;

import java.util.List;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * Created by zhaokun on 2019/3/12.
 */

public class FriendsCircleImageLayout extends ViewGroup {
    private final int space = 20;
    //当只有一张图片的宽高
    private int imageHeight;
    private int imageWidth;
    private RequestOptions mRequestOptions1;


    public FriendsCircleImageLayout(Context context) {
        this(context, null);
    }

    public FriendsCircleImageLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FriendsCircleImageLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mRequestOptions1 = RequestOptions.bitmapTransform(
                new MultiTransformation(new RoundedCornersTransformation(32, 0, RoundedCornersTransformation.CornerType.ALL))).diskCacheStrategy(DiskCacheStrategy.ALL);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int count = getChildCount();
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);

        if (count == 1 ) {
            double size = (double) imageWidth / imageHeight;
            if (size >= (double) 16 / 9) {//1.777
                height =width * 9 / 16;
            } else if (size >= 1 && size < (double) 16 / 9) {
               height = (int) (width / size);
            } else if (size > (double) 9 / 16 && size < 1) {//0.5625
                height = (int)(width / size);
            } else if (size <= (double) 9 / 16) {
                height = width * 16 / 9;
            }
        } else if(count == 4 || count == 9){
            height = width;
        }else if (count == 2) {
            height = (width - space) / 2;
        } else if (count == 3) {
            height = (width - 2 * space) / 3 * 2 + space;
        } else if (count == 5) {
            height = (width - space) / 2 + space +(width - 2*space) / 3;
        } else if (count == 6) {
            height = width;
        } else if (count == 7) {
            height = width - space + 2 * space + (width - 2 * space) / 3;
        } else if (count == 8) {
            height = (width - 2 * space) / 3 * 2 + 2 * space + (width - space) / 2;
        }

        super.onMeasure(MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY), MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY));

    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
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
            //每个大的宽高
            int mincurrWidth=(getWidth()-space)/2;
            //每个小的的宽高
            int maxcurrWidth=(getWidth()-2*space)/3;
            for (int i = 0; i < childCount; i++) {
                View childView = getChildAt(i);

                if (i<2){
                    //前两个
                    childView.layout(0+i%2*space+i%2*mincurrWidth,0,mincurrWidth+i%2*space+i%2*mincurrWidth,mincurrWidth);
                }else {
                    childView.layout(0+i%3*space+i%3*maxcurrWidth,mincurrWidth+space,0+i%3*space+(i%3+1)*maxcurrWidth,getHeight());
                }

            }
        }else if (childCount==6){
            int currWidth=(getWidth()-2*space)/3;
            for (int i = 0; i < childCount; i++) {
                View childView = getChildAt(i);
                //每个小的的宽高
                if (i==0){
                    childView.layout(0,0,getWidth()-space-currWidth,getWidth()-space-currWidth);
                }else if (i==1||i==2){
                    childView.layout(getWidth()-currWidth,0+(i-1)*space+(i-1)*currWidth,getWidth(),0+(i-1)*space+i*currWidth);
                } else {
                    childView.layout(0+i%3*space+i%3*currWidth,2*(currWidth+space),0+i%3*space+(i%3+1)*currWidth,getHeight());
                }
            }

        }else if (childCount==7) {
            //每个大的宽高
            int maxcurrWidth=(getWidth()-space)/2;
            //每个小的的宽高
            int mincurrWidth=(getWidth()-2*space)/3;

            for (int i = 0; i < childCount; i++) {
                View childView = getChildAt(i);
                if (i<2){
                    childView.layout(0+i%2*space+i%2*maxcurrWidth,0,maxcurrWidth+i%2*space+i%2*maxcurrWidth,maxcurrWidth);
                }else if (i>=2&&i<4){
                    childView.layout(0+i%2*space+i%2*maxcurrWidth,maxcurrWidth+space,maxcurrWidth+i%2*space+i%2*maxcurrWidth,2*maxcurrWidth+space);
                }else {
                    childView.layout(0+i%3*space+i%3*mincurrWidth,2*(maxcurrWidth+space),0+i%3*space+(i%3+1)*mincurrWidth,getHeight());
                }
            }
        }else if (childCount==8) {
            //每个大的宽高
            int maxcurrWidth=(getWidth()-space)/2;
            //每个小的的宽高
            int mincurrWidth=(getWidth()-2*space)/3;

            for (int i = 0; i < childCount; i++) {
                View childView = getChildAt(i);
                if (i<2){
                    childView.layout(0+i%2*space+i%2*maxcurrWidth,0,maxcurrWidth+i%2*space+i%2*maxcurrWidth,maxcurrWidth);
                }else if (i>=2&&i<5){
                    childView.layout(0+i%3*space+i%3*mincurrWidth,maxcurrWidth+space,0+i%3*space+(i%3+1)*mincurrWidth,maxcurrWidth+mincurrWidth+space);
                }else {
                    childView.layout(0+i%3*space+i%3*mincurrWidth,maxcurrWidth+mincurrWidth+2*space,0+i%3*space+(i%3+1)*mincurrWidth,getHeight());
                }
            }
        } else if (childCount==9){
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
    public void setImageUrls(final List<String> imageUrls,int imageHeight,int imageWidth) {
        this.imageHeight=imageHeight;
        this.imageWidth=imageWidth;
        removeAllViews();
        if (imageUrls == null && imageUrls.size() == 0) {
            return;
        }

        for (int i = 0; i < imageUrls.size(); i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            Glide.with(getContext())
                    .load(imageUrls.get(i))
                    .apply(mRequestOptions1)
                    .into(imageView);
            addView(imageView);
            //点击查看大图
        }

    }

}
