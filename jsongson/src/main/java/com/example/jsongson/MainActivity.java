package com.example.jsongson;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String mStringJson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.gson).setOnClickListener(this);

//        获取到String串的json
        getStringJson();

        try {
//            JsonObject是gson类中的.
            JSONObject jsonObject = new JSONObject(mStringJson);

            /**
             * get类型
             * 源码:如果存在或者是可以被强制装成int类型的,否则抛出异常
             * 无论怎么着至少不会产生creash,已经做了处理,抛出了异常
             */
//            基本类型
            int rank = jsonObject.getInt("rank");
            String rankString = jsonObject.getString("rankString");
//            集合
            JSONArray staffs = jsonObject.getJSONArray("staffs");

            /**
             * 源码:如果存在或者是可以被强制装成int类型的,否则返回0
             * 无论怎么着至少不会产生creash,最多是0了
             */
//            基本类型
            int rank1 = jsonObject.optInt("rank1");
            String rankString1 = jsonObject.optString("rankString");
//            集合
            JSONArray staffs1 = jsonObject.optJSONArray("staffs");

            /**
             * 如果有mapping值,返回true,但不保证其值是不是null
             */
            jsonObject.has("rank");
            /**
             * 返回true,如果没有mapping或者其值为null
             */
            jsonObject.isNull("rank");
            /**
             * 添加和删除
             */
            jsonObject.put("rankFromJava", "null");
            jsonObject.remove("rank1");

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    private void getStringJson() {
        InputStreamReader summaryIsr;
        try {
            summaryIsr = new InputStreamReader(getAssets().open("summaryjson"), "UTF-8");

            BufferedReader summaryBr = new BufferedReader(summaryIsr);

            String summayLine;
            StringBuilder summaryBuilder = new StringBuilder();
            while ((summayLine = summaryBr.readLine()) != null) {
                summaryBuilder.append(summayLine);
            }

            summaryBr.close();
            summaryIsr.close();

            mStringJson = summaryBuilder.toString();
        } catch (Exception e) {
            /*IO or jsonException*/
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.gson:
                startActivity(new Intent(this, GsonActivity.class));
                break;
        }
    }
}
