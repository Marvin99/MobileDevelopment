package com.yablonskyi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

public class MainActivity extends AppCompatActivity {

    public Button buttonSubmit;
    public EditText inputFirstName;
    public EditText inputLastName;
    public EditText inputPhone;
    public EditText inputEmail;
    public EditText inputPassword;
    public EditText inputConfirm;
    public AwesomeValidation inputValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputValidation = new AwesomeValidation(ValidationStyle.BASIC);
        setupUI();
        validateUI();
        checkUI();
    }

    private void setupUI() {
        inputFirstName = findViewById(R.id.inputFirstName);
        inputLastName = findViewById(R.id.inputLastName);


        inputEmail = findViewById(R.id.inputEmail);
        inputEmail.setInputType(InputType.TYPE_CLASS_TEXT |
                InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);

        inputPhone = findViewById(R.id.inputPhone);
        inputPassword = findViewById(R.id.inputPassword);
        inputConfirm = findViewById(R.id.inputConfirm);
        buttonSubmit = findViewById(R.id.buttonSubmit);
    }


    private void validateUI() {
        String regexPassword = "(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d])(?=.*[~`!@#\\$%\\^&\\*\\(\\)\\-_"
                + "\\+=\\{\\}\\[\\]\\|\\;:\"<>,./\\?]).{8,}";
        inputValidation.addValidation(MainActivity.this, R.id.inputFirstName,
                "[a-zA-Z\\s]+", R.string.inputFirstName);
        inputValidation.addValidation(MainActivity.this, R.id.inputLastName,
                "[a-zA-Z\\s]+", R.string.inputLastName);
        inputValidation.addValidation(MainActivity.this, R.id.inputEmail,
                Patterns.EMAIL_ADDRESS, R.string.inputEmail);
        inputValidation.addValidation(MainActivity.this, R.id.inputPhone,
                RegexTemplate.TELEPHONE, R.string.inputPhone);
        inputValidation.addValidation(MainActivity.this, R.id.inputPassword,
                regexPassword, R.string.inputPassword);
        inputValidation.addValidation(MainActivity.this, R.id.inputConfirm,
                R.id.inputPassword, R.string.inputConfirmation);

    }




    private void checkUI() {
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String message = inputValidation.validate()
                        ? "Data Received Succesfully"
                        : "Error";

                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
