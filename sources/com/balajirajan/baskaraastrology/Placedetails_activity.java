package com.cuspal.interlinks;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Placedetails_activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button btnBack;
    Button btnsearch;
    DBController_place controller = new DBController_place(this);
    TextView infotext;
    ListView ls;
    ArrayList<HashMap<String, String>> myIds;
    String place_name;
    Spinner spinner_country;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_placedetails_activity);
        this.spinner_country = (Spinner) findViewById(R.id.spinner_country);
        this.infotext = (TextView) findViewById(R.id.txtresulttext);
        ListView listView = (ListView) findViewById(R.id.placeslist);
        this.ls = listView;
        registerForContextMenu(listView);
        loadSpinnerData();
        Button button = (Button) findViewById(R.id.btn_Search);
        this.btnsearch = button;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Placedetails_activity.this.Search_Place(((Spinner) Placedetails_activity.this.findViewById(R.id.spinner_country)).getSelectedItem().toString());
                Placedetails_activity.hideKeyboard(Placedetails_activity.this);
            }
        });
        Button button2 = (Button) findViewById(R.id.btn_Back);
        this.btnBack = button2;
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Placedetails_activity.this.finish();
            }
        });
    }

    /* access modifiers changed from: private */
    public void Search_Place(String spn) {
        try {
            List<HashMap<String, String>> data = this.controller.getAllPlace(spn, ((EditText) findViewById(R.id.edt_place)).getText().toString());
            if (data.size() != 0) {
                final SimpleAdapter simpleAdapter = new SimpleAdapter(this, data, R.layout.place_rows, new String[]{"id", "name"}, new int[]{R.id.txtnameid, R.id.txtname});
                this.ls.setAdapter(simpleAdapter);
                this.ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> adapterView, View itemClicked, int position, long id) {
                        String obj = simpleAdapter.getItem(position).toString();
                        Placedetails_activity.this.place_name = (String) ((Map) Placedetails_activity.this.ls.getItemAtPosition(position)).get("name");
                        Placedetails_activity placedetails_activity = Placedetails_activity.this;
                        placedetails_activity.myIds = placedetails_activity.controller.selectAllIds(Placedetails_activity.this.place_name);
                        Global.isrun = true;
                        Global.Loc = ((String) Placedetails_activity.this.myIds.get(0).get("place")) + "," + ((String) Placedetails_activity.this.myIds.get(0).get("state")) + "," + ((String) Placedetails_activity.this.myIds.get(0).get("country"));
                        ((EditText) Placedetails_activity.this.findViewById(R.id.edt_place)).setText((CharSequence) Placedetails_activity.this.myIds.get(0).get("place"));
                        Global.londd = Integer.parseInt((String) Placedetails_activity.this.myIds.get(0).get("longDeg"));
                        Global.lonmm = Integer.parseInt((String) Placedetails_activity.this.myIds.get(0).get("longMnt"));
                        Global.lonEW = (String) Placedetails_activity.this.myIds.get(0).get("longDir");
                        Global.latdd = Integer.parseInt((String) Placedetails_activity.this.myIds.get(0).get("latDeg"));
                        Global.latmm = Integer.parseInt((String) Placedetails_activity.this.myIds.get(0).get("latMnt"));
                        Global.latNS = (String) Placedetails_activity.this.myIds.get(0).get("latDir");
                        Global.TzHH = Integer.parseInt((String) Placedetails_activity.this.myIds.get(0).get("tzHH"));
                        Global.TzMM = Integer.parseInt((String) Placedetails_activity.this.myIds.get(0).get("tzMM"));
                        if (Integer.parseInt((String) Placedetails_activity.this.myIds.get(0).get("tzPM")) == 1) {
                            Global.TzPM = "+";
                        } else {
                            Global.TzPM = "-";
                        }
                        Global.p_select = true;
                        Toast.Toasty(Placedetails_activity.this.getApplicationContext(), "Selected Saved", 2);
                    }
                });
                String length = String.valueOf(data.size());
                TextView textView = this.infotext;
                textView.setText(length + " data found");
                return;
            }
            this.infotext.setText("No data in database");
        } catch (Exception ex) {
            this.infotext.setText(ex.getMessage());
        }
    }

    private void loadSpinnerData() {
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, 17367048, new DBController_place(getApplicationContext()).getAllLabels());
        dataAdapter.setDropDownViewResource(17367049);
        this.spinner_country.setAdapter(dataAdapter);
        this.spinner_country.setSelection(dataAdapter.getPosition("India"));
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return true;
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if (v.getId() == R.id.placeslist) {
            AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) menuInfo;
            menu.add(0, 0, 0, "Select");
        }
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService("input_method");
        View view = activity.getCurrentFocus();
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
