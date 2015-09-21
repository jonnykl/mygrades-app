package de.mygrades.database.dao;

import java.util.List;
import de.mygrades.database.dao.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END
/**
 * Entity mapped to table "ACTION".
 */
public class Action {

    private Long id;
    private long actionId;
    private int position;
    /** Not-null value. */
    private String method;
    private String url;
    private String parseExpression;
    private String parseType;
    private long ruleId;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient ActionDao myDao;

    private List<ActionParam> actionParams;

    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    public Action() {
    }

    public Action(Long id) {
        this.id = id;
    }

    public Action(Long id, long actionId, int position, String method, String url, String parseExpression, String parseType, long ruleId) {
        this.id = id;
        this.actionId = actionId;
        this.position = position;
        this.method = method;
        this.url = url;
        this.parseExpression = parseExpression;
        this.parseType = parseType;
        this.ruleId = ruleId;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getActionDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getActionId() {
        return actionId;
    }

    public void setActionId(long actionId) {
        this.actionId = actionId;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    /** Not-null value. */
    public String getMethod() {
        return method;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getParseExpression() {
        return parseExpression;
    }

    public void setParseExpression(String parseExpression) {
        this.parseExpression = parseExpression;
    }

    public String getParseType() {
        return parseType;
    }

    public void setParseType(String parseType) {
        this.parseType = parseType;
    }

    public long getRuleId() {
        return ruleId;
    }

    public void setRuleId(long ruleId) {
        this.ruleId = ruleId;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<ActionParam> getActionParams() {
        if (actionParams == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ActionParamDao targetDao = daoSession.getActionParamDao();
            List<ActionParam> actionParamsNew = targetDao._queryAction_ActionParams(id);
            synchronized (this) {
                if(actionParams == null) {
                    actionParams = actionParamsNew;
                }
            }
        }
        return actionParams;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetActionParams() {
        actionParams = null;
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

    // KEEP METHODS - put your custom methods here

    public void setActionParams(List<ActionParam> actionParams) {
        this.actionParams = actionParams;
    }

    public List<ActionParam> getActionParamsRaw() {
        return actionParams == null ? new java.util.ArrayList<ActionParam>() : actionParams;
    }
    // KEEP METHODS END

}
