package com.whkj.project.entity;

import java.util.Date;

public class User {
    private String host;

    private String user;

    private Object selectPriv;

    private Object insertPriv;

    private Object updatePriv;

    private Object deletePriv;

    private Object createPriv;

    private Object dropPriv;

    private Object reloadPriv;

    private Object shutdownPriv;

    private Object processPriv;

    private Object filePriv;

    private Object grantPriv;

    private Object referencesPriv;

    private Object indexPriv;

    private Object alterPriv;

    private Object showDbPriv;

    private Object superPriv;

    private Object createTmpTablePriv;

    private Object lockTablesPriv;

    private Object executePriv;

    private Object replSlavePriv;

    private Object replClientPriv;

    private Object createViewPriv;

    private Object showViewPriv;

    private Object createRoutinePriv;

    private Object alterRoutinePriv;

    private Object createUserPriv;

    private Object eventPriv;

    private Object triggerPriv;

    private Object createTablespacePriv;

    private Object sslType;

    private byte[] sslCipher;

    private byte[] x509Issuer;

    private byte[] x509Subject;

    private Integer maxQuestions;

    private Integer maxUpdates;

    private Integer maxConnections;

    private Integer maxUserConnections;

    private String plugin;

    private String authenticationString;

    private Object passwordExpired;

    private Date passwordLastChanged;

    private Short passwordLifetime;

    private Object accountLocked;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Object getSelectPriv() {
        return selectPriv;
    }

    public void setSelectPriv(Object selectPriv) {
        this.selectPriv = selectPriv;
    }

    public Object getInsertPriv() {
        return insertPriv;
    }

    public void setInsertPriv(Object insertPriv) {
        this.insertPriv = insertPriv;
    }

    public Object getUpdatePriv() {
        return updatePriv;
    }

    public void setUpdatePriv(Object updatePriv) {
        this.updatePriv = updatePriv;
    }

    public Object getDeletePriv() {
        return deletePriv;
    }

    public void setDeletePriv(Object deletePriv) {
        this.deletePriv = deletePriv;
    }

    public Object getCreatePriv() {
        return createPriv;
    }

    public void setCreatePriv(Object createPriv) {
        this.createPriv = createPriv;
    }

    public Object getDropPriv() {
        return dropPriv;
    }

    public void setDropPriv(Object dropPriv) {
        this.dropPriv = dropPriv;
    }

    public Object getReloadPriv() {
        return reloadPriv;
    }

    public void setReloadPriv(Object reloadPriv) {
        this.reloadPriv = reloadPriv;
    }

    public Object getShutdownPriv() {
        return shutdownPriv;
    }

    public void setShutdownPriv(Object shutdownPriv) {
        this.shutdownPriv = shutdownPriv;
    }

    public Object getProcessPriv() {
        return processPriv;
    }

    public void setProcessPriv(Object processPriv) {
        this.processPriv = processPriv;
    }

    public Object getFilePriv() {
        return filePriv;
    }

    public void setFilePriv(Object filePriv) {
        this.filePriv = filePriv;
    }

    public Object getGrantPriv() {
        return grantPriv;
    }

    public void setGrantPriv(Object grantPriv) {
        this.grantPriv = grantPriv;
    }

    public Object getReferencesPriv() {
        return referencesPriv;
    }

    public void setReferencesPriv(Object referencesPriv) {
        this.referencesPriv = referencesPriv;
    }

    public Object getIndexPriv() {
        return indexPriv;
    }

    public void setIndexPriv(Object indexPriv) {
        this.indexPriv = indexPriv;
    }

    public Object getAlterPriv() {
        return alterPriv;
    }

    public void setAlterPriv(Object alterPriv) {
        this.alterPriv = alterPriv;
    }

    public Object getShowDbPriv() {
        return showDbPriv;
    }

    public void setShowDbPriv(Object showDbPriv) {
        this.showDbPriv = showDbPriv;
    }

    public Object getSuperPriv() {
        return superPriv;
    }

    public void setSuperPriv(Object superPriv) {
        this.superPriv = superPriv;
    }

    public Object getCreateTmpTablePriv() {
        return createTmpTablePriv;
    }

    public void setCreateTmpTablePriv(Object createTmpTablePriv) {
        this.createTmpTablePriv = createTmpTablePriv;
    }

    public Object getLockTablesPriv() {
        return lockTablesPriv;
    }

    public void setLockTablesPriv(Object lockTablesPriv) {
        this.lockTablesPriv = lockTablesPriv;
    }

