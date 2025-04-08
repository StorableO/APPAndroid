package com.example.listviewpr;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyListAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final int[] obrazki;
    private final String[] opisy;

    public MyListAdapter(Context context, int[] obrazki, String[] opisy) {
        super(context, R.layout.moja_lista, opisy);
        this.context = context;
        this.obrazki = obrazki;
        this.opisy = opisy;
    }

    private static class ViewHolder {
        ImageView imageView;
        TextView textView1;
        TextView textView2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Walidacja danych wejściowych
        if (obrazki == null || opisy == null || position < 0 || position >= obrazki.length) {
            return convertView != null ? convertView :
                    LayoutInflater.from(context).inflate(R.layout.moja_lista, parent, false);
        }

        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.moja_lista, parent, false);
            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.imageView);
            holder.textView1 = convertView.findViewById(R.id.textView1);
            holder.textView2 = convertView.findViewById(R.id.textView2);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        try {
            holder.imageView.setImageResource(obrazki[position]);
            holder.textView1.setText(opisy[position]);
            holder.textView2.setText("To jest " + opisy[position]);
        } catch (Resources.NotFoundException e) {
            holder.textView1.setText("Błąd ładowania");
        }

        return convertView;
    }
}