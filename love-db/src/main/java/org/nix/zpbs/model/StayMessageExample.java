package org.nix.zpbs.model;

import java.util.ArrayList;
import java.util.List;

public class StayMessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StayMessageExample() {
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

        public Criteria andStayUserIdIsNull() {
            addCriterion("STAY_USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andStayUserIdIsNotNull() {
            addCriterion("STAY_USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andStayUserIdEqualTo(Long value) {
            addCriterion("STAY_USER_ID =", value, "stayUserId");
            return (Criteria) this;
        }

        public Criteria andStayUserIdNotEqualTo(Long value) {
            addCriterion("STAY_USER_ID <>", value, "stayUserId");
            return (Criteria) this;
        }

        public Criteria andStayUserIdGreaterThan(Long value) {
            addCriterion("STAY_USER_ID >", value, "stayUserId");
            return (Criteria) this;
        }

        public Criteria andStayUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("STAY_USER_ID >=", value, "stayUserId");
            return (Criteria) this;
        }

        public Criteria andStayUserIdLessThan(Long value) {
            addCriterion("STAY_USER_ID <", value, "stayUserId");
            return (Criteria) this;
        }

        public Criteria andStayUserIdLessThanOrEqualTo(Long value) {
            addCriterion("STAY_USER_ID <=", value, "stayUserId");
            return (Criteria) this;
        }

        public Criteria andStayUserIdIn(List<Long> values) {
            addCriterion("STAY_USER_ID in", values, "stayUserId");
            return (Criteria) this;
        }

        public Criteria andStayUserIdNotIn(List<Long> values) {
            addCriterion("STAY_USER_ID not in", values, "stayUserId");
            return (Criteria) this;
        }

        public Criteria andStayUserIdBetween(Long value1, Long value2) {
            addCriterion("STAY_USER_ID between", value1, value2, "stayUserId");
            return (Criteria) this;
        }

        public Criteria andStayUserIdNotBetween(Long value1, Long value2) {
            addCriterion("STAY_USER_ID not between", value1, value2, "stayUserId");
            return (Criteria) this;
        }

        public Criteria andMessageContentIsNull() {
            addCriterion("MESSAGE_CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andMessageContentIsNotNull() {
            addCriterion("MESSAGE_CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andMessageContentEqualTo(String value) {
            addCriterion("MESSAGE_CONTENT =", value, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentNotEqualTo(String value) {
            addCriterion("MESSAGE_CONTENT <>", value, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentGreaterThan(String value) {
            addCriterion("MESSAGE_CONTENT >", value, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentGreaterThanOrEqualTo(String value) {
            addCriterion("MESSAGE_CONTENT >=", value, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentLessThan(String value) {
            addCriterion("MESSAGE_CONTENT <", value, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentLessThanOrEqualTo(String value) {
            addCriterion("MESSAGE_CONTENT <=", value, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentLike(String value) {
            addCriterion("MESSAGE_CONTENT like", value, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentNotLike(String value) {
            addCriterion("MESSAGE_CONTENT not like", value, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentIn(List<String> values) {
            addCriterion("MESSAGE_CONTENT in", values, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentNotIn(List<String> values) {
            addCriterion("MESSAGE_CONTENT not in", values, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentBetween(String value1, String value2) {
            addCriterion("MESSAGE_CONTENT between", value1, value2, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentNotBetween(String value1, String value2) {
            addCriterion("MESSAGE_CONTENT not between", value1, value2, "messageContent");
            return (Criteria) this;
        }

        public Criteria andStayUserIpIsNull() {
            addCriterion("STAY_USER_IP is null");
            return (Criteria) this;
        }

        public Criteria andStayUserIpIsNotNull() {
            addCriterion("STAY_USER_IP is not null");
            return (Criteria) this;
        }

        public Criteria andStayUserIpEqualTo(String value) {
            addCriterion("STAY_USER_IP =", value, "stayUserIp");
            return (Criteria) this;
        }

        public Criteria andStayUserIpNotEqualTo(String value) {
            addCriterion("STAY_USER_IP <>", value, "stayUserIp");
            return (Criteria) this;
        }

        public Criteria andStayUserIpGreaterThan(String value) {
            addCriterion("STAY_USER_IP >", value, "stayUserIp");
            return (Criteria) this;
        }

        public Criteria andStayUserIpGreaterThanOrEqualTo(String value) {
            addCriterion("STAY_USER_IP >=", value, "stayUserIp");
            return (Criteria) this;
        }

        public Criteria andStayUserIpLessThan(String value) {
            addCriterion("STAY_USER_IP <", value, "stayUserIp");
            return (Criteria) this;
        }

        public Criteria andStayUserIpLessThanOrEqualTo(String value) {
            addCriterion("STAY_USER_IP <=", value, "stayUserIp");
            return (Criteria) this;
        }

        public Criteria andStayUserIpLike(String value) {
            addCriterion("STAY_USER_IP like", value, "stayUserIp");
            return (Criteria) this;
        }

        public Criteria andStayUserIpNotLike(String value) {
            addCriterion("STAY_USER_IP not like", value, "stayUserIp");
            return (Criteria) this;
        }

        public Criteria andStayUserIpIn(List<String> values) {
            addCriterion("STAY_USER_IP in", values, "stayUserIp");
            return (Criteria) this;
        }

        public Criteria andStayUserIpNotIn(List<String> values) {
            addCriterion("STAY_USER_IP not in", values, "stayUserIp");
            return (Criteria) this;
        }

        public Criteria andStayUserIpBetween(String value1, String value2) {
            addCriterion("STAY_USER_IP between", value1, value2, "stayUserIp");
            return (Criteria) this;
        }

        public Criteria andStayUserIpNotBetween(String value1, String value2) {
            addCriterion("STAY_USER_IP not between", value1, value2, "stayUserIp");
            return (Criteria) this;
        }

        public Criteria andMessageStayTimeIsNull() {
            addCriterion("MESSAGE_STAY_TIME is null");
            return (Criteria) this;
        }

        public Criteria andMessageStayTimeIsNotNull() {
            addCriterion("MESSAGE_STAY_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andMessageStayTimeEqualTo(Long value) {
            addCriterion("MESSAGE_STAY_TIME =", value, "messageStayTime");
            return (Criteria) this;
        }

        public Criteria andMessageStayTimeNotEqualTo(Long value) {
            addCriterion("MESSAGE_STAY_TIME <>", value, "messageStayTime");
            return (Criteria) this;
        }

        public Criteria andMessageStayTimeGreaterThan(Long value) {
            addCriterion("MESSAGE_STAY_TIME >", value, "messageStayTime");
            return (Criteria) this;
        }

        public Criteria andMessageStayTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("MESSAGE_STAY_TIME >=", value, "messageStayTime");
            return (Criteria) this;
        }

        public Criteria andMessageStayTimeLessThan(Long value) {
            addCriterion("MESSAGE_STAY_TIME <", value, "messageStayTime");
            return (Criteria) this;
        }

        public Criteria andMessageStayTimeLessThanOrEqualTo(Long value) {
            addCriterion("MESSAGE_STAY_TIME <=", value, "messageStayTime");
            return (Criteria) this;
        }

        public Criteria andMessageStayTimeIn(List<Long> values) {
            addCriterion("MESSAGE_STAY_TIME in", values, "messageStayTime");
            return (Criteria) this;
        }

        public Criteria andMessageStayTimeNotIn(List<Long> values) {
            addCriterion("MESSAGE_STAY_TIME not in", values, "messageStayTime");
            return (Criteria) this;
        }

        public Criteria andMessageStayTimeBetween(Long value1, Long value2) {
            addCriterion("MESSAGE_STAY_TIME between", value1, value2, "messageStayTime");
            return (Criteria) this;
        }

        public Criteria andMessageStayTimeNotBetween(Long value1, Long value2) {
            addCriterion("MESSAGE_STAY_TIME not between", value1, value2, "messageStayTime");
            return (Criteria) this;
        }

        public Criteria andPlaceIsNull() {
            addCriterion("PLACE is null");
            return (Criteria) this;
        }

        public Criteria andPlaceIsNotNull() {
            addCriterion("PLACE is not null");
            return (Criteria) this;
        }

        public Criteria andPlaceEqualTo(String value) {
            addCriterion("PLACE =", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceNotEqualTo(String value) {
            addCriterion("PLACE <>", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceGreaterThan(String value) {
            addCriterion("PLACE >", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("PLACE >=", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceLessThan(String value) {
            addCriterion("PLACE <", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceLessThanOrEqualTo(String value) {
            addCriterion("PLACE <=", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceLike(String value) {
            addCriterion("PLACE like", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceNotLike(String value) {
            addCriterion("PLACE not like", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceIn(List<String> values) {
            addCriterion("PLACE in", values, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceNotIn(List<String> values) {
            addCriterion("PLACE not in", values, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceBetween(String value1, String value2) {
            addCriterion("PLACE between", value1, value2, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceNotBetween(String value1, String value2) {
            addCriterion("PLACE not between", value1, value2, "place");
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