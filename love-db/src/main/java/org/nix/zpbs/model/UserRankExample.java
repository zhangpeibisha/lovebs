package org.nix.zpbs.model;

import java.util.ArrayList;
import java.util.List;

public class UserRankExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserRankExample() {
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

        public Criteria andRankIdIsNull() {
            addCriterion("rank_id is null");
            return (Criteria) this;
        }

        public Criteria andRankIdIsNotNull() {
            addCriterion("rank_id is not null");
            return (Criteria) this;
        }

        public Criteria andRankIdEqualTo(Long value) {
            addCriterion("rank_id =", value, "rankId");
            return (Criteria) this;
        }

        public Criteria andRankIdNotEqualTo(Long value) {
            addCriterion("rank_id <>", value, "rankId");
            return (Criteria) this;
        }

        public Criteria andRankIdGreaterThan(Long value) {
            addCriterion("rank_id >", value, "rankId");
            return (Criteria) this;
        }

        public Criteria andRankIdGreaterThanOrEqualTo(Long value) {
            addCriterion("rank_id >=", value, "rankId");
            return (Criteria) this;
        }

        public Criteria andRankIdLessThan(Long value) {
            addCriterion("rank_id <", value, "rankId");
            return (Criteria) this;
        }

        public Criteria andRankIdLessThanOrEqualTo(Long value) {
            addCriterion("rank_id <=", value, "rankId");
            return (Criteria) this;
        }

        public Criteria andRankIdIn(List<Long> values) {
            addCriterion("rank_id in", values, "rankId");
            return (Criteria) this;
        }

        public Criteria andRankIdNotIn(List<Long> values) {
            addCriterion("rank_id not in", values, "rankId");
            return (Criteria) this;
        }

        public Criteria andRankIdBetween(Long value1, Long value2) {
            addCriterion("rank_id between", value1, value2, "rankId");
            return (Criteria) this;
        }

        public Criteria andRankIdNotBetween(Long value1, Long value2) {
            addCriterion("rank_id not between", value1, value2, "rankId");
            return (Criteria) this;
        }

        public Criteria andUserRankIdIsNull() {
            addCriterion("user_rank_id is null");
            return (Criteria) this;
        }

