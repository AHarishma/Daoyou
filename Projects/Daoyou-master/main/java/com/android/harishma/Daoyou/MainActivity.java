package com.android.harishma.Daoyou;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.android.harishma.Daoyou.R.layout.activity_main);

        TextView taipei = (TextView) findViewById(com.android.harishma.Daoyou.R.id.taipei);
        taipei.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent taipeiIntent = new Intent(MainActivity.this, TaipeiActivity.class);
                startActivity(taipeiIntent);
            }
        });

        TextView taichung = (TextView) findViewById(com.android.harishma.Daoyou.R.id.taichung);
        taichung.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent taichungIntent = new Intent(MainActivity.this, TaichungActivity.class);
                startActivity(taichungIntent);
            }
        });

        TextView tainan = (TextView) findViewById(com.android.harishma.Daoyou.R.id.tainan);
        tainan.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tainanIntent = new Intent(MainActivity.this, TainanActivity.class);
                startActivity(tainanIntent);
            }
        });

        TextView kaohsiung = (TextView) findViewById(com.android.harishma.Daoyou.R.id.kaohsiung);
        kaohsiung.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kaohsiungIntent = new Intent(MainActivity.this, KaohsiungActivity.class);
                startActivity(kaohsiungIntent);
            }
        });
        TextView link=(TextView)findViewById(R.id.link);
        link.setClickable(true);link.setMovementMethod(LinkMovementMethod.getInstance());
        //create a string and store the hyperlink
        String linkString="<a href=\"http://www.google.com\">To know more... Click here </a>";
        //check whether the installed android os is equal to android N
        //doing this because fromHTML() is deprecated in java 8
        // if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
        // web.setText(Html.fromHtml(linkString, Html.FROM_HTML_MODE_LEGACY));
        // else
        link.setText(Html.fromHtml(linkString));
    }
}
