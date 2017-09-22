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

import com.wwssxx.kaiyan.model.modelforvideo.UrlList;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "URL_LIST".
*/
public class UrlListDao extends AbstractDao<UrlList, Long> {

    public static final String TABLENAME = "URL_LIST";

    /**
     * Properties of entity UrlList.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property KeyId = new Property(0, Long.class, "keyId", true, "_id");
        public final static Property CustomerId2 = new Property(1, long.class, "customerId2", false, "CUSTOMER_ID2");
        public final static Property Name = new Property(2, String.class, "name", false, "NAME");
        public final static Property Url = new Property(3, String.class, "url", false, "URL");
    }

    private Query<UrlList> playInfo_UrlListQuery;

    public UrlListDao(DaoConfig config) {
        super(config);
    }
    
    public UrlListDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"URL_LIST\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: keyId
                "\"CUSTOMER_ID2\" INTEGER NOT NULL ," + // 1: customerId2
                "\"NAME\" TEXT," + // 2: name
                "\"URL\" TEXT);"); // 3: url
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"URL_LIST\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, UrlList entity) {
        stmt.clearBindings();
 
        Long keyId = entity.getKeyId();
        if (keyId != null) {
            stmt.bindLong(1, keyId);
        }
        stmt.bindLong(2, entity.getCustomerId2());
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(3, name);
        }
 
        String url = entity.getUrl();
        if (url != null) {
            stmt.bindString(4, url);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, UrlList entity) {
        stmt.clearBindings();
 
        Long keyId = entity.getKeyId();
        if (keyId != null) {
            stmt.bindLong(1, keyId);
        }
        stmt.bindLong(2, entity.getCustomerId2());
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(3, name);
        }
 
        String url = entity.getUrl();
        if (url != null) {
            stmt.bindString(4, url);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public UrlList readEntity(Cursor cursor, int offset) {
        UrlList entity = new UrlList( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // keyId
            cursor.getLong(offset + 1), // customerId2
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // name
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3) // url
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, UrlList entity, int offset) {
        entity.setKeyId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setCustomerId2(cursor.getLong(offset + 1));
        entity.setName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setUrl(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(UrlList entity, long rowId) {
        entity.setKeyId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(UrlList entity) {
        if(entity != null) {
            return entity.getKeyId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(UrlList entity) {
        return entity.getKeyId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "urlList" to-many relationship of PlayInfo. */
    public List<UrlList> _queryPlayInfo_UrlList(long customerId2) {
        synchronized (this) {
            if (playInfo_UrlListQuery == null) {
                QueryBuilder<UrlList> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.CustomerId2.eq(null));
                playInfo_UrlListQuery = queryBuilder.build();
            }
        }
        Query<UrlList> query = playInfo_UrlListQuery.forCurrentThread();
        query.setParameter(0, customerId2);
        return query.list();
    }

}
