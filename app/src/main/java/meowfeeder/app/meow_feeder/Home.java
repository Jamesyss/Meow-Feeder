package meowfeeder.app.meow_feeder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatCallback;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import okhttp3.internal.cache.DiskLruCache;

public class Home extends Fragment {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference reff1,reff2;
    TextView textH1, textH2;
    ImageSlider imageSlider;
    ImageView b1;

    public Home() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup containr, Bundle saveInstancestate) {
        View view = inflater.inflate(R.layout.activity_main, containr, false);

        textH1 = view.findViewById(R.id.textH1);
        textH2 = view.findViewById(R.id.textH2);
        b1 = view.findViewById(R.id.add);
        imageSlider = view.findViewById(R.id.slider);
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel("https://i.pinimg.com/564x/91/e4/a1/91e4a1beb6b913ce13edfc276ad130bd.jpg"));
        slideModels.add(new SlideModel("https://i.pinimg.com/originals/41/f5/58/41f558af99ca90b1d65f4fe25087776d.jpg"));
        slideModels.add(new SlideModel("https://lovemeaw.com/wp-content/uploads/2019/09/american-shorthair-cat-768x432.jpeg"));
        slideModels.add(new SlideModel("https://petsgyan.com/wp-content/uploads/2020/05/Siamese-cat-3-660x330.jpg"));
        slideModels.add(new SlideModel("https://images.pexels.com/photos/45170/kittens-cat-cat-puppy-rush-45170.jpeg?auto=compress&cs=tinysrgb&dpr=3&h=750&w=1260"));
        imageSlider.setImageList(slideModels, true);

        firebaseDatabase = FirebaseDatabase.getInstance();

        reff1 = firebaseDatabase.getReference("History/FeedTime0");
        reff1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                    String H1 = snapshot.getValue(String.class);
                    textH1.setText(H1);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        reff2 = firebaseDatabase.getReference("History/FeedTime1");
        reff2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String H2 = snapshot.getValue(String.class);
                textH2.setText(H2);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return view;
    }

}