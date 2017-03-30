package com.example.amir.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner=(Spinner)findViewById(R.id.spinner);
        ArrayAdapter adapter=ArrayAdapter.createFromResource(this,R.array.intents,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void tester(View view)
    {
        int position=spinner.getSelectedItemPosition();
        Intent intent=null;
        switch (position) {
            case 0:
                intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:999999"));
                break;
            case 1:
                intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:999999"));
                break;
        }
        if(intent.resolveActivity(getPackageManager()) != null)
        {
            startActivity(intent);
        }



    }
}
