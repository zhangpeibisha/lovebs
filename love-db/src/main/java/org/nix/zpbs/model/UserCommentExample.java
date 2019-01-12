package org.nix.zpbs.model;

import java.util.ArrayList;
import java.util.List;

public class UserCommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserCommentExample() {
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

        public Criteria andCommitIdIsNull() {
            addCriterion("COMMIT_ID is null");
            return (Criteria) this;
        }

        public Criteria andCommitIdIsNotNull() {
            addCriterion("COMMIT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCommitIdEqualTo(Long value) {
            addCriterion("COMMIT_ID =", value, "commitId");
            return (Criteria) this;
        }

        public Criteria andCommitIdNotEqualTo(Long value) {
            addCriterion("COMMIT_ID <>", value, "commitId");
            return (Criteria) this;
        }

        public Criteria andCommitIdGreaterThan(Long value) {
            addCriterion("COMMIT_ID >", value, "commitId");
            return (Criteria) this;
        }

        public Criteria andCommitIdGreaterThanOrEqualTo(Long value) {
            addCriterion("COMMIT_ID >=", value, "commitId");
            return (Criteria) this;
        }

        public Criteria andCommitIdLessThan(Long value) {
            addCriterion("COMMIT_ID <", value, "commitId");
            return (Criteria) this;
        }

        public Criteria andCommitIdLessThanOrEqualTo(Long value) {
            addCriterion("COMMIT_ID <=", value, "commitId");
            return (Criteria) this;
        }

        public Criteria andCommitIdIn(List<Long> values) {
            addCriterion("COMMIT_ID in", values, "commitId");
            return (Criteria) this;
        }

        public Criteria andCommitIdNotIn(List<Long> values) {
            addCriterion("COMMIT_ID not in", values, "commitId");
            return (Criteria) this;
        }

        public Criteria andCommitIdBetween(Long value1, Long value2) {
            addCriterion("COMMIT_ID between", value1, value2, "commitId");
            return (Criteria) this;
        }

        public Criteria andCommitIdNotBetween(Long value1, Long value2) {
            addCriterion("COMMIT_ID not between", value1, value2, "commitId");
            return (Criteria) this;
        }

        public Criteria andCommitContentIsNull() {
            addCriterion("COMMIT_CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andCommitContentIsNotNull() {
            addCriterion("COMMIT_CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andCommitContentEqualTo(String value) {
            addCriterion("COMMIT_CONTENT =", value, "commitContent");
            return (Criteria) this;
        }

        public Criteria andCommitContentNotEqualTo(String value) {
            addCriterion("COMMIT_CONTENT <>", value, "commitContent");
            return (Criteria) this;
        }

        public Criteria andCommitContentGreaterThan(String value) {
            addCriterion("COMMIT_CONTENT >", value, "commitContent");
            return (Criteria) this;
        }

        public Criteria andCommitContentGreaterThanOrEqualTo(String value) {
            addCriterion("COMMIT_CONTENT >=", value, "commitContent");
            return (Criteria) this;
        }

        public Criteria andCommitContentLessThan(String value) {
            addCriterion("COMMIT_CONTENT <", value, "commitContent");
            return (Criteria) this;
        }

        public Criteria andCommitContentLessThanOrEqualTo(String value) {
            addCriterion("COMMIT_CONTENT <=", value, "commitContent");
            return (Criteria) this;
        }

        public Criteria andCommitContentLike(String value) {
            addCriterion("COMMIT_CONTENT like", value, "commitContent");
            return (Criteria) this;
        }

        public Criteria andCommitContentNotLike(String value) {
            addCriterion("COMMIT_CONTENT not like", value, "commitContent");
            return (Criteria) this;
        }

        public Criteria andCommitContentIn(List<String> values) {
            addCriterion("COMMIT_CONTENT in", values, "commitContent");
            return (Criteria) this;
        }

        public Criteria andCommitContentNotIn(List<String> values) {
            addCriterion("COMMIT_CONTENT not in", values, "commitContent");
            return (Criteria) this;
        }

        public Criteria andCommitContentBetween(String value1, String value2) {
            addCriterion("COMMIT_CONTENT between", value1, value2, "commitContent");
            return (Criteria) this;
        }

        public Criteria andCommitContentNotBetween(String value1, String value2) {
            addCriterion("COMMIT_CONTENT not between", value1, value2, "commitContent");
            return (Criteria) this;
        }

        public Criteria andCommitUserIdIsNull() {
            addCriterion("COMMIT_USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andCommitUserIdIsNotNull() {
            addCriterion("COMMIT_USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCommitUserIdEqualTo(Long value) {
            addCriterion("COMMIT_USER_ID =", value, "commitUserId");
            return (Criteria) this;
        }

        public Criteria andCommitUserIdNotEqualTo(Long value) {
            addCriterion("COMMIT_USER_ID <>", value, "commitUserId");
            return (Criteria) this;
        }

        public Criteria andCommitUserIdGreaterThan(Long value) {
            addCriterion("COMMIT_USER_ID >", value, "commitUserId");
            return (Criteria) this;
        }

        public Criteria andCommitUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("COMMIT_USER_ID >=", value, "commitUserId");
            return (Criteria) this;
        }

        public Criteria andCommitUserIdLessThan(Long value) {
            addCriterion("COMMIT_USER_ID <", value, "commitUserId");
            return (Criteria) this;
        }

        public Criteria andCommitUserIdLessThanOrEqualTo(Long value) {
            addCriterion("COMMIT_USER_ID <=", value, "commitUserId");
            return (Criteria) this;
        }

        public Criteria andCommitUserIdIn(List<Long> values) {
            addCriterion("COMMIT_USER_ID in", values, "commitUserId");
            return (Criteria) this;
        }

        public Criteria andCommitUserIdNotIn(List<Long> values) {
            addCriterion("COMMIT_USER_ID not in", values, "commitUserId");
            return (Criteria) this;
        }

        public Criteria andCommitUserIdBetween(Long value1, Long value2) {
            addCriterion("COMMIT_USER_ID between", value1, value2, "commitUserId");
            return (Criteria) this;
        }

        public Criteria andCommitUserIdNotBetween(Long value1, Long value2) {
            addCriterion("COMMIT_USER_ID not between", value1, value2, "commitUserId");
            return (Criteria) this;
        }

        public Criteria andCommitTimeIsNull() {
            addCriterion("COMMIT_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCommitTimeIsNotNull() {
            addCriterion("COMMIT_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCommitTimeEqualTo(Long value) {
            addCriterion("COMMIT_TIME =", value, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeNotEqualTo(Long value) {
            addCriterion("COMMIT_TIME <>", value, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeGreaterThan(Long value) {
            addCriterion("COMMIT_TIME >", value, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("COMMIT_TIME >=", value, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeLessThan(Long value) {
            addCriterion("COMMIT_TIME <", value, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeLessThanOrEqualTo(Long value) {
            addCriterion("COMMIT_TIME <=", value, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeIn(List<Long> values) {
            addCriterion("COMMIT_TIME in", values, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeNotIn(List<Long> values) {
            addCriterion("COMMIT_TIME not in", values, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeBetween(Long value1, Long value2) {
            addCriterion("COMMIT_TIME between", value1, value2, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeNotBetween(Long value1, Long value2) {
            addCriterion("COMMIT_TIME not between", value1, value2, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitIpIsNull() {
            addCriterion("COMMIT_IP is null");
            return (Criteria) this;
        }

        public Criteria andCommitIpIsNotNull() {
            addCriterion("COMMIT_IP is not null");
            return (Criteria) this;
        }

        public Criteria andCommitIpEqualTo(String value) {
            addCriterion("COMMIT_IP =", value, "commitIp");
            return (Criteria) this;
        }

        public Criteria andCommitIpNotEqualTo(String value) {
            addCriterion("COMMIT_IP <>", value, "commitIp");
            return (Criteria) this;
        }

        public Criteria andCommitIpGreaterThan(String value) {
            addCriterion("COMMIT_IP >", value, "commitIp");
            return (Criteria) this;
        }

        public Criteria andCommitIpGreaterThanOrEqualTo(String value) {
            addCriterion("COMMIT_IP >=", value, "commitIp");
            return (Criteria) this;
        }

        public Criteria andCommitIpLessThan(String value) {
            addCriterion("COMMIT_IP <", value, "commitIp");
            return (Criteria) this;
        }

        public Criteria andCommitIpLessThanOrEqualTo(String value) {
            addCriterion("COMMIT_IP <=", value, "commitIp");
            return (Criteria) this;
        }

        public Criteria andCommitIpLike(String value) {
            addCriterion("COMMIT_IP like", value, "commitIp");
            return (Criteria) this;
        }

        public Criteria andCommitIpNotLike(String value) {
            addCriterion("COMMIT_IP not like", value, "commitIp");
            return (Criteria) this;
        }

        public Criteria andCommitIpIn(List<String> values) {
            addCriterion("COMMIT_IP in", values, "commitIp");
            return (Criteria) this;
        }

        public Criteria andCommitIpNotIn(List<String> values) {
            addCriterion("COMMIT_IP not in", values, "commitIp");
            return (Criteria) this;
        }

        public Criteria andCommitIpBetween(String value1, String value2) {
            addCriterion("COMMIT_IP between", value1, value2, "commitIp");
            return (Criteria) this;
        }

        public Criteria andCommitIpNotBetween(String value1, String value2) {
            addCriterion("COMMIT_IP not between", value1, value2, "commitIp");
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