package com.ivan.androidfanny;

import android.content.Intent;
import android.widget.TextView;

import com.ivan.androidfanny.base.BaseActivity;
import com.ivan.androidfanny.ui.DbActivity;

import butterknife.Bind;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Bind(R.id.tv_main)
    TextView tvMain;

    @Override
    protected void initDataAndView() {
    }

    @Override
    protected int getContentViewRes() {
        return R.layout.activity_main;
    }

    @OnClick(R.id.btn_main)
    void test() {
        tvMain.setText(R.string.app_test);
    }

    @OnClick(R.id.btn_db_test)
    void db() {
        startActivity(new Intent(this, DbActivity.class));
    }
}
