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

        public Criteria andStayIdIsNull() {
            addCriterion("stay_id is null");
            return (Criteria) this;
        }

        public Criteria andStayIdIsNotNull() {
            addCriterion("stay_id is not null");
            return (Criteria) this;
        }

        public Criteria andStayIdEqualTo(Short value) {
            addCriterion("stay_id =", value, "stayId");
            return (Criteria) this;
        }

        public Criteria andStayIdNotEqualTo(Short value) {
            addCriterion("stay_id <>", value, "stayId");
            return (Criteria) this;
        }

        public Criteria andStayIdGreaterThan(Short value) {
            addCriterion("stay_id >", value, "stayId");
            return (Criteria) this;
        }

        public Criteria andStayIdGreaterThanOrEqualTo(Short value) {
            addCriterion("stay_id >=", value, "stayId");
            return (Criteria) this;
        }

        public Criteria andStayIdLessThan(Short value) {
            addCriterion("stay_id <", value, "stayId");
            return (Criteria) this;
        }

        public Criteria andStayIdLessThanOrEqualTo(Short value) {
            addCriterion("stay_id <=", value, "stayId");
            return (Criteria) this;
        }

        public Criteria andStayIdIn(List<Short> values) {
            addCriterion("stay_id in", values, "stayId");
            return (Criteria) this;
        }

        public Criteria andStayIdNotIn(List<Short> values) {
            addCriterion("stay_id not in", values, "stayId");
            return (Criteria) this;
        }

        public Criteria andStayIdBetween(Short value1, Short value2) {
            addCriterion("stay_id between", value1, value2, "stayId");
            return (Criteria) this;
        }

        public Criteria andStayIdNotBetween(Short value1, Short value2) {
            addCriterion("stay_id not between", value1, value2, "stayId");
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

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andStayUserIdIsNull() {
            addCriterion("stay_user_id is null");
            return (Criteria) this;
        }

        public Criteria andStayUserIdIsNotNull() {
            addCriterion("stay_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andStayUserIdEqualTo(Integer value) {
            addCriterion("stay_user_id =", value, "stayUserId");
            return (Criteria) this;
        }

        public Criteria andStayUserIdNotEqualTo(Integer value) {
            addCriterion("stay_user_id <>", value, "stayUserId");
            return (Criteria) this;
        }

        public Criteria andStayUserIdGreaterThan(Integer value) {
            addCriterion("stay_user_id >", value, "stayUserId");
            return (Criteria) this;
        }

        public Criteria andStayUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("stay_user_id >=", value, "stayUserId");
            return (Criteria) this;
        }

        public Criteria andStayUserIdLessThan(Integer value) {
            addCriterion("stay_user_id <", value, "stayUserId");
            return (Criteria) this;
        }

        public Criteria andStayUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("stay_user_id <=", value, "stayUserId");
            return (Criteria) this;
        }

        public Criteria andStayUserIdIn(List<Integer> values) {
            addCriterion("stay_user_id in", values, "stayUserId");
            return (Criteria) this;
        }

        public Criteria andStayUserIdNotIn(List<Integer> values) {
            addCriterion("stay_user_id not in", values, "stayUserId");
            return (Criteria) this;
        }

        public Criteria andStayUserIdBetween(Integer value1, Integer value2) {
            addCriterion("stay_user_id between", value1, value2, "stayUserId");
            return (Criteria) this;
        }

        public Criteria andStayUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("stay_user_id not between", value1, value2, "stayUserId");
            return (Criteria) this;
        }

        public Criteria andMessageContentIsNull() {
            addCriterion("message_content is null");
            return (Criteria) this;
        }

        public Criteria andMessageContentIsNotNull() {
            addCriterion("message_content is not null");
            return (Criteria) this;
        }

        public Criteria andMessageContentEqualTo(String value) {
            addCriterion("message_content =", value, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentNotEqualTo(String value) {
            addCriterion("message_content <>", value, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentGreaterThan(String value) {
            addCriterion("message_content >", value, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentGreaterThanOrEqualTo(String value) {
            addCriterion("message_content >=", value, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentLessThan(String value) {
            addCriterion("message_content <", value, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentLessThanOrEqualTo(String value) {
            addCriterion("message_content <=", value, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentLike(String value) {
            addCriterion("message_content like", value, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentNotLike(String value) {
            addCriterion("message_content not like", value, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentIn(List<String> values) {
            addCriterion("message_content in", values, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentNotIn(List<String> values) {
            addCriterion("message_content not in", values, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentBetween(String value1, String value2) {
            addCriterion("message_content between", value1, value2, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentNotBetween(String value1, String value2) {
            addCriterion("message_content not between", value1, value2, "messageContent");
            return (Criteria) this;
        }

        public Criteria andStayUserIpIsNull() {
            addCriterion("stay_user_ip is null");
            return (Criteria) this;
        }

        public Criteria andStayUserIpIsNotNull() {
            addCriterion("stay_user_ip is not null");
            return (Criteria) this;
        }

        public Criteria andStayUserIpEqualTo(String value) {
            addCriterion("stay_user_ip =", value, "stayUserIp");
            return (Criteria) this;
        }

        public Criteria andStayUserIpNotEqualTo(String value) {
            addCriterion("stay_user_ip <>", value, "stayUserIp");
            return (Criteria) this;
        }

        public Criteria andStayUserIpGreaterThan(String value) {
            addCriterion("stay_user_ip >", value, "stayUserIp");
            return (Criteria) this;
        }

        public Criteria andStayUserIpGreaterThanOrEqualTo(String value) {
            addCriterion("stay_user_ip >=", value, "stayUserIp");
            return (Criteria) this;
        }

        public Criteria andStayUserIpLessThan(String value) {
            addCriterion("stay_user_ip <", value, "stayUserIp");
            return (Criteria) this;
        }

        public Criteria andStayUserIpLessThanOrEqualTo(String value) {
            addCriterion("stay_user_ip <=", value, "stayUserIp");
            return (Criteria) this;
        }

        public Criteria andStayUserIpLike(String value) {
            addCriterion("stay_user_ip like", value, "stayUserIp");
            return (Criteria) this;
        }

        public Criteria andStayUserIpNotLike(String value) {
            addCriterion("stay_user_ip not like", value, "stayUserIp");
            return (Criteria) this;
        }

        public Criteria andStayUserIpIn(List<String> values) {
            addCriterion("stay_user_ip in", values, "stayUserIp");
            return (Criteria) this;
        }

        public Criteria andStayUserIpNotIn(List<String> values) {
            addCriterion("stay_user_ip not in", values, "stayUserIp");
            return (Criteria) this;
        }

        public Criteria andStayUserIpBetween(String value1, String value2) {
            addCriterion("stay_user_ip between", value1, value2, "stayUserIp");
            return (Criteria) this;
        }

        public Criteria andStayUserIpNotBetween(String value1, String value2) {
            addCriterion("stay_user_ip not between", value1, value2, "stayUserIp");
            return (Criteria) this;
        }

        public Criteria andMessageStayTimeIsNull() {
            addCriterion("message_stay_time is null");
            return (Criteria) this;
        }

        public Criteria andMessageStayTimeIsNotNull() {
            addCriterion("message_stay_time is not null");
            return (Criteria) this;
        }

        public Criteria andMessageStayTimeEqualTo(Integer value) {
            addCriterion("message_stay_time =", value, "messageStayTime");
            return (Criteria) this;
        }

        public Criteria andMessageStayTimeNotEqualTo(Integer value) {
            addCriterion("message_stay_time <>", value, "messageStayTime");
            return (Criteria) this;
        }

        public Criteria andMessageStayTimeGreaterThan(Integer value) {
            addCriterion("message_stay_time >", value, "messageStayTime");
            return (Criteria) this;
        }

        public Criteria andMessageStayTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("message_stay_time >=", value, "messageStayTime");
            return (Criteria) this;
        }

        public Criteria andMessageStayTimeLessThan(Integer value) {
            addCriterion("message_stay_time <", value, "messageStayTime");
            return (Criteria) this;
        }

        public Criteria andMessageStayTimeLessThanOrEqualTo(Integer value) {
            addCriterion("message_stay_time <=", value, "messageStayTime");
            return (Criteria) this;
        }

        public Criteria andMessageStayTimeIn(List<Integer> values) {
            addCriterion("message_stay_time in", values, "messageStayTime");
            return (Criteria) this;
        }

        public Criteria andMessageStayTimeNotIn(List<Integer> values) {
            addCriterion("message_stay_time not in", values, "messageStayTime");
            return (Criteria) this;
        }

        public Criteria andMessageStayTimeBetween(Integer value1, Integer value2) {
            addCriterion("message_stay_time between", value1, value2, "messageStayTime");
            return (Criteria) this;
        }

        public Criteria andMessageStayTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("message_stay_time not between", value1, value2, "messageStayTime");
            return (Criteria) this;
        }

        public Criteria andPlaceIsNull() {
            addCriterion("place is null");
            return (Criteria) this;
        }

        public Criteria andPlaceIsNotNull() {
            addCriterion("place is not null");
            return (Criteria) this;
        }

        public Criteria andPlaceEqualTo(String value) {
            addCriterion("place =", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceNotEqualTo(String value) {
            addCriterion("place <>", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceGreaterThan(String value) {
            addCriterion("place >", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("place >=", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceLessThan(String value) {
            addCriterion("place <", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceLessThanOrEqualTo(String value) {
            addCriterion("place <=", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceLike(String value) {
            addCriterion("place like", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceNotLike(String value) {
            addCriterion("place not like", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceIn(List<String> values) {
            addCriterion("place in", values, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceNotIn(List<String> values) {
            addCriterion("place not in", values, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceBetween(String value1, String value2) {
            addCriterion("place between", value1, value2, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceNotBetween(String value1, String value2) {
            addCriterion("place not between", value1, value2, "place");
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