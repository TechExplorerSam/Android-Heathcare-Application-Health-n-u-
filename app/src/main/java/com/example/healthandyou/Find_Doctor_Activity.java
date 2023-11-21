package com.example.healthandyou;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Find_Doctor_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);
        CardView exit=findViewById(R.id.cardBack);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Find_Doctor_Activity.this, HOMEACTIVITY.class));

            }
        });

        CardView familyPhysician=findViewById(R.id.cardFDFamilyPhysician);
        familyPhysician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(Find_Doctor_Activity.this,Doctordetailsactivity.class);
                it.putExtra("title","Familyphysician");
               startActivity(it);
            }
        });

        CardView dietician=findViewById(R.id.cardFDDietician);
        dietician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(Find_Doctor_Activity.this,Doctordetailsactivity.class);
                it.putExtra("title","Dietician");
                startActivity(it);
            }
        });
        CardView Dentist=findViewById(R.id.cardFDDentist);
        Dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(Find_Doctor_Activity.this,Doctordetailsactivity.class);
                it.putExtra("title","Dentist");
                startActivity(it);
            }
        });
        CardView Surgeon=findViewById(R.id.cardFDSurgeon);
        Surgeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(Find_Doctor_Activity.this,Doctordetailsactivity.class);
                it.putExtra("title","Surgeon");
                startActivity(it);
            }
        });
        CardView Cardiologist=findViewById(R.id.cardFDCardiologists);
        Cardiologist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(Find_Doctor_Activity.this,Doctordetailsactivity.class);
                it.putExtra("title","Cardiologist");
                startActivity(it);
            }
        });


    }
}