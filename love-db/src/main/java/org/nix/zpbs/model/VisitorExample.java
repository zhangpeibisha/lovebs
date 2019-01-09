package org.nix.zpbs.model;

import java.util.ArrayList;
import java.util.List;

public class VisitorExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VisitorExample() {
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

        public Criteria andVIdIsNull() {
            addCriterion("v_id is null");
            return (Criteria) this;
        }

        public Criteria andVIdIsNotNull() {
            addCriterion("v_id is not null");
            return (Criteria) this;
        }

        public Criteria andVIdEqualTo(Long value) {
            addCriterion("v_id =", value, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdNotEqualTo(Long value) {
            addCriterion("v_id <>", value, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdGreaterThan(Long value) {
            addCriterion("v_id >", value, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdGreaterThanOrEqualTo(Long value) {
            addCriterion("v_id >=", value, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdLessThan(Long value) {
            addCriterion("v_id <", value, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdLessThanOrEqualTo(Long value) {
            addCriterion("v_id <=", value, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdIn(List<Long> values) {
            addCriterion("v_id in", values, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdNotIn(List<Long> values) {
            addCriterion("v_id not in", values, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdBetween(Long value1, Long value2) {
            addCriterion("v_id between", value1, value2, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdNotBetween(Long value1, Long value2) {
            addCriterion("v_id not between", value1, value2, "vId");
            return (Criteria) this;
        }

        public Criteria andVisitorIdIsNull() {
            addCriterion("visitor_id is null");
            return (Criteria) this;
        }

        public Criteria andVisitorIdIsNotNull() {
            addCriterion("visitor_id is not null");
            return (Criteria) this;
        }

        public Criteria andVisitorIdEqualTo(Long value) {
            addCriterion("visitor_id =", value, "visitorId");
            return (Criteria) this;
        }

        public Criteria andVisitorIdNotEqualTo(Long value) {
            addCriterion("visitor_id <>", value, "visitorId");
            return (Criteria) this;
        }

        public Criteria andVisitorIdGreaterThan(Long value) {
            addCriterion("visitor_id >", value, "visitorId");
            return (Criteria) this;
        }

        public Criteria andVisitorIdGreaterThanOrEqualTo(Long value) {
            addCriterion("visitor_id >=", value, "visitorId");
            return (Criteria) this;
        }

        public Criteria andVisitorIdLessThan(Long value) {
            addCriterion("visitor_id <", value, "visitorId");
            return (Criteria) this;
        }

        public Criteria andVisitorIdLessThanOrEqualTo(Long value) {
            addCriterion("visitor_id <=", value, "visitorId");
            return (Criteria) this;
        }

        public Criteria andVisitorIdIn(List<Long> values) {
            addCriterion("visitor_id in", values, "visitorId");
            return (Criteria) this;
        }

        public Criteria andVisitorIdNotIn(List<Long> values) {
            addCriterion("visitor_id not in", values, "visitorId");
            return (Criteria) this;
        }

        public Criteria andVisitorIdBetween(Long value1, Long value2) {
            addCriterion("visitor_id between", value1, value2, "visitorId");
            return (Criteria) this;
        }

        public Criteria andVisitorIdNotBetween(Long value1, Long value2) {
            addCriterion("visitor_id not between", value1, value2, "visitorId");
            return (Criteria) this;
        }

        public Criteria andVisitorTimeIsNull() {
            addCriterion("visitor_time is null");
            return (Criteria) this;
        }

        public Criteria andVisitorTimeIsNotNull() {
            addCriterion("visitor_time is not null");
            return (Criteria) this;
        }

        public Criteria andVisitorTimeEqualTo(Long value) {
            addCriterion("visitor_time =", value, "visitorTime");
            return (Criteria) this;
        }

        public Criteria andVisitorTimeNotEqualTo(Long value) {
            addCriterion("visitor_time <>", value, "visitorTime");
            return (Criteria) this;
        }

        public Criteria andVisitorTimeGreaterThan(Long value) {
            addCriterion("visitor_time >", value, "visitorTime");
            return (Criteria) this;
        }

        public Criteria andVisitorTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("visitor_time >=", value, "visitorTime");
            return (Criteria) this;
        }

        public Criteria andVisitorTimeLessThan(Long value) {
            addCriterion("visitor_time <", value, "visitorTime");
            return (Criteria) this;
        }

        public Criteria andVisitorTimeLessThanOrEqualTo(Long value) {
            addCriterion("visitor_time <=", value, "visitorTime");
            return (Criteria) this;
        }

        public Criteria andVisitorTimeIn(List<Long> values) {
            addCriterion("visitor_time in", values, "visitorTime");
            return (Criteria) this;
        }

        public Criteria andVisitorTimeNotIn(List<Long> values) {
            addCriterion("visitor_time not in", values, "visitorTime");
            return (Criteria) this;
        }

        public Criteria andVisitorTimeBetween(Long value1, Long value2) {
            addCriterion("visitor_time between", value1, value2, "visitorTime");
            return (Criteria) this;
        }

        public Criteria andVisitorTimeNotBetween(Long value1, Long value2) {
            addCriterion("visitor_time not between", value1, value2, "visitorTime");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andVisitorIpIsNull() {
            addCriterion("visitor_ip is null");
            return (Criteria) this;
        }

        public Criteria andVisitorIpIsNotNull() {
            addCriterion("visitor_ip is not null");
            return (Criteria) this;
        }

        public Criteria andVisitorIpEqualTo(String value) {
            addCriterion("visitor_ip =", value, "visitorIp");
            return (Criteria) this;
        }

        public Criteria andVisitorIpNotEqualTo(String value) {
            addCriterion("visitor_ip <>", value, "visitorIp");
            return (Criteria) this;
        }

        public Criteria andVisitorIpGreaterThan(String value) {
            addCriterion("visitor_ip >", value, "visitorIp");
            return (Criteria) this;
        }

        public Criteria andVisitorIpGreaterThanOrEqualTo(String value) {
            addCriterion("visitor_ip >=", value, "visitorIp");
            return (Criteria) this;
        }

        public Criteria andVisitorIpLessThan(String value) {
            addCriterion("visitor_ip <", value, "visitorIp");
            return (Criteria) this;
        }

        public Criteria andVisitorIpLessThanOrEqualTo(String value) {
            addCriterion("visitor_ip <=", value, "visitorIp");
            return (Criteria) this;
        }

        public Criteria andVisitorIpLike(String value) {
            addCriterion("visitor_ip like", value, "visitorIp");
            return (Criteria) this;
        }

        public Criteria andVisitorIpNotLike(String value) {
            addCriterion("visitor_ip not like", value, "visitorIp");
            return (Criteria) this;
        }

        public Criteria andVisitorIpIn(List<String> values) {
            addCriterion("visitor_ip in", values, "visitorIp");
            return (Criteria) this;
        }

        public Criteria andVisitorIpNotIn(List<String> values) {
            addCriterion("visitor_ip not in", values, "visitorIp");
            return (Criteria) this;
        }

        public Criteria andVisitorIpBetween(String value1, String value2) {
            addCriterion("visitor_ip between", value1, value2, "visitorIp");
            return (Criteria) this;
        }

        public Criteria andVisitorIpNotBetween(String value1, String value2) {
            addCriterion("visitor_ip not between", value1, value2, "visitorIp");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNull() {
            addCriterion("type_id is null");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNotNull() {
            addCriterion("type_id is not null");
            return (Criteria) this;
        }

        public Criteria andTypeIdEqualTo(Integer value) {
            addCriterion("type_id =", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotEqualTo(Integer value) {
            addCriterion("type_id <>", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThan(Integer value) {
            addCriterion("type_id >", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("type_id >=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThan(Integer value) {
            addCriterion("type_id <", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("type_id <=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIn(List<Integer> values) {
            addCriterion("type_id in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotIn(List<Integer> values) {
            addCriterion("type_id not in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("type_id between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("type_id not between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andWhereIdIsNull() {
            addCriterion("where_id is null");
            return (Criteria) this;
        }

        public Criteria andWhereIdIsNotNull() {
            addCriterion("where_id is not null");
            return (Criteria) this;
        }

        public Criteria andWhereIdEqualTo(Long value) {
            addCriterion("where_id =", value, "whereId");
            return (Criteria) this;
        }

        public Criteria andWhereIdNotEqualTo(Long value) {
            addCriterion("where_id <>", value, "whereId");
            return (Criteria) this;
        }

        public Criteria andWhereIdGreaterThan(Long value) {
            addCriterion("where_id >", value, "whereId");
            return (Criteria) this;
        }

        public Criteria andWhereIdGreaterThanOrEqualTo(Long value) {
            addCriterion("where_id >=", value, "whereId");
            return (Criteria) this;
        }

        public Criteria andWhereIdLessThan(Long value) {
            addCriterion("where_id <", value, "whereId");
            return (Criteria) this;
        }

        public Criteria andWhereIdLessThanOrEqualTo(Long value) {
            addCriterion("where_id <=", value, "whereId");
            return (Criteria) this;
        }

        public Criteria andWhereIdIn(List<Long> values) {
            addCriterion("where_id in", values, "whereId");
            return (Criteria) this;
        }

        public Criteria andWhereIdNotIn(List<Long> values) {
            addCriterion("where_id not in", values, "whereId");
            return (Criteria) this;
        }

        public Criteria andWhereIdBetween(Long value1, Long value2) {
            addCriterion("where_id between", value1, value2, "whereId");
            return (Criteria) this;
        }

        public Criteria andWhereIdNotBetween(Long value1, Long value2) {
            addCriterion("where_id not between", value1, value2, "whereId");
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