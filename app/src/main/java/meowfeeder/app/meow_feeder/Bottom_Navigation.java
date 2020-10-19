package meowfeeder.app.meow_feeder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Timer;

public class Bottom_Navigation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom__navigation);

    }
    public void btn_home(View view){
        Fragment fragment;
        fragment = new MainActivity();
        FragmentManager fmg = getSupportFragmentManager();
        FragmentTransaction fmt = fmg.beginTransaction();
        fmt.replace(R.id.main_fragment,fragment);
        fmt.commit();
    }
    public void btn_timer(View view){
        Fragment fragment;
        fragment = new timer();
        FragmentManager fmg = getSupportFragmentManager();
        FragmentTransaction fmt = fmg.beginTransaction();
        fmt.replace(R.id.main_fragment,fragment);
        fmt.commit();
    }

}