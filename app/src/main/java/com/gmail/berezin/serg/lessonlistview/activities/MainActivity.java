package com.gmail.berezin.serg.lessonlistview.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.gmail.berezin.serg.lessonlistview.R;
import com.gmail.berezin.serg.lessonlistview.adapters.ContactsArrayAdapter;
import com.gmail.berezin.serg.lessonlistview.models.Contact;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView vContList;
    static ArrayList<Contact> mContacts;
    //    ArrayAdapter<Contact> mAdapter;
    //    ContactsAdapter mAdapter;
    private ContactsArrayAdapter mAdapter;
    private final static String LOG_TAG = "myLogs";


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
//        View header = getLayoutInflater().inflate(R.layout.header, null);
//        vContList.addHeaderView(header);
//        vContList.addFooterView(header);
        vContList.setAdapter(mAdapter);
        vContList.setClickable(true);
        vContList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d(LOG_TAG, "itemClick: position = " + i + ", id = "
                        + l);
                Intent intent = new Intent(MainActivity.this, InfoActivity.class);
                intent.putExtra(InfoActivity.POS_NO, i);
                startActivity(intent);
            }
        });
    }

    private void addContact() {
        for (int i = 0; i < 15; i++) {
            mContacts.add(new Contact());
        }
    }
}
