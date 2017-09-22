package com.wwssxx.kaiyan.model.modelforvideo;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by ruby on 2017/3/9.
 */
@Entity
public class UrlList {
    @Id(autoincrement = true)
    private Long keyId;
    private long customerId2;
    private String name;
    private String url;
    @Generated(hash = 1527134308)
    public UrlList(Long keyId, long customerId2, String name, String url) {
        this.keyId = keyId;
        this.customerId2 = customerId2;
        this.name = name;
        this.url = url;
    }
    @Generated(hash = 402970144)
    public UrlList() {
    }
    public Long getKeyId() {
        return this.keyId;
    }
    public void setKeyId(Long keyId) {
        this.keyId = keyId;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public void setKeyId(long keyId) {
        this.keyId = keyId;
    }
    public long getCustomerId2() {
        return this.customerId2;
    }
    public void setCustomerId2(long customerId2) {
        this.customerId2 = customerId2;
    }

}
