package com.wwssxx.kaiyan.module.greendao;

import java.util.List;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import com.wwssxx.kaiyan.model.modelforvideo.PlayInfo;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "PLAY_INFO".
*/
public class PlayInfoDao extends AbstractDao<PlayInfo, Long> {

    public static final String TABLENAME = "PLAY_INFO";

    /**
     * Properties of entity PlayInfo.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property KeyId = new Property(0, Long.class, "keyId", true, "_id");
        public final static Property CustomerId = new Property(1, long.class, "customerId", false, "CUSTOMER_ID");
        public final static Property Height = new Property(2, int.class, "height", false, "HEIGHT");
        public final static Property Width = new Property(3, int.class, "width", false, "WIDTH");
        public final static Property Name = new Property(4, String.class, "name", false, "NAME");
        public final static Property Type = new Property(5, String.class, "type", false, "TYPE");
        public final static Property Url = new Property(6, String.class, "url", false, "URL");
    }

    private DaoSession daoSession;

    private Query<PlayInfo> video_PlayInfoQuery;

    public PlayInfoDao(DaoConfig config) {
        super(config);
    }
    
    public PlayInfoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"PLAY_INFO\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: keyId
                "\"CUSTOMER_ID\" INTEGER NOT NULL ," + // 1: customerId
                "\"HEIGHT\" INTEGER NOT NULL ," + // 2: height
                "\"WIDTH\" INTEGER NOT NULL ," + // 3: width
                "\"NAME\" TEXT," + // 4: name
                "\"TYPE\" TEXT," + // 5: type
                "\"URL\" TEXT);"); // 6: url
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"PLAY_INFO\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, PlayInfo entity) {
        stmt.clearBindings();
 
        Long keyId = entity.getKeyId();
        if (keyId != null) {
            stmt.bindLong(1, keyId);
        }
        stmt.bindLong(2, entity.getCustomerId());
        stmt.bindLong(3, entity.getHeight());
        stmt.bindLong(4, entity.getWidth());
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(5, name);
        }
 
        String type = entity.getType();
        if (type != null) {
            stmt.bindString(6, type);
        }
 
        String url = entity.getUrl();
        if (url != null) {
            stmt.bindString(7, url);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, PlayInfo entity) {
        stmt.clearBindings();
 
        Long keyId = entity.getKeyId();
        if (keyId != null) {
            stmt.bindLong(1, keyId);
        }
        stmt.bindLong(2, entity.getCustomerId());
        stmt.bindLong(3, entity.getHeight());
        stmt.bindLong(4, entity.getWidth());
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(5, name);
        }
 
        String type = entity.getType();
        if (type != null) {
            stmt.bindString(6, type);
        }
 
        String url = entity.getUrl();
        if (url != null) {
            stmt.bindString(7, url);
        }
    }

    @Override
    protected final void attachEntity(PlayInfo entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public PlayInfo readEntity(Cursor cursor, int offset) {
        PlayInfo entity = new PlayInfo( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // keyId
            cursor.getLong(offset + 1), // customerId
            cursor.getInt(offset + 2), // height
            cursor.getInt(offset + 3), // width
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // name
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // type
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6) // url
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, PlayInfo entity, int offset) {
        entity.setKeyId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setCustomerId(cursor.getLong(offset + 1));
        entity.setHeight(cursor.getInt(offset + 2));
        entity.setWidth(cursor.getInt(offset + 3));
        entity.setName(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setType(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setUrl(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(PlayInfo entity, long rowId) {
        entity.setKeyId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(PlayInfo entity) {
        if(entity != null) {
            return entity.getKeyId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(PlayInfo entity) {
        return entity.getKeyId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "playInfo" to-many relationship of Video. */
    public List<PlayInfo> _queryVideo_PlayInfo(long customerId) {
        synchronized (this) {
            if (video_PlayInfoQuery == null) {
                QueryBuilder<PlayInfo> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.CustomerId.eq(null));
                video_PlayInfoQuery = queryBuilder.build();
            }
        }
        Query<PlayInfo> query = video_PlayInfoQuery.forCurrentThread();
        query.setParameter(0, customerId);
        return query.list();
    }

}