        public Criteria andUserRankIdIsNotNull() {
            addCriterion("user_rank_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserRankIdEqualTo(Short value) {
            addCriterion("user_rank_id =", value, "userRankId");
            return (Criteria) this;
        }

        public Criteria andUserRankIdNotEqualTo(Short value) {
            addCriterion("user_rank_id <>", value, "userRankId");
            return (Criteria) this;
        }

        public Criteria andUserRankIdGreaterThan(Short value) {
            addCriterion("user_rank_id >", value, "userRankId");
            return (Criteria) this;
        }

        public Criteria andUserRankIdGreaterThanOrEqualTo(Short value) {
            addCriterion("user_rank_id >=", value, "userRankId");
            return (Criteria) this;
        }

        public Criteria andUserRankIdLessThan(Short value) {
            addCriterion("user_rank_id <", value, "userRankId");
            return (Criteria) this;
        }

        public Criteria andUserRankIdLessThanOrEqualTo(Short value) {
            addCriterion("user_rank_id <=", value, "userRankId");
            return (Criteria) this;
        }

        public Criteria andUserRankIdIn(List<Short> values) {
            addCriterion("user_rank_id in", values, "userRankId");
            return (Criteria) this;
        }

        public Criteria andUserRankIdNotIn(List<Short> values) {
            addCriterion("user_rank_id not in", values, "userRankId");
            return (Criteria) this;
        }

        public Criteria andUserRankIdBetween(Short value1, Short value2) {
            addCriterion("user_rank_id between", value1, value2, "userRankId");
            return (Criteria) this;
        }

        public Criteria andUserRankIdNotBetween(Short value1, Short value2) {
            addCriterion("user_rank_id not between", value1, value2, "userRankId");
            return (Criteria) this;
        }

        public Criteria andRankMarkIsNull() {
            addCriterion("rank_mark is null");
            return (Criteria) this;
        }

        public Criteria andRankMarkIsNotNull() {
            addCriterion("rank_mark is not null");
            return (Criteria) this;
        }

        public Criteria andRankMarkEqualTo(Long value) {
            addCriterion("rank_mark =", value, "rankMark");
            return (Criteria) this;
        }

        public Criteria andRankMarkNotEqualTo(Long value) {
            addCriterion("rank_mark <>", value, "rankMark");
            return (Criteria) this;
        }

        public Criteria andRankMarkGreaterThan(Long value) {
            addCriterion("rank_mark >", value, "rankMark");
            return (Criteria) this;
        }

        public Criteria andRankMarkGreaterThanOrEqualTo(Long value) {
            addCriterion("rank_mark >=", value, "rankMark");
            return (Criteria) this;
        }

        public Criteria andRankMarkLessThan(Long value) {
            addCriterion("rank_mark <", value, "rankMark");
            return (Criteria) this;
        }

        public Criteria andRankMarkLessThanOrEqualTo(Long value) {
            addCriterion("rank_mark <=", value, "rankMark");
            return (Criteria) this;
        }

        public Criteria andRankMarkIn(List<Long> values) {
            addCriterion("rank_mark in", values, "rankMark");
            return (Criteria) this;
        }

        public Criteria andRankMarkNotIn(List<Long> values) {
            addCriterion("rank_mark not in", values, "rankMark");
            return (Criteria) this;
        }

        public Criteria andRankMarkBetween(Long value1, Long value2) {
            addCriterion("rank_mark between", value1, value2, "rankMark");
            return (Criteria) this;
        }

        public Criteria andRankMarkNotBetween(Long value1, Long value2) {
            addCriterion("rank_mark not between", value1, value2, "rankMark");
            return (Criteria) this;
        }

        public Criteria andRankNameIsNull() {
            addCriterion("rank_name is null");
            return (Criteria) this;
        }

        public Criteria andRankNameIsNotNull() {
            addCriterion("rank_name is not null");
            return (Criteria) this;
        }

        public Criteria andRankNameEqualTo(String value) {
            addCriterion("rank_name =", value, "rankName");
            return (Criteria) this;
        }

        public Criteria andRankNameNotEqualTo(String value) {
            addCriterion("rank_name <>", value, "rankName");
            return (Criteria) this;
        }

        public Criteria andRankNameGreaterThan(String value) {
            addCriterion("rank_name >", value, "rankName");
            return (Criteria) this;
        }

        public Criteria andRankNameGreaterThanOrEqualTo(String value) {
            addCriterion("rank_name >=", value, "rankName");
            return (Criteria) this;
        }

        public Criteria andRankNameLessThan(String value) {
            addCriterion("rank_name <", value, "rankName");
            return (Criteria) this;
        }

        public Criteria andRankNameLessThanOrEqualTo(String value) {
            addCriterion("rank_name <=", value, "rankName");
            return (Criteria) this;
        }

        public Criteria andRankNameLike(String value) {
            addCriterion("rank_name like", value, "rankName");
            return (Criteria) this;
        }

        public Criteria andRankNameNotLike(String value) {
            addCriterion("rank_name not like", value, "rankName");
            return (Criteria) this;
        }

        public Criteria andRankNameIn(List<String> values) {
            addCriterion("rank_name in", values, "rankName");
            return (Criteria) this;
        }

        public Criteria andRankNameNotIn(List<String> values) {
            addCriterion("rank_name not in", values, "rankName");
            return (Criteria) this;
        }

        public Criteria andRankNameBetween(String value1, String value2) {
            addCriterion("rank_name between", value1, value2, "rankName");
            return (Criteria) this;
        }

        public Criteria andRankNameNotBetween(String value1, String value2) {
            addCriterion("rank_name not between", value1, value2, "rankName");
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