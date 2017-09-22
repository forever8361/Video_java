package com.wwssxx.kaiyan.model.modelforvideo;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by ruby on 2017/3/9.
 */
@Entity
public class Tags {
    /**
     * id : 12
     * name : 剧情
     * actionUrl : eyepetizer://tag/12/?title=%E5%89%A7%E6%83%85
     * adTrack : null
     */
    @Id(autoincrement = true)
    private Long keyId;
    private int id;
    private long customerId;
    private String name;
    private String actionUrl;
    private String adTrack;
    @Generated(hash = 772261471)
    public Tags(Long keyId, int id, long customerId, String name, String actionUrl,
            String adTrack) {
        this.keyId = keyId;
        this.id = id;
        this.customerId = customerId;
        this.name = name;
        this.actionUrl = actionUrl;
        this.adTrack = adTrack;
    }
    @Generated(hash = 1290390976)
    public Tags() {
    }
    public Long getKeyId() {
        return this.keyId;
    }
    public void setKeyId(Long keyId) {
        this.keyId = keyId;
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public long getCustomerId() {
        return this.customerId;
    }
    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getActionUrl() {
        return this.actionUrl;
    }
    public void setActionUrl(String actionUrl) {
        this.actionUrl = actionUrl;
    }
    public String getAdTrack() {
        return this.adTrack;
    }
    public void setAdTrack(String adTrack) {
        this.adTrack = adTrack;
    }
    public void setKeyId(long keyId) {
        this.keyId = keyId;
    }

}
