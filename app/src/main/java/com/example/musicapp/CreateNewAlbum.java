package com.example.musicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateNewAlbum extends AppCompatActivity {

    Button next;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_album);


        next=findViewById(R.id.btn_next);


        next.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent=new Intent(CreateNewAlbum.this,Album1.class);
                startActivity(intent);
            }
        });

    }
}