package com.android.harishma.Daoyou;

import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class Mumbai extends AppCompatActivity {
    private ArrayList<Attraction> attractions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attraction_list);

        // Create a list of attractions
        attractions = new ArrayList<Attraction>();
        Location gateOfIndia = new Location(getResources().getString(R.string.mumbai_attraction_name_1));
        gateOfIndia.setLatitude(18.922262);
        gateOfIndia.setLongitude(72.834604);
        attractions.add(new Attraction(getResources().getString(R.string.mumbai_attraction_name_1),
                getResources().getString(R.string.mumbai_attraction_phone_1),
                getResources().getString(R.string.mumbai_attraction_address_1),
                getResources().getString(R.string.mumbai_attraction_imageurl_1),
                gateOfIndia));

        Location elephantCaves = new Location(getResources().getString(R.string.mumbai_attraction_name_2));
        elephantCaves.setLatitude(18.970513);
        elephantCaves.setLongitude(72.935562);
        attractions.add(new Attraction(getResources().getString(R.string.mumbai_attraction_name_2),
                getResources().getString(R.string.mumbai_attraction_phone_2),
                getResources().getString(R.string.mumbai_attraction_address_2),
                getResources().getString(R.string.mumbai_attraction_imageurl_2), elephantCaves));

        Location chhatrapatiShivajiMaharajVastuSangrahalaya = new Location(getResources().getString(R.string.mumbai_attraction_name_3));
        chhatrapatiShivajiMaharajVastuSangrahalaya.setLatitude(18.927098);
        chhatrapatiShivajiMaharajVastuSangrahalaya.setLongitude(72.832594);
        attractions.add(new Attraction(getResources().getString(R.string.mumbai_attraction_name_3),
                getResources().getString(R.string.mumbai_attraction_phone_3),
                getResources().getString(R.string.mumbai_attraction_address_3),
                getResources().getString(R.string.mumbai_attraction_imageurl_3), chhatrapatiShivajiMaharajVastuSangrahalaya));

        Location globalVipassanaPagoda = new Location(getResources().getString(R.string.mumbai_attraction_name_4));
        globalVipassanaPagoda.setLatitude(19.228464);
        globalVipassanaPagoda.setLongitude(72805906);
        attractions.add(new Attraction(getResources().getString(R.string.mumbai_attraction_name_4),
                getResources().getString(R.string.mumbai_attraction_phone_4),
                getResources().getString(R.string.mumbai_attraction_address_4),
                getResources().getString(R.string.mumbai_attraction_imageurl_4), globalVipassanaPagoda));

       /* Location confuciusTemple = new Location(getResources().getString(R.string.mumbai_attraction_name_5));
        confuciusTemple.setLatitude(22.99311);
        confuciusTemple.setLongitude(120.20496);
        attractions.add(new Attraction(getResources().getString(R.string.mumbai_attraction_name_5),
                getResources().getString(R.string.mumbai
                mumbai_attraction_phone_5), getResources().getString(R.string.mumbai_attraction_address_5),
                getResources().getString(R.string.mumbai_attraction_imageurl_5), confuciusTemple));*/

        AttractionAdapter adapter = new AttractionAdapter(this, attractions);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                double lat = attractions.get(position).getLocation().getLatitude();
                double lon = attractions.get(position).getLocation().getLongitude();
                String keyword = attractions.get(position).getAttractionName();
                Uri uri = Uri.parse("geo:" + lat + "," + lon + "?q=" + Uri.encode(keyword));

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent);
            }
        });
    }
}
