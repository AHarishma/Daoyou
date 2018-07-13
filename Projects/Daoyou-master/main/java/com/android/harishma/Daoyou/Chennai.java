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

public class Chennai extends AppCompatActivity {
    private ArrayList<Attraction> attractions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attraction_list);

        // Create a list of attractions
        attractions = new ArrayList<Attraction>();
        Location parthasarathyTemple = new Location(getResources().getString(R.string.chennai_attraction_name_1));
        parthasarathyTemple.setLatitude(13.053901);
        parthasarathyTemple.setLongitude(80.277017);
        attractions.add(new Attraction(getResources().getString(R.string.chennai_attraction_name_1),
                getResources().getString(R.string.chennai_attraction_phone_1),
                getResources().getString(R.string.chennai_attraction_address_1),
                getResources().getString(R.string.chennai_attraction_imageurl_1), parthasarathyTemple));

        Location fortStGeorge = new Location(getResources().getString(R.string.chennai_attraction_name_2));
        fortStGeorge.setLatitude(13.079605);
        fortStGeorge.setLongitude(80.287456);
        attractions.add(new Attraction(getResources().getString(R.string.chennai_attraction_name_2),
                getResources().getString(R.string.chennai_attraction_phone_2),
                getResources().getString(R.string.chennai_attraction_address_2),
                getResources().getString(R.string.chennai_attraction_imageurl_2), fortStGeorge));

        Location vivekanandarIllam = new Location(getResources().getString(R.string.chennai_attraction_name_3));
        vivekanandarIllam.setLatitude(13.049502);
        vivekanandarIllam.setLongitude(80.280377);
        attractions.add(new Attraction(getResources().getString(R.string.chennai_attraction_name_3),
                getResources().getString(R.string.chennai_attraction_phone_3),
                getResources().getString(R.string.chennai_attraction_address_3),
                getResources().getString(R.string.chennai_attraction_imageurl_3), vivekanandarIllam));

        Location mahabalipuram = new Location(getResources().getString(R.string.chennai_attraction_name_4));
        mahabalipuram.setLatitude(12.62645);
        mahabalipuram.setLongitude(80.192727);
        attractions.add(new Attraction(getResources().getString(R.string.chennai_attraction_name_4),
                getResources().getString(R.string.chennai_attraction_phone_4),
                getResources().getString(R.string.chennai_attraction_address_4),
                getResources().getString(R.string.chennai_attraction_imageurl_4), mahabalipuram));

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
