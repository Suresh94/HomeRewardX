package com.kryptoblocks.homerewardx;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {


    protected static ArrayList<String> getDataList(int dataSize) {
        ArrayList<String> dataList = new ArrayList<>();
        for (int i = 1; i <= dataSize; i++) {
            dataList.add("Product" + i);

        }
        return dataList;
    }

    protected void startNewActivity(Class<Activity> activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }
}