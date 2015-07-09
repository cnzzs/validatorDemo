package net.zz.validator.constraintvalidators;

import net.zz.validator.constraints.QQ;
import net.zz.validator.plug.Regx;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by ZaoSheng on 2015/7/2.
 */
public class QQValidator implements ConstraintValidator<QQ, String> {
    @Override
    public void initialize(QQ constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (null == value || value.length() <= 0){
            return true;
        }
        return (value.matches(Regx.QQ) || value.matches(Regx.PHONE));
    }
}
