package edu.zsk.mikolajewicz;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;

import java.util.Objects;

public class LoggedInActivity extends AppCompatActivity {
    final String CHANNEL_ID = "2137";
    final String CHANNEL_NAME = "Zadanie podsumuwujące";
    String activeFragment;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_logged_in);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.fragmentHolder, FirstFragment.class, null)
                .commit();

        ((Button) findViewById(R.id.changeFragmentButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment();
            }
        });

        ((Button) findViewById(R.id.showNotificationButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNotification();
            }
        });
    }

    private void changeFragment() {
        if (Objects.equals(activeFragment, "first")) {
            activeFragment = "second";
            fragmentManager.beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragmentHolder, SecondFragment.class, null)
                    .commit();
        } else {
            activeFragment = "first";
            fragmentManager.beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragmentHolder, FirstFragment.class, null)
                    .commit();

        }
    }

    private void sendNotification() {
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission)
//                PackageManager.PERMISSION_GRANTED)
        requestPermissions(new String[] {Manifest.permission.} );
        Intent intent = new Intent(getApplicationContext(), NotificationActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(
                getApplicationContext(),
                0,
                intent,
                PendingIntent.FLAG_IMMUTABLE
        );
        int importance = NotificationManager.IMPORTANCE_DEFAULT;

        NotificationChannel channel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, importance);

        NotificationManager notificationManager = getApplicationContext().getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(channel);


        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Powiadomienie")
                .setContentText("Wiadomość powiadomienia")
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        notificationManager.notify(2137, builder.build());
    }

    public void openDialog() {
        AppDialogFragment adp = new AppDialogFragment();

        adp.setCancelable(true);
        fragmentManager.beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.fragmentHolder, adp, null)
                .commit();
    }
}