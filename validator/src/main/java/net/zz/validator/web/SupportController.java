package net.zz.validator.web;

import net.zz.validator.exception.CommonException;
import net.zz.validator.plug.MsgCode;
import org.hibernate.validator.method.MethodConstraintViolation;
import org.hibernate.validator.method.MethodConstraintViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.annotation.Annotation;
import java.util.*;

@Controller
public abstract class SupportController {

    private final static Map<String, MsgCode> errorFields = new WeakHashMap();

    protected Map<String, Object> successData() {
        Map<String, Object> data = newData();
        data.put("MZCode", 0);
        return data;
    }

    /**
     * @return
     */
    protected Map<String, Object> successData(String key, Object result) {
        Map<String, Object> data = newData();
        data.put("MZCode", 0);
        data.put(key, result);
        return data;
    }


    protected Map<String, Object> newData() {
        Map<String, Object> data = new HashMap<String, Object>();
        return data;
    }


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String, Object> handleException(Exception ex) throws Exception {

        Map<String, Object> data = newData();
        if (ex instanceof BindException) {
            BindException be = (BindException) ex;
            Class<?> targetClass = be.getTarget().getClass();
            List<FieldError> errors = be.getFieldErrors();

            data.put("ZZCode", -1);

            for (FieldError error : errors) {
                String key = error.getField() + error.getCode();
                MsgCode msgCode = null;
                if (null == errorFields.get(key)) {
                    msgCode = targetClass.getDeclaredField(error.getField()).getAnnotation(MsgCode.class);
                    errorFields.put(key, msgCode);
                } else {
                    msgCode = errorFields.get(key);
                }

                if (null != msgCode){
                    data.put("ZZCode", msgCode.value());
                }
                data.put("message", error.getDefaultMessage());
                return data;
            }

        } else if (ex instanceof MethodConstraintViolationException) {
            MethodConstraintViolationException mcve = (MethodConstraintViolationException) ex;
            Set<MethodConstraintViolation<?>> constraintViolations = mcve.getConstraintViolations();
            data.put("ZZCode", -1);
            for (MethodConstraintViolation<?> violation : constraintViolations){
                data.put("message", violation.getMessage());
                String key = violation.getPropertyPath().toString() + violation.getParameterIndex();
                if (null == errorFields.get(key)){
                    Annotation[] parameterAnnotations = violation.getMethod().getParameterAnnotations()[violation.getParameterIndex()];
                    for (Annotation parameterAnnotation : parameterAnnotations){
                        if (parameterAnnotation instanceof MsgCode){
                            MsgCode code = (MsgCode) parameterAnnotation;
                            errorFields.put(key, code);
                            break;
                        }
                    }
                }

                data.put("ZZCode", errorFields.get(key).value());
                return data;

            }

        } else if (ex instanceof CommonException) {
            CommonException ce = (CommonException) ex;
            data.put("ZZCode", ce.getCode());
            data.put("message", ce.getMessage());
            return data;
        } else {
            throw ex;
        }
        return data;
    }

}
