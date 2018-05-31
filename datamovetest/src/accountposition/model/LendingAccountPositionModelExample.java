package com.huatai.cube.server.ts.modules.accountposition.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class LendingAccountPositionModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LendingAccountPositionModelExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andAssetaccountIsNull() {
            addCriterion("AssetAccount is null");
            return (Criteria) this;
        }

        public Criteria andAssetaccountIsNotNull() {
            addCriterion("AssetAccount is not null");
            return (Criteria) this;
        }

        public Criteria andAssetaccountEqualTo(String value) {
            addCriterion("AssetAccount =", value, "assetaccount");
            return (Criteria) this;
        }

        public Criteria andAssetaccountNotEqualTo(String value) {
            addCriterion("AssetAccount <>", value, "assetaccount");
            return (Criteria) this;
        }

        public Criteria andAssetaccountGreaterThan(String value) {
            addCriterion("AssetAccount >", value, "assetaccount");
            return (Criteria) this;
        }

        public Criteria andAssetaccountGreaterThanOrEqualTo(String value) {
            addCriterion("AssetAccount >=", value, "assetaccount");
            return (Criteria) this;
        }

        public Criteria andAssetaccountLessThan(String value) {
            addCriterion("AssetAccount <", value, "assetaccount");
            return (Criteria) this;
        }

        public Criteria andAssetaccountLessThanOrEqualTo(String value) {
            addCriterion("AssetAccount <=", value, "assetaccount");
            return (Criteria) this;
        }

        public Criteria andAssetaccountLike(String value) {
            addCriterion("AssetAccount like", value, "assetaccount");
            return (Criteria) this;
        }

        public Criteria andAssetaccountNotLike(String value) {
            addCriterion("AssetAccount not like", value, "assetaccount");
            return (Criteria) this;
        }

        public Criteria andAssetaccountIn(List<String> values) {
            addCriterion("AssetAccount in", values, "assetaccount");
            return (Criteria) this;
        }

        public Criteria andAssetaccountNotIn(List<String> values) {
            addCriterion("AssetAccount not in", values, "assetaccount");
            return (Criteria) this;
        }

        public Criteria andAssetaccountBetween(String value1, String value2) {
            addCriterion("AssetAccount between", value1, value2, "assetaccount");
            return (Criteria) this;
        }

        public Criteria andAssetaccountNotBetween(String value1, String value2) {
            addCriterion("AssetAccount not between", value1, value2, "assetaccount");
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

        public Criteria andSecurityaccountIsNull() {
            addCriterion("SecurityAccount is null");
            return (Criteria) this;
        }

        public Criteria andSecurityaccountIsNotNull() {
            addCriterion("SecurityAccount is not null");
            return (Criteria) this;
        }

        public Criteria andSecurityaccountEqualTo(String value) {
            addCriterion("SecurityAccount =", value, "securityaccount");
            return (Criteria) this;
        }

        public Criteria andSecurityaccountNotEqualTo(String value) {
            addCriterion("SecurityAccount <>", value, "securityaccount");
            return (Criteria) this;
        }

        public Criteria andSecurityaccountGreaterThan(String value) {
            addCriterion("SecurityAccount >", value, "securityaccount");
            return (Criteria) this;
        }

        public Criteria andSecurityaccountGreaterThanOrEqualTo(String value) {
            addCriterion("SecurityAccount >=", value, "securityaccount");
            return (Criteria) this;
        }

        public Criteria andSecurityaccountLessThan(String value) {
            addCriterion("SecurityAccount <", value, "securityaccount");
            return (Criteria) this;
        }

        public Criteria andSecurityaccountLessThanOrEqualTo(String value) {
            addCriterion("SecurityAccount <=", value, "securityaccount");
            return (Criteria) this;
        }

        public Criteria andSecurityaccountLike(String value) {
            addCriterion("SecurityAccount like", value, "securityaccount");
            return (Criteria) this;
        }

        public Criteria andSecurityaccountNotLike(String value) {
            addCriterion("SecurityAccount not like", value, "securityaccount");
            return (Criteria) this;
        }

        public Criteria andSecurityaccountIn(List<String> values) {
            addCriterion("SecurityAccount in", values, "securityaccount");
            return (Criteria) this;
        }

        public Criteria andSecurityaccountNotIn(List<String> values) {
            addCriterion("SecurityAccount not in", values, "securityaccount");
            return (Criteria) this;
        }

        public Criteria andSecurityaccountBetween(String value1, String value2) {
            addCriterion("SecurityAccount between", value1, value2, "securityaccount");
            return (Criteria) this;
        }

        public Criteria andSecurityaccountNotBetween(String value1, String value2) {
            addCriterion("SecurityAccount not between", value1, value2, "securityaccount");
            return (Criteria) this;
        }

        public Criteria andExecbrokerIsNull() {
            addCriterion("ExecBroker is null");
            return (Criteria) this;
        }

        public Criteria andExecbrokerIsNotNull() {
            addCriterion("ExecBroker is not null");
            return (Criteria) this;
        }

        public Criteria andExecbrokerEqualTo(String value) {
            addCriterion("ExecBroker =", value, "execbroker");
            return (Criteria) this;
        }

        public Criteria andExecbrokerNotEqualTo(String value) {
            addCriterion("ExecBroker <>", value, "execbroker");
            return (Criteria) this;
        }

        public Criteria andExecbrokerGreaterThan(String value) {
            addCriterion("ExecBroker >", value, "execbroker");
            return (Criteria) this;
        }

        public Criteria andExecbrokerGreaterThanOrEqualTo(String value) {
            addCriterion("ExecBroker >=", value, "execbroker");
            return (Criteria) this;
        }

        public Criteria andExecbrokerLessThan(String value) {
            addCriterion("ExecBroker <", value, "execbroker");
            return (Criteria) this;
        }

        public Criteria andExecbrokerLessThanOrEqualTo(String value) {
            addCriterion("ExecBroker <=", value, "execbroker");
            return (Criteria) this;
        }

        public Criteria andExecbrokerLike(String value) {
            addCriterion("ExecBroker like", value, "execbroker");
            return (Criteria) this;
        }

        public Criteria andExecbrokerNotLike(String value) {
            addCriterion("ExecBroker not like", value, "execbroker");
            return (Criteria) this;
        }

        public Criteria andExecbrokerIn(List<String> values) {
            addCriterion("ExecBroker in", values, "execbroker");
            return (Criteria) this;
        }

        public Criteria andExecbrokerNotIn(List<String> values) {
            addCriterion("ExecBroker not in", values, "execbroker");
            return (Criteria) this;
        }

        public Criteria andExecbrokerBetween(String value1, String value2) {
            addCriterion("ExecBroker between", value1, value2, "execbroker");
            return (Criteria) this;
        }

        public Criteria andExecbrokerNotBetween(String value1, String value2) {
            addCriterion("ExecBroker not between", value1, value2, "execbroker");
            return (Criteria) this;
        }

        public Criteria andSecurityexchangeIsNull() {
            addCriterion("SecurityExchange is null");
            return (Criteria) this;
        }

        public Criteria andSecurityexchangeIsNotNull() {
            addCriterion("SecurityExchange is not null");
            return (Criteria) this;
        }

        public Criteria andSecurityexchangeEqualTo(String value) {
            addCriterion("SecurityExchange =", value, "securityexchange");
            return (Criteria) this;
        }

        public Criteria andSecurityexchangeNotEqualTo(String value) {
            addCriterion("SecurityExchange <>", value, "securityexchange");
            return (Criteria) this;
        }

        public Criteria andSecurityexchangeGreaterThan(String value) {
            addCriterion("SecurityExchange >", value, "securityexchange");
            return (Criteria) this;
        }

        public Criteria andSecurityexchangeGreaterThanOrEqualTo(String value) {
            addCriterion("SecurityExchange >=", value, "securityexchange");
            return (Criteria) this;
        }

        public Criteria andSecurityexchangeLessThan(String value) {
            addCriterion("SecurityExchange <", value, "securityexchange");
            return (Criteria) this;
        }

        public Criteria andSecurityexchangeLessThanOrEqualTo(String value) {
            addCriterion("SecurityExchange <=", value, "securityexchange");
            return (Criteria) this;
        }

        public Criteria andSecurityexchangeLike(String value) {
            addCriterion("SecurityExchange like", value, "securityexchange");
            return (Criteria) this;
        }

        public Criteria andSecurityexchangeNotLike(String value) {
            addCriterion("SecurityExchange not like", value, "securityexchange");
            return (Criteria) this;
        }

        public Criteria andSecurityexchangeIn(List<String> values) {
            addCriterion("SecurityExchange in", values, "securityexchange");
            return (Criteria) this;
        }

        public Criteria andSecurityexchangeNotIn(List<String> values) {
            addCriterion("SecurityExchange not in", values, "securityexchange");
            return (Criteria) this;
        }

        public Criteria andSecurityexchangeBetween(String value1, String value2) {
            addCriterion("SecurityExchange between", value1, value2, "securityexchange");
            return (Criteria) this;
        }

        public Criteria andSecurityexchangeNotBetween(String value1, String value2) {
            addCriterion("SecurityExchange not between", value1, value2, "securityexchange");
            return (Criteria) this;
        }

        public Criteria andUnderlyingIsNull() {
            addCriterion("Underlying is null");
            return (Criteria) this;
        }

        public Criteria andUnderlyingIsNotNull() {
            addCriterion("Underlying is not null");
            return (Criteria) this;
        }

        public Criteria andUnderlyingEqualTo(String value) {
            addCriterion("Underlying =", value, "underlying");
            return (Criteria) this;
        }

        public Criteria andUnderlyingNotEqualTo(String value) {
            addCriterion("Underlying <>", value, "underlying");
            return (Criteria) this;
        }

        public Criteria andUnderlyingGreaterThan(String value) {
            addCriterion("Underlying >", value, "underlying");
            return (Criteria) this;
        }

        public Criteria andUnderlyingGreaterThanOrEqualTo(String value) {
            addCriterion("Underlying >=", value, "underlying");
            return (Criteria) this;
        }

        public Criteria andUnderlyingLessThan(String value) {
            addCriterion("Underlying <", value, "underlying");
            return (Criteria) this;
        }

        public Criteria andUnderlyingLessThanOrEqualTo(String value) {
            addCriterion("Underlying <=", value, "underlying");
            return (Criteria) this;
        }

        public Criteria andUnderlyingLike(String value) {
            addCriterion("Underlying like", value, "underlying");
            return (Criteria) this;
        }

        public Criteria andUnderlyingNotLike(String value) {
            addCriterion("Underlying not like", value, "underlying");
            return (Criteria) this;
        }

        public Criteria andUnderlyingIn(List<String> values) {
            addCriterion("Underlying in", values, "underlying");
            return (Criteria) this;
        }

        public Criteria andUnderlyingNotIn(List<String> values) {
            addCriterion("Underlying not in", values, "underlying");
            return (Criteria) this;
        }

        public Criteria andUnderlyingBetween(String value1, String value2) {
            addCriterion("Underlying between", value1, value2, "underlying");
            return (Criteria) this;
        }

        public Criteria andUnderlyingNotBetween(String value1, String value2) {
            addCriterion("Underlying not between", value1, value2, "underlying");
            return (Criteria) this;
        }

        public Criteria andUnderlyingnameIsNull() {
            addCriterion("UnderlyingName is null");
            return (Criteria) this;
        }

        public Criteria andUnderlyingnameIsNotNull() {
            addCriterion("UnderlyingName is not null");
            return (Criteria) this;
        }

        public Criteria andUnderlyingnameEqualTo(String value) {
            addCriterion("UnderlyingName =", value, "underlyingname");
            return (Criteria) this;
        }

        public Criteria andUnderlyingnameNotEqualTo(String value) {
            addCriterion("UnderlyingName <>", value, "underlyingname");
            return (Criteria) this;
        }

        public Criteria andUnderlyingnameGreaterThan(String value) {
            addCriterion("UnderlyingName >", value, "underlyingname");
            return (Criteria) this;
        }

        public Criteria andUnderlyingnameGreaterThanOrEqualTo(String value) {
            addCriterion("UnderlyingName >=", value, "underlyingname");
            return (Criteria) this;
        }

        public Criteria andUnderlyingnameLessThan(String value) {
            addCriterion("UnderlyingName <", value, "underlyingname");
            return (Criteria) this;
        }

        public Criteria andUnderlyingnameLessThanOrEqualTo(String value) {
            addCriterion("UnderlyingName <=", value, "underlyingname");
            return (Criteria) this;
        }

        public Criteria andUnderlyingnameLike(String value) {
            addCriterion("UnderlyingName like", value, "underlyingname");
            return (Criteria) this;
        }

        public Criteria andUnderlyingnameNotLike(String value) {
            addCriterion("UnderlyingName not like", value, "underlyingname");
            return (Criteria) this;
        }

        public Criteria andUnderlyingnameIn(List<String> values) {
            addCriterion("UnderlyingName in", values, "underlyingname");
            return (Criteria) this;
        }

        public Criteria andUnderlyingnameNotIn(List<String> values) {
            addCriterion("UnderlyingName not in", values, "underlyingname");
            return (Criteria) this;
        }

        public Criteria andUnderlyingnameBetween(String value1, String value2) {
            addCriterion("UnderlyingName between", value1, value2, "underlyingname");
            return (Criteria) this;
        }

        public Criteria andUnderlyingnameNotBetween(String value1, String value2) {
            addCriterion("UnderlyingName not between", value1, value2, "underlyingname");
            return (Criteria) this;
        }

        public Criteria andPositionIsNull() {
            addCriterion("Position is null");
            return (Criteria) this;
        }

        public Criteria andPositionIsNotNull() {
            addCriterion("Position is not null");
            return (Criteria) this;
        }

        public Criteria andPositionEqualTo(Integer value) {
            addCriterion("Position =", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotEqualTo(Integer value) {
            addCriterion("Position <>", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThan(Integer value) {
            addCriterion("Position >", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThanOrEqualTo(Integer value) {
            addCriterion("Position >=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThan(Integer value) {
            addCriterion("Position <", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThanOrEqualTo(Integer value) {
            addCriterion("Position <=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionIn(List<Integer> values) {
            addCriterion("Position in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotIn(List<Integer> values) {
            addCriterion("Position not in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionBetween(Integer value1, Integer value2) {
            addCriterion("Position between", value1, value2, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotBetween(Integer value1, Integer value2) {
            addCriterion("Position not between", value1, value2, "position");
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

        public Criteria andLockedpositionIsNull() {
            addCriterion("LockedPosition is null");
            return (Criteria) this;
        }

        public Criteria andLockedpositionIsNotNull() {
            addCriterion("LockedPosition is not null");
            return (Criteria) this;
        }

        public Criteria andLockedpositionEqualTo(Integer value) {
            addCriterion("LockedPosition =", value, "lockedposition");
            return (Criteria) this;
        }

        public Criteria andLockedpositionNotEqualTo(Integer value) {
            addCriterion("LockedPosition <>", value, "lockedposition");
            return (Criteria) this;
        }

        public Criteria andLockedpositionGreaterThan(Integer value) {
            addCriterion("LockedPosition >", value, "lockedposition");
            return (Criteria) this;
        }

        public Criteria andLockedpositionGreaterThanOrEqualTo(Integer value) {
            addCriterion("LockedPosition >=", value, "lockedposition");
            return (Criteria) this;
        }

        public Criteria andLockedpositionLessThan(Integer value) {
            addCriterion("LockedPosition <", value, "lockedposition");
            return (Criteria) this;
        }

        public Criteria andLockedpositionLessThanOrEqualTo(Integer value) {
            addCriterion("LockedPosition <=", value, "lockedposition");
            return (Criteria) this;
        }

        public Criteria andLockedpositionIn(List<Integer> values) {
            addCriterion("LockedPosition in", values, "lockedposition");
            return (Criteria) this;
        }

        public Criteria andLockedpositionNotIn(List<Integer> values) {
            addCriterion("LockedPosition not in", values, "lockedposition");
            return (Criteria) this;
        }

        public Criteria andLockedpositionBetween(Integer value1, Integer value2) {
            addCriterion("LockedPosition between", value1, value2, "lockedposition");
            return (Criteria) this;
        }

        public Criteria andLockedpositionNotBetween(Integer value1, Integer value2) {
            addCriterion("LockedPosition not between", value1, value2, "lockedposition");
            return (Criteria) this;
        }

        public Criteria andLockedshortamountIsNull() {
            addCriterion("LockedShortAmount is null");
            return (Criteria) this;
        }

        public Criteria andLockedshortamountIsNotNull() {
            addCriterion("LockedShortAmount is not null");
            return (Criteria) this;
        }

        public Criteria andLockedshortamountEqualTo(Integer value) {
            addCriterion("LockedShortAmount =", value, "lockedshortamount");
            return (Criteria) this;
        }

        public Criteria andLockedshortamountNotEqualTo(Integer value) {
            addCriterion("LockedShortAmount <>", value, "lockedshortamount");
            return (Criteria) this;
        }

        public Criteria andLockedshortamountGreaterThan(Integer value) {
            addCriterion("LockedShortAmount >", value, "lockedshortamount");
            return (Criteria) this;
        }

        public Criteria andLockedshortamountGreaterThanOrEqualTo(Integer value) {
            addCriterion("LockedShortAmount >=", value, "lockedshortamount");
            return (Criteria) this;
        }

        public Criteria andLockedshortamountLessThan(Integer value) {
            addCriterion("LockedShortAmount <", value, "lockedshortamount");
            return (Criteria) this;
        }

        public Criteria andLockedshortamountLessThanOrEqualTo(Integer value) {
            addCriterion("LockedShortAmount <=", value, "lockedshortamount");
            return (Criteria) this;
        }

        public Criteria andLockedshortamountIn(List<Integer> values) {
            addCriterion("LockedShortAmount in", values, "lockedshortamount");
            return (Criteria) this;
        }

        public Criteria andLockedshortamountNotIn(List<Integer> values) {
            addCriterion("LockedShortAmount not in", values, "lockedshortamount");
            return (Criteria) this;
        }

        public Criteria andLockedshortamountBetween(Integer value1, Integer value2) {
            addCriterion("LockedShortAmount between", value1, value2, "lockedshortamount");
            return (Criteria) this;
        }

        public Criteria andLockedshortamountNotBetween(Integer value1, Integer value2) {
            addCriterion("LockedShortAmount not between", value1, value2, "lockedshortamount");
            return (Criteria) this;
        }

        public Criteria andShortamountIsNull() {
            addCriterion("ShortAmount is null");
            return (Criteria) this;
        }

        public Criteria andShortamountIsNotNull() {
            addCriterion("ShortAmount is not null");
            return (Criteria) this;
        }

        public Criteria andShortamountEqualTo(Integer value) {
            addCriterion("ShortAmount =", value, "shortamount");
            return (Criteria) this;
        }

        public Criteria andShortamountNotEqualTo(Integer value) {
            addCriterion("ShortAmount <>", value, "shortamount");
            return (Criteria) this;
        }

        public Criteria andShortamountGreaterThan(Integer value) {
            addCriterion("ShortAmount >", value, "shortamount");
            return (Criteria) this;
        }

        public Criteria andShortamountGreaterThanOrEqualTo(Integer value) {
            addCriterion("ShortAmount >=", value, "shortamount");
            return (Criteria) this;
        }

        public Criteria andShortamountLessThan(Integer value) {
            addCriterion("ShortAmount <", value, "shortamount");
            return (Criteria) this;
        }

        public Criteria andShortamountLessThanOrEqualTo(Integer value) {
            addCriterion("ShortAmount <=", value, "shortamount");
            return (Criteria) this;
        }

        public Criteria andShortamountIn(List<Integer> values) {
            addCriterion("ShortAmount in", values, "shortamount");
            return (Criteria) this;
        }

        public Criteria andShortamountNotIn(List<Integer> values) {
            addCriterion("ShortAmount not in", values, "shortamount");
            return (Criteria) this;
        }

        public Criteria andShortamountBetween(Integer value1, Integer value2) {
            addCriterion("ShortAmount between", value1, value2, "shortamount");
            return (Criteria) this;
        }

        public Criteria andShortamountNotBetween(Integer value1, Integer value2) {
            addCriterion("ShortAmount not between", value1, value2, "shortamount");
            return (Criteria) this;
        }

        public Criteria andDateIsNull() {
            addCriterion("Date is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("Date is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(Date value) {
            addCriterionForJDBCDate("Date =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("Date <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(Date value) {
            addCriterionForJDBCDate("Date >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("Date >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(Date value) {
            addCriterionForJDBCDate("Date <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("Date <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<Date> values) {
            addCriterionForJDBCDate("Date in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("Date not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("Date between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("Date not between", value1, value2, "date");
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