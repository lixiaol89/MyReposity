package com.huatai.cube.server.ts.modules.securitypool.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SecurityPoolModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SecurityPoolModelExample() {
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

        public Criteria andLendableamountIsNull() {
            addCriterion("LendAbleAmount is null");
            return (Criteria) this;
        }

        public Criteria andLendableamountIsNotNull() {
            addCriterion("LendAbleAmount is not null");
            return (Criteria) this;
        }

        public Criteria andLendableamountEqualTo(Integer value) {
            addCriterion("LendAbleAmount =", value, "lendableamount");
            return (Criteria) this;
        }

        public Criteria andLendableamountNotEqualTo(Integer value) {
            addCriterion("LendAbleAmount <>", value, "lendableamount");
            return (Criteria) this;
        }

        public Criteria andLendableamountGreaterThan(Integer value) {
            addCriterion("LendAbleAmount >", value, "lendableamount");
            return (Criteria) this;
        }

        public Criteria andLendableamountGreaterThanOrEqualTo(Integer value) {
            addCriterion("LendAbleAmount >=", value, "lendableamount");
            return (Criteria) this;
        }

        public Criteria andLendableamountLessThan(Integer value) {
            addCriterion("LendAbleAmount <", value, "lendableamount");
            return (Criteria) this;
        }

        public Criteria andLendableamountLessThanOrEqualTo(Integer value) {
            addCriterion("LendAbleAmount <=", value, "lendableamount");
            return (Criteria) this;
        }

        public Criteria andLendableamountIn(List<Integer> values) {
            addCriterion("LendAbleAmount in", values, "lendableamount");
            return (Criteria) this;
        }

        public Criteria andLendableamountNotIn(List<Integer> values) {
            addCriterion("LendAbleAmount not in", values, "lendableamount");
            return (Criteria) this;
        }

        public Criteria andLendableamountBetween(Integer value1, Integer value2) {
            addCriterion("LendAbleAmount between", value1, value2, "lendableamount");
            return (Criteria) this;
        }

        public Criteria andLendableamountNotBetween(Integer value1, Integer value2) {
            addCriterion("LendAbleAmount not between", value1, value2, "lendableamount");
            return (Criteria) this;
        }

        public Criteria andLockedamountIsNull() {
            addCriterion("LockedAmount is null");
            return (Criteria) this;
        }

        public Criteria andLockedamountIsNotNull() {
            addCriterion("LockedAmount is not null");
            return (Criteria) this;
        }

        public Criteria andLockedamountEqualTo(Integer value) {
            addCriterion("LockedAmount =", value, "lockedamount");
            return (Criteria) this;
        }

        public Criteria andLockedamountNotEqualTo(Integer value) {
            addCriterion("LockedAmount <>", value, "lockedamount");
            return (Criteria) this;
        }

        public Criteria andLockedamountGreaterThan(Integer value) {
            addCriterion("LockedAmount >", value, "lockedamount");
            return (Criteria) this;
        }

        public Criteria andLockedamountGreaterThanOrEqualTo(Integer value) {
            addCriterion("LockedAmount >=", value, "lockedamount");
            return (Criteria) this;
        }

        public Criteria andLockedamountLessThan(Integer value) {
            addCriterion("LockedAmount <", value, "lockedamount");
            return (Criteria) this;
        }

        public Criteria andLockedamountLessThanOrEqualTo(Integer value) {
            addCriterion("LockedAmount <=", value, "lockedamount");
            return (Criteria) this;
        }

        public Criteria andLockedamountIn(List<Integer> values) {
            addCriterion("LockedAmount in", values, "lockedamount");
            return (Criteria) this;
        }

        public Criteria andLockedamountNotIn(List<Integer> values) {
            addCriterion("LockedAmount not in", values, "lockedamount");
            return (Criteria) this;
        }

        public Criteria andLockedamountBetween(Integer value1, Integer value2) {
            addCriterion("LockedAmount between", value1, value2, "lockedamount");
            return (Criteria) this;
        }

        public Criteria andLockedamountNotBetween(Integer value1, Integer value2) {
            addCriterion("LockedAmount not between", value1, value2, "lockedamount");
            return (Criteria) this;
        }

        public Criteria andLeftamountIsNull() {
            addCriterion("LeftAmount is null");
            return (Criteria) this;
        }

        public Criteria andLeftamountIsNotNull() {
            addCriterion("LeftAmount is not null");
            return (Criteria) this;
        }

        public Criteria andLeftamountEqualTo(Integer value) {
            addCriterion("LeftAmount =", value, "leftamount");
            return (Criteria) this;
        }

        public Criteria andLeftamountNotEqualTo(Integer value) {
            addCriterion("LeftAmount <>", value, "leftamount");
            return (Criteria) this;
        }

        public Criteria andLeftamountGreaterThan(Integer value) {
            addCriterion("LeftAmount >", value, "leftamount");
            return (Criteria) this;
        }

        public Criteria andLeftamountGreaterThanOrEqualTo(Integer value) {
            addCriterion("LeftAmount >=", value, "leftamount");
            return (Criteria) this;
        }

        public Criteria andLeftamountLessThan(Integer value) {
            addCriterion("LeftAmount <", value, "leftamount");
            return (Criteria) this;
        }

        public Criteria andLeftamountLessThanOrEqualTo(Integer value) {
            addCriterion("LeftAmount <=", value, "leftamount");
            return (Criteria) this;
        }

        public Criteria andLeftamountIn(List<Integer> values) {
            addCriterion("LeftAmount in", values, "leftamount");
            return (Criteria) this;
        }

        public Criteria andLeftamountNotIn(List<Integer> values) {
            addCriterion("LeftAmount not in", values, "leftamount");
            return (Criteria) this;
        }

        public Criteria andLeftamountBetween(Integer value1, Integer value2) {
            addCriterion("LeftAmount between", value1, value2, "leftamount");
            return (Criteria) this;
        }

        public Criteria andLeftamountNotBetween(Integer value1, Integer value2) {
            addCriterion("LeftAmount not between", value1, value2, "leftamount");
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

        public Criteria andShortableamountIsNull() {
            addCriterion("ShortAbleAmount is null");
            return (Criteria) this;
        }

        public Criteria andShortableamountIsNotNull() {
            addCriterion("ShortAbleAmount is not null");
            return (Criteria) this;
        }

        public Criteria andShortableamountEqualTo(Integer value) {
            addCriterion("ShortAbleAmount =", value, "shortableamount");
            return (Criteria) this;
        }

        public Criteria andShortableamountNotEqualTo(Integer value) {
            addCriterion("ShortAbleAmount <>", value, "shortableamount");
            return (Criteria) this;
        }

        public Criteria andShortableamountGreaterThan(Integer value) {
            addCriterion("ShortAbleAmount >", value, "shortableamount");
            return (Criteria) this;
        }

        public Criteria andShortableamountGreaterThanOrEqualTo(Integer value) {
            addCriterion("ShortAbleAmount >=", value, "shortableamount");
            return (Criteria) this;
        }

        public Criteria andShortableamountLessThan(Integer value) {
            addCriterion("ShortAbleAmount <", value, "shortableamount");
            return (Criteria) this;
        }

        public Criteria andShortableamountLessThanOrEqualTo(Integer value) {
            addCriterion("ShortAbleAmount <=", value, "shortableamount");
            return (Criteria) this;
        }

        public Criteria andShortableamountIn(List<Integer> values) {
            addCriterion("ShortAbleAmount in", values, "shortableamount");
            return (Criteria) this;
        }

        public Criteria andShortableamountNotIn(List<Integer> values) {
            addCriterion("ShortAbleAmount not in", values, "shortableamount");
            return (Criteria) this;
        }

        public Criteria andShortableamountBetween(Integer value1, Integer value2) {
            addCriterion("ShortAbleAmount between", value1, value2, "shortableamount");
            return (Criteria) this;
        }

        public Criteria andShortableamountNotBetween(Integer value1, Integer value2) {
            addCriterion("ShortAbleAmount not between", value1, value2, "shortableamount");
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

        public Criteria andCustomertypeIsNull() {
            addCriterion("CustomerType is null");
            return (Criteria) this;
        }

        public Criteria andCustomertypeIsNotNull() {
            addCriterion("CustomerType is not null");
            return (Criteria) this;
        }

        public Criteria andCustomertypeEqualTo(String value) {
            addCriterion("CustomerType =", value, "customertype");
            return (Criteria) this;
        }

        public Criteria andCustomertypeNotEqualTo(String value) {
            addCriterion("CustomerType <>", value, "customertype");
            return (Criteria) this;
        }

        public Criteria andCustomertypeGreaterThan(String value) {
            addCriterion("CustomerType >", value, "customertype");
            return (Criteria) this;
        }

        public Criteria andCustomertypeGreaterThanOrEqualTo(String value) {
            addCriterion("CustomerType >=", value, "customertype");
            return (Criteria) this;
        }

        public Criteria andCustomertypeLessThan(String value) {
            addCriterion("CustomerType <", value, "customertype");
            return (Criteria) this;
        }

        public Criteria andCustomertypeLessThanOrEqualTo(String value) {
            addCriterion("CustomerType <=", value, "customertype");
            return (Criteria) this;
        }

        public Criteria andCustomertypeLike(String value) {
            addCriterion("CustomerType like", value, "customertype");
            return (Criteria) this;
        }

        public Criteria andCustomertypeNotLike(String value) {
            addCriterion("CustomerType not like", value, "customertype");
            return (Criteria) this;
        }

        public Criteria andCustomertypeIn(List<String> values) {
            addCriterion("CustomerType in", values, "customertype");
            return (Criteria) this;
        }

        public Criteria andCustomertypeNotIn(List<String> values) {
            addCriterion("CustomerType not in", values, "customertype");
            return (Criteria) this;
        }

        public Criteria andCustomertypeBetween(String value1, String value2) {
            addCriterion("CustomerType between", value1, value2, "customertype");
            return (Criteria) this;
        }

        public Criteria andCustomertypeNotBetween(String value1, String value2) {
            addCriterion("CustomerType not between", value1, value2, "customertype");
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