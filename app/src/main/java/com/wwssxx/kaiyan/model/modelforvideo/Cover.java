package com.wwssxx.kaiyan.model.modelforvideo;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by ruby on 2017/3/9.
 */
@Entity
public class Cover{
    /**
     * feed : http://img.kaiyanapp.com/94078b7701ded62b2e8bb25cfeec118e.jpeg?imageMogr2/quality/60/format/jpg
     * detail : http://img.kaiyanapp.com/94078b7701ded62b2e8bb25cfeec118e.jpeg?imageMogr2/quality/60/format/jpg
     * blurred : http://img.kaiyanapp.com/0dfc5d94b9369e1a794ebed233159cec.jpeg?imageMogr2/quality/60/format/jpg
     * sharing : null
     */
    @Id(autoincrement = true)
    private Long keyId;
    private String feed;
    private String detail;
    private String blurred;
    private String sharing;
    @Generated(hash = 76332560)
    public Cover(Long keyId, String feed, String detail, String blurred, String sharing) {
        this.keyId = keyId;
        this.feed = feed;
        this.detail = detail;
        this.blurred = blurred;
        this.sharing = sharing;
    }
    @Generated(hash = 1978515490)
    public Cover() {
    }
    public Long getKeyId() {
        return this.keyId;
    }
    public void setKeyId(Long keyId) {
        this.keyId = keyId;
    }
    public String getFeed() {
        return this.feed;
    }
    public void setFeed(String feed) {
        this.feed = feed;
    }
    public String getDetail() {
        return this.detail;
    }
    public void setDetail(String detail) {
        this.detail = detail;
    }
    public String getBlurred() {
        return this.blurred;
    }
    public void setBlurred(String blurred) {
        this.blurred = blurred;
    }
    public String getSharing() {
        return this.sharing;
    }
    public void setSharing(String sharing) {
        this.sharing = sharing;
    }
    public void setKeyId(long keyId) {
        this.keyId = keyId;
    }

}
