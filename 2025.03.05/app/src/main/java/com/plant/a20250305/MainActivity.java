package com.plant.a20250305;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
//        ArrayAdapter images = new ArrayAdapter(getApplicationContext(), R.layout.activity_main,
        int[] images = new int[] {
                R.drawable._b,
                R.drawable.lena,
                R.drawable.pieck,
                R.drawable.shittalkmiku_1_,
                R.drawable.vinyl_miku,
                R.drawable._bred,
                R.drawable.maomao,
                R.drawable.piecktitan,
                R.drawable.strelizia,
                R.drawable.zero,
                R.drawable.maomaohand,
                R.drawable.pink,
                R.drawable.touka,
                R.drawable.mikuteto,
                R.drawable.regina,
                R.drawable.toukaken
        };

//    );
        LinearLayout linearLayout = findViewById(R.id.scrollview);

        for (int image : images) {
            ImageButton imageButton = new ImageButton(this);
            imageButton.setImageResource(image);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    300,
                    300
            );
            imageButton.setScaleType(ImageView.ScaleType.FIT_CENTER);

            imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Dialog dialog = new Dialog(image);
                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .add(R.id.main, dialog, null)
                            .commit();

                }
            });


            params.setMargins(16, 16, 16, 16);
            imageButton.setLayoutParams(params);

            linearLayout.addView(imageButton);

        }
    }
}