package com.android.harishma.Daoyou;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        TextView india=(TextView)findViewById(R.id.Main2Activity);
        TextView china=(TextView)findViewById(R.id.MainActivity);
        india.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent india=new Intent(Start.this,Main2Activity.class);
                startActivity(india);
            }
        });
        china.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent china=new Intent(Start.this,MainActivity.class);
                startActivity(china);
            }
        });
    }
}
