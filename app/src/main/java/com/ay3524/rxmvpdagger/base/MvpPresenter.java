package com.ay3524.rxmvpdagger.base;

public interface MvpPresenter<V extends MvpView, I extends MvpInteractor> {
    void onAttach(V mvpView);

    void onDetach();

    I getInteractor();
}
