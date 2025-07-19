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

public class ClientList extends AppCompatActivity {
    DBClass_All controller = new DBClass_All(this);
    TextView infotext;
    ListView ls;
    ArrayList<HashMap<String, String>> myIds;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_client_list);
        this.ls = (ListView) findViewById(R.id.placeslist);
        this.infotext = (TextView) findViewById(R.id.txtresulttext);
        registerForContextMenu(this.ls);
        try {
            List<HashMap<String, String>> data = this.controller.getAllPlace_Birth();
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
        ArrayList<HashMap<String, String>> selectAllIds_Birth = this.controller.selectAllIds_Birth();
        this.myIds = selectAllIds_Birth;
        int id = Integer.parseInt((String) selectAllIds_Birth.get(info.position).get("id"));
        int itemId = menuItem.getItemId();
        if (itemId == 0) {
            Global.isrun = true;
            Global.Name = (String) this.myIds.get(info.position).get("name");
            Global.Loc = (String) this.myIds.get(info.position).get("place");
            Global.dd = Integer.parseInt((String) this.myIds.get(info.position).get("day"));
            Global.mm = Integer.parseInt((String) this.myIds.get(info.position).get("month"));
            Global.yy = Integer.parseInt((String) this.myIds.get(info.position).get("year"));
            Global.hh = Integer.parseInt((String) this.myIds.get(info.position).get("hh"));
            Global.min = Integer.parseInt((String) this.myIds.get(info.position).get("mm"));
            Global.ss = Integer.parseInt((String) this.myIds.get(info.position).get("ss"));
            String[] strArrayLat = ((String) this.myIds.get(info.position).get("latdd")).split(":");
            Global.latdd = Integer.parseInt(strArrayLat[0]);
            Global.latmm = Integer.parseInt(strArrayLat[1]);
            Global.latNS = strArrayLat[2];
            String[] strArrayLon = ((String) this.myIds.get(info.position).get("londd")).split(":");
            Global.londd = Integer.parseInt(strArrayLon[0]);
            Global.lonmm = Integer.parseInt(strArrayLon[1]);
            Global.lonEW = strArrayLon[2];
            String[] strArrayTzpm = ((String) this.myIds.get(info.position).get("tzpm")).split(":");
            Global.TzHH = Integer.parseInt(strArrayTzpm[1]);
            Global.TzMM = Integer.parseInt(strArrayTzpm[2]);
            Global.TzPM = strArrayTzpm[0];
            String[] strArrayTcpm = ((String) this.myIds.get(info.position).get("tcpm")).split(":");
            Global.TcHH = Integer.parseInt(strArrayTcpm[1]);
            Global.TcMM = Integer.parseInt(strArrayTcpm[2]);
            Global.TcPM = strArrayTcpm[0];
            Toast.makeText(this, "Selected" + info.id, 1).show();
        } else if (itemId == 1) {
            try {
                DBClass_All dBClass_All = new DBClass_All(getApplicationContext());
                this.controller = dBClass_All;
                SQLiteDatabase db = dBClass_All.getWritableDatabase();
                db.delete("clientdata", "id=" + id, (String[]) null);
                TextView textView = this.infotext;
                textView.setText(id + "-Deleted Successfully");
            } catch (Exception ex) {
                this.infotext.setText(ex.getMessage());
            }
        }
        return true;
    }
}
