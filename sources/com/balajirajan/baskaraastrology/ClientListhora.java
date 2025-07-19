package com.cuspal.interlinks;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ClientListhora extends AppCompatActivity {
    DBClass_Horary controller = new DBClass_Horary(this);
    TextView infotext;
    ListView ls;
    ArrayList<HashMap<String, String>> myIds;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_client_listhora);
        this.ls = (ListView) findViewById(R.id.placeslist);
        this.infotext = (TextView) findViewById(R.id.txtresulttext);
        registerForContextMenu(this.ls);
        try {
            List<HashMap<String, String>> data = this.controller.getAllPlace();
            if (data.size() != 0) {
                this.ls.setAdapter(new SimpleAdapter(this, data, R.layout.rows, new String[]{"id", "name", "place"}, new int[]{R.id.txtnameid, R.id.txtname, R.id.txtplace}));
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

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if (v.getId() == R.id.placeslist) {
            AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) menuInfo;
            MenuItem add = menu.add(0, 0, 0, "Select");
            menu.add(0, 1, 1, "Delete");
        }
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuItem.getMenuInfo();
        ArrayList<HashMap<String, String>> selectAllIds = this.controller.selectAllIds();
        this.myIds = selectAllIds;
        int id = Integer.parseInt((String) selectAllIds.get(info.position).get("id"));
        int itemId = menuItem.getItemId();
        if (itemId == 0) {
            Global.isrun = true;
            Global.Name = (String) this.myIds.get(info.position).get("name");
            Global.Hno = Integer.parseInt((String) this.myIds.get(info.position).get("Horno"));
            Global.Loc = (String) this.myIds.get(info.position).get("place");
            Global.dd = Integer.parseInt((String) this.myIds.get(info.position).get("day"));
            Global.mm = Integer.parseInt((String) this.myIds.get(info.position).get("month"));
            Global.yy = Integer.parseInt((String) this.myIds.get(info.position).get("year"));
            Global.hh = Integer.parseInt((String) this.myIds.get(info.position).get("hh"));
            Global.min = Integer.parseInt((String) this.myIds.get(info.position).get("mm"));
            Global.ss = Integer.parseInt((String) this.myIds.get(info.position).get("ss"));
            Global.latdd = Integer.parseInt((String) this.myIds.get(info.position).get("latdd"));
            Global.latmm = Integer.parseInt((String) this.myIds.get(info.position).get("latmm"));
            Global.latNS = (String) this.myIds.get(info.position).get("latNS");
            Global.londd = Integer.parseInt((String) this.myIds.get(info.position).get("londd"));
            Global.lonmm = Integer.parseInt((String) this.myIds.get(info.position).get("lonmm"));
            Global.lonEW = (String) this.myIds.get(info.position).get("lonEW");
            Global.TzHH = Integer.parseInt((String) this.myIds.get(info.position).get("tzhh"));
            Global.TzMM = Integer.parseInt((String) this.myIds.get(info.position).get("tzmm"));
            Global.TzPM = (String) this.myIds.get(info.position).get("tzpm");
            Global.TcHH = Integer.parseInt((String) this.myIds.get(info.position).get("tchh"));
            Global.TcMM = Integer.parseInt((String) this.myIds.get(info.position).get("tcmm"));
            Global.TcPM = (String) this.myIds.get(info.position).get("tcpm");
            Toast.makeText(this, "Selected" + info.id, 1).show();
        } else if (itemId == 1) {
            try {
                DBClass_Horary dBClass_Horary = new DBClass_Horary(getApplicationContext());
                this.controller = dBClass_Horary;
                SQLiteDatabase db = dBClass_Horary.getWritableDatabase();
                db.delete("clientdataHora", "id=" + id, (String[]) null);
                TextView textView = this.infotext;
                textView.setText(id + "-Deleted Successfully");
            } catch (Exception ex) {
                this.infotext.setText(ex.getMessage());
            }
        }
        return true;
    }
}