    public Object getExecutePriv() {
        return executePriv;
    }

    public void setExecutePriv(Object executePriv) {
        this.executePriv = executePriv;
    }

    public Object getReplSlavePriv() {
        return replSlavePriv;
    }

    public void setReplSlavePriv(Object replSlavePriv) {
        this.replSlavePriv = replSlavePriv;
    }

    public Object getReplClientPriv() {
        return replClientPriv;
    }

    public void setReplClientPriv(Object replClientPriv) {
        this.replClientPriv = replClientPriv;
    }

    public Object getCreateViewPriv() {
        return createViewPriv;
    }

    public void setCreateViewPriv(Object createViewPriv) {
        this.createViewPriv = createViewPriv;
    }

    public Object getShowViewPriv() {
        return showViewPriv;
    }

    public void setShowViewPriv(Object showViewPriv) {
        this.showViewPriv = showViewPriv;
    }

    public Object getCreateRoutinePriv() {
        return createRoutinePriv;
    }

    public void setCreateRoutinePriv(Object createRoutinePriv) {
        this.createRoutinePriv = createRoutinePriv;
    }

    public Object getAlterRoutinePriv() {
        return alterRoutinePriv;
    }

    public void setAlterRoutinePriv(Object alterRoutinePriv) {
        this.alterRoutinePriv = alterRoutinePriv;
    }

    public Object getCreateUserPriv() {
        return createUserPriv;
    }

    public void setCreateUserPriv(Object createUserPriv) {
        this.createUserPriv = createUserPriv;
    }

    public Object getEventPriv() {
        return eventPriv;
    }

    public void setEventPriv(Object eventPriv) {
        this.eventPriv = eventPriv;
    }

    public Object getTriggerPriv() {
        return triggerPriv;
    }

    public void setTriggerPriv(Object triggerPriv) {
        this.triggerPriv = triggerPriv;
    }

    public Object getCreateTablespacePriv() {
        return createTablespacePriv;
    }

    public void setCreateTablespacePriv(Object createTablespacePriv) {
        this.createTablespacePriv = createTablespacePriv;
    }

    public Object getSslType() {
        return sslType;
    }

    public void setSslType(Object sslType) {
        this.sslType = sslType;
    }

    public byte[] getSslCipher() {
        return sslCipher;
    }

    public void setSslCipher(byte[] sslCipher) {
        this.sslCipher = sslCipher;
    }

    public byte[] getX509Issuer() {
        return x509Issuer;
    }

    public void setX509Issuer(byte[] x509Issuer) {
        this.x509Issuer = x509Issuer;
    }

    public byte[] getX509Subject() {
        return x509Subject;
    }

    public void setX509Subject(byte[] x509Subject) {
        this.x509Subject = x509Subject;
    }

    public Integer getMaxQuestions() {
        return maxQuestions;
    }

    public void setMaxQuestions(Integer maxQuestions) {
        this.maxQuestions = maxQuestions;
    }

    public Integer getMaxUpdates() {
        return maxUpdates;
    }

    public void setMaxUpdates(Integer maxUpdates) {
        this.maxUpdates = maxUpdates;
    }

    public Integer getMaxConnections() {
        return maxConnections;
    }

    public void setMaxConnections(Integer maxConnections) {
        this.maxConnections = maxConnections;
    }

    public Integer getMaxUserConnections() {
        return maxUserConnections;
    }

    public void setMaxUserConnections(Integer maxUserConnections) {
        this.maxUserConnections = maxUserConnections;
    }

    public String getPlugin() {
        return plugin;
    }

    public void setPlugin(String plugin) {
        this.plugin = plugin;
    }

    public String getAuthenticationString() {
        return authenticationString;
    }

    public void setAuthenticationString(String authenticationString) {
        this.authenticationString = authenticationString;
    }

    public Object getPasswordExpired() {
        return passwordExpired;
    }

    public void setPasswordExpired(Object passwordExpired) {
        this.passwordExpired = passwordExpired;
    }

    public Date getPasswordLastChanged() {
        return passwordLastChanged;
    }

    public void setPasswordLastChanged(Date passwordLastChanged) {
        this.passwordLastChanged = passwordLastChanged;
    }

    public Short getPasswordLifetime() {
        return passwordLifetime;
    }

    public void setPasswordLifetime(Short passwordLifetime) {
        this.passwordLifetime = passwordLifetime;
    }

    public Object getAccountLocked() {
        return accountLocked;
    }

    public void setAccountLocked(Object accountLocked) {
        this.accountLocked = accountLocked;
    }
}