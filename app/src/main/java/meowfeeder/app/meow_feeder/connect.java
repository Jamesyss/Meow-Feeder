package meowfeeder.app.meow_feeder;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class connect extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup containr, @Nullable Bundle saveInstancestate){
        return inflater.inflate(R.layout.activity_connect,containr,false)
                ;}
}