package com.gmail.berezin.serg.lessonlistview.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.gmail.berezin.serg.lessonlistview.adapters.ContactsAdapter;
import com.gmail.berezin.serg.lessonlistview.adapters.ContactsArrayAdapter;
import com.gmail.berezin.serg.lessonlistview.models.Contact;
import com.gmail.berezin.serg.lessonlistview.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView vContList;
    //    ImageView vContPhoto;
    ArrayList<Contact> mContacts;
    //    ArrayAdapter<Contact> mAdapter;
//    ContactsAdapter mAdapter;
    ContactsArrayAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vContList = (ListView) findViewById(R.id.list_item);
//        vContPhoto = (ImageView) findViewById(R.id.image);
        mContacts = new ArrayList<>();
        addContact();
//        mAdapter = new ContactsAdapter(this, mContacts);
//        mAdapter = new ArrayAdapter<Contact>(this, android.R.layout.simple_list_item_1, mContacts);
        mAdapter = new ContactsArrayAdapter(this, mContacts);
        View header = getLayoutInflater().inflate(R.layout.header,null);
        vContList.addHeaderView(header);
        vContList.addFooterView(header);
        vContList.setAdapter(mAdapter);

    }

    private void addContact() {
        for (int i = 0; i < 15; i++) {
            mContacts.add(new Contact());
        }
    }
}
