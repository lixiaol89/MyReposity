package com.huatai.cube.server.ts.modules.lendingAccountPosition.model;

import java.util.Date;

import com.huatai.cube.server.ts.core.aop.annotation.XField;
import com.huatai.cube.server.ts.util.define.securitypool.SecurityPoolXFields;

public class LendingAccountPositionModel {
    private Integer id;

    @XField(SecurityPoolXFields.SecurityPoolDetail.ProductAccount)
    private String productaccount;

    @XField(SecurityPoolXFields.SecurityPoolDetail.AssetAccount)
    private String assetaccount;

    @XField(SecurityPoolXFields.SecurityPoolDetail.TradingAccount)
    private String tradingaccount;

    @XField(SecurityPoolXFields.SecurityPoolDetail.SecurityAccount)
    private String securityaccount;

    @XField(SecurityPoolXFields.SecurityPoolDetail.ExecBroker)
    private String execbroker;

    @XField(SecurityPoolXFields.SecurityPoolDetail.SecurityExchange)
    private String securityexchange;

    @XField(SecurityPoolXFields.SecurityPoolDetail.Underlying)
    private String underlying;

    @XField(SecurityPoolXFields.SecurityPoolDetail.UnderlyingName)
    private String underlyingname;

    @XField(SecurityPoolXFields.SecurityPoolDetail.Position)
    private Integer position;

    @XField(SecurityPoolXFields.SecurityPoolDetail.LastUpdateTime)
    private Date lastupdatetime;

    @XField(SecurityPoolXFields.SecurityPoolDetail.LastUpdateUser)
    private String lastupdateuser;

    @XField(SecurityPoolXFields.SecurityPoolDetail.ShortAmount)
    private Integer shortamount;

    @XField(SecurityPoolXFields.SecurityPoolDetail.Date)
    private Date date;

    private Integer todayboughtamount;

    private Integer todayshortedamount;

    private Boolean isvaid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductaccount() {
        return productaccount;
    }

    public void setProductaccount(String productaccount) {
        this.productaccount = productaccount == null ? null : productaccount.trim();
    }

    public String getAssetaccount() {
        return assetaccount;
    }

    public void setAssetaccount(String assetaccount) {
        this.assetaccount = assetaccount == null ? null : assetaccount.trim();
    }

    public String getTradingaccount() {
        return tradingaccount;
    }

    public void setTradingaccount(String tradingaccount) {
        this.tradingaccount = tradingaccount == null ? null : tradingaccount.trim();
    }

    public String getSecurityaccount() {
        return securityaccount;
    }

    public void setSecurityaccount(String securityaccount) {
        this.securityaccount = securityaccount == null ? null : securityaccount.trim();
    }

    public String getExecbroker() {
        return execbroker;
    }

    public void setExecbroker(String execbroker) {
        this.execbroker = execbroker == null ? null : execbroker.trim();
    }

    public String getSecurityexchange() {
        return securityexchange;
    }

    public void setSecurityexchange(String securityexchange) {
        this.securityexchange = securityexchange == null ? null : securityexchange.trim();
    }

    public String getUnderlying() {
        return underlying;
    }

    public void setUnderlying(String underlying) {
        this.underlying = underlying == null ? null : underlying.trim();
    }

    public String getUnderlyingname() {
        return underlyingname;
    }

    public void setUnderlyingname(String underlyingname) {
        this.underlyingname = underlyingname == null ? null : underlyingname.trim();
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Date getLastupdatetime() {
        return lastupdatetime;
    }

    public void setLastupdatetime(Date lastupdatetime) {
        this.lastupdatetime = lastupdatetime;
    }

    public String getLastupdateuser() {
        return lastupdateuser;
    }

    public void setLastupdateuser(String lastupdateuser) {
        this.lastupdateuser = lastupdateuser == null ? null : lastupdateuser.trim();
    }

    public Integer getShortamount() {
        return shortamount;
    }

    public void setShortamount(Integer shortamount) {
        this.shortamount = shortamount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getTodayboughtamount() {
        return todayboughtamount;
    }

    public void setTodayboughtamount(Integer todayboughtamount) {
        this.todayboughtamount = todayboughtamount;
    }

    public Integer getTodayshortedamount() {
        return todayshortedamount;
    }

    public void setTodayshortedamount(Integer todayshortedamount) {
        this.todayshortedamount = todayshortedamount;
    }

    public Boolean getIsvaid() {
        return isvaid;
    }

    public void setIsvaid(Boolean isvaid) {
        this.isvaid = isvaid;
    }
}