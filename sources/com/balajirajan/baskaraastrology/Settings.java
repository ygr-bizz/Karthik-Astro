package com.cuspal.interlinks;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Settings extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    public static final String Language = "Lang";
    public static final String LatitueDD = "LatDD";
    public static final String LatitueMM = "LatMM";
    public static final String LatitueNS = "LatNS";
    public static final String LongitudeDD = "LonDD";
    public static final String LongitudeEW = "LonEW";
    public static final String LongitudeMM = "LonMM";
    public static final String MyPREFERENCES = "MyPrefs";
    public static final String NativePlace = "Place";
    public static final String TimecHH = "TcHH";
    public static final String TimecMM = "TcMM";
    public static final String TimecPM = "TcPM";
    public static final String TimezHH = "TzHH";
    public static final String TimezMM = "TzMM";
    public static final String TimezPM = "TzPM";
    String Lang;
    EditText Place;
    String[] SelectLanguage = {"Set Language", "English", "Tamil", "Telugu", "Malayalam", "Hindi"};
    EditText TcHH;
    EditText TcMM;
    EditText TcPM;
    EditText TzHH;
    EditText TzMM;
    EditText TzPM;
    Button b1;
    EditText latNS;
    EditText latdd;
    EditText latmm;
    EditText lonEW;
    EditText londd;
    EditText lonmm;
    SharedPreferences sharedpreferences;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_settings);
        Spinner spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);
        ArrayAdapter ad = new ArrayAdapter(this, 17367048, this.SelectLanguage);
        ad.setDropDownViewResource(17367049);
        spin.setAdapter(ad);
        this.Place = (EditText) findViewById(R.id.editText2);
        this.Lang = ((Spinner) findViewById(R.id.spinner)).getSelectedItem().toString();
        this.latdd = (EditText) findViewById(R.id.editText3);
        this.latmm = (EditText) findViewById(R.id.editText4);
        this.latNS = (EditText) findViewById(R.id.editText5);
        this.londd = (EditText) findViewById(R.id.editText6);
        this.lonmm = (EditText) findViewById(R.id.editText7);
        this.lonEW = (EditText) findViewById(R.id.editText8);
        this.TzHH = (EditText) findViewById(R.id.editText10);
        this.TzMM = (EditText) findViewById(R.id.editText11);
        this.TzPM = (EditText) findViewById(R.id.editText9);
        this.TcHH = (EditText) findViewById(R.id.editText13);
        this.TcMM = (EditText) findViewById(R.id.editText14);
        this.TcPM = (EditText) findViewById(R.id.editText12);
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", 0);
        this.sharedpreferences = sharedPreferences;
        if (sharedPreferences.getString("Place", (String) null) != null) {
            this.Place.setText(this.sharedpreferences.getString("Place", (String) null));
            this.Lang = this.sharedpreferences.getString("Lang", (String) null);
            this.latdd.setText(this.sharedpreferences.getString("LatDD", (String) null));
            this.latmm.setText(this.sharedpreferences.getString("LatMM", (String) null));
            this.latNS.setText(this.sharedpreferences.getString("LatNS", (String) null));
            this.londd.setText(this.sharedpreferences.getString("LonDD", (String) null));
            this.lonmm.setText(this.sharedpreferences.getString("LonMM", (String) null));
            this.lonEW.setText(this.sharedpreferences.getString("LonEW", (String) null));
            this.TcHH.setText(this.sharedpreferences.getString("TcHH", (String) null));
            this.TcMM.setText(this.sharedpreferences.getString("TcMM", (String) null));
            this.TcPM.setText(this.sharedpreferences.getString("TcPM", (String) null));
            this.TzHH.setText(this.sharedpreferences.getString("TzHH", (String) null));
            this.TzMM.setText(this.sharedpreferences.getString("TzMM", (String) null));
            this.TzPM.setText(this.sharedpreferences.getString("TzPM", (String) null));
        }
        Button button = (Button) findViewById(R.id.button);
        this.b1 = button;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Settings settings = Settings.this;
                settings.sharedpreferences = settings.getSharedPreferences("MyPrefs", 0);
                Settings settings2 = Settings.this;
                settings2.Place = (EditText) settings2.findViewById(R.id.editText2);
                Spinner spinner = (Spinner) Settings.this.findViewById(R.id.spinner);
                Settings.this.Lang = spinner.getSelectedItem().toString();
                Settings settings3 = Settings.this;
                settings3.latdd = (EditText) settings3.findViewById(R.id.editText3);
                Settings settings4 = Settings.this;
                settings4.latmm = (EditText) settings4.findViewById(R.id.editText4);
                Settings settings5 = Settings.this;
                settings5.latNS = (EditText) settings5.findViewById(R.id.editText5);
                Settings settings6 = Settings.this;
                settings6.londd = (EditText) settings6.findViewById(R.id.editText6);
                Settings settings7 = Settings.this;
                settings7.lonmm = (EditText) settings7.findViewById(R.id.editText7);
                Settings settings8 = Settings.this;
                settings8.lonEW = (EditText) settings8.findViewById(R.id.editText8);
                Settings settings9 = Settings.this;
                settings9.TzHH = (EditText) settings9.findViewById(R.id.editText10);
                Settings settings10 = Settings.this;
                settings10.TzMM = (EditText) settings10.findViewById(R.id.editText11);
                Settings settings11 = Settings.this;
                settings11.TzPM = (EditText) settings11.findViewById(R.id.editText9);
                Settings settings12 = Settings.this;
                settings12.TcHH = (EditText) settings12.findViewById(R.id.editText13);
                Settings settings13 = Settings.this;
                settings13.TcMM = (EditText) settings13.findViewById(R.id.editText14);
                Settings settings14 = Settings.this;
                settings14.TcPM = (EditText) settings14.findViewById(R.id.editText12);
                String p = Settings.this.Place.getText().toString();
                String L = Settings.this.Lang;
                String Ladd = Settings.this.latdd.getText().toString();
                String Lamm = Settings.this.latmm.getText().toString();
                String LaNS = Settings.this.latNS.getText().toString();
                String Lodd = Settings.this.londd.getText().toString();
                String Lomm = Settings.this.lonmm.getText().toString();
                String LoEW = Settings.this.lonEW.getText().toString();
                String chh = Settings.this.TcHH.getText().toString();
                String cmm = Settings.this.TcMM.getText().toString();
                String cpm = Settings.this.TcPM.getText().toString();
                String zhh = Settings.this.TzHH.getText().toString();
                String zmm = Settings.this.TzMM.getText().toString();
                String zpm = Settings.this.TzPM.getText().toString();
                Spinner spinner2 = spinner;
                SharedPreferences.Editor editor = Settings.this.sharedpreferences.edit();
                editor.putString("Lang", L);
                editor.putString("Place", p);
                editor.putString("LatDD", Ladd);
                editor.putString("LatMM", Lamm);
                editor.putString("LatNS", LaNS);
                editor.putString("LonDD", Lodd);
                editor.putString("LonMM", Lomm);
                editor.putString("LonEW", LoEW);
                editor.putString("TcHH", chh);
                editor.putString("TcMM", cmm);
                editor.putString("TcPM", cpm);
                editor.putString("TzHH", zhh);
                editor.putString("TzMM", zmm);
                editor.putString("TzPM", zpm);
                editor.commit();
                SharedPreferences.Editor editor2 = editor;
                String str = p;
                Toast.makeText(Settings.this, "Settings Saved,Thanks!", 1).show();
            }
        });
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
