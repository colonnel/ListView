package com.gmail.berezin.serg.lessonlistview.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gmail.berezin.serg.lessonlistview.R;
import com.gmail.berezin.serg.lessonlistview.activities.AddInfoActivity;
import com.gmail.berezin.serg.lessonlistview.models.Contact;

import java.util.ArrayList;


public class ContactsArrayAdapter extends ArrayAdapter {
    private Context context;
    private LayoutInflater inflater;
    private ArrayList<Contact> list;
    private CloseClickListener closeListener;

    public ContactsArrayAdapter(Context context, ArrayList<Contact> list, CloseClickListener closeListener) {
        super(context, R.layout.my_list_item, list);
        inflater = LayoutInflater.from(context);
        this.context = context;
        this.list = list;
        this.closeListener = closeListener;
    }


    View.OnClickListener closeClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Contact contact = (Contact) view.getTag();
            closeListener.clickOnCloseButton(contact);
        }
    };

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
        TextView phone = (TextView) convertView.findViewById(R.id.phone);
//        Button addButton = (Button) convertView.findViewById(R.id.button_add);
//        Button removeButton = (Button) convertView.findViewById(R.id.button_remove);
        Button buttonClose = (Button) convertView.findViewById(R.id.button_close);
        buttonClose.setOnClickListener(closeClickListener);
        buttonClose.setTag(contact);
        Glide.with(context)
                .load(contact.getContactPhoto())
                .into(photo);
        name.setText(contact.getName());
        phone.setText(contact.getPhoneNumber());

        return convertView;
    }


    public interface CloseClickListener {
        void clickOnCloseButton(Contact contact);
    }

}
