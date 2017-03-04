package com.example.ravinderreddy.utilpackages.util;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.ravinderreddy.utilpackages.R;

import java.util.ArrayList;

public class ResultActvity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_actvity);
        ArrayList<String> stringArrayList = getIntent().getStringArrayListExtra("namesList");
        Log.d("Lokesh",stringArrayList.toString()+" sample value::"+stringArrayList.get(0));
    }
}
