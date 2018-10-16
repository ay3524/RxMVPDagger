package com.ay3524.rxmvpdagger.ui.home;

import com.ay3524.rxmvpdagger.base.BasePresenter;

public class HomePresenter<V extends HomeMvpView, I extends HomeMvpInteractor>
        extends BasePresenter<V, I> implements HomeMvpPresenter<V, I> {
    public HomePresenter(I mvpInteractor) {
        super(mvpInteractor);
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public I getInteractor() {
        return super.getInteractor();
    }

    @Override
    public V getMvpView() {
        return super.getMvpView();
    }
}
