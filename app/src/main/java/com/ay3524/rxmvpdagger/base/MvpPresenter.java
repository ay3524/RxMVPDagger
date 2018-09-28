package com.ay3524.rxmvpdagger.base;

public interface MvpPresenter<V extends MvpView> {
    void onAttach(V mvpView);

    void onDetach();
}
