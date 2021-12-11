package com.google.android.material.bottomsheet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.NestedScrollingChild;
import androidx.viewpager.widget.ViewPager;

import java.lang.ref.WeakReference;

public class ViewPagerBottomSheetBehavior<V extends View> extends BottomSheetBehavior<V> {

    public ViewPagerBottomSheetBehavior() {
    }

    public ViewPagerBottomSheetBehavior(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @NonNull
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static <V extends View> ViewPagerBottomSheetBehavior<V> from(V view) {
        ViewGroup.LayoutParams params = view.getLayoutParams();
        if (!(params instanceof CoordinatorLayout.LayoutParams)) {
            throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
        }
        CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) params).getBehavior();
        if (!(behavior instanceof ViewPagerBottomSheetBehavior)) {
            throw new IllegalArgumentException(
                    "The view is not associated with ViewPagerBottomSheetBehavior");
        }
        return (ViewPagerBottomSheetBehavior<V>) behavior;
    }

    void invalidateScrollingChild() {
        final View scrollingChild;
        if (viewRef != null) {
            scrollingChild = findScrollingChild(viewRef.get());
            nestedScrollingChildRef = new WeakReference<>(scrollingChild);
        }
    }

    @Override
    View findScrollingChild(View view) {
        if (view instanceof NestedScrollingChild) {
            return view;
        }
        if (view instanceof ViewPager) {
            ViewPager viewPager = (ViewPager) view;
            View currentViewPagerChild = ViewPagerUtils.getCurrentView(viewPager);
            return findScrollingChild(currentViewPagerChild);
        } else if (view instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) view;
            for (int i = 0, count = group.getChildCount(); i < count; i++) {
                View scrollingChild = findScrollingChild(group.getChildAt(i));
                if (scrollingChild != null) {
                    return scrollingChild;
                }
            }
        }
        return null;
    }
}
