package sg.edu.rp.c346.ps_sgholiday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ListView lvHoli;
    TextView tvHoliCat;
    ArrayAdapter aa;
    ArrayList<Holiday> holiday1, holiday2;

    String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lvHoli = findViewById(R.id.lvHoliday);
        tvHoliCat = findViewById(R.id.tvHoliCat);

        holiday1 = new ArrayList<Holiday>();
        holiday2 = new ArrayList<Holiday>();

        Holiday ny = new Holiday("Secular", "New Year's Day", "1 Jan 2017", "newyear");
        holiday1.add(ny);
        Holiday ld = new Holiday("Secular", "Labour Day", "1 May 2017", "labourday");
        holiday1.add(ld);
        Holiday cny = new Holiday("Ethnic & Religion", "Chinese New Year", "28 - 29 Jan 2017", "cny");
        holiday1.add(cny);
        Holiday gf = new Holiday("Ethnic & Religion", "Good Friday", "14 April 2017", "goodfriday");
        holiday1.add(gf);

        //holiday1.add(new Holiday("Secular", "New Year's Day", "1 Jan 2017", "newyear"));
        //holiday1.add(new Holiday("Secular", "Labour Day", "1 May 2017", "labourday"));
        //holiday2.add(new Holiday("Ethnic and Religion", "Chinese New Year", "28 - 29 Jan 2017", "cny"));
        //holiday2.add(new Holiday("Ethnic and Religion", "Good Friday", "14 April 2017", "goodfriday"));

        Intent i = getIntent();
        category = i.getStringExtra("Holi Type");
        tvHoliCat.setText(category);

        for (int c = 0; c < holiday1.size(); c++){
            if(holiday1.get(c).getCategory().equals(category)){
                holiday2.add(holiday1.get(c));
            }
        }

        //if(category.equals("Secular")){
        //    aa = new HolidayAdapter(this, R.layout.row, holiday1);
        //}else if(category.equals("Ethnic & Religion")){
        //    aa = new HolidayAdapter(this, R.layout.row, holiday2);
        //}

        aa = new HolidayAdapter(this, R.layout.row, holiday2);
        lvHoli.setAdapter(aa);

        lvHoli.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //if(category.equals("Secular")){
                //    Holiday selectedHoliday = holiday1.get(position);

                //    Toast.makeText(SecondActivity.this, selectedHoliday.getHoliName() + ", Date: " + selectedHoliday.getDate(), Toast.LENGTH_LONG).show();
                //}else{
                //    Holiday selectedHoliday = holiday2.get(position);

                //    Toast.makeText(SecondActivity.this, selectedHoliday.getHoliName() + ", Date: " + selectedHoliday.getDate(), Toast.LENGTH_LONG).show();

                //}

                Holiday selectedHoliday = holiday2.get(position);

                Toast.makeText(SecondActivity.this, selectedHoliday.getHoliName() + ", Date: " + selectedHoliday.getDate(), Toast.LENGTH_LONG).show();

            }
        });

    }
}
