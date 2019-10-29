package com.excelbloonow.android.musicplayer.StartWidget;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.excelbloonow.android.musicplayer.PublicWidget.AccessPermission;
import com.excelbloonow.android.musicplayer.PublicWidget.SingleFragmentActivity;

public class StartActivity extends SingleFragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AccessPermission.requestStoragePermission(getApplicationContext(), this);
    }

    @Override
    protected Fragment createFragment() {
        return StartFragment.newInstance();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == AccessPermission.REQUEST_STORAGE_CODE) {
            if (!(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    new AlertDialog.Builder(this)
                            .setMessage("application need the permission of reading and writing storage")
                            .setPositiveButton("OK", (dialog, which) ->
                                    ActivityCompat.requestPermissions(this,
                                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                                            AccessPermission.REQUEST_STORAGE_CODE))
                            .setNegativeButton("Cancel", null)
                            .create()
                            .show();
                }
            }
        }
    }

}
