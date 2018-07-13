package com.android.harishma.Daoyou;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class Data2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data2);
        TextView name=(TextView)findViewById(R.id.name);
        name.setText(getIntent().getExtras().getString("userName"));
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Data2.this,Start.class);
                startActivity(i);
            }
        });
    }
}
