package com.example.lostandfoundapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class NewAdvert extends AppCompatActivity {
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_advert);
        db = new DatabaseHelper(this);

        Button save = findViewById(R.id.buttonsave);
        EditText name = findViewById(R.id.editTextname);
        EditText phone = findViewById(R.id.editTextphone);
        EditText desc = findViewById(R.id.editTextDescription);
        EditText Date = findViewById(R.id.editTextDate);
        EditText loc = findViewById(R.id.editTextLocation);
        RadioButton radiolost= findViewById(R.id.radioButtonLost);
        RadioButton radiofound= findViewById(R.id.radioButtonFound);



        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name = name.getText().toString();
                String Phone = phone.getText().toString();
                String descr = desc.getText().toString();
                String date = Date.getText().toString();
                String Loc = loc.getText().toString();

                if (radiolost.isChecked()) {
                    Boolean checkinsertdata = db.savedatalost(Name, Phone, descr, date, Loc);
                    if (checkinsertdata)
                        Toast.makeText(NewAdvert.this, "New Lost Entry Inserted", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(NewAdvert.this, "New Lost Entry Not Inserted", Toast.LENGTH_SHORT).show();
                } else if (radiofound.isChecked()) {
                    Boolean checkinsertdata = db.savedatafound(Name, Phone, descr, date, Loc);
                    if (checkinsertdata)
                        Toast.makeText(NewAdvert.this, "New Found Entry Inserted", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(NewAdvert.this, "New Found Entry Not Inserted", Toast.LENGTH_SHORT).show();
                }
            } });





    }
}

