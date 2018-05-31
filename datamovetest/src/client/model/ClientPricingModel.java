package com.huatai.cube.rms.modules.client.model;

import java.math.BigDecimal;

import com.huatai.cube.rms.core.aop.annotation.XField;
import com.huatai.cube.server.common.utils.CubeXFields;

public class ClientPricingModel {
    private Integer id;

    @XField(CubeXFields.Common.clientID)
    private String clientid;

    @XField(CubeXFields.Booking.templateType)
    private String templatetype;

    @XField(CubeXFields.Common.orderSide)
    private Integer longshort;

    @XField(CubeXFields.Common.scale)
    private BigDecimal quota;

    @XField(CubeXFields.Booking.settleCcy)
    private String settleccy;

    @XField(CubeXFields.Booking.salesID)
    private String salesid;

    @XField(CubeXFields.Booking.edge)
    private BigDecimal edge;

    @XField(CubeXFields.Booking.initialMargin)
    private BigDecimal initalmargin;

    @XField(CubeXFields.Booking.marginWarningLevel)
    private BigDecimal marginwarninglevel;

    @XField(CubeXFields.Booking.marginCallLevel)
    private BigDecimal margincalllevel;

    @XField(CubeXFields.Booking.liquidationLevel)
    private BigDecimal liquiditionlevel;

    @XField(CubeXFields.Booking.marginNet)
    private Integer marginnet;

    @XField(CubeXFields.Booking.leverage)
    private BigDecimal leverage;

    @XField(CubeXFields.Booking.fundingRate)
    private BigDecimal fundingrate;

    @XField(CubeXFields.Booking.fundingCcy)
    private String fundingccy;

    @XField(CubeXFields.Booking.commissionRate)
    private BigDecimal commission;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClientid() {
        return clientid;
    }

    public void setClientid(String clientid) {
        this.clientid = clientid == null ? null : clientid.trim();
    }

    public String getTemplatetype() {
        return templatetype;
    }

    public void setTemplatetype(String templatetype) {
        this.templatetype = templatetype == null ? null : templatetype.trim();
    }

    public Integer getLongshort() {
        return longshort;
    }

    public void setLongshort(Integer longshort) {
        this.longshort = longshort;
    }

    public BigDecimal getQuota() {
        return quota;
    }

    public void setQuota(BigDecimal quota) {
        this.quota = quota;
    }

    public String getSettleccy() {
        return settleccy;
    }

    public void setSettleccy(String settleccy) {
        this.settleccy = settleccy == null ? null : settleccy.trim();
    }

    public String getSalesid() {
        return salesid;
    }

    public void setSalesid(String salesid) {
        this.salesid = salesid == null ? null : salesid.trim();
    }

    public BigDecimal getEdge() {
        return edge;
    }

    public void setEdge(BigDecimal edge) {
        this.edge = edge;
    }

    public BigDecimal getInitalmargin() {
        return initalmargin;
    }

    public void setInitalmargin(BigDecimal initalmargin) {
        this.initalmargin = initalmargin;
    }

    public BigDecimal getMarginwarninglevel() {
        return marginwarninglevel;
    }

    public void setMarginwarninglevel(BigDecimal marginwarninglevel) {
        this.marginwarninglevel = marginwarninglevel;
    }

    public BigDecimal getMargincalllevel() {
        return margincalllevel;
    }

    public void setMargincalllevel(BigDecimal margincalllevel) {
        this.margincalllevel = margincalllevel;
    }

    public BigDecimal getLiquiditionlevel() {
        return liquiditionlevel;
    }

    public void setLiquiditionlevel(BigDecimal liquiditionlevel) {
        this.liquiditionlevel = liquiditionlevel;
    }

    public Integer getMarginnet() {
        return marginnet;
    }

    public void setMarginnet(Integer marginnet) {
        this.marginnet = marginnet;
    }

    public BigDecimal getLeverage() {
        return leverage;
    }

    public void setLeverage(BigDecimal leverage) {
        this.leverage = leverage;
    }

    public BigDecimal getFundingrate() {
        return fundingrate;
    }

    public void setFundingrate(BigDecimal fundingrate) {
        this.fundingrate = fundingrate;
    }

    public String getFundingccy() {
        return fundingccy;
    }

    public void setFundingccy(String fundingccy) {
        this.fundingccy = fundingccy == null ? null : fundingccy.trim();
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }
}