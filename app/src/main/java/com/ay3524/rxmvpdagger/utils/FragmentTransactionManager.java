package com.ay3524.rxmvpdagger.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.ay3524.rxmvpdagger.R;
import com.ay3524.rxmvpdagger.base.BaseFragment;

public class FragmentTransactionManager {

    private static int animationIn = R.anim.fragment_in;
    private static int animationOut = R.anim.fragment_out;

    public static void setTransitionAnimations(int animationIn, int animationOut) {
        if (animationIn != -1) {
            FragmentTransactionManager.animationIn = animationIn;
        }
        if (animationOut != -1) {
            FragmentTransactionManager.animationOut = animationOut;
        }
    }

    public static synchronized void doContentFragmentTransactionUsingAdd(FragmentManager mFragmentManager, BaseFragment fragment, boolean popStack, int container) {
        if (!mFragmentManager.isDestroyed()) {
            if (popStack) {
                mFragmentManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            }
            FragmentTransaction ft = mFragmentManager.beginTransaction();

            ft.add(container, fragment, fragment.createTag());

            //Pop the stack completely till the current fragment thats being inserted.
            ft.addToBackStack(fragment.createTag());
            ft.commitAllowingStateLoss();
            mFragmentManager.executePendingTransactions();
        }
    }

    public static synchronized void doContentFragmentTransactionUsingReplace(FragmentManager mFragmentManager, BaseFragment fragment, boolean popStack, int container) {
        if (!mFragmentManager.isDestroyed()) {

            FragmentTransaction ft = mFragmentManager.beginTransaction();

            ft.replace(container, fragment);

            //Pop the stack completely till the current fragment thats being inserted.
            if (popStack) {
                mFragmentManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            }
            ft.addToBackStack(fragment.createTag());
            ft.commitAllowingStateLoss();
            mFragmentManager.executePendingTransactions();
        }
    }

    public static Fragment getCurrentFragment(FragmentManager mFragmentManager) {
        if (mFragmentManager != null) {
            if (mFragmentManager.getBackStackEntryCount() != 0) {
                String fragmentTag = mFragmentManager.getBackStackEntryAt(mFragmentManager.getBackStackEntryCount() - 1).getName();
                return mFragmentManager.findFragmentByTag(fragmentTag);
            }
        }
        return null;
    }
}