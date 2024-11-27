package com.superstrona.a20241127;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.regex.Pattern;

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

        Button submit = (Button) findViewById(R.id.send);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //‒ Po wybraniu przycisku ZATWIERDŹ jest sprawdzane:
                //‒ Czy e-mail zawiera znak @.
                //‒ Czy podane hasło jest równe powtórzonemu hasłu.
                //‒ W obszarze do wyświetlania komunikatów pojawia się napis:
                //‒ Na początku działania aplikacji: „Autor”, dalej wstawiony numer PESEL zdającego.
                //‒ Po zatwierdzeniu, gdy e-mail jest niepoprawny: „Nieprawidłowy adres e-mail”.
                //‒ Po zatwierdzeniu, gdy hasła się różnią: „Hasła się różnią”.
                //‒ Po zatwierdzeniu, gdy nie wystąpiły błędy: „Witaj <e-mail>”, gdzie <e-mail> oznacza aktualnie
                //wprowadzony adres e-mail.

                EditText email = (EditText) findViewById(R.id.email);
                EditText pass = (EditText) findViewById(R.id.pass);
                EditText repass = (EditText) findViewById(R.id.reppass);
                TextView out = (TextView) findViewById(R.id.out);

                out.append(getResources().getString(R.string.pesel));
                out.append("/n");

                if (!email.getText().toString().contains("@")) {
                    out.append(getResources().getString(R.string.invalid_email));
                    out.append("/n");
                    return;
                }

                Pattern regex = Pattern.compile("(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)[A-Za-z\\d]{8,}");
                if (!regex.matcher(pass.getText().toString()).matches()) {
                    out.append("Witaj " + email.getText());
                    out.append("/n");
                    return;
                }
                if (!pass.getText().toString().equals(repass.getText().toString())) {
                    out.append(getResources().getString(R.string.invalid_pass));
                    out.append("/n");
                    return;
                }

                Intent i = new Intent(getApplicationContext(), New_Activity.class);
                i.putExtra("email", email.getText().toString());

                startActivity(i);
            }
        });
    }

}
