package com.wwssxx.kaiyan.model;

/**
 * Created by ruby on 2017/2/24.
 */

public class KaiYanVideoText {

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * dataType : TextFooter
         * text : 查看往期编辑精选
         * font : normal
         * actionUrl : eyepetizer://feed?issueIndex=1
         * adTrack : null
         */

        private String dataType;
        private String text;
        private String font;
        private String actionUrl;
        private Object adTrack;

        public String getDataType() {
            return dataType;
        }

        public void setDataType(String dataType) {
            this.dataType = dataType;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getFont() {
            return font;
        }

        public void setFont(String font) {
            this.font = font;
        }

        public String getActionUrl() {
            return actionUrl;
        }

        public void setActionUrl(String actionUrl) {
            this.actionUrl = actionUrl;
        }

        public Object getAdTrack() {
            return adTrack;
        }

        public void setAdTrack(Object adTrack) {
            this.adTrack = adTrack;
        }
    }
}
