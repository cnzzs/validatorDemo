package net.zz.validator.constraints;

import net.zz.validator.constraintvalidators.TelePhoneValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * The annotated element must be <code>telephone</code>.
 * Accepts any type.
 *
 * @author  ZaoSheng
 * @email cnzhengzs@gmail.com
 *
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = TelePhoneValidator.class)
public @interface TelePhone {
    String message() default "这不是一个合法的身份证";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default {};
    /**
     * Defines several <code>@TelePhone</code> annotations on the same element
     * @see TelePhone
     *
     * @author ZaoSheng
     */
    @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
    @Retention(RUNTIME)
    @Documented
    @interface List {
        TelePhone[] value();
    }
}

