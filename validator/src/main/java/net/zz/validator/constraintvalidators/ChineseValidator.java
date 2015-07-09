package net.zz.validator.constraintvalidators;

import net.zz.validator.constraints.Chinese;
import net.zz.validator.plug.Regx;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by ZaoSheng on 2015/7/2.
 */
public class ChineseValidator implements ConstraintValidator<Chinese, String> {
    private int start;
    private int end;
    @Override
    public void initialize(Chinese constraintAnnotation) {
        start = constraintAnnotation.start();
        end = constraintAnnotation.end();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (null == value || value.length() <= 0){
            return true;
        }
        return value.matches(String.format(Regx.CHINESE, start, end));
    }
}
