package meowfeeder.app.meow_feeder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (ImageView) findViewById(R.id.plus);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openconnect();
            }
        });
        button = (ImageView) findViewById(R.id.timer);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opentimer();
            }
        });
    }
    public void openconnect() {
        Intent intent = new Intent(this, connect.class);
        startActivity(intent);
    }
    public void opentimer() {
        Intent intent = new Intent(this, timer.class);
        startActivity(intent);
    }
}