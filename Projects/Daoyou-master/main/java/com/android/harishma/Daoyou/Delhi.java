package com.android.harishma.Daoyou;

import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Delhi extends AppCompatActivity {
    private ArrayList<Attraction> attractions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attraction_list);

        // Create a list of attractions
        attractions = new ArrayList<Attraction>();
       /* Location delhiMainPublicLibrary = new Location(getResources().getString(R.string.delhi_attraction_name_1));
        delhiMainPublicLibrary.setLatitude(22.61023);
        delhiMainPublicLibrary.setLongitude(120.30174);
        attractions.add(new Attraction(getResources().getString(R.string.delhi_attraction_name_1),
                getResources().getString(R.string.delhi_attraction_phone_1), getResources().getString(R.string.delhi_attraction_address_1),
                getResources().getString(R.string.delhi_attraction_imageurl_1), delhiMainPublicLibrary));*/

        //India gate
        Location indiaGate = new Location(getResources().getString(R.string.delhi_attraction_name_2));
        indiaGate.setLatitude(28.615736);
        indiaGate.setLongitude(77.228992);
        attractions.add(new Attraction(getResources().getString(R.string.delhi_attraction_name_2),
                getResources().getString(R.string.delhi_attraction_phone_2)
                , getResources().getString(R.string.delhi_attraction_address_2),
                getResources().getString(R.string.delhi_attraction_imageurl_2), indiaGate));

        //Qutubminar
        Location qutubMinar = new Location(getResources().getString(R.string.delhi_attraction_name_3));
        qutubMinar.setLatitude(28.524426);
        qutubMinar.setLongitude(77.185448);
        attractions.add(new Attraction(getResources().getString(R.string.delhi_attraction_name_3),
                getResources().getString(R.string.delhi_attraction_phone_3),
                getResources().getString(R.string.delhi_attraction_address_3),
                getResources().getString(R.string.delhi_attraction_imageurl_3), qutubMinar));

        //Taj mahal
        Location tajMahal = new Location(getResources().getString(R.string.delhi_attraction_name_4));
        tajMahal.setLatitude(27.175032);
        tajMahal.setLongitude(78.042168);
        attractions.add(new Attraction(getResources().getString(R.string.delhi_attraction_name_4),
                getResources().getString(R.string.delhi_attraction_phone_4),
                getResources().getString(R.string.delhi_attraction_address_4),
                getResources().getString(R.string.delhi_attraction_imageurl_4), tajMahal));

        //Lotus Temple
        Location lotusTemple = new Location(getResources().getString(R.string.delhi_attraction_name_5));
        lotusTemple.setLatitude(28.553503);
        lotusTemple.setLongitude(77.258823);
        attractions.add(new Attraction(getResources().getString(R.string.delhi_attraction_name_5),
                getResources().getString(R.string.delhi_attraction_phone_5),
                getResources().getString(R.string.delhi_attraction_address_5),
                getResources().getString(R.string.delhi_attraction_imageurl_5), lotusTemple));

        AttractionAdapter adapter = new AttractionAdapter(this, attractions);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                double lat = attractions.get(position).getLocation().getLatitude();
                Log.d("lat", ""+lat);
                double lon = attractions.get(position).getLocation().getLongitude();
                Log.d("lon", ""+lon);
                String keyword = attractions.get(position).getAttractionName();
                Uri uri = Uri.parse("geo:" + lat + "," + lon + "?q=" + Uri.encode(keyword));

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent);
            }
        });
    }
}
