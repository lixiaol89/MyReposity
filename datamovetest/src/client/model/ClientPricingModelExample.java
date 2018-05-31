package com.huatai.cube.rms.modules.client.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ClientPricingModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ClientPricingModelExample() {
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
            addCriterion("ClientId is null");
            return (Criteria) this;
        }

        public Criteria andClientidIsNotNull() {
            addCriterion("ClientId is not null");
            return (Criteria) this;
        }

        public Criteria andClientidEqualTo(String value) {
            addCriterion("ClientId =", value, "clientid");
            return (Criteria) this;
        }

        public Criteria andClientidNotEqualTo(String value) {
            addCriterion("ClientId <>", value, "clientid");
            return (Criteria) this;
        }

        public Criteria andClientidGreaterThan(String value) {
            addCriterion("ClientId >", value, "clientid");
            return (Criteria) this;
        }

        public Criteria andClientidGreaterThanOrEqualTo(String value) {
            addCriterion("ClientId >=", value, "clientid");
            return (Criteria) this;
        }

        public Criteria andClientidLessThan(String value) {
            addCriterion("ClientId <", value, "clientid");
            return (Criteria) this;
        }

        public Criteria andClientidLessThanOrEqualTo(String value) {
            addCriterion("ClientId <=", value, "clientid");
            return (Criteria) this;
        }

        public Criteria andClientidLike(String value) {
            addCriterion("ClientId like", value, "clientid");
            return (Criteria) this;
        }

        public Criteria andClientidNotLike(String value) {
            addCriterion("ClientId not like", value, "clientid");
            return (Criteria) this;
        }

        public Criteria andClientidIn(List<String> values) {
            addCriterion("ClientId in", values, "clientid");
            return (Criteria) this;
        }

        public Criteria andClientidNotIn(List<String> values) {
            addCriterion("ClientId not in", values, "clientid");
            return (Criteria) this;
        }

        public Criteria andClientidBetween(String value1, String value2) {
            addCriterion("ClientId between", value1, value2, "clientid");
            return (Criteria) this;
        }

        public Criteria andClientidNotBetween(String value1, String value2) {
            addCriterion("ClientId not between", value1, value2, "clientid");
            return (Criteria) this;
        }

        public Criteria andTemplatetypeIsNull() {
            addCriterion("TemplateType is null");
            return (Criteria) this;
        }

        public Criteria andTemplatetypeIsNotNull() {
            addCriterion("TemplateType is not null");
            return (Criteria) this;
        }

        public Criteria andTemplatetypeEqualTo(String value) {
            addCriterion("TemplateType =", value, "templatetype");
            return (Criteria) this;
        }

        public Criteria andTemplatetypeNotEqualTo(String value) {
            addCriterion("TemplateType <>", value, "templatetype");
            return (Criteria) this;
        }

        public Criteria andTemplatetypeGreaterThan(String value) {
            addCriterion("TemplateType >", value, "templatetype");
            return (Criteria) this;
        }

        public Criteria andTemplatetypeGreaterThanOrEqualTo(String value) {
            addCriterion("TemplateType >=", value, "templatetype");
            return (Criteria) this;
        }

        public Criteria andTemplatetypeLessThan(String value) {
            addCriterion("TemplateType <", value, "templatetype");
            return (Criteria) this;
        }

        public Criteria andTemplatetypeLessThanOrEqualTo(String value) {
            addCriterion("TemplateType <=", value, "templatetype");
            return (Criteria) this;
        }

        public Criteria andTemplatetypeLike(String value) {
            addCriterion("TemplateType like", value, "templatetype");
            return (Criteria) this;
        }

        public Criteria andTemplatetypeNotLike(String value) {
            addCriterion("TemplateType not like", value, "templatetype");
            return (Criteria) this;
        }

        public Criteria andTemplatetypeIn(List<String> values) {
            addCriterion("TemplateType in", values, "templatetype");
            return (Criteria) this;
        }

        public Criteria andTemplatetypeNotIn(List<String> values) {
            addCriterion("TemplateType not in", values, "templatetype");
            return (Criteria) this;
        }

        public Criteria andTemplatetypeBetween(String value1, String value2) {
            addCriterion("TemplateType between", value1, value2, "templatetype");
            return (Criteria) this;
        }

        public Criteria andTemplatetypeNotBetween(String value1, String value2) {
            addCriterion("TemplateType not between", value1, value2, "templatetype");
            return (Criteria) this;
        }

        public Criteria andLongshortIsNull() {
            addCriterion("LongShort is null");
            return (Criteria) this;
        }

        public Criteria andLongshortIsNotNull() {
            addCriterion("LongShort is not null");
            return (Criteria) this;
        }

        public Criteria andLongshortEqualTo(Integer value) {
            addCriterion("LongShort =", value, "longshort");
            return (Criteria) this;
        }

        public Criteria andLongshortNotEqualTo(Integer value) {
            addCriterion("LongShort <>", value, "longshort");
            return (Criteria) this;
        }

        public Criteria andLongshortGreaterThan(Integer value) {
            addCriterion("LongShort >", value, "longshort");
            return (Criteria) this;
        }

        public Criteria andLongshortGreaterThanOrEqualTo(Integer value) {
            addCriterion("LongShort >=", value, "longshort");
            return (Criteria) this;
        }

        public Criteria andLongshortLessThan(Integer value) {
            addCriterion("LongShort <", value, "longshort");
            return (Criteria) this;
        }

        public Criteria andLongshortLessThanOrEqualTo(Integer value) {
            addCriterion("LongShort <=", value, "longshort");
            return (Criteria) this;
        }

        public Criteria andLongshortIn(List<Integer> values) {
            addCriterion("LongShort in", values, "longshort");
            return (Criteria) this;
        }

        public Criteria andLongshortNotIn(List<Integer> values) {
            addCriterion("LongShort not in", values, "longshort");
            return (Criteria) this;
        }

        public Criteria andLongshortBetween(Integer value1, Integer value2) {
            addCriterion("LongShort between", value1, value2, "longshort");
            return (Criteria) this;
        }

        public Criteria andLongshortNotBetween(Integer value1, Integer value2) {
            addCriterion("LongShort not between", value1, value2, "longshort");
            return (Criteria) this;
        }

        public Criteria andQuotaIsNull() {
            addCriterion("Quota is null");
            return (Criteria) this;
        }

        public Criteria andQuotaIsNotNull() {
            addCriterion("Quota is not null");
            return (Criteria) this;
        }

        public Criteria andQuotaEqualTo(BigDecimal value) {
            addCriterion("Quota =", value, "quota");
            return (Criteria) this;
        }

        public Criteria andQuotaNotEqualTo(BigDecimal value) {
            addCriterion("Quota <>", value, "quota");
            return (Criteria) this;
        }

        public Criteria andQuotaGreaterThan(BigDecimal value) {
            addCriterion("Quota >", value, "quota");
            return (Criteria) this;
        }

        public Criteria andQuotaGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("Quota >=", value, "quota");
            return (Criteria) this;
        }

        public Criteria andQuotaLessThan(BigDecimal value) {
            addCriterion("Quota <", value, "quota");
            return (Criteria) this;
        }

        public Criteria andQuotaLessThanOrEqualTo(BigDecimal value) {
            addCriterion("Quota <=", value, "quota");
            return (Criteria) this;
        }

        public Criteria andQuotaIn(List<BigDecimal> values) {
            addCriterion("Quota in", values, "quota");
            return (Criteria) this;
        }

        public Criteria andQuotaNotIn(List<BigDecimal> values) {
            addCriterion("Quota not in", values, "quota");
            return (Criteria) this;
        }

        public Criteria andQuotaBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Quota between", value1, value2, "quota");
            return (Criteria) this;
        }

        public Criteria andQuotaNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Quota not between", value1, value2, "quota");
            return (Criteria) this;
        }

        public Criteria andSettleccyIsNull() {
            addCriterion("SettleCcy is null");
            return (Criteria) this;
        }

        public Criteria andSettleccyIsNotNull() {
            addCriterion("SettleCcy is not null");
            return (Criteria) this;
        }

        public Criteria andSettleccyEqualTo(String value) {
            addCriterion("SettleCcy =", value, "settleccy");
            return (Criteria) this;
        }

        public Criteria andSettleccyNotEqualTo(String value) {
            addCriterion("SettleCcy <>", value, "settleccy");
            return (Criteria) this;
        }

        public Criteria andSettleccyGreaterThan(String value) {
            addCriterion("SettleCcy >", value, "settleccy");
            return (Criteria) this;
        }

        public Criteria andSettleccyGreaterThanOrEqualTo(String value) {
            addCriterion("SettleCcy >=", value, "settleccy");
            return (Criteria) this;
        }

        public Criteria andSettleccyLessThan(String value) {
            addCriterion("SettleCcy <", value, "settleccy");
            return (Criteria) this;
        }

        public Criteria andSettleccyLessThanOrEqualTo(String value) {
            addCriterion("SettleCcy <=", value, "settleccy");
            return (Criteria) this;
        }

        public Criteria andSettleccyLike(String value) {
            addCriterion("SettleCcy like", value, "settleccy");
            return (Criteria) this;
        }

        public Criteria andSettleccyNotLike(String value) {
            addCriterion("SettleCcy not like", value, "settleccy");
            return (Criteria) this;
        }

        public Criteria andSettleccyIn(List<String> values) {
            addCriterion("SettleCcy in", values, "settleccy");
            return (Criteria) this;
        }

        public Criteria andSettleccyNotIn(List<String> values) {
            addCriterion("SettleCcy not in", values, "settleccy");
            return (Criteria) this;
        }

        public Criteria andSettleccyBetween(String value1, String value2) {
            addCriterion("SettleCcy between", value1, value2, "settleccy");
            return (Criteria) this;
        }

        public Criteria andSettleccyNotBetween(String value1, String value2) {
            addCriterion("SettleCcy not between", value1, value2, "settleccy");
            return (Criteria) this;
        }

        public Criteria andSalesidIsNull() {
            addCriterion("SalesId is null");
            return (Criteria) this;
        }

        public Criteria andSalesidIsNotNull() {
            addCriterion("SalesId is not null");
            return (Criteria) this;
        }

        public Criteria andSalesidEqualTo(String value) {
            addCriterion("SalesId =", value, "salesid");
            return (Criteria) this;
        }

        public Criteria andSalesidNotEqualTo(String value) {
            addCriterion("SalesId <>", value, "salesid");
            return (Criteria) this;
        }

        public Criteria andSalesidGreaterThan(String value) {
            addCriterion("SalesId >", value, "salesid");
            return (Criteria) this;
        }

        public Criteria andSalesidGreaterThanOrEqualTo(String value) {
            addCriterion("SalesId >=", value, "salesid");
            return (Criteria) this;
        }

        public Criteria andSalesidLessThan(String value) {
            addCriterion("SalesId <", value, "salesid");
            return (Criteria) this;
        }

        public Criteria andSalesidLessThanOrEqualTo(String value) {
            addCriterion("SalesId <=", value, "salesid");
            return (Criteria) this;
        }

        public Criteria andSalesidLike(String value) {
            addCriterion("SalesId like", value, "salesid");
            return (Criteria) this;
        }

        public Criteria andSalesidNotLike(String value) {
            addCriterion("SalesId not like", value, "salesid");
            return (Criteria) this;
        }

        public Criteria andSalesidIn(List<String> values) {
            addCriterion("SalesId in", values, "salesid");
            return (Criteria) this;
        }

        public Criteria andSalesidNotIn(List<String> values) {
            addCriterion("SalesId not in", values, "salesid");
            return (Criteria) this;
        }

        public Criteria andSalesidBetween(String value1, String value2) {
            addCriterion("SalesId between", value1, value2, "salesid");
            return (Criteria) this;
        }

        public Criteria andSalesidNotBetween(String value1, String value2) {
            addCriterion("SalesId not between", value1, value2, "salesid");
            return (Criteria) this;
        }

        public Criteria andEdgeIsNull() {
            addCriterion("Edge is null");
            return (Criteria) this;
        }

        public Criteria andEdgeIsNotNull() {
            addCriterion("Edge is not null");
            return (Criteria) this;
        }

        public Criteria andEdgeEqualTo(BigDecimal value) {
            addCriterion("Edge =", value, "edge");
            return (Criteria) this;
        }

        public Criteria andEdgeNotEqualTo(BigDecimal value) {
            addCriterion("Edge <>", value, "edge");
            return (Criteria) this;
        }

        public Criteria andEdgeGreaterThan(BigDecimal value) {
            addCriterion("Edge >", value, "edge");
            return (Criteria) this;
        }

        public Criteria andEdgeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("Edge >=", value, "edge");
            return (Criteria) this;
        }

        public Criteria andEdgeLessThan(BigDecimal value) {
            addCriterion("Edge <", value, "edge");
            return (Criteria) this;
        }

        public Criteria andEdgeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("Edge <=", value, "edge");
            return (Criteria) this;
        }

        public Criteria andEdgeIn(List<BigDecimal> values) {
            addCriterion("Edge in", values, "edge");
            return (Criteria) this;
        }

        public Criteria andEdgeNotIn(List<BigDecimal> values) {
            addCriterion("Edge not in", values, "edge");
            return (Criteria) this;
        }

        public Criteria andEdgeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Edge between", value1, value2, "edge");
            return (Criteria) this;
        }

        public Criteria andEdgeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Edge not between", value1, value2, "edge");
            return (Criteria) this;
        }

        public Criteria andInitalmarginIsNull() {
            addCriterion("InitalMargin is null");
            return (Criteria) this;
        }

        public Criteria andInitalmarginIsNotNull() {
            addCriterion("InitalMargin is not null");
            return (Criteria) this;
        }

        public Criteria andInitalmarginEqualTo(BigDecimal value) {
            addCriterion("InitalMargin =", value, "initalmargin");
            return (Criteria) this;
        }

        public Criteria andInitalmarginNotEqualTo(BigDecimal value) {
            addCriterion("InitalMargin <>", value, "initalmargin");
            return (Criteria) this;
        }

        public Criteria andInitalmarginGreaterThan(BigDecimal value) {
            addCriterion("InitalMargin >", value, "initalmargin");
            return (Criteria) this;
        }

        public Criteria andInitalmarginGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("InitalMargin >=", value, "initalmargin");
            return (Criteria) this;
        }

        public Criteria andInitalmarginLessThan(BigDecimal value) {
            addCriterion("InitalMargin <", value, "initalmargin");
            return (Criteria) this;
        }

        public Criteria andInitalmarginLessThanOrEqualTo(BigDecimal value) {
            addCriterion("InitalMargin <=", value, "initalmargin");
            return (Criteria) this;
        }

        public Criteria andInitalmarginIn(List<BigDecimal> values) {
            addCriterion("InitalMargin in", values, "initalmargin");
            return (Criteria) this;
        }

        public Criteria andInitalmarginNotIn(List<BigDecimal> values) {
            addCriterion("InitalMargin not in", values, "initalmargin");
            return (Criteria) this;
        }

        public Criteria andInitalmarginBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("InitalMargin between", value1, value2, "initalmargin");
            return (Criteria) this;
        }

        public Criteria andInitalmarginNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("InitalMargin not between", value1, value2, "initalmargin");
            return (Criteria) this;
        }

        public Criteria andMarginwarninglevelIsNull() {
            addCriterion("MarginWarningLevel is null");
            return (Criteria) this;
        }

        public Criteria andMarginwarninglevelIsNotNull() {
            addCriterion("MarginWarningLevel is not null");
            return (Criteria) this;
        }

        public Criteria andMarginwarninglevelEqualTo(BigDecimal value) {
            addCriterion("MarginWarningLevel =", value, "marginwarninglevel");
            return (Criteria) this;
        }

        public Criteria andMarginwarninglevelNotEqualTo(BigDecimal value) {
            addCriterion("MarginWarningLevel <>", value, "marginwarninglevel");
            return (Criteria) this;
        }

        public Criteria andMarginwarninglevelGreaterThan(BigDecimal value) {
            addCriterion("MarginWarningLevel >", value, "marginwarninglevel");
            return (Criteria) this;
        }

        public Criteria andMarginwarninglevelGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MarginWarningLevel >=", value, "marginwarninglevel");
            return (Criteria) this;
        }

        public Criteria andMarginwarninglevelLessThan(BigDecimal value) {
            addCriterion("MarginWarningLevel <", value, "marginwarninglevel");
            return (Criteria) this;
        }

        public Criteria andMarginwarninglevelLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MarginWarningLevel <=", value, "marginwarninglevel");
            return (Criteria) this;
        }

        public Criteria andMarginwarninglevelIn(List<BigDecimal> values) {
            addCriterion("MarginWarningLevel in", values, "marginwarninglevel");
            return (Criteria) this;
        }

        public Criteria andMarginwarninglevelNotIn(List<BigDecimal> values) {
            addCriterion("MarginWarningLevel not in", values, "marginwarninglevel");
            return (Criteria) this;
        }

        public Criteria andMarginwarninglevelBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MarginWarningLevel between", value1, value2, "marginwarninglevel");
            return (Criteria) this;
        }

        public Criteria andMarginwarninglevelNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MarginWarningLevel not between", value1, value2, "marginwarninglevel");
            return (Criteria) this;
        }

        public Criteria andMargincalllevelIsNull() {
            addCriterion("MarginCallLevel is null");
            return (Criteria) this;
        }

        public Criteria andMargincalllevelIsNotNull() {
            addCriterion("MarginCallLevel is not null");
            return (Criteria) this;
        }

        public Criteria andMargincalllevelEqualTo(BigDecimal value) {
            addCriterion("MarginCallLevel =", value, "margincalllevel");
            return (Criteria) this;
        }

        public Criteria andMargincalllevelNotEqualTo(BigDecimal value) {
            addCriterion("MarginCallLevel <>", value, "margincalllevel");
            return (Criteria) this;
        }

        public Criteria andMargincalllevelGreaterThan(BigDecimal value) {
            addCriterion("MarginCallLevel >", value, "margincalllevel");
            return (Criteria) this;
        }

        public Criteria andMargincalllevelGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MarginCallLevel >=", value, "margincalllevel");
            return (Criteria) this;
        }

        public Criteria andMargincalllevelLessThan(BigDecimal value) {
            addCriterion("MarginCallLevel <", value, "margincalllevel");
            return (Criteria) this;
        }

        public Criteria andMargincalllevelLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MarginCallLevel <=", value, "margincalllevel");
            return (Criteria) this;
        }

        public Criteria andMargincalllevelIn(List<BigDecimal> values) {
            addCriterion("MarginCallLevel in", values, "margincalllevel");
            return (Criteria) this;
        }

        public Criteria andMargincalllevelNotIn(List<BigDecimal> values) {
            addCriterion("MarginCallLevel not in", values, "margincalllevel");
            return (Criteria) this;
        }

        public Criteria andMargincalllevelBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MarginCallLevel between", value1, value2, "margincalllevel");
            return (Criteria) this;
        }

        public Criteria andMargincalllevelNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MarginCallLevel not between", value1, value2, "margincalllevel");
            return (Criteria) this;
        }

        public Criteria andLiquiditionlevelIsNull() {
            addCriterion("LiquiditionLevel is null");
            return (Criteria) this;
        }

        public Criteria andLiquiditionlevelIsNotNull() {
            addCriterion("LiquiditionLevel is not null");
            return (Criteria) this;
        }

        public Criteria andLiquiditionlevelEqualTo(BigDecimal value) {
            addCriterion("LiquiditionLevel =", value, "liquiditionlevel");
            return (Criteria) this;
        }

        public Criteria andLiquiditionlevelNotEqualTo(BigDecimal value) {
            addCriterion("LiquiditionLevel <>", value, "liquiditionlevel");
            return (Criteria) this;
        }

        public Criteria andLiquiditionlevelGreaterThan(BigDecimal value) {
            addCriterion("LiquiditionLevel >", value, "liquiditionlevel");
            return (Criteria) this;
        }

        public Criteria andLiquiditionlevelGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LiquiditionLevel >=", value, "liquiditionlevel");
            return (Criteria) this;
        }

        public Criteria andLiquiditionlevelLessThan(BigDecimal value) {
            addCriterion("LiquiditionLevel <", value, "liquiditionlevel");
            return (Criteria) this;
        }

        public Criteria andLiquiditionlevelLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LiquiditionLevel <=", value, "liquiditionlevel");
            return (Criteria) this;
        }

        public Criteria andLiquiditionlevelIn(List<BigDecimal> values) {
            addCriterion("LiquiditionLevel in", values, "liquiditionlevel");
            return (Criteria) this;
        }

        public Criteria andLiquiditionlevelNotIn(List<BigDecimal> values) {
            addCriterion("LiquiditionLevel not in", values, "liquiditionlevel");
            return (Criteria) this;
        }

        public Criteria andLiquiditionlevelBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LiquiditionLevel between", value1, value2, "liquiditionlevel");
            return (Criteria) this;
        }

        public Criteria andLiquiditionlevelNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LiquiditionLevel not between", value1, value2, "liquiditionlevel");
            return (Criteria) this;
        }

        public Criteria andMarginnetIsNull() {
            addCriterion("MarginNet is null");
            return (Criteria) this;
        }

        public Criteria andMarginnetIsNotNull() {
            addCriterion("MarginNet is not null");
            return (Criteria) this;
        }

        public Criteria andMarginnetEqualTo(Integer value) {
            addCriterion("MarginNet =", value, "marginnet");
            return (Criteria) this;
        }

        public Criteria andMarginnetNotEqualTo(Integer value) {
            addCriterion("MarginNet <>", value, "marginnet");
            return (Criteria) this;
        }

        public Criteria andMarginnetGreaterThan(Integer value) {
            addCriterion("MarginNet >", value, "marginnet");
            return (Criteria) this;
        }

        public Criteria andMarginnetGreaterThanOrEqualTo(Integer value) {
            addCriterion("MarginNet >=", value, "marginnet");
            return (Criteria) this;
        }

        public Criteria andMarginnetLessThan(Integer value) {
            addCriterion("MarginNet <", value, "marginnet");
            return (Criteria) this;
        }

        public Criteria andMarginnetLessThanOrEqualTo(Integer value) {
            addCriterion("MarginNet <=", value, "marginnet");
            return (Criteria) this;
        }

        public Criteria andMarginnetIn(List<Integer> values) {
            addCriterion("MarginNet in", values, "marginnet");
            return (Criteria) this;
        }

        public Criteria andMarginnetNotIn(List<Integer> values) {
            addCriterion("MarginNet not in", values, "marginnet");
            return (Criteria) this;
        }

        public Criteria andMarginnetBetween(Integer value1, Integer value2) {
            addCriterion("MarginNet between", value1, value2, "marginnet");
            return (Criteria) this;
        }

        public Criteria andMarginnetNotBetween(Integer value1, Integer value2) {
            addCriterion("MarginNet not between", value1, value2, "marginnet");
            return (Criteria) this;
        }

        public Criteria andLeverageIsNull() {
            addCriterion("Leverage is null");
            return (Criteria) this;
        }

        public Criteria andLeverageIsNotNull() {
            addCriterion("Leverage is not null");
            return (Criteria) this;
        }

        public Criteria andLeverageEqualTo(BigDecimal value) {
            addCriterion("Leverage =", value, "leverage");
            return (Criteria) this;
        }

        public Criteria andLeverageNotEqualTo(BigDecimal value) {
            addCriterion("Leverage <>", value, "leverage");
            return (Criteria) this;
        }

        public Criteria andLeverageGreaterThan(BigDecimal value) {
            addCriterion("Leverage >", value, "leverage");
            return (Criteria) this;
        }

        public Criteria andLeverageGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("Leverage >=", value, "leverage");
            return (Criteria) this;
        }

        public Criteria andLeverageLessThan(BigDecimal value) {
            addCriterion("Leverage <", value, "leverage");
            return (Criteria) this;
        }

        public Criteria andLeverageLessThanOrEqualTo(BigDecimal value) {
            addCriterion("Leverage <=", value, "leverage");
            return (Criteria) this;
        }

        public Criteria andLeverageIn(List<BigDecimal> values) {
            addCriterion("Leverage in", values, "leverage");
            return (Criteria) this;
        }

        public Criteria andLeverageNotIn(List<BigDecimal> values) {
            addCriterion("Leverage not in", values, "leverage");
            return (Criteria) this;
        }

        public Criteria andLeverageBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Leverage between", value1, value2, "leverage");
            return (Criteria) this;
        }

        public Criteria andLeverageNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Leverage not between", value1, value2, "leverage");
            return (Criteria) this;
        }

        public Criteria andFundingrateIsNull() {
            addCriterion("FundingRate is null");
            return (Criteria) this;
        }

        public Criteria andFundingrateIsNotNull() {
            addCriterion("FundingRate is not null");
            return (Criteria) this;
        }

        public Criteria andFundingrateEqualTo(BigDecimal value) {
            addCriterion("FundingRate =", value, "fundingrate");
            return (Criteria) this;
        }

        public Criteria andFundingrateNotEqualTo(BigDecimal value) {
            addCriterion("FundingRate <>", value, "fundingrate");
            return (Criteria) this;
        }

        public Criteria andFundingrateGreaterThan(BigDecimal value) {
            addCriterion("FundingRate >", value, "fundingrate");
            return (Criteria) this;
        }

        public Criteria andFundingrateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FundingRate >=", value, "fundingrate");
            return (Criteria) this;
        }

        public Criteria andFundingrateLessThan(BigDecimal value) {
            addCriterion("FundingRate <", value, "fundingrate");
            return (Criteria) this;
        }

        public Criteria andFundingrateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FundingRate <=", value, "fundingrate");
            return (Criteria) this;
        }

        public Criteria andFundingrateIn(List<BigDecimal> values) {
            addCriterion("FundingRate in", values, "fundingrate");
            return (Criteria) this;
        }

        public Criteria andFundingrateNotIn(List<BigDecimal> values) {
            addCriterion("FundingRate not in", values, "fundingrate");
            return (Criteria) this;
        }

        public Criteria andFundingrateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FundingRate between", value1, value2, "fundingrate");
            return (Criteria) this;
        }

        public Criteria andFundingrateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FundingRate not between", value1, value2, "fundingrate");
            return (Criteria) this;
        }

        public Criteria andFundingccyIsNull() {
            addCriterion("FundingCcy is null");
            return (Criteria) this;
        }

        public Criteria andFundingccyIsNotNull() {
            addCriterion("FundingCcy is not null");
            return (Criteria) this;
        }

        public Criteria andFundingccyEqualTo(String value) {
            addCriterion("FundingCcy =", value, "fundingccy");
            return (Criteria) this;
        }

        public Criteria andFundingccyNotEqualTo(String value) {
            addCriterion("FundingCcy <>", value, "fundingccy");
            return (Criteria) this;
        }

        public Criteria andFundingccyGreaterThan(String value) {
            addCriterion("FundingCcy >", value, "fundingccy");
            return (Criteria) this;
        }

        public Criteria andFundingccyGreaterThanOrEqualTo(String value) {
            addCriterion("FundingCcy >=", value, "fundingccy");
            return (Criteria) this;
        }

        public Criteria andFundingccyLessThan(String value) {
            addCriterion("FundingCcy <", value, "fundingccy");
            return (Criteria) this;
        }

        public Criteria andFundingccyLessThanOrEqualTo(String value) {
            addCriterion("FundingCcy <=", value, "fundingccy");
            return (Criteria) this;
        }

        public Criteria andFundingccyLike(String value) {
            addCriterion("FundingCcy like", value, "fundingccy");
            return (Criteria) this;
        }

        public Criteria andFundingccyNotLike(String value) {
            addCriterion("FundingCcy not like", value, "fundingccy");
            return (Criteria) this;
        }

        public Criteria andFundingccyIn(List<String> values) {
            addCriterion("FundingCcy in", values, "fundingccy");
            return (Criteria) this;
        }

        public Criteria andFundingccyNotIn(List<String> values) {
            addCriterion("FundingCcy not in", values, "fundingccy");
            return (Criteria) this;
        }

        public Criteria andFundingccyBetween(String value1, String value2) {
            addCriterion("FundingCcy between", value1, value2, "fundingccy");
            return (Criteria) this;
        }

        public Criteria andFundingccyNotBetween(String value1, String value2) {
            addCriterion("FundingCcy not between", value1, value2, "fundingccy");
            return (Criteria) this;
        }

        public Criteria andCommissionIsNull() {
            addCriterion("Commission is null");
            return (Criteria) this;
        }

        public Criteria andCommissionIsNotNull() {
            addCriterion("Commission is not null");
            return (Criteria) this;
        }

        public Criteria andCommissionEqualTo(BigDecimal value) {
            addCriterion("Commission =", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionNotEqualTo(BigDecimal value) {
            addCriterion("Commission <>", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionGreaterThan(BigDecimal value) {
            addCriterion("Commission >", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("Commission >=", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionLessThan(BigDecimal value) {
            addCriterion("Commission <", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("Commission <=", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionIn(List<BigDecimal> values) {
            addCriterion("Commission in", values, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionNotIn(List<BigDecimal> values) {
            addCriterion("Commission not in", values, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Commission between", value1, value2, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Commission not between", value1, value2, "commission");
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