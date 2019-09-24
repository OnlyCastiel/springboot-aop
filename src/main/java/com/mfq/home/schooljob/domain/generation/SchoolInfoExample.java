package com.mfq.home.schooljob.domain.generation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SchoolInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    /** 在查询中增加for update 
     * 目前用来支持对查询记录加锁
     **/
    protected boolean forUpdate;

    /** 是否自定义设置查询字段 */
    protected boolean definedQueryColumns;

    /** 设置查询字段 */
    protected List<String> queryColumns;

    public SchoolInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
        queryColumns = new ArrayList<String>();
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
        forUpdate = false;
        definedQueryColumns = false;
        queryColumns.clear();
    }

    public void setForUpdate(boolean forUpdate) {
        this.forUpdate = forUpdate;
    }

    public boolean isForUpdate() {
        return forUpdate;
    }

    public void setDefinedQueryColumns(boolean definedQueryColumns) {
        this.definedQueryColumns = definedQueryColumns;
    }

    public boolean isDefinedQueryColumns() {
        return definedQueryColumns;
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSchoolNameIsNull() {
            addCriterion("school_name is null");
            return (Criteria) this;
        }

        public Criteria andSchoolNameIsNotNull() {
            addCriterion("school_name is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolNameEqualTo(String value) {
            addCriterion("school_name =", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameNotEqualTo(String value) {
            addCriterion("school_name <>", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameGreaterThan(String value) {
            addCriterion("school_name >", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameGreaterThanOrEqualTo(String value) {
            addCriterion("school_name >=", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameLessThan(String value) {
            addCriterion("school_name <", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameLessThanOrEqualTo(String value) {
            addCriterion("school_name <=", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameLike(String value) {
            addCriterion("school_name like", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameNotLike(String value) {
            addCriterion("school_name not like", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameIn(List<String> values) {
            addCriterion("school_name in", values, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameNotIn(List<String> values) {
            addCriterion("school_name not in", values, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameBetween(String value1, String value2) {
            addCriterion("school_name between", value1, value2, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameNotBetween(String value1, String value2) {
            addCriterion("school_name not between", value1, value2, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNamecChIsNull() {
            addCriterion("school_namec_ch is null");
            return (Criteria) this;
        }

        public Criteria andSchoolNamecChIsNotNull() {
            addCriterion("school_namec_ch is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolNamecChEqualTo(String value) {
            addCriterion("school_namec_ch =", value, "schoolNamecCh");
            return (Criteria) this;
        }

        public Criteria andSchoolNamecChNotEqualTo(String value) {
            addCriterion("school_namec_ch <>", value, "schoolNamecCh");
            return (Criteria) this;
        }

        public Criteria andSchoolNamecChGreaterThan(String value) {
            addCriterion("school_namec_ch >", value, "schoolNamecCh");
            return (Criteria) this;
        }

        public Criteria andSchoolNamecChGreaterThanOrEqualTo(String value) {
            addCriterion("school_namec_ch >=", value, "schoolNamecCh");
            return (Criteria) this;
        }

        public Criteria andSchoolNamecChLessThan(String value) {
            addCriterion("school_namec_ch <", value, "schoolNamecCh");
            return (Criteria) this;
        }

        public Criteria andSchoolNamecChLessThanOrEqualTo(String value) {
            addCriterion("school_namec_ch <=", value, "schoolNamecCh");
            return (Criteria) this;
        }

        public Criteria andSchoolNamecChLike(String value) {
            addCriterion("school_namec_ch like", value, "schoolNamecCh");
            return (Criteria) this;
        }

        public Criteria andSchoolNamecChNotLike(String value) {
            addCriterion("school_namec_ch not like", value, "schoolNamecCh");
            return (Criteria) this;
        }

        public Criteria andSchoolNamecChIn(List<String> values) {
            addCriterion("school_namec_ch in", values, "schoolNamecCh");
            return (Criteria) this;
        }

        public Criteria andSchoolNamecChNotIn(List<String> values) {
            addCriterion("school_namec_ch not in", values, "schoolNamecCh");
            return (Criteria) this;
        }

        public Criteria andSchoolNamecChBetween(String value1, String value2) {
            addCriterion("school_namec_ch between", value1, value2, "schoolNamecCh");
            return (Criteria) this;
        }

        public Criteria andSchoolNamecChNotBetween(String value1, String value2) {
            addCriterion("school_namec_ch not between", value1, value2, "schoolNamecCh");
            return (Criteria) this;
        }

        public Criteria andHomepageUrlIsNull() {
            addCriterion("homepage_url is null");
            return (Criteria) this;
        }

        public Criteria andHomepageUrlIsNotNull() {
            addCriterion("homepage_url is not null");
            return (Criteria) this;
        }

        public Criteria andHomepageUrlEqualTo(String value) {
            addCriterion("homepage_url =", value, "homepageUrl");
            return (Criteria) this;
        }

        public Criteria andHomepageUrlNotEqualTo(String value) {
            addCriterion("homepage_url <>", value, "homepageUrl");
            return (Criteria) this;
        }

        public Criteria andHomepageUrlGreaterThan(String value) {
            addCriterion("homepage_url >", value, "homepageUrl");
            return (Criteria) this;
        }

        public Criteria andHomepageUrlGreaterThanOrEqualTo(String value) {
            addCriterion("homepage_url >=", value, "homepageUrl");
            return (Criteria) this;
        }

        public Criteria andHomepageUrlLessThan(String value) {
            addCriterion("homepage_url <", value, "homepageUrl");
            return (Criteria) this;
        }

        public Criteria andHomepageUrlLessThanOrEqualTo(String value) {
            addCriterion("homepage_url <=", value, "homepageUrl");
            return (Criteria) this;
        }

        public Criteria andHomepageUrlLike(String value) {
            addCriterion("homepage_url like", value, "homepageUrl");
            return (Criteria) this;
        }

        public Criteria andHomepageUrlNotLike(String value) {
            addCriterion("homepage_url not like", value, "homepageUrl");
            return (Criteria) this;
        }

        public Criteria andHomepageUrlIn(List<String> values) {
            addCriterion("homepage_url in", values, "homepageUrl");
            return (Criteria) this;
        }

        public Criteria andHomepageUrlNotIn(List<String> values) {
            addCriterion("homepage_url not in", values, "homepageUrl");
            return (Criteria) this;
        }

        public Criteria andHomepageUrlBetween(String value1, String value2) {
            addCriterion("homepage_url between", value1, value2, "homepageUrl");
            return (Criteria) this;
        }

        public Criteria andHomepageUrlNotBetween(String value1, String value2) {
            addCriterion("homepage_url not between", value1, value2, "homepageUrl");
            return (Criteria) this;
        }

        public Criteria andRecruitStudentsUrlIsNull() {
            addCriterion("recruit_students_url is null");
            return (Criteria) this;
        }

        public Criteria andRecruitStudentsUrlIsNotNull() {
            addCriterion("recruit_students_url is not null");
            return (Criteria) this;
        }

        public Criteria andRecruitStudentsUrlEqualTo(String value) {
            addCriterion("recruit_students_url =", value, "recruitStudentsUrl");
            return (Criteria) this;
        }

        public Criteria andRecruitStudentsUrlNotEqualTo(String value) {
            addCriterion("recruit_students_url <>", value, "recruitStudentsUrl");
            return (Criteria) this;
        }

        public Criteria andRecruitStudentsUrlGreaterThan(String value) {
            addCriterion("recruit_students_url >", value, "recruitStudentsUrl");
            return (Criteria) this;
        }

        public Criteria andRecruitStudentsUrlGreaterThanOrEqualTo(String value) {
            addCriterion("recruit_students_url >=", value, "recruitStudentsUrl");
            return (Criteria) this;
        }

        public Criteria andRecruitStudentsUrlLessThan(String value) {
            addCriterion("recruit_students_url <", value, "recruitStudentsUrl");
            return (Criteria) this;
        }

        public Criteria andRecruitStudentsUrlLessThanOrEqualTo(String value) {
            addCriterion("recruit_students_url <=", value, "recruitStudentsUrl");
            return (Criteria) this;
        }

        public Criteria andRecruitStudentsUrlLike(String value) {
            addCriterion("recruit_students_url like", value, "recruitStudentsUrl");
            return (Criteria) this;
        }

        public Criteria andRecruitStudentsUrlNotLike(String value) {
            addCriterion("recruit_students_url not like", value, "recruitStudentsUrl");
            return (Criteria) this;
        }

        public Criteria andRecruitStudentsUrlIn(List<String> values) {
            addCriterion("recruit_students_url in", values, "recruitStudentsUrl");
            return (Criteria) this;
        }

        public Criteria andRecruitStudentsUrlNotIn(List<String> values) {
            addCriterion("recruit_students_url not in", values, "recruitStudentsUrl");
            return (Criteria) this;
        }

        public Criteria andRecruitStudentsUrlBetween(String value1, String value2) {
            addCriterion("recruit_students_url between", value1, value2, "recruitStudentsUrl");
            return (Criteria) this;
        }

        public Criteria andRecruitStudentsUrlNotBetween(String value1, String value2) {
            addCriterion("recruit_students_url not between", value1, value2, "recruitStudentsUrl");
            return (Criteria) this;
        }

        public Criteria andMethodNameIsNull() {
            addCriterion("method_name is null");
            return (Criteria) this;
        }

        public Criteria andMethodNameIsNotNull() {
            addCriterion("method_name is not null");
            return (Criteria) this;
        }

        public Criteria andMethodNameEqualTo(String value) {
            addCriterion("method_name =", value, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameNotEqualTo(String value) {
            addCriterion("method_name <>", value, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameGreaterThan(String value) {
            addCriterion("method_name >", value, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameGreaterThanOrEqualTo(String value) {
            addCriterion("method_name >=", value, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameLessThan(String value) {
            addCriterion("method_name <", value, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameLessThanOrEqualTo(String value) {
            addCriterion("method_name <=", value, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameLike(String value) {
            addCriterion("method_name like", value, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameNotLike(String value) {
            addCriterion("method_name not like", value, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameIn(List<String> values) {
            addCriterion("method_name in", values, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameNotIn(List<String> values) {
            addCriterion("method_name not in", values, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameBetween(String value1, String value2) {
            addCriterion("method_name between", value1, value2, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameNotBetween(String value1, String value2) {
            addCriterion("method_name not between", value1, value2, "methodName");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNull() {
            addCriterion("created_at is null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNotNull() {
            addCriterion("created_at is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtEqualTo(Date value) {
            addCriterion("created_at =", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotEqualTo(Date value) {
            addCriterion("created_at <>", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThan(Date value) {
            addCriterion("created_at >", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("created_at >=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThan(Date value) {
            addCriterion("created_at <", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThanOrEqualTo(Date value) {
            addCriterion("created_at <=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIn(List<Date> values) {
            addCriterion("created_at in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotIn(List<Date> values) {
            addCriterion("created_at not in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtBetween(Date value1, Date value2) {
            addCriterion("created_at between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotBetween(Date value1, Date value2) {
            addCriterion("created_at not between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNull() {
            addCriterion("updated_at is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNotNull() {
            addCriterion("updated_at is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtEqualTo(Date value) {
            addCriterion("updated_at =", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotEqualTo(Date value) {
            addCriterion("updated_at <>", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThan(Date value) {
            addCriterion("updated_at >", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("updated_at >=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThan(Date value) {
            addCriterion("updated_at <", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThanOrEqualTo(Date value) {
            addCriterion("updated_at <=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIn(List<Date> values) {
            addCriterion("updated_at in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotIn(List<Date> values) {
            addCriterion("updated_at not in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtBetween(Date value1, Date value2) {
            addCriterion("updated_at between", value1, value2, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotBetween(Date value1, Date value2) {
            addCriterion("updated_at not between", value1, value2, "updatedAt");
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