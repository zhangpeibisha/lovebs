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

        public Criteria andSortImgIdIsNull() {
            addCriterion("sort_img_id is null");
            return (Criteria) this;
        }

        public Criteria andSortImgIdIsNotNull() {
            addCriterion("sort_img_id is not null");
            return (Criteria) this;
        }

        public Criteria andSortImgIdEqualTo(Long value) {
            addCriterion("sort_img_id =", value, "sortImgId");
            return (Criteria) this;
        }

        public Criteria andSortImgIdNotEqualTo(Long value) {
            addCriterion("sort_img_id <>", value, "sortImgId");
            return (Criteria) this;
        }

        public Criteria andSortImgIdGreaterThan(Long value) {
            addCriterion("sort_img_id >", value, "sortImgId");
            return (Criteria) this;
        }

        public Criteria andSortImgIdGreaterThanOrEqualTo(Long value) {
            addCriterion("sort_img_id >=", value, "sortImgId");
            return (Criteria) this;
        }

        public Criteria andSortImgIdLessThan(Long value) {
            addCriterion("sort_img_id <", value, "sortImgId");
            return (Criteria) this;
        }

        public Criteria andSortImgIdLessThanOrEqualTo(Long value) {
            addCriterion("sort_img_id <=", value, "sortImgId");
            return (Criteria) this;
        }

        public Criteria andSortImgIdIn(List<Long> values) {
            addCriterion("sort_img_id in", values, "sortImgId");
            return (Criteria) this;
        }

        public Criteria andSortImgIdNotIn(List<Long> values) {
            addCriterion("sort_img_id not in", values, "sortImgId");
            return (Criteria) this;
        }

        public Criteria andSortImgIdBetween(Long value1, Long value2) {
            addCriterion("sort_img_id between", value1, value2, "sortImgId");
            return (Criteria) this;
        }

        public Criteria andSortImgIdNotBetween(Long value1, Long value2) {
            addCriterion("sort_img_id not between", value1, value2, "sortImgId");
            return (Criteria) this;
        }

        public Criteria andSortImgNameIsNull() {
            addCriterion("sort_img_name is null");
            return (Criteria) this;
        }

        public Criteria andSortImgNameIsNotNull() {
            addCriterion("sort_img_name is not null");
            return (Criteria) this;
        }

        public Criteria andSortImgNameEqualTo(String value) {
            addCriterion("sort_img_name =", value, "sortImgName");
            return (Criteria) this;
        }

        public Criteria andSortImgNameNotEqualTo(String value) {
            addCriterion("sort_img_name <>", value, "sortImgName");
            return (Criteria) this;
        }

        public Criteria andSortImgNameGreaterThan(String value) {
            addCriterion("sort_img_name >", value, "sortImgName");
            return (Criteria) this;
        }

        public Criteria andSortImgNameGreaterThanOrEqualTo(String value) {
            addCriterion("sort_img_name >=", value, "sortImgName");
            return (Criteria) this;
        }

        public Criteria andSortImgNameLessThan(String value) {
            addCriterion("sort_img_name <", value, "sortImgName");
            return (Criteria) this;
        }

        public Criteria andSortImgNameLessThanOrEqualTo(String value) {
            addCriterion("sort_img_name <=", value, "sortImgName");
            return (Criteria) this;
        }

        public Criteria andSortImgNameLike(String value) {
            addCriterion("sort_img_name like", value, "sortImgName");
            return (Criteria) this;
        }

        public Criteria andSortImgNameNotLike(String value) {
            addCriterion("sort_img_name not like", value, "sortImgName");
            return (Criteria) this;
        }

        public Criteria andSortImgNameIn(List<String> values) {
            addCriterion("sort_img_name in", values, "sortImgName");
            return (Criteria) this;
        }

        public Criteria andSortImgNameNotIn(List<String> values) {
            addCriterion("sort_img_name not in", values, "sortImgName");
            return (Criteria) this;
        }

        public Criteria andSortImgNameBetween(String value1, String value2) {
            addCriterion("sort_img_name between", value1, value2, "sortImgName");
            return (Criteria) this;
        }

        public Criteria andSortImgNameNotBetween(String value1, String value2) {
            addCriterion("sort_img_name not between", value1, value2, "sortImgName");
            return (Criteria) this;
        }

        public Criteria andSortImgTypeIsNull() {
            addCriterion("sort_img_type is null");
            return (Criteria) this;
        }

        public Criteria andSortImgTypeIsNotNull() {
            addCriterion("sort_img_type is not null");
            return (Criteria) this;
        }

        public Criteria andSortImgTypeEqualTo(String value) {
            addCriterion("sort_img_type =", value, "sortImgType");
            return (Criteria) this;
        }

        public Criteria andSortImgTypeNotEqualTo(String value) {
            addCriterion("sort_img_type <>", value, "sortImgType");
            return (Criteria) this;
        }

        public Criteria andSortImgTypeGreaterThan(String value) {
            addCriterion("sort_img_type >", value, "sortImgType");
            return (Criteria) this;
        }

        public Criteria andSortImgTypeGreaterThanOrEqualTo(String value) {
            addCriterion("sort_img_type >=", value, "sortImgType");
            return (Criteria) this;
        }

        public Criteria andSortImgTypeLessThan(String value) {
            addCriterion("sort_img_type <", value, "sortImgType");
            return (Criteria) this;
        }

        public Criteria andSortImgTypeLessThanOrEqualTo(String value) {
            addCriterion("sort_img_type <=", value, "sortImgType");
            return (Criteria) this;
        }

        public Criteria andSortImgTypeLike(String value) {
            addCriterion("sort_img_type like", value, "sortImgType");
            return (Criteria) this;
        }

        public Criteria andSortImgTypeNotLike(String value) {
            addCriterion("sort_img_type not like", value, "sortImgType");
            return (Criteria) this;
        }

        public Criteria andSortImgTypeIn(List<String> values) {
            addCriterion("sort_img_type in", values, "sortImgType");
            return (Criteria) this;
        }

        public Criteria andSortImgTypeNotIn(List<String> values) {
            addCriterion("sort_img_type not in", values, "sortImgType");
            return (Criteria) this;
        }

        public Criteria andSortImgTypeBetween(String value1, String value2) {
            addCriterion("sort_img_type between", value1, value2, "sortImgType");
            return (Criteria) this;
        }

        public Criteria andSortImgTypeNotBetween(String value1, String value2) {
            addCriterion("sort_img_type not between", value1, value2, "sortImgType");
            return (Criteria) this;
        }

        public Criteria andImgPasswordIsNull() {
            addCriterion("img_password is null");
            return (Criteria) this;
        }

        public Criteria andImgPasswordIsNotNull() {
            addCriterion("img_password is not null");
            return (Criteria) this;
        }

        public Criteria andImgPasswordEqualTo(String value) {
            addCriterion("img_password =", value, "imgPassword");
            return (Criteria) this;
        }

        public Criteria andImgPasswordNotEqualTo(String value) {
            addCriterion("img_password <>", value, "imgPassword");
            return (Criteria) this;
        }

        public Criteria andImgPasswordGreaterThan(String value) {
            addCriterion("img_password >", value, "imgPassword");
            return (Criteria) this;
        }

        public Criteria andImgPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("img_password >=", value, "imgPassword");
            return (Criteria) this;
        }

        public Criteria andImgPasswordLessThan(String value) {
            addCriterion("img_password <", value, "imgPassword");
            return (Criteria) this;
        }

        public Criteria andImgPasswordLessThanOrEqualTo(String value) {
            addCriterion("img_password <=", value, "imgPassword");
            return (Criteria) this;
        }

        public Criteria andImgPasswordLike(String value) {
            addCriterion("img_password like", value, "imgPassword");
            return (Criteria) this;
        }

        public Criteria andImgPasswordNotLike(String value) {
            addCriterion("img_password not like", value, "imgPassword");
            return (Criteria) this;
        }

        public Criteria andImgPasswordIn(List<String> values) {
            addCriterion("img_password in", values, "imgPassword");
            return (Criteria) this;
        }

        public Criteria andImgPasswordNotIn(List<String> values) {
            addCriterion("img_password not in", values, "imgPassword");
            return (Criteria) this;
        }

        public Criteria andImgPasswordBetween(String value1, String value2) {
            addCriterion("img_password between", value1, value2, "imgPassword");
            return (Criteria) this;
        }

        public Criteria andImgPasswordNotBetween(String value1, String value2) {
            addCriterion("img_password not between", value1, value2, "imgPassword");
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

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andImgSortQuestionIsNull() {
            addCriterion("img_sort_question is null");
            return (Criteria) this;
        }

        public Criteria andImgSortQuestionIsNotNull() {
            addCriterion("img_sort_question is not null");
            return (Criteria) this;
        }

        public Criteria andImgSortQuestionEqualTo(String value) {
            addCriterion("img_sort_question =", value, "imgSortQuestion");
            return (Criteria) this;
        }

        public Criteria andImgSortQuestionNotEqualTo(String value) {
            addCriterion("img_sort_question <>", value, "imgSortQuestion");
            return (Criteria) this;
        }

        public Criteria andImgSortQuestionGreaterThan(String value) {
            addCriterion("img_sort_question >", value, "imgSortQuestion");
            return (Criteria) this;
        }

        public Criteria andImgSortQuestionGreaterThanOrEqualTo(String value) {
            addCriterion("img_sort_question >=", value, "imgSortQuestion");
            return (Criteria) this;
        }

        public Criteria andImgSortQuestionLessThan(String value) {
            addCriterion("img_sort_question <", value, "imgSortQuestion");
            return (Criteria) this;
        }

        public Criteria andImgSortQuestionLessThanOrEqualTo(String value) {
            addCriterion("img_sort_question <=", value, "imgSortQuestion");
            return (Criteria) this;
        }

        public Criteria andImgSortQuestionLike(String value) {
            addCriterion("img_sort_question like", value, "imgSortQuestion");
            return (Criteria) this;
        }

        public Criteria andImgSortQuestionNotLike(String value) {
            addCriterion("img_sort_question not like", value, "imgSortQuestion");
            return (Criteria) this;
        }

        public Criteria andImgSortQuestionIn(List<String> values) {
            addCriterion("img_sort_question in", values, "imgSortQuestion");
            return (Criteria) this;
        }

        public Criteria andImgSortQuestionNotIn(List<String> values) {
            addCriterion("img_sort_question not in", values, "imgSortQuestion");
            return (Criteria) this;
        }

        public Criteria andImgSortQuestionBetween(String value1, String value2) {
            addCriterion("img_sort_question between", value1, value2, "imgSortQuestion");
            return (Criteria) this;
        }

        public Criteria andImgSortQuestionNotBetween(String value1, String value2) {
            addCriterion("img_sort_question not between", value1, value2, "imgSortQuestion");
            return (Criteria) this;
        }

        public Criteria andImgSortAnswerIsNull() {
            addCriterion("img_sort_answer is null");
            return (Criteria) this;
        }

        public Criteria andImgSortAnswerIsNotNull() {
            addCriterion("img_sort_answer is not null");
            return (Criteria) this;
        }

        public Criteria andImgSortAnswerEqualTo(String value) {
            addCriterion("img_sort_answer =", value, "imgSortAnswer");
            return (Criteria) this;
        }

        public Criteria andImgSortAnswerNotEqualTo(String value) {
            addCriterion("img_sort_answer <>", value, "imgSortAnswer");
            return (Criteria) this;
        }

        public Criteria andImgSortAnswerGreaterThan(String value) {
            addCriterion("img_sort_answer >", value, "imgSortAnswer");
            return (Criteria) this;
        }

        public Criteria andImgSortAnswerGreaterThanOrEqualTo(String value) {
            addCriterion("img_sort_answer >=", value, "imgSortAnswer");
            return (Criteria) this;
        }

        public Criteria andImgSortAnswerLessThan(String value) {
            addCriterion("img_sort_answer <", value, "imgSortAnswer");
            return (Criteria) this;
        }

        public Criteria andImgSortAnswerLessThanOrEqualTo(String value) {
            addCriterion("img_sort_answer <=", value, "imgSortAnswer");
            return (Criteria) this;
        }

        public Criteria andImgSortAnswerLike(String value) {
            addCriterion("img_sort_answer like", value, "imgSortAnswer");
            return (Criteria) this;
        }

        public Criteria andImgSortAnswerNotLike(String value) {
            addCriterion("img_sort_answer not like", value, "imgSortAnswer");
            return (Criteria) this;
        }

        public Criteria andImgSortAnswerIn(List<String> values) {
            addCriterion("img_sort_answer in", values, "imgSortAnswer");
            return (Criteria) this;
        }

        public Criteria andImgSortAnswerNotIn(List<String> values) {
            addCriterion("img_sort_answer not in", values, "imgSortAnswer");
            return (Criteria) this;
        }

        public Criteria andImgSortAnswerBetween(String value1, String value2) {
            addCriterion("img_sort_answer between", value1, value2, "imgSortAnswer");
            return (Criteria) this;
        }

        public Criteria andImgSortAnswerNotBetween(String value1, String value2) {
            addCriterion("img_sort_answer not between", value1, value2, "imgSortAnswer");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNull() {
            addCriterion("type_id is null");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNotNull() {
            addCriterion("type_id is not null");
            return (Criteria) this;
        }

        public Criteria andTypeIdEqualTo(Integer value) {
            addCriterion("type_id =", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotEqualTo(Integer value) {
            addCriterion("type_id <>", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThan(Integer value) {
            addCriterion("type_id >", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("type_id >=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThan(Integer value) {
            addCriterion("type_id <", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("type_id <=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIn(List<Integer> values) {
            addCriterion("type_id in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotIn(List<Integer> values) {
            addCriterion("type_id not in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("type_id between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("type_id not between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTopPicSrcIsNull() {
            addCriterion("top_pic_src is null");
            return (Criteria) this;
        }

        public Criteria andTopPicSrcIsNotNull() {
            addCriterion("top_pic_src is not null");
            return (Criteria) this;
        }

        public Criteria andTopPicSrcEqualTo(Long value) {
            addCriterion("top_pic_src =", value, "topPicSrc");
            return (Criteria) this;
        }

        public Criteria andTopPicSrcNotEqualTo(Long value) {
            addCriterion("top_pic_src <>", value, "topPicSrc");
            return (Criteria) this;
        }

        public Criteria andTopPicSrcGreaterThan(Long value) {
            addCriterion("top_pic_src >", value, "topPicSrc");
            return (Criteria) this;
        }

        public Criteria andTopPicSrcGreaterThanOrEqualTo(Long value) {
            addCriterion("top_pic_src >=", value, "topPicSrc");
            return (Criteria) this;
        }

        public Criteria andTopPicSrcLessThan(Long value) {
            addCriterion("top_pic_src <", value, "topPicSrc");
            return (Criteria) this;
        }

        public Criteria andTopPicSrcLessThanOrEqualTo(Long value) {
            addCriterion("top_pic_src <=", value, "topPicSrc");
            return (Criteria) this;
        }

        public Criteria andTopPicSrcIn(List<Long> values) {
            addCriterion("top_pic_src in", values, "topPicSrc");
            return (Criteria) this;
        }

        public Criteria andTopPicSrcNotIn(List<Long> values) {
            addCriterion("top_pic_src not in", values, "topPicSrc");
            return (Criteria) this;
        }

        public Criteria andTopPicSrcBetween(Long value1, Long value2) {
            addCriterion("top_pic_src between", value1, value2, "topPicSrc");
            return (Criteria) this;
        }

        public Criteria andTopPicSrcNotBetween(Long value1, Long value2) {
            addCriterion("top_pic_src not between", value1, value2, "topPicSrc");
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