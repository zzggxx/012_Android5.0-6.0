package com.example.jsongson;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.Gson;

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
         * 对象和String串的转化
         */
        mGson = new Gson();
        SummaryBean summaryBean = mGson.fromJson(mStringJson, SummaryBean.class);
        String s = mGson.toJson(summaryBean);


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
