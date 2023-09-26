package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lista;
    Button btnDodaj;
    Button btnEdytuj;
    Button btnUsun;
   ArrayList<String> listItem;




    DBmain db = new DBmain(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listItem = new ArrayList<>();
        lista = findViewById(R.id.lista);

        viewData();

        btnDodaj = findViewById(R.id.btnDodaj);
        btnEdytuj = findViewById(R.id.btnEytuj);
        btnUsun = findViewById(R.id.btnUsun);
        btnDodaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dodaj = new Intent(getApplicationContext(), ListaAdd.class);
                startActivity(dodaj);
            }
        });
        btnEdytuj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent edytuj = new Intent(getApplicationContext(), ListaEdit.class);
                startActivity(edytuj);
            }
        });
        btnUsun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent usun = new Intent(getApplicationContext(), ListaDel.class);
                startActivity(usun);
            }
        });

    }
    public void viewData(){
        Cursor cursor = db.viewData();
        if(cursor.getCount() == 0){
            Toast.makeText(MainActivity.this, "Nie ma żadnych informacji", Toast.LENGTH_SHORT).show();
        } else{
            while (cursor.moveToNext()){
                listItem.add("ID:"+cursor.getString(0)+" Tytul:"+cursor.getString(1)+" Opis:"+cursor.getString(2)+" Data rozpoczecia:"+cursor.getString(3));
            }
            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listItem);
            lista.setAdapter(adapter);
        }
    }
}
