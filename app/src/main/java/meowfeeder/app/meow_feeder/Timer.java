package meowfeeder.app.meow_feeder;


import androidx.fragment.app.Fragment;

import android.app.TimePickerDialog;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class Timer extends Fragment  {

    TextView textView1,textView2,textView3,textView4;
    int t1hour,t1Minute,t2hour,t2Minute,t3hour,t3Minute,t4hour,t4Minute;

    public Timer(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup containr, Bundle saveInstancestate) {
        View view = inflater.inflate(R.layout.activity_timer, containr, false);

        textView1 = view.findViewById(R.id.textView1);
        textView2 = view.findViewById(R.id.textView2);
        textView3 = view.findViewById(R.id.textView3);
        //textView4 = view.findViewById(R.id.textView4);

        textView1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TimePickerDialog timePickerDialog = new TimePickerDialog(
                        getActivity(),
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                                t1hour = hourOfDay;
                                t1Minute = minute;

                                Calendar calendar = Calendar.getInstance();
                                calendar.set(0, 0, 0, t1hour, t1Minute);
                                textView1.setText(DateFormat.format("hh:mm aa", calendar));
                            }
                        }, 12, 0, false
                );

                timePickerDialog.updateTime(t1hour,t1Minute);
                timePickerDialog.show();
            }
        });

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        getActivity(),
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                                t2hour = hourOfDay;
                                t2Minute = minute;

                                Calendar calendar = Calendar.getInstance();
                                calendar.set(0, 0, 0, t2hour, t2Minute);
                                textView2.setText(DateFormat.format("hh:mm aa", calendar));
                            }
                        }, 12, 0, false
                );

                timePickerDialog.updateTime(t2hour,t2Minute);
                timePickerDialog.show();
            }
        });

        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        getActivity(),
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                                t3hour = hourOfDay;
                                t3Minute = minute;

                                Calendar calendar = Calendar.getInstance();
                                calendar.set(0, 0, 0, t3hour, t3Minute);
                                textView3.setText(DateFormat.format("hh:mm aa", calendar));
                            }
                        }, 12, 0, false
                );

                timePickerDialog.updateTime(t3hour,t3Minute);
                timePickerDialog.show();
            }
        });

        return view;
    }

}