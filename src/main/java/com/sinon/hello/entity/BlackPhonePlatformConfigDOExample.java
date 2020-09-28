package com.sinon.hello.entity;

import java.util.ArrayList;
import java.util.List;

public class BlackPhonePlatformConfigDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public BlackPhonePlatformConfigDOExample() {
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
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

        public Criteria andPlatformNameIsNull() {
            addCriterion("platform_name is null");
            return (Criteria) this;
        }

        public Criteria andPlatformNameIsNotNull() {
            addCriterion("platform_name is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformNameEqualTo(String value) {
            addCriterion("platform_name =", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameNotEqualTo(String value) {
            addCriterion("platform_name <>", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameGreaterThan(String value) {
            addCriterion("platform_name >", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameGreaterThanOrEqualTo(String value) {
            addCriterion("platform_name >=", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameLessThan(String value) {
            addCriterion("platform_name <", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameLessThanOrEqualTo(String value) {
            addCriterion("platform_name <=", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameLike(String value) {
            addCriterion("platform_name like", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameNotLike(String value) {
            addCriterion("platform_name not like", value, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameIn(List<String> values) {
            addCriterion("platform_name in", values, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameNotIn(List<String> values) {
            addCriterion("platform_name not in", values, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameBetween(String value1, String value2) {
            addCriterion("platform_name between", value1, value2, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformNameNotBetween(String value1, String value2) {
            addCriterion("platform_name not between", value1, value2, "platformName");
            return (Criteria) this;
        }

        public Criteria andPlatformIdentityIsNull() {
            addCriterion("platform_identity is null");
            return (Criteria) this;
        }

        public Criteria andPlatformIdentityIsNotNull() {
            addCriterion("platform_identity is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformIdentityEqualTo(String value) {
            addCriterion("platform_identity =", value, "platformIdentity");
            return (Criteria) this;
        }

        public Criteria andPlatformIdentityNotEqualTo(String value) {
            addCriterion("platform_identity <>", value, "platformIdentity");
            return (Criteria) this;
        }

        public Criteria andPlatformIdentityGreaterThan(String value) {
            addCriterion("platform_identity >", value, "platformIdentity");
            return (Criteria) this;
        }

        public Criteria andPlatformIdentityGreaterThanOrEqualTo(String value) {
            addCriterion("platform_identity >=", value, "platformIdentity");
            return (Criteria) this;
        }

        public Criteria andPlatformIdentityLessThan(String value) {
            addCriterion("platform_identity <", value, "platformIdentity");
            return (Criteria) this;
        }

        public Criteria andPlatformIdentityLessThanOrEqualTo(String value) {
            addCriterion("platform_identity <=", value, "platformIdentity");
            return (Criteria) this;
        }

        public Criteria andPlatformIdentityLike(String value) {
            addCriterion("platform_identity like", value, "platformIdentity");
            return (Criteria) this;
        }

        public Criteria andPlatformIdentityNotLike(String value) {
            addCriterion("platform_identity not like", value, "platformIdentity");
            return (Criteria) this;
        }

        public Criteria andPlatformIdentityIn(List<String> values) {
            addCriterion("platform_identity in", values, "platformIdentity");
            return (Criteria) this;
        }

        public Criteria andPlatformIdentityNotIn(List<String> values) {
            addCriterion("platform_identity not in", values, "platformIdentity");
            return (Criteria) this;
        }

        public Criteria andPlatformIdentityBetween(String value1, String value2) {
            addCriterion("platform_identity between", value1, value2, "platformIdentity");
            return (Criteria) this;
        }

        public Criteria andPlatformIdentityNotBetween(String value1, String value2) {
            addCriterion("platform_identity not between", value1, value2, "platformIdentity");
            return (Criteria) this;
        }

        public Criteria andMaxPushBatchSizeIsNull() {
            addCriterion("max_push_batch_size is null");
            return (Criteria) this;
        }

        public Criteria andMaxPushBatchSizeIsNotNull() {
            addCriterion("max_push_batch_size is not null");
            return (Criteria) this;
        }

        public Criteria andMaxPushBatchSizeEqualTo(Integer value) {
            addCriterion("max_push_batch_size =", value, "maxPushBatchSize");
            return (Criteria) this;
        }

        public Criteria andMaxPushBatchSizeNotEqualTo(Integer value) {
            addCriterion("max_push_batch_size <>", value, "maxPushBatchSize");
            return (Criteria) this;
        }

        public Criteria andMaxPushBatchSizeGreaterThan(Integer value) {
            addCriterion("max_push_batch_size >", value, "maxPushBatchSize");
            return (Criteria) this;
        }

        public Criteria andMaxPushBatchSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_push_batch_size >=", value, "maxPushBatchSize");
            return (Criteria) this;
        }

        public Criteria andMaxPushBatchSizeLessThan(Integer value) {
            addCriterion("max_push_batch_size <", value, "maxPushBatchSize");
            return (Criteria) this;
        }

        public Criteria andMaxPushBatchSizeLessThanOrEqualTo(Integer value) {
            addCriterion("max_push_batch_size <=", value, "maxPushBatchSize");
            return (Criteria) this;
        }

        public Criteria andMaxPushBatchSizeIn(List<Integer> values) {
            addCriterion("max_push_batch_size in", values, "maxPushBatchSize");
            return (Criteria) this;
        }

        public Criteria andMaxPushBatchSizeNotIn(List<Integer> values) {
            addCriterion("max_push_batch_size not in", values, "maxPushBatchSize");
            return (Criteria) this;
        }

        public Criteria andMaxPushBatchSizeBetween(Integer value1, Integer value2) {
            addCriterion("max_push_batch_size between", value1, value2, "maxPushBatchSize");
            return (Criteria) this;
        }

        public Criteria andMaxPushBatchSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("max_push_batch_size not between", value1, value2, "maxPushBatchSize");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andRequestHeaderIsNull() {
            addCriterion("request_header is null");
            return (Criteria) this;
        }

        public Criteria andRequestHeaderIsNotNull() {
            addCriterion("request_header is not null");
            return (Criteria) this;
        }

        public Criteria andRequestHeaderEqualTo(String value) {
            addCriterion("request_header =", value, "requestHeader");
            return (Criteria) this;
        }

        public Criteria andRequestHeaderNotEqualTo(String value) {
            addCriterion("request_header <>", value, "requestHeader");
            return (Criteria) this;
        }

        public Criteria andRequestHeaderGreaterThan(String value) {
            addCriterion("request_header >", value, "requestHeader");
            return (Criteria) this;
        }

        public Criteria andRequestHeaderGreaterThanOrEqualTo(String value) {
            addCriterion("request_header >=", value, "requestHeader");
            return (Criteria) this;
        }

        public Criteria andRequestHeaderLessThan(String value) {
            addCriterion("request_header <", value, "requestHeader");
            return (Criteria) this;
        }

        public Criteria andRequestHeaderLessThanOrEqualTo(String value) {
            addCriterion("request_header <=", value, "requestHeader");
            return (Criteria) this;
        }

        public Criteria andRequestHeaderLike(String value) {
            addCriterion("request_header like", value, "requestHeader");
            return (Criteria) this;
        }

        public Criteria andRequestHeaderNotLike(String value) {
            addCriterion("request_header not like", value, "requestHeader");
            return (Criteria) this;
        }

        public Criteria andRequestHeaderIn(List<String> values) {
            addCriterion("request_header in", values, "requestHeader");
            return (Criteria) this;
        }

        public Criteria andRequestHeaderNotIn(List<String> values) {
            addCriterion("request_header not in", values, "requestHeader");
            return (Criteria) this;
        }

        public Criteria andRequestHeaderBetween(String value1, String value2) {
            addCriterion("request_header between", value1, value2, "requestHeader");
            return (Criteria) this;
        }

        public Criteria andRequestHeaderNotBetween(String value1, String value2) {
            addCriterion("request_header not between", value1, value2, "requestHeader");
            return (Criteria) this;
        }

        public Criteria andRequestBodyTemplateIsNull() {
            addCriterion("request_body_template is null");
            return (Criteria) this;
        }

        public Criteria andRequestBodyTemplateIsNotNull() {
            addCriterion("request_body_template is not null");
            return (Criteria) this;
        }

        public Criteria andRequestBodyTemplateEqualTo(String value) {
            addCriterion("request_body_template =", value, "requestBodyTemplate");
            return (Criteria) this;
        }

        public Criteria andRequestBodyTemplateNotEqualTo(String value) {
            addCriterion("request_body_template <>", value, "requestBodyTemplate");
            return (Criteria) this;
        }

        public Criteria andRequestBodyTemplateGreaterThan(String value) {
            addCriterion("request_body_template >", value, "requestBodyTemplate");
            return (Criteria) this;
        }

        public Criteria andRequestBodyTemplateGreaterThanOrEqualTo(String value) {
            addCriterion("request_body_template >=", value, "requestBodyTemplate");
            return (Criteria) this;
        }

        public Criteria andRequestBodyTemplateLessThan(String value) {
            addCriterion("request_body_template <", value, "requestBodyTemplate");
            return (Criteria) this;
        }

        public Criteria andRequestBodyTemplateLessThanOrEqualTo(String value) {
            addCriterion("request_body_template <=", value, "requestBodyTemplate");
            return (Criteria) this;
        }

        public Criteria andRequestBodyTemplateLike(String value) {
            addCriterion("request_body_template like", value, "requestBodyTemplate");
            return (Criteria) this;
        }

        public Criteria andRequestBodyTemplateNotLike(String value) {
            addCriterion("request_body_template not like", value, "requestBodyTemplate");
            return (Criteria) this;
        }

        public Criteria andRequestBodyTemplateIn(List<String> values) {
            addCriterion("request_body_template in", values, "requestBodyTemplate");
            return (Criteria) this;
        }

        public Criteria andRequestBodyTemplateNotIn(List<String> values) {
            addCriterion("request_body_template not in", values, "requestBodyTemplate");
            return (Criteria) this;
        }

        public Criteria andRequestBodyTemplateBetween(String value1, String value2) {
            addCriterion("request_body_template between", value1, value2, "requestBodyTemplate");
            return (Criteria) this;
        }

        public Criteria andRequestBodyTemplateNotBetween(String value1, String value2) {
            addCriterion("request_body_template not between", value1, value2, "requestBodyTemplate");
            return (Criteria) this;
        }

        public Criteria andRequestValMapIsNull() {
            addCriterion("request_val_map is null");
            return (Criteria) this;
        }

        public Criteria andRequestValMapIsNotNull() {
            addCriterion("request_val_map is not null");
            return (Criteria) this;
        }

        public Criteria andRequestValMapEqualTo(String value) {
            addCriterion("request_val_map =", value, "requestValMap");
            return (Criteria) this;
        }

        public Criteria andRequestValMapNotEqualTo(String value) {
            addCriterion("request_val_map <>", value, "requestValMap");
            return (Criteria) this;
        }

        public Criteria andRequestValMapGreaterThan(String value) {
            addCriterion("request_val_map >", value, "requestValMap");
            return (Criteria) this;
        }

        public Criteria andRequestValMapGreaterThanOrEqualTo(String value) {
            addCriterion("request_val_map >=", value, "requestValMap");
            return (Criteria) this;
        }

        public Criteria andRequestValMapLessThan(String value) {
            addCriterion("request_val_map <", value, "requestValMap");
            return (Criteria) this;
        }

        public Criteria andRequestValMapLessThanOrEqualTo(String value) {
            addCriterion("request_val_map <=", value, "requestValMap");
            return (Criteria) this;
        }

        public Criteria andRequestValMapLike(String value) {
            addCriterion("request_val_map like", value, "requestValMap");
            return (Criteria) this;
        }

        public Criteria andRequestValMapNotLike(String value) {
            addCriterion("request_val_map not like", value, "requestValMap");
            return (Criteria) this;
        }

        public Criteria andRequestValMapIn(List<String> values) {
            addCriterion("request_val_map in", values, "requestValMap");
            return (Criteria) this;
        }

        public Criteria andRequestValMapNotIn(List<String> values) {
            addCriterion("request_val_map not in", values, "requestValMap");
            return (Criteria) this;
        }

        public Criteria andRequestValMapBetween(String value1, String value2) {
            addCriterion("request_val_map between", value1, value2, "requestValMap");
            return (Criteria) this;
        }

        public Criteria andRequestValMapNotBetween(String value1, String value2) {
            addCriterion("request_val_map not between", value1, value2, "requestValMap");
            return (Criteria) this;
        }

        public Criteria andResponseFormateTypeIsNull() {
            addCriterion("response_formate_type is null");
            return (Criteria) this;
        }

        public Criteria andResponseFormateTypeIsNotNull() {
            addCriterion("response_formate_type is not null");
            return (Criteria) this;
        }

        public Criteria andResponseFormateTypeEqualTo(Byte value) {
            addCriterion("response_formate_type =", value, "responseFormateType");
            return (Criteria) this;
        }

        public Criteria andResponseFormateTypeNotEqualTo(Byte value) {
            addCriterion("response_formate_type <>", value, "responseFormateType");
            return (Criteria) this;
        }

        public Criteria andResponseFormateTypeGreaterThan(Byte value) {
            addCriterion("response_formate_type >", value, "responseFormateType");
            return (Criteria) this;
        }

        public Criteria andResponseFormateTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("response_formate_type >=", value, "responseFormateType");
            return (Criteria) this;
        }

        public Criteria andResponseFormateTypeLessThan(Byte value) {
            addCriterion("response_formate_type <", value, "responseFormateType");
            return (Criteria) this;
        }

        public Criteria andResponseFormateTypeLessThanOrEqualTo(Byte value) {
            addCriterion("response_formate_type <=", value, "responseFormateType");
            return (Criteria) this;
        }

        public Criteria andResponseFormateTypeIn(List<Byte> values) {
            addCriterion("response_formate_type in", values, "responseFormateType");
            return (Criteria) this;
        }

        public Criteria andResponseFormateTypeNotIn(List<Byte> values) {
            addCriterion("response_formate_type not in", values, "responseFormateType");
            return (Criteria) this;
        }

        public Criteria andResponseFormateTypeBetween(Byte value1, Byte value2) {
            addCriterion("response_formate_type between", value1, value2, "responseFormateType");
            return (Criteria) this;
        }

        public Criteria andResponseFormateTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("response_formate_type not between", value1, value2, "responseFormateType");
            return (Criteria) this;
        }

        public Criteria andResponsePhoneNodeIsNull() {
            addCriterion("response_phone_node is null");
            return (Criteria) this;
        }

        public Criteria andResponsePhoneNodeIsNotNull() {
            addCriterion("response_phone_node is not null");
            return (Criteria) this;
        }

        public Criteria andResponsePhoneNodeEqualTo(String value) {
            addCriterion("response_phone_node =", value, "responsePhoneNode");
            return (Criteria) this;
        }

        public Criteria andResponsePhoneNodeNotEqualTo(String value) {
            addCriterion("response_phone_node <>", value, "responsePhoneNode");
            return (Criteria) this;
        }

        public Criteria andResponsePhoneNodeGreaterThan(String value) {
            addCriterion("response_phone_node >", value, "responsePhoneNode");
            return (Criteria) this;
        }

        public Criteria andResponsePhoneNodeGreaterThanOrEqualTo(String value) {
            addCriterion("response_phone_node >=", value, "responsePhoneNode");
            return (Criteria) this;
        }

        public Criteria andResponsePhoneNodeLessThan(String value) {
            addCriterion("response_phone_node <", value, "responsePhoneNode");
            return (Criteria) this;
        }

        public Criteria andResponsePhoneNodeLessThanOrEqualTo(String value) {
            addCriterion("response_phone_node <=", value, "responsePhoneNode");
            return (Criteria) this;
        }

        public Criteria andResponsePhoneNodeLike(String value) {
            addCriterion("response_phone_node like", value, "responsePhoneNode");
            return (Criteria) this;
        }

        public Criteria andResponsePhoneNodeNotLike(String value) {
            addCriterion("response_phone_node not like", value, "responsePhoneNode");
            return (Criteria) this;
        }

        public Criteria andResponsePhoneNodeIn(List<String> values) {
            addCriterion("response_phone_node in", values, "responsePhoneNode");
            return (Criteria) this;
        }

        public Criteria andResponsePhoneNodeNotIn(List<String> values) {
            addCriterion("response_phone_node not in", values, "responsePhoneNode");
            return (Criteria) this;
        }

        public Criteria andResponsePhoneNodeBetween(String value1, String value2) {
            addCriterion("response_phone_node between", value1, value2, "responsePhoneNode");
            return (Criteria) this;
        }

        public Criteria andResponsePhoneNodeNotBetween(String value1, String value2) {
            addCriterion("response_phone_node not between", value1, value2, "responsePhoneNode");
            return (Criteria) this;
        }

        public Criteria andResponseResultNodeIsNull() {
            addCriterion("response_result_node is null");
            return (Criteria) this;
        }

        public Criteria andResponseResultNodeIsNotNull() {
            addCriterion("response_result_node is not null");
            return (Criteria) this;
        }

        public Criteria andResponseResultNodeEqualTo(String value) {
            addCriterion("response_result_node =", value, "responseResultNode");
            return (Criteria) this;
        }

        public Criteria andResponseResultNodeNotEqualTo(String value) {
            addCriterion("response_result_node <>", value, "responseResultNode");
            return (Criteria) this;
        }

        public Criteria andResponseResultNodeGreaterThan(String value) {
            addCriterion("response_result_node >", value, "responseResultNode");
            return (Criteria) this;
        }

        public Criteria andResponseResultNodeGreaterThanOrEqualTo(String value) {
            addCriterion("response_result_node >=", value, "responseResultNode");
            return (Criteria) this;
        }

        public Criteria andResponseResultNodeLessThan(String value) {
            addCriterion("response_result_node <", value, "responseResultNode");
            return (Criteria) this;
        }

        public Criteria andResponseResultNodeLessThanOrEqualTo(String value) {
            addCriterion("response_result_node <=", value, "responseResultNode");
            return (Criteria) this;
        }

        public Criteria andResponseResultNodeLike(String value) {
            addCriterion("response_result_node like", value, "responseResultNode");
            return (Criteria) this;
        }

        public Criteria andResponseResultNodeNotLike(String value) {
            addCriterion("response_result_node not like", value, "responseResultNode");
            return (Criteria) this;
        }

        public Criteria andResponseResultNodeIn(List<String> values) {
            addCriterion("response_result_node in", values, "responseResultNode");
            return (Criteria) this;
        }

        public Criteria andResponseResultNodeNotIn(List<String> values) {
            addCriterion("response_result_node not in", values, "responseResultNode");
            return (Criteria) this;
        }

        public Criteria andResponseResultNodeBetween(String value1, String value2) {
            addCriterion("response_result_node between", value1, value2, "responseResultNode");
            return (Criteria) this;
        }

        public Criteria andResponseResultNodeNotBetween(String value1, String value2) {
            addCriterion("response_result_node not between", value1, value2, "responseResultNode");
            return (Criteria) this;
        }

        public Criteria andForbidSymbolSetIsNull() {
            addCriterion("forbid_symbol_set is null");
            return (Criteria) this;
        }

        public Criteria andForbidSymbolSetIsNotNull() {
            addCriterion("forbid_symbol_set is not null");
            return (Criteria) this;
        }

        public Criteria andForbidSymbolSetEqualTo(String value) {
            addCriterion("forbid_symbol_set =", value, "forbidSymbolSet");
            return (Criteria) this;
        }

        public Criteria andForbidSymbolSetNotEqualTo(String value) {
            addCriterion("forbid_symbol_set <>", value, "forbidSymbolSet");
            return (Criteria) this;
        }

        public Criteria andForbidSymbolSetGreaterThan(String value) {
            addCriterion("forbid_symbol_set >", value, "forbidSymbolSet");
            return (Criteria) this;
        }

        public Criteria andForbidSymbolSetGreaterThanOrEqualTo(String value) {
            addCriterion("forbid_symbol_set >=", value, "forbidSymbolSet");
            return (Criteria) this;
        }

        public Criteria andForbidSymbolSetLessThan(String value) {
            addCriterion("forbid_symbol_set <", value, "forbidSymbolSet");
            return (Criteria) this;
        }

        public Criteria andForbidSymbolSetLessThanOrEqualTo(String value) {
            addCriterion("forbid_symbol_set <=", value, "forbidSymbolSet");
            return (Criteria) this;
        }

        public Criteria andForbidSymbolSetLike(String value) {
            addCriterion("forbid_symbol_set like", value, "forbidSymbolSet");
            return (Criteria) this;
        }

        public Criteria andForbidSymbolSetNotLike(String value) {
            addCriterion("forbid_symbol_set not like", value, "forbidSymbolSet");
            return (Criteria) this;
        }

        public Criteria andForbidSymbolSetIn(List<String> values) {
            addCriterion("forbid_symbol_set in", values, "forbidSymbolSet");
            return (Criteria) this;
        }

        public Criteria andForbidSymbolSetNotIn(List<String> values) {
            addCriterion("forbid_symbol_set not in", values, "forbidSymbolSet");
            return (Criteria) this;
        }

        public Criteria andForbidSymbolSetBetween(String value1, String value2) {
            addCriterion("forbid_symbol_set between", value1, value2, "forbidSymbolSet");
            return (Criteria) this;
        }

        public Criteria andForbidSymbolSetNotBetween(String value1, String value2) {
            addCriterion("forbid_symbol_set not between", value1, value2, "forbidSymbolSet");
            return (Criteria) this;
        }

        public Criteria andPassSymbolSetIsNull() {
            addCriterion("pass_symbol_set is null");
            return (Criteria) this;
        }

        public Criteria andPassSymbolSetIsNotNull() {
            addCriterion("pass_symbol_set is not null");
            return (Criteria) this;
        }

        public Criteria andPassSymbolSetEqualTo(String value) {
            addCriterion("pass_symbol_set =", value, "passSymbolSet");
            return (Criteria) this;
        }

        public Criteria andPassSymbolSetNotEqualTo(String value) {
            addCriterion("pass_symbol_set <>", value, "passSymbolSet");
            return (Criteria) this;
        }

        public Criteria andPassSymbolSetGreaterThan(String value) {
            addCriterion("pass_symbol_set >", value, "passSymbolSet");
            return (Criteria) this;
        }

        public Criteria andPassSymbolSetGreaterThanOrEqualTo(String value) {
            addCriterion("pass_symbol_set >=", value, "passSymbolSet");
            return (Criteria) this;
        }

        public Criteria andPassSymbolSetLessThan(String value) {
            addCriterion("pass_symbol_set <", value, "passSymbolSet");
            return (Criteria) this;
        }

        public Criteria andPassSymbolSetLessThanOrEqualTo(String value) {
            addCriterion("pass_symbol_set <=", value, "passSymbolSet");
            return (Criteria) this;
        }

        public Criteria andPassSymbolSetLike(String value) {
            addCriterion("pass_symbol_set like", value, "passSymbolSet");
            return (Criteria) this;
        }

        public Criteria andPassSymbolSetNotLike(String value) {
            addCriterion("pass_symbol_set not like", value, "passSymbolSet");
            return (Criteria) this;
        }

        public Criteria andPassSymbolSetIn(List<String> values) {
            addCriterion("pass_symbol_set in", values, "passSymbolSet");
            return (Criteria) this;
        }

        public Criteria andPassSymbolSetNotIn(List<String> values) {
            addCriterion("pass_symbol_set not in", values, "passSymbolSet");
            return (Criteria) this;
        }

        public Criteria andPassSymbolSetBetween(String value1, String value2) {
            addCriterion("pass_symbol_set between", value1, value2, "passSymbolSet");
            return (Criteria) this;
        }

        public Criteria andPassSymbolSetNotBetween(String value1, String value2) {
            addCriterion("pass_symbol_set not between", value1, value2, "passSymbolSet");
            return (Criteria) this;
        }

        public Criteria andEnableMinPackSizeIsNull() {
            addCriterion("enable_min_pack_size is null");
            return (Criteria) this;
        }

        public Criteria andEnableMinPackSizeIsNotNull() {
            addCriterion("enable_min_pack_size is not null");
            return (Criteria) this;
        }

        public Criteria andEnableMinPackSizeEqualTo(Integer value) {
            addCriterion("enable_min_pack_size =", value, "enableMinPackSize");
            return (Criteria) this;
        }

        public Criteria andEnableMinPackSizeNotEqualTo(Integer value) {
            addCriterion("enable_min_pack_size <>", value, "enableMinPackSize");
            return (Criteria) this;
        }

        public Criteria andEnableMinPackSizeGreaterThan(Integer value) {
            addCriterion("enable_min_pack_size >", value, "enableMinPackSize");
            return (Criteria) this;
        }

        public Criteria andEnableMinPackSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("enable_min_pack_size >=", value, "enableMinPackSize");
            return (Criteria) this;
        }

        public Criteria andEnableMinPackSizeLessThan(Integer value) {
            addCriterion("enable_min_pack_size <", value, "enableMinPackSize");
            return (Criteria) this;
        }

        public Criteria andEnableMinPackSizeLessThanOrEqualTo(Integer value) {
            addCriterion("enable_min_pack_size <=", value, "enableMinPackSize");
            return (Criteria) this;
        }

        public Criteria andEnableMinPackSizeIn(List<Integer> values) {
            addCriterion("enable_min_pack_size in", values, "enableMinPackSize");
            return (Criteria) this;
        }

        public Criteria andEnableMinPackSizeNotIn(List<Integer> values) {
            addCriterion("enable_min_pack_size not in", values, "enableMinPackSize");
            return (Criteria) this;
        }

        public Criteria andEnableMinPackSizeBetween(Integer value1, Integer value2) {
            addCriterion("enable_min_pack_size between", value1, value2, "enableMinPackSize");
            return (Criteria) this;
        }

        public Criteria andEnableMinPackSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("enable_min_pack_size not between", value1, value2, "enableMinPackSize");
            return (Criteria) this;
        }

        public Criteria andEnableIsNull() {
            addCriterion("`enable` is null");
            return (Criteria) this;
        }

        public Criteria andEnableIsNotNull() {
            addCriterion("`enable` is not null");
            return (Criteria) this;
        }

        public Criteria andEnableEqualTo(Boolean value) {
            addCriterion("`enable` =", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotEqualTo(Boolean value) {
            addCriterion("`enable` <>", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableGreaterThan(Boolean value) {
            addCriterion("`enable` >", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableGreaterThanOrEqualTo(Boolean value) {
            addCriterion("`enable` >=", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableLessThan(Boolean value) {
            addCriterion("`enable` <", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableLessThanOrEqualTo(Boolean value) {
            addCriterion("`enable` <=", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableIn(List<Boolean> values) {
            addCriterion("`enable` in", values, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotIn(List<Boolean> values) {
            addCriterion("`enable` not in", values, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableBetween(Boolean value1, Boolean value2) {
            addCriterion("`enable` between", value1, value2, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotBetween(Boolean value1, Boolean value2) {
            addCriterion("`enable` not between", value1, value2, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableInsertBlacklistIsNull() {
            addCriterion("enable_insert_blacklist is null");
            return (Criteria) this;
        }

        public Criteria andEnableInsertBlacklistIsNotNull() {
            addCriterion("enable_insert_blacklist is not null");
            return (Criteria) this;
        }

        public Criteria andEnableInsertBlacklistEqualTo(Boolean value) {
            addCriterion("enable_insert_blacklist =", value, "enableInsertBlacklist");
            return (Criteria) this;
        }

        public Criteria andEnableInsertBlacklistNotEqualTo(Boolean value) {
            addCriterion("enable_insert_blacklist <>", value, "enableInsertBlacklist");
            return (Criteria) this;
        }

        public Criteria andEnableInsertBlacklistGreaterThan(Boolean value) {
            addCriterion("enable_insert_blacklist >", value, "enableInsertBlacklist");
            return (Criteria) this;
        }

        public Criteria andEnableInsertBlacklistGreaterThanOrEqualTo(Boolean value) {
            addCriterion("enable_insert_blacklist >=", value, "enableInsertBlacklist");
            return (Criteria) this;
        }

        public Criteria andEnableInsertBlacklistLessThan(Boolean value) {
            addCriterion("enable_insert_blacklist <", value, "enableInsertBlacklist");
            return (Criteria) this;
        }

        public Criteria andEnableInsertBlacklistLessThanOrEqualTo(Boolean value) {
            addCriterion("enable_insert_blacklist <=", value, "enableInsertBlacklist");
            return (Criteria) this;
        }

        public Criteria andEnableInsertBlacklistIn(List<Boolean> values) {
            addCriterion("enable_insert_blacklist in", values, "enableInsertBlacklist");
            return (Criteria) this;
        }

        public Criteria andEnableInsertBlacklistNotIn(List<Boolean> values) {
            addCriterion("enable_insert_blacklist not in", values, "enableInsertBlacklist");
            return (Criteria) this;
        }

        public Criteria andEnableInsertBlacklistBetween(Boolean value1, Boolean value2) {
            addCriterion("enable_insert_blacklist between", value1, value2, "enableInsertBlacklist");
            return (Criteria) this;
        }

        public Criteria andEnableInsertBlacklistNotBetween(Boolean value1, Boolean value2) {
            addCriterion("enable_insert_blacklist not between", value1, value2, "enableInsertBlacklist");
            return (Criteria) this;
        }
    }

    /**
     */
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