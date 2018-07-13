package com.android.harishma.Daoyou;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView  kolkata = (TextView) findViewById(R.id.kolkata);
        kolkata.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kolkataIntent = new Intent(Main2Activity.this, Kolkata.class);
                startActivity(kolkataIntent);
            }
        });

        TextView chennai = (TextView) findViewById(R.id.chennai);
        chennai.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chennaiIntent = new Intent(Main2Activity.this, Chennai.class);
                startActivity(chennaiIntent);
            }
        });

        TextView mumbai = (TextView) findViewById(R.id.mumbai);
        mumbai.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mumbaiIntent = new Intent(Main2Activity.this, Mumbai.class);
                startActivity(mumbaiIntent);
            }
        });

        TextView delhi = (TextView) findViewById(R.id.delhi);
        delhi.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent delhiIntent = new Intent(Main2Activity.this, Delhi.class);
                startActivity(delhiIntent);
            }
        });
    }
}
