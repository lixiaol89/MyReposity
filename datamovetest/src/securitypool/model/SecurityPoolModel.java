package com.huatai.cube.server.ts.modules.securitypool.model;

import java.math.BigDecimal;
import java.util.Date;

import com.huatai.cube.server.ts.core.aop.annotation.XField;
import com.huatai.cube.server.ts.util.define.securitypool.SecurityPoolXFields;

/**
 * 券池管理
 * @author K0180007
 *
 */
public class SecurityPoolModel {
	/**
	 * 主键
	 */
    private Integer id;
    /**
	 * 交易市场
	 */
    @XField(SecurityPoolXFields.SecurityPool.SecurityExchange)
    private String securityexchange;
    /**
	 * 证券代码
	 */
    @XField(SecurityPoolXFields.SecurityPool.Underlying)
    private String underlying;
    /**
	 * 证券名称
	 */
    @XField(SecurityPoolXFields.SecurityPool.UnderlyingName)
    private String underlyingname;
    /**
	 * 总数
	 */
    @XField(SecurityPoolXFields.SecurityPool.TotalAmount)
    private Integer totalamount;
    /**
	 * 持仓
	 */
    @XField(SecurityPoolXFields.SecurityPool.Position)
    private Integer position;
    /**
	 * 已借数量
	 */
    @XField(SecurityPoolXFields.SecurityPool.LentAmount)
    private Integer lentamount;
    /**
	 * 可借数量
	 */
    @XField(SecurityPoolXFields.SecurityPool.LendAbleAmount)
    private Integer lendableamount;
    /**
	 * 锁仓数量
	 */
    @XField(SecurityPoolXFields.SecurityPool.LockedAmount)
    private Integer lockedamount;
    /**
	 * 剩余可借
	 */
    @XField(SecurityPoolXFields.SecurityPool.LeftAmount)
    private Integer leftamount;
    /**
	 * 利率
	 */
    @XField(SecurityPoolXFields.SecurityPool.InterestRate)
    private BigDecimal interestrate;
    /**
	 * 最后更新人
	 */
    @XField(SecurityPoolXFields.SecurityPool.LastUpdateUser)
    private String lastupdateuser;
    /**
	 * 最后更新时间
	 */
    @XField(SecurityPoolXFields.SecurityPool.LastUpdateTime)
    private Date lastupdatetime;
    /**
     * 可卖空额度
     */
    @XField(SecurityPoolXFields.SecurityPool.ShortAbleamount)
    private Integer shortableamount;
    /**
     * 卖空额度
     */
    @XField(SecurityPoolXFields.SecurityPool.ShortAmount)
    private Integer shortamount;
    /**
     * 已卖空额度
     */
    @XField(SecurityPoolXFields.SecurityPool.ShortedAmount)
    private Integer shortedamount;
    /**
     * 更新日期
     */
    @XField(SecurityPoolXFields.SecurityPool.Date)
    private Date date;

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
}