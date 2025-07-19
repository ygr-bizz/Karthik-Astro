package com.cuspal.interlinks;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyAssetfiles {
    boolean bOverWrite;
    Context ct;
    String pPath;
    String pattern;

    public CopyAssetfiles(String pattern2, Context ct2, String tPath, boolean aOverwrite) {
        this.pattern = pattern2;
        this.ct = ct2;
        this.pPath = tPath;
        this.bOverWrite = aOverwrite;
    }

    /* access modifiers changed from: package-private */
    public void copy() {
        AssetManager assetManager = this.ct.getAssets();
        String[] files = null;
        try {
            files = assetManager.list("");
        } catch (IOException e) {
            Log.e("tag", "Failed to get asset file list.", e);
        }
        String outdir = this.pPath + File.separator;
        File saveDir = new File(outdir);
        if (!saveDir.exists()) {
            saveDir.mkdirs();
        }
        new File(outdir).mkdirs();
        for (String filename : files) {
            if (!new File(outdir + filename).exists() && filename.matches(this.pattern)) {
                try {
                    InputStream in = assetManager.open(filename);
                    OutputStream out = new FileOutputStream(new File(outdir, filename));
                    copyFile(in, out);
                    in.close();
                    out.flush();
                    out.close();
                } catch (IOException e2) {
                    Log.e("tag", "Failed to copy asset file: " + filename, e2);
                }
            }
        }
    }

    private void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        while (true) {
            int read = in.read(buffer);
            int read2 = read;
            if (read != -1) {
                out.write(buffer, 0, read2);
            } else {
                return;
            }
        }
    }
}
