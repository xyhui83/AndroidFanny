package com.ivan.androidfanny.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Fragment的抽象基类 已实现视图注入功能，子类可以通过注解的方式获取控件和给控件添加常用事件
 */
public abstract class BaseFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getContentViewRes(), container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initDataView();
    }

    /**
     * 初始化一些Fragment需要用的数据
     */
    protected abstract void initDataView();

    /**
     * 获取Fragment根视图的资源ID
     * @return 根视图的资源ID
     */
    protected abstract int getContentViewRes();
}