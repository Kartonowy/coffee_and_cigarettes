package com.plant.a20250305;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Dialog extends DialogFragment {
    int imageId;
    public Dialog(int imageId) {
        this.imageId = imageId;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_DeviceDefault);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_dialog, container, false);
        ImageButton ib = v.findViewById(R.id.mainimage);
        ib.setImageResource(imageId);
        Dialog current_frag = this;
        ib.setScaleType(ImageView.ScaleType.FIT_CENTER);
        // Watch for button clicks.
        ib.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().remove(current_frag).commit();
            }
        });

        return v;
    }

}