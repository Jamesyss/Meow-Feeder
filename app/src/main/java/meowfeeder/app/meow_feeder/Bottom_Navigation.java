package meowfeeder.app.meow_feeder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Bottom_Navigation extends AppCompatActivity {

    public FirebaseDatabase firebaseDatabase;
    public DatabaseReference databaseReference_LED;
    private static final String TAG = "LEDS Control";
    public ImageView feed_btn;
    public Integer value,value_refer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom__navigation);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference_LED = firebaseDatabase.getReference("cat-auto-feeder/LED_STATUS");

        feed_btn = (ImageView)findViewById(R.id.imageView8);

        databaseReference_LED.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                value = dataSnapshot.getValue(Integer.class);
                Log.d(TAG, "Value is: " + value);
                if(value == 0){
                    databaseReference_LED.setValue(0);
                    value_refer = 1;
                }else{
                    databaseReference_LED.setValue(1);
                    value_refer = 0;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        feed_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference_LED.setValue(value_refer);
            }
        });


    }
    public void btn_home(View view){
        Fragment fragment;
        fragment = new Home();
        FragmentManager fmg = getSupportFragmentManager();
        FragmentTransaction fmt = fmg.beginTransaction();
        fmt.replace(R.id.main_fragment,fragment);
        fmt.commit();
    }
    public void btn_timer(View view){
        Fragment fragment;
        fragment = new Timer();
        FragmentManager fmg = getSupportFragmentManager();
        FragmentTransaction fmt = fmg.beginTransaction();
        fmt.replace(R.id.main_fragment,fragment);
        fmt.commit();
    }

}