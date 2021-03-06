package meowfeeder.app.meow_feeder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdReceiver;
import com.google.firebase.iid.InstanceIdResult;

public class Bottom_Navigation extends AppCompatActivity {

    public FirebaseDatabase firebaseDatabase;
    public DatabaseReference databaseReference_FEED;
    private static final String TAG = "Feed_Status ";
    public ImageView feed_btn;
    public Integer value,value_refer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom__navigation);

        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "getInstanceId failed", task.getException());
                            return;
                        }

                        // Get new Instance ID token
                        String token = task.getResult().getToken();

                        // Log and toast
                        String msg = token;
                        Log.d(TAG, "Token is " + msg);
                        //sendNotificationId(msg);
                    }
                });

        /// FeedButton///
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference_FEED = firebaseDatabase.getReference("cat-auto-feeder/FEED_STATUS");

        feed_btn = (ImageView)findViewById(R.id.imageView8);

        databaseReference_FEED.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                value = dataSnapshot.getValue(Integer.class);
                Log.d(TAG, "Value is: " + value);
                if(value == 0){
                    databaseReference_FEED.setValue(0);
                    value_refer = 1;
                }else{
                    databaseReference_FEED.setValue(1);
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
                databaseReference_FEED.setValue(value_refer);
                showNotification();
            }

        });
    }

    public void showNotification() {
        String message = "Food was distributed.";

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel notificationChannel =
                    new NotificationChannel("n","n",NotificationManager.IMPORTANCE_DEFAULT);

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(notificationChannel);
        }
        Intent resultIntent = new Intent(this,Notification.class);
        resultIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent resultPendingIntent = PendingIntent.getActivity(this,
                1, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,"n")
                .setContentText("Code sphere")
                .setSmallIcon(R.drawable.appicon)
                .setAutoCancel(true)
                .setContentText(message)
                .setContentIntent(resultPendingIntent);

        resultIntent.putExtra("message",message);
        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
        managerCompat.notify(999,builder.build());

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
    public void btn_notify(View view){
        Intent intent = new Intent(this,Notification.class);
        startActivity(intent);
    }
}