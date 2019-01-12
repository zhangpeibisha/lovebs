package org.nix.zpbs.model;

import java.util.ArrayList;
import java.util.List;

public class SysResourceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysResourceExample() {
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

        public Criteria andResourceNameIsNull() {
            addCriterion("RESOURCE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andResourceNameIsNotNull() {
            addCriterion("RESOURCE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andResourceNameEqualTo(String value) {
            addCriterion("RESOURCE_NAME =", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameNotEqualTo(String value) {
            addCriterion("RESOURCE_NAME <>", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameGreaterThan(String value) {
            addCriterion("RESOURCE_NAME >", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameGreaterThanOrEqualTo(String value) {
            addCriterion("RESOURCE_NAME >=", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameLessThan(String value) {
            addCriterion("RESOURCE_NAME <", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameLessThanOrEqualTo(String value) {
            addCriterion("RESOURCE_NAME <=", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameLike(String value) {
            addCriterion("RESOURCE_NAME like", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameNotLike(String value) {
            addCriterion("RESOURCE_NAME not like", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameIn(List<String> values) {
            addCriterion("RESOURCE_NAME in", values, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameNotIn(List<String> values) {
            addCriterion("RESOURCE_NAME not in", values, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameBetween(String value1, String value2) {
            addCriterion("RESOURCE_NAME between", value1, value2, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameNotBetween(String value1, String value2) {
            addCriterion("RESOURCE_NAME not between", value1, value2, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceUrlIsNull() {
            addCriterion("RESOURCE_URL is null");
            return (Criteria) this;
        }

        public Criteria andResourceUrlIsNotNull() {
            addCriterion("RESOURCE_URL is not null");
            return (Criteria) this;
        }

        public Criteria andResourceUrlEqualTo(String value) {
            addCriterion("RESOURCE_URL =", value, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlNotEqualTo(String value) {
            addCriterion("RESOURCE_URL <>", value, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlGreaterThan(String value) {
            addCriterion("RESOURCE_URL >", value, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlGreaterThanOrEqualTo(String value) {
            addCriterion("RESOURCE_URL >=", value, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlLessThan(String value) {
            addCriterion("RESOURCE_URL <", value, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlLessThanOrEqualTo(String value) {
            addCriterion("RESOURCE_URL <=", value, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlLike(String value) {
            addCriterion("RESOURCE_URL like", value, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlNotLike(String value) {
            addCriterion("RESOURCE_URL not like", value, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlIn(List<String> values) {
            addCriterion("RESOURCE_URL in", values, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlNotIn(List<String> values) {
            addCriterion("RESOURCE_URL not in", values, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlBetween(String value1, String value2) {
            addCriterion("RESOURCE_URL between", value1, value2, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceUrlNotBetween(String value1, String value2) {
            addCriterion("RESOURCE_URL not between", value1, value2, "resourceUrl");
            return (Criteria) this;
        }

        public Criteria andResourceSwitchIsNull() {
            addCriterion("RESOURCE_SWITCH is null");
            return (Criteria) this;
        }

        public Criteria andResourceSwitchIsNotNull() {
            addCriterion("RESOURCE_SWITCH is not null");
            return (Criteria) this;
        }

        public Criteria andResourceSwitchEqualTo(Integer value) {
            addCriterion("RESOURCE_SWITCH =", value, "resourceSwitch");
            return (Criteria) this;
        }

        public Criteria andResourceSwitchNotEqualTo(Integer value) {
            addCriterion("RESOURCE_SWITCH <>", value, "resourceSwitch");
            return (Criteria) this;
        }

        public Criteria andResourceSwitchGreaterThan(Integer value) {
            addCriterion("RESOURCE_SWITCH >", value, "resourceSwitch");
            return (Criteria) this;
        }

        public Criteria andResourceSwitchGreaterThanOrEqualTo(Integer value) {
            addCriterion("RESOURCE_SWITCH >=", value, "resourceSwitch");
            return (Criteria) this;
        }

        public Criteria andResourceSwitchLessThan(Integer value) {
            addCriterion("RESOURCE_SWITCH <", value, "resourceSwitch");
            return (Criteria) this;
        }

        public Criteria andResourceSwitchLessThanOrEqualTo(Integer value) {
            addCriterion("RESOURCE_SWITCH <=", value, "resourceSwitch");
            return (Criteria) this;
        }

        public Criteria andResourceSwitchIn(List<Integer> values) {
            addCriterion("RESOURCE_SWITCH in", values, "resourceSwitch");
            return (Criteria) this;
        }

        public Criteria andResourceSwitchNotIn(List<Integer> values) {
            addCriterion("RESOURCE_SWITCH not in", values, "resourceSwitch");
            return (Criteria) this;
        }

        public Criteria andResourceSwitchBetween(Integer value1, Integer value2) {
            addCriterion("RESOURCE_SWITCH between", value1, value2, "resourceSwitch");
            return (Criteria) this;
        }

        public Criteria andResourceSwitchNotBetween(Integer value1, Integer value2) {
            addCriterion("RESOURCE_SWITCH not between", value1, value2, "resourceSwitch");
            return (Criteria) this;
        }

        public Criteria andResourceDescriptionIsNull() {
            addCriterion("RESOURCE_DESCRIPTION is null");
            return (Criteria) this;
        }

        public Criteria andResourceDescriptionIsNotNull() {
            addCriterion("RESOURCE_DESCRIPTION is not null");
            return (Criteria) this;
        }

        public Criteria andResourceDescriptionEqualTo(String value) {
            addCriterion("RESOURCE_DESCRIPTION =", value, "resourceDescription");
            return (Criteria) this;
        }

        public Criteria andResourceDescriptionNotEqualTo(String value) {
            addCriterion("RESOURCE_DESCRIPTION <>", value, "resourceDescription");
            return (Criteria) this;
        }

        public Criteria andResourceDescriptionGreaterThan(String value) {
            addCriterion("RESOURCE_DESCRIPTION >", value, "resourceDescription");
            return (Criteria) this;
        }

        public Criteria andResourceDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("RESOURCE_DESCRIPTION >=", value, "resourceDescription");
            return (Criteria) this;
        }

        public Criteria andResourceDescriptionLessThan(String value) {
            addCriterion("RESOURCE_DESCRIPTION <", value, "resourceDescription");
            return (Criteria) this;
        }

        public Criteria andResourceDescriptionLessThanOrEqualTo(String value) {
            addCriterion("RESOURCE_DESCRIPTION <=", value, "resourceDescription");
            return (Criteria) this;
        }

        public Criteria andResourceDescriptionLike(String value) {
            addCriterion("RESOURCE_DESCRIPTION like", value, "resourceDescription");
            return (Criteria) this;
        }

        public Criteria andResourceDescriptionNotLike(String value) {
            addCriterion("RESOURCE_DESCRIPTION not like", value, "resourceDescription");
            return (Criteria) this;
        }

        public Criteria andResourceDescriptionIn(List<String> values) {
            addCriterion("RESOURCE_DESCRIPTION in", values, "resourceDescription");
            return (Criteria) this;
        }

        public Criteria andResourceDescriptionNotIn(List<String> values) {
            addCriterion("RESOURCE_DESCRIPTION not in", values, "resourceDescription");
            return (Criteria) this;
        }

        public Criteria andResourceDescriptionBetween(String value1, String value2) {
            addCriterion("RESOURCE_DESCRIPTION between", value1, value2, "resourceDescription");
            return (Criteria) this;
        }

        public Criteria andResourceDescriptionNotBetween(String value1, String value2) {
            addCriterion("RESOURCE_DESCRIPTION not between", value1, value2, "resourceDescription");
            return (Criteria) this;
        }

        public Criteria andResourceTypeIsNull() {
            addCriterion("RESOURCE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andResourceTypeIsNotNull() {
            addCriterion("RESOURCE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andResourceTypeEqualTo(Integer value) {
            addCriterion("RESOURCE_TYPE =", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeNotEqualTo(Integer value) {
            addCriterion("RESOURCE_TYPE <>", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeGreaterThan(Integer value) {
            addCriterion("RESOURCE_TYPE >", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("RESOURCE_TYPE >=", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeLessThan(Integer value) {
            addCriterion("RESOURCE_TYPE <", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeLessThanOrEqualTo(Integer value) {
            addCriterion("RESOURCE_TYPE <=", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeIn(List<Integer> values) {
            addCriterion("RESOURCE_TYPE in", values, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeNotIn(List<Integer> values) {
            addCriterion("RESOURCE_TYPE not in", values, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeBetween(Integer value1, Integer value2) {
            addCriterion("RESOURCE_TYPE between", value1, value2, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("RESOURCE_TYPE not between", value1, value2, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourcePrentIsNull() {
            addCriterion("RESOURCE_PRENT is null");
            return (Criteria) this;
        }

        public Criteria andResourcePrentIsNotNull() {
            addCriterion("RESOURCE_PRENT is not null");
            return (Criteria) this;
        }

        public Criteria andResourcePrentEqualTo(Long value) {
            addCriterion("RESOURCE_PRENT =", value, "resourcePrent");
            return (Criteria) this;
        }

        public Criteria andResourcePrentNotEqualTo(Long value) {
            addCriterion("RESOURCE_PRENT <>", value, "resourcePrent");
            return (Criteria) this;
        }

        public Criteria andResourcePrentGreaterThan(Long value) {
            addCriterion("RESOURCE_PRENT >", value, "resourcePrent");
            return (Criteria) this;
        }

        public Criteria andResourcePrentGreaterThanOrEqualTo(Long value) {
            addCriterion("RESOURCE_PRENT >=", value, "resourcePrent");
            return (Criteria) this;
        }

        public Criteria andResourcePrentLessThan(Long value) {
            addCriterion("RESOURCE_PRENT <", value, "resourcePrent");
            return (Criteria) this;
        }

        public Criteria andResourcePrentLessThanOrEqualTo(Long value) {
            addCriterion("RESOURCE_PRENT <=", value, "resourcePrent");
            return (Criteria) this;
        }

        public Criteria andResourcePrentIn(List<Long> values) {
            addCriterion("RESOURCE_PRENT in", values, "resourcePrent");
            return (Criteria) this;
        }

        public Criteria andResourcePrentNotIn(List<Long> values) {
            addCriterion("RESOURCE_PRENT not in", values, "resourcePrent");
            return (Criteria) this;
        }

        public Criteria andResourcePrentBetween(Long value1, Long value2) {
            addCriterion("RESOURCE_PRENT between", value1, value2, "resourcePrent");
            return (Criteria) this;
        }

        public Criteria andResourcePrentNotBetween(Long value1, Long value2) {
            addCriterion("RESOURCE_PRENT not between", value1, value2, "resourcePrent");
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