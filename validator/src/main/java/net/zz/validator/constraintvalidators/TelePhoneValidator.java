package net.zz.validator.constraintvalidators;

import net.zz.validator.constraints.TelePhone;
import net.zz.validator.plug.Regx;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by ZaoSheng on 2015/7/2.
 */
public class TelePhoneValidator implements ConstraintValidator<TelePhone, String> {
    @Override
    public void initialize(TelePhone constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (null == value || value.length() <= 0){
            return true;
        }
        return value.matches(Regx.TELEPHONE);
    }
}
