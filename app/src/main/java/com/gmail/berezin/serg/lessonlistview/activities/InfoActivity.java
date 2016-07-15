package com.gmail.berezin.serg.lessonlistview.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.gmail.berezin.serg.lessonlistview.R;
import com.gmail.berezin.serg.lessonlistview.models.Contact;


public class InfoActivity extends Activity {
    public static final String POS_NO = "posNo";
    private ImageView vBigContactPhoto;
    private TextView vNumberInfo;
    private TextView vNameInfo;
    private Button vCloseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        vBigContactPhoto = (ImageView) findViewById(R.id.image_info);
        vNameInfo = (TextView) findViewById(R.id.name_info);
        vNumberInfo = (TextView) findViewById(R.id.phone_info);
        int position = (int) getIntent().getExtras().get(POS_NO);
        Contact contact = MainActivity.mContacts.get(position);
        vBigContactPhoto.setImageResource(contact.getContactPhoto());
        vNameInfo.setText(contact.getName());
        vNumberInfo.setText(contact.getPhoneNumber());
    }


}
