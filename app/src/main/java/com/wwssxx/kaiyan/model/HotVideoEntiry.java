package com.wwssxx.kaiyan.model;

import android.support.annotation.Keep;

import java.util.List;

/**
 * Created by ruby on 2017/2/28.
 */
@Keep
public class HotVideoEntiry {

    /**
     * type : video
     * data : {"dataType":"VideoBeanForClient","id":14796,"title":"震撼你的视野新版行星及恒星的大小对比","description":"该视频展现了行星及恒星的大小对比！整个画面十分震撼，人类，不太阳系真的太渺小了！","provider":{"name":"PGC","alias":"PGC","icon":""},"category":"科普","author":{"id":400,"icon":"http://img.kaiyanapp.com/1c4b7194935f0351cde3916e35479e1f.jpeg?imageMogr2/quality/60/format/jpg","name":"天文一族","description":"专注于对宇宙、太空、星系等天文科学知识的分享及科普！","link":"","latestReleaseTime":1488258461000,"videoNum":23,"adTrack":null,"follow":{"itemType":"author","itemId":400,"followed":false},"authorType":"NORMAL"},"cover":{"feed":"http://img.kaiyanapp.com/3586a5420e4803557e221d5ebaeb8d04.png?imageMogr2/quality/60/format/jpg","detail":"http://img.kaiyanapp.com/3586a5420e4803557e221d5ebaeb8d04.png?imageMogr2/quality/60/format/jpg","blurred":"http://img.kaiyanapp.com/cee6447d64899aeba600fc91a2081d7a.jpeg?imageMogr2/quality/60/format/jpg","sharing":null},"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=14796&editionType=default&source=ucloud","duration":378,"webUrl":{"raw":"http://www.eyepetizer.net/detail.html?vid=14796","forWeibo":"http://wandou.im/3m62x5"},"releaseTime":1488162878000,"playInfo":[{"height":480,"width":854,"urlList":[{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=14796&editionType=normal&source=ucloud"},{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=14796&editionType=normal&source=qcloud"}],"name":"标清","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=14796&editionType=normal&source=ucloud"},{"height":720,"width":1280,"urlList":[{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=14796&editionType=high&source=ucloud"},{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=14796&editionType=high&source=qcloud"}],"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=14796&editionType=high&source=ucloud"}],"consumption":{"collectionCount":190,"shareCount":213,"replyCount":7},"campaign":null,"waterMarks":null,"adTrack":null,"tags":[],"type":"NORMAL","idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1488162878000,"promotion":null,"label":null,"collected":false,"played":false}
     */

    private String type;
    private DataBean data;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * dataType : VideoBeanForClient
         * id : 14796
         * title : 震撼你的视野新版行星及恒星的大小对比
         * description : 该视频展现了行星及恒星的大小对比！整个画面十分震撼，人类，不太阳系真的太渺小了！
         * provider : {"name":"PGC","alias":"PGC","icon":""}
         * category : 科普
         * author : {"id":400,"icon":"http://img.kaiyanapp.com/1c4b7194935f0351cde3916e35479e1f.jpeg?imageMogr2/quality/60/format/jpg","name":"天文一族","description":"专注于对宇宙、太空、星系等天文科学知识的分享及科普！","link":"","latestReleaseTime":1488258461000,"videoNum":23,"adTrack":null,"follow":{"itemType":"author","itemId":400,"followed":false},"authorType":"NORMAL"}
         * cover : {"feed":"http://img.kaiyanapp.com/3586a5420e4803557e221d5ebaeb8d04.png?imageMogr2/quality/60/format/jpg","detail":"http://img.kaiyanapp.com/3586a5420e4803557e221d5ebaeb8d04.png?imageMogr2/quality/60/format/jpg","blurred":"http://img.kaiyanapp.com/cee6447d64899aeba600fc91a2081d7a.jpeg?imageMogr2/quality/60/format/jpg","sharing":null}
         * playUrl : http://baobab.kaiyanapp.com/api/v1/playUrl?vid=14796&editionType=default&source=ucloud
         * duration : 378
         * webUrl : {"raw":"http://www.eyepetizer.net/detail.html?vid=14796","forWeibo":"http://wandou.im/3m62x5"}
         * releaseTime : 1488162878000
         * playInfo : [{"height":480,"width":854,"urlList":[{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=14796&editionType=normal&source=ucloud"},{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=14796&editionType=normal&source=qcloud"}],"name":"标清","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=14796&editionType=normal&source=ucloud"},{"height":720,"width":1280,"urlList":[{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=14796&editionType=high&source=ucloud"},{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=14796&editionType=high&source=qcloud"}],"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=14796&editionType=high&source=ucloud"}]
         * consumption : {"collectionCount":190,"shareCount":213,"replyCount":7}
         * campaign : null
         * waterMarks : null
         * adTrack : null
         * tags : []
         * type : NORMAL
         * idx : 0
         * shareAdTrack : null
         * favoriteAdTrack : null
         * webAdTrack : null
         * date : 1488162878000
         * promotion : null
         * label : null
         * collected : false
         * played : false
         */

