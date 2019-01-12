package org.nix.zpbs.model;

import java.util.ArrayList;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        public Criteria andGroupIdIsNull() {
            addCriterion("GROUP_ID is null");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNotNull() {
            addCriterion("GROUP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andGroupIdEqualTo(Long value) {
            addCriterion("GROUP_ID =", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotEqualTo(Long value) {
            addCriterion("GROUP_ID <>", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThan(Long value) {
            addCriterion("GROUP_ID >", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThanOrEqualTo(Long value) {
            addCriterion("GROUP_ID >=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThan(Long value) {
            addCriterion("GROUP_ID <", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThanOrEqualTo(Long value) {
            addCriterion("GROUP_ID <=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdIn(List<Long> values) {
            addCriterion("GROUP_ID in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotIn(List<Long> values) {
            addCriterion("GROUP_ID not in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdBetween(Long value1, Long value2) {
            addCriterion("GROUP_ID between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotBetween(Long value1, Long value2) {
            addCriterion("GROUP_ID not between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("USER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("USER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("USER_NAME =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("USER_NAME <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("USER_NAME >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("USER_NAME >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("USER_NAME <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("USER_NAME <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("USER_NAME like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("USER_NAME not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("USER_NAME in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("USER_NAME not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("USER_NAME between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("USER_NAME not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserPwdIsNull() {
            addCriterion("USER_PWD is null");
            return (Criteria) this;
        }

        public Criteria andUserPwdIsNotNull() {
            addCriterion("USER_PWD is not null");
            return (Criteria) this;
        }

        public Criteria andUserPwdEqualTo(String value) {
            addCriterion("USER_PWD =", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdNotEqualTo(String value) {
            addCriterion("USER_PWD <>", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdGreaterThan(String value) {
            addCriterion("USER_PWD >", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdGreaterThanOrEqualTo(String value) {
            addCriterion("USER_PWD >=", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdLessThan(String value) {
            addCriterion("USER_PWD <", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdLessThanOrEqualTo(String value) {
            addCriterion("USER_PWD <=", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdLike(String value) {
            addCriterion("USER_PWD like", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdNotLike(String value) {
            addCriterion("USER_PWD not like", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdIn(List<String> values) {
            addCriterion("USER_PWD in", values, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdNotIn(List<String> values) {
            addCriterion("USER_PWD not in", values, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdBetween(String value1, String value2) {
            addCriterion("USER_PWD between", value1, value2, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdNotBetween(String value1, String value2) {
            addCriterion("USER_PWD not between", value1, value2, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNull() {
            addCriterion("USER_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNotNull() {
            addCriterion("USER_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneEqualTo(Long value) {
            addCriterion("USER_PHONE =", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotEqualTo(Long value) {
            addCriterion("USER_PHONE <>", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThan(Long value) {
            addCriterion("USER_PHONE >", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThanOrEqualTo(Long value) {
            addCriterion("USER_PHONE >=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThan(Long value) {
            addCriterion("USER_PHONE <", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThanOrEqualTo(Long value) {
            addCriterion("USER_PHONE <=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIn(List<Long> values) {
            addCriterion("USER_PHONE in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotIn(List<Long> values) {
            addCriterion("USER_PHONE not in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneBetween(Long value1, Long value2) {
            addCriterion("USER_PHONE between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotBetween(Long value1, Long value2) {
            addCriterion("USER_PHONE not between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserSexIsNull() {
            addCriterion("USER_SEX is null");
            return (Criteria) this;
        }

        public Criteria andUserSexIsNotNull() {
            addCriterion("USER_SEX is not null");
            return (Criteria) this;
        }

        public Criteria andUserSexEqualTo(String value) {
            addCriterion("USER_SEX =", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotEqualTo(String value) {
            addCriterion("USER_SEX <>", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexGreaterThan(String value) {
            addCriterion("USER_SEX >", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexGreaterThanOrEqualTo(String value) {
            addCriterion("USER_SEX >=", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexLessThan(String value) {
            addCriterion("USER_SEX <", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexLessThanOrEqualTo(String value) {
            addCriterion("USER_SEX <=", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexLike(String value) {
            addCriterion("USER_SEX like", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotLike(String value) {
            addCriterion("USER_SEX not like", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexIn(List<String> values) {
            addCriterion("USER_SEX in", values, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotIn(List<String> values) {
            addCriterion("USER_SEX not in", values, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexBetween(String value1, String value2) {
            addCriterion("USER_SEX between", value1, value2, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotBetween(String value1, String value2) {
            addCriterion("USER_SEX not between", value1, value2, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserQqIsNull() {
            addCriterion("USER_QQ is null");
            return (Criteria) this;
        }

        public Criteria andUserQqIsNotNull() {
            addCriterion("USER_QQ is not null");
            return (Criteria) this;
        }

        public Criteria andUserQqEqualTo(Long value) {
            addCriterion("USER_QQ =", value, "userQq");
            return (Criteria) this;
        }

        public Criteria andUserQqNotEqualTo(Long value) {
            addCriterion("USER_QQ <>", value, "userQq");
            return (Criteria) this;
        }

        public Criteria andUserQqGreaterThan(Long value) {
            addCriterion("USER_QQ >", value, "userQq");
            return (Criteria) this;
        }

        public Criteria andUserQqGreaterThanOrEqualTo(Long value) {
            addCriterion("USER_QQ >=", value, "userQq");
            return (Criteria) this;
        }

        public Criteria andUserQqLessThan(Long value) {
            addCriterion("USER_QQ <", value, "userQq");
            return (Criteria) this;
        }

        public Criteria andUserQqLessThanOrEqualTo(Long value) {
            addCriterion("USER_QQ <=", value, "userQq");
            return (Criteria) this;
        }

        public Criteria andUserQqIn(List<Long> values) {
            addCriterion("USER_QQ in", values, "userQq");
            return (Criteria) this;
        }

        public Criteria andUserQqNotIn(List<Long> values) {
            addCriterion("USER_QQ not in", values, "userQq");
            return (Criteria) this;
        }

        public Criteria andUserQqBetween(Long value1, Long value2) {
            addCriterion("USER_QQ between", value1, value2, "userQq");
            return (Criteria) this;
        }

        public Criteria andUserQqNotBetween(Long value1, Long value2) {
            addCriterion("USER_QQ not between", value1, value2, "userQq");
            return (Criteria) this;
        }

        public Criteria andUserEmailIsNull() {
            addCriterion("USER_EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andUserEmailIsNotNull() {
            addCriterion("USER_EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andUserEmailEqualTo(String value) {
            addCriterion("USER_EMAIL =", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotEqualTo(String value) {
            addCriterion("USER_EMAIL <>", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailGreaterThan(String value) {
            addCriterion("USER_EMAIL >", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailGreaterThanOrEqualTo(String value) {
            addCriterion("USER_EMAIL >=", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLessThan(String value) {
            addCriterion("USER_EMAIL <", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLessThanOrEqualTo(String value) {
            addCriterion("USER_EMAIL <=", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLike(String value) {
            addCriterion("USER_EMAIL like", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotLike(String value) {
            addCriterion("USER_EMAIL not like", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailIn(List<String> values) {
            addCriterion("USER_EMAIL in", values, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotIn(List<String> values) {
            addCriterion("USER_EMAIL not in", values, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailBetween(String value1, String value2) {
            addCriterion("USER_EMAIL between", value1, value2, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotBetween(String value1, String value2) {
            addCriterion("USER_EMAIL not between", value1, value2, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserAddressIsNull() {
            addCriterion("USER_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andUserAddressIsNotNull() {
            addCriterion("USER_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andUserAddressEqualTo(String value) {
            addCriterion("USER_ADDRESS =", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressNotEqualTo(String value) {
            addCriterion("USER_ADDRESS <>", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressGreaterThan(String value) {
            addCriterion("USER_ADDRESS >", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressGreaterThanOrEqualTo(String value) {
            addCriterion("USER_ADDRESS >=", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressLessThan(String value) {
            addCriterion("USER_ADDRESS <", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressLessThanOrEqualTo(String value) {
            addCriterion("USER_ADDRESS <=", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressLike(String value) {
            addCriterion("USER_ADDRESS like", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressNotLike(String value) {
            addCriterion("USER_ADDRESS not like", value, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressIn(List<String> values) {
            addCriterion("USER_ADDRESS in", values, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressNotIn(List<String> values) {
            addCriterion("USER_ADDRESS not in", values, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressBetween(String value1, String value2) {
            addCriterion("USER_ADDRESS between", value1, value2, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserAddressNotBetween(String value1, String value2) {
            addCriterion("USER_ADDRESS not between", value1, value2, "userAddress");
            return (Criteria) this;
        }

        public Criteria andUserMarkIsNull() {
            addCriterion("USER_MARK is null");
            return (Criteria) this;
        }

        public Criteria andUserMarkIsNotNull() {
            addCriterion("USER_MARK is not null");
            return (Criteria) this;
        }

        public Criteria andUserMarkEqualTo(Long value) {
            addCriterion("USER_MARK =", value, "userMark");
            return (Criteria) this;
        }

        public Criteria andUserMarkNotEqualTo(Long value) {
            addCriterion("USER_MARK <>", value, "userMark");
            return (Criteria) this;
        }

        public Criteria andUserMarkGreaterThan(Long value) {
            addCriterion("USER_MARK >", value, "userMark");
            return (Criteria) this;
        }

        public Criteria andUserMarkGreaterThanOrEqualTo(Long value) {
            addCriterion("USER_MARK >=", value, "userMark");
            return (Criteria) this;
        }

        public Criteria andUserMarkLessThan(Long value) {
            addCriterion("USER_MARK <", value, "userMark");
            return (Criteria) this;
        }

        public Criteria andUserMarkLessThanOrEqualTo(Long value) {
            addCriterion("USER_MARK <=", value, "userMark");
            return (Criteria) this;
        }

        public Criteria andUserMarkIn(List<Long> values) {
            addCriterion("USER_MARK in", values, "userMark");
            return (Criteria) this;
        }

        public Criteria andUserMarkNotIn(List<Long> values) {
            addCriterion("USER_MARK not in", values, "userMark");
            return (Criteria) this;
        }

        public Criteria andUserMarkBetween(Long value1, Long value2) {
            addCriterion("USER_MARK between", value1, value2, "userMark");
            return (Criteria) this;
        }

        public Criteria andUserMarkNotBetween(Long value1, Long value2) {
            addCriterion("USER_MARK not between", value1, value2, "userMark");
            return (Criteria) this;
        }

        public Criteria andUserRankIdIsNull() {
            addCriterion("USER_RANK_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserRankIdIsNotNull() {
            addCriterion("USER_RANK_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserRankIdEqualTo(Integer value) {
            addCriterion("USER_RANK_ID =", value, "userRankId");
            return (Criteria) this;
        }

        public Criteria andUserRankIdNotEqualTo(Integer value) {
            addCriterion("USER_RANK_ID <>", value, "userRankId");
            return (Criteria) this;
        }

        public Criteria andUserRankIdGreaterThan(Integer value) {
            addCriterion("USER_RANK_ID >", value, "userRankId");
            return (Criteria) this;
        }

        public Criteria andUserRankIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("USER_RANK_ID >=", value, "userRankId");
            return (Criteria) this;
        }

        public Criteria andUserRankIdLessThan(Integer value) {
            addCriterion("USER_RANK_ID <", value, "userRankId");
            return (Criteria) this;
        }

        public Criteria andUserRankIdLessThanOrEqualTo(Integer value) {
            addCriterion("USER_RANK_ID <=", value, "userRankId");
            return (Criteria) this;
        }

        public Criteria andUserRankIdIn(List<Integer> values) {
            addCriterion("USER_RANK_ID in", values, "userRankId");
            return (Criteria) this;
        }

        public Criteria andUserRankIdNotIn(List<Integer> values) {
            addCriterion("USER_RANK_ID not in", values, "userRankId");
            return (Criteria) this;
        }

        public Criteria andUserRankIdBetween(Integer value1, Integer value2) {
            addCriterion("USER_RANK_ID between", value1, value2, "userRankId");
            return (Criteria) this;
        }

        public Criteria andUserRankIdNotBetween(Integer value1, Integer value2) {
            addCriterion("USER_RANK_ID not between", value1, value2, "userRankId");
            return (Criteria) this;
        }

        public Criteria andUserLastLoginIpIsNull() {
            addCriterion("USER_LAST_LOGIN_IP is null");
            return (Criteria) this;
        }

        public Criteria andUserLastLoginIpIsNotNull() {
            addCriterion("USER_LAST_LOGIN_IP is not null");
            return (Criteria) this;
        }

        public Criteria andUserLastLoginIpEqualTo(String value) {
            addCriterion("USER_LAST_LOGIN_IP =", value, "userLastLoginIp");
            return (Criteria) this;
        }

        public Criteria andUserLastLoginIpNotEqualTo(String value) {
            addCriterion("USER_LAST_LOGIN_IP <>", value, "userLastLoginIp");
            return (Criteria) this;
        }

        public Criteria andUserLastLoginIpGreaterThan(String value) {
            addCriterion("USER_LAST_LOGIN_IP >", value, "userLastLoginIp");
            return (Criteria) this;
        }

        public Criteria andUserLastLoginIpGreaterThanOrEqualTo(String value) {
            addCriterion("USER_LAST_LOGIN_IP >=", value, "userLastLoginIp");
            return (Criteria) this;
        }

        public Criteria andUserLastLoginIpLessThan(String value) {
            addCriterion("USER_LAST_LOGIN_IP <", value, "userLastLoginIp");
            return (Criteria) this;
        }

        public Criteria andUserLastLoginIpLessThanOrEqualTo(String value) {
            addCriterion("USER_LAST_LOGIN_IP <=", value, "userLastLoginIp");
            return (Criteria) this;
        }

        public Criteria andUserLastLoginIpLike(String value) {
            addCriterion("USER_LAST_LOGIN_IP like", value, "userLastLoginIp");
            return (Criteria) this;
        }

        public Criteria andUserLastLoginIpNotLike(String value) {
            addCriterion("USER_LAST_LOGIN_IP not like", value, "userLastLoginIp");
            return (Criteria) this;
        }

        public Criteria andUserLastLoginIpIn(List<String> values) {
            addCriterion("USER_LAST_LOGIN_IP in", values, "userLastLoginIp");
            return (Criteria) this;
        }

        public Criteria andUserLastLoginIpNotIn(List<String> values) {
            addCriterion("USER_LAST_LOGIN_IP not in", values, "userLastLoginIp");
            return (Criteria) this;
        }

        public Criteria andUserLastLoginIpBetween(String value1, String value2) {
            addCriterion("USER_LAST_LOGIN_IP between", value1, value2, "userLastLoginIp");
            return (Criteria) this;
        }

        public Criteria andUserLastLoginIpNotBetween(String value1, String value2) {
            addCriterion("USER_LAST_LOGIN_IP not between", value1, value2, "userLastLoginIp");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayIsNull() {
            addCriterion("USER_BIRTHDAY is null");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayIsNotNull() {
            addCriterion("USER_BIRTHDAY is not null");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayEqualTo(Long value) {
            addCriterion("USER_BIRTHDAY =", value, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayNotEqualTo(Long value) {
            addCriterion("USER_BIRTHDAY <>", value, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayGreaterThan(Long value) {
            addCriterion("USER_BIRTHDAY >", value, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayGreaterThanOrEqualTo(Long value) {
            addCriterion("USER_BIRTHDAY >=", value, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayLessThan(Long value) {
            addCriterion("USER_BIRTHDAY <", value, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayLessThanOrEqualTo(Long value) {
            addCriterion("USER_BIRTHDAY <=", value, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayIn(List<Long> values) {
            addCriterion("USER_BIRTHDAY in", values, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayNotIn(List<Long> values) {
            addCriterion("USER_BIRTHDAY not in", values, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayBetween(Long value1, Long value2) {
            addCriterion("USER_BIRTHDAY between", value1, value2, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayNotBetween(Long value1, Long value2) {
            addCriterion("USER_BIRTHDAY not between", value1, value2, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserDescriptionIsNull() {
            addCriterion("USER_DESCRIPTION is null");
            return (Criteria) this;
        }

        public Criteria andUserDescriptionIsNotNull() {
            addCriterion("USER_DESCRIPTION is not null");
            return (Criteria) this;
        }

        public Criteria andUserDescriptionEqualTo(String value) {
            addCriterion("USER_DESCRIPTION =", value, "userDescription");
            return (Criteria) this;
        }

        public Criteria andUserDescriptionNotEqualTo(String value) {
            addCriterion("USER_DESCRIPTION <>", value, "userDescription");
            return (Criteria) this;
        }

        public Criteria andUserDescriptionGreaterThan(String value) {
            addCriterion("USER_DESCRIPTION >", value, "userDescription");
            return (Criteria) this;
        }

        public Criteria andUserDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("USER_DESCRIPTION >=", value, "userDescription");
            return (Criteria) this;
        }

        public Criteria andUserDescriptionLessThan(String value) {
            addCriterion("USER_DESCRIPTION <", value, "userDescription");
            return (Criteria) this;
        }

        public Criteria andUserDescriptionLessThanOrEqualTo(String value) {
            addCriterion("USER_DESCRIPTION <=", value, "userDescription");
            return (Criteria) this;
        }

        public Criteria andUserDescriptionLike(String value) {
            addCriterion("USER_DESCRIPTION like", value, "userDescription");
            return (Criteria) this;
        }

        public Criteria andUserDescriptionNotLike(String value) {
            addCriterion("USER_DESCRIPTION not like", value, "userDescription");
            return (Criteria) this;
        }

        public Criteria andUserDescriptionIn(List<String> values) {
            addCriterion("USER_DESCRIPTION in", values, "userDescription");
            return (Criteria) this;
        }

        public Criteria andUserDescriptionNotIn(List<String> values) {
            addCriterion("USER_DESCRIPTION not in", values, "userDescription");
            return (Criteria) this;
        }

        public Criteria andUserDescriptionBetween(String value1, String value2) {
            addCriterion("USER_DESCRIPTION between", value1, value2, "userDescription");
            return (Criteria) this;
        }

        public Criteria andUserDescriptionNotBetween(String value1, String value2) {
            addCriterion("USER_DESCRIPTION not between", value1, value2, "userDescription");
            return (Criteria) this;
        }

        public Criteria andUserImageUrlIsNull() {
            addCriterion("USER_IMAGE_URL is null");
            return (Criteria) this;
        }

        public Criteria andUserImageUrlIsNotNull() {
            addCriterion("USER_IMAGE_URL is not null");
            return (Criteria) this;
        }

        public Criteria andUserImageUrlEqualTo(String value) {
            addCriterion("USER_IMAGE_URL =", value, "userImageUrl");
            return (Criteria) this;
        }

        public Criteria andUserImageUrlNotEqualTo(String value) {
            addCriterion("USER_IMAGE_URL <>", value, "userImageUrl");
            return (Criteria) this;
        }

        public Criteria andUserImageUrlGreaterThan(String value) {
            addCriterion("USER_IMAGE_URL >", value, "userImageUrl");
            return (Criteria) this;
        }

        public Criteria andUserImageUrlGreaterThanOrEqualTo(String value) {
            addCriterion("USER_IMAGE_URL >=", value, "userImageUrl");
            return (Criteria) this;
        }

        public Criteria andUserImageUrlLessThan(String value) {
            addCriterion("USER_IMAGE_URL <", value, "userImageUrl");
            return (Criteria) this;
        }

        public Criteria andUserImageUrlLessThanOrEqualTo(String value) {
            addCriterion("USER_IMAGE_URL <=", value, "userImageUrl");
            return (Criteria) this;
        }

        public Criteria andUserImageUrlLike(String value) {
            addCriterion("USER_IMAGE_URL like", value, "userImageUrl");
            return (Criteria) this;
        }

        public Criteria andUserImageUrlNotLike(String value) {
            addCriterion("USER_IMAGE_URL not like", value, "userImageUrl");
            return (Criteria) this;
        }

        public Criteria andUserImageUrlIn(List<String> values) {
            addCriterion("USER_IMAGE_URL in", values, "userImageUrl");
            return (Criteria) this;
        }

        public Criteria andUserImageUrlNotIn(List<String> values) {
            addCriterion("USER_IMAGE_URL not in", values, "userImageUrl");
            return (Criteria) this;
        }

        public Criteria andUserImageUrlBetween(String value1, String value2) {
            addCriterion("USER_IMAGE_URL between", value1, value2, "userImageUrl");
            return (Criteria) this;
        }

        public Criteria andUserImageUrlNotBetween(String value1, String value2) {
            addCriterion("USER_IMAGE_URL not between", value1, value2, "userImageUrl");
            return (Criteria) this;
        }

        public Criteria andUserSchoolIsNull() {
            addCriterion("USER_SCHOOL is null");
            return (Criteria) this;
        }

        public Criteria andUserSchoolIsNotNull() {
            addCriterion("USER_SCHOOL is not null");
            return (Criteria) this;
        }

        public Criteria andUserSchoolEqualTo(String value) {
            addCriterion("USER_SCHOOL =", value, "userSchool");
            return (Criteria) this;
        }

        public Criteria andUserSchoolNotEqualTo(String value) {
            addCriterion("USER_SCHOOL <>", value, "userSchool");
            return (Criteria) this;
        }

        public Criteria andUserSchoolGreaterThan(String value) {
            addCriterion("USER_SCHOOL >", value, "userSchool");
            return (Criteria) this;
        }

        public Criteria andUserSchoolGreaterThanOrEqualTo(String value) {
            addCriterion("USER_SCHOOL >=", value, "userSchool");
            return (Criteria) this;
        }

        public Criteria andUserSchoolLessThan(String value) {
            addCriterion("USER_SCHOOL <", value, "userSchool");
            return (Criteria) this;
        }

        public Criteria andUserSchoolLessThanOrEqualTo(String value) {
            addCriterion("USER_SCHOOL <=", value, "userSchool");
            return (Criteria) this;
        }

        public Criteria andUserSchoolLike(String value) {
            addCriterion("USER_SCHOOL like", value, "userSchool");
            return (Criteria) this;
        }

        public Criteria andUserSchoolNotLike(String value) {
            addCriterion("USER_SCHOOL not like", value, "userSchool");
            return (Criteria) this;
        }

        public Criteria andUserSchoolIn(List<String> values) {
            addCriterion("USER_SCHOOL in", values, "userSchool");
            return (Criteria) this;
        }

        public Criteria andUserSchoolNotIn(List<String> values) {
            addCriterion("USER_SCHOOL not in", values, "userSchool");
            return (Criteria) this;
        }

        public Criteria andUserSchoolBetween(String value1, String value2) {
            addCriterion("USER_SCHOOL between", value1, value2, "userSchool");
            return (Criteria) this;
        }

        public Criteria andUserSchoolNotBetween(String value1, String value2) {
            addCriterion("USER_SCHOOL not between", value1, value2, "userSchool");
            return (Criteria) this;
        }

        public Criteria andUserRegisterTimeIsNull() {
            addCriterion("USER_REGISTER_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUserRegisterTimeIsNotNull() {
            addCriterion("USER_REGISTER_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUserRegisterTimeEqualTo(Long value) {
            addCriterion("USER_REGISTER_TIME =", value, "userRegisterTime");
            return (Criteria) this;
        }

        public Criteria andUserRegisterTimeNotEqualTo(Long value) {
            addCriterion("USER_REGISTER_TIME <>", value, "userRegisterTime");
            return (Criteria) this;
        }

        public Criteria andUserRegisterTimeGreaterThan(Long value) {
            addCriterion("USER_REGISTER_TIME >", value, "userRegisterTime");
            return (Criteria) this;
        }

        public Criteria andUserRegisterTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("USER_REGISTER_TIME >=", value, "userRegisterTime");
            return (Criteria) this;
        }

        public Criteria andUserRegisterTimeLessThan(Long value) {
            addCriterion("USER_REGISTER_TIME <", value, "userRegisterTime");
            return (Criteria) this;
        }

        public Criteria andUserRegisterTimeLessThanOrEqualTo(Long value) {
            addCriterion("USER_REGISTER_TIME <=", value, "userRegisterTime");
            return (Criteria) this;
        }

        public Criteria andUserRegisterTimeIn(List<Long> values) {
            addCriterion("USER_REGISTER_TIME in", values, "userRegisterTime");
            return (Criteria) this;
        }

        public Criteria andUserRegisterTimeNotIn(List<Long> values) {
            addCriterion("USER_REGISTER_TIME not in", values, "userRegisterTime");
            return (Criteria) this;
        }

        public Criteria andUserRegisterTimeBetween(Long value1, Long value2) {
            addCriterion("USER_REGISTER_TIME between", value1, value2, "userRegisterTime");
            return (Criteria) this;
        }

        public Criteria andUserRegisterTimeNotBetween(Long value1, Long value2) {
            addCriterion("USER_REGISTER_TIME not between", value1, value2, "userRegisterTime");
            return (Criteria) this;
        }

        public Criteria andUserRegisterIpIsNull() {
            addCriterion("USER_REGISTER_IP is null");
            return (Criteria) this;
        }

        public Criteria andUserRegisterIpIsNotNull() {
            addCriterion("USER_REGISTER_IP is not null");
            return (Criteria) this;
        }

        public Criteria andUserRegisterIpEqualTo(String value) {
            addCriterion("USER_REGISTER_IP =", value, "userRegisterIp");
            return (Criteria) this;
        }

        public Criteria andUserRegisterIpNotEqualTo(String value) {
            addCriterion("USER_REGISTER_IP <>", value, "userRegisterIp");
            return (Criteria) this;
        }

        public Criteria andUserRegisterIpGreaterThan(String value) {
            addCriterion("USER_REGISTER_IP >", value, "userRegisterIp");
            return (Criteria) this;
        }

        public Criteria andUserRegisterIpGreaterThanOrEqualTo(String value) {
            addCriterion("USER_REGISTER_IP >=", value, "userRegisterIp");
            return (Criteria) this;
        }

        public Criteria andUserRegisterIpLessThan(String value) {
            addCriterion("USER_REGISTER_IP <", value, "userRegisterIp");
            return (Criteria) this;
        }

        public Criteria andUserRegisterIpLessThanOrEqualTo(String value) {
            addCriterion("USER_REGISTER_IP <=", value, "userRegisterIp");
            return (Criteria) this;
        }

        public Criteria andUserRegisterIpLike(String value) {
            addCriterion("USER_REGISTER_IP like", value, "userRegisterIp");
            return (Criteria) this;
        }

        public Criteria andUserRegisterIpNotLike(String value) {
            addCriterion("USER_REGISTER_IP not like", value, "userRegisterIp");
            return (Criteria) this;
        }

        public Criteria andUserRegisterIpIn(List<String> values) {
            addCriterion("USER_REGISTER_IP in", values, "userRegisterIp");
            return (Criteria) this;
        }

        public Criteria andUserRegisterIpNotIn(List<String> values) {
            addCriterion("USER_REGISTER_IP not in", values, "userRegisterIp");
            return (Criteria) this;
        }

        public Criteria andUserRegisterIpBetween(String value1, String value2) {
            addCriterion("USER_REGISTER_IP between", value1, value2, "userRegisterIp");
            return (Criteria) this;
        }

        public Criteria andUserRegisterIpNotBetween(String value1, String value2) {
            addCriterion("USER_REGISTER_IP not between", value1, value2, "userRegisterIp");
            return (Criteria) this;
        }

        public Criteria andUserLastUpdateTimeIsNull() {
            addCriterion("USER_LAST_UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUserLastUpdateTimeIsNotNull() {
            addCriterion("USER_LAST_UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUserLastUpdateTimeEqualTo(Long value) {
            addCriterion("USER_LAST_UPDATE_TIME =", value, "userLastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andUserLastUpdateTimeNotEqualTo(Long value) {
            addCriterion("USER_LAST_UPDATE_TIME <>", value, "userLastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andUserLastUpdateTimeGreaterThan(Long value) {
            addCriterion("USER_LAST_UPDATE_TIME >", value, "userLastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andUserLastUpdateTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("USER_LAST_UPDATE_TIME >=", value, "userLastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andUserLastUpdateTimeLessThan(Long value) {
            addCriterion("USER_LAST_UPDATE_TIME <", value, "userLastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andUserLastUpdateTimeLessThanOrEqualTo(Long value) {
            addCriterion("USER_LAST_UPDATE_TIME <=", value, "userLastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andUserLastUpdateTimeIn(List<Long> values) {
            addCriterion("USER_LAST_UPDATE_TIME in", values, "userLastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andUserLastUpdateTimeNotIn(List<Long> values) {
            addCriterion("USER_LAST_UPDATE_TIME not in", values, "userLastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andUserLastUpdateTimeBetween(Long value1, Long value2) {
            addCriterion("USER_LAST_UPDATE_TIME between", value1, value2, "userLastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andUserLastUpdateTimeNotBetween(Long value1, Long value2) {
            addCriterion("USER_LAST_UPDATE_TIME not between", value1, value2, "userLastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andUserWeiboIsNull() {
            addCriterion("USER_WEIBO is null");
            return (Criteria) this;
        }

        public Criteria andUserWeiboIsNotNull() {
            addCriterion("USER_WEIBO is not null");
            return (Criteria) this;
        }

        public Criteria andUserWeiboEqualTo(String value) {
            addCriterion("USER_WEIBO =", value, "userWeibo");
            return (Criteria) this;
        }

        public Criteria andUserWeiboNotEqualTo(String value) {
            addCriterion("USER_WEIBO <>", value, "userWeibo");
            return (Criteria) this;
        }

        public Criteria andUserWeiboGreaterThan(String value) {
            addCriterion("USER_WEIBO >", value, "userWeibo");
            return (Criteria) this;
        }

        public Criteria andUserWeiboGreaterThanOrEqualTo(String value) {
            addCriterion("USER_WEIBO >=", value, "userWeibo");
            return (Criteria) this;
        }

        public Criteria andUserWeiboLessThan(String value) {
            addCriterion("USER_WEIBO <", value, "userWeibo");
            return (Criteria) this;
        }

        public Criteria andUserWeiboLessThanOrEqualTo(String value) {
            addCriterion("USER_WEIBO <=", value, "userWeibo");
            return (Criteria) this;
        }

        public Criteria andUserWeiboLike(String value) {
            addCriterion("USER_WEIBO like", value, "userWeibo");
            return (Criteria) this;
        }

        public Criteria andUserWeiboNotLike(String value) {
            addCriterion("USER_WEIBO not like", value, "userWeibo");
            return (Criteria) this;
        }

        public Criteria andUserWeiboIn(List<String> values) {
            addCriterion("USER_WEIBO in", values, "userWeibo");
            return (Criteria) this;
        }

        public Criteria andUserWeiboNotIn(List<String> values) {
            addCriterion("USER_WEIBO not in", values, "userWeibo");
            return (Criteria) this;
        }

        public Criteria andUserWeiboBetween(String value1, String value2) {
            addCriterion("USER_WEIBO between", value1, value2, "userWeibo");
            return (Criteria) this;
        }

        public Criteria andUserWeiboNotBetween(String value1, String value2) {
            addCriterion("USER_WEIBO not between", value1, value2, "userWeibo");
            return (Criteria) this;
        }

        public Criteria andUserBloodTypeIsNull() {
            addCriterion("USER_BLOOD_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andUserBloodTypeIsNotNull() {
            addCriterion("USER_BLOOD_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andUserBloodTypeEqualTo(String value) {
            addCriterion("USER_BLOOD_TYPE =", value, "userBloodType");
            return (Criteria) this;
        }

        public Criteria andUserBloodTypeNotEqualTo(String value) {
            addCriterion("USER_BLOOD_TYPE <>", value, "userBloodType");
            return (Criteria) this;
        }

        public Criteria andUserBloodTypeGreaterThan(String value) {
            addCriterion("USER_BLOOD_TYPE >", value, "userBloodType");
            return (Criteria) this;
        }

        public Criteria andUserBloodTypeGreaterThanOrEqualTo(String value) {
            addCriterion("USER_BLOOD_TYPE >=", value, "userBloodType");
            return (Criteria) this;
        }

        public Criteria andUserBloodTypeLessThan(String value) {
            addCriterion("USER_BLOOD_TYPE <", value, "userBloodType");
            return (Criteria) this;
        }

        public Criteria andUserBloodTypeLessThanOrEqualTo(String value) {
            addCriterion("USER_BLOOD_TYPE <=", value, "userBloodType");
            return (Criteria) this;
        }

        public Criteria andUserBloodTypeLike(String value) {
            addCriterion("USER_BLOOD_TYPE like", value, "userBloodType");
            return (Criteria) this;
        }

        public Criteria andUserBloodTypeNotLike(String value) {
            addCriterion("USER_BLOOD_TYPE not like", value, "userBloodType");
            return (Criteria) this;
        }

        public Criteria andUserBloodTypeIn(List<String> values) {
            addCriterion("USER_BLOOD_TYPE in", values, "userBloodType");
            return (Criteria) this;
        }

        public Criteria andUserBloodTypeNotIn(List<String> values) {
            addCriterion("USER_BLOOD_TYPE not in", values, "userBloodType");
            return (Criteria) this;
        }

        public Criteria andUserBloodTypeBetween(String value1, String value2) {
            addCriterion("USER_BLOOD_TYPE between", value1, value2, "userBloodType");
            return (Criteria) this;
        }

        public Criteria andUserBloodTypeNotBetween(String value1, String value2) {
            addCriterion("USER_BLOOD_TYPE not between", value1, value2, "userBloodType");
            return (Criteria) this;
        }

        public Criteria andUserSaysIsNull() {
            addCriterion("USER_SAYS is null");
            return (Criteria) this;
        }

        public Criteria andUserSaysIsNotNull() {
            addCriterion("USER_SAYS is not null");
            return (Criteria) this;
        }

        public Criteria andUserSaysEqualTo(String value) {
            addCriterion("USER_SAYS =", value, "userSays");
            return (Criteria) this;
        }

        public Criteria andUserSaysNotEqualTo(String value) {
            addCriterion("USER_SAYS <>", value, "userSays");
            return (Criteria) this;
        }

        public Criteria andUserSaysGreaterThan(String value) {
            addCriterion("USER_SAYS >", value, "userSays");
            return (Criteria) this;
        }

        public Criteria andUserSaysGreaterThanOrEqualTo(String value) {
            addCriterion("USER_SAYS >=", value, "userSays");
            return (Criteria) this;
        }

        public Criteria andUserSaysLessThan(String value) {
            addCriterion("USER_SAYS <", value, "userSays");
            return (Criteria) this;
        }

        public Criteria andUserSaysLessThanOrEqualTo(String value) {
            addCriterion("USER_SAYS <=", value, "userSays");
            return (Criteria) this;
        }

        public Criteria andUserSaysLike(String value) {
            addCriterion("USER_SAYS like", value, "userSays");
            return (Criteria) this;
        }

        public Criteria andUserSaysNotLike(String value) {
            addCriterion("USER_SAYS not like", value, "userSays");
            return (Criteria) this;
        }

        public Criteria andUserSaysIn(List<String> values) {
            addCriterion("USER_SAYS in", values, "userSays");
            return (Criteria) this;
        }

        public Criteria andUserSaysNotIn(List<String> values) {
            addCriterion("USER_SAYS not in", values, "userSays");
            return (Criteria) this;
        }

        public Criteria andUserSaysBetween(String value1, String value2) {
            addCriterion("USER_SAYS between", value1, value2, "userSays");
            return (Criteria) this;
        }

        public Criteria andUserSaysNotBetween(String value1, String value2) {
            addCriterion("USER_SAYS not between", value1, value2, "userSays");
            return (Criteria) this;
        }

        public Criteria andUserActivationIsNull() {
            addCriterion("USER_ACTIVATION is null");
            return (Criteria) this;
        }

        public Criteria andUserActivationIsNotNull() {
            addCriterion("USER_ACTIVATION is not null");
            return (Criteria) this;
        }

        public Criteria andUserActivationEqualTo(Integer value) {
            addCriterion("USER_ACTIVATION =", value, "userActivation");
            return (Criteria) this;
        }

        public Criteria andUserActivationNotEqualTo(Integer value) {
            addCriterion("USER_ACTIVATION <>", value, "userActivation");
            return (Criteria) this;
        }

        public Criteria andUserActivationGreaterThan(Integer value) {
            addCriterion("USER_ACTIVATION >", value, "userActivation");
            return (Criteria) this;
        }

        public Criteria andUserActivationGreaterThanOrEqualTo(Integer value) {
            addCriterion("USER_ACTIVATION >=", value, "userActivation");
            return (Criteria) this;
        }

        public Criteria andUserActivationLessThan(Integer value) {
            addCriterion("USER_ACTIVATION <", value, "userActivation");
            return (Criteria) this;
        }

        public Criteria andUserActivationLessThanOrEqualTo(Integer value) {
            addCriterion("USER_ACTIVATION <=", value, "userActivation");
            return (Criteria) this;
        }

        public Criteria andUserActivationIn(List<Integer> values) {
            addCriterion("USER_ACTIVATION in", values, "userActivation");
            return (Criteria) this;
        }

        public Criteria andUserActivationNotIn(List<Integer> values) {
            addCriterion("USER_ACTIVATION not in", values, "userActivation");
            return (Criteria) this;
        }

        public Criteria andUserActivationBetween(Integer value1, Integer value2) {
            addCriterion("USER_ACTIVATION between", value1, value2, "userActivation");
            return (Criteria) this;
        }

        public Criteria andUserActivationNotBetween(Integer value1, Integer value2) {
            addCriterion("USER_ACTIVATION not between", value1, value2, "userActivation");
            return (Criteria) this;
        }

        public Criteria andUserFreezeIsNull() {
            addCriterion("USER_FREEZE is null");
            return (Criteria) this;
        }

        public Criteria andUserFreezeIsNotNull() {
            addCriterion("USER_FREEZE is not null");
            return (Criteria) this;
        }

        public Criteria andUserFreezeEqualTo(Integer value) {
            addCriterion("USER_FREEZE =", value, "userFreeze");
            return (Criteria) this;
        }

        public Criteria andUserFreezeNotEqualTo(Integer value) {
            addCriterion("USER_FREEZE <>", value, "userFreeze");
            return (Criteria) this;
        }

        public Criteria andUserFreezeGreaterThan(Integer value) {
            addCriterion("USER_FREEZE >", value, "userFreeze");
            return (Criteria) this;
        }

        public Criteria andUserFreezeGreaterThanOrEqualTo(Integer value) {
            addCriterion("USER_FREEZE >=", value, "userFreeze");
            return (Criteria) this;
        }

        public Criteria andUserFreezeLessThan(Integer value) {
            addCriterion("USER_FREEZE <", value, "userFreeze");
            return (Criteria) this;
        }

        public Criteria andUserFreezeLessThanOrEqualTo(Integer value) {
            addCriterion("USER_FREEZE <=", value, "userFreeze");
            return (Criteria) this;
        }

        public Criteria andUserFreezeIn(List<Integer> values) {
            addCriterion("USER_FREEZE in", values, "userFreeze");
            return (Criteria) this;
        }

        public Criteria andUserFreezeNotIn(List<Integer> values) {
            addCriterion("USER_FREEZE not in", values, "userFreeze");
            return (Criteria) this;
        }

        public Criteria andUserFreezeBetween(Integer value1, Integer value2) {
            addCriterion("USER_FREEZE between", value1, value2, "userFreeze");
            return (Criteria) this;
        }

        public Criteria andUserFreezeNotBetween(Integer value1, Integer value2) {
            addCriterion("USER_FREEZE not between", value1, value2, "userFreeze");
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