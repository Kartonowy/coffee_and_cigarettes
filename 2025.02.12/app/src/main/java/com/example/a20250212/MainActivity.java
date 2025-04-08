package com.example.a20250212;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    int counter;

    EditText name;
    EditText email;

    Button bat;
    TextView txt1;
    TextView txt2;

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

        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.mail);

        bat = (Button) findViewById(R.id.raise);
        txt1 = (TextView) findViewById(R.id.txt1);
        txt2 = (TextView) findViewById(R.id.txt2);
        counter = 0;
        System.out.println("Counter reseted:");
        System.out.println(counter);
        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt("counter");
            System.out.println("Counter restored:");
            System.out.println(counter);
            name.setText(savedInstanceState.getString("name"));
            email.setText(savedInstanceState.getString("email"));
            txt2.setText(String.format("String clicked %d amount of times", counter));
        }

        bat.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {
                if (name.getText().toString().isEmpty() || email.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "something empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                txt2.setText(String.format("String clicked %d amount of times", ++counter));
                System.out.println(counter);
            }
        });

        Duo duo = new Duo(name, email, txt1);
        duo.setup();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt("counter", counter);
        System.out.println("Counter stored:");
        System.out.println(counter);
        outState.putString("name", name.getText().toString());
        outState.putString("email", email.getText().toString());
        super.onSaveInstanceState(outState);
    }
}