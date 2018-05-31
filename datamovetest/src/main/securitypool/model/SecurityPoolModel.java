package com.huatai.cube.server.ts.modules.securitypool.model;

import java.math.BigDecimal;
import java.util.Date;

import com.huatai.cube.server.common.utils.CubeXFields;
import com.huatai.cube.server.ts.core.aop.annotation.XField;
public class SecurityPoolModel {
    private Integer id;
    
    @XField(CubeXFields.Common.exchangeCode)
    private String securityexchange;
    
    @XField(CubeXFields.Common.underlying)
    private String underlying;
    
    @XField(CubeXFields.Common.underlyingName)
    private String underlyingname;
    
    @XField(CubeXFields.Trading.totalAmount)
    private Integer totalamount;
    
    @XField(CubeXFields.Booking.position)
    private Integer position;
    
    @XField(CubeXFields.Trading.lentAmount)
    private Integer lentamount;
    
    @XField(CubeXFields.Trading.lendAbleAmount)
    private Integer lendableamount;
    
    @XField(CubeXFields.Trading.lockedAmount)
    private Integer lockedamount;
   
    @XField(CubeXFields.Trading.leftAmount)
    private Integer leftamount;
    
    @XField(CubeXFields.Common.interestRate)
    private BigDecimal interestrate;
    
    @XField(CubeXFields.Common.lastUpdateUser)
    private String lastupdateuser;
   
    @XField(CubeXFields.Common.lastUpdateTime)
    private Date lastupdatetime;
    
    @XField(CubeXFields.Trading.shortAbleamount)
    private Integer shortableamount;
    
    @XField(CubeXFields.Trading.shortAmount)
    private Integer shortamount;
    
    @XField(CubeXFields.Trading.shortedAmount)
    private Integer shortedamount;
    
    @XField(CubeXFields.Booking.tradeDate)
    private Date date;

    @XField(CubeXFields.Common.overAssetAccountType)
    private String customertype;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(Integer totalamount) {
        this.totalamount = totalamount;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getLentamount() {
        return lentamount;
    }

    public void setLentamount(Integer lentamount) {
        this.lentamount = lentamount;
    }

    public Integer getLendableamount() {
        return lendableamount;
    }

    public void setLendableamount(Integer lendableamount) {
        this.lendableamount = lendableamount;
    }

    public Integer getLockedamount() {
        return lockedamount;
    }

    public void setLockedamount(Integer lockedamount) {
        this.lockedamount = lockedamount;
    }

    public Integer getLeftamount() {
        return leftamount;
    }

    public void setLeftamount(Integer leftamount) {
        this.leftamount = leftamount;
    }

    public BigDecimal getInterestrate() {
        return interestrate;
    }

    public void setInterestrate(BigDecimal interestrate) {
        this.interestrate = interestrate;
    }

    public String getLastupdateuser() {
        return lastupdateuser;
    }

    public void setLastupdateuser(String lastupdateuser) {
        this.lastupdateuser = lastupdateuser == null ? null : lastupdateuser.trim();
    }

    public Date getLastupdatetime() {
        return lastupdatetime;
    }

    public void setLastupdatetime(Date lastupdatetime) {
        this.lastupdatetime = lastupdatetime;
    }

    public Integer getShortableamount() {
        return shortableamount;
    }

    public void setShortableamount(Integer shortableamount) {
        this.shortableamount = shortableamount;
    }

    public Integer getShortamount() {
        return shortamount;
    }

    public void setShortamount(Integer shortamount) {
        this.shortamount = shortamount;
    }

    public Integer getShortedamount() {
        return shortedamount;
    }

    public void setShortedamount(Integer shortedamount) {
        this.shortedamount = shortedamount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCustomertype() {
        return customertype;
    }

    public void setCustomertype(String customertype) {
        this.customertype = customertype == null ? null : customertype.trim();
    }
}