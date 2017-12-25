package com.example.jsongson;

import java.util.List;

/**
 * Created by will on 2017/12/25.
 */

public class SummaryBean {

    /**
     * rank : 1
     * rank1 :
     * rankString : 1
     * staffs : [{"staff_id":"a67487c4ec0b40f3964c64ac459ddb94","staff_name":"","staff_position":"艺术总监","staff_img":"","service_pfm":0,"titles":["剪发之星"],"rank":1},{"staff_id":"bb55fff3f59b44e9b3ba4a170d51486e","staff_name":"","staff_position":"高级发型师","staff_img":"","service_pfm":0,"titles":["烫发之星","染发之星","护发之星"],"rank":2},{"staff_id":"f70fbde832b94620ab8b232ba4f5ae5a","staff_name":"","staff_position":"艺术总监","staff_img":"","service_pfm":0,"titles":[],"rank":3},{"staff_id":"82a132e1f8a44b7897ab00ebd693aa13","staff_name":"","staff_position":"特级发型师","staff_img":"","service_pfm":0,"titles":[],"rank":4},{"staff_id":"055292a370064ce39d73af80e9c24643","staff_name":"","staff_position":"高级发型师","staff_img":"","service_pfm":0,"titles":["洗吹之星"],"rank":5}]
     */

    private int rank;
    private String rank1;
    private String rankString;
    private List<StaffsBean> staffs;

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getRank1() {
        return rank1;
    }

    public void setRank1(String rank1) {
        this.rank1 = rank1;
    }

    public String getRankString() {
        return rankString;
    }

    public void setRankString(String rankString) {
        this.rankString = rankString;
    }

    public List<StaffsBean> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<StaffsBean> staffs) {
        this.staffs = staffs;
    }

    public static class StaffsBean {
        /**
         * staff_id : a67487c4ec0b40f3964c64ac459ddb94
         * staff_name :
         * staff_position : 艺术总监
         * staff_img :
         * service_pfm : 0
         * titles : ["剪发之星"]
         * rank : 1
         */

        private String staff_id;
        private String staff_name;
        private String staff_position;
        private String staff_img;
        private int service_pfm;
        private int rank;
        private List<String> titles;

        public String getStaff_id() {
            return staff_id;
        }

        public void setStaff_id(String staff_id) {
            this.staff_id = staff_id;
        }

        public String getStaff_name() {
            return staff_name;
        }

        public void setStaff_name(String staff_name) {
            this.staff_name = staff_name;
        }

        public String getStaff_position() {
            return staff_position;
        }

        public void setStaff_position(String staff_position) {
            this.staff_position = staff_position;
        }

        public String getStaff_img() {
            return staff_img;
        }

        public void setStaff_img(String staff_img) {
            this.staff_img = staff_img;
        }

        public int getService_pfm() {
            return service_pfm;
        }

        public void setService_pfm(int service_pfm) {
            this.service_pfm = service_pfm;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public List<String> getTitles() {
            return titles;
        }

        public void setTitles(List<String> titles) {
            this.titles = titles;
        }
    }
}
