package org.nix.zpbs.model;

import java.util.ArrayList;
import java.util.List;

public class AboutBlogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AboutBlogExample() {
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

        public Criteria andBlogKeywordIsNull() {
            addCriterion("BLOG_KEYWORD is null");
            return (Criteria) this;
        }

        public Criteria andBlogKeywordIsNotNull() {
            addCriterion("BLOG_KEYWORD is not null");
            return (Criteria) this;
        }

        public Criteria andBlogKeywordEqualTo(String value) {
            addCriterion("BLOG_KEYWORD =", value, "blogKeyword");
            return (Criteria) this;
        }

        public Criteria andBlogKeywordNotEqualTo(String value) {
            addCriterion("BLOG_KEYWORD <>", value, "blogKeyword");
            return (Criteria) this;
        }

        public Criteria andBlogKeywordGreaterThan(String value) {
            addCriterion("BLOG_KEYWORD >", value, "blogKeyword");
            return (Criteria) this;
        }

        public Criteria andBlogKeywordGreaterThanOrEqualTo(String value) {
            addCriterion("BLOG_KEYWORD >=", value, "blogKeyword");
            return (Criteria) this;
        }

        public Criteria andBlogKeywordLessThan(String value) {
            addCriterion("BLOG_KEYWORD <", value, "blogKeyword");
            return (Criteria) this;
        }

        public Criteria andBlogKeywordLessThanOrEqualTo(String value) {
            addCriterion("BLOG_KEYWORD <=", value, "blogKeyword");
            return (Criteria) this;
        }

        public Criteria andBlogKeywordLike(String value) {
            addCriterion("BLOG_KEYWORD like", value, "blogKeyword");
            return (Criteria) this;
        }

        public Criteria andBlogKeywordNotLike(String value) {
            addCriterion("BLOG_KEYWORD not like", value, "blogKeyword");
            return (Criteria) this;
        }

        public Criteria andBlogKeywordIn(List<String> values) {
            addCriterion("BLOG_KEYWORD in", values, "blogKeyword");
            return (Criteria) this;
        }

        public Criteria andBlogKeywordNotIn(List<String> values) {
            addCriterion("BLOG_KEYWORD not in", values, "blogKeyword");
            return (Criteria) this;
        }

        public Criteria andBlogKeywordBetween(String value1, String value2) {
            addCriterion("BLOG_KEYWORD between", value1, value2, "blogKeyword");
            return (Criteria) this;
        }

        public Criteria andBlogKeywordNotBetween(String value1, String value2) {
            addCriterion("BLOG_KEYWORD not between", value1, value2, "blogKeyword");
            return (Criteria) this;
        }

        public Criteria andBlogDescriptionIsNull() {
            addCriterion("BLOG_DESCRIPTION is null");
            return (Criteria) this;
        }

        public Criteria andBlogDescriptionIsNotNull() {
            addCriterion("BLOG_DESCRIPTION is not null");
            return (Criteria) this;
        }

        public Criteria andBlogDescriptionEqualTo(String value) {
            addCriterion("BLOG_DESCRIPTION =", value, "blogDescription");
            return (Criteria) this;
        }

        public Criteria andBlogDescriptionNotEqualTo(String value) {
            addCriterion("BLOG_DESCRIPTION <>", value, "blogDescription");
            return (Criteria) this;
        }

        public Criteria andBlogDescriptionGreaterThan(String value) {
            addCriterion("BLOG_DESCRIPTION >", value, "blogDescription");
            return (Criteria) this;
        }

