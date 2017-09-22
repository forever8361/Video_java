package com.wwssxx.kaiyan.model.modelforvideo;

import com.wwssxx.kaiyan.module.greendao.DaoSession;
import com.wwssxx.kaiyan.module.greendao.PlayInfoDao;
import com.wwssxx.kaiyan.module.greendao.UrlListDao;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;

/**
 * Created by ruby on 2017/3/9.
 */
@Entity
public class PlayInfo  {
    @Id(autoincrement = true)
    private Long keyId;
    private long customerId;
    private int height;
    private int width;
    private String name;
    private String type;
    private String url;
    @ToMany(referencedJoinProperty = "customerId2")
    private List<UrlList> urlList;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 864135210)
    private transient PlayInfoDao myDao;
    @Generated(hash = 1971255725)
    public PlayInfo(Long keyId, long customerId, int height, int width, String name, String type,
            String url) {
        this.keyId = keyId;
        this.customerId = customerId;
        this.height = height;
        this.width = width;
        this.name = name;
        this.type = type;
        this.url = url;
    }
    @Generated(hash = 620864500)
    public PlayInfo() {
    }
    public Long getKeyId() {
        return this.keyId;
    }
    public void setKeyId(Long keyId) {
        this.keyId = keyId;
    }
    public long getCustomerId() {
        return this.customerId;
    }
    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }
    public int getHeight() {
        return this.height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public int getWidth() {
        return this.width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return this.type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1152293674)
    public List<UrlList> getUrlList() {
        if (urlList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            UrlListDao targetDao = daoSession.getUrlListDao();
            List<UrlList> urlListNew = targetDao._queryPlayInfo_UrlList(keyId);
            synchronized (this) {
                if (urlList == null) {
                    urlList = urlListNew;
                }
            }
        }
        return urlList;
    }
    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1207500769)
    public synchronized void resetUrlList() {
        urlList = null;
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
    @Generated(hash = 1543320434)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getPlayInfoDao() : null;
    }

}
