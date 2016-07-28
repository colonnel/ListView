package com.gmail.berezin.serg.lessonlistview.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.gmail.berezin.serg.lessonlistview.R;
import com.gmail.berezin.serg.lessonlistview.models.Contact;


public class AddInfoActivity extends AppCompatActivity implements View.OnClickListener {
    public static final int REQUEST_CODE_ADD_INFO_ACTIVITY = 1;
    public static final String CONTACT_FOR_ADD_SECOND_MBN = "CONTACT_FOR_ADD_SECOND_MBN";
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
        contact = (Contact) getIntent().getExtras().getSerializable(CONTACT_FOR_ADD_SECOND_MBN);
        vInfoText.setText(contact.getName());

    }

    @Override
    public void onClick(View view) {
        String newNumber = vInputNumber.getText().toString();
        if (!TextUtils.isEmpty(newNumber)) {
            Intent intent = new Intent();
            contact.setPhoneNumber2(newNumber);
            Toast.makeText(AddInfoActivity.this, "Done!", Toast.LENGTH_SHORT).show();
            intent.putExtra(MainActivity.NEW_MBN_FOR_CONTACT_RECEIVED, contact);
            setResult(RESULT_OK, intent);
            finish();
        }
    }

}
