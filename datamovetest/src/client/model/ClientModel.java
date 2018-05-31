package com.huatai.cube.rms.modules.client.model;

import java.math.BigDecimal;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.huatai.cube.rms.core.aop.annotation.XField;
import com.huatai.cube.server.common.utils.CubeXFields;

public class ClientModel {
    private Integer id;

    @XField(CubeXFields.Common.clientID)
    private String clientid;

    @XField(CubeXFields.Common.clientName)
    private String clientname;

    @XField(CubeXFields.Common.organCode)
    private String organcode;

    @XField(CubeXFields.Common.organName)
    private String organname;

    @XField(CubeXFields.Common.investorAccount)
    private String investoraccount;

    @XField(CubeXFields.Common.investorName)
    private String investorname;

    @XField(CubeXFields.Common.productAccount)
    private String productaccount;

    @XField(CubeXFields.Common.productName)
    private String productname;

    @XField(CubeXFields.Common.tradingAccount)
    private String tradingaccount;

    @XField(CubeXFields.Common.tradingName)
    private String tradingaccountname;

    @XField(CubeXFields.Common.ExtAssetAccount)
    private String extassetaccount;

    @XField(CubeXFields.Common.overAssetAccountType)
    private Integer overassetaccounttype;

    @XField(CubeXFields.Common.email)
    private String email;

    @XField(CubeXFields.Common.marginMultiplier)
    private BigDecimal marginmultiplier;

    @XField(CubeXFields.Common.marginCallRatio)
    private BigDecimal margincallratio;

    @XField(CubeXFields.Common.marginCcy)
    private String marginccy;

    @XField(CubeXFields.Common.fundCost)
    private BigDecimal fundcost;

    @XField(CubeXFields.Common.interestRate)
    private BigDecimal interestrate;

    @XField(CubeXFields.Common.referee)
    private String referee;

    @XField(CubeXFields.Common.senderBankName)
    private String senderbankname;

    @XField(CubeXFields.Common.senderAccountNo)
    private String senderaccountno;

    @XField(CubeXFields.Common.senderName)
    private String sendername;

    @XField(CubeXFields.Common.receiverBankName)
    private String receiverbankname;

    @XField(CubeXFields.Common.receiverAccountNo)
    private String receiveraccountno;

    @XField(CubeXFields.Common.receiverName)
    private String receivername;

    @XField(CubeXFields.Common.cnapsBankCode)
    private String cnapsbankcode;

    @XField(CubeXFields.Common.lastUpdateUser)
    private String lastupdateuser;

    @XField(CubeXFields.Common.lastUpdateTime)
    private Date lastupdatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @JSONField(name = "ClientID")
    public String getClientid() {
        return clientid;
    }
    @JSONField(name = "ClientID")
    public void setClientid(String clientid) {
        this.clientid = clientid == null ? null : clientid.trim();
    }
    @JSONField(name = "ClientName")
    public String getClientname() {
        return clientname;
    }
    @JSONField(name = "ClientName")
    public void setClientname(String clientname) {
        this.clientname = clientname == null ? null : clientname.trim();
    }

    public String getOrgancode() {
        return organcode;
    }

    public void setOrgancode(String organcode) {
        this.organcode = organcode == null ? null : organcode.trim();
    }

    public String getOrganname() {
        return organname;
    }

    public void setOrganname(String organname) {
        this.organname = organname == null ? null : organname.trim();
    }

    public String getInvestoraccount() {
        return investoraccount;
    }

    public void setInvestoraccount(String investoraccount) {
        this.investoraccount = investoraccount == null ? null : investoraccount.trim();
    }

    public String getInvestorname() {
        return investorname;
    }

    public void setInvestorname(String investorname) {
        this.investorname = investorname == null ? null : investorname.trim();
    }

    public String getProductaccount() {
        return productaccount;
    }

    public void setProductaccount(String productaccount) {
        this.productaccount = productaccount == null ? null : productaccount.trim();
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname == null ? null : productname.trim();
    }

