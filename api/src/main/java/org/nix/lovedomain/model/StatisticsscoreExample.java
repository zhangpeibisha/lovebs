package org.nix.lovedomain.model;

import java.util.ArrayList;
import java.util.List;

public class StatisticsscoreExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StatisticsscoreExample() {
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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTeacheridIsNull() {
            addCriterion("teacherId is null");
            return (Criteria) this;
        }

        public Criteria andTeacheridIsNotNull() {
            addCriterion("teacherId is not null");
            return (Criteria) this;
        }

        public Criteria andTeacheridEqualTo(Integer value) {
            addCriterion("teacherId =", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridNotEqualTo(Integer value) {
            addCriterion("teacherId <>", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridGreaterThan(Integer value) {
            addCriterion("teacherId >", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridGreaterThanOrEqualTo(Integer value) {
            addCriterion("teacherId >=", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridLessThan(Integer value) {
            addCriterion("teacherId <", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridLessThanOrEqualTo(Integer value) {
            addCriterion("teacherId <=", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridIn(List<Integer> values) {
            addCriterion("teacherId in", values, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridNotIn(List<Integer> values) {
            addCriterion("teacherId not in", values, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridBetween(Integer value1, Integer value2) {
            addCriterion("teacherId between", value1, value2, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridNotBetween(Integer value1, Integer value2) {
            addCriterion("teacherId not between", value1, value2, "teacherid");
            return (Criteria) this;
        }

        public Criteria andCourseidIsNull() {
            addCriterion("courseId is null");
            return (Criteria) this;
        }

        public Criteria andCourseidIsNotNull() {
            addCriterion("courseId is not null");
            return (Criteria) this;
        }

        public Criteria andCourseidEqualTo(Integer value) {
            addCriterion("courseId =", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidNotEqualTo(Integer value) {
            addCriterion("courseId <>", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidGreaterThan(Integer value) {
            addCriterion("courseId >", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidGreaterThanOrEqualTo(Integer value) {
            addCriterion("courseId >=", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidLessThan(Integer value) {
            addCriterion("courseId <", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidLessThanOrEqualTo(Integer value) {
            addCriterion("courseId <=", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidIn(List<Integer> values) {
            addCriterion("courseId in", values, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidNotIn(List<Integer> values) {
            addCriterion("courseId not in", values, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidBetween(Integer value1, Integer value2) {
            addCriterion("courseId between", value1, value2, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidNotBetween(Integer value1, Integer value2) {
            addCriterion("courseId not between", value1, value2, "courseid");
            return (Criteria) this;
        }

        public Criteria andPublishquestionnaireidIsNull() {
            addCriterion("publishQuestionnaireId is null");
            return (Criteria) this;
        }

        public Criteria andPublishquestionnaireidIsNotNull() {
            addCriterion("publishQuestionnaireId is not null");
            return (Criteria) this;
        }

        public Criteria andPublishquestionnaireidEqualTo(Integer value) {
            addCriterion("publishQuestionnaireId =", value, "publishquestionnaireid");
            return (Criteria) this;
        }

        public Criteria andPublishquestionnaireidNotEqualTo(Integer value) {
            addCriterion("publishQuestionnaireId <>", value, "publishquestionnaireid");
            return (Criteria) this;
        }

        public Criteria andPublishquestionnaireidGreaterThan(Integer value) {
            addCriterion("publishQuestionnaireId >", value, "publishquestionnaireid");
            return (Criteria) this;
        }

        public Criteria andPublishquestionnaireidGreaterThanOrEqualTo(Integer value) {
            addCriterion("publishQuestionnaireId >=", value, "publishquestionnaireid");
            return (Criteria) this;
        }

        public Criteria andPublishquestionnaireidLessThan(Integer value) {
            addCriterion("publishQuestionnaireId <", value, "publishquestionnaireid");
            return (Criteria) this;
        }

        public Criteria andPublishquestionnaireidLessThanOrEqualTo(Integer value) {
            addCriterion("publishQuestionnaireId <=", value, "publishquestionnaireid");
            return (Criteria) this;
        }

        public Criteria andPublishquestionnaireidIn(List<Integer> values) {
            addCriterion("publishQuestionnaireId in", values, "publishquestionnaireid");
            return (Criteria) this;
        }

        public Criteria andPublishquestionnaireidNotIn(List<Integer> values) {
            addCriterion("publishQuestionnaireId not in", values, "publishquestionnaireid");
            return (Criteria) this;
        }

        public Criteria andPublishquestionnaireidBetween(Integer value1, Integer value2) {
            addCriterion("publishQuestionnaireId between", value1, value2, "publishquestionnaireid");
            return (Criteria) this;
        }

        public Criteria andPublishquestionnaireidNotBetween(Integer value1, Integer value2) {
            addCriterion("publishQuestionnaireId not between", value1, value2, "publishquestionnaireid");
            return (Criteria) this;
        }

        public Criteria andFractionIsNull() {
            addCriterion("fraction is null");
            return (Criteria) this;
        }

        public Criteria andFractionIsNotNull() {
            addCriterion("fraction is not null");
            return (Criteria) this;
        }

        public Criteria andFractionEqualTo(Integer value) {
            addCriterion("fraction =", value, "fraction");
            return (Criteria) this;
        }

        public Criteria andFractionNotEqualTo(Integer value) {
            addCriterion("fraction <>", value, "fraction");
            return (Criteria) this;
        }

        public Criteria andFractionGreaterThan(Integer value) {
            addCriterion("fraction >", value, "fraction");
            return (Criteria) this;
        }

        public Criteria andFractionGreaterThanOrEqualTo(Integer value) {
            addCriterion("fraction >=", value, "fraction");
            return (Criteria) this;
        }

        public Criteria andFractionLessThan(Integer value) {
            addCriterion("fraction <", value, "fraction");
            return (Criteria) this;
        }

        public Criteria andFractionLessThanOrEqualTo(Integer value) {
            addCriterion("fraction <=", value, "fraction");
            return (Criteria) this;
        }

        public Criteria andFractionIn(List<Integer> values) {
            addCriterion("fraction in", values, "fraction");
            return (Criteria) this;
        }

        public Criteria andFractionNotIn(List<Integer> values) {
            addCriterion("fraction not in", values, "fraction");
            return (Criteria) this;
        }

        public Criteria andFractionBetween(Integer value1, Integer value2) {
            addCriterion("fraction between", value1, value2, "fraction");
            return (Criteria) this;
        }

        public Criteria andFractionNotBetween(Integer value1, Integer value2) {
            addCriterion("fraction not between", value1, value2, "fraction");
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