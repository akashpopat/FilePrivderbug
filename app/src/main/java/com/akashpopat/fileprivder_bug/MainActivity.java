package com.akashpopat.fileprivder_bug;

import android.net.Uri;
import android.os.Environment;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Uri uri = FileProvider.getUriForFile(MainActivity.this,
                            getApplicationContext().getPackageName() + ".provider",
                            Environment.getExternalStorageDirectory());
                }catch (Exception e){
                    e.printStackTrace();
                    new AlertDialog.Builder(MainActivity.this)
                            .setMessage(e.toString())
                            .show();
                }
            }
        });
    }
}
