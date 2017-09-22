package com.wwssxx.kaiyan.model.modelforvideo;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by ruby on 2017/3/9.
 */
@Entity
public class Consumption {
    @Id(autoincrement = true)
    private Long keyId;
    private int collectionCount;
    private int shareCount;
    private int replyCount;
    @Generated(hash = 2011816016)
    public Consumption(Long keyId, int collectionCount, int shareCount,
            int replyCount) {
        this.keyId = keyId;
        this.collectionCount = collectionCount;
        this.shareCount = shareCount;
        this.replyCount = replyCount;
    }
    @Generated(hash = 609816755)
    public Consumption() {
    }
    public Long getKeyId() {
        return this.keyId;
    }
    public void setKeyId(Long keyId) {
        this.keyId = keyId;
    }
    public int getCollectionCount() {
        return this.collectionCount;
    }
    public void setCollectionCount(int collectionCount) {
        this.collectionCount = collectionCount;
    }
    public int getShareCount() {
        return this.shareCount;
    }
    public void setShareCount(int shareCount) {
        this.shareCount = shareCount;
    }
    public int getReplyCount() {
        return this.replyCount;
    }
    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
    }
    public void setKeyId(long keyId) {
        this.keyId = keyId;
    }

}
