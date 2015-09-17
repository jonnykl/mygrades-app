package de.mygrades.database.dao;

import java.util.List;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;

import de.mygrades.database.dao.TransformerMapping;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "TRANSFORMER_MAPPING".
*/
public class TransformerMappingDao extends AbstractDao<TransformerMapping, Long> {

    public static final String TABLENAME = "TRANSFORMER_MAPPING";

    /**
     * Properties of entity TransformerMapping.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property RuleId = new Property(1, long.class, "ruleId", false, "RULE_ID");
        public final static Property Name = new Property(2, String.class, "name", false, "NAME");
        public final static Property ParseExpression = new Property(3, String.class, "parseExpression", false, "PARSE_EXPRESSION");
        public final static Property ParseType = new Property(4, String.class, "parseType", false, "PARSE_TYPE");
        public final static Property TransformerMappingId = new Property(5, long.class, "transformerMappingId", false, "TRANSFORMER_MAPPING_ID");
    };

    private Query<TransformerMapping> rule_TransformerMappingsQuery;

    public TransformerMappingDao(DaoConfig config) {
        super(config);
    }
    
    public TransformerMappingDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"TRANSFORMER_MAPPING\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"RULE_ID\" INTEGER NOT NULL ," + // 1: ruleId
                "\"NAME\" TEXT NOT NULL ," + // 2: name
                "\"PARSE_EXPRESSION\" TEXT," + // 3: parseExpression
                "\"PARSE_TYPE\" TEXT," + // 4: parseType
                "\"TRANSFORMER_MAPPING_ID\" INTEGER NOT NULL UNIQUE );"); // 5: transformerMappingId
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"TRANSFORMER_MAPPING\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, TransformerMapping entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getRuleId());
        stmt.bindString(3, entity.getName());
 
        String parseExpression = entity.getParseExpression();
        if (parseExpression != null) {
            stmt.bindString(4, parseExpression);
        }
 
        String parseType = entity.getParseType();
        if (parseType != null) {
            stmt.bindString(5, parseType);
        }
        stmt.bindLong(6, entity.getTransformerMappingId());
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public TransformerMapping readEntity(Cursor cursor, int offset) {
        TransformerMapping entity = new TransformerMapping( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getLong(offset + 1), // ruleId
            cursor.getString(offset + 2), // name
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // parseExpression
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // parseType
            cursor.getLong(offset + 5) // transformerMappingId
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, TransformerMapping entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setRuleId(cursor.getLong(offset + 1));
        entity.setName(cursor.getString(offset + 2));
        entity.setParseExpression(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setParseType(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setTransformerMappingId(cursor.getLong(offset + 5));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(TransformerMapping entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(TransformerMapping entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "transformerMappings" to-many relationship of Rule. */
    public List<TransformerMapping> _queryRule_TransformerMappings(long transformerMappingId) {
        synchronized (this) {
            if (rule_TransformerMappingsQuery == null) {
                QueryBuilder<TransformerMapping> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.TransformerMappingId.eq(null));
                rule_TransformerMappingsQuery = queryBuilder.build();
            }
        }
        Query<TransformerMapping> query = rule_TransformerMappingsQuery.forCurrentThread();
        query.setParameter(0, transformerMappingId);
        return query.list();
    }

}