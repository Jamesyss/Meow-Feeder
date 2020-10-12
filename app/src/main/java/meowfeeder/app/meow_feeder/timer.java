package meowfeeder.app.meow_feeder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class timer extends AppCompatActivity {
    private ImageView button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        button = (ImageView) findViewById(R.id.home);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openhome();
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
    public void openhome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void opentimer() {
        Intent intent = new Intent(this, timer.class);
        startActivity(intent);
    }
}