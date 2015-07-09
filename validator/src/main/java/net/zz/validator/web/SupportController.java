package net.zz.validator.web;

import net.zz.validator.exception.CommonException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public abstract class SupportController {


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

            for (FieldError error : errors) {
                String key = error.getField() + error.getCode();
                data.put("ZZCode", -1);
                data.put("message", error.getDefaultMessage());
                return data;
            }

        } else if (ex instanceof CommonException) {
            CommonException ce = (CommonException) ex;
            data.put("ZZCode", -1);
            data.put("message", ce.getMessage());
            return data;
        } else {
            throw ex;
        }
        return data;
    }

}
