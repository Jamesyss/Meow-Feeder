package meowfeeder.app.meow_feeder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatCallback;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class Home extends Fragment {

    ImageSlider imageSlider;

    ImageView b1;

    public Home() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup containr, Bundle saveInstancestate) {
        View view = inflater.inflate(R.layout.activity_main, containr, false);

        b1 = view.findViewById(R.id.add);
        imageSlider = view.findViewById(R.id.slider);
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel("https://i.pinimg.com/564x/91/e4/a1/91e4a1beb6b913ce13edfc276ad130bd.jpg"));
        slideModels.add(new SlideModel("https://i.pinimg.com/originals/41/f5/58/41f558af99ca90b1d65f4fe25087776d.jpg"));
        slideModels.add(new SlideModel("https://lovemeaw.com/wp-content/uploads/2019/09/american-shorthair-cat-768x432.jpeg"));
        slideModels.add(new SlideModel("https://petsgyan.com/wp-content/uploads/2020/05/Siamese-cat-3-660x330.jpg"));
        slideModels.add(new SlideModel("https://images.pexels.com/photos/45170/kittens-cat-cat-puppy-rush-45170.jpeg?auto=compress&cs=tinysrgb&dpr=3&h=750&w=1260"));
        imageSlider.setImageList(slideModels, true);

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