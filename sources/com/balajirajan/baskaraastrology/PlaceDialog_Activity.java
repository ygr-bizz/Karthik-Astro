package com.cuspal.interlinks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.DialogFragment;

public class PlaceDialog_Activity extends DialogFragment {
    static PlaceSelectDialogListener pListner;

    public interface PlaceSelectDialogListener {
        void onFinishPlaceSelectDialog(String str);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_place_dialog_, container);
        ((Button) view.findViewById(R.id.btnCancel)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                PlaceDialog_Activity.pListner.onFinishPlaceSelectDialog("Test Message");
                PlaceDialog_Activity.this.getDialog().dismiss();
            }
        });
        return view;
    }
}
