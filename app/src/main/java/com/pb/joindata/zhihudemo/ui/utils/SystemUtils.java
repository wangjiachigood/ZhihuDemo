package com.pb.joindata.zhihudemo.ui.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by wangjiachi on 2017/9/14.
 */

public class SystemUtils {
    /**
     * 手机的Android版本4.4以上设置沉浸式状态栏
     *
     * @param activity resId颜色为空时状态栏穿透
     */
    public static void setTranslucentStatusBar(Activity activity, int resId,
                                               boolean setPaddingTop) {
        if (activity == null) {
            return;
        }
        Window window = activity.getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            //设置状态栏颜色
            window.setStatusBarColor(ContextCompat.getColor(activity, resId));
            if (setPaddingTop) {
                ViewGroup contentView = ((ViewGroup) activity.findViewById(android.R.id.content));
                View childAt = contentView.getChildAt(0);
                if (childAt != null) {
                    childAt.setFitsSystemWindows(true);
                }
            }
        } else if (Build.VERSION.SDK_INT >= 19) {
            try {
                //透明状态栏
                window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                if (setPaddingTop) {
                    //设置contentview为fitsSystemWindows
                    ViewGroup contentView = (ViewGroup) activity.findViewById(android.R.id.content);
                    View childAt = contentView.getChildAt(0);
                    if (childAt != null) {
                        childAt.setFitsSystemWindows(true);
                    }
                    //给statusbar着色
                    View view = new View(activity);
                    view.setLayoutParams(new ViewGroup.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT, getStatusBarHeight(activity)));
                    view.setBackgroundResource(resId);
                    contentView.addView(view);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
    /**
     * 获取手机状态条的高度
     *
     * @param context
     * @return
     */
    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}
