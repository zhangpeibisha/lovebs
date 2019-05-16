package org.nix.lovedomain.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PublishquestionnaireExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PublishquestionnaireExample() {
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

        public Criteria andReleaseidIsNull() {
            addCriterion("releaseId is null");
            return (Criteria) this;
        }

        public Criteria andReleaseidIsNotNull() {
            addCriterion("releaseId is not null");
            return (Criteria) this;
        }

        public Criteria andReleaseidEqualTo(Integer value) {
            addCriterion("releaseId =", value, "releaseid");
            return (Criteria) this;
        }

        public Criteria andReleaseidNotEqualTo(Integer value) {
            addCriterion("releaseId <>", value, "releaseid");
            return (Criteria) this;
        }

        public Criteria andReleaseidGreaterThan(Integer value) {
            addCriterion("releaseId >", value, "releaseid");
            return (Criteria) this;
        }

        public Criteria andReleaseidGreaterThanOrEqualTo(Integer value) {
            addCriterion("releaseId >=", value, "releaseid");
            return (Criteria) this;
        }

        public Criteria andReleaseidLessThan(Integer value) {
            addCriterion("releaseId <", value, "releaseid");
            return (Criteria) this;
        }

        public Criteria andReleaseidLessThanOrEqualTo(Integer value) {
            addCriterion("releaseId <=", value, "releaseid");
            return (Criteria) this;
        }

        public Criteria andReleaseidIn(List<Integer> values) {
            addCriterion("releaseId in", values, "releaseid");
            return (Criteria) this;
        }

        public Criteria andReleaseidNotIn(List<Integer> values) {
            addCriterion("releaseId not in", values, "releaseid");
            return (Criteria) this;
        }

        public Criteria andReleaseidBetween(Integer value1, Integer value2) {
            addCriterion("releaseId between", value1, value2, "releaseid");
            return (Criteria) this;
        }

        public Criteria andReleaseidNotBetween(Integer value1, Integer value2) {
            addCriterion("releaseId not between", value1, value2, "releaseid");
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

        public Criteria andQuestionnaireidIsNull() {
            addCriterion("questionnaireId is null");
            return (Criteria) this;
        }

        public Criteria andQuestionnaireidIsNotNull() {
            addCriterion("questionnaireId is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionnaireidEqualTo(Integer value) {
            addCriterion("questionnaireId =", value, "questionnaireid");
            return (Criteria) this;
        }

        public Criteria andQuestionnaireidNotEqualTo(Integer value) {
            addCriterion("questionnaireId <>", value, "questionnaireid");
            return (Criteria) this;
        }

        public Criteria andQuestionnaireidGreaterThan(Integer value) {
            addCriterion("questionnaireId >", value, "questionnaireid");
            return (Criteria) this;
        }

        public Criteria andQuestionnaireidGreaterThanOrEqualTo(Integer value) {
            addCriterion("questionnaireId >=", value, "questionnaireid");
            return (Criteria) this;
        }

        public Criteria andQuestionnaireidLessThan(Integer value) {
            addCriterion("questionnaireId <", value, "questionnaireid");
            return (Criteria) this;
        }

        public Criteria andQuestionnaireidLessThanOrEqualTo(Integer value) {
            addCriterion("questionnaireId <=", value, "questionnaireid");
            return (Criteria) this;
        }

        public Criteria andQuestionnaireidIn(List<Integer> values) {
            addCriterion("questionnaireId in", values, "questionnaireid");
            return (Criteria) this;
        }

        public Criteria andQuestionnaireidNotIn(List<Integer> values) {
            addCriterion("questionnaireId not in", values, "questionnaireid");
            return (Criteria) this;
        }

        public Criteria andQuestionnaireidBetween(Integer value1, Integer value2) {
            addCriterion("questionnaireId between", value1, value2, "questionnaireid");
            return (Criteria) this;
        }

        public Criteria andQuestionnaireidNotBetween(Integer value1, Integer value2) {
            addCriterion("questionnaireId not between", value1, value2, "questionnaireid");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andReleasetimeIsNull() {
            addCriterion("releaseTime is null");
            return (Criteria) this;
        }

        public Criteria andReleasetimeIsNotNull() {
            addCriterion("releaseTime is not null");
            return (Criteria) this;
        }

        public Criteria andReleasetimeEqualTo(Date value) {
            addCriterion("releaseTime =", value, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeNotEqualTo(Date value) {
            addCriterion("releaseTime <>", value, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeGreaterThan(Date value) {
            addCriterion("releaseTime >", value, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("releaseTime >=", value, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeLessThan(Date value) {
            addCriterion("releaseTime <", value, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeLessThanOrEqualTo(Date value) {
            addCriterion("releaseTime <=", value, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeIn(List<Date> values) {
            addCriterion("releaseTime in", values, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeNotIn(List<Date> values) {
            addCriterion("releaseTime not in", values, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeBetween(Date value1, Date value2) {
            addCriterion("releaseTime between", value1, value2, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeNotBetween(Date value1, Date value2) {
            addCriterion("releaseTime not between", value1, value2, "releasetime");
            return (Criteria) this;
        }

        public Criteria andStartrespondtimeIsNull() {
            addCriterion("startRespondTime is null");
            return (Criteria) this;
        }

        public Criteria andStartrespondtimeIsNotNull() {
            addCriterion("startRespondTime is not null");
            return (Criteria) this;
        }

        public Criteria andStartrespondtimeEqualTo(Date value) {
            addCriterion("startRespondTime =", value, "startrespondtime");
            return (Criteria) this;
        }

        public Criteria andStartrespondtimeNotEqualTo(Date value) {
            addCriterion("startRespondTime <>", value, "startrespondtime");
            return (Criteria) this;
        }

        public Criteria andStartrespondtimeGreaterThan(Date value) {
            addCriterion("startRespondTime >", value, "startrespondtime");
            return (Criteria) this;
        }

        public Criteria andStartrespondtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("startRespondTime >=", value, "startrespondtime");
            return (Criteria) this;
        }

        public Criteria andStartrespondtimeLessThan(Date value) {
            addCriterion("startRespondTime <", value, "startrespondtime");
            return (Criteria) this;
        }

        public Criteria andStartrespondtimeLessThanOrEqualTo(Date value) {
            addCriterion("startRespondTime <=", value, "startrespondtime");
            return (Criteria) this;
        }

        public Criteria andStartrespondtimeIn(List<Date> values) {
            addCriterion("startRespondTime in", values, "startrespondtime");
            return (Criteria) this;
        }

        public Criteria andStartrespondtimeNotIn(List<Date> values) {
            addCriterion("startRespondTime not in", values, "startrespondtime");
            return (Criteria) this;
        }

        public Criteria andStartrespondtimeBetween(Date value1, Date value2) {
            addCriterion("startRespondTime between", value1, value2, "startrespondtime");
            return (Criteria) this;
        }

        public Criteria andStartrespondtimeNotBetween(Date value1, Date value2) {
            addCriterion("startRespondTime not between", value1, value2, "startrespondtime");
            return (Criteria) this;
        }

        public Criteria andEndrespondtimeIsNull() {
            addCriterion("endRespondTime is null");
            return (Criteria) this;
        }

        public Criteria andEndrespondtimeIsNotNull() {
            addCriterion("endRespondTime is not null");
            return (Criteria) this;
        }

        public Criteria andEndrespondtimeEqualTo(Date value) {
            addCriterion("endRespondTime =", value, "endrespondtime");
            return (Criteria) this;
        }

        public Criteria andEndrespondtimeNotEqualTo(Date value) {
            addCriterion("endRespondTime <>", value, "endrespondtime");
            return (Criteria) this;
        }

        public Criteria andEndrespondtimeGreaterThan(Date value) {
            addCriterion("endRespondTime >", value, "endrespondtime");
            return (Criteria) this;
        }

        public Criteria andEndrespondtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("endRespondTime >=", value, "endrespondtime");
            return (Criteria) this;
        }

        public Criteria andEndrespondtimeLessThan(Date value) {
            addCriterion("endRespondTime <", value, "endrespondtime");
            return (Criteria) this;
        }

        public Criteria andEndrespondtimeLessThanOrEqualTo(Date value) {
            addCriterion("endRespondTime <=", value, "endrespondtime");
            return (Criteria) this;
        }

        public Criteria andEndrespondtimeIn(List<Date> values) {
            addCriterion("endRespondTime in", values, "endrespondtime");
            return (Criteria) this;
        }

        public Criteria andEndrespondtimeNotIn(List<Date> values) {
            addCriterion("endRespondTime not in", values, "endrespondtime");
            return (Criteria) this;
        }

        public Criteria andEndrespondtimeBetween(Date value1, Date value2) {
            addCriterion("endRespondTime between", value1, value2, "endrespondtime");
            return (Criteria) this;
        }

        public Criteria andEndrespondtimeNotBetween(Date value1, Date value2) {
            addCriterion("endRespondTime not between", value1, value2, "endrespondtime");
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