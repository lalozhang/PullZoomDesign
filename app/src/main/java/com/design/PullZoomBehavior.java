package com.design;

import android.support.design.widget.CoordinatorLayout;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by lalo.zhang on 2016/11/27.
 */
public class PullZoomBehavior extends CoordinatorLayout.Behavior {


    @Override
    public boolean onInterceptTouchEvent(CoordinatorLayout parent, View child, MotionEvent ev) {
        return super.onInterceptTouchEvent(parent, child, ev);
    }


    @Override
    public boolean onTouchEvent(CoordinatorLayout parent, View child, MotionEvent ev) {
        return super.onTouchEvent(parent, child, ev);
    }
}
