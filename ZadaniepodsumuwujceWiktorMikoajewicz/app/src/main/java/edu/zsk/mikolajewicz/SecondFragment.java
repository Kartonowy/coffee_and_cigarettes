package edu.zsk.mikolajewicz;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_second, container, false);

        v.findViewById(R.id.dialogFragmentOpenButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((LoggedInActivity) getActivity().getParent()).openDialog();
            }
        });

        return v;
    }
}