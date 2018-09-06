package com.yablonskyi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button buttonHi, buttonClear;
    EditText inputName;
    TextView myName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("Hello World");
        inputName = findViewById(R.id.inputName);
        buttonClear = findViewById(R.id.buttonClear);
        buttonHi = findViewById(R.id.buttonHi);
        myName = findViewById(R.id.myname);
    }

    public void clearMessage(View view) {
        inputName.getText().clear();
    }

    public void showMessage(View view) {
        myName.setText("Hello" + " " + inputName.getText().toString());
        inputName.getText().clear();
    }
}
