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
public class SchoolFileInfo implements Serializable {
    /** 主键id,作为@BizId */
    @BizId
    private String id;

    /** 学校id */
    private String schoolId;

    /** 文件名称 */
    private String fileName;

    /** 创建时间 */
    private Date createdAt;

    /** 更新时间 */
    private Date updatedAt;

    /** id属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    @JsonIgnore
    private String idExpression;

    /** schoolId属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    @JsonIgnore
    private String schoolIdExpression;

    /** fileName属性对应的表达式属性，
     * 目前用来支持update set 字段=表达式(如:'字段+1')这种场景
     **/
    @JsonIgnore
    private String fileNameExpression;

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