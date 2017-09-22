package com.wwssxx.kaiyan.model.modelforvideo;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by ruby on 2017/3/9.
 */
@Entity
public class Provider{
    @Id(autoincrement = true)
    private Long keyId;
    private String name;
    private String alias;
    private String icon;
    @Generated(hash = 796944403)
    public Provider(Long keyId, String name, String alias, String icon) {
        this.keyId = keyId;
        this.name = name;
        this.alias = alias;
        this.icon = icon;
    }
    @Generated(hash = 2018611927)
    public Provider() {
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
    public String getAlias() {
        return this.alias;
    }
    public void setAlias(String alias) {
        this.alias = alias;
    }
    public String getIcon() {
        return this.icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }
    public void setKeyId(long keyId) {
        this.keyId = keyId;
    }

}
