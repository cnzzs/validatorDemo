package net.zz.validator.constraints;

import net.zz.validator.exception.CommonException;
import org.hibernate.validator.method.MethodConstraintViolation;
import org.hibernate.validator.method.MethodValidator;
import org.springframework.stereotype.Component;

import javax.validation.Validation;
import javax.validation.Validator;
import java.lang.reflect.Method;
import org.springframework.validation.BindException;
import java.util.Set;

@Component
public class Validate {

    public MethodValidator getMethodValidator() {
           /* MethodValidator methodValidator1 = Validation.byProvider(HibernateValidator.class)
                       .configure()
                       .buildValidatorFactory()
                       .getValidator()
                       .unwrap(MethodValidator.class);
               */
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        return validator.unwrap(MethodValidator.class);
    }

    public Set<MethodConstraintViolation<Object>> validateParameter(Object valiObjct, Method method, Object paramValue, int paramIndex) throws Exception {
        Set<MethodConstraintViolation<Object>> methodConstraintViolations = getMethodValidator().validateParameter(valiObjct, method, paramValue, paramIndex);
        return methodConstraintViolations;
    }

    public Set<MethodConstraintViolation<Object>> validateAllParameters(Object valiObjct, Method method, Object[] paramValues) throws Exception {
        Set<MethodConstraintViolation<Object>> methodConstraintViolations = getMethodValidator().validateAllParameters(valiObjct, method, paramValues);

        return methodConstraintViolations;
    }

    public void throwException(Set<MethodConstraintViolation<Object>> methodConstraintViolations)  {
    StringBuilder builder = new StringBuilder();
        for (MethodConstraintViolation<Object> violation : methodConstraintViolations) {
            builder.append(String.format( violation.getMessage()));
            break;
        }
        if (!methodConstraintViolations.isEmpty())
        {
            throw new CommonException(-1, builder.toString());
        }

    }

}
