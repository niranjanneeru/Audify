package com.codingcrew.audify.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.codingcrew.audify.R;
import com.codingcrew.audify.activity.SignUpActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Button signUpButton, loginButton;
    TextInputLayout usernameLayout, passwordLayout;
    TextInputEditText usernameEDT, passwordEDT;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
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


        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        signUpButton = view.findViewById(R.id.profile_sign_up);
        loginButton = view.findViewById(R.id.next_button);
        usernameLayout = view.findViewById(R.id.usernameTextField);
        passwordLayout = view.findViewById(R.id.passwordTextField);
        usernameEDT = view.findViewById(R.id.usernameEditText);
        passwordEDT = view.findViewById(R.id.passwordEditText);

        loginButton.setOnClickListener(view12 -> {
            String username = usernameEDT.getText().toString();
            String password = passwordEDT.getText().toString();

            if (username.trim().isEmpty()) {
                usernameLayout.setError("Empty Credentials");
                passwordLayout.setError(null);
                return;
            }
            if (password.trim().isEmpty()) {
                usernameLayout.setError(null);
                passwordLayout.setError("Empty Credentials");
                return;
            }

            usernameLayout.setError(null);
            passwordLayout.setError(null);
        });

        signUpButton.setOnClickListener(view1 -> startActivity(new Intent(getActivity(), SignUpActivity.class)));

        return view;
    }
}