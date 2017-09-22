package com.wwssxx.kaiyan.model.modelforvideo;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by ruby on 2017/3/9.
 */
@Entity
public class Follow {
    @Id(autoincrement = true)
    private Long keyId;
    private String itemType;
    private int itemId;
    private boolean followed;
    @Generated(hash = 1258378586)
    public Follow(Long keyId, String itemType, int itemId, boolean followed) {
        this.keyId = keyId;
        this.itemType = itemType;
        this.itemId = itemId;
        this.followed = followed;
    }
    @Generated(hash = 2125231264)
    public Follow() {
    }
    public Long getKeyId() {
        return this.keyId;
    }
    public void setKeyId(Long keyId) {
        this.keyId = keyId;
    }
    public String getItemType() {
        return this.itemType;
    }
    public void setItemType(String itemType) {
        this.itemType = itemType;
    }
    public int getItemId() {
        return this.itemId;
    }
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
    public boolean getFollowed() {
        return this.followed;
    }
    public void setFollowed(boolean followed) {
        this.followed = followed;
    }
    public void setKeyId(long keyId) {
        this.keyId = keyId;
    }

}
