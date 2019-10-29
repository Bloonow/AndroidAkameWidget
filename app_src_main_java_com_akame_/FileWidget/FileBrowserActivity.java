package com.excelbloonow.android.musicplayer.FileWidget;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.excelbloonow.android.musicplayer.PublicWidget.AppConst;
import com.excelbloonow.android.musicplayer.PublicWidget.BackFragmentHandleHelper;
import com.excelbloonow.android.musicplayer.PublicWidget.SingleFragmentActivity;

public class FileBrowserActivity extends SingleFragmentActivity {

    public static Intent newIntent(Context packageContext) {
        return new Intent(packageContext, FileBrowserActivity.class);
    }

    @Override
    protected Fragment createFragment() {
        String requestContent = getIntent().getStringExtra(AppConst.INTENT_EXTRA_REQUEST_FILENAME_KEY);
        return FileBrowserFragment.newInstance(requestContent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onBackPressed() {
        if (!BackFragmentHandleHelper.handleBackFromActivity(this)) {
            super.onBackPressed();
        }
    }

}
