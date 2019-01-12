package org.nix.zpbs.model;

import java.util.ArrayList;
import java.util.List;

public class SecretMessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SecretMessageExample() {
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

        public Criteria andSendIdIsNull() {
            addCriterion("SEND_ID is null");
            return (Criteria) this;
        }

        public Criteria andSendIdIsNotNull() {
            addCriterion("SEND_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSendIdEqualTo(Long value) {
            addCriterion("SEND_ID =", value, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdNotEqualTo(Long value) {
            addCriterion("SEND_ID <>", value, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdGreaterThan(Long value) {
            addCriterion("SEND_ID >", value, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdGreaterThanOrEqualTo(Long value) {
            addCriterion("SEND_ID >=", value, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdLessThan(Long value) {
            addCriterion("SEND_ID <", value, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdLessThanOrEqualTo(Long value) {
            addCriterion("SEND_ID <=", value, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdIn(List<Long> values) {
            addCriterion("SEND_ID in", values, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdNotIn(List<Long> values) {
            addCriterion("SEND_ID not in", values, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdBetween(Long value1, Long value2) {
            addCriterion("SEND_ID between", value1, value2, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdNotBetween(Long value1, Long value2) {
            addCriterion("SEND_ID not between", value1, value2, "sendId");
            return (Criteria) this;
        }

        public Criteria andReceiveIdIsNull() {
            addCriterion("RECEIVE_ID is null");
            return (Criteria) this;
        }

        public Criteria andReceiveIdIsNotNull() {
            addCriterion("RECEIVE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveIdEqualTo(Long value) {
            addCriterion("RECEIVE_ID =", value, "receiveId");
            return (Criteria) this;
        }

        public Criteria andReceiveIdNotEqualTo(Long value) {
            addCriterion("RECEIVE_ID <>", value, "receiveId");
            return (Criteria) this;
        }

        public Criteria andReceiveIdGreaterThan(Long value) {
            addCriterion("RECEIVE_ID >", value, "receiveId");
            return (Criteria) this;
        }

        public Criteria andReceiveIdGreaterThanOrEqualTo(Long value) {
            addCriterion("RECEIVE_ID >=", value, "receiveId");
            return (Criteria) this;
        }

        public Criteria andReceiveIdLessThan(Long value) {
            addCriterion("RECEIVE_ID <", value, "receiveId");
            return (Criteria) this;
        }

        public Criteria andReceiveIdLessThanOrEqualTo(Long value) {
            addCriterion("RECEIVE_ID <=", value, "receiveId");
            return (Criteria) this;
        }

        public Criteria andReceiveIdIn(List<Long> values) {
            addCriterion("RECEIVE_ID in", values, "receiveId");
            return (Criteria) this;
        }

        public Criteria andReceiveIdNotIn(List<Long> values) {
            addCriterion("RECEIVE_ID not in", values, "receiveId");
            return (Criteria) this;
        }

        public Criteria andReceiveIdBetween(Long value1, Long value2) {
            addCriterion("RECEIVE_ID between", value1, value2, "receiveId");
            return (Criteria) this;
        }

        public Criteria andReceiveIdNotBetween(Long value1, Long value2) {
            addCriterion("RECEIVE_ID not between", value1, value2, "receiveId");
            return (Criteria) this;
        }

        public Criteria andMessageTopicIsNull() {
            addCriterion("MESSAGE_TOPIC is null");
            return (Criteria) this;
        }

        public Criteria andMessageTopicIsNotNull() {
            addCriterion("MESSAGE_TOPIC is not null");
            return (Criteria) this;
        }

        public Criteria andMessageTopicEqualTo(String value) {
            addCriterion("MESSAGE_TOPIC =", value, "messageTopic");
            return (Criteria) this;
        }

        public Criteria andMessageTopicNotEqualTo(String value) {
            addCriterion("MESSAGE_TOPIC <>", value, "messageTopic");
            return (Criteria) this;
        }

        public Criteria andMessageTopicGreaterThan(String value) {
            addCriterion("MESSAGE_TOPIC >", value, "messageTopic");
            return (Criteria) this;
        }

        public Criteria andMessageTopicGreaterThanOrEqualTo(String value) {
            addCriterion("MESSAGE_TOPIC >=", value, "messageTopic");
            return (Criteria) this;
        }

        public Criteria andMessageTopicLessThan(String value) {
            addCriterion("MESSAGE_TOPIC <", value, "messageTopic");
            return (Criteria) this;
        }

        public Criteria andMessageTopicLessThanOrEqualTo(String value) {
            addCriterion("MESSAGE_TOPIC <=", value, "messageTopic");
            return (Criteria) this;
        }

        public Criteria andMessageTopicLike(String value) {
            addCriterion("MESSAGE_TOPIC like", value, "messageTopic");
            return (Criteria) this;
        }

        public Criteria andMessageTopicNotLike(String value) {
            addCriterion("MESSAGE_TOPIC not like", value, "messageTopic");
            return (Criteria) this;
        }

        public Criteria andMessageTopicIn(List<String> values) {
            addCriterion("MESSAGE_TOPIC in", values, "messageTopic");
            return (Criteria) this;
        }

        public Criteria andMessageTopicNotIn(List<String> values) {
            addCriterion("MESSAGE_TOPIC not in", values, "messageTopic");
            return (Criteria) this;
        }

        public Criteria andMessageTopicBetween(String value1, String value2) {
            addCriterion("MESSAGE_TOPIC between", value1, value2, "messageTopic");
            return (Criteria) this;
        }

        public Criteria andMessageTopicNotBetween(String value1, String value2) {
            addCriterion("MESSAGE_TOPIC not between", value1, value2, "messageTopic");
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