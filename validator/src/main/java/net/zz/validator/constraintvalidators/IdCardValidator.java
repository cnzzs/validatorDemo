package net.zz.validator.constraintvalidators;

import net.zz.validator.constraints.IdCard;
import net.zz.validator.plug.IdCardUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;

/**
 * Created by ZaoSheng on 2015/7/2.
 */
public class IdCardValidator implements ConstraintValidator<IdCard, String> {
    @Override
    public void initialize(IdCard constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (null == value || value.length() <= 0){
            return true;
        }

        try {
            return "true".equals(IdCardUtil.IDCardValidate(value)) ? true :false;
        } catch (ParseException e) {
            e.printStackTrace();

        }
        return true;
    }
}
