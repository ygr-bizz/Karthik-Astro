package com.cuspal.interlinks;

import android.content.Context;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Global_Log {
    String dataPath;
    Context mContext;

    public Global_Log(Context context, String path) {
        this.mContext = context;
        this.dataPath = path;
    }

    public void AppendLog() {
        new File(this.dataPath + "log.txt").delete();
    }

    public void AppendLog(String text) {
        File logFile = new File(this.dataPath + "log.txt");
        if (!logFile.exists()) {
            try {
                logFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            BufferedWriter buf = new BufferedWriter(new FileWriter(logFile, true));
            buf.append(text);
            buf.newLine();
            buf.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
