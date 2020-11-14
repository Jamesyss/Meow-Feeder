package meowfeeder.app.meow_feeder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class notification extends Fragment {
    public notification(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup containr, Bundle saveInstancestate){
        View view = inflater.inflate(R.layout.activity_notification,containr,false);

        TextView textView = view.findViewById(R.id.text_view);
        
        String message = getActivity().getIntent().getStringExtra("message");
        textView.setText(message);
        
        return view;
    }

}