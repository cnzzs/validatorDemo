package net.zz.validator;

import net.zz.validator.constraints.Validate;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.hibernate.validator.method.MethodConstraintViolation;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;

import javax.annotation.Resource;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
//import java.lang.reflect.Parameter;

@Component
@Aspect
public class ZZValidate {
    @Resource
    private Validate validate;

    @Before(value = "execution(@javax.validation.Valid public * *(..))")
    public void validate(JoinPoint joinPoint) throws Exception {

        Signature sign = joinPoint.getSignature();
        Object[] objects = joinPoint.getArgs();
        Object target = joinPoint.getTarget();

        MethodSignature msign = (MethodSignature) sign;
        Method method = msign.getMethod();
        System.out.println("method: " + method.getName());
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        int arg = -1;
        //jdk8.0
//        Parameter[] parameters = method.getParameters();
//        for (Parameter parameter : parameters) {
//            Annotation[] annotations = parameter.getAnnotations();
        for (Annotation[] annotations : parameterAnnotations)
            if (annotations.length <= 0) {
                continue;
            }
        arg++;
//            int arg = new Integer(parameter.getName().replace("arg", ""));
        Object paramValue = null;
        try {
            paramValue = objects[arg];
        } catch (Exception e) {
//                System.out.println("aaaa");
        }
        validate.throwException(validate.validateParameter(target, method, paramValue, arg));

    }
/*@AfterThrowing
    public void throwing()
    {

    }*/
}