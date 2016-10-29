package com.davidferrand.spark.ui.base;

import android.support.annotation.NonNull;

public class BasePresenter<T extends BaseView> {
    private T view = null;

    public final void bindView(@NonNull final T view) {
        this.view = view;
    }

    @NonNull
    protected T getView() {
        if (view == null) {
            throw new IllegalStateException("bindView() hasn't been called");
        }

        return view;
    }
}
