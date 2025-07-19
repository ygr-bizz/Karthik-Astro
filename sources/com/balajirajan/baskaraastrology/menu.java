package com.cuspal.interlinks;

import android.content.ClipData;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.text.ClipboardManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class menu extends AppCompatActivity {
    private static final String m_szDevIDShort = ("35" + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) + (Build.CPU_ABI.length() % 10) + (Build.DEVICE.length() % 10) + (Build.DISPLAY.length() % 10) + (Build.HOST.length() % 10) + (Build.ID.length() % 10) + (Build.MANUFACTURER.length() % 10) + (Build.MODEL.length() % 10) + (Build.PRODUCT.length() % 10) + (Build.TAGS.length() % 10) + (Build.TYPE.length() % 10) + (Build.USER.length() % 10));
    public String MAIN_TEXT;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_menu);
        String lic_text = readFromFile(this);
        if (lic_text != null) {
            if (m_szDevIDShort.equals(decrypt(lic_text))) {
                Toast.Toasty(getApplicationContext(), "Software Licenced", 3);
            } else {
                check();
            }
        } else {
            check();
        }
        ListView menuList = (ListView) findViewById(R.id.ListView_Menu);
        menuList.setAdapter(new ArrayAdapter<>(this, R.layout.menu_item, new String[]{getResources().getString(R.string.menu_item_play), "Horary Chart", "Numerology", getResources().getString(R.string.menu_item_settings), getResources().getString(R.string.menu_item_help)}));
        menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View itemClicked, int position, long id) {
                String strText = ((TextView) itemClicked).getText().toString();
                if (strText.equalsIgnoreCase(menu.this.getResources().getString(R.string.menu_item_play))) {
                    menu.this.startActivity(new Intent(menu.this, Main_input.class));
                } else if (strText.equalsIgnoreCase(menu.this.getResources().getString(R.string.menu_item_help))) {
                    menu.this.startActivity(new Intent(menu.this, help.class));
                } else if (strText.equalsIgnoreCase("Settings")) {
                    menu.this.startActivity(new Intent(menu.this, Settings.class));
                } else if (strText.equalsIgnoreCase("Horary Chart")) {
                    menu.this.startActivity(new Intent(menu.this, Main_input_h.class));
                } else if (strText.equalsIgnoreCase("Numerology")) {
                    menu.this.startActivity(new Intent(menu.this, Activity_Numerology.class));
                }
            }
        });
    }

    public void onBackPressed() {
        Toast.Toasty(getApplicationContext(), "Press back again to logout", 2);
        exitFromApp();
    }

    private void check() {
        final AlertDialog dialogBuilder = new AlertDialog.Builder(this).create();
        View dialogView = getLayoutInflater().inflate(R.layout.custom_dialog, (ViewGroup) null);
        dialogBuilder.setCanceledOnTouchOutside(false);
        dialogBuilder.setCancelable(false);
        dialogBuilder.setView(dialogView);
        dialogBuilder.show();
        String str = m_szDevIDShort;
        String encrypt = encrypt(str);
        this.MAIN_TEXT = str;
        ((TextView) dialogView.findViewById(R.id.MainKey)).setText(str);
        final EditText editText = (EditText) dialogView.findViewById(R.id.edt_comment);
        ((Button) dialogView.findViewById(R.id.buttonCancel)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                dialogBuilder.dismiss();
                menu.this.exitFromApp();
            }
        });
        ((Button) dialogView.findViewById(R.id.buttonSubmit)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String etxt = editText.getText().toString();
                if (menu.decrypt(etxt).equals("35" + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) + (Build.CPU_ABI.length() % 10) + (Build.DEVICE.length() % 10) + (Build.DISPLAY.length() % 10) + (Build.HOST.length() % 10) + (Build.ID.length() % 10) + (Build.MANUFACTURER.length() % 10) + (Build.MODEL.length() % 10) + (Build.PRODUCT.length() % 10) + (Build.TAGS.length() % 10) + (Build.TYPE.length() % 10) + (Build.USER.length() % 10))) {
                    menu menu = menu.this;
                    menu.writeToFile(etxt, menu);
                    Toast.Toasty(menu.this.getApplicationContext(), "Software Licenced", 3);
                    dialogBuilder.dismiss();
                    return;
                }
                Toast.Toasty(menu.this.getApplicationContext(), "Software Not Licenced", 0);
            }
        });
        ((Button) dialogView.findViewById(R.id.btnCopy)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                menu menu = menu.this;
                menu.copyToClipboard(menu.MAIN_TEXT);
            }
        });
    }

    public void copyToClipboard(String copyText) {
        if (Build.VERSION.SDK_INT < 11) {
            ((ClipboardManager) getSystemService("clipboard")).setText(copyText);
        } else {
            ((android.content.ClipboardManager) getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("Your Main key", copyText));
        }
        Toast.Toasty(this, "Your Main key is copied", 0);
    }

    public static String encrypt(String cleartext) {
        String encrypted = "";
        try {
            encrypted = AESHelper.encrypt(cleartext);
            Log.d("TEST", "encrypted:" + encrypted);
            return encrypted;
        } catch (Exception e) {
            e.printStackTrace();
            return encrypted;
        }
    }

    public static String decrypt(String encrypted) {
        String decrypted = "";
        try {
            decrypted = AESHelper.decrypt(encrypted);
            Log.d("TEST", "decrypted:" + decrypted);
            return decrypted;
        } catch (Exception e) {
            e.printStackTrace();
            return decrypted;
        }
    }

    /* access modifiers changed from: private */
    public void exitFromApp() {
        Process.killProcess(Process.myPid());
    }

    /* access modifiers changed from: private */
    public void writeToFile(String data, menu context) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("config.txt", 0));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    private String readFromFile(menu context) {
        try {
            InputStream inputStream = context.openFileInput("config.txt");
            if (inputStream == null) {
                return "";
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                String receiveString = readLine;
                if (readLine != null) {
                    stringBuilder.append(receiveString);
                } else {
                    inputStream.close();
                    return stringBuilder.toString();
                }
            }
        } catch (FileNotFoundException e) {
            Log.e("LICENCE activity", "File not found: " + e.toString());
            return "";
        } catch (IOException e2) {
            Log.e("LICENCE activity", "Can not read file: " + e2.toString());
            return "";
        }
    }
}
