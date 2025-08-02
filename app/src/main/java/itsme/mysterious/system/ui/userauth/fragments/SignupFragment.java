package itsme.mysterious.system.ui.userauth.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import itsme.mysterious.system.MainActivity;
import itsme.mysterious.system.R;
public class SignupFragment extends Fragment {

    private EditText etName, etEmail, etPassword, etConfirmPassword, etPin, etConfirmPin;
    private Button btnSignup;
    private TextView tvLogin;

    private FirebaseAuth mAuth;
    private FirebaseFirestore db;

    public SignupFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.signup, container, false);

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        etName = view.findViewById(R.id.et_name);
        etEmail = view.findViewById(R.id.et_email);
        etPassword = view.findViewById(R.id.et_password);
        etConfirmPassword = view.findViewById(R.id.et_confirm_password);
        etPin = view.findViewById(R.id.et_pin);
        etConfirmPin = view.findViewById(R.id.et_confirm_pin);
        btnSignup = view.findViewById(R.id.btn_signup);
        tvLogin = view.findViewById(R.id.tv_login);

        btnSignup.setOnClickListener(v -> handleSignup());

        tvLogin.setOnClickListener(v -> {
            // Replace this fragment with LoginFragment
            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, new LoginFragment());
            transaction.commit();
        });

        return view;
    }

    private void handleSignup() {
        String name = etName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        String confirmPassword = etConfirmPassword.getText().toString().trim();
        String pin = etPin.getText().toString().trim();
        String confirmPin = etConfirmPin.getText().toString().trim();

        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || pin.isEmpty()) {
            Toast.makeText(getContext(), "All fields are required", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!password.equals(confirmPassword)) {
            Toast.makeText(getContext(), "Passwords do not match", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!pin.equals(confirmPin)) {
            Toast.makeText(getContext(), "PINs do not match", Toast.LENGTH_SHORT).show();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnSuccessListener(authResult -> {
                    String uid = mAuth.getCurrentUser().getUid();
                    Map<String, Object> user = new HashMap<>();
                    user.put("username", name);
                    user.put("email", email);
                    user.put("pin", pin);
                    user.put("uid", uid);

                    db.collection("users").document(uid).set(user)
                            .addOnSuccessListener(unused -> {
                                Toast.makeText(getContext(), "Registered!", Toast.LENGTH_SHORT).show();
                                startAuthActivity();
                            });
                })
                .addOnFailureListener(e ->
                        Toast.makeText(getContext(), "Signup failed: " + e.getMessage(), Toast.LENGTH_SHORT).show());
    }

    private void startAuthActivity() {
        Intent intent = new Intent(getContext(), MainActivity.class);
        startActivity(intent);
        requireActivity().finish();
    }
}
