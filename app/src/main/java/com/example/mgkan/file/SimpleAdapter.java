package com.example.mgkan.file;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Mauve3 on 7/7/16.
 */
public class SimpleAdapter extends BaseAdapter {
    private final LayoutInflater inflater;
    private final Cursor sms;

    public SimpleAdapter(Context context, Cursor sms) {
        inflater = LayoutInflater.from(context);
        this.sms = sms;
    }

    @Override
    public int getCount() {
        return sms.getCount();
    }

    @Override
    public Object getItem(int position) {
        return sms.moveToPosition(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Log.d("SimpleAdapter: " , "Position: " + position);

        View v = convertView;
        TextView address, body, date, seen;

        if (v == null) {

            v = inflater.inflate(R.layout.list_item, parent, false);
        }

        address = (TextView) v.findViewById(R.id.address);
        body = (TextView) v.findViewById(R.id.body);
        date = (TextView) v.findViewById(R.id.date);
        seen = (TextView) v.findViewById(R.id.seen);

        sms.moveToPosition(position);

        address.setText(sms.getString(sms.getColumnIndexOrThrow("address")));
        body.setText(sms.getString(sms.getColumnIndexOrThrow("body")));
        date.setText(sms.getString(sms.getColumnIndexOrThrow("date")));
        seen.setText(sms.getString(sms.getColumnIndexOrThrow("seen")));


        return v;
    }
}
