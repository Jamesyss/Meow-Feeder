package meowfeeder.app.meow_feeder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class MainActivity extends Fragment {

    ImageView b1;

    public MainActivity() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup containr, Bundle saveInstancestate) {
        View view = inflater.inflate(R.layout.activity_main, containr, false);

        b1 = view.findViewById(R.id.add);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fragment = new connect();
                FragmentTransaction fmt = getFragmentManager().beginTransaction();
                fmt.replace(R.id.main_fragment, fragment);
                fmt.commit();
            }
        });
        return view;
    }
}