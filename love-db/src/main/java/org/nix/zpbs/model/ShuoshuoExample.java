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

        public Criteria andShuoIdIsNull() {
            addCriterion("shuo_id is null");
            return (Criteria) this;
        }

        public Criteria andShuoIdIsNotNull() {
            addCriterion("shuo_id is not null");
            return (Criteria) this;
        }

        public Criteria andShuoIdEqualTo(Long value) {
            addCriterion("shuo_id =", value, "shuoId");
            return (Criteria) this;
        }

        public Criteria andShuoIdNotEqualTo(Long value) {
            addCriterion("shuo_id <>", value, "shuoId");
            return (Criteria) this;
        }

        public Criteria andShuoIdGreaterThan(Long value) {
            addCriterion("shuo_id >", value, "shuoId");
            return (Criteria) this;
        }

        public Criteria andShuoIdGreaterThanOrEqualTo(Long value) {
            addCriterion("shuo_id >=", value, "shuoId");
            return (Criteria) this;
        }

        public Criteria andShuoIdLessThan(Long value) {
            addCriterion("shuo_id <", value, "shuoId");
            return (Criteria) this;
        }

        public Criteria andShuoIdLessThanOrEqualTo(Long value) {
            addCriterion("shuo_id <=", value, "shuoId");
            return (Criteria) this;
        }

        public Criteria andShuoIdIn(List<Long> values) {
            addCriterion("shuo_id in", values, "shuoId");
            return (Criteria) this;
        }

        public Criteria andShuoIdNotIn(List<Long> values) {
            addCriterion("shuo_id not in", values, "shuoId");
            return (Criteria) this;
        }

        public Criteria andShuoIdBetween(Long value1, Long value2) {
            addCriterion("shuo_id between", value1, value2, "shuoId");
            return (Criteria) this;
        }

        public Criteria andShuoIdNotBetween(Long value1, Long value2) {
            addCriterion("shuo_id not between", value1, value2, "shuoId");
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

        public Criteria andShuoTimeIsNull() {
            addCriterion("shuo_time is null");
            return (Criteria) this;
        }

        public Criteria andShuoTimeIsNotNull() {
            addCriterion("shuo_time is not null");
            return (Criteria) this;
        }

        public Criteria andShuoTimeEqualTo(Long value) {
            addCriterion("shuo_time =", value, "shuoTime");
            return (Criteria) this;
        }

        public Criteria andShuoTimeNotEqualTo(Long value) {
            addCriterion("shuo_time <>", value, "shuoTime");
            return (Criteria) this;
        }

        public Criteria andShuoTimeGreaterThan(Long value) {
            addCriterion("shuo_time >", value, "shuoTime");
            return (Criteria) this;
        }

        public Criteria andShuoTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("shuo_time >=", value, "shuoTime");
            return (Criteria) this;
        }

        public Criteria andShuoTimeLessThan(Long value) {
            addCriterion("shuo_time <", value, "shuoTime");
            return (Criteria) this;
        }

        public Criteria andShuoTimeLessThanOrEqualTo(Long value) {
            addCriterion("shuo_time <=", value, "shuoTime");
            return (Criteria) this;
        }

        public Criteria andShuoTimeIn(List<Long> values) {
            addCriterion("shuo_time in", values, "shuoTime");
            return (Criteria) this;
        }

        public Criteria andShuoTimeNotIn(List<Long> values) {
            addCriterion("shuo_time not in", values, "shuoTime");
            return (Criteria) this;
        }

        public Criteria andShuoTimeBetween(Long value1, Long value2) {
            addCriterion("shuo_time between", value1, value2, "shuoTime");
            return (Criteria) this;
        }

        public Criteria andShuoTimeNotBetween(Long value1, Long value2) {
            addCriterion("shuo_time not between", value1, value2, "shuoTime");
            return (Criteria) this;
        }

        public Criteria andShuoIpIsNull() {
            addCriterion("shuo_ip is null");
            return (Criteria) this;
        }

        public Criteria andShuoIpIsNotNull() {
            addCriterion("shuo_ip is not null");
            return (Criteria) this;
        }

        public Criteria andShuoIpEqualTo(String value) {
            addCriterion("shuo_ip =", value, "shuoIp");
            return (Criteria) this;
        }

        public Criteria andShuoIpNotEqualTo(String value) {
            addCriterion("shuo_ip <>", value, "shuoIp");
            return (Criteria) this;
        }

        public Criteria andShuoIpGreaterThan(String value) {
            addCriterion("shuo_ip >", value, "shuoIp");
            return (Criteria) this;
        }

        public Criteria andShuoIpGreaterThanOrEqualTo(String value) {
            addCriterion("shuo_ip >=", value, "shuoIp");
            return (Criteria) this;
        }

        public Criteria andShuoIpLessThan(String value) {
            addCriterion("shuo_ip <", value, "shuoIp");
            return (Criteria) this;
        }

        public Criteria andShuoIpLessThanOrEqualTo(String value) {
            addCriterion("shuo_ip <=", value, "shuoIp");
            return (Criteria) this;
        }

        public Criteria andShuoIpLike(String value) {
            addCriterion("shuo_ip like", value, "shuoIp");
            return (Criteria) this;
        }

        public Criteria andShuoIpNotLike(String value) {
            addCriterion("shuo_ip not like", value, "shuoIp");
            return (Criteria) this;
        }

        public Criteria andShuoIpIn(List<String> values) {
            addCriterion("shuo_ip in", values, "shuoIp");
            return (Criteria) this;
        }

        public Criteria andShuoIpNotIn(List<String> values) {
            addCriterion("shuo_ip not in", values, "shuoIp");
            return (Criteria) this;
        }

        public Criteria andShuoIpBetween(String value1, String value2) {
            addCriterion("shuo_ip between", value1, value2, "shuoIp");
            return (Criteria) this;
        }

        public Criteria andShuoIpNotBetween(String value1, String value2) {
            addCriterion("shuo_ip not between", value1, value2, "shuoIp");
            return (Criteria) this;
        }

        public Criteria andShuoshuoIsNull() {
            addCriterion("shuoshuo is null");
            return (Criteria) this;
        }

        public Criteria andShuoshuoIsNotNull() {
            addCriterion("shuoshuo is not null");
            return (Criteria) this;
        }

        public Criteria andShuoshuoEqualTo(String value) {
            addCriterion("shuoshuo =", value, "shuoshuo");
            return (Criteria) this;
        }

        public Criteria andShuoshuoNotEqualTo(String value) {
            addCriterion("shuoshuo <>", value, "shuoshuo");
            return (Criteria) this;
        }

        public Criteria andShuoshuoGreaterThan(String value) {
            addCriterion("shuoshuo >", value, "shuoshuo");
            return (Criteria) this;
        }

        public Criteria andShuoshuoGreaterThanOrEqualTo(String value) {
            addCriterion("shuoshuo >=", value, "shuoshuo");
            return (Criteria) this;
        }

        public Criteria andShuoshuoLessThan(String value) {
            addCriterion("shuoshuo <", value, "shuoshuo");
            return (Criteria) this;
        }

        public Criteria andShuoshuoLessThanOrEqualTo(String value) {
            addCriterion("shuoshuo <=", value, "shuoshuo");
            return (Criteria) this;
        }

        public Criteria andShuoshuoLike(String value) {
            addCriterion("shuoshuo like", value, "shuoshuo");
            return (Criteria) this;
        }

        public Criteria andShuoshuoNotLike(String value) {
            addCriterion("shuoshuo not like", value, "shuoshuo");
            return (Criteria) this;
        }

        public Criteria andShuoshuoIn(List<String> values) {
            addCriterion("shuoshuo in", values, "shuoshuo");
            return (Criteria) this;
        }

        public Criteria andShuoshuoNotIn(List<String> values) {
            addCriterion("shuoshuo not in", values, "shuoshuo");
            return (Criteria) this;
        }

        public Criteria andShuoshuoBetween(String value1, String value2) {
            addCriterion("shuoshuo between", value1, value2, "shuoshuo");
            return (Criteria) this;
        }

        public Criteria andShuoshuoNotBetween(String value1, String value2) {
            addCriterion("shuoshuo not between", value1, value2, "shuoshuo");
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

        public Criteria andTypeIdEqualTo(Byte value) {
            addCriterion("type_id =", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotEqualTo(Byte value) {
            addCriterion("type_id <>", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThan(Byte value) {
            addCriterion("type_id >", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThanOrEqualTo(Byte value) {
            addCriterion("type_id >=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThan(Byte value) {
            addCriterion("type_id <", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThanOrEqualTo(Byte value) {
            addCriterion("type_id <=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIn(List<Byte> values) {
            addCriterion("type_id in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotIn(List<Byte> values) {
            addCriterion("type_id not in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdBetween(Byte value1, Byte value2) {
            addCriterion("type_id between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotBetween(Byte value1, Byte value2) {
            addCriterion("type_id not between", value1, value2, "typeId");
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