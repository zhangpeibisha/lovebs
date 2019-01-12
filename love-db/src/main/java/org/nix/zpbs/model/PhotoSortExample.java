package org.nix.zpbs.model;

import java.util.ArrayList;
import java.util.List;

public class PhotoSortExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PhotoSortExample() {
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

        public Criteria andSortImgNameIsNull() {
            addCriterion("SORT_IMG_NAME is null");
            return (Criteria) this;
        }

        public Criteria andSortImgNameIsNotNull() {
            addCriterion("SORT_IMG_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andSortImgNameEqualTo(String value) {
            addCriterion("SORT_IMG_NAME =", value, "sortImgName");
            return (Criteria) this;
        }

        public Criteria andSortImgNameNotEqualTo(String value) {
            addCriterion("SORT_IMG_NAME <>", value, "sortImgName");
            return (Criteria) this;
        }

        public Criteria andSortImgNameGreaterThan(String value) {
            addCriterion("SORT_IMG_NAME >", value, "sortImgName");
            return (Criteria) this;
        }

        public Criteria andSortImgNameGreaterThanOrEqualTo(String value) {
            addCriterion("SORT_IMG_NAME >=", value, "sortImgName");
            return (Criteria) this;
        }

        public Criteria andSortImgNameLessThan(String value) {
            addCriterion("SORT_IMG_NAME <", value, "sortImgName");
            return (Criteria) this;
        }

        public Criteria andSortImgNameLessThanOrEqualTo(String value) {
            addCriterion("SORT_IMG_NAME <=", value, "sortImgName");
            return (Criteria) this;
        }

        public Criteria andSortImgNameLike(String value) {
            addCriterion("SORT_IMG_NAME like", value, "sortImgName");
            return (Criteria) this;
        }

        public Criteria andSortImgNameNotLike(String value) {
            addCriterion("SORT_IMG_NAME not like", value, "sortImgName");
            return (Criteria) this;
        }

        public Criteria andSortImgNameIn(List<String> values) {
            addCriterion("SORT_IMG_NAME in", values, "sortImgName");
            return (Criteria) this;
        }

        public Criteria andSortImgNameNotIn(List<String> values) {
            addCriterion("SORT_IMG_NAME not in", values, "sortImgName");
            return (Criteria) this;
        }

        public Criteria andSortImgNameBetween(String value1, String value2) {
            addCriterion("SORT_IMG_NAME between", value1, value2, "sortImgName");
            return (Criteria) this;
        }

        public Criteria andSortImgNameNotBetween(String value1, String value2) {
            addCriterion("SORT_IMG_NAME not between", value1, value2, "sortImgName");
            return (Criteria) this;
        }

        public Criteria andSortImgTypeIsNull() {
            addCriterion("SORT_IMG_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andSortImgTypeIsNotNull() {
            addCriterion("SORT_IMG_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andSortImgTypeEqualTo(String value) {
            addCriterion("SORT_IMG_TYPE =", value, "sortImgType");
            return (Criteria) this;
        }

        public Criteria andSortImgTypeNotEqualTo(String value) {
            addCriterion("SORT_IMG_TYPE <>", value, "sortImgType");
            return (Criteria) this;
        }

        public Criteria andSortImgTypeGreaterThan(String value) {
            addCriterion("SORT_IMG_TYPE >", value, "sortImgType");
            return (Criteria) this;
        }

        public Criteria andSortImgTypeGreaterThanOrEqualTo(String value) {
            addCriterion("SORT_IMG_TYPE >=", value, "sortImgType");
            return (Criteria) this;
        }

        public Criteria andSortImgTypeLessThan(String value) {
            addCriterion("SORT_IMG_TYPE <", value, "sortImgType");
            return (Criteria) this;
        }

        public Criteria andSortImgTypeLessThanOrEqualTo(String value) {
            addCriterion("SORT_IMG_TYPE <=", value, "sortImgType");
            return (Criteria) this;
        }

        public Criteria andSortImgTypeLike(String value) {
            addCriterion("SORT_IMG_TYPE like", value, "sortImgType");
            return (Criteria) this;
        }

        public Criteria andSortImgTypeNotLike(String value) {
            addCriterion("SORT_IMG_TYPE not like", value, "sortImgType");
            return (Criteria) this;
        }

        public Criteria andSortImgTypeIn(List<String> values) {
            addCriterion("SORT_IMG_TYPE in", values, "sortImgType");
            return (Criteria) this;
        }

        public Criteria andSortImgTypeNotIn(List<String> values) {
            addCriterion("SORT_IMG_TYPE not in", values, "sortImgType");
            return (Criteria) this;
        }

        public Criteria andSortImgTypeBetween(String value1, String value2) {
            addCriterion("SORT_IMG_TYPE between", value1, value2, "sortImgType");
            return (Criteria) this;
        }

        public Criteria andSortImgTypeNotBetween(String value1, String value2) {
            addCriterion("SORT_IMG_TYPE not between", value1, value2, "sortImgType");
            return (Criteria) this;
        }

        public Criteria andImgPasswordIsNull() {
            addCriterion("IMG_PASSWORD is null");
            return (Criteria) this;
        }

        public Criteria andImgPasswordIsNotNull() {
            addCriterion("IMG_PASSWORD is not null");
            return (Criteria) this;
        }

        public Criteria andImgPasswordEqualTo(String value) {
            addCriterion("IMG_PASSWORD =", value, "imgPassword");
            return (Criteria) this;
        }

        public Criteria andImgPasswordNotEqualTo(String value) {
            addCriterion("IMG_PASSWORD <>", value, "imgPassword");
            return (Criteria) this;
        }

        public Criteria andImgPasswordGreaterThan(String value) {
            addCriterion("IMG_PASSWORD >", value, "imgPassword");
            return (Criteria) this;
        }

        public Criteria andImgPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("IMG_PASSWORD >=", value, "imgPassword");
            return (Criteria) this;
        }

        public Criteria andImgPasswordLessThan(String value) {
            addCriterion("IMG_PASSWORD <", value, "imgPassword");
            return (Criteria) this;
        }

        public Criteria andImgPasswordLessThanOrEqualTo(String value) {
            addCriterion("IMG_PASSWORD <=", value, "imgPassword");
            return (Criteria) this;
        }

        public Criteria andImgPasswordLike(String value) {
            addCriterion("IMG_PASSWORD like", value, "imgPassword");
            return (Criteria) this;
        }

        public Criteria andImgPasswordNotLike(String value) {
            addCriterion("IMG_PASSWORD not like", value, "imgPassword");
            return (Criteria) this;
        }

        public Criteria andImgPasswordIn(List<String> values) {
            addCriterion("IMG_PASSWORD in", values, "imgPassword");
            return (Criteria) this;
        }

        public Criteria andImgPasswordNotIn(List<String> values) {
            addCriterion("IMG_PASSWORD not in", values, "imgPassword");
            return (Criteria) this;
        }

        public Criteria andImgPasswordBetween(String value1, String value2) {
            addCriterion("IMG_PASSWORD between", value1, value2, "imgPassword");
            return (Criteria) this;
        }

        public Criteria andImgPasswordNotBetween(String value1, String value2) {
            addCriterion("IMG_PASSWORD not between", value1, value2, "imgPassword");
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

        public Criteria andImgSortQuestionIsNull() {
            addCriterion("IMG_SORT_QUESTION is null");
            return (Criteria) this;
        }

        public Criteria andImgSortQuestionIsNotNull() {
            addCriterion("IMG_SORT_QUESTION is not null");
            return (Criteria) this;
        }

        public Criteria andImgSortQuestionEqualTo(String value) {
            addCriterion("IMG_SORT_QUESTION =", value, "imgSortQuestion");
            return (Criteria) this;
        }

        public Criteria andImgSortQuestionNotEqualTo(String value) {
            addCriterion("IMG_SORT_QUESTION <>", value, "imgSortQuestion");
            return (Criteria) this;
        }

        public Criteria andImgSortQuestionGreaterThan(String value) {
            addCriterion("IMG_SORT_QUESTION >", value, "imgSortQuestion");
            return (Criteria) this;
        }

        public Criteria andImgSortQuestionGreaterThanOrEqualTo(String value) {
            addCriterion("IMG_SORT_QUESTION >=", value, "imgSortQuestion");
            return (Criteria) this;
        }

        public Criteria andImgSortQuestionLessThan(String value) {
            addCriterion("IMG_SORT_QUESTION <", value, "imgSortQuestion");
            return (Criteria) this;
        }

        public Criteria andImgSortQuestionLessThanOrEqualTo(String value) {
            addCriterion("IMG_SORT_QUESTION <=", value, "imgSortQuestion");
            return (Criteria) this;
        }

        public Criteria andImgSortQuestionLike(String value) {
            addCriterion("IMG_SORT_QUESTION like", value, "imgSortQuestion");
            return (Criteria) this;
        }

        public Criteria andImgSortQuestionNotLike(String value) {
            addCriterion("IMG_SORT_QUESTION not like", value, "imgSortQuestion");
            return (Criteria) this;
        }

        public Criteria andImgSortQuestionIn(List<String> values) {
            addCriterion("IMG_SORT_QUESTION in", values, "imgSortQuestion");
            return (Criteria) this;
        }

        public Criteria andImgSortQuestionNotIn(List<String> values) {
            addCriterion("IMG_SORT_QUESTION not in", values, "imgSortQuestion");
            return (Criteria) this;
        }

        public Criteria andImgSortQuestionBetween(String value1, String value2) {
            addCriterion("IMG_SORT_QUESTION between", value1, value2, "imgSortQuestion");
            return (Criteria) this;
        }

        public Criteria andImgSortQuestionNotBetween(String value1, String value2) {
            addCriterion("IMG_SORT_QUESTION not between", value1, value2, "imgSortQuestion");
            return (Criteria) this;
        }

        public Criteria andImgSortAnswerIsNull() {
            addCriterion("IMG_SORT_ANSWER is null");
            return (Criteria) this;
        }

        public Criteria andImgSortAnswerIsNotNull() {
            addCriterion("IMG_SORT_ANSWER is not null");
            return (Criteria) this;
        }

        public Criteria andImgSortAnswerEqualTo(String value) {
            addCriterion("IMG_SORT_ANSWER =", value, "imgSortAnswer");
            return (Criteria) this;
        }

        public Criteria andImgSortAnswerNotEqualTo(String value) {
            addCriterion("IMG_SORT_ANSWER <>", value, "imgSortAnswer");
            return (Criteria) this;
        }

        public Criteria andImgSortAnswerGreaterThan(String value) {
            addCriterion("IMG_SORT_ANSWER >", value, "imgSortAnswer");
            return (Criteria) this;
        }

        public Criteria andImgSortAnswerGreaterThanOrEqualTo(String value) {
            addCriterion("IMG_SORT_ANSWER >=", value, "imgSortAnswer");
            return (Criteria) this;
        }

        public Criteria andImgSortAnswerLessThan(String value) {
            addCriterion("IMG_SORT_ANSWER <", value, "imgSortAnswer");
            return (Criteria) this;
        }

        public Criteria andImgSortAnswerLessThanOrEqualTo(String value) {
            addCriterion("IMG_SORT_ANSWER <=", value, "imgSortAnswer");
            return (Criteria) this;
        }

        public Criteria andImgSortAnswerLike(String value) {
            addCriterion("IMG_SORT_ANSWER like", value, "imgSortAnswer");
            return (Criteria) this;
        }

        public Criteria andImgSortAnswerNotLike(String value) {
            addCriterion("IMG_SORT_ANSWER not like", value, "imgSortAnswer");
            return (Criteria) this;
        }

        public Criteria andImgSortAnswerIn(List<String> values) {
            addCriterion("IMG_SORT_ANSWER in", values, "imgSortAnswer");
            return (Criteria) this;
        }

        public Criteria andImgSortAnswerNotIn(List<String> values) {
            addCriterion("IMG_SORT_ANSWER not in", values, "imgSortAnswer");
            return (Criteria) this;
        }

        public Criteria andImgSortAnswerBetween(String value1, String value2) {
            addCriterion("IMG_SORT_ANSWER between", value1, value2, "imgSortAnswer");
            return (Criteria) this;
        }

        public Criteria andImgSortAnswerNotBetween(String value1, String value2) {
            addCriterion("IMG_SORT_ANSWER not between", value1, value2, "imgSortAnswer");
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

        public Criteria andTopPicSrcIsNull() {
            addCriterion("TOP_PIC_SRC is null");
            return (Criteria) this;
        }

        public Criteria andTopPicSrcIsNotNull() {
            addCriterion("TOP_PIC_SRC is not null");
            return (Criteria) this;
        }

        public Criteria andTopPicSrcEqualTo(Long value) {
            addCriterion("TOP_PIC_SRC =", value, "topPicSrc");
            return (Criteria) this;
        }

        public Criteria andTopPicSrcNotEqualTo(Long value) {
            addCriterion("TOP_PIC_SRC <>", value, "topPicSrc");
            return (Criteria) this;
        }

        public Criteria andTopPicSrcGreaterThan(Long value) {
            addCriterion("TOP_PIC_SRC >", value, "topPicSrc");
            return (Criteria) this;
        }

        public Criteria andTopPicSrcGreaterThanOrEqualTo(Long value) {
            addCriterion("TOP_PIC_SRC >=", value, "topPicSrc");
            return (Criteria) this;
        }

        public Criteria andTopPicSrcLessThan(Long value) {
            addCriterion("TOP_PIC_SRC <", value, "topPicSrc");
            return (Criteria) this;
        }

        public Criteria andTopPicSrcLessThanOrEqualTo(Long value) {
            addCriterion("TOP_PIC_SRC <=", value, "topPicSrc");
            return (Criteria) this;
        }

        public Criteria andTopPicSrcIn(List<Long> values) {
            addCriterion("TOP_PIC_SRC in", values, "topPicSrc");
            return (Criteria) this;
        }

        public Criteria andTopPicSrcNotIn(List<Long> values) {
            addCriterion("TOP_PIC_SRC not in", values, "topPicSrc");
            return (Criteria) this;
        }

        public Criteria andTopPicSrcBetween(Long value1, Long value2) {
            addCriterion("TOP_PIC_SRC between", value1, value2, "topPicSrc");
            return (Criteria) this;
        }

        public Criteria andTopPicSrcNotBetween(Long value1, Long value2) {
            addCriterion("TOP_PIC_SRC not between", value1, value2, "topPicSrc");
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