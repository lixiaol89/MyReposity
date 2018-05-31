package com.huatai.cube.rms.modules.mktquotation.model;

import java.math.BigDecimal;
import java.util.Date;

import com.huatai.cube.rms.core.aop.annotation.XField;
import com.huatai.cube.server.common.utils.CubeXFields;

public class LivePriceModel {
	private Integer id;
	@XField(CubeXFields.Booking.tradeDate)
    private Date nowdate;
    @XField(CubeXFields.Common.underlying)
    private String underlying;
    @XField(CubeXFields.Common.currency)
    private String currency;
    @XField(CubeXFields.Common.exchangeCode)
    private String exchangecode;
    @XField(CubeXFields.Common.last)
    private BigDecimal last;
    @XField(CubeXFields.Common.close)
    private BigDecimal close;
    @XField(CubeXFields.Common.open)
    private BigDecimal open;
    @XField(CubeXFields.Common.high)
    private BigDecimal high;
    @XField(CubeXFields.Common.low)
    private BigDecimal low;
    @XField(CubeXFields.Common.settlePrice)
    private BigDecimal settleprice;
    @XField(CubeXFields.Common.stopFlag)
    private Boolean stopflag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getNowdate() {
        return nowdate;
    }

    public void setNowdate(Date nowdate) {
        this.nowdate = nowdate;
    }

    public String getUnderlying() {
        return underlying;
    }

    public void setUnderlying(String underlying) {
        this.underlying = underlying == null ? null : underlying.trim();
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public String getExchangecode() {
        return exchangecode;
    }

    public void setExchangecode(String exchangecode) {
        this.exchangecode = exchangecode == null ? null : exchangecode.trim();
    }

    public Boolean getStopflag() {
        return stopflag;
    }

    public void setStopflag(Boolean stopflag) {
        this.stopflag = stopflag;
    }

    public BigDecimal getLast() {
        return last;
    }

    public void setLast(BigDecimal last) {
        this.last = last;
    }

    public BigDecimal getClose() {
        return close;
    }

    public void setClose(BigDecimal close) {
        this.close = close;
    }

    public BigDecimal getOpen() {
        return open;
    }

    public void setOpen(BigDecimal open) {
        this.open = open;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public void setHigh(BigDecimal high) {
        this.high = high;
    }

    public BigDecimal getLow() {
        return low;
    }

    public void setLow(BigDecimal low) {
        this.low = low;
    }

    public BigDecimal getSettleprice() {
        return settleprice;
    }

    public void setSettleprice(BigDecimal settleprice) {
        this.settleprice = settleprice;
    }
}