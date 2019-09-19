package com.mfq.home.schooljob.domain.generation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mfq.home.schooljob.validator.annotation.BizId;
import com.mfq.home.schooljob.validator.annotation.Domain;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.ToString;

@Domain
@Data
@ToString
public class SchoolInfo implements Serializable {
    /** 主键id,作为@BizId */
    @BizId
    private String id;

    /** 学校名称原名 */
    private String schoolName;

    /** 学校中文名称 */
    private String schoolNamecCh;

    /** 学校首页地址 */
    private String homepageUrl;

    /** 学校首页地址 */
    private String recruitStudentsUrl;

    /** 创建时间 */
    private Date createdAt;

    /** 更新时间 */
    private Date updatedAt;

    /** id属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    @JsonIgnore
    private String idExpression;

    /** schoolName属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    @JsonIgnore
    private String schoolNameExpression;

    /** schoolNamecCh属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    @JsonIgnore
    private String schoolNamecChExpression;

    /** homepageUrl属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    @JsonIgnore
    private String homepageUrlExpression;

    /** recruitStudentsUrl属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    @JsonIgnore
    private String recruitStudentsUrlExpression;

    /** createdAt属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    @JsonIgnore
    private String createdAtExpression;

    /** updatedAt属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    @JsonIgnore
    private String updatedAtExpression;

    private static final long serialVersionUID = 1L;
}