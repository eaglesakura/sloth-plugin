package com.eaglesakura.test.db.temp;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.eaglesakura.test.db.temp.DbTempEntity;

import com.eaglesakura.test.db.temp.DbTempEntityDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig dbTempEntityDaoConfig;

    private final DbTempEntityDao dbTempEntityDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        dbTempEntityDaoConfig = daoConfigMap.get(DbTempEntityDao.class).clone();
        dbTempEntityDaoConfig.initIdentityScope(type);

        dbTempEntityDao = new DbTempEntityDao(dbTempEntityDaoConfig, this);

        registerDao(DbTempEntity.class, dbTempEntityDao);
    }
    
    public void clear() {
        dbTempEntityDaoConfig.getIdentityScope().clear();
    }

    public DbTempEntityDao getDbTempEntityDao() {
        return dbTempEntityDao;
    }

}
