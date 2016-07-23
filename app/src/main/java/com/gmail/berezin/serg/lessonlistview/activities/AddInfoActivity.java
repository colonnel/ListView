package com.gmail.berezin.serg.lessonlistview.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.gmail.berezin.serg.lessonlistview.R;
import com.gmail.berezin.serg.lessonlistview.models.Contact;


public class AddInfoActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView vInfoText;
    private EditText vInputNumber;
    private Button vDoneButton;
    private Contact contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_info);
        vInfoText = (TextView) findViewById(R.id.contact_info);
        vInputNumber = (EditText) findViewById(R.id.edit_number);
        vDoneButton = (Button) findViewById(R.id.button_done);
        vDoneButton.setOnClickListener(this);
        contact = (Contact) getIntent().getExtras().getSerializable(InfoActivity.POS_NO);
        vInfoText.setText(contact.getName());

    }

    @Override
    public void onClick(View view) {
        if (!TextUtils.isEmpty(vInputNumber.getText().toString())) {
            Intent intent = new Intent();
            contact.setPhoneNumber2(vInputNumber.getText().toString());
            vInfoText.setText("Done!");
            intent.putExtra("contact", contact.getPhoneNumber2().toString());
            setResult(RESULT_OK, intent);
            finish();
        }
    }

}
