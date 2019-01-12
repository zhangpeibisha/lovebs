package org.nix.zpbs.model;

import java.util.ArrayList;
import java.util.List;

public class ShuoshuoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShuoshuoExample() {
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

        public Criteria andShuoTimeIsNull() {
            addCriterion("SHUO_TIME is null");
            return (Criteria) this;
        }

        public Criteria andShuoTimeIsNotNull() {
            addCriterion("SHUO_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andShuoTimeEqualTo(Long value) {
            addCriterion("SHUO_TIME =", value, "shuoTime");
            return (Criteria) this;
        }

        public Criteria andShuoTimeNotEqualTo(Long value) {
            addCriterion("SHUO_TIME <>", value, "shuoTime");
            return (Criteria) this;
        }

        public Criteria andShuoTimeGreaterThan(Long value) {
            addCriterion("SHUO_TIME >", value, "shuoTime");
            return (Criteria) this;
        }

        public Criteria andShuoTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("SHUO_TIME >=", value, "shuoTime");
            return (Criteria) this;
        }

        public Criteria andShuoTimeLessThan(Long value) {
            addCriterion("SHUO_TIME <", value, "shuoTime");
            return (Criteria) this;
        }

        public Criteria andShuoTimeLessThanOrEqualTo(Long value) {
            addCriterion("SHUO_TIME <=", value, "shuoTime");
            return (Criteria) this;
        }

        public Criteria andShuoTimeIn(List<Long> values) {
            addCriterion("SHUO_TIME in", values, "shuoTime");
            return (Criteria) this;
        }

        public Criteria andShuoTimeNotIn(List<Long> values) {
            addCriterion("SHUO_TIME not in", values, "shuoTime");
            return (Criteria) this;
        }

        public Criteria andShuoTimeBetween(Long value1, Long value2) {
            addCriterion("SHUO_TIME between", value1, value2, "shuoTime");
            return (Criteria) this;
        }

        public Criteria andShuoTimeNotBetween(Long value1, Long value2) {
            addCriterion("SHUO_TIME not between", value1, value2, "shuoTime");
            return (Criteria) this;
        }

        public Criteria andShuoIpIsNull() {
            addCriterion("SHUO_IP is null");
            return (Criteria) this;
        }

        public Criteria andShuoIpIsNotNull() {
            addCriterion("SHUO_IP is not null");
            return (Criteria) this;
        }

        public Criteria andShuoIpEqualTo(String value) {
            addCriterion("SHUO_IP =", value, "shuoIp");
            return (Criteria) this;
        }

        public Criteria andShuoIpNotEqualTo(String value) {
            addCriterion("SHUO_IP <>", value, "shuoIp");
            return (Criteria) this;
        }

        public Criteria andShuoIpGreaterThan(String value) {
            addCriterion("SHUO_IP >", value, "shuoIp");
            return (Criteria) this;
        }

        public Criteria andShuoIpGreaterThanOrEqualTo(String value) {
            addCriterion("SHUO_IP >=", value, "shuoIp");
            return (Criteria) this;
        }

        public Criteria andShuoIpLessThan(String value) {
            addCriterion("SHUO_IP <", value, "shuoIp");
            return (Criteria) this;
        }

        public Criteria andShuoIpLessThanOrEqualTo(String value) {
            addCriterion("SHUO_IP <=", value, "shuoIp");
            return (Criteria) this;
        }

        public Criteria andShuoIpLike(String value) {
            addCriterion("SHUO_IP like", value, "shuoIp");
            return (Criteria) this;
        }

        public Criteria andShuoIpNotLike(String value) {
            addCriterion("SHUO_IP not like", value, "shuoIp");
            return (Criteria) this;
        }

        public Criteria andShuoIpIn(List<String> values) {
            addCriterion("SHUO_IP in", values, "shuoIp");
            return (Criteria) this;
        }

        public Criteria andShuoIpNotIn(List<String> values) {
            addCriterion("SHUO_IP not in", values, "shuoIp");
            return (Criteria) this;
        }

        public Criteria andShuoIpBetween(String value1, String value2) {
            addCriterion("SHUO_IP between", value1, value2, "shuoIp");
            return (Criteria) this;
        }

        public Criteria andShuoIpNotBetween(String value1, String value2) {
            addCriterion("SHUO_IP not between", value1, value2, "shuoIp");
            return (Criteria) this;
        }

        public Criteria andShuoshuoIsNull() {
            addCriterion("SHUOSHUO is null");
            return (Criteria) this;
        }

        public Criteria andShuoshuoIsNotNull() {
            addCriterion("SHUOSHUO is not null");
            return (Criteria) this;
        }

        public Criteria andShuoshuoEqualTo(String value) {
            addCriterion("SHUOSHUO =", value, "shuoshuo");
            return (Criteria) this;
        }

        public Criteria andShuoshuoNotEqualTo(String value) {
            addCriterion("SHUOSHUO <>", value, "shuoshuo");
            return (Criteria) this;
        }

        public Criteria andShuoshuoGreaterThan(String value) {
            addCriterion("SHUOSHUO >", value, "shuoshuo");
            return (Criteria) this;
        }

        public Criteria andShuoshuoGreaterThanOrEqualTo(String value) {
            addCriterion("SHUOSHUO >=", value, "shuoshuo");
            return (Criteria) this;
        }

        public Criteria andShuoshuoLessThan(String value) {
            addCriterion("SHUOSHUO <", value, "shuoshuo");
            return (Criteria) this;
        }

        public Criteria andShuoshuoLessThanOrEqualTo(String value) {
            addCriterion("SHUOSHUO <=", value, "shuoshuo");
            return (Criteria) this;
        }

        public Criteria andShuoshuoLike(String value) {
            addCriterion("SHUOSHUO like", value, "shuoshuo");
            return (Criteria) this;
        }

        public Criteria andShuoshuoNotLike(String value) {
            addCriterion("SHUOSHUO not like", value, "shuoshuo");
            return (Criteria) this;
        }

        public Criteria andShuoshuoIn(List<String> values) {
            addCriterion("SHUOSHUO in", values, "shuoshuo");
            return (Criteria) this;
        }

        public Criteria andShuoshuoNotIn(List<String> values) {
            addCriterion("SHUOSHUO not in", values, "shuoshuo");
            return (Criteria) this;
        }

        public Criteria andShuoshuoBetween(String value1, String value2) {
            addCriterion("SHUOSHUO between", value1, value2, "shuoshuo");
            return (Criteria) this;
        }

        public Criteria andShuoshuoNotBetween(String value1, String value2) {
            addCriterion("SHUOSHUO not between", value1, value2, "shuoshuo");
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