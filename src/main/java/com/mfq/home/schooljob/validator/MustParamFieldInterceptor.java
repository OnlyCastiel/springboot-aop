package com.mfq.home.schooljob.validator;

import com.mfq.home.schooljob.validator.annotation.MustParamField;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class MustParamFieldInterceptor {
    public MustParamFieldInterceptor() {
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod)handler;
            Method method = handlerMethod.getMethod();
            MustParamField anno = (MustParamField)method.getAnnotation(MustParamField.class);
            if (anno != null) {
                String[] arr = anno.value();
                if (arr != null && arr.length > 0) {
                    request.setAttribute("_MustFieldName_", arr);
                }
            }
        }

        return true;
    }
}
