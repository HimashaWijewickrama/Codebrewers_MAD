package com.example.musicapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Album1 extends AppCompatActivity {

    EditText trackName,txttrack,txtart,txtdes;
    Button adds,update,delete,view;
    DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album1);

        trackName=findViewById(R.id.trackName);
        txttrack=findViewById(R.id.txttrack);
        txtart=findViewById(R.id.txtart);
        txtdes=findViewById(R.id.txtdes);
        adds = findViewById(R.id.btn_adds);
        update=findViewById(R.id.btn_update);
        view=findViewById(R.id.btn_view);
        delete=findViewById(R.id.btn_delete);
        DB=new DBHelper(this);
        //set add button

        adds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String trackNameTXT=trackName.getText().toString();
                String txttrackTXT=txttrack.getText().toString();
                String txtartTXT=txtart.getText().toString();
                String txtdesTXT=txtdes.getText().toString();

                Boolean checkinsertdata=DB.inserttrackdata(trackNameTXT,txttrackTXT,txtartTXT,txtdesTXT);
                if(checkinsertdata==true)
                    Toast.makeText(Album1.this,"Track is added successfully",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Album1.this,"Track is already exists",Toast.LENGTH_SHORT).show();
            }
        });

        //set update button

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String trackNameTXT=trackName.getText().toString();
                String txttrackTXT=txttrack.getText().toString();
                String txtartTXT=txtart.getText().toString();
                String txtdesTXT=txtdes.getText().toString();

                Boolean checkupdatedata=DB.updatetrackdata(trackNameTXT,txttrackTXT,txtartTXT,txtdesTXT);
                if(checkupdatedata==true)
                    Toast.makeText(Album1.this,"Track details are updated",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Album1.this,"Track details are not updated",Toast.LENGTH_SHORT).show();
            }
        });
        //set delete button /delete listener

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String trackNameTXT=trackName.getText().toString();


                Boolean checkdeletedata=DB.deletedata(trackNameTXT);
                if(checkdeletedata==true)
                    Toast.makeText(Album1.this,"Track is deleted successfully",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Album1.this,"Track is not deleted",Toast.LENGTH_SHORT).show();
            }
        });

        //set view button
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res=DB.getdata();
                if(res.getCount()==0){
                    Toast.makeText(Album1.this, "No track is exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer=new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Track ID: "+res.getString(0)+"\n");
                    buffer.append("Track Title: "+res.getString(1)+"\n");
                    buffer.append("Artists: "+res.getString(2)+"\n");
                    buffer.append("Description: "+res.getString(3)+"\n\n");

                }
                //show the alert message with all the values in table had stored
                AlertDialog.Builder builder=new AlertDialog.Builder(Album1.this);
                builder.setCancelable(true);
                builder.setTitle("Track Entries");
                builder.setMessage(buffer.toString());
                builder.show();

            }
        });








    }
}