package com.example.todolist;

import static com.example.todolist.DBmain.TABLENAME;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ListaAdd extends AppCompatActivity {
    Button btnPow;
    Button btnAdd;
    EditText textTytul;
    EditText textOpis;
    EditText textData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodaj);
        btnPow = findViewById(R.id.btnPow);
        btnAdd = findViewById(R.id.btnAdd);
        textTytul = findViewById(R.id.textTytul);
        textOpis = findViewById(R.id.textOpis);
        textData = findViewById(R.id.textData);
        DBmain db = new DBmain(this);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String tytul = textTytul.getText().toString();
               String opis = textOpis.getText().toString();
               String data = textData.getText().toString();
               if(!tytul.equals("") && !opis.equals("") && !data.equals("") && db.insertData(tytul,opis,data)){
                   Toast.makeText(ListaAdd.this, "Dodano do bazy", Toast.LENGTH_SHORT).show();
               }
            }
        });
        btnPow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent powrot = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(powrot);
            }
        });

    }
}