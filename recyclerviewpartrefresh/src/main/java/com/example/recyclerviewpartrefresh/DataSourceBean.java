package com.example.recyclerviewpartrefresh;

public class DataSourceBean {

    int No;
    boolean isShowAttention;

    public DataSourceBean(int i) {
        No = i;
    }

    public int getNo() {
        return No;
    }

    public void setNo(int no) {
        No = no;
    }

    public boolean isShowAttention() {
        return isShowAttention;
    }

    public void setShowAttention(boolean showAttention) {
        isShowAttention = showAttention;
    }


}
