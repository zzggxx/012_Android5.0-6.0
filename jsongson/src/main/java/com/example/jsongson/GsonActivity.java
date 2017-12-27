package com.example.jsongson;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GsonActivity extends AppCompatActivity {

    private String mStringJson;
    private Gson mGson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gson);

        //        获取到String串的json
        getStringJson();

        /**
         * 对象和String串的转化,最常见的方式
         */
        mGson = new Gson();
        SummaryBean summaryBean = mGson.fromJson(mStringJson, SummaryBean.class);
        String s = mGson.toJson(summaryBean);

        /**
         * 使用字段的方法
         */
//        json字符串成JsonObject.
        JsonObject jsonObject = new JsonParser().parse(mStringJson).getAsJsonObject();
        int rank = jsonObject.get("rank").getAsInt();
        JsonArray staffs = jsonObject.get("staffs").getAsJsonArray();

//        JsonObject staffs1 = jsonObject.get("staffs").getAsJsonObject();
//        Set<Map.Entry<String, JsonElement>> entries = staffs1.entrySet();
//        for (Map.Entry<String, JsonElement> entry : entries) {
//            staffs1.get("entry")
//        }

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

}
