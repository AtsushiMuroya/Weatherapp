package sorajirocom.android.wetherapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FivedaysActivity extends AppCompatActivity {
    ListView listView;
    ArrayAdapter adapter;
    double lat;
    double lon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fivedays);
        listView = (ListView)findViewById(R.id.listView);
        adapter = new ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1);
        listView.setAdapter(adapter);

        Intent intent = getIntent();
        lat = intent.getDoubleExtra("Lat",0);
        lon = intent.getDoubleExtra("Lon",0);
    }
}
