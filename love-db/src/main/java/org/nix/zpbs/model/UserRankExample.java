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

        public Criteria andUserRankIsNull() {
            addCriterion("USER_RANK is null");
            return (Criteria) this;
        }

        public Criteria andUserRankIsNotNull() {
            addCriterion("USER_RANK is not null");
            return (Criteria) this;
        }

        public Criteria andUserRankEqualTo(Long value) {
            addCriterion("USER_RANK =", value, "userRank");
            return (Criteria) this;
        }

        public Criteria andUserRankNotEqualTo(Long value) {
            addCriterion("USER_RANK <>", value, "userRank");
            return (Criteria) this;
        }

        public Criteria andUserRankGreaterThan(Long value) {
            addCriterion("USER_RANK >", value, "userRank");
            return (Criteria) this;
        }

        public Criteria andUserRankGreaterThanOrEqualTo(Long value) {
            addCriterion("USER_RANK >=", value, "userRank");
            return (Criteria) this;
        }

        public Criteria andUserRankLessThan(Long value) {
            addCriterion("USER_RANK <", value, "userRank");
            return (Criteria) this;
        }

        public Criteria andUserRankLessThanOrEqualTo(Long value) {
            addCriterion("USER_RANK <=", value, "userRank");
            return (Criteria) this;
        }

        public Criteria andUserRankIn(List<Long> values) {
            addCriterion("USER_RANK in", values, "userRank");
            return (Criteria) this;
        }

        public Criteria andUserRankNotIn(List<Long> values) {
            addCriterion("USER_RANK not in", values, "userRank");
            return (Criteria) this;
        }

        public Criteria andUserRankBetween(Long value1, Long value2) {
            addCriterion("USER_RANK between", value1, value2, "userRank");
            return (Criteria) this;
        }

        public Criteria andUserRankNotBetween(Long value1, Long value2) {
            addCriterion("USER_RANK not between", value1, value2, "userRank");
            return (Criteria) this;
        }

        public Criteria andRankMarkIsNull() {
            addCriterion("RANK_MARK is null");
            return (Criteria) this;
        }

        public Criteria andRankMarkIsNotNull() {
            addCriterion("RANK_MARK is not null");
            return (Criteria) this;
        }

        public Criteria andRankMarkEqualTo(Long value) {
            addCriterion("RANK_MARK =", value, "rankMark");
            return (Criteria) this;
        }

        public Criteria andRankMarkNotEqualTo(Long value) {
            addCriterion("RANK_MARK <>", value, "rankMark");
            return (Criteria) this;
        }

        public Criteria andRankMarkGreaterThan(Long value) {
            addCriterion("RANK_MARK >", value, "rankMark");
            return (Criteria) this;
        }

        public Criteria andRankMarkGreaterThanOrEqualTo(Long value) {
            addCriterion("RANK_MARK >=", value, "rankMark");
            return (Criteria) this;
        }

        public Criteria andRankMarkLessThan(Long value) {
            addCriterion("RANK_MARK <", value, "rankMark");
            return (Criteria) this;
        }

        public Criteria andRankMarkLessThanOrEqualTo(Long value) {
            addCriterion("RANK_MARK <=", value, "rankMark");
            return (Criteria) this;
        }

        public Criteria andRankMarkIn(List<Long> values) {
            addCriterion("RANK_MARK in", values, "rankMark");
            return (Criteria) this;
        }

        public Criteria andRankMarkNotIn(List<Long> values) {
            addCriterion("RANK_MARK not in", values, "rankMark");
            return (Criteria) this;
        }

        public Criteria andRankMarkBetween(Long value1, Long value2) {
            addCriterion("RANK_MARK between", value1, value2, "rankMark");
            return (Criteria) this;
        }

        public Criteria andRankMarkNotBetween(Long value1, Long value2) {
            addCriterion("RANK_MARK not between", value1, value2, "rankMark");
            return (Criteria) this;
        }

        public Criteria andRankNameIsNull() {
            addCriterion("RANK_NAME is null");
            return (Criteria) this;
        }

        public Criteria andRankNameIsNotNull() {
            addCriterion("RANK_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andRankNameEqualTo(String value) {
            addCriterion("RANK_NAME =", value, "rankName");
            return (Criteria) this;
        }

        public Criteria andRankNameNotEqualTo(String value) {
            addCriterion("RANK_NAME <>", value, "rankName");
            return (Criteria) this;
        }

        public Criteria andRankNameGreaterThan(String value) {
            addCriterion("RANK_NAME >", value, "rankName");
            return (Criteria) this;
        }

        public Criteria andRankNameGreaterThanOrEqualTo(String value) {
            addCriterion("RANK_NAME >=", value, "rankName");
            return (Criteria) this;
        }

        public Criteria andRankNameLessThan(String value) {
            addCriterion("RANK_NAME <", value, "rankName");
            return (Criteria) this;
        }

        public Criteria andRankNameLessThanOrEqualTo(String value) {
            addCriterion("RANK_NAME <=", value, "rankName");
            return (Criteria) this;
        }

        public Criteria andRankNameLike(String value) {
            addCriterion("RANK_NAME like", value, "rankName");
            return (Criteria) this;
        }

        public Criteria andRankNameNotLike(String value) {
            addCriterion("RANK_NAME not like", value, "rankName");
            return (Criteria) this;
        }

        public Criteria andRankNameIn(List<String> values) {
            addCriterion("RANK_NAME in", values, "rankName");
            return (Criteria) this;
        }

        public Criteria andRankNameNotIn(List<String> values) {
            addCriterion("RANK_NAME not in", values, "rankName");
            return (Criteria) this;
        }

        public Criteria andRankNameBetween(String value1, String value2) {
            addCriterion("RANK_NAME between", value1, value2, "rankName");
            return (Criteria) this;
        }

        public Criteria andRankNameNotBetween(String value1, String value2) {
            addCriterion("RANK_NAME not between", value1, value2, "rankName");
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