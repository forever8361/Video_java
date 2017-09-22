package com.wwssxx.kaiyan.model;

import android.support.annotation.Keep;

import java.util.List;

/**
 * Created by ruby on 2017/2/27.
 */
@Keep
public class DiscovertoryEntiry {

    /**
     * tabInfo : {"tabList":[{"id":0,"name":"热门","apiUrl":"http://baobab.kaiyanapp.com/api/v4/discovery/hot"},{"id":1,"name":"分类","apiUrl":"http://baobab.kaiyanapp.com/api/v4/discovery/category"},{"id":2,"name":"作者","apiUrl":"http://baobab.kaiyanapp.com/api/v4/pgcs/all"}],"defaultIdx":0}
     */

    private TabInfoBean tabInfo;

    public TabInfoBean getTabInfo() {
        return tabInfo;
    }

    public void setTabInfo(TabInfoBean tabInfo) {
        this.tabInfo = tabInfo;
    }

    public static class TabInfoBean {
        /**
         * tabList : [{"id":0,"name":"热门","apiUrl":"http://baobab.kaiyanapp.com/api/v4/discovery/hot"},{"id":1,"name":"分类","apiUrl":"http://baobab.kaiyanapp.com/api/v4/discovery/category"},{"id":2,"name":"作者","apiUrl":"http://baobab.kaiyanapp.com/api/v4/pgcs/all"}]
         * defaultIdx : 0
         */

        private int defaultIdx;
        private List<TabListBean> tabList;

        public int getDefaultIdx() {
            return defaultIdx;
        }

        public void setDefaultIdx(int defaultIdx) {
            this.defaultIdx = defaultIdx;
        }

        public List<TabListBean> getTabList() {
            return tabList;
        }

        public void setTabList(List<TabListBean> tabList) {
            this.tabList = tabList;
        }

        public static class TabListBean {
            /**
             * id : 0
             * name : 热门
             * apiUrl : http://baobab.kaiyanapp.com/api/v4/discovery/hot
             */

            private int id;
            private String name;
            private String apiUrl;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getApiUrl() {
                return apiUrl;
            }

            public void setApiUrl(String apiUrl) {
                this.apiUrl = apiUrl;
            }
        }
    }
}
