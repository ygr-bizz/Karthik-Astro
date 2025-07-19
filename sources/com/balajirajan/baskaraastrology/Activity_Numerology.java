package com.cuspal.interlinks;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashMap;
import java.util.Map;

public class Activity_Numerology extends AppCompatActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity__numerology);
        ((Button) findViewById(R.id.btn_run)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String StrNuerology = Activity_Numerology.this.digitise(((EditText) Activity_Numerology.this.findViewById(R.id.edtPersonName)).getText().toString().replaceAll("[-+.^:,]", "").toUpperCase());
                ((TextView) Activity_Numerology.this.findViewById(R.id.help_text)).setText(Activity_Numerology.this.pyramidCal1(StrNuerology));
                ((TextView) Activity_Numerology.this.findViewById(R.id.resultTextTotal)).setText(Activity_Numerology.this.pyramidCal2(StrNuerology));
            }
        });
    }

    /* access modifiers changed from: private */
    public String digitise(String StrName) {
        char[] ch = StrName.toCharArray();
        String tmp = "";
        for (char str : ch) {
            if (str != ' ') {
                tmp = tmp + "" + a2no(str);
            }
        }
        return tmp;
    }

    private int digitiseInt(String StrName) {
        char[] ch = StrName.toCharArray();
        int tmp = 0;
        for (char str : ch) {
            if (str != ' ') {
                tmp = digit2Tot(tmp, Integer.parseInt(a2no(str)));
            }
        }
        return tmp;
    }

    private String a2no(char letr) {
        Map<Character, Object> a2narr = new HashMap<>();
        a2narr.put('A', 1);
        a2narr.put('I', 1);
        a2narr.put('J', 1);
        a2narr.put('Q', 1);
        a2narr.put('Y', 1);
        a2narr.put('B', 2);
        a2narr.put('K', 2);
        a2narr.put('R', 2);
        a2narr.put('C', 3);
        a2narr.put('G', 3);
        a2narr.put('L', 3);
        a2narr.put('S', 3);
        a2narr.put('D', 4);
        a2narr.put('M', 4);
        a2narr.put('T', 4);
        a2narr.put('E', 5);
        a2narr.put('H', 5);
        a2narr.put('N', 5);
        a2narr.put('X', 5);
        a2narr.put('U', 6);
        a2narr.put('V', 6);
        a2narr.put('W', 6);
        a2narr.put('O', 7);
        a2narr.put('Z', 7);
        a2narr.put('F', 8);
        a2narr.put('P', 8);
        a2narr.put('1', 1);
        a2narr.put('2', 2);
        a2narr.put('3', 3);
        a2narr.put('4', 4);
        a2narr.put('5', 5);
        a2narr.put('6', 6);
        a2narr.put('7', 7);
        a2narr.put('8', 8);
        a2narr.put('9', 9);
        a2narr.put('0', 0);
        return a2narr.get(Character.valueOf(letr)) + "";
    }

    /* access modifiers changed from: private */
    public String pyramidCal1(String StrNuerology) {
        Activity_Numerology activity_Numerology = this;
        String str = " = " + digitiseInt(StrNuerology) + "\n";
        String res = StrNuerology + "\n";
        char[] nox = StrNuerology.toCharArray();
        char[] no = StrNuerology.toCharArray();
        int temp = 0;
        String tmpStr = "";
        String[] eSum = new String[(no.length - 1)];
        int j = 0;
        while (j < nox.length - 1) {
            int i = 0;
            while (i < no.length - 1) {
                int zValue = activity_Numerology.digit2Tot(Integer.parseInt(String.valueOf(no[i])), Integer.parseInt(String.valueOf(no[i + 1])));
                temp = activity_Numerology.digit2Tot(temp, zValue);
                tmpStr = tmpStr + String.valueOf(zValue);
                i++;
                activity_Numerology = this;
            }
            eSum[j] = tmpStr;
            no = tmpStr.toCharArray();
            tmpStr = "";
            res = res + "" + eSum[j] + "\n";
            String resultTextTotal = "=" + temp + "\n";
            j++;
            activity_Numerology = this;
        }
        return res;
    }

    /* access modifiers changed from: private */
    public String pyramidCal2(String StrNuerology) {
        Activity_Numerology activity_Numerology = this;
        String resultTextTotal = " = " + digitiseInt(StrNuerology) + "\n";
        String res = StrNuerology + "\n";
        char[] nox = StrNuerology.toCharArray();
        char[] no = StrNuerology.toCharArray();
        int temp = 0;
        String tmpStr = "";
        String[] eSum = new String[(no.length - 1)];
        int j = 0;
        while (j < nox.length - 1) {
            int i = 0;
            while (i < no.length - 1) {
                int zValue = activity_Numerology.digit2Tot(Integer.parseInt(String.valueOf(no[i])), Integer.parseInt(String.valueOf(no[i + 1])));
                temp = activity_Numerology.digit2Tot(temp, zValue);
                tmpStr = tmpStr + String.valueOf(zValue);
                i++;
                activity_Numerology = this;
            }
            eSum[j] = tmpStr;
            no = tmpStr.toCharArray();
            tmpStr = "";
            res = res + "" + eSum[j];
            resultTextTotal = resultTextTotal + " = " + temp + " \n";
            j++;
            activity_Numerology = this;
        }
        return resultTextTotal;
    }

    private int digit2Tot(int x, int y) {
        if (x + y > 9) {
            return (x + y) - 9;
        }
        return x + y;
    }
}
