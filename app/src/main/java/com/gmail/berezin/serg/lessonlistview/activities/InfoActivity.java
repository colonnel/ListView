package com.gmail.berezin.serg.lessonlistview.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.gmail.berezin.serg.lessonlistview.R;
import com.gmail.berezin.serg.lessonlistview.models.Contact;


public class InfoActivity extends AppCompatActivity {
    public static final String POS_NO = "posNo";
    private ImageView vBigContactPhoto;
    private TextView vNumberInfo;
    private TextView vNameInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        vBigContactPhoto = (ImageView) findViewById(R.id.image_info);
        vNameInfo = (TextView) findViewById(R.id.name_info);
        vNumberInfo = (TextView) findViewById(R.id.phone_info);
        Contact contact = (Contact) getIntent().getExtras().getSerializable(POS_NO);
        vBigContactPhoto.setImageResource(contact.getContactPhoto());
        vNameInfo.setText(contact.getName());
        vNumberInfo.setText(contact.getPhoneNumber());
    }


}
