package com.example.mcu.LocationOwner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.se.omapi.Session;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.mcu.R;
import com.example.mcu.aboutus;
import com.example.mcu.login_Activity;
import com.example.mcu.sign_up_Activity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link retailer_settingfragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class retailer_settingfragment extends Fragment {
    Activity referenceActivity;
    View parentHolder;

//    Button btn_about, out ;
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
        referenceActivity = getActivity ( );
        // Inflate the layout for this fragment
        View v = inflater.inflate ( R.layout.retailer_settingfragment, container, false );
//        //Hooks
//        Button btn_about=(Button) v.findViewById (R.id.about_us  );
//        Button out=(Button) v.findViewById (R.id.log_out  );
//
//
//
//
//
//
//
//        // link from setting to log out
//        out.setOnClickListener( new View.OnClickListener ( ) {
//            @Override
//            public void onClick ( View v ) {
//                Intent intent = new Intent (new Intent(getActivity(), login_Activity.class));
//                startActivity ( intent );
//
//
//
//            }
//        } );


        return v;
    }
}