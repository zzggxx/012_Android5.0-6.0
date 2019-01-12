package com.example.recyclerviewpartrefresh;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<DataSourceBean> mArrayList;
    private final LayoutInflater mInflater;
    private String TAG = "RecyclerViewAdapter";

    public RecyclerViewAdapter(Context context, ArrayList<DataSourceBean> arrayList) {
        mContext = context;
        mArrayList = arrayList;
        mInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position, List<Object> payloads) {
        if (payloads.isEmpty()) {
            onBindViewHolder(holder, position);
        } else {
            changeAttentionStatus(holder, position, mArrayList.get(position));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        DataSourceBean dataSourceBean = mArrayList.get(position);

        holder.mItem.setText(String.valueOf(dataSourceBean.getNo()));

        holder.mAttentionTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClick != null) {
                    mOnItemClick.onItemClickAll(position);
                }
            }
        });

        changeAttentionStatus(holder, position, dataSourceBean);
    }

    private void changeAttentionStatus(@NonNull ViewHolder holder, int position, DataSourceBean dataSourceBean) {
        Log.i(TAG, "onBindViewHolder: " + position);
        if (!dataSourceBean.isShowAttention()) {
            holder.mAttentionTv.setVisibility(View.VISIBLE);
        } else {
            holder.mAttentionTv.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return mArrayList == null ? 0 : mArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView mItem, mAttentionTv;

        public ViewHolder(View itemView) {
            super(itemView);

            mItem = (TextView) itemView.findViewById(R.id.item);
            mAttentionTv = (TextView) itemView.findViewById(R.id.attention_tv);
        }
    }

    interface onItemClick {
        void onItemClickAll(int position);
    }

    public void setOnItemClick(onItemClick onItemClick) {
        mOnItemClick = onItemClick;
    }

    public onItemClick mOnItemClick;


}
