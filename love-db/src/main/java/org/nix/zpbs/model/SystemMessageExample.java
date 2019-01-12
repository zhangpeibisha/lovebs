package org.nix.zpbs.model;

import java.util.ArrayList;
import java.util.List;

public class SystemMessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SystemMessageExample() {
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

        public Criteria andGroupIdIsNull() {
            addCriterion("GROUP_ID is null");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNotNull() {
            addCriterion("GROUP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andGroupIdEqualTo(Integer value) {
            addCriterion("GROUP_ID =", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotEqualTo(Integer value) {
            addCriterion("GROUP_ID <>", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThan(Integer value) {
            addCriterion("GROUP_ID >", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("GROUP_ID >=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThan(Integer value) {
            addCriterion("GROUP_ID <", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThanOrEqualTo(Integer value) {
            addCriterion("GROUP_ID <=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdIn(List<Integer> values) {
            addCriterion("GROUP_ID in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotIn(List<Integer> values) {
            addCriterion("GROUP_ID not in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdBetween(Integer value1, Integer value2) {
            addCriterion("GROUP_ID between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotBetween(Integer value1, Integer value2) {
            addCriterion("GROUP_ID not between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andSendDefaultIsNull() {
            addCriterion("SEND_DEFAULT is null");
            return (Criteria) this;
        }

        public Criteria andSendDefaultIsNotNull() {
            addCriterion("SEND_DEFAULT is not null");
            return (Criteria) this;
        }

        public Criteria andSendDefaultEqualTo(Long value) {
            addCriterion("SEND_DEFAULT =", value, "sendDefault");
            return (Criteria) this;
        }

        public Criteria andSendDefaultNotEqualTo(Long value) {
            addCriterion("SEND_DEFAULT <>", value, "sendDefault");
            return (Criteria) this;
        }

        public Criteria andSendDefaultGreaterThan(Long value) {
            addCriterion("SEND_DEFAULT >", value, "sendDefault");
            return (Criteria) this;
        }

        public Criteria andSendDefaultGreaterThanOrEqualTo(Long value) {
            addCriterion("SEND_DEFAULT >=", value, "sendDefault");
            return (Criteria) this;
        }

        public Criteria andSendDefaultLessThan(Long value) {
            addCriterion("SEND_DEFAULT <", value, "sendDefault");
            return (Criteria) this;
        }

        public Criteria andSendDefaultLessThanOrEqualTo(Long value) {
            addCriterion("SEND_DEFAULT <=", value, "sendDefault");
            return (Criteria) this;
        }

        public Criteria andSendDefaultIn(List<Long> values) {
            addCriterion("SEND_DEFAULT in", values, "sendDefault");
            return (Criteria) this;
        }

        public Criteria andSendDefaultNotIn(List<Long> values) {
            addCriterion("SEND_DEFAULT not in", values, "sendDefault");
            return (Criteria) this;
        }

        public Criteria andSendDefaultBetween(Long value1, Long value2) {
            addCriterion("SEND_DEFAULT between", value1, value2, "sendDefault");
            return (Criteria) this;
        }

        public Criteria andSendDefaultNotBetween(Long value1, Long value2) {
            addCriterion("SEND_DEFAULT not between", value1, value2, "sendDefault");
            return (Criteria) this;
        }

        public Criteria andSystemTopicIsNull() {
            addCriterion("SYSTEM_TOPIC is null");
            return (Criteria) this;
        }

        public Criteria andSystemTopicIsNotNull() {
            addCriterion("SYSTEM_TOPIC is not null");
            return (Criteria) this;
        }

        public Criteria andSystemTopicEqualTo(String value) {
            addCriterion("SYSTEM_TOPIC =", value, "systemTopic");
            return (Criteria) this;
        }

        public Criteria andSystemTopicNotEqualTo(String value) {
            addCriterion("SYSTEM_TOPIC <>", value, "systemTopic");
            return (Criteria) this;
        }

        public Criteria andSystemTopicGreaterThan(String value) {
            addCriterion("SYSTEM_TOPIC >", value, "systemTopic");
            return (Criteria) this;
        }

        public Criteria andSystemTopicGreaterThanOrEqualTo(String value) {
            addCriterion("SYSTEM_TOPIC >=", value, "systemTopic");
            return (Criteria) this;
        }

        public Criteria andSystemTopicLessThan(String value) {
            addCriterion("SYSTEM_TOPIC <", value, "systemTopic");
            return (Criteria) this;
        }

        public Criteria andSystemTopicLessThanOrEqualTo(String value) {
            addCriterion("SYSTEM_TOPIC <=", value, "systemTopic");
            return (Criteria) this;
        }

        public Criteria andSystemTopicLike(String value) {
            addCriterion("SYSTEM_TOPIC like", value, "systemTopic");
            return (Criteria) this;
        }

        public Criteria andSystemTopicNotLike(String value) {
            addCriterion("SYSTEM_TOPIC not like", value, "systemTopic");
            return (Criteria) this;
        }

        public Criteria andSystemTopicIn(List<String> values) {
            addCriterion("SYSTEM_TOPIC in", values, "systemTopic");
            return (Criteria) this;
        }

        public Criteria andSystemTopicNotIn(List<String> values) {
            addCriterion("SYSTEM_TOPIC not in", values, "systemTopic");
            return (Criteria) this;
        }

        public Criteria andSystemTopicBetween(String value1, String value2) {
            addCriterion("SYSTEM_TOPIC between", value1, value2, "systemTopic");
            return (Criteria) this;
        }

        public Criteria andSystemTopicNotBetween(String value1, String value2) {
            addCriterion("SYSTEM_TOPIC not between", value1, value2, "systemTopic");
            return (Criteria) this;
        }

        public Criteria andSystemContentIsNull() {
            addCriterion("SYSTEM_CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andSystemContentIsNotNull() {
            addCriterion("SYSTEM_CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andSystemContentEqualTo(String value) {
            addCriterion("SYSTEM_CONTENT =", value, "systemContent");
            return (Criteria) this;
        }

        public Criteria andSystemContentNotEqualTo(String value) {
            addCriterion("SYSTEM_CONTENT <>", value, "systemContent");
            return (Criteria) this;
        }

        public Criteria andSystemContentGreaterThan(String value) {
            addCriterion("SYSTEM_CONTENT >", value, "systemContent");
            return (Criteria) this;
        }

        public Criteria andSystemContentGreaterThanOrEqualTo(String value) {
            addCriterion("SYSTEM_CONTENT >=", value, "systemContent");
            return (Criteria) this;
        }

        public Criteria andSystemContentLessThan(String value) {
            addCriterion("SYSTEM_CONTENT <", value, "systemContent");
            return (Criteria) this;
        }

        public Criteria andSystemContentLessThanOrEqualTo(String value) {
            addCriterion("SYSTEM_CONTENT <=", value, "systemContent");
            return (Criteria) this;
        }

        public Criteria andSystemContentLike(String value) {
            addCriterion("SYSTEM_CONTENT like", value, "systemContent");
            return (Criteria) this;
        }

        public Criteria andSystemContentNotLike(String value) {
            addCriterion("SYSTEM_CONTENT not like", value, "systemContent");
            return (Criteria) this;
        }

        public Criteria andSystemContentIn(List<String> values) {
            addCriterion("SYSTEM_CONTENT in", values, "systemContent");
            return (Criteria) this;
        }

        public Criteria andSystemContentNotIn(List<String> values) {
            addCriterion("SYSTEM_CONTENT not in", values, "systemContent");
            return (Criteria) this;
        }

        public Criteria andSystemContentBetween(String value1, String value2) {
            addCriterion("SYSTEM_CONTENT between", value1, value2, "systemContent");
            return (Criteria) this;
        }

        public Criteria andSystemContentNotBetween(String value1, String value2) {
            addCriterion("SYSTEM_CONTENT not between", value1, value2, "systemContent");
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