package org.nix.zpbs.model;

import java.util.ArrayList;
import java.util.List;

public class ArticleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ArticleExample() {
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

        public Criteria andArticleNameIsNull() {
            addCriterion("ARTICLE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andArticleNameIsNotNull() {
            addCriterion("ARTICLE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andArticleNameEqualTo(String value) {
            addCriterion("ARTICLE_NAME =", value, "articleName");
            return (Criteria) this;
        }

        public Criteria andArticleNameNotEqualTo(String value) {
            addCriterion("ARTICLE_NAME <>", value, "articleName");
            return (Criteria) this;
        }

        public Criteria andArticleNameGreaterThan(String value) {
            addCriterion("ARTICLE_NAME >", value, "articleName");
            return (Criteria) this;
        }

        public Criteria andArticleNameGreaterThanOrEqualTo(String value) {
            addCriterion("ARTICLE_NAME >=", value, "articleName");
            return (Criteria) this;
        }

        public Criteria andArticleNameLessThan(String value) {
            addCriterion("ARTICLE_NAME <", value, "articleName");
            return (Criteria) this;
        }

        public Criteria andArticleNameLessThanOrEqualTo(String value) {
            addCriterion("ARTICLE_NAME <=", value, "articleName");
            return (Criteria) this;
        }

        public Criteria andArticleNameLike(String value) {
            addCriterion("ARTICLE_NAME like", value, "articleName");
            return (Criteria) this;
        }

        public Criteria andArticleNameNotLike(String value) {
            addCriterion("ARTICLE_NAME not like", value, "articleName");
            return (Criteria) this;
        }

        public Criteria andArticleNameIn(List<String> values) {
            addCriterion("ARTICLE_NAME in", values, "articleName");
            return (Criteria) this;
        }

        public Criteria andArticleNameNotIn(List<String> values) {
            addCriterion("ARTICLE_NAME not in", values, "articleName");
            return (Criteria) this;
        }

        public Criteria andArticleNameBetween(String value1, String value2) {
            addCriterion("ARTICLE_NAME between", value1, value2, "articleName");
            return (Criteria) this;
        }

        public Criteria andArticleNameNotBetween(String value1, String value2) {
            addCriterion("ARTICLE_NAME not between", value1, value2, "articleName");
            return (Criteria) this;
        }

        public Criteria andArticleTimeIsNull() {
            addCriterion("ARTICLE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andArticleTimeIsNotNull() {
            addCriterion("ARTICLE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andArticleTimeEqualTo(Long value) {
            addCriterion("ARTICLE_TIME =", value, "articleTime");
            return (Criteria) this;
        }

        public Criteria andArticleTimeNotEqualTo(Long value) {
            addCriterion("ARTICLE_TIME <>", value, "articleTime");
            return (Criteria) this;
        }

        public Criteria andArticleTimeGreaterThan(Long value) {
            addCriterion("ARTICLE_TIME >", value, "articleTime");
            return (Criteria) this;
        }

        public Criteria andArticleTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("ARTICLE_TIME >=", value, "articleTime");
            return (Criteria) this;
        }

        public Criteria andArticleTimeLessThan(Long value) {
            addCriterion("ARTICLE_TIME <", value, "articleTime");
            return (Criteria) this;
        }

        public Criteria andArticleTimeLessThanOrEqualTo(Long value) {
            addCriterion("ARTICLE_TIME <=", value, "articleTime");
            return (Criteria) this;
        }

        public Criteria andArticleTimeIn(List<Long> values) {
            addCriterion("ARTICLE_TIME in", values, "articleTime");
            return (Criteria) this;
        }

        public Criteria andArticleTimeNotIn(List<Long> values) {
            addCriterion("ARTICLE_TIME not in", values, "articleTime");
            return (Criteria) this;
        }

        public Criteria andArticleTimeBetween(Long value1, Long value2) {
            addCriterion("ARTICLE_TIME between", value1, value2, "articleTime");
            return (Criteria) this;
        }

        public Criteria andArticleTimeNotBetween(Long value1, Long value2) {
            addCriterion("ARTICLE_TIME not between", value1, value2, "articleTime");
            return (Criteria) this;
        }

        public Criteria andArticleIpIsNull() {
            addCriterion("ARTICLE_IP is null");
            return (Criteria) this;
        }

        public Criteria andArticleIpIsNotNull() {
            addCriterion("ARTICLE_IP is not null");
            return (Criteria) this;
        }

        public Criteria andArticleIpEqualTo(String value) {
            addCriterion("ARTICLE_IP =", value, "articleIp");
            return (Criteria) this;
        }

        public Criteria andArticleIpNotEqualTo(String value) {
            addCriterion("ARTICLE_IP <>", value, "articleIp");
            return (Criteria) this;
        }

        public Criteria andArticleIpGreaterThan(String value) {
            addCriterion("ARTICLE_IP >", value, "articleIp");
            return (Criteria) this;
        }

        public Criteria andArticleIpGreaterThanOrEqualTo(String value) {
            addCriterion("ARTICLE_IP >=", value, "articleIp");
            return (Criteria) this;
        }

        public Criteria andArticleIpLessThan(String value) {
            addCriterion("ARTICLE_IP <", value, "articleIp");
            return (Criteria) this;
        }

        public Criteria andArticleIpLessThanOrEqualTo(String value) {
            addCriterion("ARTICLE_IP <=", value, "articleIp");
            return (Criteria) this;
        }

        public Criteria andArticleIpLike(String value) {
            addCriterion("ARTICLE_IP like", value, "articleIp");
            return (Criteria) this;
        }

        public Criteria andArticleIpNotLike(String value) {
            addCriterion("ARTICLE_IP not like", value, "articleIp");
            return (Criteria) this;
        }

        public Criteria andArticleIpIn(List<String> values) {
            addCriterion("ARTICLE_IP in", values, "articleIp");
            return (Criteria) this;
        }

        public Criteria andArticleIpNotIn(List<String> values) {
            addCriterion("ARTICLE_IP not in", values, "articleIp");
            return (Criteria) this;
        }

        public Criteria andArticleIpBetween(String value1, String value2) {
            addCriterion("ARTICLE_IP between", value1, value2, "articleIp");
            return (Criteria) this;
        }

        public Criteria andArticleIpNotBetween(String value1, String value2) {
            addCriterion("ARTICLE_IP not between", value1, value2, "articleIp");
            return (Criteria) this;
        }

        public Criteria andArticleClickIsNull() {
            addCriterion("ARTICLE_CLICK is null");
            return (Criteria) this;
        }

        public Criteria andArticleClickIsNotNull() {
            addCriterion("ARTICLE_CLICK is not null");
            return (Criteria) this;
        }

        public Criteria andArticleClickEqualTo(Integer value) {
            addCriterion("ARTICLE_CLICK =", value, "articleClick");
            return (Criteria) this;
        }

        public Criteria andArticleClickNotEqualTo(Integer value) {
            addCriterion("ARTICLE_CLICK <>", value, "articleClick");
            return (Criteria) this;
        }

        public Criteria andArticleClickGreaterThan(Integer value) {
            addCriterion("ARTICLE_CLICK >", value, "articleClick");
            return (Criteria) this;
        }

        public Criteria andArticleClickGreaterThanOrEqualTo(Integer value) {
            addCriterion("ARTICLE_CLICK >=", value, "articleClick");
            return (Criteria) this;
        }

        public Criteria andArticleClickLessThan(Integer value) {
            addCriterion("ARTICLE_CLICK <", value, "articleClick");
            return (Criteria) this;
        }

        public Criteria andArticleClickLessThanOrEqualTo(Integer value) {
            addCriterion("ARTICLE_CLICK <=", value, "articleClick");
            return (Criteria) this;
        }

        public Criteria andArticleClickIn(List<Integer> values) {
            addCriterion("ARTICLE_CLICK in", values, "articleClick");
            return (Criteria) this;
        }

        public Criteria andArticleClickNotIn(List<Integer> values) {
            addCriterion("ARTICLE_CLICK not in", values, "articleClick");
            return (Criteria) this;
        }

        public Criteria andArticleClickBetween(Integer value1, Integer value2) {
            addCriterion("ARTICLE_CLICK between", value1, value2, "articleClick");
            return (Criteria) this;
        }

        public Criteria andArticleClickNotBetween(Integer value1, Integer value2) {
            addCriterion("ARTICLE_CLICK not between", value1, value2, "articleClick");
            return (Criteria) this;
        }

        public Criteria andSortArticleIdIsNull() {
            addCriterion("SORT_ARTICLE_ID is null");
            return (Criteria) this;
        }

        public Criteria andSortArticleIdIsNotNull() {
            addCriterion("SORT_ARTICLE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSortArticleIdEqualTo(Long value) {
            addCriterion("SORT_ARTICLE_ID =", value, "sortArticleId");
            return (Criteria) this;
        }

        public Criteria andSortArticleIdNotEqualTo(Long value) {
            addCriterion("SORT_ARTICLE_ID <>", value, "sortArticleId");
            return (Criteria) this;
        }

        public Criteria andSortArticleIdGreaterThan(Long value) {
            addCriterion("SORT_ARTICLE_ID >", value, "sortArticleId");
            return (Criteria) this;
        }

        public Criteria andSortArticleIdGreaterThanOrEqualTo(Long value) {
            addCriterion("SORT_ARTICLE_ID >=", value, "sortArticleId");
            return (Criteria) this;
        }

        public Criteria andSortArticleIdLessThan(Long value) {
            addCriterion("SORT_ARTICLE_ID <", value, "sortArticleId");
            return (Criteria) this;
        }

        public Criteria andSortArticleIdLessThanOrEqualTo(Long value) {
            addCriterion("SORT_ARTICLE_ID <=", value, "sortArticleId");
            return (Criteria) this;
        }

        public Criteria andSortArticleIdIn(List<Long> values) {
            addCriterion("SORT_ARTICLE_ID in", values, "sortArticleId");
            return (Criteria) this;
        }

        public Criteria andSortArticleIdNotIn(List<Long> values) {
            addCriterion("SORT_ARTICLE_ID not in", values, "sortArticleId");
            return (Criteria) this;
        }

        public Criteria andSortArticleIdBetween(Long value1, Long value2) {
            addCriterion("SORT_ARTICLE_ID between", value1, value2, "sortArticleId");
            return (Criteria) this;
        }

        public Criteria andSortArticleIdNotBetween(Long value1, Long value2) {
            addCriterion("SORT_ARTICLE_ID not between", value1, value2, "sortArticleId");
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

        public Criteria andArticleTypeIsNull() {
            addCriterion("ARTICLE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andArticleTypeIsNotNull() {
            addCriterion("ARTICLE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andArticleTypeEqualTo(Integer value) {
            addCriterion("ARTICLE_TYPE =", value, "articleType");
            return (Criteria) this;
        }

        public Criteria andArticleTypeNotEqualTo(Integer value) {
            addCriterion("ARTICLE_TYPE <>", value, "articleType");
            return (Criteria) this;
        }

        public Criteria andArticleTypeGreaterThan(Integer value) {
            addCriterion("ARTICLE_TYPE >", value, "articleType");
            return (Criteria) this;
        }

        public Criteria andArticleTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("ARTICLE_TYPE >=", value, "articleType");
            return (Criteria) this;
        }

        public Criteria andArticleTypeLessThan(Integer value) {
            addCriterion("ARTICLE_TYPE <", value, "articleType");
            return (Criteria) this;
        }

        public Criteria andArticleTypeLessThanOrEqualTo(Integer value) {
            addCriterion("ARTICLE_TYPE <=", value, "articleType");
            return (Criteria) this;
        }

        public Criteria andArticleTypeIn(List<Integer> values) {
            addCriterion("ARTICLE_TYPE in", values, "articleType");
            return (Criteria) this;
        }

        public Criteria andArticleTypeNotIn(List<Integer> values) {
            addCriterion("ARTICLE_TYPE not in", values, "articleType");
            return (Criteria) this;
        }

        public Criteria andArticleTypeBetween(Integer value1, Integer value2) {
            addCriterion("ARTICLE_TYPE between", value1, value2, "articleType");
            return (Criteria) this;
        }

        public Criteria andArticleTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("ARTICLE_TYPE not between", value1, value2, "articleType");
            return (Criteria) this;
        }

        public Criteria andArticleUpIsNull() {
            addCriterion("ARTICLE_UP is null");
            return (Criteria) this;
        }

        public Criteria andArticleUpIsNotNull() {
            addCriterion("ARTICLE_UP is not null");
            return (Criteria) this;
        }

        public Criteria andArticleUpEqualTo(Integer value) {
            addCriterion("ARTICLE_UP =", value, "articleUp");
            return (Criteria) this;
        }

        public Criteria andArticleUpNotEqualTo(Integer value) {
            addCriterion("ARTICLE_UP <>", value, "articleUp");
            return (Criteria) this;
        }

        public Criteria andArticleUpGreaterThan(Integer value) {
            addCriterion("ARTICLE_UP >", value, "articleUp");
            return (Criteria) this;
        }

        public Criteria andArticleUpGreaterThanOrEqualTo(Integer value) {
            addCriterion("ARTICLE_UP >=", value, "articleUp");
            return (Criteria) this;
        }

        public Criteria andArticleUpLessThan(Integer value) {
            addCriterion("ARTICLE_UP <", value, "articleUp");
            return (Criteria) this;
        }

        public Criteria andArticleUpLessThanOrEqualTo(Integer value) {
            addCriterion("ARTICLE_UP <=", value, "articleUp");
            return (Criteria) this;
        }

        public Criteria andArticleUpIn(List<Integer> values) {
            addCriterion("ARTICLE_UP in", values, "articleUp");
            return (Criteria) this;
        }

        public Criteria andArticleUpNotIn(List<Integer> values) {
            addCriterion("ARTICLE_UP not in", values, "articleUp");
            return (Criteria) this;
        }

        public Criteria andArticleUpBetween(Integer value1, Integer value2) {
            addCriterion("ARTICLE_UP between", value1, value2, "articleUp");
            return (Criteria) this;
        }

        public Criteria andArticleUpNotBetween(Integer value1, Integer value2) {
            addCriterion("ARTICLE_UP not between", value1, value2, "articleUp");
            return (Criteria) this;
        }

        public Criteria andArticleSupportIsNull() {
            addCriterion("ARTICLE_SUPPORT is null");
            return (Criteria) this;
        }

        public Criteria andArticleSupportIsNotNull() {
            addCriterion("ARTICLE_SUPPORT is not null");
            return (Criteria) this;
        }

        public Criteria andArticleSupportEqualTo(Integer value) {
            addCriterion("ARTICLE_SUPPORT =", value, "articleSupport");
            return (Criteria) this;
        }

        public Criteria andArticleSupportNotEqualTo(Integer value) {
            addCriterion("ARTICLE_SUPPORT <>", value, "articleSupport");
            return (Criteria) this;
        }

        public Criteria andArticleSupportGreaterThan(Integer value) {
            addCriterion("ARTICLE_SUPPORT >", value, "articleSupport");
            return (Criteria) this;
        }

        public Criteria andArticleSupportGreaterThanOrEqualTo(Integer value) {
            addCriterion("ARTICLE_SUPPORT >=", value, "articleSupport");
            return (Criteria) this;
        }

        public Criteria andArticleSupportLessThan(Integer value) {
            addCriterion("ARTICLE_SUPPORT <", value, "articleSupport");
            return (Criteria) this;
        }

        public Criteria andArticleSupportLessThanOrEqualTo(Integer value) {
            addCriterion("ARTICLE_SUPPORT <=", value, "articleSupport");
            return (Criteria) this;
        }

        public Criteria andArticleSupportIn(List<Integer> values) {
            addCriterion("ARTICLE_SUPPORT in", values, "articleSupport");
            return (Criteria) this;
        }

        public Criteria andArticleSupportNotIn(List<Integer> values) {
            addCriterion("ARTICLE_SUPPORT not in", values, "articleSupport");
            return (Criteria) this;
        }

        public Criteria andArticleSupportBetween(Integer value1, Integer value2) {
            addCriterion("ARTICLE_SUPPORT between", value1, value2, "articleSupport");
            return (Criteria) this;
        }

        public Criteria andArticleSupportNotBetween(Integer value1, Integer value2) {
            addCriterion("ARTICLE_SUPPORT not between", value1, value2, "articleSupport");
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