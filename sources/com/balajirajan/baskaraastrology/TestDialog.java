package com.cuspal.interlinks;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class TestDialog extends DialogFragment implements TextView.OnEditorActionListener {
    private static String pPath;
    Cursor cPlace;
    Context ct;
    SQLiteDatabase dbPlaces;
    String fndCountry;
    ArrayAdapter<String> listCountryAdapter;
    List<String> listCoutnry;
    List<String> listPlaces;
    ArrayAdapter<String> listPlacesAdapter;
    private ImageButton mBtnFind;
    /* access modifiers changed from: private */
    public EditText mEditCountry;
    /* access modifiers changed from: private */
    public EditText mEditLatitude;
    /* access modifiers changed from: private */
    public EditText mEditLongitude;
    /* access modifiers changed from: private */
    public EditText mEditPlace;
    /* access modifiers changed from: private */
    public EditText mEditState;
    /* access modifiers changed from: private */
    public EditText mEditTz;
    Spinner showCountry;
    Spinner showPlaces;

    public interface EditNameDialogListener {
        void onFinishEditDialog(Boolean bool, String str, String str2, String str3, String str4);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().setTitle("DialogFragment Demo");
        View view = inflater.inflate(R.layout.activity_place_dialog_, container);
        getDialog().setTitle("Hello");
        this.mEditPlace = (EditText) view.findViewById(R.id.editPlace);
        this.mEditState = (EditText) view.findViewById(R.id.editState);
        this.mEditCountry = (EditText) view.findViewById(R.id.editCountry);
        this.mEditLatitude = (EditText) view.findViewById(R.id.editLatitude);
        this.mEditLongitude = (EditText) view.findViewById(R.id.editLongitude);
        this.mEditTz = (EditText) view.findViewById(R.id.editTz);
        this.mBtnFind = (ImageButton) view.findViewById(R.id.btnFind);
        this.mEditPlace.setText("Chennai");
        pPath = "/data/user/0/com.cuspal.interlinks/databases";
        this.dbPlaces = SQLiteDatabase.openDatabase(pPath + "/filesplaces.sqlite3", (SQLiteDatabase.CursorFactory) null, 1);
        ArrayList arrayList = new ArrayList();
        this.listPlaces = arrayList;
        arrayList.clear();
        this.listPlaces.add("Select Place");
        this.showCountry = (Spinner) view.findViewById(R.id.spintxtCoutnry);
        getDatabaseStructure(this.dbPlaces);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), R.layout.custom_spinner_list, this.listPlaces);
        this.listPlacesAdapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(R.layout.customer_spinner);
        this.showPlaces = (Spinner) view.findViewById(R.id.showPlaces);
        this.fndCountry = "India";
        UpdatePlaceList(this.mEditPlace.getText().toString(), "India");
        this.showPlaces.setAdapter(this.listPlacesAdapter);
        this.mBtnFind.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String tPlace = TestDialog.this.mEditPlace.getText().toString().trim();
                if (tPlace.length() < 3) {
                    Toast.Toasty(TestDialog.this.getContext(), "Error,Please enter Place atleast 2 chars", 3);
                    return;
                }
                TestDialog testDialog = TestDialog.this;
                testDialog.UpdatePlaceList(tPlace, testDialog.fndCountry);
            }
        });
        this.showPlaces.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                String TzPM;
                int i = position;
                if (i >= 1) {
                    TestDialog.this.mEditPlace.setText(TestDialog.this.listPlacesAdapter.getItem(i));
                    TestDialog.this.cPlace.moveToPosition(i - 1);
                    TestDialog.this.mEditCountry.setText(TestDialog.this.cPlace.getString(0));
                    TestDialog.this.mEditState.setText(TestDialog.this.cPlace.getString(1));
                    TestDialog.this.mEditLatitude.setText(String.format("%03d:%02d:%1s", new Object[]{Integer.valueOf(TestDialog.this.cPlace.getInt(3)), Integer.valueOf(TestDialog.this.cPlace.getInt(4)), TestDialog.this.cPlace.getString(6)}));
                    TestDialog.this.mEditLongitude.setText(String.format("%03d:%02d:%1s", new Object[]{Integer.valueOf(TestDialog.this.cPlace.getInt(7)), Integer.valueOf(TestDialog.this.cPlace.getInt(8)), TestDialog.this.cPlace.getString(10)}));
                    double TzValue = TestDialog.this.cPlace.getDouble(13);
                    Integer TzDD = Integer.valueOf((int) TzValue);
                    Integer TzMM = Integer.valueOf((int) ((TzValue - ((double) TzDD.intValue())) * 60.0d));
                    if (TzValue > 0.0d) {
                        TzPM = "+";
                    } else {
                        TzPM = "+";
                    }
                    TestDialog.this.mEditTz.setText(String.format("%1s:%02d:%02d", new Object[]{TzPM, TzDD, TzMM}));
                }
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        this.showCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                if (position >= 1) {
                    TestDialog testDialog = TestDialog.this;
                    testDialog.fndCountry = testDialog.listCountryAdapter.getItem(position);
                    TestDialog.this.mEditCountry.setText(TestDialog.this.listCountryAdapter.getItem(position));
                    TestDialog.this.listPlaces.clear();
                }
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        ((Button) view.findViewById(R.id.btnSelect)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    ((EditNameDialogListener) TestDialog.this.getActivity()).onFinishEditDialog(true, TestDialog.this.mEditPlace.getText().toString(), TestDialog.this.mEditLatitude.getText().toString(), TestDialog.this.mEditLongitude.getText().toString(), TestDialog.this.mEditTz.getText().toString());
                    TestDialog.this.getDialog().dismiss();
                } catch (Exception es) {
                    PrintStream printStream = System.out;
                    printStream.println("Stacktrace " + es.toString());
                }
            }
        });
        ((Button) view.findViewById(R.id.btnCancel)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ((EditNameDialogListener) TestDialog.this.getActivity()).onFinishEditDialog(false, "", "", "", "");
                TestDialog.this.getDialog().dismiss();
            }
        });
        return view;
    }

    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (6 != actionId) {
            return false;
        }
        ((EditNameDialogListener) getActivity()).onFinishEditDialog(true, this.mEditPlace.getText().toString(), this.mEditLatitude.getText().toString(), this.mEditLongitude.getText().toString(), this.mEditTz.getText().toString());
        dismiss();
        return true;
    }

    public void UpdatePlaceList(String tPlace, String strtable) {
        if (tPlace.length() >= 3) {
            SQLiteDatabase sQLiteDatabase = this.dbPlaces;
            this.cPlace = sQLiteDatabase.rawQuery("SELECT * FROM " + strtable + " WHERE name LIKE '%" + tPlace + "%'", (String[]) null);
            this.listPlaces.clear();
            if (this.cPlace.getCount() <= 0) {
                Context context = getContext();
                Toast.Toasty(context, "Error,Place Not found!!!  " + tPlace + " In " + strtable, 0);
            } else if (this.cPlace.moveToFirst()) {
                this.mEditPlace.setText(this.cPlace.getString(2));
                this.mEditCountry.setText(this.cPlace.getString(0));
                this.listPlaces.add("Select Place");
                this.listPlaces.add(this.cPlace.getString(2));
                while (this.cPlace.moveToNext()) {
                    this.listPlaces.add(this.cPlace.getString(2));
                }
                this.showPlaces.setSelection(0, true);
                this.showPlaces.setSelection(1, true);
            } else {
                Context context2 = getContext();
                Toast.Toasty(context2, "Error,Place not found" + tPlace, 3);
            }
        }
    }

    public String getFilePath(Context ct2) {
        return ct2.getFilesDir() + "/";
    }

    public void getDatabaseStructure(SQLiteDatabase db) {
        ArrayList arrayList = new ArrayList();
        this.listCoutnry = arrayList;
        arrayList.clear();
        this.listCoutnry.add("India");
        SQLiteDatabase sQLiteDatabase = this.dbPlaces;
        Cursor cCountry = sQLiteDatabase.rawQuery("SELECT * FROM " + "sqlite_sequence", (String[]) null);
        cCountry.moveToFirst();
        while (cCountry.moveToNext()) {
            this.listCoutnry.add(cCountry.getString(0));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), 17367048, this.listCoutnry);
        this.listCountryAdapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(17367049);
        this.showCountry.setAdapter(this.listCountryAdapter);
    }
}
