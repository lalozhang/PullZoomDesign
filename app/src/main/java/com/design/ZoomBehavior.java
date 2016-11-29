package com.design;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by admin on 2016/11/28.
 */
public class ZoomBehavior extends CoordinatorLayout.Behavior {


    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof AppBarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        ((AppBarLayout)dependency).addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

            }
        });
        return super.onDependentViewChanged(parent, child, dependency);
    }

    @Override
    public boolean onTouchEvent(CoordinatorLayout parent, View child, MotionEvent ev) {
        return super.onTouchEvent(parent, child, ev);
    }
}
