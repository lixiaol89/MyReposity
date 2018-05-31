package com.huatai.cube.rms.modules.mktquotation.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class LivePriceModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LivePriceModelExample() {
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

        public Criteria andNowdateIsNull() {
            addCriterion("NowDate is null");
            return (Criteria) this;
        }

        public Criteria andNowdateIsNotNull() {
            addCriterion("NowDate is not null");
            return (Criteria) this;
        }

        public Criteria andNowdateEqualTo(Date value) {
            addCriterionForJDBCDate("NowDate =", value, "nowdate");
            return (Criteria) this;
        }

        public Criteria andNowdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("NowDate <>", value, "nowdate");
            return (Criteria) this;
        }

        public Criteria andNowdateGreaterThan(Date value) {
            addCriterionForJDBCDate("NowDate >", value, "nowdate");
            return (Criteria) this;
        }

        public Criteria andNowdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("NowDate >=", value, "nowdate");
            return (Criteria) this;
        }

        public Criteria andNowdateLessThan(Date value) {
            addCriterionForJDBCDate("NowDate <", value, "nowdate");
            return (Criteria) this;
        }

        public Criteria andNowdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("NowDate <=", value, "nowdate");
            return (Criteria) this;
        }

        public Criteria andNowdateIn(List<Date> values) {
            addCriterionForJDBCDate("NowDate in", values, "nowdate");
            return (Criteria) this;
        }

        public Criteria andNowdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("NowDate not in", values, "nowdate");
            return (Criteria) this;
        }

        public Criteria andNowdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("NowDate between", value1, value2, "nowdate");
            return (Criteria) this;
        }

        public Criteria andNowdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("NowDate not between", value1, value2, "nowdate");
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

        public Criteria andCurrencyIsNull() {
            addCriterion("Currency is null");
            return (Criteria) this;
        }

        public Criteria andCurrencyIsNotNull() {
            addCriterion("Currency is not null");
            return (Criteria) this;
        }

        public Criteria andCurrencyEqualTo(String value) {
            addCriterion("Currency =", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotEqualTo(String value) {
            addCriterion("Currency <>", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyGreaterThan(String value) {
            addCriterion("Currency >", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyGreaterThanOrEqualTo(String value) {
            addCriterion("Currency >=", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLessThan(String value) {
            addCriterion("Currency <", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLessThanOrEqualTo(String value) {
            addCriterion("Currency <=", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLike(String value) {
            addCriterion("Currency like", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotLike(String value) {
            addCriterion("Currency not like", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyIn(List<String> values) {
            addCriterion("Currency in", values, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotIn(List<String> values) {
            addCriterion("Currency not in", values, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyBetween(String value1, String value2) {
            addCriterion("Currency between", value1, value2, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotBetween(String value1, String value2) {
            addCriterion("Currency not between", value1, value2, "currency");
            return (Criteria) this;
        }

        public Criteria andExchangecodeIsNull() {
            addCriterion("ExchangeCode is null");
            return (Criteria) this;
        }

        public Criteria andExchangecodeIsNotNull() {
            addCriterion("ExchangeCode is not null");
            return (Criteria) this;
        }

        public Criteria andExchangecodeEqualTo(String value) {
            addCriterion("ExchangeCode =", value, "exchangecode");
            return (Criteria) this;
        }

        public Criteria andExchangecodeNotEqualTo(String value) {
            addCriterion("ExchangeCode <>", value, "exchangecode");
            return (Criteria) this;
        }

        public Criteria andExchangecodeGreaterThan(String value) {
            addCriterion("ExchangeCode >", value, "exchangecode");
            return (Criteria) this;
        }

        public Criteria andExchangecodeGreaterThanOrEqualTo(String value) {
            addCriterion("ExchangeCode >=", value, "exchangecode");
            return (Criteria) this;
        }

        public Criteria andExchangecodeLessThan(String value) {
            addCriterion("ExchangeCode <", value, "exchangecode");
            return (Criteria) this;
        }

        public Criteria andExchangecodeLessThanOrEqualTo(String value) {
            addCriterion("ExchangeCode <=", value, "exchangecode");
            return (Criteria) this;
        }

        public Criteria andExchangecodeLike(String value) {
            addCriterion("ExchangeCode like", value, "exchangecode");
            return (Criteria) this;
        }

        public Criteria andExchangecodeNotLike(String value) {
            addCriterion("ExchangeCode not like", value, "exchangecode");
            return (Criteria) this;
        }

        public Criteria andExchangecodeIn(List<String> values) {
            addCriterion("ExchangeCode in", values, "exchangecode");
            return (Criteria) this;
        }

        public Criteria andExchangecodeNotIn(List<String> values) {
            addCriterion("ExchangeCode not in", values, "exchangecode");
            return (Criteria) this;
        }

        public Criteria andExchangecodeBetween(String value1, String value2) {
            addCriterion("ExchangeCode between", value1, value2, "exchangecode");
            return (Criteria) this;
        }

        public Criteria andExchangecodeNotBetween(String value1, String value2) {
            addCriterion("ExchangeCode not between", value1, value2, "exchangecode");
            return (Criteria) this;
        }

        public Criteria andStopflagIsNull() {
            addCriterion("StopFlag is null");
            return (Criteria) this;
        }

        public Criteria andStopflagIsNotNull() {
            addCriterion("StopFlag is not null");
            return (Criteria) this;
        }

        public Criteria andStopflagEqualTo(Boolean value) {
            addCriterion("StopFlag =", value, "stopflag");
            return (Criteria) this;
        }

        public Criteria andStopflagNotEqualTo(Boolean value) {
            addCriterion("StopFlag <>", value, "stopflag");
            return (Criteria) this;
        }

        public Criteria andStopflagGreaterThan(Boolean value) {
            addCriterion("StopFlag >", value, "stopflag");
            return (Criteria) this;
        }

        public Criteria andStopflagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("StopFlag >=", value, "stopflag");
            return (Criteria) this;
        }

        public Criteria andStopflagLessThan(Boolean value) {
            addCriterion("StopFlag <", value, "stopflag");
            return (Criteria) this;
        }

        public Criteria andStopflagLessThanOrEqualTo(Boolean value) {
            addCriterion("StopFlag <=", value, "stopflag");
            return (Criteria) this;
        }

        public Criteria andStopflagIn(List<Boolean> values) {
            addCriterion("StopFlag in", values, "stopflag");
            return (Criteria) this;
        }

        public Criteria andStopflagNotIn(List<Boolean> values) {
            addCriterion("StopFlag not in", values, "stopflag");
            return (Criteria) this;
        }

        public Criteria andStopflagBetween(Boolean value1, Boolean value2) {
            addCriterion("StopFlag between", value1, value2, "stopflag");
            return (Criteria) this;
        }

        public Criteria andStopflagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("StopFlag not between", value1, value2, "stopflag");
            return (Criteria) this;
        }

        public Criteria andLastIsNull() {
            addCriterion("Last is null");
            return (Criteria) this;
        }

        public Criteria andLastIsNotNull() {
            addCriterion("Last is not null");
            return (Criteria) this;
        }

        public Criteria andLastEqualTo(BigDecimal value) {
            addCriterion("Last =", value, "last");
            return (Criteria) this;
        }

        public Criteria andLastNotEqualTo(BigDecimal value) {
            addCriterion("Last <>", value, "last");
            return (Criteria) this;
        }

        public Criteria andLastGreaterThan(BigDecimal value) {
            addCriterion("Last >", value, "last");
            return (Criteria) this;
        }

        public Criteria andLastGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("Last >=", value, "last");
            return (Criteria) this;
        }

        public Criteria andLastLessThan(BigDecimal value) {
            addCriterion("Last <", value, "last");
            return (Criteria) this;
        }

        public Criteria andLastLessThanOrEqualTo(BigDecimal value) {
            addCriterion("Last <=", value, "last");
            return (Criteria) this;
        }

        public Criteria andLastIn(List<BigDecimal> values) {
            addCriterion("Last in", values, "last");
            return (Criteria) this;
        }

        public Criteria andLastNotIn(List<BigDecimal> values) {
            addCriterion("Last not in", values, "last");
            return (Criteria) this;
        }

        public Criteria andLastBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Last between", value1, value2, "last");
            return (Criteria) this;
        }

        public Criteria andLastNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Last not between", value1, value2, "last");
            return (Criteria) this;
        }

        public Criteria andCloseIsNull() {
            addCriterion("Close is null");
            return (Criteria) this;
        }

        public Criteria andCloseIsNotNull() {
            addCriterion("Close is not null");
            return (Criteria) this;
        }

        public Criteria andCloseEqualTo(BigDecimal value) {
            addCriterion("Close =", value, "close");
            return (Criteria) this;
        }

        public Criteria andCloseNotEqualTo(BigDecimal value) {
            addCriterion("Close <>", value, "close");
            return (Criteria) this;
        }

        public Criteria andCloseGreaterThan(BigDecimal value) {
            addCriterion("Close >", value, "close");
            return (Criteria) this;
        }

        public Criteria andCloseGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("Close >=", value, "close");
            return (Criteria) this;
        }

        public Criteria andCloseLessThan(BigDecimal value) {
            addCriterion("Close <", value, "close");
            return (Criteria) this;
        }

        public Criteria andCloseLessThanOrEqualTo(BigDecimal value) {
            addCriterion("Close <=", value, "close");
            return (Criteria) this;
        }

        public Criteria andCloseIn(List<BigDecimal> values) {
            addCriterion("Close in", values, "close");
            return (Criteria) this;
        }

        public Criteria andCloseNotIn(List<BigDecimal> values) {
            addCriterion("Close not in", values, "close");
            return (Criteria) this;
        }

        public Criteria andCloseBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Close between", value1, value2, "close");
            return (Criteria) this;
        }

        public Criteria andCloseNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Close not between", value1, value2, "close");
            return (Criteria) this;
        }

        public Criteria andOpenIsNull() {
            addCriterion("Open is null");
            return (Criteria) this;
        }

        public Criteria andOpenIsNotNull() {
            addCriterion("Open is not null");
            return (Criteria) this;
        }

        public Criteria andOpenEqualTo(BigDecimal value) {
            addCriterion("Open =", value, "open");
            return (Criteria) this;
        }

        public Criteria andOpenNotEqualTo(BigDecimal value) {
            addCriterion("Open <>", value, "open");
            return (Criteria) this;
        }

        public Criteria andOpenGreaterThan(BigDecimal value) {
            addCriterion("Open >", value, "open");
            return (Criteria) this;
        }

        public Criteria andOpenGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("Open >=", value, "open");
            return (Criteria) this;
        }

        public Criteria andOpenLessThan(BigDecimal value) {
            addCriterion("Open <", value, "open");
            return (Criteria) this;
        }

        public Criteria andOpenLessThanOrEqualTo(BigDecimal value) {
            addCriterion("Open <=", value, "open");
            return (Criteria) this;
        }

        public Criteria andOpenIn(List<BigDecimal> values) {
            addCriterion("Open in", values, "open");
            return (Criteria) this;
        }

        public Criteria andOpenNotIn(List<BigDecimal> values) {
            addCriterion("Open not in", values, "open");
            return (Criteria) this;
        }

        public Criteria andOpenBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Open between", value1, value2, "open");
            return (Criteria) this;
        }

        public Criteria andOpenNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Open not between", value1, value2, "open");
            return (Criteria) this;
        }

        public Criteria andHighIsNull() {
            addCriterion("High is null");
            return (Criteria) this;
        }

        public Criteria andHighIsNotNull() {
            addCriterion("High is not null");
            return (Criteria) this;
        }

        public Criteria andHighEqualTo(BigDecimal value) {
            addCriterion("High =", value, "high");
            return (Criteria) this;
        }

        public Criteria andHighNotEqualTo(BigDecimal value) {
            addCriterion("High <>", value, "high");
            return (Criteria) this;
        }

        public Criteria andHighGreaterThan(BigDecimal value) {
            addCriterion("High >", value, "high");
            return (Criteria) this;
        }

        public Criteria andHighGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("High >=", value, "high");
            return (Criteria) this;
        }

        public Criteria andHighLessThan(BigDecimal value) {
            addCriterion("High <", value, "high");
            return (Criteria) this;
        }

        public Criteria andHighLessThanOrEqualTo(BigDecimal value) {
            addCriterion("High <=", value, "high");
            return (Criteria) this;
        }

        public Criteria andHighIn(List<BigDecimal> values) {
            addCriterion("High in", values, "high");
            return (Criteria) this;
        }

        public Criteria andHighNotIn(List<BigDecimal> values) {
            addCriterion("High not in", values, "high");
            return (Criteria) this;
        }

        public Criteria andHighBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("High between", value1, value2, "high");
            return (Criteria) this;
        }

        public Criteria andHighNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("High not between", value1, value2, "high");
            return (Criteria) this;
        }

        public Criteria andLowIsNull() {
            addCriterion("Low is null");
            return (Criteria) this;
        }

        public Criteria andLowIsNotNull() {
            addCriterion("Low is not null");
            return (Criteria) this;
        }

        public Criteria andLowEqualTo(BigDecimal value) {
            addCriterion("Low =", value, "low");
            return (Criteria) this;
        }

        public Criteria andLowNotEqualTo(BigDecimal value) {
            addCriterion("Low <>", value, "low");
            return (Criteria) this;
        }

        public Criteria andLowGreaterThan(BigDecimal value) {
            addCriterion("Low >", value, "low");
            return (Criteria) this;
        }

        public Criteria andLowGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("Low >=", value, "low");
            return (Criteria) this;
        }

        public Criteria andLowLessThan(BigDecimal value) {
            addCriterion("Low <", value, "low");
            return (Criteria) this;
        }

        public Criteria andLowLessThanOrEqualTo(BigDecimal value) {
            addCriterion("Low <=", value, "low");
            return (Criteria) this;
        }

        public Criteria andLowIn(List<BigDecimal> values) {
            addCriterion("Low in", values, "low");
            return (Criteria) this;
        }

        public Criteria andLowNotIn(List<BigDecimal> values) {
            addCriterion("Low not in", values, "low");
            return (Criteria) this;
        }

        public Criteria andLowBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Low between", value1, value2, "low");
            return (Criteria) this;
        }

        public Criteria andLowNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Low not between", value1, value2, "low");
            return (Criteria) this;
        }

        public Criteria andSettlepriceIsNull() {
            addCriterion("SettlePrice is null");
            return (Criteria) this;
        }

        public Criteria andSettlepriceIsNotNull() {
            addCriterion("SettlePrice is not null");
            return (Criteria) this;
        }

        public Criteria andSettlepriceEqualTo(BigDecimal value) {
            addCriterion("SettlePrice =", value, "settleprice");
            return (Criteria) this;
        }

        public Criteria andSettlepriceNotEqualTo(BigDecimal value) {
            addCriterion("SettlePrice <>", value, "settleprice");
            return (Criteria) this;
        }

        public Criteria andSettlepriceGreaterThan(BigDecimal value) {
            addCriterion("SettlePrice >", value, "settleprice");
            return (Criteria) this;
        }

        public Criteria andSettlepriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SettlePrice >=", value, "settleprice");
            return (Criteria) this;
        }

        public Criteria andSettlepriceLessThan(BigDecimal value) {
            addCriterion("SettlePrice <", value, "settleprice");
            return (Criteria) this;
        }

        public Criteria andSettlepriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SettlePrice <=", value, "settleprice");
            return (Criteria) this;
        }

        public Criteria andSettlepriceIn(List<BigDecimal> values) {
            addCriterion("SettlePrice in", values, "settleprice");
            return (Criteria) this;
        }

        public Criteria andSettlepriceNotIn(List<BigDecimal> values) {
            addCriterion("SettlePrice not in", values, "settleprice");
            return (Criteria) this;
        }

        public Criteria andSettlepriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SettlePrice between", value1, value2, "settleprice");
            return (Criteria) this;
        }

        public Criteria andSettlepriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SettlePrice not between", value1, value2, "settleprice");
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