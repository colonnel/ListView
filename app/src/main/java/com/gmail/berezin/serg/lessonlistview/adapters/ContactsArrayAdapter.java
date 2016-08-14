package com.gmail.berezin.serg.lessonlistview.adapters;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gmail.berezin.serg.lessonlistview.R;
import com.gmail.berezin.serg.lessonlistview.models.Contact;

import java.util.ArrayList;


public class ContactsArrayAdapter extends ArrayAdapter {
    private Context context;
    private LayoutInflater inflater;
    private ArrayList<Contact> list;
    private MyClickListener myClickListener;


    public ContactsArrayAdapter(Context context, ArrayList<Contact> list, MyClickListener myClickListener) {
        super(context, R.layout.my_list_item, list);
        inflater = LayoutInflater.from(context);
        this.context = context;
        this.list = list;
        this.myClickListener = myClickListener;

    }

    static class ViewHolder {
        protected ImageView photo;
        protected TextView name;
        protected TextView phone;
        protected TextView phone2;
        protected ImageView buttonClose;
    }

    View.OnClickListener MyClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Contact contact = (Contact) view.getTag();
            switch (view.getId()) {
                case R.id.button_close:
                    myClickListener.clickOnCloseButton(contact);
                    break;
                case R.id.button_add:
                    myClickListener.addPhoneNumber(contact);
                    break;
                case R.id.button_remove:
                    myClickListener.removePhoneNumber(contact);
            }

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
        final ViewHolder viewHolder=new ViewHolder();
        viewHolder.photo = (ImageView) convertView.findViewById(R.id.image);
        viewHolder.name = (TextView) convertView.findViewById(R.id.name);
        viewHolder.phone = (TextView) convertView.findViewById(R.id.phone);
        viewHolder.phone2 = (TextView) convertView.findViewById(R.id.phone_2);
        if (!TextUtils.isEmpty(contact.getPhoneNumber2())) {
            viewHolder.phone2.setText(contact.getPhoneNumber2().toString());
        }
        viewHolder.buttonClose = (ImageView) convertView.findViewById(R.id.button_close);
        viewHolder.buttonClose.setOnClickListener(MyClickListener);
        viewHolder.buttonClose.setTag(contact);
        Button addButton = (Button) convertView.findViewById(R.id.button_add);
        Button removeButton = (Button) convertView.findViewById(R.id.button_remove);
        addButton.setTag(contact);
        addButton.setOnClickListener(MyClickListener);
        removeButton.setTag(contact);
        removeButton.setOnClickListener(MyClickListener);
        if (contact.getPhoneNumber2() != null) {
            addButton.setEnabled(false);
            removeButton.setEnabled(true);
        } else {
            addButton.setEnabled(true);
            removeButton.setEnabled(true);
        }

        Glide.with(context)
                .load(contact.getContactPhoto())
                .into(viewHolder.photo);
        viewHolder.name.setText(contact.getName());
        viewHolder.phone.setText(contact.getPhoneNumber());

        return convertView;
    }


    public interface MyClickListener {
        void clickOnCloseButton(Contact contact);

        void addPhoneNumber(Contact contact);

        void removePhoneNumber(Contact contact);
    }


}
