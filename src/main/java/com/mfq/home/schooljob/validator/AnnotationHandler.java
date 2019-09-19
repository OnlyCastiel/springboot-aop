package com.mfq.home.schooljob.validator;

import com.mfq.home.schooljob.validator.annotation.Length;
import com.mfq.home.schooljob.validator.annotation.Validator;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnnotationHandler {
    public AnnotationHandler() {
    }

    public static List<ErrorInfo> annoHandler(Object obj, String[] mustFieldName) throws IllegalArgumentException, IllegalAccessException {
        List<ErrorInfo> errors = new ArrayList();
        Class cla = obj.getClass();
        Field[] fields = cla.getDeclaredFields();
        Class superClass = cla.getSuperclass();
        if (superClass != null) {
            fields = (Field[])((Field[])ArrayUtils.addAll(fields, superClass.getDeclaredFields()));
        }

        List<String> temp = null;
        if (mustFieldName != null && mustFieldName.length > 0) {
            temp = Arrays.asList(mustFieldName);
        }

        Field[] var7 = fields;
        int var8 = fields.length;

        for(int var9 = 0; var9 < var8; ++var9) {
            Field field = var7[var9];
            field.setAccessible(true);
            Annotation[] annos = field.getAnnotations();
            Annotation[] var12 = annos;
            int var13 = annos.length;

            for(int var14 = 0; var14 < var13; ++var14) {
                Annotation anno = var12[var14];
                if (anno.annotationType().getName().equals("com.fdc.platform.common.validator.annotation.Validator")) {
                    errors.addAll(handleValidator(obj, field, anno, temp));
                } else if (anno.annotationType().getName().equals("com.fdc.platform.common.validator.annotation.Length")) {
                    errors.addAll(handleLength(obj, field, anno, temp));
                }
            }
        }

        return errors;
    }

    private static List<ErrorInfo> handleValidator(Object source, Field field, Annotation anno, List<String> mustFieldName) throws IllegalArgumentException, IllegalAccessException {
        List<ErrorInfo> errors = new ArrayList();
        String fieldName = field.getName();
        Object fieldValue = field.get(source);
        Validator valid = (Validator)anno;
        boolean isRequired = valid.required();
        if (mustFieldName == null) {
            if (isRequired) {
                errors.addAll(handleMustParams(fieldValue, fieldName, valid));
            } else {
                errors.addAll(handleNoMustParams(fieldValue, valid));
            }
        } else if (mustFieldName.contains(fieldName)) {
            errors.addAll(handleMustParams(fieldValue, fieldName, valid));
        } else {
            errors.addAll(handleNoMustParams(fieldValue, valid));
        }

        return errors;
    }

    private static List<ErrorInfo> handleLength(Object source, Field field, Annotation anno, List<String> mustFieldName) throws IllegalArgumentException, IllegalAccessException {
        List<ErrorInfo> errors = new ArrayList();
        Object fieldValue = field.get(source);
        String fieldName = field.getName();
        Length len = (Length)anno;
        int maxLength = len.max();
        int minLength = len.min();
        if (fieldValue != null) {
            String value = String.valueOf(fieldValue);
            if (value.length() > maxLength || value.length() < minLength) {
                ErrorInfo errorInfo = new ErrorInfo();
                errorInfo.setMessage("参数" + fieldName + "长度控制在" + minLength + "与" + maxLength + "之间");
                errors.add(errorInfo);
            }
        }

        return errors;
    }

    private static List<ErrorInfo> handleMustParams(Object fieldValue, String fieldName, Validator valid) {
        List<ErrorInfo> errors = new ArrayList();
        String message = valid.message();
        String regExp = valid.regExp();
        String[] selects = valid.selects();
        if (fieldValue == null) {
            ErrorInfo errorInfo = new ErrorInfo();
            errorInfo.setMessage(fieldName + "必填");
            errors.add(errorInfo);
        } else {
            String value = String.valueOf(fieldValue);
            if (selects != null && selects.length > 0) {
                List<String> paramList = Arrays.asList(selects);
                if (!paramList.contains(value)) {
                    ErrorInfo errorInfo = new ErrorInfo();
                    errorInfo.setMessage(fieldName + "不在设定选定值内");
                    errors.add(errorInfo);
                }
            } else if (StringUtils.isNotBlank(regExp) && !value.matches(regExp)) {
                ErrorInfo errorInfo = new ErrorInfo();
                errorInfo.setMessage(message);
                errors.add(errorInfo);
            }
        }

        return errors;
    }

    private static List<ErrorInfo> handleNoMustParams(Object fieldValue, Validator valid) {
        List<ErrorInfo> errors = new ArrayList();
        String message = valid.message();
        String regExp = valid.regExp();
        String[] selects = valid.selects();
        if (fieldValue != null) {
            String value = String.valueOf(fieldValue);
            if (selects != null && selects.length > 0) {
                List<String> paramList = Arrays.asList(selects);
                if (!paramList.contains(value)) {
                    ErrorInfo errorInfo = new ErrorInfo();
                    errorInfo.setMessage(message);
                    errors.add(errorInfo);
                }
            } else if (StringUtils.isNotBlank(regExp) && !value.matches(regExp)) {
                ErrorInfo errorInfo = new ErrorInfo();
                errorInfo.setMessage(message);
                errors.add(errorInfo);
            }
        }

        return errors;
    }
}
