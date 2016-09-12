package net.zz.validator;

import net.zz.validator.constraints.Validate;

import javax.annotation.Resource;
//import java.lang.reflect.Parameter;

//@Component
//@Aspect
@Deprecated
public class ZZValidate {
    @Resource
    private Validate validate;
/*
    @Before(value = "execution(@javax.validation.Valid public * *(..))")
    public void validate(JoinPoint joinPoint) throws Exception {

        Signature sign = joinPoint.getSignature();
        Object[] objects = joinPoint.getArgs();
        Object target = joinPoint.getTarget();
        MethodSignature msign = (MethodSignature) sign;
        Method method = msign.getMethod();
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

        }
        validate.throwException(validate.validateParameter(target, method, paramValue, arg));

    }*/
/*@AfterThrowing
    public void throwing()
    {

    }*/
}