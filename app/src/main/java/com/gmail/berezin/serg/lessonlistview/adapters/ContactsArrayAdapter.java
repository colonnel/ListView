package com.gmail.berezin.serg.lessonlistview.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gmail.berezin.serg.lessonlistview.R;
import com.gmail.berezin.serg.lessonlistview.models.Contact;

import java.util.ArrayList;


public class ContactsArrayAdapter extends ArrayAdapter {
    private Context context;
    private LayoutInflater inflater;
    private int layoutResourceId;
    private ArrayList<Contact> list;

    public ContactsArrayAdapter(Context context, int layoutResourceId, ArrayList<Contact> list) {
        super(context, layoutResourceId, list);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Contact contact = (Contact) getItem(position);
        inflater = ((Activity)context).getLayoutInflater();
        convertView = inflater.inflate(R.layout.my_list_item, parent, false);
        ImageView photo = (ImageView) convertView.findViewById(R.id.image);
        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView phone = (TextView) convertView.findViewById(R.id.phone);
        photo.setImageResource(contact.getContactPhoto());
        name.setText(contact.getName());
        phone.setText(contact.getPhoneNumber());

        return convertView;
    }
}
