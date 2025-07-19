package com.cuspal.interlinks;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

public class Flash_Activity extends AppCompatActivity {
    private static final String DB_NAME = "asset.db";
    Context ct;
    String dataPath;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_flash_);
        Context applicationContext = getApplicationContext();
        this.ct = applicationContext;
        this.dataPath = getFilePath(applicationContext);
        setContentView((int) R.layout.activity_flash_);
        new CopyAssetfiles(".*\\.SE1", this.ct, this.dataPath + "ephe", false).copy();
        new CopyAssetfiles(".*\\.sqlite3", this.ct, "/data/data/" + this.ct.getPackageName() + "/databases/", false).copy();
        new Thread() {
            public void run() {
                try {
                    sleep(3000);
                    Flash_Activity.this.startActivity(new Intent(Flash_Activity.this, menu.class));
                    Flash_Activity.this.finish();
                } catch (Exception e) {
                    e.printStackTrace();
                } catch (Throwable th) {
                    Flash_Activity.this.finish();
                    throw th;
                }
                Flash_Activity.this.finish();
            }
        }.start();
    }

    public String getFilePath(Context ct2) {
        String filePath = ct2.getFilesDir() + "/";
        Log.d("Test", "File path: " + filePath);
        return filePath;
    }
}
