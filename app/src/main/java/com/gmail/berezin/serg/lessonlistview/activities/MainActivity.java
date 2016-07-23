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

public class MainActivity extends AppCompatActivity implements ContactsArrayAdapter.MyClickListener {
    private ListView vContList;
    private ArrayList<Contact> mContacts;
    //    ArrayAdapter<Contact> mAdapter;
    //    ContactsAdapter mAdapter;
    private ContactsArrayAdapter mAdapter;
    private final static String LOG_TAG = "myLogs";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vContList = (ListView) findViewById(R.id.list_item);
        mContacts = new ArrayList<>();
        addContact();
        mAdapter = new ContactsArrayAdapter(this, mContacts, this);
        vContList.setAdapter(mAdapter);
//        vContList.setClickable(true);
        vContList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d(LOG_TAG, "itemClick: position = " + i + ", id = "
                        + l);
                Intent intent = new Intent(MainActivity.this, InfoActivity.class);
                intent.putExtra(InfoActivity.POS_NO, mContacts.get(i));
                startActivity(intent);
            }
        });

    }


    private void addContact() {
        for (int i = 0; i < 15; i++) {
            mContacts.add(new Contact());
        }
    }

    @Override
    public void clickOnCloseButton(Contact contact) {
        mContacts.remove(contact);
        mAdapter.clear();
        mAdapter.addAll(mContacts);

    }

    @Override
    public void addPhoneNumber(Contact contact) {
        if (contact.getPhoneNumber2() == null) {
            Intent intent = new Intent(MainActivity.this, AddInfoActivity.class);
            intent.putExtra(InfoActivity.POS_NO, contact);
            startActivityForResult(intent, 1);
        }
    }

    @Override
    public void removePhoneNumber(Contact contact) {
        if (contact.getPhoneNumber2() != null) {
            contact.setPhoneNumber2(null);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
