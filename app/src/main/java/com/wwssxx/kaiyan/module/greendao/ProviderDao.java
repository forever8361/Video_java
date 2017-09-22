package com.wwssxx.kaiyan.module.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.wwssxx.kaiyan.model.modelforvideo.Provider;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "PROVIDER".
*/
public class ProviderDao extends AbstractDao<Provider, Long> {

    public static final String TABLENAME = "PROVIDER";

    /**
     * Properties of entity Provider.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property KeyId = new Property(0, Long.class, "keyId", true, "_id");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property Alias = new Property(2, String.class, "alias", false, "ALIAS");
        public final static Property Icon = new Property(3, String.class, "icon", false, "ICON");
    }


    public ProviderDao(DaoConfig config) {
        super(config);
    }
    
    public ProviderDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"PROVIDER\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: keyId
                "\"NAME\" TEXT," + // 1: name
                "\"ALIAS\" TEXT," + // 2: alias
                "\"ICON\" TEXT);"); // 3: icon
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"PROVIDER\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Provider entity) {
        stmt.clearBindings();
 
        Long keyId = entity.getKeyId();
        if (keyId != null) {
            stmt.bindLong(1, keyId);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        String alias = entity.getAlias();
        if (alias != null) {
            stmt.bindString(3, alias);
        }
 
        String icon = entity.getIcon();
        if (icon != null) {
            stmt.bindString(4, icon);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Provider entity) {
        stmt.clearBindings();
 
        Long keyId = entity.getKeyId();
        if (keyId != null) {
            stmt.bindLong(1, keyId);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        String alias = entity.getAlias();
        if (alias != null) {
            stmt.bindString(3, alias);
        }
 
        String icon = entity.getIcon();
        if (icon != null) {
            stmt.bindString(4, icon);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Provider readEntity(Cursor cursor, int offset) {
        Provider entity = new Provider( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // keyId
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // name
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // alias
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3) // icon
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Provider entity, int offset) {
        entity.setKeyId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setAlias(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setIcon(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Provider entity, long rowId) {
        entity.setKeyId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Provider entity) {
        if(entity != null) {
            return entity.getKeyId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Provider entity) {
        return entity.getKeyId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
