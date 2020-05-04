package sg.edu.rp.c346.ps_sgholiday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvTypes;
    ArrayList holiCate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvTypes = findViewById(R.id.lvTypesHoli);

        holiCate = new ArrayList<String>();
        holiCate.add("Secular");
        holiCate.add("Ethnic & Religion");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, holiCate );

        lvTypes.setAdapter(arrayAdapter);

        lvTypes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(getBaseContext(), SecondActivity.class);
                String selectedFromList = (String) lvTypes.getItemAtPosition(i);
                Log.i("TAG", "onItemClick: lmao " + selectedFromList);
                intent.putExtra("Holi Type", selectedFromList);
                startActivity(intent);

            }
        });

    }
}
