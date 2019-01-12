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

        public Criteria andPhotoNameIsNull() {
            addCriterion("PHOTO_NAME is null");
            return (Criteria) this;
        }

        public Criteria andPhotoNameIsNotNull() {
            addCriterion("PHOTO_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoNameEqualTo(String value) {
            addCriterion("PHOTO_NAME =", value, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameNotEqualTo(String value) {
            addCriterion("PHOTO_NAME <>", value, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameGreaterThan(String value) {
            addCriterion("PHOTO_NAME >", value, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameGreaterThanOrEqualTo(String value) {
            addCriterion("PHOTO_NAME >=", value, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameLessThan(String value) {
            addCriterion("PHOTO_NAME <", value, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameLessThanOrEqualTo(String value) {
            addCriterion("PHOTO_NAME <=", value, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameLike(String value) {
            addCriterion("PHOTO_NAME like", value, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameNotLike(String value) {
            addCriterion("PHOTO_NAME not like", value, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameIn(List<String> values) {
            addCriterion("PHOTO_NAME in", values, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameNotIn(List<String> values) {
            addCriterion("PHOTO_NAME not in", values, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameBetween(String value1, String value2) {
            addCriterion("PHOTO_NAME between", value1, value2, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameNotBetween(String value1, String value2) {
            addCriterion("PHOTO_NAME not between", value1, value2, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoSrcIsNull() {
            addCriterion("PHOTO_SRC is null");
            return (Criteria) this;
        }

        public Criteria andPhotoSrcIsNotNull() {
            addCriterion("PHOTO_SRC is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoSrcEqualTo(String value) {
            addCriterion("PHOTO_SRC =", value, "photoSrc");
            return (Criteria) this;
        }

        public Criteria andPhotoSrcNotEqualTo(String value) {
            addCriterion("PHOTO_SRC <>", value, "photoSrc");
            return (Criteria) this;
        }

        public Criteria andPhotoSrcGreaterThan(String value) {
            addCriterion("PHOTO_SRC >", value, "photoSrc");
            return (Criteria) this;
        }

        public Criteria andPhotoSrcGreaterThanOrEqualTo(String value) {
            addCriterion("PHOTO_SRC >=", value, "photoSrc");
            return (Criteria) this;
        }

        public Criteria andPhotoSrcLessThan(String value) {
            addCriterion("PHOTO_SRC <", value, "photoSrc");
            return (Criteria) this;
        }

        public Criteria andPhotoSrcLessThanOrEqualTo(String value) {
            addCriterion("PHOTO_SRC <=", value, "photoSrc");
            return (Criteria) this;
        }

        public Criteria andPhotoSrcLike(String value) {
            addCriterion("PHOTO_SRC like", value, "photoSrc");
            return (Criteria) this;
        }

        public Criteria andPhotoSrcNotLike(String value) {
            addCriterion("PHOTO_SRC not like", value, "photoSrc");
            return (Criteria) this;
        }

        public Criteria andPhotoSrcIn(List<String> values) {
            addCriterion("PHOTO_SRC in", values, "photoSrc");
            return (Criteria) this;
        }

        public Criteria andPhotoSrcNotIn(List<String> values) {
            addCriterion("PHOTO_SRC not in", values, "photoSrc");
            return (Criteria) this;
        }

        public Criteria andPhotoSrcBetween(String value1, String value2) {
            addCriterion("PHOTO_SRC between", value1, value2, "photoSrc");
            return (Criteria) this;
        }

        public Criteria andPhotoSrcNotBetween(String value1, String value2) {
            addCriterion("PHOTO_SRC not between", value1, value2, "photoSrc");
            return (Criteria) this;
        }

        public Criteria andPhotoDescriptionIsNull() {
            addCriterion("PHOTO_DESCRIPTION is null");
            return (Criteria) this;
        }

        public Criteria andPhotoDescriptionIsNotNull() {
            addCriterion("PHOTO_DESCRIPTION is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoDescriptionEqualTo(String value) {
            addCriterion("PHOTO_DESCRIPTION =", value, "photoDescription");
            return (Criteria) this;
        }

        public Criteria andPhotoDescriptionNotEqualTo(String value) {
            addCriterion("PHOTO_DESCRIPTION <>", value, "photoDescription");
            return (Criteria) this;
        }

        public Criteria andPhotoDescriptionGreaterThan(String value) {
            addCriterion("PHOTO_DESCRIPTION >", value, "photoDescription");
            return (Criteria) this;
        }

        public Criteria andPhotoDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("PHOTO_DESCRIPTION >=", value, "photoDescription");
            return (Criteria) this;
        }

        public Criteria andPhotoDescriptionLessThan(String value) {
            addCriterion("PHOTO_DESCRIPTION <", value, "photoDescription");
            return (Criteria) this;
        }

        public Criteria andPhotoDescriptionLessThanOrEqualTo(String value) {
            addCriterion("PHOTO_DESCRIPTION <=", value, "photoDescription");
            return (Criteria) this;
        }

        public Criteria andPhotoDescriptionLike(String value) {
            addCriterion("PHOTO_DESCRIPTION like", value, "photoDescription");
            return (Criteria) this;
        }

        public Criteria andPhotoDescriptionNotLike(String value) {
            addCriterion("PHOTO_DESCRIPTION not like", value, "photoDescription");
            return (Criteria) this;
        }

        public Criteria andPhotoDescriptionIn(List<String> values) {
            addCriterion("PHOTO_DESCRIPTION in", values, "photoDescription");
            return (Criteria) this;
        }

        public Criteria andPhotoDescriptionNotIn(List<String> values) {
            addCriterion("PHOTO_DESCRIPTION not in", values, "photoDescription");
            return (Criteria) this;
        }

        public Criteria andPhotoDescriptionBetween(String value1, String value2) {
            addCriterion("PHOTO_DESCRIPTION between", value1, value2, "photoDescription");
            return (Criteria) this;
        }

        public Criteria andPhotoDescriptionNotBetween(String value1, String value2) {
            addCriterion("PHOTO_DESCRIPTION not between", value1, value2, "photoDescription");
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

        public Criteria andSortIdIsNull() {
            addCriterion("SORT_ID is null");
            return (Criteria) this;
        }

        public Criteria andSortIdIsNotNull() {
            addCriterion("SORT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSortIdEqualTo(Long value) {
            addCriterion("SORT_ID =", value, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdNotEqualTo(Long value) {
            addCriterion("SORT_ID <>", value, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdGreaterThan(Long value) {
            addCriterion("SORT_ID >", value, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdGreaterThanOrEqualTo(Long value) {
            addCriterion("SORT_ID >=", value, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdLessThan(Long value) {
            addCriterion("SORT_ID <", value, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdLessThanOrEqualTo(Long value) {
            addCriterion("SORT_ID <=", value, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdIn(List<Long> values) {
            addCriterion("SORT_ID in", values, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdNotIn(List<Long> values) {
            addCriterion("SORT_ID not in", values, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdBetween(Long value1, Long value2) {
            addCriterion("SORT_ID between", value1, value2, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdNotBetween(Long value1, Long value2) {
            addCriterion("SORT_ID not between", value1, value2, "sortId");
            return (Criteria) this;
        }

        public Criteria andUploadTimeIsNull() {
            addCriterion("UPLOAD_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUploadTimeIsNotNull() {
            addCriterion("UPLOAD_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUploadTimeEqualTo(Long value) {
            addCriterion("UPLOAD_TIME =", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeNotEqualTo(Long value) {
            addCriterion("UPLOAD_TIME <>", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeGreaterThan(Long value) {
            addCriterion("UPLOAD_TIME >", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("UPLOAD_TIME >=", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeLessThan(Long value) {
            addCriterion("UPLOAD_TIME <", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeLessThanOrEqualTo(Long value) {
            addCriterion("UPLOAD_TIME <=", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeIn(List<Long> values) {
            addCriterion("UPLOAD_TIME in", values, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeNotIn(List<Long> values) {
            addCriterion("UPLOAD_TIME not in", values, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeBetween(Long value1, Long value2) {
            addCriterion("UPLOAD_TIME between", value1, value2, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeNotBetween(Long value1, Long value2) {
            addCriterion("UPLOAD_TIME not between", value1, value2, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadIpIsNull() {
            addCriterion("UPLOAD_IP is null");
            return (Criteria) this;
        }

        public Criteria andUploadIpIsNotNull() {
            addCriterion("UPLOAD_IP is not null");
            return (Criteria) this;
        }

        public Criteria andUploadIpEqualTo(String value) {
            addCriterion("UPLOAD_IP =", value, "uploadIp");
            return (Criteria) this;
        }

        public Criteria andUploadIpNotEqualTo(String value) {
            addCriterion("UPLOAD_IP <>", value, "uploadIp");
            return (Criteria) this;
        }

        public Criteria andUploadIpGreaterThan(String value) {
            addCriterion("UPLOAD_IP >", value, "uploadIp");
            return (Criteria) this;
        }

        public Criteria andUploadIpGreaterThanOrEqualTo(String value) {
            addCriterion("UPLOAD_IP >=", value, "uploadIp");
            return (Criteria) this;
        }

        public Criteria andUploadIpLessThan(String value) {
            addCriterion("UPLOAD_IP <", value, "uploadIp");
            return (Criteria) this;
        }

        public Criteria andUploadIpLessThanOrEqualTo(String value) {
            addCriterion("UPLOAD_IP <=", value, "uploadIp");
            return (Criteria) this;
        }

        public Criteria andUploadIpLike(String value) {
            addCriterion("UPLOAD_IP like", value, "uploadIp");
            return (Criteria) this;
        }

        public Criteria andUploadIpNotLike(String value) {
            addCriterion("UPLOAD_IP not like", value, "uploadIp");
            return (Criteria) this;
        }

        public Criteria andUploadIpIn(List<String> values) {
            addCriterion("UPLOAD_IP in", values, "uploadIp");
            return (Criteria) this;
        }

        public Criteria andUploadIpNotIn(List<String> values) {
            addCriterion("UPLOAD_IP not in", values, "uploadIp");
            return (Criteria) this;
        }

        public Criteria andUploadIpBetween(String value1, String value2) {
            addCriterion("UPLOAD_IP between", value1, value2, "uploadIp");
            return (Criteria) this;
        }

        public Criteria andUploadIpNotBetween(String value1, String value2) {
            addCriterion("UPLOAD_IP not between", value1, value2, "uploadIp");
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