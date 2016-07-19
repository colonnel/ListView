package com.gmail.berezin.serg.lessonlistview.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_info);
        vInfoText = (TextView) findViewById(R.id.contact_info);
        vInputNumber = (EditText) findViewById(R.id.edit_number);
        vDoneButton = (Button) findViewById(R.id.button_done);
        vDoneButton.setOnClickListener(this);
        vInfoText.setText("Done!");
    }

    @Override
    public void onClick(View view) {
        if (vInputNumber != null) {
            Contact contact = (Contact) getIntent().getExtras().getSerializable(InfoActivity.POS_NO);
            contact.setPhoneNumber2(vInputNumber.getText().toString());
        }
    }
}
