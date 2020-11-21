package meowfeeder.app.meow_feeder;


import androidx.annotation.NonNull;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;

import android.app.TimePickerDialog;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.TimePicker;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

public class
Timer extends Fragment  {

    public FirebaseDatabase firebaseDatabase;
    public DatabaseReference databaseReference_Timer1,databaseReference_Timer2,databaseReference_Timer3,databaseReference_Timer4;
    TextView textView1,textView2,textView3,textView4;
    int t1hour,t1Minute,t2hour,t2Minute,t3hour,t3Minute,t4hour,t4Minute;
    SwitchCompat sw1,sw2,sw3,sw4;
    String t1,t2,t3,t4;

    public Timer(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup containr, Bundle saveInstancestate) {
        View view = inflater.inflate(R.layout.activity_timer, containr, false);

        textView1 = view.findViewById(R.id.textView1);
        textView2 = view.findViewById(R.id.textView2);
        textView3 = view.findViewById(R.id.textView3);
        textView4 = view.findViewById(R.id.textView4);
        sw1 = view.findViewById(R.id.swCustom1);
        sw2 = view.findViewById(R.id.swCustom2);
        sw3 = view.findViewById(R.id.swCustom3);
        sw4 = view.findViewById(R.id.swCustom4);

        firebaseDatabase = FirebaseDatabase.getInstance();

        databaseReference_Timer1 = firebaseDatabase.getReference("Timer/Timer_1");
        databaseReference_Timer1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                t1 = snapshot.getValue(String.class);
                if (t1.equals("Disable")) {
                    sw1.setChecked(false);
                } else {
                    sw1.setChecked(true);
                }
                textView1.setText(t1);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        databaseReference_Timer2 = firebaseDatabase.getReference("Timer/Timer_2");
        databaseReference_Timer2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                t2 = snapshot.getValue(String.class);
                if (t2.equals("Disable")) {
                    sw2.setChecked(false);
                } else {
                    sw2.setChecked(true);
                }
                textView2.setText(t2);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        databaseReference_Timer3 = firebaseDatabase.getReference("Timer/Timer_3");
        databaseReference_Timer3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                t3 = snapshot.getValue(String.class);
                if (t3.equals("Disable")) {
                    sw3.setChecked(false);
                } else {
                    sw3.setChecked(true);
                }
                textView3.setText(t3);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        databaseReference_Timer4 = firebaseDatabase.getReference("Timer/Timer_4");
        databaseReference_Timer4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                t4 = snapshot.getValue(String.class);
                if (t4.equals("Disable")) {
                    sw4.setChecked(false);
                } else {
                    sw4.setChecked(true);
                }
                textView4.setText(t4);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

/////////////////---1---///////////////
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
                                textView1.setText(DateFormat.format("HH:mm", calendar));
                            }
                        }, 24, 0, true

                );
                timePickerDialog.updateTime(t1hour,t1Minute);
                timePickerDialog.show();
            }
        });
        sw1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sw1.isChecked()){
                    String timer1 = textView1.getText().toString();
                    FirebaseDatabase.getInstance().getReference().child("Timer").child("Timer_1").setValue(timer1);
                }else{
                    FirebaseDatabase.getInstance().getReference().child("Timer").child("Timer_1").setValue("Disable");

                }
            }
        });

/////////////////---2---///////////////

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
                                textView2.setText(DateFormat.format("HH:mm", calendar));
                            }
                        }, 24, 0, true
                );

                timePickerDialog.updateTime(t2hour,t2Minute);
                timePickerDialog.show();
            }
        });
        sw2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sw2.isChecked()){
                    String timer2 = textView2.getText().toString();
                    FirebaseDatabase.getInstance().getReference().child("Timer").child("Timer_2").setValue(timer2);
                }else{
                    FirebaseDatabase.getInstance().getReference().child("Timer").child("Timer_2").setValue("Disable");
                }
            }
        });

/////////////////---3---///////////////

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
                                textView3.setText(DateFormat.format("HH:mm", calendar));
                            }
                        }, 24, 0, true
                );

                timePickerDialog.updateTime(t3hour,t3Minute);
                timePickerDialog.show();
            }
        });
        sw3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sw3.isChecked()){
                    String timer3 = textView3.getText().toString();
                    FirebaseDatabase.getInstance().getReference().child("Timer").child("Timer_3").setValue(timer3);
                }else{
                    FirebaseDatabase.getInstance().getReference().child("Timer").child("Timer_3").setValue("Disable");
                }
            }
        });

/////////////////---4---///////////////

        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        getActivity(),
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                                t4hour = hourOfDay;
                                t4Minute = minute;

                                Calendar calendar = Calendar.getInstance();
                                calendar.set(0, 0, 0, t4hour, t4Minute);
                                textView4.setText(DateFormat.format("HH:mm", calendar));
                            }
                        }, 24, 0, true
                );

                timePickerDialog.updateTime(t4hour,t4Minute);
                timePickerDialog.show();
            }
        });
        sw4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sw4.isChecked()){
                    String timer4 = textView4.getText().toString();
                    FirebaseDatabase.getInstance().getReference().child("Timer").child("Timer_4").setValue(timer4);
                }else{
                    FirebaseDatabase.getInstance().getReference().child("Timer").child("Timer_4").setValue("Disable");
                }
            }
        });
        return view;
    }

}