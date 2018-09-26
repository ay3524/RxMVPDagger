package com.ay3524.rxmvpdagger.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.ay3524.rxmvpdagger.utils.FragmentTransactionManager;

public class BaseActivity extends AppCompatActivity {
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFragmentManager = getSupportFragmentManager ();
    }

    @Override public void onBackPressed () {
        Fragment currentFragment = FragmentTransactionManager.getCurrentFragment(mFragmentManager);
        //TODO you can add a home fragment...
//        if (currentFragment instanceof HomeFragment ) {
//            return;
//        }
        if (currentFragment instanceof IBackPressInterceptor) {
            ((IBackPressInterceptor) currentFragment).onBackPressed(new IBackPressInterceptor.BackCallback() {
                @Override
                public void backCompleted() {
                    mFragmentManager.popBackStackImmediate();
                }
            });
        } else {
            super.onBackPressed();
        }
    }
}
