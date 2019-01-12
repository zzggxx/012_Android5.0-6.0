package com.example.recyclerviewpartrefresh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public RecyclerView mRecyclerview;
    private ArrayList<DataSourceBean> mArrayList = new ArrayList<>();
    private RecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intiView();
        initRecyclerView();
        loadData();
    }

    private void loadData() {
        for (int i = 0; i < 50; i++) {
            mArrayList.add(new DataSourceBean(i));
        }
        mAdapter.notifyDataSetChanged();
    }

    private void initRecyclerView() {
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerview.setAdapter(mAdapter = new RecyclerViewAdapter(this, mArrayList));
        mAdapter.setOnItemClick(new RecyclerViewAdapter.onItemClick() {
            @Override
            public void onItemClickAll(int position) {
                mArrayList.get(position).setShowAttention(true);
                //只更新屏幕内的不更新屏幕外的,屏幕外需要数据本质去更新,同时屏幕内的也需要数据做变更.
                mAdapter.notifyItemRangeChanged(0, mArrayList.size(), 1);
            }
        });
    }

    private void intiView() {
        mRecyclerview = (RecyclerView) findViewById(R.id.recy);
    }
}
