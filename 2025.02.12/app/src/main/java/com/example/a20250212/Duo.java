package com.example.a20250212;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class Duo {
    EditText[] editTexts;
    TextView out;

    public Duo(EditText uno, EditText dos, TextView out) {
        this.editTexts = new EditText[]{uno, dos};
        this.out = out;
    }

    public void setup() {
        editTexts[0].addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!editTexts[0].toString().isEmpty() && !editTexts[1].toString().isEmpty()) {
                    out.setText(String.format("Hello, %s! You'r email is: %s", editTexts[0].getText().toString(), editTexts[1].getText().toString()));
                }
            }
        });
        editTexts[1].addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!editTexts[0].toString().isEmpty() && !editTexts[1].toString().isEmpty()) {
                    out.setText(String.format("Hello, %s! You'r email is: %s", editTexts[0].getText().toString(), editTexts[1].getText().toString()));
                }
            }
        });
    }
}