        private String dataType;
        private int id;
        private String title;
        private String description;
        private ProviderBean provider;
        private String category;
        private AuthorBean author;
        private CoverBean cover;
        private String playUrl;
        private int duration;
        private WebUrlBean webUrl;
        private long releaseTime;
        private ConsumptionBean consumption;
        private Object campaign;
        private Object waterMarks;
        private Object adTrack;
        private String type;
        private int idx;
        private Object shareAdTrack;
        private Object favoriteAdTrack;
        private Object webAdTrack;
        private long date;
        private Object promotion;
        private Object label;
        private boolean collected;
        private boolean played;
        private List<PlayInfoBean> playInfo;
        private List<?> tags;

        public String getDataType() {
            return dataType;
        }

        public void setDataType(String dataType) {
            this.dataType = dataType;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public ProviderBean getProvider() {
            return provider;
        }

        public void setProvider(ProviderBean provider) {
            this.provider = provider;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public AuthorBean getAuthor() {
            return author;
        }

        public void setAuthor(AuthorBean author) {
            this.author = author;
        }

        public CoverBean getCover() {
            return cover;
        }

        public void setCover(CoverBean cover) {
            this.cover = cover;
        }

        public String getPlayUrl() {
            return playUrl;
        }

        public void setPlayUrl(String playUrl) {
            this.playUrl = playUrl;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public WebUrlBean getWebUrl() {
            return webUrl;
        }

        public void setWebUrl(WebUrlBean webUrl) {
            this.webUrl = webUrl;
        }

        public long getReleaseTime() {
            return releaseTime;
        }

        public void setReleaseTime(long releaseTime) {
            this.releaseTime = releaseTime;
        }

        public ConsumptionBean getConsumption() {
            return consumption;
        }

        public void setConsumption(ConsumptionBean consumption) {
            this.consumption = consumption;
        }

        public Object getCampaign() {
            return campaign;
        }

        public void setCampaign(Object campaign) {
            this.campaign = campaign;
        }

        public Object getWaterMarks() {
            return waterMarks;
        }

        public void setWaterMarks(Object waterMarks) {
            this.waterMarks = waterMarks;
        }

        public Object getAdTrack() {
            return adTrack;
        }

        public void setAdTrack(Object adTrack) {
            this.adTrack = adTrack;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getIdx() {
            return idx;
        }

        public void setIdx(int idx) {
            this.idx = idx;
        }

        public Object getShareAdTrack() {
            return shareAdTrack;
        }

        public void setShareAdTrack(Object shareAdTrack) {
            this.shareAdTrack = shareAdTrack;
        }

        public Object getFavoriteAdTrack() {
            return favoriteAdTrack;
        }

        public void setFavoriteAdTrack(Object favoriteAdTrack) {
            this.favoriteAdTrack = favoriteAdTrack;
        }

        public Object getWebAdTrack() {
            return webAdTrack;
        }

        public void setWebAdTrack(Object webAdTrack) {
            this.webAdTrack = webAdTrack;
        }

        public long getDate() {
            return date;
        }

        public void setDate(long date) {
            this.date = date;
        }

        public Object getPromotion() {
            return promotion;
        }

        public void setPromotion(Object promotion) {
            this.promotion = promotion;
        }

        public Object getLabel() {
            return label;
        }

        public void setLabel(Object label) {
            this.label = label;
        }

        public boolean isCollected() {
            return collected;
        }

        public void setCollected(boolean collected) {
            this.collected = collected;
        }

        public boolean isPlayed() {
            return played;
        }

        public void setPlayed(boolean played) {
            this.played = played;
        }

        public List<PlayInfoBean> getPlayInfo() {
            return playInfo;
        }

        public void setPlayInfo(List<PlayInfoBean> playInfo) {
            this.playInfo = playInfo;
        }

        public List<?> getTags() {
            return tags;
        }

        public void setTags(List<?> tags) {
            this.tags = tags;
        }

        public static class ProviderBean {
            /**
             * name : PGC
             * alias : PGC
             * icon :
             */

            private String name;
            private String alias;
            private String icon;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getAlias() {
                return alias;
            }

            public void setAlias(String alias) {
                this.alias = alias;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }
        }

        public static class AuthorBean {
            /**
             * id : 400
             * icon : http://img.kaiyanapp.com/1c4b7194935f0351cde3916e35479e1f.jpeg?imageMogr2/quality/60/format/jpg
             * name : 天文一族
             * description : 专注于对宇宙、太空、星系等天文科学知识的分享及科普！
             * link :
             * latestReleaseTime : 1488258461000
             * videoNum : 23
             * adTrack : null
             * follow : {"itemType":"author","itemId":400,"followed":false}
             * authorType : NORMAL
             */

            private int id;
            private String icon;
            private String name;
            private String description;
            private String link;
            private long latestReleaseTime;
            private int videoNum;
            private Object adTrack;
            private FollowBean follow;
            private String authorType;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public long getLatestReleaseTime() {
                return latestReleaseTime;
            }

            public void setLatestReleaseTime(long latestReleaseTime) {
                this.latestReleaseTime = latestReleaseTime;
            }

            public int getVideoNum() {
                return videoNum;
            }

            public void setVideoNum(int videoNum) {
                this.videoNum = videoNum;
            }

            public Object getAdTrack() {
                return adTrack;
            }

            public void setAdTrack(Object adTrack) {
                this.adTrack = adTrack;
            }

            public FollowBean getFollow() {
                return follow;
            }

            public void setFollow(FollowBean follow) {
                this.follow = follow;
            }

            public String getAuthorType() {
                return authorType;
            }

            public void setAuthorType(String authorType) {
                this.authorType = authorType;
            }

            public static class FollowBean {
                /**
                 * itemType : author
                 * itemId : 400
                 * followed : false
                 */

                private String itemType;
                private int itemId;
                private boolean followed;

                public String getItemType() {
                    return itemType;
                }

                public void setItemType(String itemType) {
                    this.itemType = itemType;
                }

                public int getItemId() {
                    return itemId;
                }

                public void setItemId(int itemId) {
                    this.itemId = itemId;
                }

                public boolean isFollowed() {
                    return followed;
                }

                public void setFollowed(boolean followed) {
                    this.followed = followed;
                }
            }
        }

        public static class CoverBean {
            /**
             * feed : http://img.kaiyanapp.com/3586a5420e4803557e221d5ebaeb8d04.png?imageMogr2/quality/60/format/jpg
             * detail : http://img.kaiyanapp.com/3586a5420e4803557e221d5ebaeb8d04.png?imageMogr2/quality/60/format/jpg
             * blurred : http://img.kaiyanapp.com/cee6447d64899aeba600fc91a2081d7a.jpeg?imageMogr2/quality/60/format/jpg
             * sharing : null
             */

            private String feed;
            private String detail;
            private String blurred;
            private Object sharing;

            public String getFeed() {
                return feed;
            }

            public void setFeed(String feed) {
                this.feed = feed;
            }

            public String getDetail() {
                return detail;
            }

            public void setDetail(String detail) {
                this.detail = detail;
            }

            public String getBlurred() {
                return blurred;
            }

            public void setBlurred(String blurred) {
                this.blurred = blurred;
            }

            public Object getSharing() {
                return sharing;
            }

            public void setSharing(Object sharing) {
                this.sharing = sharing;
            }
        }

        public static class WebUrlBean {
            /**
             * raw : http://www.eyepetizer.net/detail.html?vid=14796
             * forWeibo : http://wandou.im/3m62x5
             */

            private String raw;
            private String forWeibo;

            public String getRaw() {
                return raw;
            }

            public void setRaw(String raw) {
                this.raw = raw;
            }

            public String getForWeibo() {
                return forWeibo;
            }

            public void setForWeibo(String forWeibo) {
                this.forWeibo = forWeibo;
            }
        }

        public static class ConsumptionBean {
            /**
             * collectionCount : 190
             * shareCount : 213
             * replyCount : 7
             */

            private int collectionCount;
            private int shareCount;
            private int replyCount;

            public int getCollectionCount() {
                return collectionCount;
            }

            public void setCollectionCount(int collectionCount) {
                this.collectionCount = collectionCount;
            }

            public int getShareCount() {
                return shareCount;
            }

            public void setShareCount(int shareCount) {
                this.shareCount = shareCount;
            }

            public int getReplyCount() {
                return replyCount;
            }

            public void setReplyCount(int replyCount) {
                this.replyCount = replyCount;
            }
        }

        public static class PlayInfoBean {
            /**
             * height : 480
             * width : 854
             * urlList : [{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=14796&editionType=normal&source=ucloud"},{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=14796&editionType=normal&source=qcloud"}]
             * name : 标清
             * type : normal
             * url : http://baobab.kaiyanapp.com/api/v1/playUrl?vid=14796&editionType=normal&source=ucloud
             */

            private int height;
            private int width;
            private String name;
            private String type;
            private String url;
            private List<UrlListBean> urlList;

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public List<UrlListBean> getUrlList() {
                return urlList;
            }

            public void setUrlList(List<UrlListBean> urlList) {
                this.urlList = urlList;
            }

            public static class UrlListBean {
                /**
                 * name : ucloud
                 * url : http://baobab.kaiyanapp.com/api/v1/playUrl?vid=14796&editionType=normal&source=ucloud
                 */

                private String name;
                private String url;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }
        }
    }
}
