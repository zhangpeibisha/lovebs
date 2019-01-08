package org.nix.zpbs.model;

import java.util.ArrayList;
import java.util.List;

public class PhotosExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PhotosExample() {
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

        public Criteria andPhotoIdIsNull() {
            addCriterion("photo_id is null");
            return (Criteria) this;
        }

        public Criteria andPhotoIdIsNotNull() {
            addCriterion("photo_id is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoIdEqualTo(Integer value) {
            addCriterion("photo_id =", value, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdNotEqualTo(Integer value) {
            addCriterion("photo_id <>", value, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdGreaterThan(Integer value) {
            addCriterion("photo_id >", value, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("photo_id >=", value, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdLessThan(Integer value) {
            addCriterion("photo_id <", value, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdLessThanOrEqualTo(Integer value) {
            addCriterion("photo_id <=", value, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdIn(List<Integer> values) {
            addCriterion("photo_id in", values, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdNotIn(List<Integer> values) {
            addCriterion("photo_id not in", values, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdBetween(Integer value1, Integer value2) {
            addCriterion("photo_id between", value1, value2, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdNotBetween(Integer value1, Integer value2) {
            addCriterion("photo_id not between", value1, value2, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoNameIsNull() {
            addCriterion("photo_name is null");
            return (Criteria) this;
        }

        public Criteria andPhotoNameIsNotNull() {
            addCriterion("photo_name is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoNameEqualTo(String value) {
            addCriterion("photo_name =", value, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameNotEqualTo(String value) {
            addCriterion("photo_name <>", value, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameGreaterThan(String value) {
            addCriterion("photo_name >", value, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameGreaterThanOrEqualTo(String value) {
            addCriterion("photo_name >=", value, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameLessThan(String value) {
            addCriterion("photo_name <", value, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameLessThanOrEqualTo(String value) {
            addCriterion("photo_name <=", value, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameLike(String value) {
            addCriterion("photo_name like", value, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameNotLike(String value) {
            addCriterion("photo_name not like", value, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameIn(List<String> values) {
            addCriterion("photo_name in", values, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameNotIn(List<String> values) {
            addCriterion("photo_name not in", values, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameBetween(String value1, String value2) {
            addCriterion("photo_name between", value1, value2, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameNotBetween(String value1, String value2) {
            addCriterion("photo_name not between", value1, value2, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoSrcIsNull() {
            addCriterion("photo_src is null");
            return (Criteria) this;
        }

        public Criteria andPhotoSrcIsNotNull() {
            addCriterion("photo_src is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoSrcEqualTo(String value) {
            addCriterion("photo_src =", value, "photoSrc");
            return (Criteria) this;
        }

        public Criteria andPhotoSrcNotEqualTo(String value) {
            addCriterion("photo_src <>", value, "photoSrc");
            return (Criteria) this;
        }

        public Criteria andPhotoSrcGreaterThan(String value) {
            addCriterion("photo_src >", value, "photoSrc");
            return (Criteria) this;
        }

        public Criteria andPhotoSrcGreaterThanOrEqualTo(String value) {
            addCriterion("photo_src >=", value, "photoSrc");
            return (Criteria) this;
        }

        public Criteria andPhotoSrcLessThan(String value) {
            addCriterion("photo_src <", value, "photoSrc");
            return (Criteria) this;
        }

        public Criteria andPhotoSrcLessThanOrEqualTo(String value) {
            addCriterion("photo_src <=", value, "photoSrc");
            return (Criteria) this;
        }

        public Criteria andPhotoSrcLike(String value) {
            addCriterion("photo_src like", value, "photoSrc");
            return (Criteria) this;
        }

        public Criteria andPhotoSrcNotLike(String value) {
            addCriterion("photo_src not like", value, "photoSrc");
            return (Criteria) this;
        }

        public Criteria andPhotoSrcIn(List<String> values) {
            addCriterion("photo_src in", values, "photoSrc");
            return (Criteria) this;
        }

        public Criteria andPhotoSrcNotIn(List<String> values) {
            addCriterion("photo_src not in", values, "photoSrc");
            return (Criteria) this;
        }

        public Criteria andPhotoSrcBetween(String value1, String value2) {
            addCriterion("photo_src between", value1, value2, "photoSrc");
            return (Criteria) this;
        }

        public Criteria andPhotoSrcNotBetween(String value1, String value2) {
            addCriterion("photo_src not between", value1, value2, "photoSrc");
            return (Criteria) this;
        }

        public Criteria andPhotoDescriptionIsNull() {
            addCriterion("photo_description is null");
            return (Criteria) this;
        }

        public Criteria andPhotoDescriptionIsNotNull() {
            addCriterion("photo_description is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoDescriptionEqualTo(String value) {
            addCriterion("photo_description =", value, "photoDescription");
            return (Criteria) this;
        }

        public Criteria andPhotoDescriptionNotEqualTo(String value) {
            addCriterion("photo_description <>", value, "photoDescription");
            return (Criteria) this;
        }

        public Criteria andPhotoDescriptionGreaterThan(String value) {
            addCriterion("photo_description >", value, "photoDescription");
            return (Criteria) this;
        }

        public Criteria andPhotoDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("photo_description >=", value, "photoDescription");
            return (Criteria) this;
        }

        public Criteria andPhotoDescriptionLessThan(String value) {
            addCriterion("photo_description <", value, "photoDescription");
            return (Criteria) this;
        }

        public Criteria andPhotoDescriptionLessThanOrEqualTo(String value) {
            addCriterion("photo_description <=", value, "photoDescription");
            return (Criteria) this;
        }

        public Criteria andPhotoDescriptionLike(String value) {
            addCriterion("photo_description like", value, "photoDescription");
            return (Criteria) this;
        }

        public Criteria andPhotoDescriptionNotLike(String value) {
            addCriterion("photo_description not like", value, "photoDescription");
            return (Criteria) this;
        }

        public Criteria andPhotoDescriptionIn(List<String> values) {
            addCriterion("photo_description in", values, "photoDescription");
            return (Criteria) this;
        }

        public Criteria andPhotoDescriptionNotIn(List<String> values) {
            addCriterion("photo_description not in", values, "photoDescription");
            return (Criteria) this;
        }

        public Criteria andPhotoDescriptionBetween(String value1, String value2) {
            addCriterion("photo_description between", value1, value2, "photoDescription");
            return (Criteria) this;
        }

        public Criteria andPhotoDescriptionNotBetween(String value1, String value2) {
            addCriterion("photo_description not between", value1, value2, "photoDescription");
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

        public Criteria andSortIdIsNull() {
            addCriterion("sort_id is null");
            return (Criteria) this;
        }

        public Criteria andSortIdIsNotNull() {
            addCriterion("sort_id is not null");
            return (Criteria) this;
        }

        public Criteria andSortIdEqualTo(Integer value) {
            addCriterion("sort_id =", value, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdNotEqualTo(Integer value) {
            addCriterion("sort_id <>", value, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdGreaterThan(Integer value) {
            addCriterion("sort_id >", value, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort_id >=", value, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdLessThan(Integer value) {
            addCriterion("sort_id <", value, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdLessThanOrEqualTo(Integer value) {
            addCriterion("sort_id <=", value, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdIn(List<Integer> values) {
            addCriterion("sort_id in", values, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdNotIn(List<Integer> values) {
            addCriterion("sort_id not in", values, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdBetween(Integer value1, Integer value2) {
            addCriterion("sort_id between", value1, value2, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sort_id not between", value1, value2, "sortId");
            return (Criteria) this;
        }

        public Criteria andUploadTimeIsNull() {
            addCriterion("upload_time is null");
            return (Criteria) this;
        }

        public Criteria andUploadTimeIsNotNull() {
            addCriterion("upload_time is not null");
            return (Criteria) this;
        }

        public Criteria andUploadTimeEqualTo(Integer value) {
            addCriterion("upload_time =", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeNotEqualTo(Integer value) {
            addCriterion("upload_time <>", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeGreaterThan(Integer value) {
            addCriterion("upload_time >", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("upload_time >=", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeLessThan(Integer value) {
            addCriterion("upload_time <", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeLessThanOrEqualTo(Integer value) {
            addCriterion("upload_time <=", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeIn(List<Integer> values) {
            addCriterion("upload_time in", values, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeNotIn(List<Integer> values) {
            addCriterion("upload_time not in", values, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeBetween(Integer value1, Integer value2) {
            addCriterion("upload_time between", value1, value2, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("upload_time not between", value1, value2, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadIpIsNull() {
            addCriterion("upload_ip is null");
            return (Criteria) this;
        }

        public Criteria andUploadIpIsNotNull() {
            addCriterion("upload_ip is not null");
            return (Criteria) this;
        }

        public Criteria andUploadIpEqualTo(String value) {
            addCriterion("upload_ip =", value, "uploadIp");
            return (Criteria) this;
        }

        public Criteria andUploadIpNotEqualTo(String value) {
            addCriterion("upload_ip <>", value, "uploadIp");
            return (Criteria) this;
        }

        public Criteria andUploadIpGreaterThan(String value) {
            addCriterion("upload_ip >", value, "uploadIp");
            return (Criteria) this;
        }

        public Criteria andUploadIpGreaterThanOrEqualTo(String value) {
            addCriterion("upload_ip >=", value, "uploadIp");
            return (Criteria) this;
        }

        public Criteria andUploadIpLessThan(String value) {
            addCriterion("upload_ip <", value, "uploadIp");
            return (Criteria) this;
        }

        public Criteria andUploadIpLessThanOrEqualTo(String value) {
            addCriterion("upload_ip <=", value, "uploadIp");
            return (Criteria) this;
        }

        public Criteria andUploadIpLike(String value) {
            addCriterion("upload_ip like", value, "uploadIp");
            return (Criteria) this;
        }

        public Criteria andUploadIpNotLike(String value) {
            addCriterion("upload_ip not like", value, "uploadIp");
            return (Criteria) this;
        }

        public Criteria andUploadIpIn(List<String> values) {
            addCriterion("upload_ip in", values, "uploadIp");
            return (Criteria) this;
        }

        public Criteria andUploadIpNotIn(List<String> values) {
            addCriterion("upload_ip not in", values, "uploadIp");
            return (Criteria) this;
        }

        public Criteria andUploadIpBetween(String value1, String value2) {
            addCriterion("upload_ip between", value1, value2, "uploadIp");
            return (Criteria) this;
        }

        public Criteria andUploadIpNotBetween(String value1, String value2) {
            addCriterion("upload_ip not between", value1, value2, "uploadIp");
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