    public String getTradingaccount() {
        return tradingaccount;
    }

    public void setTradingaccount(String tradingaccount) {
        this.tradingaccount = tradingaccount == null ? null : tradingaccount.trim();
    }

    public String getTradingaccountname() {
        return tradingaccountname;
    }

    public void setTradingaccountname(String tradingaccountname) {
        this.tradingaccountname = tradingaccountname == null ? null : tradingaccountname.trim();
    }

    public String getExtassetaccount() {
        return extassetaccount;
    }

    public void setExtassetaccount(String extassetaccount) {
        this.extassetaccount = extassetaccount == null ? null : extassetaccount.trim();
    }

    public Integer getOverassetaccounttype() {
        return overassetaccounttype;
    }

    public void setOverassetaccounttype(Integer overassetaccounttype) {
        this.overassetaccounttype = overassetaccounttype;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public BigDecimal getMarginmultiplier() {
        return marginmultiplier;
    }

    public void setMarginmultiplier(BigDecimal marginmultiplier) {
        this.marginmultiplier = marginmultiplier;
    }

    public BigDecimal getMargincallratio() {
        return margincallratio;
    }

    public void setMargincallratio(BigDecimal margincallratio) {
        this.margincallratio = margincallratio;
    }

    public String getMarginccy() {
        return marginccy;
    }

    public void setMarginccy(String marginccy) {
        this.marginccy = marginccy == null ? null : marginccy.trim();
    }

    public BigDecimal getFundcost() {
        return fundcost;
    }

    public void setFundcost(BigDecimal fundcost) {
        this.fundcost = fundcost;
    }

    public BigDecimal getInterestrate() {
        return interestrate;
    }

    public void setInterestrate(BigDecimal interestrate) {
        this.interestrate = interestrate;
    }

    public String getReferee() {
        return referee;
    }

    public void setReferee(String referee) {
        this.referee = referee == null ? null : referee.trim();
    }
    @JSONField(name = "SenderBankName")
    public String getSenderbankname() {
        return senderbankname;
    }
    @JSONField(name = "SenderBankName")
    public void setSenderbankname(String senderbankname) {
        this.senderbankname = senderbankname == null ? null : senderbankname.trim();
    }
    @JSONField(name = "SenderAcctNo")
    public String getSenderaccountno() {
        return senderaccountno;
    }
    @JSONField(name = "SenderAcctNo")
    public void setSenderaccountno(String senderaccountno) {
        this.senderaccountno = senderaccountno == null ? null : senderaccountno.trim();
    }
    @JSONField(name = "SenderName")
    public String getSendername() {
        return sendername;
    }
    @JSONField(name = "SenderName")
    public void setSendername(String sendername) {
        this.sendername = sendername == null ? null : sendername.trim();
    }
    @JSONField(name = "ReceiverBankName")
    public String getReceiverbankname() {
        return receiverbankname;
    }
    @JSONField(name = "ReceiverBankName")
    public void setReceiverbankname(String receiverbankname) {
        this.receiverbankname = receiverbankname == null ? null : receiverbankname.trim();
    }
    @JSONField(name = "ReceiverAcctNo")
    public String getReceiveraccountno() {
        return receiveraccountno;
    }
    @JSONField(name = "ReceiverAcctNo")
    public void setReceiveraccountno(String receiveraccountno) {
        this.receiveraccountno = receiveraccountno == null ? null : receiveraccountno.trim();
    }
    @JSONField(name = "ReceiverName")
    public String getReceivername() {
        return receivername;
    }
    @JSONField(name = "ReceiverName")
    public void setReceivername(String receivername) {
        this.receivername = receivername == null ? null : receivername.trim();
    }
    @JSONField(name = "CnapsBankCode")
    public String getCnapsbankcode() {
        return cnapsbankcode;
    }
    @JSONField(name = "CnapsBankCode")
    public void setCnapsbankcode(String cnapsbankcode) {
        this.cnapsbankcode = cnapsbankcode == null ? null : cnapsbankcode.trim();
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
}