package com.wwssxx.kaiyan.model.modelforvideo;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by ruby on 2017/3/9.
 */
@Entity
public class WebUrl {
    @Id(autoincrement = true)
    private Long keyId;
    private String raw;
    private String forWeibo;
    @Generated(hash = 630915943)
    public WebUrl(Long keyId, String raw, String forWeibo) {
        this.keyId = keyId;
        this.raw = raw;
        this.forWeibo = forWeibo;
    }
    @Generated(hash = 1285492167)
    public WebUrl() {
    }
    public Long getKeyId() {
        return this.keyId;
    }
    public void setKeyId(Long keyId) {
        this.keyId = keyId;
    }
    public String getRaw() {
        return this.raw;
    }
    public void setRaw(String raw) {
        this.raw = raw;
    }
    public String getForWeibo() {
        return this.forWeibo;
    }
    public void setForWeibo(String forWeibo) {
        this.forWeibo = forWeibo;
    }
    public void setKeyId(long keyId) {
        this.keyId = keyId;
    }
}
