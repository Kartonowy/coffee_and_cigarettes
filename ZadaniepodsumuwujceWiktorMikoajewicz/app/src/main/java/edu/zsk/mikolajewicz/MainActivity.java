package edu.zsk.mikolajewicz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import edu.zsk.mikolajewicz.database.Database;
import edu.zsk.mikolajewicz.database.User;
import edu.zsk.mikolajewicz.utils.CredentialsCallback;

public class MainActivity extends AppCompatActivity {

    private Database db;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

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

        initDb();


        Button loginButton = (Button) findViewById(R.id.loginButton);
        EditText emailInput = (EditText)findViewById(R.id.emailinput);
        EditText passwordInput = (EditText)findViewById(R.id.passwordinput);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailInput.getText().toString();
                String password = passwordInput.getText().toString();
                if (email.isBlank() || password.isBlank()) {
                    Toast.makeText(getApplicationContext(), "Wypełnij wszystkie pola!", Toast.LENGTH_LONG).show();
                    return;
                }
                checkCredentials(email, password, isValid -> {
                    runOnUiThread(() -> {
                        if (isValid) {
                            Toast.makeText(getApplicationContext(), "Zalogowano!", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(getApplicationContext(), LoggedInActivity.class);
                            startActivity(i);
                        } else {
                            Toast.makeText(getApplicationContext(), "Niepoprawne dane logowania!", Toast.LENGTH_LONG).show();
                            passwordInput.setText("");
                        }
                    });
                });
            }
        });
    }

    private void initDb() {
        //TODO
        db = Room.databaseBuilder(getApplicationContext(), Database.class, "users-db")
                .allowMainThreadQueries()
                .build();

        executor.execute(() -> {
            if (db.userDao().getUserCount() == 0) {
                db.userDao().insert(new User("admin@example.com", "admin"));
                db.userDao().insert(new User("user1@example.com", "user1"));
                db.userDao().insert(new User("user2@example.com", "user2"));
                db.userDao().insert(new User("user3@example.com", "user3"));
            }
        });
    }

    private void checkCredentials(String email, String password, CredentialsCallback callback) {
        executor.execute(() -> {
            User user = db.userDao().getUserByEmail(email);
            boolean isValid = user != null && user.password.equals(password);
            callback.onResult(isValid);
        });
    }
}