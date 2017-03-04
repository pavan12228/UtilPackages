package com.example.ravinderreddy.utilpackages;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.ravinderreddy.utilpackages.util.Product;
import com.example.ravinderreddy.utilpackages.util.ResultActvity;
import com.example.ravinderreddy.utilpackages.util.Util;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<Product> products = new ArrayList<Product>();
    ListAdapter boxAdapter;

    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fillData();
        boxAdapter = new ListAdapter(this, products);

        ListView lvMain = (ListView) findViewById(R.id.listView);
        lvMain.setAdapter(boxAdapter);
    }

    void fillData() {
        for (int i = 1; i <= 20; i++) {
            products.add(new Product("Product " + i, i * 100,
                    R.mipmap.ic_launcher, false));
        }
    }

    public void showResult(View v) {
        String result = "Selected Product are :";
        List<String> productList = new ArrayList<>();
        int totalAmount=0;
        for (Product p : boxAdapter.getBox()) {
            if (p.box){
                result += "\n" + p.name;
                totalAmount+=p.price;
                productList.add(p.name);
            }
        }
        Intent mResultIntent = new Intent(this, ResultActvity.class);
        mResultIntent.putStringArrayListExtra("namesList", (ArrayList<String>) productList);
        startActivity(mResultIntent);

        Toast.makeText(this, result+"\n"+"Total Amount:="+totalAmount, Toast.LENGTH_LONG).show();
    }
}
