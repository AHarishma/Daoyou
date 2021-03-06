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

public class Kolkata extends AppCompatActivity {
    private ArrayList<Attraction> attractions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attraction_list);

        // Create a list of attractions
        attractions = new ArrayList<Attraction>();

        //Howrah Bridge
        Location howrahBridge = new Location(getResources().getString(R.string.kolkata_attraction_name_1));
        howrahBridge.setLatitude(22.585152);
        howrahBridge.setLongitude(88.346808);
        attractions.add(new Attraction(getResources().getString(R.string.kolkata_attraction_name_1),
                getResources().getString(R.string.kolkata_attraction_phone_1),
                getResources().getString(R.string.kolkata_attraction_address_1),
                getResources().getString(R.string.kolkata_attraction_imageurl_1), howrahBridge));

        //Victoria Memorial
        Location victoriaMemorial = new Location(getResources().getString(R.string.kolkata_attraction_name_2));
        victoriaMemorial.setLatitude(22.544960);
        victoriaMemorial.setLongitude(88.342471);
        attractions.add(new Attraction(getResources().getString(R.string.kolkata_attraction_name_2),
                getResources().getString(R.string.kolkata_attraction_phone_2),
                getResources().getString(R.string.kolkata_attraction_address_2),
                getResources().getString(R.string.kolkata_attraction_imageurl_2),
                victoriaMemorial));

        // Dhakshineshwar Kali Temple
        Location dhakshineshwarKaliTemple = new Location(getResources().getString(R.string.kolkata_attraction_name_3));
        dhakshineshwarKaliTemple.setLatitude(22.654898);
        dhakshineshwarKaliTemple.setLongitude(88.357518);
        attractions.add(new Attraction(getResources().getString(R.string.kolkata_attraction_name_3),
                getResources().getString(R.string.kolkata_attraction_phone_3),
                getResources().getString(R.string.kolkata_attraction_address_3),
                getResources().getString(R.string.kolkata_attraction_imageurl_3),
                dhakshineshwarKaliTemple));

        //Park Street
        Location parkStreet = new Location(getResources().getString(R.string.kolkata_attraction_name_4));
        parkStreet.setLatitude(22.548110);
        parkStreet.setLongitude(88.359095);
        attractions.add(new Attraction(getResources().getString(R.string.kolkata_attraction_name_4),
                getResources().getString(R.string.kolkata_attraction_phone_4),
                getResources().getString(R.string.kolkata_attraction_address_4),
                getResources().getString(R.string.kolkata_attraction_imageurl_4),
                parkStreet));

        /*Location nationalPalaceMuseum = new Location(getResources().getString(R.string.kolkata_attraction_name_5));
        nationalPalaceMuseum.setLatitude(25.10236);
        nationalPalaceMuseum.setLongitude(121.54849);
        attractions.add(new Attraction(getResources().getString(R.string.kolkata_attraction_name_5),
                getResources().getString(R.string.kolkata_attraction_phone_5), getResources().getString(R.string.kolkata_attraction_address_5),
                getResources().getString(R.string.kolkata_attraction_imageurl_5), nationalPalaceMuseum));*/

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
