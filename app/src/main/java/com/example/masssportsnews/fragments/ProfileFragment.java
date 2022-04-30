package com.example.masssportsnews.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.masssportsnews.R;

import static com.example.masssportsnews.models.Profile.KEY_ADDRESS;
import static com.example.masssportsnews.models.Profile.KEY_EMAIL;
import static com.example.masssportsnews.models.Profile.KEY_FIRSTNAME;
import static com.example.masssportsnews.models.Profile.KEY_LASTNAME;
import static com.example.masssportsnews.models.Profile.KEY_PHONENUMBER;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.masssportsnews.models.Profile;

import com.google.android.material.button.MaterialButton;
import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;


public class ProfileFragment extends Fragment {

    public static final String TAG = "ProfileFragment";


    Button btnEditProfile;

   // List<Profile> profileList;

    TextView tvProfile;
    TextView viewFirstName;
    TextView viewLastName;
    TextView viewEmail;
    TextView viewPhoneNumber;
    TextView viewPassword;
    TextView viewAddress;
    Button btnLogout;

    public ProfileFragment()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ParseUser currentUser = ParseUser.getCurrentUser();
        //profileList = new ArrayList<>();
        tvProfile = view.findViewById(R.id.tvProfile);
        viewFirstName = view.findViewById(R.id.viewFirstName);
        viewLastName = view.findViewById(R.id.viewLastName);
        viewEmail = view.findViewById(R.id.viewEmail);
        viewPhoneNumber = view.findViewById(R.id.viewPhoneNumber);
        viewPassword = view.findViewById(R.id.viewPassword);
        viewAddress = view.findViewById(R.id.viewAddress);
        btnEditProfile = view.findViewById(R.id.btnEditProfile);
        btnLogout = view.findViewById(R.id.btnLogout);

        viewFirstName.setText("First Name: " +currentUser.get(KEY_FIRSTNAME).toString());
        viewLastName.setText("Last Name: "+currentUser.get(KEY_LASTNAME).toString());
        viewEmail.setText("Email: " + currentUser.get(KEY_EMAIL));
        viewPhoneNumber.setText("Phone Number: " + currentUser.get(KEY_PHONENUMBER).toString());
        viewAddress.setText("Address : " + currentUser.get(KEY_ADDRESS).toString());

        //queryProfile();
    }

    protected void queryProfile() {

        //ParseQuery<Profile> query = ParseQuery.getQuery(Profile.class);
        ParseUser currentUser = ParseUser.getCurrentUser();
        currentUser.getUsername();
        currentUser.getEmail();
        currentUser.get(KEY_PHONENUMBER);
        currentUser.get(KEY_ADDRESS);
        //currentUser.(KEY_FIRSTNAME, ParseUser.getCurrentUser());



        viewFirstName.setText(KEY_FIRSTNAME);
        viewLastName.setText(KEY_LASTNAME);





//        currentUser.findInBackground(new FindCallback<Profile>() {
//            @Override
//            public void done(List<Profile> profile, ParseException e) {
//                if (e != null){
//                    Log.e(TAG, "issue with profile", e);
//                    return;
//                }
//                for(Profile profile1: profile){
//                    Log.i(TAG, "Profile: " + profile1.getKeyFirstname() + ", username: " + ParseUser.getCurrentUser());
//                }
//
//
//                //   Log.i(TAG, "Profile: " + profile);
//                profileList.addAll(profile);
//
//
//            }
//
//        });




    }
}