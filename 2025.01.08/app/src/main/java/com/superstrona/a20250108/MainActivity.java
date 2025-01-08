package com.superstrona.a20250108;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    String Sspecies = "Kot";

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

        String[] species = {"Pies", "Kot", "Świnka morska"};

        ListView list = (ListView) findViewById(R.id.species);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                R.layout.row, R.id.row,  species);

        list.setAdapter(adapter);

        SeekBar bar = findViewById(R.id.seekbar);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String species = parent.getItemAtPosition(position).toString().trim();
                switch (species) {
                    case "Pies":
                        bar.setMax(18);
                        Sspecies = "Pies";
                        break;
                    case "Kota":
                        bar.setMax(20);
                        Sspecies = "Kot";
                        break;
                    case "Świnka morska":
                        bar.setMax(9);
                        Sspecies = "Świnka morska";
                        break;
                    default:
                        break;
                }
            }
        });

        var prog = (TextView) findViewById(R.id.prog);
        bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                prog.setText(Integer.toString(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        NotificationManager nm;
        nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        NotificationChannel channel = new NotificationChannel("chan", "channel", NotificationManager.IMPORTANCE_DEFAULT);

        nm.createNotificationChannel(channel);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "chan")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Wizyta")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);


        var out = (TextView) findViewById(R.id.out);
        ((Button) findViewById(R.id.submit)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = ((EditText) findViewById(R.id.name)).getText().toString();
                String species = Sspecies;
                String age = prog.getText().toString();
                String purpose = ((EditText) findViewById(R.id.purpose)).getText().toString();
                String time = ((EditText) findViewById(R.id.time)).getText().toString();

                String response = String.format("%s, %s, %s, %s, %s", name, species, age, purpose, time);

                out.setText(response);

                builder.setContentText(response);

                nm.notify(0, builder.build());
            }
        });
    }
}