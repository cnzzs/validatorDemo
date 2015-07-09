package net.zz.validator.constraints;

import net.zz.validator.constraintvalidators.IdCardValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * The annotated element must be <code>idcard</code>.
 * Accepts any type.
 *
 * @author  ZaoSheng
 * @email cnzhengzs@gmail.com
 *
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = IdCardValidator.class)
public @interface IdCard {
    String message() default "这不是一个合法的身份证";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default {};
    /**
     * Defines several <code>@IdCard</code> annotations on the same element
     * @see IdCard
     *
     * @author ZaoSheng
     */
    @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
    @Retention(RUNTIME)
    @Documented
    @interface List {
        IdCard[] value();
    }
}

