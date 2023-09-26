package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ListaDel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usun);
        EditText id = findViewById(R.id.textId);
        Button btnDel = findViewById(R.id.btnDel);
        Button btnPow = findViewById(R.id.btnPowU);
        DBmain db = new DBmain(this);

        btnPow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent powrot = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(powrot);
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idDelete = id.getText().toString();
                if(!id.equals("")){
                    db.deleteData(idDelete);
                }

            }
        });
    }
}