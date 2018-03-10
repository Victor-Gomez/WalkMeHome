package com.example.juanp.walkmehome.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.widget.EditText;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.content.SharedPreferences.Editor;
//import android.app.Fragment;

import com.example.juanp.walkmehome.R;
import com.example.juanp.walkmehome.activities.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class WelcomeFragment extends Fragment implements OnClickListener {

    public String safePIN = "";
    public String unsafePIN = "";
    EditText input_pin_safe;
    EditText input_pin_unsafe;
    static SharedPreferences preferences;
    static SharedPreferences.Editor editor;

    public WelcomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_welcome, container, false);

        View v = inflater.inflate(R.layout.fragment_welcome, container, false);

        Button b = (Button) v.findViewById(R.id.saveSettingsButton);
        b.setOnClickListener(this);

        input_pin_safe    = (EditText)v.findViewById(R.id.input_pin_safe_text);
        input_pin_unsafe  = (EditText)v.findViewById(R.id.input_pin_risk_text);

        preferences = this.getActivity().getSharedPreferences("pref", getContext().MODE_PRIVATE);
        editor = preferences.edit();
        input_pin_safe.setText(preferences.getString("safepin", null));
        input_pin_unsafe.setText(preferences.getString("unsafepin", null));

        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.saveSettingsButton:
                Toast.makeText(getContext(), "Configuración guardada", Toast.LENGTH_LONG).show();
                safePIN = input_pin_safe.getText().toString();
                unsafePIN = input_pin_unsafe.getText().toString();
                editor.putString("safepin", safePIN);
                editor.putString("unsafepin", unsafePIN);
                editor.apply();
                //Toast.makeText(getContext(), email, Toast.LENGTH_LONG).show();
                break;
        }
    }

}
