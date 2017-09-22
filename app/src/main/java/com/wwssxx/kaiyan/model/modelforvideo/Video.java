package com.wwssxx.kaiyan.model.modelforvideo;

import com.wwssxx.kaiyan.module.greendao.AuthorDao;
import com.wwssxx.kaiyan.module.greendao.ConsumptionDao;
import com.wwssxx.kaiyan.module.greendao.CoverDao;
import com.wwssxx.kaiyan.module.greendao.DaoSession;
import com.wwssxx.kaiyan.module.greendao.PlayInfoDao;
import com.wwssxx.kaiyan.module.greendao.ProviderDao;
import com.wwssxx.kaiyan.module.greendao.TagsDao;
import com.wwssxx.kaiyan.module.greendao.VideoDao;
import com.wwssxx.kaiyan.module.greendao.WebUrlDao;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.ToOne;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ruby on 2017/3/8.
 */
@Entity
public class Video implements Serializable {
    /**
     * dataType : VideoBeanForClient
     * id : 16263
     * title : 特条丨「幽灵行动：荒野」真人预告
     * description : 昨天上线的「Ghot Recon Wildlands」今天出了电视上市真人宣传片！开放世界第三人称射击游戏外媒评价还不错，不过今天还是别在玻利维亚做任务了，陪另一半吧~（如果你有的话，科科~）
     * provider : {"name":"YouTube","alias":"youtube","icon":"http://img.kaiyanapp.com/fa20228bc5b921e837156923a58713f6.png"}
     * category : 游戏
     * author : {"id":327,"icon":"http://img.kaiyanapp.com/b4d8b681fca288dcdd9d7584d3bb9914.jpeg?imageMogr2/quality/60","name":"育碧 Ubisoft","description":"第一时间为你提供育碧游戏资讯","link":"","latestReleaseTime":1488974415000,"videoNum":179,"adTrack":null,"follow":{"itemType":"author","itemId":327,"followed":false}}
     * cover : {"feed":"http://img.kaiyanapp.com/94078b7701ded62b2e8bb25cfeec118e.jpeg?imageMogr2/quality/60/format/jpg","detail":"http://img.kaiyanapp.com/94078b7701ded62b2e8bb25cfeec118e.jpeg?imageMogr2/quality/60/format/jpg","blurred":"http://img.kaiyanapp.com/0dfc5d94b9369e1a794ebed233159cec.jpeg?imageMogr2/quality/60/format/jpg","sharing":null}
     * playUrl : http://baobab.kaiyanapp.com/api/v1/playUrl?vid=16263&editionType=default&source=ucloud
     * duration : 137
     * webUrl : {"raw":"http://www.eyepetizer.net/detail.html?vid=16263","forWeibo":"http://wandou.im/3maogj"}
     * releaseTime : 1488964048000
     * playInfo : [{"height":480,"width":854,"urlList":[{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=16263&editionType=normal&source=ucloud"},{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=16263&editionType=normal&source=qcloud"}],"name":"标清","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=16263&editionType=normal&source=ucloud"},{"height":720,"width":1280,"urlList":[{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=16263&editionType=high&source=ucloud"},{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=16263&editionType=high&source=qcloud"}],"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=16263&editionType=high&source=ucloud"}]
     * consumption : {"collectionCount":96,"shareCount":128,"replyCount":7}
     * campaign : null
     * waterMarks : null
     * adTrack : null
     * tags : [{"id":12,"name":"剧情","actionUrl":"eyepetizer://tag/12/?title=%E5%89%A7%E6%83%85","adTrack":null},{"id":22,"name":"预告","actionUrl":"eyepetizer://tag/22/?title=%E9%A2%84%E5%91%8A","adTrack":null},{"id":184,"name":"动作","actionUrl":"eyepetizer://tag/184/?title=%E5%8A%A8%E4%BD%9C","adTrack":null},{"id":16,"name":"广告","actionUrl":"eyepetizer://tag/16/?title=%E5%B9%BF%E5%91%8A","adTrack":null},{"id":30,"name":"游戏","actionUrl":"eyepetizer://tag/30/?title=%E6%B8%B8%E6%88%8F","adTrack":null},{"id":146,"name":"666","actionUrl":"eyepetizer://tag/146/?title=666","adTrack":null},{"id":588,"name":"暗黑","actionUrl":"eyepetizer://tag/588/?title=%E6%9A%97%E9%BB%91","adTrack":null}]
     * type : NORMAL
     * subtitles : []
     * titlePgc : null
     * descriptionPgc : null
     * idx : 0
     * shareAdTrack : null
     * favoriteAdTrack : null
     * webAdTrack : null
     * date : 1488934800000
     * promotion : null
     * label : null
     * descriptionEditor : 昨天上线的「Ghot Recon Wildlands」今天出了电视上市真人宣传片！开放世界第三人称射击游戏外媒评价还不错，不过今天还是别在玻利维亚做任务了，陪另一半吧~（如果你有的话，科科~）
     * collected : false
     * played : false
     */
    @Id(autoincrement = true)
    private Long keyId;
    private long id;
    private long customerId;
    private String dataType;
    private String title;
    private String description;
    @ToOne(joinProperty = "customerId")
    private Provider provider;
    private String category;
    @ToOne(joinProperty = "customerId")
    private Author author;
    @ToOne(joinProperty = "customerId")
    private Cover cover;
    private String playUrl;
    private int duration;
    @ToOne(joinProperty = "customerId")
    private WebUrl webUrl;
    private long releaseTime;
    @ToOne(joinProperty = "customerId")
    private Consumption consumption;
    private String campaign;
    private String waterMarks;
    private String adTrack;
    private String type;
    private String titlePgc;
    private String descriptionPgc;
    private int idx;
    private String shareAdTrack;
    private String favoriteAdTrack;
    private String webAdTrack;
    private long date;
    private String promotion;
    private String label;
    private String descriptionEditor;
    private boolean collected;
    private boolean played;
    @ToMany(referencedJoinProperty = "customerId")
    private List<PlayInfo> playInfo;
    @ToMany(referencedJoinProperty = "customerId")
    private List<Tags> tags;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 2004496110)
    private transient VideoDao myDao;
    @Generated(hash = 83422264)
    public Video(Long keyId, long id, long customerId, String dataType, String title, String description, String category, String playUrl, int duration, long releaseTime, String campaign, String waterMarks, String adTrack, String type, String titlePgc, String descriptionPgc, int idx, String shareAdTrack, String favoriteAdTrack, String webAdTrack, long date, String promotion, String label, String descriptionEditor, boolean collected, boolean played) {
        this.keyId = keyId;
        this.id = id;
        this.customerId = customerId;
        this.dataType = dataType;
        this.title = title;
        this.description = description;
        this.category = category;
        this.playUrl = playUrl;
        this.duration = duration;
        this.releaseTime = releaseTime;
        this.campaign = campaign;
        this.waterMarks = waterMarks;
        this.adTrack = adTrack;
        this.type = type;
        this.titlePgc = titlePgc;
        this.descriptionPgc = descriptionPgc;
        this.idx = idx;
        this.shareAdTrack = shareAdTrack;
        this.favoriteAdTrack = favoriteAdTrack;
        this.webAdTrack = webAdTrack;
        this.date = date;
        this.promotion = promotion;
        this.label = label;
        this.descriptionEditor = descriptionEditor;
        this.collected = collected;
        this.played = played;
    }
    @Generated(hash = 237528154)
    public Video() {
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
    public String getDataType() {
        return this.dataType;
    }
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getCategory() {
        return this.category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getPlayUrl() {
        return this.playUrl;
    }
    public void setPlayUrl(String playUrl) {
        this.playUrl = playUrl;
    }
    public int getDuration() {
        return this.duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public long getReleaseTime() {
        return this.releaseTime;
    }
    public void setReleaseTime(long releaseTime) {
        this.releaseTime = releaseTime;
    }
    public String getCampaign() {
        return this.campaign;
    }
    public void setCampaign(String campaign) {
        this.campaign = campaign;
    }
    public String getWaterMarks() {
        return this.waterMarks;
    }
    public void setWaterMarks(String waterMarks) {
        this.waterMarks = waterMarks;
    }
    public String getAdTrack() {
        return this.adTrack;
    }
    public void setAdTrack(String adTrack) {
        this.adTrack = adTrack;
    }
    public String getType() {
        return this.type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getTitlePgc() {
        return this.titlePgc;
    }
    public void setTitlePgc(String titlePgc) {
        this.titlePgc = titlePgc;
    }
    public String getDescriptionPgc() {
        return this.descriptionPgc;
    }
    public void setDescriptionPgc(String descriptionPgc) {
        this.descriptionPgc = descriptionPgc;
    }
    public int getIdx() {
        return this.idx;
    }
    public void setIdx(int idx) {
        this.idx = idx;
    }
    public String getShareAdTrack() {
        return this.shareAdTrack;
    }
    public void setShareAdTrack(String shareAdTrack) {
        this.shareAdTrack = shareAdTrack;
    }
    public String getFavoriteAdTrack() {
        return this.favoriteAdTrack;
    }
    public void setFavoriteAdTrack(String favoriteAdTrack) {
        this.favoriteAdTrack = favoriteAdTrack;
    }
    public String getWebAdTrack() {
        return this.webAdTrack;
    }
    public void setWebAdTrack(String webAdTrack) {
        this.webAdTrack = webAdTrack;
    }
    public long getDate() {
        return this.date;
    }
    public void setDate(long date) {
        this.date = date;
    }
    public String getPromotion() {
        return this.promotion;
    }
    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }
    public String getLabel() {
        return this.label;
    }
    public void setLabel(String label) {
        this.label = label;
    }
    public String getDescriptionEditor() {
        return this.descriptionEditor;
    }
    public void setDescriptionEditor(String descriptionEditor) {
        this.descriptionEditor = descriptionEditor;
    }
    public boolean getCollected() {
        return this.collected;
    }
    public void setCollected(boolean collected) {
        this.collected = collected;
    }
    public boolean getPlayed() {
        return this.played;
    }
    public void setPlayed(boolean played) {
        this.played = played;
    }
    @Generated(hash = 1944571340)
    private transient Long provider__resolvedKey;
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 127131321)
    public Provider getProvider() {
        long __key = this.customerId;
        if (provider__resolvedKey == null || !provider__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ProviderDao targetDao = daoSession.getProviderDao();
            Provider providerNew = targetDao.load(__key);
            synchronized (this) {
                provider = providerNew;
                provider__resolvedKey = __key;
            }
        }
        return provider;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 835385792)
    public void setProvider(@NotNull Provider provider) {
        if (provider == null) {
            throw new DaoException("To-one property 'customerId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.provider = provider;
            customerId = provider.getKeyId();
            provider__resolvedKey = customerId;
        }
    }
    @Generated(hash = 1107320010)
    private transient Long author__resolvedKey;
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1319414186)
    public Author getAuthor() {
        long __key = this.customerId;
        if (author__resolvedKey == null || !author__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            AuthorDao targetDao = daoSession.getAuthorDao();
            Author authorNew = targetDao.load(__key);
            synchronized (this) {
                author = authorNew;
                author__resolvedKey = __key;
            }
        }
        return author;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1243912507)
    public void setAuthor(@NotNull Author author) {
        if (author == null) {
            throw new DaoException("To-one property 'customerId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.author = author;
            customerId = author.getKeyId();
            author__resolvedKey = customerId;
        }
    }
    @Generated(hash = 1608555099)
    private transient Long cover__resolvedKey;
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 86116200)
    public Cover getCover() {
        long __key = this.customerId;
        if (cover__resolvedKey == null || !cover__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            CoverDao targetDao = daoSession.getCoverDao();
            Cover coverNew = targetDao.load(__key);
            synchronized (this) {
                cover = coverNew;
                cover__resolvedKey = __key;
            }
        }
        return cover;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 578488019)
    public void setCover(@NotNull Cover cover) {
        if (cover == null) {
            throw new DaoException("To-one property 'customerId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.cover = cover;
            customerId = cover.getKeyId();
            cover__resolvedKey = customerId;
        }
    }
    @Generated(hash = 285530594)
    private transient Long webUrl__resolvedKey;
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1518710508)
    public WebUrl getWebUrl() {
        long __key = this.customerId;
        if (webUrl__resolvedKey == null || !webUrl__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            WebUrlDao targetDao = daoSession.getWebUrlDao();
            WebUrl webUrlNew = targetDao.load(__key);
            synchronized (this) {
                webUrl = webUrlNew;
                webUrl__resolvedKey = __key;
            }
        }
        return webUrl;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1045082760)
    public void setWebUrl(@NotNull WebUrl webUrl) {
        if (webUrl == null) {
            throw new DaoException("To-one property 'customerId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.webUrl = webUrl;
            customerId = webUrl.getKeyId();
            webUrl__resolvedKey = customerId;
        }
    }
    @Generated(hash = 1551745173)
    private transient Long consumption__resolvedKey;
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 960450161)
    public Consumption getConsumption() {
        long __key = this.customerId;
        if (consumption__resolvedKey == null || !consumption__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ConsumptionDao targetDao = daoSession.getConsumptionDao();
            Consumption consumptionNew = targetDao.load(__key);
            synchronized (this) {
                consumption = consumptionNew;
                consumption__resolvedKey = __key;
            }
        }
        return consumption;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1633371803)
    public void setConsumption(@NotNull Consumption consumption) {
        if (consumption == null) {
            throw new DaoException("To-one property 'customerId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.consumption = consumption;
            customerId = consumption.getKeyId();
            consumption__resolvedKey = customerId;
        }
    }
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 53385353)
    public List<PlayInfo> getPlayInfo() {
        if (playInfo == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            PlayInfoDao targetDao = daoSession.getPlayInfoDao();
            List<PlayInfo> playInfoNew = targetDao._queryVideo_PlayInfo(keyId);
            synchronized (this) {
                if (playInfo == null) {
                    playInfo = playInfoNew;
                }
            }
        }
        return playInfo;
    }
    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1091687520)
    public synchronized void resetPlayInfo() {
        playInfo = null;
    }
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 837292478)
    public List<Tags> getTags() {
        if (tags == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            TagsDao targetDao = daoSession.getTagsDao();
            List<Tags> tagsNew = targetDao._queryVideo_Tags(keyId);
            synchronized (this) {
                if (tags == null) {
                    tags = tagsNew;
                }
            }
        }
        return tags;
    }
    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 404234)
    public synchronized void resetTags() {
        tags = null;
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
    @Generated(hash = 658121286)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getVideoDao() : null;
    }


}
