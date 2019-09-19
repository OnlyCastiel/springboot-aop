package com.mfq.home.schooljob.validator;

import com.mfq.home.schooljob.validator.annotation.Domain;
import org.apache.catalina.connector.RequestFacade;
import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CheckParamInterceptor {
    private static Logger log = LoggerFactory.getLogger(CheckParamInterceptor.class);
    private RequestFacade request;
    private String[] mustFieldName;
    private List<Object> params = new ArrayList();

    public CheckParamInterceptor() {
    }

    public void before(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        List errors = null;

        try {
            Object[] var4 = args;
            int var5 = args.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                Object obj = var4[var6];
                if (obj != null) {
                    Class<?> cla = obj.getClass();
                    String argClassName = cla.getName();
                    if (argClassName.startsWith("com.fdc") && !argClassName.endsWith("CommonParameters")) {
                        if (!cla.isAnnotationPresent(Domain.class)) {
                            log.error(joinPoint.toString() + "；参数" + cla.getName() + "没有添加注解@Domain,请添加注解");
                            throw new RuntimeException(joinPoint.toString() + "；参数" + cla.getName() + "没有添加注解@Domain,请添加注解");
                        }

                        this.params.add(obj);
                    } else if (argClassName.equals("org.apache.catalina.connector.RequestFacade")) {
                        this.request = (RequestFacade)obj;
                        this.mustFieldName = (String[])((String[])this.request.getAttribute("_MustFieldName_"));
                    }
                }
            }

            if (this.params.size() > 0) {
                Object obj;
                for(Iterator var12 = this.params.iterator(); var12.hasNext(); errors = AnnotationHandler.annoHandler(obj, this.mustFieldName)) {
                    obj = var12.next();
                }

                if (this.request == null) {
                    throw new RuntimeException("接口参数要包括HttpServletRequest参数");
                }

                this.request.setAttribute("_errors_", errors);
            }
        } catch (IllegalArgumentException var10) {
            var10.printStackTrace();
        } catch (IllegalAccessException var11) {
            var11.printStackTrace();
        }

    }
}
