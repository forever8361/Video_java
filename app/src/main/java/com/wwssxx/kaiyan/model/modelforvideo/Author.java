package com.wwssxx.kaiyan.model.modelforvideo;

import com.wwssxx.kaiyan.module.greendao.AuthorDao;
import com.wwssxx.kaiyan.module.greendao.DaoSession;
import com.wwssxx.kaiyan.module.greendao.FollowDao;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToOne;

/**
 * Created by ruby on 2017/3/9.
 */
@Entity
public class Author {
    /**
     * id : 347
     * icon : http://img.kaiyanapp.com/637723a9f19470f5d6c63b0cb4bc0fe6.jpeg?imageMogr2/quality/60
     * name : 华纳兄弟影业
     * description : 华纳兄弟影业公司（Warner Bros. Pictures）全球最大的电影和电视娱乐制作公司之一。
     * link :
     * latestReleaseTime : 1489025460000
     * videoNum : 128
     * adTrack : null
     * follow : {"itemType":"author","itemId":347,"followed":false}
     */
    @Id(autoincrement = true)
    private Long keyId;
    private long id;
    private long customerId;
    private String icon;
    private String name;
    private String description;
    private String link;
    private long latestReleaseTime;
    private int videoNum;
    private String adTrack;
    @ToOne(joinProperty = "customerId")
    private Follow follow;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1264723625)
    private transient AuthorDao myDao;
    @Generated(hash = 1655134761)
    public Author(Long keyId, long id, long customerId, String icon, String name, String description,
            String link, long latestReleaseTime, int videoNum, String adTrack) {
        this.keyId = keyId;
        this.id = id;
        this.customerId = customerId;
        this.icon = icon;
        this.name = name;
        this.description = description;
        this.link = link;
        this.latestReleaseTime = latestReleaseTime;
        this.videoNum = videoNum;
        this.adTrack = adTrack;
    }
    @Generated(hash = 64241762)
    public Author() {
    }
    public Long getKeyId() {
        return this.keyId;
    }
    public void setKeyId(Long keyId) {
        this.keyId = keyId;
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getCustomerId() {
        return this.customerId;
    }
    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }
    public String getIcon() {
        return this.icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getLink() {
        return this.link;
    }
    public void setLink(String link) {
        this.link = link;
    }
    public long getLatestReleaseTime() {
        return this.latestReleaseTime;
    }
    public void setLatestReleaseTime(long latestReleaseTime) {
        this.latestReleaseTime = latestReleaseTime;
    }
    public int getVideoNum() {
        return this.videoNum;
    }
    public void setVideoNum(int videoNum) {
        this.videoNum = videoNum;
    }
    public String getAdTrack() {
        return this.adTrack;
    }
    public void setAdTrack(String adTrack) {
        this.adTrack = adTrack;
    }
    @Generated(hash = 2136485735)
    private transient Long follow__resolvedKey;
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 131933541)
    public Follow getFollow() {
        long __key = this.customerId;
        if (follow__resolvedKey == null || !follow__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            FollowDao targetDao = daoSession.getFollowDao();
            Follow followNew = targetDao.load(__key);
            synchronized (this) {
                follow = followNew;
                follow__resolvedKey = __key;
            }
        }
        return follow;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 2061963984)
    public void setFollow(@NotNull Follow follow) {
        if (follow == null) {
            throw new DaoException(
                    "To-one property 'customerId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.follow = follow;
            customerId = follow.getKeyId();
            follow__resolvedKey = customerId;
        }
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }
    public void setKeyId(long keyId) {
        this.keyId = keyId;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 22439443)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getAuthorDao() : null;
    }

}