        public Criteria andBlogDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("BLOG_DESCRIPTION >=", value, "blogDescription");
            return (Criteria) this;
        }

        public Criteria andBlogDescriptionLessThan(String value) {
            addCriterion("BLOG_DESCRIPTION <", value, "blogDescription");
            return (Criteria) this;
        }

        public Criteria andBlogDescriptionLessThanOrEqualTo(String value) {
            addCriterion("BLOG_DESCRIPTION <=", value, "blogDescription");
            return (Criteria) this;
        }

        public Criteria andBlogDescriptionLike(String value) {
            addCriterion("BLOG_DESCRIPTION like", value, "blogDescription");
            return (Criteria) this;
        }

        public Criteria andBlogDescriptionNotLike(String value) {
            addCriterion("BLOG_DESCRIPTION not like", value, "blogDescription");
            return (Criteria) this;
        }

        public Criteria andBlogDescriptionIn(List<String> values) {
            addCriterion("BLOG_DESCRIPTION in", values, "blogDescription");
            return (Criteria) this;
        }

        public Criteria andBlogDescriptionNotIn(List<String> values) {
            addCriterion("BLOG_DESCRIPTION not in", values, "blogDescription");
            return (Criteria) this;
        }

        public Criteria andBlogDescriptionBetween(String value1, String value2) {
            addCriterion("BLOG_DESCRIPTION between", value1, value2, "blogDescription");
            return (Criteria) this;
        }

        public Criteria andBlogDescriptionNotBetween(String value1, String value2) {
            addCriterion("BLOG_DESCRIPTION not between", value1, value2, "blogDescription");
            return (Criteria) this;
        }

        public Criteria andBlogNameIsNull() {
            addCriterion("BLOG_NAME is null");
            return (Criteria) this;
        }

        public Criteria andBlogNameIsNotNull() {
            addCriterion("BLOG_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andBlogNameEqualTo(String value) {
            addCriterion("BLOG_NAME =", value, "blogName");
            return (Criteria) this;
        }

        public Criteria andBlogNameNotEqualTo(String value) {
            addCriterion("BLOG_NAME <>", value, "blogName");
            return (Criteria) this;
        }

        public Criteria andBlogNameGreaterThan(String value) {
            addCriterion("BLOG_NAME >", value, "blogName");
            return (Criteria) this;
        }

        public Criteria andBlogNameGreaterThanOrEqualTo(String value) {
            addCriterion("BLOG_NAME >=", value, "blogName");
            return (Criteria) this;
        }

        public Criteria andBlogNameLessThan(String value) {
            addCriterion("BLOG_NAME <", value, "blogName");
            return (Criteria) this;
        }

        public Criteria andBlogNameLessThanOrEqualTo(String value) {
            addCriterion("BLOG_NAME <=", value, "blogName");
            return (Criteria) this;
        }

        public Criteria andBlogNameLike(String value) {
            addCriterion("BLOG_NAME like", value, "blogName");
            return (Criteria) this;
        }

        public Criteria andBlogNameNotLike(String value) {
            addCriterion("BLOG_NAME not like", value, "blogName");
            return (Criteria) this;
        }

        public Criteria andBlogNameIn(List<String> values) {
            addCriterion("BLOG_NAME in", values, "blogName");
            return (Criteria) this;
        }

        public Criteria andBlogNameNotIn(List<String> values) {
            addCriterion("BLOG_NAME not in", values, "blogName");
            return (Criteria) this;
        }

        public Criteria andBlogNameBetween(String value1, String value2) {
            addCriterion("BLOG_NAME between", value1, value2, "blogName");
            return (Criteria) this;
        }

        public Criteria andBlogNameNotBetween(String value1, String value2) {
            addCriterion("BLOG_NAME not between", value1, value2, "blogName");
            return (Criteria) this;
        }

        public Criteria andBlogTitleIsNull() {
            addCriterion("BLOG_TITLE is null");
            return (Criteria) this;
        }

        public Criteria andBlogTitleIsNotNull() {
            addCriterion("BLOG_TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andBlogTitleEqualTo(String value) {
            addCriterion("BLOG_TITLE =", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleNotEqualTo(String value) {
            addCriterion("BLOG_TITLE <>", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleGreaterThan(String value) {
            addCriterion("BLOG_TITLE >", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleGreaterThanOrEqualTo(String value) {
            addCriterion("BLOG_TITLE >=", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleLessThan(String value) {
            addCriterion("BLOG_TITLE <", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleLessThanOrEqualTo(String value) {
            addCriterion("BLOG_TITLE <=", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleLike(String value) {
            addCriterion("BLOG_TITLE like", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleNotLike(String value) {
            addCriterion("BLOG_TITLE not like", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleIn(List<String> values) {
            addCriterion("BLOG_TITLE in", values, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleNotIn(List<String> values) {
            addCriterion("BLOG_TITLE not in", values, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleBetween(String value1, String value2) {
            addCriterion("BLOG_TITLE between", value1, value2, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleNotBetween(String value1, String value2) {
            addCriterion("BLOG_TITLE not between", value1, value2, "blogTitle");
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