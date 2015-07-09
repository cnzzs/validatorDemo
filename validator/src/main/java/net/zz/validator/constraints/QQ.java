package net.zz.validator.constraints;

import net.zz.validator.constraintvalidators.QQValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * The annotated element must be <code>qq</code>.
 * Accepts any type.
 *
 * @author  ZaoSheng
 * @email cnzhengzs@gmail.com
 *
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = QQValidator.class)
public @interface QQ {
    String message() default "QQ 格式是否正确";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default {};
    /**
     * Defines several <code>@QQ</code> annotations on the same element
     * @see QQ
     *
     * @author ZaoSheng
     */
    @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
    @Retention(RUNTIME)
    @Documented
    @interface List {
        QQ[] value();
    }
}

