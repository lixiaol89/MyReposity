package com.huatai.cube.rms.modules.client.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClientModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ClientModelExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andClientidIsNull() {
            addCriterion("ClientID is null");
            return (Criteria) this;
        }

        public Criteria andClientidIsNotNull() {
            addCriterion("ClientID is not null");
            return (Criteria) this;
        }

        public Criteria andClientidEqualTo(String value) {
            addCriterion("ClientID =", value, "clientid");
            return (Criteria) this;
        }

        public Criteria andClientidNotEqualTo(String value) {
            addCriterion("ClientID <>", value, "clientid");
            return (Criteria) this;
        }

        public Criteria andClientidGreaterThan(String value) {
            addCriterion("ClientID >", value, "clientid");
            return (Criteria) this;
        }

        public Criteria andClientidGreaterThanOrEqualTo(String value) {
            addCriterion("ClientID >=", value, "clientid");
            return (Criteria) this;
        }

        public Criteria andClientidLessThan(String value) {
            addCriterion("ClientID <", value, "clientid");
            return (Criteria) this;
        }

        public Criteria andClientidLessThanOrEqualTo(String value) {
            addCriterion("ClientID <=", value, "clientid");
            return (Criteria) this;
        }

        public Criteria andClientidLike(String value) {
            addCriterion("ClientID like", value, "clientid");
            return (Criteria) this;
        }

        public Criteria andClientidNotLike(String value) {
            addCriterion("ClientID not like", value, "clientid");
            return (Criteria) this;
        }

        public Criteria andClientidIn(List<String> values) {
            addCriterion("ClientID in", values, "clientid");
            return (Criteria) this;
        }

        public Criteria andClientidNotIn(List<String> values) {
            addCriterion("ClientID not in", values, "clientid");
            return (Criteria) this;
        }

        public Criteria andClientidBetween(String value1, String value2) {
            addCriterion("ClientID between", value1, value2, "clientid");
            return (Criteria) this;
        }

        public Criteria andClientidNotBetween(String value1, String value2) {
            addCriterion("ClientID not between", value1, value2, "clientid");
            return (Criteria) this;
        }

        public Criteria andClientnameIsNull() {
            addCriterion("ClientName is null");
            return (Criteria) this;
        }

        public Criteria andClientnameIsNotNull() {
            addCriterion("ClientName is not null");
            return (Criteria) this;
        }

        public Criteria andClientnameEqualTo(String value) {
            addCriterion("ClientName =", value, "clientname");
            return (Criteria) this;
        }

        public Criteria andClientnameNotEqualTo(String value) {
            addCriterion("ClientName <>", value, "clientname");
            return (Criteria) this;
        }

        public Criteria andClientnameGreaterThan(String value) {
            addCriterion("ClientName >", value, "clientname");
            return (Criteria) this;
        }

        public Criteria andClientnameGreaterThanOrEqualTo(String value) {
            addCriterion("ClientName >=", value, "clientname");
            return (Criteria) this;
        }

        public Criteria andClientnameLessThan(String value) {
            addCriterion("ClientName <", value, "clientname");
            return (Criteria) this;
        }

        public Criteria andClientnameLessThanOrEqualTo(String value) {
            addCriterion("ClientName <=", value, "clientname");
            return (Criteria) this;
        }

        public Criteria andClientnameLike(String value) {
            addCriterion("ClientName like", value, "clientname");
            return (Criteria) this;
        }

        public Criteria andClientnameNotLike(String value) {
            addCriterion("ClientName not like", value, "clientname");
            return (Criteria) this;
        }

        public Criteria andClientnameIn(List<String> values) {
            addCriterion("ClientName in", values, "clientname");
            return (Criteria) this;
        }

        public Criteria andClientnameNotIn(List<String> values) {
            addCriterion("ClientName not in", values, "clientname");
            return (Criteria) this;
        }

        public Criteria andClientnameBetween(String value1, String value2) {
            addCriterion("ClientName between", value1, value2, "clientname");
            return (Criteria) this;
        }

        public Criteria andClientnameNotBetween(String value1, String value2) {
            addCriterion("ClientName not between", value1, value2, "clientname");
            return (Criteria) this;
        }

        public Criteria andOrgancodeIsNull() {
            addCriterion("OrganCode is null");
            return (Criteria) this;
        }

        public Criteria andOrgancodeIsNotNull() {
            addCriterion("OrganCode is not null");
            return (Criteria) this;
        }

        public Criteria andOrgancodeEqualTo(String value) {
            addCriterion("OrganCode =", value, "organcode");
            return (Criteria) this;
        }

        public Criteria andOrgancodeNotEqualTo(String value) {
            addCriterion("OrganCode <>", value, "organcode");
            return (Criteria) this;
        }

        public Criteria andOrgancodeGreaterThan(String value) {
            addCriterion("OrganCode >", value, "organcode");
            return (Criteria) this;
        }

        public Criteria andOrgancodeGreaterThanOrEqualTo(String value) {
            addCriterion("OrganCode >=", value, "organcode");
            return (Criteria) this;
        }

        public Criteria andOrgancodeLessThan(String value) {
            addCriterion("OrganCode <", value, "organcode");
            return (Criteria) this;
        }

        public Criteria andOrgancodeLessThanOrEqualTo(String value) {
            addCriterion("OrganCode <=", value, "organcode");
            return (Criteria) this;
        }

        public Criteria andOrgancodeLike(String value) {
            addCriterion("OrganCode like", value, "organcode");
            return (Criteria) this;
        }

        public Criteria andOrgancodeNotLike(String value) {
            addCriterion("OrganCode not like", value, "organcode");
            return (Criteria) this;
        }

        public Criteria andOrgancodeIn(List<String> values) {
            addCriterion("OrganCode in", values, "organcode");
            return (Criteria) this;
        }

        public Criteria andOrgancodeNotIn(List<String> values) {
            addCriterion("OrganCode not in", values, "organcode");
            return (Criteria) this;
        }

        public Criteria andOrgancodeBetween(String value1, String value2) {
            addCriterion("OrganCode between", value1, value2, "organcode");
            return (Criteria) this;
        }

        public Criteria andOrgancodeNotBetween(String value1, String value2) {
            addCriterion("OrganCode not between", value1, value2, "organcode");
            return (Criteria) this;
        }

        public Criteria andOrgannameIsNull() {
            addCriterion("OrganName is null");
            return (Criteria) this;
        }

        public Criteria andOrgannameIsNotNull() {
            addCriterion("OrganName is not null");
            return (Criteria) this;
        }

        public Criteria andOrgannameEqualTo(String value) {
            addCriterion("OrganName =", value, "organname");
            return (Criteria) this;
        }

        public Criteria andOrgannameNotEqualTo(String value) {
            addCriterion("OrganName <>", value, "organname");
            return (Criteria) this;
        }

        public Criteria andOrgannameGreaterThan(String value) {
            addCriterion("OrganName >", value, "organname");
            return (Criteria) this;
        }

        public Criteria andOrgannameGreaterThanOrEqualTo(String value) {
            addCriterion("OrganName >=", value, "organname");
            return (Criteria) this;
        }

        public Criteria andOrgannameLessThan(String value) {
            addCriterion("OrganName <", value, "organname");
            return (Criteria) this;
        }

        public Criteria andOrgannameLessThanOrEqualTo(String value) {
            addCriterion("OrganName <=", value, "organname");
            return (Criteria) this;
        }

        public Criteria andOrgannameLike(String value) {
            addCriterion("OrganName like", value, "organname");
            return (Criteria) this;
        }

        public Criteria andOrgannameNotLike(String value) {
            addCriterion("OrganName not like", value, "organname");
            return (Criteria) this;
        }

        public Criteria andOrgannameIn(List<String> values) {
            addCriterion("OrganName in", values, "organname");
            return (Criteria) this;
        }

        public Criteria andOrgannameNotIn(List<String> values) {
            addCriterion("OrganName not in", values, "organname");
            return (Criteria) this;
        }

        public Criteria andOrgannameBetween(String value1, String value2) {
            addCriterion("OrganName between", value1, value2, "organname");
            return (Criteria) this;
        }

        public Criteria andOrgannameNotBetween(String value1, String value2) {
            addCriterion("OrganName not between", value1, value2, "organname");
            return (Criteria) this;
        }

        public Criteria andInvestoraccountIsNull() {
            addCriterion("InvestorAccount is null");
            return (Criteria) this;
        }

        public Criteria andInvestoraccountIsNotNull() {
            addCriterion("InvestorAccount is not null");
            return (Criteria) this;
        }

        public Criteria andInvestoraccountEqualTo(String value) {
            addCriterion("InvestorAccount =", value, "investoraccount");
            return (Criteria) this;
        }

        public Criteria andInvestoraccountNotEqualTo(String value) {
            addCriterion("InvestorAccount <>", value, "investoraccount");
            return (Criteria) this;
        }

        public Criteria andInvestoraccountGreaterThan(String value) {
            addCriterion("InvestorAccount >", value, "investoraccount");
            return (Criteria) this;
        }

        public Criteria andInvestoraccountGreaterThanOrEqualTo(String value) {
            addCriterion("InvestorAccount >=", value, "investoraccount");
            return (Criteria) this;
        }

        public Criteria andInvestoraccountLessThan(String value) {
            addCriterion("InvestorAccount <", value, "investoraccount");
            return (Criteria) this;
        }

        public Criteria andInvestoraccountLessThanOrEqualTo(String value) {
            addCriterion("InvestorAccount <=", value, "investoraccount");
            return (Criteria) this;
        }

        public Criteria andInvestoraccountLike(String value) {
            addCriterion("InvestorAccount like", value, "investoraccount");
            return (Criteria) this;
        }

        public Criteria andInvestoraccountNotLike(String value) {
            addCriterion("InvestorAccount not like", value, "investoraccount");
            return (Criteria) this;
        }

        public Criteria andInvestoraccountIn(List<String> values) {
            addCriterion("InvestorAccount in", values, "investoraccount");
            return (Criteria) this;
        }

        public Criteria andInvestoraccountNotIn(List<String> values) {
            addCriterion("InvestorAccount not in", values, "investoraccount");
            return (Criteria) this;
        }

        public Criteria andInvestoraccountBetween(String value1, String value2) {
            addCriterion("InvestorAccount between", value1, value2, "investoraccount");
            return (Criteria) this;
        }

        public Criteria andInvestoraccountNotBetween(String value1, String value2) {
            addCriterion("InvestorAccount not between", value1, value2, "investoraccount");
            return (Criteria) this;
        }

        public Criteria andInvestornameIsNull() {
            addCriterion("InvestorName is null");
            return (Criteria) this;
        }

        public Criteria andInvestornameIsNotNull() {
            addCriterion("InvestorName is not null");
            return (Criteria) this;
        }

        public Criteria andInvestornameEqualTo(String value) {
            addCriterion("InvestorName =", value, "investorname");
            return (Criteria) this;
        }

        public Criteria andInvestornameNotEqualTo(String value) {
            addCriterion("InvestorName <>", value, "investorname");
            return (Criteria) this;
        }

        public Criteria andInvestornameGreaterThan(String value) {
            addCriterion("InvestorName >", value, "investorname");
            return (Criteria) this;
        }

        public Criteria andInvestornameGreaterThanOrEqualTo(String value) {
            addCriterion("InvestorName >=", value, "investorname");
            return (Criteria) this;
        }

        public Criteria andInvestornameLessThan(String value) {
            addCriterion("InvestorName <", value, "investorname");
            return (Criteria) this;
        }

        public Criteria andInvestornameLessThanOrEqualTo(String value) {
            addCriterion("InvestorName <=", value, "investorname");
            return (Criteria) this;
        }

        public Criteria andInvestornameLike(String value) {
            addCriterion("InvestorName like", value, "investorname");
            return (Criteria) this;
        }

        public Criteria andInvestornameNotLike(String value) {
            addCriterion("InvestorName not like", value, "investorname");
            return (Criteria) this;
        }

        public Criteria andInvestornameIn(List<String> values) {
            addCriterion("InvestorName in", values, "investorname");
            return (Criteria) this;
        }

        public Criteria andInvestornameNotIn(List<String> values) {
            addCriterion("InvestorName not in", values, "investorname");
            return (Criteria) this;
        }

        public Criteria andInvestornameBetween(String value1, String value2) {
            addCriterion("InvestorName between", value1, value2, "investorname");
            return (Criteria) this;
        }

        public Criteria andInvestornameNotBetween(String value1, String value2) {
            addCriterion("InvestorName not between", value1, value2, "investorname");
            return (Criteria) this;
        }

        public Criteria andProductaccountIsNull() {
            addCriterion("ProductAccount is null");
            return (Criteria) this;
        }

        public Criteria andProductaccountIsNotNull() {
            addCriterion("ProductAccount is not null");
            return (Criteria) this;
        }

        public Criteria andProductaccountEqualTo(String value) {
            addCriterion("ProductAccount =", value, "productaccount");
            return (Criteria) this;
        }

        public Criteria andProductaccountNotEqualTo(String value) {
            addCriterion("ProductAccount <>", value, "productaccount");
            return (Criteria) this;
        }

        public Criteria andProductaccountGreaterThan(String value) {
            addCriterion("ProductAccount >", value, "productaccount");
            return (Criteria) this;
        }

        public Criteria andProductaccountGreaterThanOrEqualTo(String value) {
            addCriterion("ProductAccount >=", value, "productaccount");
            return (Criteria) this;
        }

        public Criteria andProductaccountLessThan(String value) {
            addCriterion("ProductAccount <", value, "productaccount");
            return (Criteria) this;
        }

        public Criteria andProductaccountLessThanOrEqualTo(String value) {
            addCriterion("ProductAccount <=", value, "productaccount");
            return (Criteria) this;
        }

        public Criteria andProductaccountLike(String value) {
            addCriterion("ProductAccount like", value, "productaccount");
            return (Criteria) this;
        }

        public Criteria andProductaccountNotLike(String value) {
            addCriterion("ProductAccount not like", value, "productaccount");
            return (Criteria) this;
        }

        public Criteria andProductaccountIn(List<String> values) {
            addCriterion("ProductAccount in", values, "productaccount");
            return (Criteria) this;
        }

        public Criteria andProductaccountNotIn(List<String> values) {
            addCriterion("ProductAccount not in", values, "productaccount");
            return (Criteria) this;
        }

        public Criteria andProductaccountBetween(String value1, String value2) {
            addCriterion("ProductAccount between", value1, value2, "productaccount");
            return (Criteria) this;
        }

        public Criteria andProductaccountNotBetween(String value1, String value2) {
            addCriterion("ProductAccount not between", value1, value2, "productaccount");
            return (Criteria) this;
        }

        public Criteria andProductnameIsNull() {
            addCriterion("ProductName is null");
            return (Criteria) this;
        }

        public Criteria andProductnameIsNotNull() {
            addCriterion("ProductName is not null");
            return (Criteria) this;
        }

        public Criteria andProductnameEqualTo(String value) {
            addCriterion("ProductName =", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameNotEqualTo(String value) {
            addCriterion("ProductName <>", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameGreaterThan(String value) {
            addCriterion("ProductName >", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameGreaterThanOrEqualTo(String value) {
            addCriterion("ProductName >=", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameLessThan(String value) {
            addCriterion("ProductName <", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameLessThanOrEqualTo(String value) {
            addCriterion("ProductName <=", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameLike(String value) {
            addCriterion("ProductName like", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameNotLike(String value) {
            addCriterion("ProductName not like", value, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameIn(List<String> values) {
            addCriterion("ProductName in", values, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameNotIn(List<String> values) {
            addCriterion("ProductName not in", values, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameBetween(String value1, String value2) {
            addCriterion("ProductName between", value1, value2, "productname");
            return (Criteria) this;
        }

        public Criteria andProductnameNotBetween(String value1, String value2) {
            addCriterion("ProductName not between", value1, value2, "productname");
            return (Criteria) this;
        }

        public Criteria andTradingaccountIsNull() {
            addCriterion("TradingAccount is null");
            return (Criteria) this;
        }

        public Criteria andTradingaccountIsNotNull() {
            addCriterion("TradingAccount is not null");
            return (Criteria) this;
        }

        public Criteria andTradingaccountEqualTo(String value) {
            addCriterion("TradingAccount =", value, "tradingaccount");
            return (Criteria) this;
        }

        public Criteria andTradingaccountNotEqualTo(String value) {
            addCriterion("TradingAccount <>", value, "tradingaccount");
            return (Criteria) this;
        }

        public Criteria andTradingaccountGreaterThan(String value) {
            addCriterion("TradingAccount >", value, "tradingaccount");
            return (Criteria) this;
        }

        public Criteria andTradingaccountGreaterThanOrEqualTo(String value) {
            addCriterion("TradingAccount >=", value, "tradingaccount");
            return (Criteria) this;
        }

        public Criteria andTradingaccountLessThan(String value) {
            addCriterion("TradingAccount <", value, "tradingaccount");
            return (Criteria) this;
        }

        public Criteria andTradingaccountLessThanOrEqualTo(String value) {
            addCriterion("TradingAccount <=", value, "tradingaccount");
            return (Criteria) this;
        }

        public Criteria andTradingaccountLike(String value) {
            addCriterion("TradingAccount like", value, "tradingaccount");
            return (Criteria) this;
        }

        public Criteria andTradingaccountNotLike(String value) {
            addCriterion("TradingAccount not like", value, "tradingaccount");
            return (Criteria) this;
        }

        public Criteria andTradingaccountIn(List<String> values) {
            addCriterion("TradingAccount in", values, "tradingaccount");
            return (Criteria) this;
        }

        public Criteria andTradingaccountNotIn(List<String> values) {
            addCriterion("TradingAccount not in", values, "tradingaccount");
            return (Criteria) this;
        }

        public Criteria andTradingaccountBetween(String value1, String value2) {
            addCriterion("TradingAccount between", value1, value2, "tradingaccount");
            return (Criteria) this;
        }

        public Criteria andTradingaccountNotBetween(String value1, String value2) {
            addCriterion("TradingAccount not between", value1, value2, "tradingaccount");
            return (Criteria) this;
        }

        public Criteria andTradingaccountnameIsNull() {
            addCriterion("TradingAccountName is null");
            return (Criteria) this;
        }

        public Criteria andTradingaccountnameIsNotNull() {
            addCriterion("TradingAccountName is not null");
            return (Criteria) this;
        }

        public Criteria andTradingaccountnameEqualTo(String value) {
            addCriterion("TradingAccountName =", value, "tradingaccountname");
            return (Criteria) this;
        }

        public Criteria andTradingaccountnameNotEqualTo(String value) {
            addCriterion("TradingAccountName <>", value, "tradingaccountname");
            return (Criteria) this;
        }

        public Criteria andTradingaccountnameGreaterThan(String value) {
            addCriterion("TradingAccountName >", value, "tradingaccountname");
            return (Criteria) this;
        }

        public Criteria andTradingaccountnameGreaterThanOrEqualTo(String value) {
            addCriterion("TradingAccountName >=", value, "tradingaccountname");
            return (Criteria) this;
        }

        public Criteria andTradingaccountnameLessThan(String value) {
            addCriterion("TradingAccountName <", value, "tradingaccountname");
            return (Criteria) this;
        }

        public Criteria andTradingaccountnameLessThanOrEqualTo(String value) {
            addCriterion("TradingAccountName <=", value, "tradingaccountname");
            return (Criteria) this;
        }

        public Criteria andTradingaccountnameLike(String value) {
            addCriterion("TradingAccountName like", value, "tradingaccountname");
            return (Criteria) this;
        }

        public Criteria andTradingaccountnameNotLike(String value) {
            addCriterion("TradingAccountName not like", value, "tradingaccountname");
            return (Criteria) this;
        }

        public Criteria andTradingaccountnameIn(List<String> values) {
            addCriterion("TradingAccountName in", values, "tradingaccountname");
            return (Criteria) this;
        }

        public Criteria andTradingaccountnameNotIn(List<String> values) {
            addCriterion("TradingAccountName not in", values, "tradingaccountname");
            return (Criteria) this;
        }

        public Criteria andTradingaccountnameBetween(String value1, String value2) {
            addCriterion("TradingAccountName between", value1, value2, "tradingaccountname");
            return (Criteria) this;
        }

        public Criteria andTradingaccountnameNotBetween(String value1, String value2) {
            addCriterion("TradingAccountName not between", value1, value2, "tradingaccountname");
            return (Criteria) this;
        }

        public Criteria andExtassetaccountIsNull() {
            addCriterion("ExtAssetAccount is null");
            return (Criteria) this;
        }

        public Criteria andExtassetaccountIsNotNull() {
            addCriterion("ExtAssetAccount is not null");
            return (Criteria) this;
        }

        public Criteria andExtassetaccountEqualTo(String value) {
            addCriterion("ExtAssetAccount =", value, "extassetaccount");
            return (Criteria) this;
        }

        public Criteria andExtassetaccountNotEqualTo(String value) {
            addCriterion("ExtAssetAccount <>", value, "extassetaccount");
            return (Criteria) this;
        }

        public Criteria andExtassetaccountGreaterThan(String value) {
            addCriterion("ExtAssetAccount >", value, "extassetaccount");
            return (Criteria) this;
        }

        public Criteria andExtassetaccountGreaterThanOrEqualTo(String value) {
            addCriterion("ExtAssetAccount >=", value, "extassetaccount");
            return (Criteria) this;
        }

        public Criteria andExtassetaccountLessThan(String value) {
            addCriterion("ExtAssetAccount <", value, "extassetaccount");
            return (Criteria) this;
        }

        public Criteria andExtassetaccountLessThanOrEqualTo(String value) {
            addCriterion("ExtAssetAccount <=", value, "extassetaccount");
            return (Criteria) this;
        }

        public Criteria andExtassetaccountLike(String value) {
            addCriterion("ExtAssetAccount like", value, "extassetaccount");
            return (Criteria) this;
        }

        public Criteria andExtassetaccountNotLike(String value) {
            addCriterion("ExtAssetAccount not like", value, "extassetaccount");
            return (Criteria) this;
        }

        public Criteria andExtassetaccountIn(List<String> values) {
            addCriterion("ExtAssetAccount in", values, "extassetaccount");
            return (Criteria) this;
        }

        public Criteria andExtassetaccountNotIn(List<String> values) {
            addCriterion("ExtAssetAccount not in", values, "extassetaccount");
            return (Criteria) this;
        }

        public Criteria andExtassetaccountBetween(String value1, String value2) {
            addCriterion("ExtAssetAccount between", value1, value2, "extassetaccount");
            return (Criteria) this;
        }

        public Criteria andExtassetaccountNotBetween(String value1, String value2) {
            addCriterion("ExtAssetAccount not between", value1, value2, "extassetaccount");
            return (Criteria) this;
        }

        public Criteria andOverassetaccounttypeIsNull() {
            addCriterion("OverAssetAccountType is null");
            return (Criteria) this;
        }

        public Criteria andOverassetaccounttypeIsNotNull() {
            addCriterion("OverAssetAccountType is not null");
            return (Criteria) this;
        }

        public Criteria andOverassetaccounttypeEqualTo(Integer value) {
            addCriterion("OverAssetAccountType =", value, "overassetaccounttype");
            return (Criteria) this;
        }

        public Criteria andOverassetaccounttypeNotEqualTo(Integer value) {
            addCriterion("OverAssetAccountType <>", value, "overassetaccounttype");
            return (Criteria) this;
        }

        public Criteria andOverassetaccounttypeGreaterThan(Integer value) {
            addCriterion("OverAssetAccountType >", value, "overassetaccounttype");
            return (Criteria) this;
        }

        public Criteria andOverassetaccounttypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("OverAssetAccountType >=", value, "overassetaccounttype");
            return (Criteria) this;
        }

        public Criteria andOverassetaccounttypeLessThan(Integer value) {
            addCriterion("OverAssetAccountType <", value, "overassetaccounttype");
            return (Criteria) this;
        }

        public Criteria andOverassetaccounttypeLessThanOrEqualTo(Integer value) {
            addCriterion("OverAssetAccountType <=", value, "overassetaccounttype");
            return (Criteria) this;
        }

        public Criteria andOverassetaccounttypeIn(List<Integer> values) {
            addCriterion("OverAssetAccountType in", values, "overassetaccounttype");
            return (Criteria) this;
        }

        public Criteria andOverassetaccounttypeNotIn(List<Integer> values) {
            addCriterion("OverAssetAccountType not in", values, "overassetaccounttype");
            return (Criteria) this;
        }

        public Criteria andOverassetaccounttypeBetween(Integer value1, Integer value2) {
            addCriterion("OverAssetAccountType between", value1, value2, "overassetaccounttype");
            return (Criteria) this;
        }

        public Criteria andOverassetaccounttypeNotBetween(Integer value1, Integer value2) {
            addCriterion("OverAssetAccountType not between", value1, value2, "overassetaccounttype");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("Email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("Email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("Email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("Email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("Email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("Email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("Email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("Email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("Email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("Email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("Email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("Email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("Email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("Email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andMarginmultiplierIsNull() {
            addCriterion("MarginMultiplier is null");
            return (Criteria) this;
        }

        public Criteria andMarginmultiplierIsNotNull() {
            addCriterion("MarginMultiplier is not null");
            return (Criteria) this;
        }

        public Criteria andMarginmultiplierEqualTo(BigDecimal value) {
            addCriterion("MarginMultiplier =", value, "marginmultiplier");
            return (Criteria) this;
        }

        public Criteria andMarginmultiplierNotEqualTo(BigDecimal value) {
            addCriterion("MarginMultiplier <>", value, "marginmultiplier");
            return (Criteria) this;
        }

        public Criteria andMarginmultiplierGreaterThan(BigDecimal value) {
            addCriterion("MarginMultiplier >", value, "marginmultiplier");
            return (Criteria) this;
        }

        public Criteria andMarginmultiplierGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MarginMultiplier >=", value, "marginmultiplier");
            return (Criteria) this;
        }

        public Criteria andMarginmultiplierLessThan(BigDecimal value) {
            addCriterion("MarginMultiplier <", value, "marginmultiplier");
            return (Criteria) this;
        }

        public Criteria andMarginmultiplierLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MarginMultiplier <=", value, "marginmultiplier");
            return (Criteria) this;
        }

        public Criteria andMarginmultiplierIn(List<BigDecimal> values) {
            addCriterion("MarginMultiplier in", values, "marginmultiplier");
            return (Criteria) this;
        }

        public Criteria andMarginmultiplierNotIn(List<BigDecimal> values) {
            addCriterion("MarginMultiplier not in", values, "marginmultiplier");
            return (Criteria) this;
        }

        public Criteria andMarginmultiplierBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MarginMultiplier between", value1, value2, "marginmultiplier");
            return (Criteria) this;
        }

        public Criteria andMarginmultiplierNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MarginMultiplier not between", value1, value2, "marginmultiplier");
            return (Criteria) this;
        }

        public Criteria andMargincallratioIsNull() {
            addCriterion("MarginCallRatio is null");
            return (Criteria) this;
        }

        public Criteria andMargincallratioIsNotNull() {
            addCriterion("MarginCallRatio is not null");
            return (Criteria) this;
        }

        public Criteria andMargincallratioEqualTo(BigDecimal value) {
            addCriterion("MarginCallRatio =", value, "margincallratio");
            return (Criteria) this;
        }

        public Criteria andMargincallratioNotEqualTo(BigDecimal value) {
            addCriterion("MarginCallRatio <>", value, "margincallratio");
            return (Criteria) this;
        }

        public Criteria andMargincallratioGreaterThan(BigDecimal value) {
            addCriterion("MarginCallRatio >", value, "margincallratio");
            return (Criteria) this;
        }

        public Criteria andMargincallratioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MarginCallRatio >=", value, "margincallratio");
            return (Criteria) this;
        }

        public Criteria andMargincallratioLessThan(BigDecimal value) {
            addCriterion("MarginCallRatio <", value, "margincallratio");
            return (Criteria) this;
        }

        public Criteria andMargincallratioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MarginCallRatio <=", value, "margincallratio");
            return (Criteria) this;
        }

        public Criteria andMargincallratioIn(List<BigDecimal> values) {
            addCriterion("MarginCallRatio in", values, "margincallratio");
            return (Criteria) this;
        }

        public Criteria andMargincallratioNotIn(List<BigDecimal> values) {
            addCriterion("MarginCallRatio not in", values, "margincallratio");
            return (Criteria) this;
        }

        public Criteria andMargincallratioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MarginCallRatio between", value1, value2, "margincallratio");
            return (Criteria) this;
        }

        public Criteria andMargincallratioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MarginCallRatio not between", value1, value2, "margincallratio");
            return (Criteria) this;
        }

        public Criteria andMarginccyIsNull() {
            addCriterion("MarginCcy is null");
            return (Criteria) this;
        }

        public Criteria andMarginccyIsNotNull() {
            addCriterion("MarginCcy is not null");
            return (Criteria) this;
        }

        public Criteria andMarginccyEqualTo(String value) {
            addCriterion("MarginCcy =", value, "marginccy");
            return (Criteria) this;
        }

        public Criteria andMarginccyNotEqualTo(String value) {
            addCriterion("MarginCcy <>", value, "marginccy");
            return (Criteria) this;
        }

        public Criteria andMarginccyGreaterThan(String value) {
            addCriterion("MarginCcy >", value, "marginccy");
            return (Criteria) this;
        }

        public Criteria andMarginccyGreaterThanOrEqualTo(String value) {
            addCriterion("MarginCcy >=", value, "marginccy");
            return (Criteria) this;
        }

        public Criteria andMarginccyLessThan(String value) {
            addCriterion("MarginCcy <", value, "marginccy");
            return (Criteria) this;
        }

        public Criteria andMarginccyLessThanOrEqualTo(String value) {
            addCriterion("MarginCcy <=", value, "marginccy");
            return (Criteria) this;
        }

        public Criteria andMarginccyLike(String value) {
            addCriterion("MarginCcy like", value, "marginccy");
            return (Criteria) this;
        }

        public Criteria andMarginccyNotLike(String value) {
            addCriterion("MarginCcy not like", value, "marginccy");
            return (Criteria) this;
        }

        public Criteria andMarginccyIn(List<String> values) {
            addCriterion("MarginCcy in", values, "marginccy");
            return (Criteria) this;
        }

        public Criteria andMarginccyNotIn(List<String> values) {
            addCriterion("MarginCcy not in", values, "marginccy");
            return (Criteria) this;
        }

        public Criteria andMarginccyBetween(String value1, String value2) {
            addCriterion("MarginCcy between", value1, value2, "marginccy");
            return (Criteria) this;
        }

        public Criteria andMarginccyNotBetween(String value1, String value2) {
            addCriterion("MarginCcy not between", value1, value2, "marginccy");
            return (Criteria) this;
        }

        public Criteria andFundcostIsNull() {
            addCriterion("FundCost is null");
            return (Criteria) this;
        }

        public Criteria andFundcostIsNotNull() {
            addCriterion("FundCost is not null");
            return (Criteria) this;
        }

        public Criteria andFundcostEqualTo(BigDecimal value) {
            addCriterion("FundCost =", value, "fundcost");
            return (Criteria) this;
        }

        public Criteria andFundcostNotEqualTo(BigDecimal value) {
            addCriterion("FundCost <>", value, "fundcost");
            return (Criteria) this;
        }

        public Criteria andFundcostGreaterThan(BigDecimal value) {
            addCriterion("FundCost >", value, "fundcost");
            return (Criteria) this;
        }

        public Criteria andFundcostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FundCost >=", value, "fundcost");
            return (Criteria) this;
        }

        public Criteria andFundcostLessThan(BigDecimal value) {
            addCriterion("FundCost <", value, "fundcost");
            return (Criteria) this;
        }

        public Criteria andFundcostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FundCost <=", value, "fundcost");
            return (Criteria) this;
        }

        public Criteria andFundcostIn(List<BigDecimal> values) {
            addCriterion("FundCost in", values, "fundcost");
            return (Criteria) this;
        }

        public Criteria andFundcostNotIn(List<BigDecimal> values) {
            addCriterion("FundCost not in", values, "fundcost");
            return (Criteria) this;
        }

        public Criteria andFundcostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FundCost between", value1, value2, "fundcost");
            return (Criteria) this;
        }

        public Criteria andFundcostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FundCost not between", value1, value2, "fundcost");
            return (Criteria) this;
        }

        public Criteria andInterestrateIsNull() {
            addCriterion("InterestRate is null");
            return (Criteria) this;
        }

        public Criteria andInterestrateIsNotNull() {
            addCriterion("InterestRate is not null");
            return (Criteria) this;
        }

        public Criteria andInterestrateEqualTo(BigDecimal value) {
            addCriterion("InterestRate =", value, "interestrate");
            return (Criteria) this;
        }

        public Criteria andInterestrateNotEqualTo(BigDecimal value) {
            addCriterion("InterestRate <>", value, "interestrate");
            return (Criteria) this;
        }

        public Criteria andInterestrateGreaterThan(BigDecimal value) {
            addCriterion("InterestRate >", value, "interestrate");
            return (Criteria) this;
        }

        public Criteria andInterestrateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("InterestRate >=", value, "interestrate");
            return (Criteria) this;
        }

        public Criteria andInterestrateLessThan(BigDecimal value) {
            addCriterion("InterestRate <", value, "interestrate");
            return (Criteria) this;
        }

        public Criteria andInterestrateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("InterestRate <=", value, "interestrate");
            return (Criteria) this;
        }

        public Criteria andInterestrateIn(List<BigDecimal> values) {
            addCriterion("InterestRate in", values, "interestrate");
            return (Criteria) this;
        }

        public Criteria andInterestrateNotIn(List<BigDecimal> values) {
            addCriterion("InterestRate not in", values, "interestrate");
            return (Criteria) this;
        }

        public Criteria andInterestrateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("InterestRate between", value1, value2, "interestrate");
            return (Criteria) this;
        }

        public Criteria andInterestrateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("InterestRate not between", value1, value2, "interestrate");
            return (Criteria) this;
        }

        public Criteria andRefereeIsNull() {
            addCriterion("Referee is null");
            return (Criteria) this;
        }

        public Criteria andRefereeIsNotNull() {
            addCriterion("Referee is not null");
            return (Criteria) this;
        }

        public Criteria andRefereeEqualTo(String value) {
            addCriterion("Referee =", value, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeNotEqualTo(String value) {
            addCriterion("Referee <>", value, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeGreaterThan(String value) {
            addCriterion("Referee >", value, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeGreaterThanOrEqualTo(String value) {
            addCriterion("Referee >=", value, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeLessThan(String value) {
            addCriterion("Referee <", value, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeLessThanOrEqualTo(String value) {
            addCriterion("Referee <=", value, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeLike(String value) {
            addCriterion("Referee like", value, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeNotLike(String value) {
            addCriterion("Referee not like", value, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeIn(List<String> values) {
            addCriterion("Referee in", values, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeNotIn(List<String> values) {
            addCriterion("Referee not in", values, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeBetween(String value1, String value2) {
            addCriterion("Referee between", value1, value2, "referee");
            return (Criteria) this;
        }

        public Criteria andRefereeNotBetween(String value1, String value2) {
            addCriterion("Referee not between", value1, value2, "referee");
            return (Criteria) this;
        }

        public Criteria andSenderbanknameIsNull() {
            addCriterion("SenderBankName is null");
            return (Criteria) this;
        }

        public Criteria andSenderbanknameIsNotNull() {
            addCriterion("SenderBankName is not null");
            return (Criteria) this;
        }

        public Criteria andSenderbanknameEqualTo(String value) {
            addCriterion("SenderBankName =", value, "senderbankname");
            return (Criteria) this;
        }

        public Criteria andSenderbanknameNotEqualTo(String value) {
            addCriterion("SenderBankName <>", value, "senderbankname");
            return (Criteria) this;
        }

        public Criteria andSenderbanknameGreaterThan(String value) {
            addCriterion("SenderBankName >", value, "senderbankname");
            return (Criteria) this;
        }

        public Criteria andSenderbanknameGreaterThanOrEqualTo(String value) {
            addCriterion("SenderBankName >=", value, "senderbankname");
            return (Criteria) this;
        }

        public Criteria andSenderbanknameLessThan(String value) {
            addCriterion("SenderBankName <", value, "senderbankname");
            return (Criteria) this;
        }

        public Criteria andSenderbanknameLessThanOrEqualTo(String value) {
            addCriterion("SenderBankName <=", value, "senderbankname");
            return (Criteria) this;
        }

        public Criteria andSenderbanknameLike(String value) {
            addCriterion("SenderBankName like", value, "senderbankname");
            return (Criteria) this;
        }

        public Criteria andSenderbanknameNotLike(String value) {
            addCriterion("SenderBankName not like", value, "senderbankname");
            return (Criteria) this;
        }

        public Criteria andSenderbanknameIn(List<String> values) {
            addCriterion("SenderBankName in", values, "senderbankname");
            return (Criteria) this;
        }

        public Criteria andSenderbanknameNotIn(List<String> values) {
            addCriterion("SenderBankName not in", values, "senderbankname");
            return (Criteria) this;
        }

        public Criteria andSenderbanknameBetween(String value1, String value2) {
            addCriterion("SenderBankName between", value1, value2, "senderbankname");
            return (Criteria) this;
        }

        public Criteria andSenderbanknameNotBetween(String value1, String value2) {
            addCriterion("SenderBankName not between", value1, value2, "senderbankname");
            return (Criteria) this;
        }

        public Criteria andSenderaccountnoIsNull() {
            addCriterion("SenderAccountNo is null");
            return (Criteria) this;
        }

        public Criteria andSenderaccountnoIsNotNull() {
            addCriterion("SenderAccountNo is not null");
            return (Criteria) this;
        }

        public Criteria andSenderaccountnoEqualTo(String value) {
            addCriterion("SenderAccountNo =", value, "senderaccountno");
            return (Criteria) this;
        }

        public Criteria andSenderaccountnoNotEqualTo(String value) {
            addCriterion("SenderAccountNo <>", value, "senderaccountno");
            return (Criteria) this;
        }

        public Criteria andSenderaccountnoGreaterThan(String value) {
            addCriterion("SenderAccountNo >", value, "senderaccountno");
            return (Criteria) this;
        }

        public Criteria andSenderaccountnoGreaterThanOrEqualTo(String value) {
            addCriterion("SenderAccountNo >=", value, "senderaccountno");
            return (Criteria) this;
        }

        public Criteria andSenderaccountnoLessThan(String value) {
            addCriterion("SenderAccountNo <", value, "senderaccountno");
            return (Criteria) this;
        }

        public Criteria andSenderaccountnoLessThanOrEqualTo(String value) {
            addCriterion("SenderAccountNo <=", value, "senderaccountno");
            return (Criteria) this;
        }

        public Criteria andSenderaccountnoLike(String value) {
            addCriterion("SenderAccountNo like", value, "senderaccountno");
            return (Criteria) this;
        }

        public Criteria andSenderaccountnoNotLike(String value) {
            addCriterion("SenderAccountNo not like", value, "senderaccountno");
            return (Criteria) this;
        }

        public Criteria andSenderaccountnoIn(List<String> values) {
            addCriterion("SenderAccountNo in", values, "senderaccountno");
            return (Criteria) this;
        }

        public Criteria andSenderaccountnoNotIn(List<String> values) {
            addCriterion("SenderAccountNo not in", values, "senderaccountno");
            return (Criteria) this;
        }

        public Criteria andSenderaccountnoBetween(String value1, String value2) {
            addCriterion("SenderAccountNo between", value1, value2, "senderaccountno");
            return (Criteria) this;
        }

        public Criteria andSenderaccountnoNotBetween(String value1, String value2) {
            addCriterion("SenderAccountNo not between", value1, value2, "senderaccountno");
            return (Criteria) this;
        }

        public Criteria andSendernameIsNull() {
            addCriterion("SenderName is null");
            return (Criteria) this;
        }

        public Criteria andSendernameIsNotNull() {
            addCriterion("SenderName is not null");
            return (Criteria) this;
        }

        public Criteria andSendernameEqualTo(String value) {
            addCriterion("SenderName =", value, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameNotEqualTo(String value) {
            addCriterion("SenderName <>", value, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameGreaterThan(String value) {
            addCriterion("SenderName >", value, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameGreaterThanOrEqualTo(String value) {
            addCriterion("SenderName >=", value, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameLessThan(String value) {
            addCriterion("SenderName <", value, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameLessThanOrEqualTo(String value) {
            addCriterion("SenderName <=", value, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameLike(String value) {
            addCriterion("SenderName like", value, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameNotLike(String value) {
            addCriterion("SenderName not like", value, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameIn(List<String> values) {
            addCriterion("SenderName in", values, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameNotIn(List<String> values) {
            addCriterion("SenderName not in", values, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameBetween(String value1, String value2) {
            addCriterion("SenderName between", value1, value2, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameNotBetween(String value1, String value2) {
            addCriterion("SenderName not between", value1, value2, "sendername");
            return (Criteria) this;
        }

        public Criteria andReceiverbanknameIsNull() {
            addCriterion("ReceiverBankName is null");
            return (Criteria) this;
        }

        public Criteria andReceiverbanknameIsNotNull() {
            addCriterion("ReceiverBankName is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverbanknameEqualTo(String value) {
            addCriterion("ReceiverBankName =", value, "receiverbankname");
            return (Criteria) this;
        }

        public Criteria andReceiverbanknameNotEqualTo(String value) {
            addCriterion("ReceiverBankName <>", value, "receiverbankname");
            return (Criteria) this;
        }

        public Criteria andReceiverbanknameGreaterThan(String value) {
            addCriterion("ReceiverBankName >", value, "receiverbankname");
            return (Criteria) this;
        }

        public Criteria andReceiverbanknameGreaterThanOrEqualTo(String value) {
            addCriterion("ReceiverBankName >=", value, "receiverbankname");
            return (Criteria) this;
        }

        public Criteria andReceiverbanknameLessThan(String value) {
            addCriterion("ReceiverBankName <", value, "receiverbankname");
            return (Criteria) this;
        }

        public Criteria andReceiverbanknameLessThanOrEqualTo(String value) {
            addCriterion("ReceiverBankName <=", value, "receiverbankname");
            return (Criteria) this;
        }

        public Criteria andReceiverbanknameLike(String value) {
            addCriterion("ReceiverBankName like", value, "receiverbankname");
            return (Criteria) this;
        }

        public Criteria andReceiverbanknameNotLike(String value) {
            addCriterion("ReceiverBankName not like", value, "receiverbankname");
            return (Criteria) this;
        }

        public Criteria andReceiverbanknameIn(List<String> values) {
            addCriterion("ReceiverBankName in", values, "receiverbankname");
            return (Criteria) this;
        }

        public Criteria andReceiverbanknameNotIn(List<String> values) {
            addCriterion("ReceiverBankName not in", values, "receiverbankname");
            return (Criteria) this;
        }

        public Criteria andReceiverbanknameBetween(String value1, String value2) {
            addCriterion("ReceiverBankName between", value1, value2, "receiverbankname");
            return (Criteria) this;
        }

        public Criteria andReceiverbanknameNotBetween(String value1, String value2) {
            addCriterion("ReceiverBankName not between", value1, value2, "receiverbankname");
            return (Criteria) this;
        }

        public Criteria andReceiveraccountnoIsNull() {
            addCriterion("ReceiverAccountNo is null");
            return (Criteria) this;
        }

        public Criteria andReceiveraccountnoIsNotNull() {
            addCriterion("ReceiverAccountNo is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveraccountnoEqualTo(String value) {
            addCriterion("ReceiverAccountNo =", value, "receiveraccountno");
            return (Criteria) this;
        }

        public Criteria andReceiveraccountnoNotEqualTo(String value) {
            addCriterion("ReceiverAccountNo <>", value, "receiveraccountno");
            return (Criteria) this;
        }

        public Criteria andReceiveraccountnoGreaterThan(String value) {
            addCriterion("ReceiverAccountNo >", value, "receiveraccountno");
            return (Criteria) this;
        }

        public Criteria andReceiveraccountnoGreaterThanOrEqualTo(String value) {
            addCriterion("ReceiverAccountNo >=", value, "receiveraccountno");
            return (Criteria) this;
        }

        public Criteria andReceiveraccountnoLessThan(String value) {
            addCriterion("ReceiverAccountNo <", value, "receiveraccountno");
            return (Criteria) this;
        }

        public Criteria andReceiveraccountnoLessThanOrEqualTo(String value) {
            addCriterion("ReceiverAccountNo <=", value, "receiveraccountno");
            return (Criteria) this;
        }

        public Criteria andReceiveraccountnoLike(String value) {
            addCriterion("ReceiverAccountNo like", value, "receiveraccountno");
            return (Criteria) this;
        }

        public Criteria andReceiveraccountnoNotLike(String value) {
            addCriterion("ReceiverAccountNo not like", value, "receiveraccountno");
            return (Criteria) this;
        }

        public Criteria andReceiveraccountnoIn(List<String> values) {
            addCriterion("ReceiverAccountNo in", values, "receiveraccountno");
            return (Criteria) this;
        }

        public Criteria andReceiveraccountnoNotIn(List<String> values) {
            addCriterion("ReceiverAccountNo not in", values, "receiveraccountno");
            return (Criteria) this;
        }

        public Criteria andReceiveraccountnoBetween(String value1, String value2) {
            addCriterion("ReceiverAccountNo between", value1, value2, "receiveraccountno");
            return (Criteria) this;
        }

        public Criteria andReceiveraccountnoNotBetween(String value1, String value2) {
            addCriterion("ReceiverAccountNo not between", value1, value2, "receiveraccountno");
            return (Criteria) this;
        }

        public Criteria andReceivernameIsNull() {
            addCriterion("ReceiverName is null");
            return (Criteria) this;
        }

        public Criteria andReceivernameIsNotNull() {
            addCriterion("ReceiverName is not null");
            return (Criteria) this;
        }

        public Criteria andReceivernameEqualTo(String value) {
            addCriterion("ReceiverName =", value, "receivername");
            return (Criteria) this;
        }

        public Criteria andReceivernameNotEqualTo(String value) {
            addCriterion("ReceiverName <>", value, "receivername");
            return (Criteria) this;
        }

        public Criteria andReceivernameGreaterThan(String value) {
            addCriterion("ReceiverName >", value, "receivername");
            return (Criteria) this;
        }

        public Criteria andReceivernameGreaterThanOrEqualTo(String value) {
            addCriterion("ReceiverName >=", value, "receivername");
            return (Criteria) this;
        }

        public Criteria andReceivernameLessThan(String value) {
            addCriterion("ReceiverName <", value, "receivername");
            return (Criteria) this;
        }

        public Criteria andReceivernameLessThanOrEqualTo(String value) {
            addCriterion("ReceiverName <=", value, "receivername");
            return (Criteria) this;
        }

        public Criteria andReceivernameLike(String value) {
            addCriterion("ReceiverName like", value, "receivername");
            return (Criteria) this;
        }

        public Criteria andReceivernameNotLike(String value) {
            addCriterion("ReceiverName not like", value, "receivername");
            return (Criteria) this;
        }

        public Criteria andReceivernameIn(List<String> values) {
            addCriterion("ReceiverName in", values, "receivername");
            return (Criteria) this;
        }

        public Criteria andReceivernameNotIn(List<String> values) {
            addCriterion("ReceiverName not in", values, "receivername");
            return (Criteria) this;
        }

        public Criteria andReceivernameBetween(String value1, String value2) {
            addCriterion("ReceiverName between", value1, value2, "receivername");
            return (Criteria) this;
        }

        public Criteria andReceivernameNotBetween(String value1, String value2) {
            addCriterion("ReceiverName not between", value1, value2, "receivername");
            return (Criteria) this;
        }

        public Criteria andCnapsbankcodeIsNull() {
            addCriterion("CnapsBankCode is null");
            return (Criteria) this;
        }

        public Criteria andCnapsbankcodeIsNotNull() {
            addCriterion("CnapsBankCode is not null");
            return (Criteria) this;
        }

        public Criteria andCnapsbankcodeEqualTo(String value) {
            addCriterion("CnapsBankCode =", value, "cnapsbankcode");
            return (Criteria) this;
        }

        public Criteria andCnapsbankcodeNotEqualTo(String value) {
            addCriterion("CnapsBankCode <>", value, "cnapsbankcode");
            return (Criteria) this;
        }

        public Criteria andCnapsbankcodeGreaterThan(String value) {
            addCriterion("CnapsBankCode >", value, "cnapsbankcode");
            return (Criteria) this;
        }

        public Criteria andCnapsbankcodeGreaterThanOrEqualTo(String value) {
            addCriterion("CnapsBankCode >=", value, "cnapsbankcode");
            return (Criteria) this;
        }

        public Criteria andCnapsbankcodeLessThan(String value) {
            addCriterion("CnapsBankCode <", value, "cnapsbankcode");
            return (Criteria) this;
        }

        public Criteria andCnapsbankcodeLessThanOrEqualTo(String value) {
            addCriterion("CnapsBankCode <=", value, "cnapsbankcode");
            return (Criteria) this;
        }

        public Criteria andCnapsbankcodeLike(String value) {
            addCriterion("CnapsBankCode like", value, "cnapsbankcode");
            return (Criteria) this;
        }

        public Criteria andCnapsbankcodeNotLike(String value) {
            addCriterion("CnapsBankCode not like", value, "cnapsbankcode");
            return (Criteria) this;
        }

        public Criteria andCnapsbankcodeIn(List<String> values) {
            addCriterion("CnapsBankCode in", values, "cnapsbankcode");
            return (Criteria) this;
        }

        public Criteria andCnapsbankcodeNotIn(List<String> values) {
            addCriterion("CnapsBankCode not in", values, "cnapsbankcode");
            return (Criteria) this;
        }

        public Criteria andCnapsbankcodeBetween(String value1, String value2) {
            addCriterion("CnapsBankCode between", value1, value2, "cnapsbankcode");
            return (Criteria) this;
        }

        public Criteria andCnapsbankcodeNotBetween(String value1, String value2) {
            addCriterion("CnapsBankCode not between", value1, value2, "cnapsbankcode");
            return (Criteria) this;
        }

        public Criteria andLastupdateuserIsNull() {
            addCriterion("LastUpdateUser is null");
            return (Criteria) this;
        }

        public Criteria andLastupdateuserIsNotNull() {
            addCriterion("LastUpdateUser is not null");
            return (Criteria) this;
        }

        public Criteria andLastupdateuserEqualTo(String value) {
            addCriterion("LastUpdateUser =", value, "lastupdateuser");
            return (Criteria) this;
        }

        public Criteria andLastupdateuserNotEqualTo(String value) {
            addCriterion("LastUpdateUser <>", value, "lastupdateuser");
            return (Criteria) this;
        }

        public Criteria andLastupdateuserGreaterThan(String value) {
            addCriterion("LastUpdateUser >", value, "lastupdateuser");
            return (Criteria) this;
        }

        public Criteria andLastupdateuserGreaterThanOrEqualTo(String value) {
            addCriterion("LastUpdateUser >=", value, "lastupdateuser");
            return (Criteria) this;
        }

        public Criteria andLastupdateuserLessThan(String value) {
            addCriterion("LastUpdateUser <", value, "lastupdateuser");
            return (Criteria) this;
        }

        public Criteria andLastupdateuserLessThanOrEqualTo(String value) {
            addCriterion("LastUpdateUser <=", value, "lastupdateuser");
            return (Criteria) this;
        }

        public Criteria andLastupdateuserLike(String value) {
            addCriterion("LastUpdateUser like", value, "lastupdateuser");
            return (Criteria) this;
        }

        public Criteria andLastupdateuserNotLike(String value) {
            addCriterion("LastUpdateUser not like", value, "lastupdateuser");
            return (Criteria) this;
        }

        public Criteria andLastupdateuserIn(List<String> values) {
            addCriterion("LastUpdateUser in", values, "lastupdateuser");
            return (Criteria) this;
        }

        public Criteria andLastupdateuserNotIn(List<String> values) {
            addCriterion("LastUpdateUser not in", values, "lastupdateuser");
            return (Criteria) this;
        }

        public Criteria andLastupdateuserBetween(String value1, String value2) {
            addCriterion("LastUpdateUser between", value1, value2, "lastupdateuser");
            return (Criteria) this;
        }

        public Criteria andLastupdateuserNotBetween(String value1, String value2) {
            addCriterion("LastUpdateUser not between", value1, value2, "lastupdateuser");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeIsNull() {
            addCriterion("LastUpdateTime is null");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeIsNotNull() {
            addCriterion("LastUpdateTime is not null");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeEqualTo(Date value) {
            addCriterion("LastUpdateTime =", value, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeNotEqualTo(Date value) {
            addCriterion("LastUpdateTime <>", value, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeGreaterThan(Date value) {
            addCriterion("LastUpdateTime >", value, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("LastUpdateTime >=", value, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeLessThan(Date value) {
            addCriterion("LastUpdateTime <", value, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("LastUpdateTime <=", value, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeIn(List<Date> values) {
            addCriterion("LastUpdateTime in", values, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeNotIn(List<Date> values) {
            addCriterion("LastUpdateTime not in", values, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeBetween(Date value1, Date value2) {
            addCriterion("LastUpdateTime between", value1, value2, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("LastUpdateTime not between", value1, value2, "lastupdatetime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}