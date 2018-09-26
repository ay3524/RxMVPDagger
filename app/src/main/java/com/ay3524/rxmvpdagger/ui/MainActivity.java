package com.ay3524.rxmvpdagger.ui;

import android.os.Bundle;

import com.ay3524.rxmvpdagger.R;
import com.ay3524.rxmvpdagger.base.BaseActivity;
import com.ay3524.rxmvpdagger.ui.home.HomeFragment;
import com.ay3524.rxmvpdagger.utils.FragmentTransactionUtil;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        launchHome();
    }

    private void launchHome() {
        FragmentTransactionUtil.doContentFragmentTransactionUsingAdd(
                getSupportFragmentManager(),
                HomeFragment.newInstance(),
                false,
                R.id.container
        );
    }
}
