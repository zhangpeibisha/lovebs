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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andVisitorIdIsNull() {
            addCriterion("VISITOR_ID is null");
            return (Criteria) this;
        }

        public Criteria andVisitorIdIsNotNull() {
            addCriterion("VISITOR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andVisitorIdEqualTo(Long value) {
            addCriterion("VISITOR_ID =", value, "visitorId");
            return (Criteria) this;
        }

        public Criteria andVisitorIdNotEqualTo(Long value) {
            addCriterion("VISITOR_ID <>", value, "visitorId");
            return (Criteria) this;
        }

        public Criteria andVisitorIdGreaterThan(Long value) {
            addCriterion("VISITOR_ID >", value, "visitorId");
            return (Criteria) this;
        }

        public Criteria andVisitorIdGreaterThanOrEqualTo(Long value) {
            addCriterion("VISITOR_ID >=", value, "visitorId");
            return (Criteria) this;
        }

        public Criteria andVisitorIdLessThan(Long value) {
            addCriterion("VISITOR_ID <", value, "visitorId");
            return (Criteria) this;
        }

        public Criteria andVisitorIdLessThanOrEqualTo(Long value) {
            addCriterion("VISITOR_ID <=", value, "visitorId");
            return (Criteria) this;
        }

        public Criteria andVisitorIdIn(List<Long> values) {
            addCriterion("VISITOR_ID in", values, "visitorId");
            return (Criteria) this;
        }

        public Criteria andVisitorIdNotIn(List<Long> values) {
            addCriterion("VISITOR_ID not in", values, "visitorId");
            return (Criteria) this;
        }

        public Criteria andVisitorIdBetween(Long value1, Long value2) {
            addCriterion("VISITOR_ID between", value1, value2, "visitorId");
            return (Criteria) this;
        }

        public Criteria andVisitorIdNotBetween(Long value1, Long value2) {
            addCriterion("VISITOR_ID not between", value1, value2, "visitorId");
            return (Criteria) this;
        }

        public Criteria andVisitorTimeIsNull() {
            addCriterion("VISITOR_TIME is null");
            return (Criteria) this;
        }

        public Criteria andVisitorTimeIsNotNull() {
            addCriterion("VISITOR_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andVisitorTimeEqualTo(Long value) {
            addCriterion("VISITOR_TIME =", value, "visitorTime");
            return (Criteria) this;
        }

        public Criteria andVisitorTimeNotEqualTo(Long value) {
            addCriterion("VISITOR_TIME <>", value, "visitorTime");
            return (Criteria) this;
        }

        public Criteria andVisitorTimeGreaterThan(Long value) {
            addCriterion("VISITOR_TIME >", value, "visitorTime");
            return (Criteria) this;
        }

        public Criteria andVisitorTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("VISITOR_TIME >=", value, "visitorTime");
            return (Criteria) this;
        }

        public Criteria andVisitorTimeLessThan(Long value) {
            addCriterion("VISITOR_TIME <", value, "visitorTime");
            return (Criteria) this;
        }

        public Criteria andVisitorTimeLessThanOrEqualTo(Long value) {
            addCriterion("VISITOR_TIME <=", value, "visitorTime");
            return (Criteria) this;
        }

        public Criteria andVisitorTimeIn(List<Long> values) {
            addCriterion("VISITOR_TIME in", values, "visitorTime");
            return (Criteria) this;
        }

        public Criteria andVisitorTimeNotIn(List<Long> values) {
            addCriterion("VISITOR_TIME not in", values, "visitorTime");
            return (Criteria) this;
        }

        public Criteria andVisitorTimeBetween(Long value1, Long value2) {
            addCriterion("VISITOR_TIME between", value1, value2, "visitorTime");
            return (Criteria) this;
        }

        public Criteria andVisitorTimeNotBetween(Long value1, Long value2) {
            addCriterion("VISITOR_TIME not between", value1, value2, "visitorTime");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("USER_ID <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("USER_ID >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("USER_ID >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("USER_ID <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("USER_ID <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("USER_ID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("USER_ID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("USER_ID between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("USER_ID not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andVisitorIpIsNull() {
            addCriterion("VISITOR_IP is null");
            return (Criteria) this;
        }

        public Criteria andVisitorIpIsNotNull() {
            addCriterion("VISITOR_IP is not null");
            return (Criteria) this;
        }

        public Criteria andVisitorIpEqualTo(String value) {
            addCriterion("VISITOR_IP =", value, "visitorIp");
            return (Criteria) this;
        }

        public Criteria andVisitorIpNotEqualTo(String value) {
            addCriterion("VISITOR_IP <>", value, "visitorIp");
            return (Criteria) this;
        }

        public Criteria andVisitorIpGreaterThan(String value) {
            addCriterion("VISITOR_IP >", value, "visitorIp");
            return (Criteria) this;
        }

        public Criteria andVisitorIpGreaterThanOrEqualTo(String value) {
            addCriterion("VISITOR_IP >=", value, "visitorIp");
            return (Criteria) this;
        }

        public Criteria andVisitorIpLessThan(String value) {
            addCriterion("VISITOR_IP <", value, "visitorIp");
            return (Criteria) this;
        }

        public Criteria andVisitorIpLessThanOrEqualTo(String value) {
            addCriterion("VISITOR_IP <=", value, "visitorIp");
            return (Criteria) this;
        }

        public Criteria andVisitorIpLike(String value) {
            addCriterion("VISITOR_IP like", value, "visitorIp");
            return (Criteria) this;
        }

        public Criteria andVisitorIpNotLike(String value) {
            addCriterion("VISITOR_IP not like", value, "visitorIp");
            return (Criteria) this;
        }

        public Criteria andVisitorIpIn(List<String> values) {
            addCriterion("VISITOR_IP in", values, "visitorIp");
            return (Criteria) this;
        }

        public Criteria andVisitorIpNotIn(List<String> values) {
            addCriterion("VISITOR_IP not in", values, "visitorIp");
            return (Criteria) this;
        }

        public Criteria andVisitorIpBetween(String value1, String value2) {
            addCriterion("VISITOR_IP between", value1, value2, "visitorIp");
            return (Criteria) this;
        }

        public Criteria andVisitorIpNotBetween(String value1, String value2) {
            addCriterion("VISITOR_IP not between", value1, value2, "visitorIp");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNull() {
            addCriterion("TYPE_ID is null");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNotNull() {
            addCriterion("TYPE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTypeIdEqualTo(Integer value) {
            addCriterion("TYPE_ID =", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotEqualTo(Integer value) {
            addCriterion("TYPE_ID <>", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThan(Integer value) {
            addCriterion("TYPE_ID >", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("TYPE_ID >=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThan(Integer value) {
            addCriterion("TYPE_ID <", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("TYPE_ID <=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIn(List<Integer> values) {
            addCriterion("TYPE_ID in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotIn(List<Integer> values) {
            addCriterion("TYPE_ID not in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("TYPE_ID between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("TYPE_ID not between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andWhereIdIsNull() {
            addCriterion("WHERE_ID is null");
            return (Criteria) this;
        }

        public Criteria andWhereIdIsNotNull() {
            addCriterion("WHERE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andWhereIdEqualTo(Long value) {
            addCriterion("WHERE_ID =", value, "whereId");
            return (Criteria) this;
        }

        public Criteria andWhereIdNotEqualTo(Long value) {
            addCriterion("WHERE_ID <>", value, "whereId");
            return (Criteria) this;
        }

        public Criteria andWhereIdGreaterThan(Long value) {
            addCriterion("WHERE_ID >", value, "whereId");
            return (Criteria) this;
        }

        public Criteria andWhereIdGreaterThanOrEqualTo(Long value) {
            addCriterion("WHERE_ID >=", value, "whereId");
            return (Criteria) this;
        }

        public Criteria andWhereIdLessThan(Long value) {
            addCriterion("WHERE_ID <", value, "whereId");
            return (Criteria) this;
        }

        public Criteria andWhereIdLessThanOrEqualTo(Long value) {
            addCriterion("WHERE_ID <=", value, "whereId");
            return (Criteria) this;
        }

        public Criteria andWhereIdIn(List<Long> values) {
            addCriterion("WHERE_ID in", values, "whereId");
            return (Criteria) this;
        }

        public Criteria andWhereIdNotIn(List<Long> values) {
            addCriterion("WHERE_ID not in", values, "whereId");
            return (Criteria) this;
        }

        public Criteria andWhereIdBetween(Long value1, Long value2) {
            addCriterion("WHERE_ID between", value1, value2, "whereId");
            return (Criteria) this;
        }

        public Criteria andWhereIdNotBetween(Long value1, Long value2) {
            addCriterion("WHERE_ID not between", value1, value2, "whereId");
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