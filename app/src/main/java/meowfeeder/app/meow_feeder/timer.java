package meowfeeder.app.meow_feeder;


import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class timer extends Fragment {

    public timer(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup containr,Bundle saveInstancestate){
        View view = inflater.inflate(R.layout.activity_timer,containr,false);



        return view;
    }
}