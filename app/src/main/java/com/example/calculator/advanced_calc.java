package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class advanced_calc extends AppCompatActivity {
    TextView Res_tv;
    Button sin_bt,cos_bt,root_bt,sqr_bt;
    DatabaseReference reff,reff1;
    Member member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_calc);


        sin_bt= findViewById(R.id.sin_bt);
        cos_bt= findViewById(R.id.cos_bt);
        root_bt= findViewById(R.id.root_bt);
        sqr_bt= findViewById(R.id.sqr_bt);

        Res_tv = (TextView)findViewById(R.id.Result_tv);

        member=new Member();
        reff = FirebaseDatabase.getInstance().getReference().child("Member");

        sin_bt.setOnClickListener( new View.OnClickListener(){


            @Override
            public void onClick(View view) {
        String num1;

        num1=getIntent().getStringExtra("snum1");
        Double tmp=Double.parseDouble(num1);
        Double res=Math.sin(Double.parseDouble(num1));
        member.setData(tmp);

        reff.push().setValue(member);
        Toast.makeText(advanced_calc.this, "data inserted", Toast.LENGTH_SHORT).show();

                Res_tv.setText(String.valueOf(res));
            }
        } );

        cos_bt.setOnClickListener( new View.OnClickListener(){


            @Override
            public void onClick(View view) {
                String num1;

                num1=getIntent().getStringExtra("snum1");
                Double res=Math.cos(Double.parseDouble(num1));
                Double tmp=Double.parseDouble(num1);
                member.setData(tmp);

                reff.push().setValue(member);
                Toast.makeText(advanced_calc.this, "data inserted", Toast.LENGTH_SHORT).show();

                Res_tv.setText(String.valueOf(res));
            }
        } );


        root_bt.setOnClickListener( new View.OnClickListener(){


            @Override
            public void onClick(View view) {
                String num1;

                num1=getIntent().getStringExtra("snum1");
                Double res=Math.sqrt(Double.parseDouble(num1));
                Double tmp=Double.parseDouble(num1);
                member.setData(tmp);

                reff.push().setValue(member);
                Toast.makeText(advanced_calc.this, "data inserted", Toast.LENGTH_SHORT).show();
                Res_tv.setText(String.valueOf(res));
            }
        } );

        sqr_bt.setOnClickListener( new View.OnClickListener(){


            @Override
            public void onClick(View view) {
                String num1;

                num1=getIntent().getStringExtra("snum1");
                double num2=Double.parseDouble(num1);
                Double res=num2*num2;
                Double tmp=Double.parseDouble(num1);
                member.setData(tmp);

                reff.push().setValue(member);
                Toast.makeText(advanced_calc.this, "data inserted", Toast.LENGTH_SHORT).show();
                Res_tv.setText(String.valueOf(res));
            }
        } );


    }
}
