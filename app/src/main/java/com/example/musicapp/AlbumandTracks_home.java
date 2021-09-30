package com.example.musicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AlbumandTracks_home extends AppCompatActivity {
    Button btn_create;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albumand_tracks_home);
        btn_create=findViewById(R.id.btn_create);
        btn_create.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent=new Intent(AlbumandTracks_home.this,CreateNewAlbum.class);
                startActivity(intent);
            }
        });

    }
}