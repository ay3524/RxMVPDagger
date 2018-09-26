package com.ay3524.rxmvpdagger.base;

import android.support.v4.app.Fragment;

public abstract class BaseFragment<T extends BaseActivity> extends Fragment {
    T parentActivity;
    BaseFragment<T> parentFragment;

    public BaseFragment() {
        //Required empty public constructor
    }

    public abstract String createTag();

    public T getParentActivity() {
        return parentActivity;
    }

    public void attachParent(T parentActivity) {
        this.parentActivity = parentActivity;
    }

    public BaseFragment<T> getParent() {
        return parentFragment;
    }

    public void attachParentFragment(BaseFragment<T> parentFragment) {
        this.parentFragment = parentFragment;
    }

}
