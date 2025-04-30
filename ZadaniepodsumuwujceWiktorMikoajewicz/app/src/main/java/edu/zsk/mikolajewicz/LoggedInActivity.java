package edu.zsk.mikolajewicz;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;

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
    String activeFragment = "first";
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

        (findViewById(R.id.changeFragmentButton)).setOnClickListener(v -> changeFragment());

        (findViewById(R.id.showNotificationButton)).setOnClickListener(v -> sendNotification());
    }

    private void changeFragment() {
        if (Objects.equals(activeFragment, "first")) {
            activeFragment = "second";
            fragmentManager.beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragmentHolder, SecondFragment.class, null)
                    .commit();
        } else {
            System.out.println("swapping to first");
            activeFragment = "first";
            fragmentManager.beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragmentHolder, FirstFragment.class, null)
                    .commit();

        }
    }

    private void sendNotification() {
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.POST_NOTIFICATIONS}, 1);
        }
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
        System.out.println("Opening dialog");
        AppDialogFragment adp = new AppDialogFragment();

        adp.setCancelable(true);

        adp.show(getSupportFragmentManager(), "AppDialog");

    }
}