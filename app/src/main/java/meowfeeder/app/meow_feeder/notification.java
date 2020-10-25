package meowfeeder.app.meow_feeder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class notification extends Fragment {
    public notification(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup containr, Bundle saveInstancestate){
        View view = inflater.inflate(R.layout.activity_notification,containr,false);



        return view;
    }
}