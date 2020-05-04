package sg.edu.rp.c346.ps_sgholiday;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HolidayAdapter extends ArrayAdapter<Holiday> {

    private ArrayList<Holiday> holiday;
    private Context context;
    private TextView tvHoliName, tvHoliDate;
    private ImageView holiImage;

    public HolidayAdapter(Context context, int resource, ArrayList<Holiday> objects){
        super(context, resource, objects);
        holiday = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        tvHoliName = rowView.findViewById(R.id.tvHoliName);
        tvHoliDate = rowView.findViewById(R.id.tvHoliDate);

        holiImage = rowView.findViewById(R.id.ivHoliImage);


        Holiday currentHoliday = holiday.get(position);

        tvHoliName.setText(currentHoliday.getHoliName());
        tvHoliDate.setText(currentHoliday.getDate());

        if(currentHoliday.getImageName().equals("newyear")) {

            holiImage.setImageResource(R.drawable.newyear);

        }else if(currentHoliday.getImageName().equals("cny")) {

            holiImage.setImageResource(R.drawable.cny);

        }else if(currentHoliday.getImageName().equals("labourday")) {

            holiImage.setImageResource(R.drawable.labourday);

        }else if (currentHoliday.getImageName().equals("goodfriday")){

            holiImage.setImageResource(R.drawable.goodfriday);

        }

        return rowView;
    }


}
