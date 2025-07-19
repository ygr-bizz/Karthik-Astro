package com.cuspal.interlinks;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class ItemArrayAdapter extends ArrayAdapter {
    private final List scoreList = new ArrayList();

    static class ItemViewHolder {
        TextView name;
        TextView score;

        ItemViewHolder() {
        }
    }

    public ItemArrayAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public void add(String[] object) {
        this.scoreList.add(object);
        super.add(object);
    }

    public int getCount() {
        return this.scoreList.size();
    }

    public String[] getItem(int index) {
        return (String[]) this.scoreList.get(index);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.cuspal.interlinks.ItemArrayAdapter$ItemViewHolder} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View getView(int r6, android.view.View r7, android.view.ViewGroup r8) {
        /*
            r5 = this;
            r0 = r7
            r1 = 0
            if (r0 != 0) goto L_0x0036
            android.content.Context r2 = r5.getContext()
            java.lang.String r3 = "layout_inflater"
            java.lang.Object r2 = r2.getSystemService(r3)
            android.view.LayoutInflater r2 = (android.view.LayoutInflater) r2
            r3 = 2131492930(0x7f0c0042, float:1.8609326E38)
            android.view.View r0 = r2.inflate(r3, r8, r1)
            com.cuspal.interlinks.ItemArrayAdapter$ItemViewHolder r3 = new com.cuspal.interlinks.ItemArrayAdapter$ItemViewHolder
            r3.<init>()
            r4 = 2131296581(0x7f090145, float:1.8211083E38)
            android.view.View r4 = r0.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r3.name = r4
            r4 = 2131296624(0x7f090170, float:1.821117E38)
            android.view.View r4 = r0.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r3.score = r4
            r0.setTag(r3)
            goto L_0x003d
        L_0x0036:
            java.lang.Object r2 = r0.getTag()
            r3 = r2
            com.cuspal.interlinks.ItemArrayAdapter$ItemViewHolder r3 = (com.cuspal.interlinks.ItemArrayAdapter.ItemViewHolder) r3
        L_0x003d:
            java.lang.String[] r2 = r5.getItem((int) r6)
            android.widget.TextView r4 = r3.name
            r1 = r2[r1]
            r4.setText(r1)
            android.widget.TextView r1 = r3.score
            r4 = 1
            r4 = r2[r4]
            r1.setText(r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cuspal.interlinks.ItemArrayAdapter.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }
}
