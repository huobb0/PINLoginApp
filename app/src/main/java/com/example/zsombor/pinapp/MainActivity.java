package com.example.zsombor.pinapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button loginButton;
    private EditText pinField;
    AlertDialog.Builder builder;

    protected boolean isPinCorrect(String pin){
        return pin.equals("8646");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = (Button) findViewById(R.id.button);
        pinField = (EditText) findViewById(R.id.editText);
        final Context context = this;
        builder = new AlertDialog.Builder(context, android.R.style.Theme_Material_Dialog_Alert);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if(isPinCorrect(pinField.getText().toString())){
                    builder.setTitle("Success")
                            .setMessage("PIN correct, you are the master")
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    pinField.setText("");
                                }
                            })
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();

                } else {
                    builder.setTitle("Error")
                            .setMessage("Incorrect credentials entered")
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    pinField.setText("");
                                }
                            })
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();

                }
            }

        });
    }
}
