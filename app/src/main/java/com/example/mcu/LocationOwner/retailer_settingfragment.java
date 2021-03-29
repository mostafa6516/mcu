package com.example.mcu.LocationOwner;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.se.omapi.Session;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import com.example.mcu.R;
import com.example.mcu.login_Activity;
import com.google.android.material.switchmaterial.SwitchMaterial;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link retailer_settingfragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class retailer_settingfragment extends Fragment {
    Activity referenceActivity;
    View parentHolder;
    SwitchMaterial the_dark ;

    Button btn_about, out ;
    private Session session;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public retailer_settingfragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment retailer_profileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static retailer_settingfragment newInstance(String param1, String param2) {
        retailer_settingfragment fragment = new retailer_settingfragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        referenceActivity = getActivity();
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.retailer_settingfragment, container, false);




           


        return v;
    }
    @Override
    public void onViewCreated ( @NonNull View view, @Nullable Bundle savedInstanceState ) {
        super.onViewCreated(view, savedInstanceState);

        the_dark =view.findViewById(R.id.the_dark);



        // the switch theme
        the_dark.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked)
                savetheme(true);
            else
                savetheme(false);

        });

        view.findViewById(R.id.language).setOnClickListener ( v -> {
            showAlertLanguage();

        } );


    }

    private void showAlertLanguage() {

        AlertDialog alert = new AlertDialog.Builder(getActivity()).create();
        alert.setCancelable(false);
        View view=LayoutInflater.from(getActivity()).inflate(R.layout.layout_language,null);
        alert.setView(view);
        ImageView cancel_lang =view.findViewById(R.id.cancel_lang);
        cancel_lang.setOnClickListener(v -> {
            alert.dismiss();
        });
        RadioButton lang_en = view.findViewById(R.id.lang_en);
        RadioButton lang_ar = view.findViewById(R.id.lang_ar);
        view.findViewById(R.id.save_language).setOnClickListener(v -> {


        });

        alert.show();
    }
    void  saveLanguage() {

    }


    void savetheme(boolean b) {
        getSharedPreferences ( "theme")
                .edit ( )
                .putBoolean ( "themeSelected", b )
                .apply ( );

        if(b) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }else
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

    }

    private SharedPreferences getSharedPreferences(String theme) {
        return null;
    }


}
