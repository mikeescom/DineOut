package com.mikeescom.dineout.base.view;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.mikeescom.dineout.R;
import com.mikeescom.dineout.base.presenter.MvpPresenter;

public abstract class BaseActivity<T extends MvpPresenter> extends AppCompatActivity implements MvpView {

    private T presenter;

    private ProgressDialog mDialog;

    protected
    @NonNull
    T getPresenter() {
        if (presenter == null)
            presenter = createPresenter();
        if (presenter == null)
            throw new IllegalStateException("createPresenter() implementation returns null!");
        return presenter;
    }

    protected abstract T createPresenter();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getPresenter().onAttach(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        getPresenter().onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getPresenter().onDetach();
    }

    protected void showProgressDialog() {
        if ((mDialog != null && mDialog.isShowing()) || isFinishing()) {
            return;
        }
        mDialog = new ProgressDialog(this);
        mDialog.setMessage(getString(R.string.progress_dialog_message));
        mDialog.setCancelable(false);
        mDialog.setCanceledOnTouchOutside(false);
        mDialog.show();
    }

    protected void dismissProgressDialog() {
        if (mDialog == null || !mDialog.isShowing() || isFinishing()) {
            return;
        }
        try {
            mDialog.dismiss();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
