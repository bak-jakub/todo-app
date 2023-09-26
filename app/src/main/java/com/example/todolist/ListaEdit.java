package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ListaEdit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actibity_edytuj);
        Button btnE = findViewById(R.id.btnE);
        EditText textID = findViewById(R.id.textIdE);
        EditText textTytul = findViewById(R.id.textTytulED);
        EditText textOpis = findViewById(R.id.textOpisED);
        Button btnPow = findViewById(R.id.btnPowE);
        DBmain db = new DBmain(this);
        btnE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = textID.getText().toString();
                String tytul = textTytul.getText().toString();
                String opis = textOpis.getText().toString();
                if(!id.isEmpty() && !tytul.isEmpty() && !opis.isEmpty()){
                    if(db.updateData(id, tytul, opis)){
                        Toast.makeText(ListaEdit.this, "Zmieniono dane", Toast.LENGTH_SHORT).show();
                    }
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