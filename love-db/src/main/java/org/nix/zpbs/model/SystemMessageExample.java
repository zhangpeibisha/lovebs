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

        public Criteria andSystemIdIsNull() {
            addCriterion("system_id is null");
            return (Criteria) this;
        }

        public Criteria andSystemIdIsNotNull() {
            addCriterion("system_id is not null");
            return (Criteria) this;
        }

        public Criteria andSystemIdEqualTo(Integer value) {
            addCriterion("system_id =", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotEqualTo(Integer value) {
            addCriterion("system_id <>", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdGreaterThan(Integer value) {
            addCriterion("system_id >", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("system_id >=", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdLessThan(Integer value) {
            addCriterion("system_id <", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdLessThanOrEqualTo(Integer value) {
            addCriterion("system_id <=", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdIn(List<Integer> values) {
            addCriterion("system_id in", values, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotIn(List<Integer> values) {
            addCriterion("system_id not in", values, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdBetween(Integer value1, Integer value2) {
            addCriterion("system_id between", value1, value2, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotBetween(Integer value1, Integer value2) {
            addCriterion("system_id not between", value1, value2, "systemId");
            return (Criteria) this;
        }

        public Criteria andSendIdIsNull() {
            addCriterion("send_id is null");
            return (Criteria) this;
        }

        public Criteria andSendIdIsNotNull() {
            addCriterion("send_id is not null");
            return (Criteria) this;
        }

        public Criteria andSendIdEqualTo(Integer value) {
            addCriterion("send_id =", value, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdNotEqualTo(Integer value) {
            addCriterion("send_id <>", value, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdGreaterThan(Integer value) {
            addCriterion("send_id >", value, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("send_id >=", value, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdLessThan(Integer value) {
            addCriterion("send_id <", value, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdLessThanOrEqualTo(Integer value) {
            addCriterion("send_id <=", value, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdIn(List<Integer> values) {
            addCriterion("send_id in", values, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdNotIn(List<Integer> values) {
            addCriterion("send_id not in", values, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdBetween(Integer value1, Integer value2) {
            addCriterion("send_id between", value1, value2, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdNotBetween(Integer value1, Integer value2) {
            addCriterion("send_id not between", value1, value2, "sendId");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNull() {
            addCriterion("group_id is null");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNotNull() {
            addCriterion("group_id is not null");
            return (Criteria) this;
        }

        public Criteria andGroupIdEqualTo(Byte value) {
            addCriterion("group_id =", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotEqualTo(Byte value) {
            addCriterion("group_id <>", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThan(Byte value) {
            addCriterion("group_id >", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThanOrEqualTo(Byte value) {
            addCriterion("group_id >=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThan(Byte value) {
            addCriterion("group_id <", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThanOrEqualTo(Byte value) {
            addCriterion("group_id <=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdIn(List<Byte> values) {
            addCriterion("group_id in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotIn(List<Byte> values) {
            addCriterion("group_id not in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdBetween(Byte value1, Byte value2) {
            addCriterion("group_id between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotBetween(Byte value1, Byte value2) {
            addCriterion("group_id not between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andSendDefaultIsNull() {
            addCriterion("send_default is null");
            return (Criteria) this;
        }

        public Criteria andSendDefaultIsNotNull() {
            addCriterion("send_default is not null");
            return (Criteria) this;
        }

        public Criteria andSendDefaultEqualTo(Integer value) {
            addCriterion("send_default =", value, "sendDefault");
            return (Criteria) this;
        }

        public Criteria andSendDefaultNotEqualTo(Integer value) {
            addCriterion("send_default <>", value, "sendDefault");
            return (Criteria) this;
        }

        public Criteria andSendDefaultGreaterThan(Integer value) {
            addCriterion("send_default >", value, "sendDefault");
            return (Criteria) this;
        }

        public Criteria andSendDefaultGreaterThanOrEqualTo(Integer value) {
            addCriterion("send_default >=", value, "sendDefault");
            return (Criteria) this;
        }

        public Criteria andSendDefaultLessThan(Integer value) {
            addCriterion("send_default <", value, "sendDefault");
            return (Criteria) this;
        }

        public Criteria andSendDefaultLessThanOrEqualTo(Integer value) {
            addCriterion("send_default <=", value, "sendDefault");
            return (Criteria) this;
        }

        public Criteria andSendDefaultIn(List<Integer> values) {
            addCriterion("send_default in", values, "sendDefault");
            return (Criteria) this;
        }

        public Criteria andSendDefaultNotIn(List<Integer> values) {
            addCriterion("send_default not in", values, "sendDefault");
            return (Criteria) this;
        }

        public Criteria andSendDefaultBetween(Integer value1, Integer value2) {
            addCriterion("send_default between", value1, value2, "sendDefault");
            return (Criteria) this;
        }

        public Criteria andSendDefaultNotBetween(Integer value1, Integer value2) {
            addCriterion("send_default not between", value1, value2, "sendDefault");
            return (Criteria) this;
        }

        public Criteria andSystemTopicIsNull() {
            addCriterion("system_topic is null");
            return (Criteria) this;
        }

        public Criteria andSystemTopicIsNotNull() {
            addCriterion("system_topic is not null");
            return (Criteria) this;
        }

        public Criteria andSystemTopicEqualTo(String value) {
            addCriterion("system_topic =", value, "systemTopic");
            return (Criteria) this;
        }

        public Criteria andSystemTopicNotEqualTo(String value) {
            addCriterion("system_topic <>", value, "systemTopic");
            return (Criteria) this;
        }

        public Criteria andSystemTopicGreaterThan(String value) {
            addCriterion("system_topic >", value, "systemTopic");
            return (Criteria) this;
        }

        public Criteria andSystemTopicGreaterThanOrEqualTo(String value) {
            addCriterion("system_topic >=", value, "systemTopic");
            return (Criteria) this;
        }

        public Criteria andSystemTopicLessThan(String value) {
            addCriterion("system_topic <", value, "systemTopic");
            return (Criteria) this;
        }

        public Criteria andSystemTopicLessThanOrEqualTo(String value) {
            addCriterion("system_topic <=", value, "systemTopic");
            return (Criteria) this;
        }

        public Criteria andSystemTopicLike(String value) {
            addCriterion("system_topic like", value, "systemTopic");
            return (Criteria) this;
        }

        public Criteria andSystemTopicNotLike(String value) {
            addCriterion("system_topic not like", value, "systemTopic");
            return (Criteria) this;
        }

        public Criteria andSystemTopicIn(List<String> values) {
            addCriterion("system_topic in", values, "systemTopic");
            return (Criteria) this;
        }

        public Criteria andSystemTopicNotIn(List<String> values) {
            addCriterion("system_topic not in", values, "systemTopic");
            return (Criteria) this;
        }

        public Criteria andSystemTopicBetween(String value1, String value2) {
            addCriterion("system_topic between", value1, value2, "systemTopic");
            return (Criteria) this;
        }

        public Criteria andSystemTopicNotBetween(String value1, String value2) {
            addCriterion("system_topic not between", value1, value2, "systemTopic");
            return (Criteria) this;
        }

        public Criteria andSystemContentIsNull() {
            addCriterion("system_content is null");
            return (Criteria) this;
        }

        public Criteria andSystemContentIsNotNull() {
            addCriterion("system_content is not null");
            return (Criteria) this;
        }

        public Criteria andSystemContentEqualTo(String value) {
            addCriterion("system_content =", value, "systemContent");
            return (Criteria) this;
        }

        public Criteria andSystemContentNotEqualTo(String value) {
            addCriterion("system_content <>", value, "systemContent");
            return (Criteria) this;
        }

        public Criteria andSystemContentGreaterThan(String value) {
            addCriterion("system_content >", value, "systemContent");
            return (Criteria) this;
        }

        public Criteria andSystemContentGreaterThanOrEqualTo(String value) {
            addCriterion("system_content >=", value, "systemContent");
            return (Criteria) this;
        }

        public Criteria andSystemContentLessThan(String value) {
            addCriterion("system_content <", value, "systemContent");
            return (Criteria) this;
        }

        public Criteria andSystemContentLessThanOrEqualTo(String value) {
            addCriterion("system_content <=", value, "systemContent");
            return (Criteria) this;
        }

        public Criteria andSystemContentLike(String value) {
            addCriterion("system_content like", value, "systemContent");
            return (Criteria) this;
        }

        public Criteria andSystemContentNotLike(String value) {
            addCriterion("system_content not like", value, "systemContent");
            return (Criteria) this;
        }

        public Criteria andSystemContentIn(List<String> values) {
            addCriterion("system_content in", values, "systemContent");
            return (Criteria) this;
        }

        public Criteria andSystemContentNotIn(List<String> values) {
            addCriterion("system_content not in", values, "systemContent");
            return (Criteria) this;
        }

        public Criteria andSystemContentBetween(String value1, String value2) {
            addCriterion("system_content between", value1, value2, "systemContent");
            return (Criteria) this;
        }

        public Criteria andSystemContentNotBetween(String value1, String value2) {
            addCriterion("system_content not between", value1, value2, "systemContent");
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