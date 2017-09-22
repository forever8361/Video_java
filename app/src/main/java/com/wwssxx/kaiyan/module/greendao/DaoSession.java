package com.wwssxx.kaiyan.module.greendao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.wwssxx.kaiyan.model.modelforvideo.Author;
import com.wwssxx.kaiyan.model.modelforvideo.Consumption;
import com.wwssxx.kaiyan.model.modelforvideo.Cover;
import com.wwssxx.kaiyan.model.modelforvideo.Follow;
import com.wwssxx.kaiyan.model.modelforvideo.PlayInfo;
import com.wwssxx.kaiyan.model.modelforvideo.Provider;
import com.wwssxx.kaiyan.model.modelforvideo.Tags;
import com.wwssxx.kaiyan.model.modelforvideo.UrlList;
import com.wwssxx.kaiyan.model.modelforvideo.Video;
import com.wwssxx.kaiyan.model.modelforvideo.WebUrl;

import com.wwssxx.kaiyan.module.greendao.AuthorDao;
import com.wwssxx.kaiyan.module.greendao.ConsumptionDao;
import com.wwssxx.kaiyan.module.greendao.CoverDao;
import com.wwssxx.kaiyan.module.greendao.FollowDao;
import com.wwssxx.kaiyan.module.greendao.PlayInfoDao;
import com.wwssxx.kaiyan.module.greendao.ProviderDao;
import com.wwssxx.kaiyan.module.greendao.TagsDao;
import com.wwssxx.kaiyan.module.greendao.UrlListDao;
import com.wwssxx.kaiyan.module.greendao.VideoDao;
import com.wwssxx.kaiyan.module.greendao.WebUrlDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig authorDaoConfig;
    private final DaoConfig consumptionDaoConfig;
    private final DaoConfig coverDaoConfig;
    private final DaoConfig followDaoConfig;
    private final DaoConfig playInfoDaoConfig;
    private final DaoConfig providerDaoConfig;
    private final DaoConfig tagsDaoConfig;
    private final DaoConfig urlListDaoConfig;
    private final DaoConfig videoDaoConfig;
    private final DaoConfig webUrlDaoConfig;

    private final AuthorDao authorDao;
    private final ConsumptionDao consumptionDao;
    private final CoverDao coverDao;
    private final FollowDao followDao;
    private final PlayInfoDao playInfoDao;
    private final ProviderDao providerDao;
    private final TagsDao tagsDao;
    private final UrlListDao urlListDao;
    private final VideoDao videoDao;
    private final WebUrlDao webUrlDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        authorDaoConfig = daoConfigMap.get(AuthorDao.class).clone();
        authorDaoConfig.initIdentityScope(type);

        consumptionDaoConfig = daoConfigMap.get(ConsumptionDao.class).clone();
        consumptionDaoConfig.initIdentityScope(type);

        coverDaoConfig = daoConfigMap.get(CoverDao.class).clone();
        coverDaoConfig.initIdentityScope(type);

        followDaoConfig = daoConfigMap.get(FollowDao.class).clone();
        followDaoConfig.initIdentityScope(type);

        playInfoDaoConfig = daoConfigMap.get(PlayInfoDao.class).clone();
        playInfoDaoConfig.initIdentityScope(type);

        providerDaoConfig = daoConfigMap.get(ProviderDao.class).clone();
        providerDaoConfig.initIdentityScope(type);

        tagsDaoConfig = daoConfigMap.get(TagsDao.class).clone();
        tagsDaoConfig.initIdentityScope(type);

        urlListDaoConfig = daoConfigMap.get(UrlListDao.class).clone();
        urlListDaoConfig.initIdentityScope(type);

        videoDaoConfig = daoConfigMap.get(VideoDao.class).clone();
        videoDaoConfig.initIdentityScope(type);

        webUrlDaoConfig = daoConfigMap.get(WebUrlDao.class).clone();
        webUrlDaoConfig.initIdentityScope(type);

        authorDao = new AuthorDao(authorDaoConfig, this);
        consumptionDao = new ConsumptionDao(consumptionDaoConfig, this);
        coverDao = new CoverDao(coverDaoConfig, this);
        followDao = new FollowDao(followDaoConfig, this);
        playInfoDao = new PlayInfoDao(playInfoDaoConfig, this);
        providerDao = new ProviderDao(providerDaoConfig, this);
        tagsDao = new TagsDao(tagsDaoConfig, this);
        urlListDao = new UrlListDao(urlListDaoConfig, this);
        videoDao = new VideoDao(videoDaoConfig, this);
        webUrlDao = new WebUrlDao(webUrlDaoConfig, this);

        registerDao(Author.class, authorDao);
        registerDao(Consumption.class, consumptionDao);
        registerDao(Cover.class, coverDao);
        registerDao(Follow.class, followDao);
        registerDao(PlayInfo.class, playInfoDao);
        registerDao(Provider.class, providerDao);
        registerDao(Tags.class, tagsDao);
        registerDao(UrlList.class, urlListDao);
        registerDao(Video.class, videoDao);
        registerDao(WebUrl.class, webUrlDao);
    }
    
    public void clear() {
        authorDaoConfig.clearIdentityScope();
        consumptionDaoConfig.clearIdentityScope();
        coverDaoConfig.clearIdentityScope();
        followDaoConfig.clearIdentityScope();
        playInfoDaoConfig.clearIdentityScope();
        providerDaoConfig.clearIdentityScope();
        tagsDaoConfig.clearIdentityScope();
        urlListDaoConfig.clearIdentityScope();
        videoDaoConfig.clearIdentityScope();
        webUrlDaoConfig.clearIdentityScope();
    }

    public AuthorDao getAuthorDao() {
        return authorDao;
    }

    public ConsumptionDao getConsumptionDao() {
        return consumptionDao;
    }

    public CoverDao getCoverDao() {
        return coverDao;
    }

    public FollowDao getFollowDao() {
        return followDao;
    }

    public PlayInfoDao getPlayInfoDao() {
        return playInfoDao;
    }

    public ProviderDao getProviderDao() {
        return providerDao;
    }

    public TagsDao getTagsDao() {
        return tagsDao;
    }

    public UrlListDao getUrlListDao() {
        return urlListDao;
    }

    public VideoDao getVideoDao() {
        return videoDao;
    }

    public WebUrlDao getWebUrlDao() {
        return webUrlDao;
    }

}
