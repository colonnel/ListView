package com.gmail.berezin.serg.lessonlistview.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gmail.berezin.serg.lessonlistview.R;
import com.gmail.berezin.serg.lessonlistview.models.Contact;

import java.util.ArrayList;


public class ContactsAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private ArrayList<Contact> list;

    public ContactsAdapter(Context context, ArrayList<Contact> list) {
        inflater = LayoutInflater.from(context);
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
        convertView = inflater.inflate(R.layout.my_list_item, parent, false);
        ImageView photo = (ImageView) convertView.findViewById(R.id.image);
        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView phoneNumber = (TextView) convertView.findViewById(R.id.phone);
        Log.e("TAG", "photo res =" + contact.getContactPhoto());

        photo.setImageResource(contact.getContactPhoto());
        name.setText(contact.getName());
        phoneNumber.setText(contact.getPhoneNumber());
        return convertView;
    }
}
