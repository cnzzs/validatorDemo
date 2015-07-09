package net.zz.validator.constraints;

import net.zz.validator.constraintvalidators.ChineseValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * The annotated element must be <code>chinese</code>.
 * Accepts any type.
 *
 * @author  ZaoSheng
 * @email cnzhengzs@gmail.com
 *
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = ChineseValidator.class)
public @interface Chinese {
    String message() default "这不是一个合法的汉字";
    int start() default 1;
    int end() default 1;
    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default {};
    /**
     * Defines several <code>@Chinese</code> annotations on the same element
     * @see Chinese
     *
     * @author ZaoSheng
     */
    @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
    @Retention(RUNTIME)
    @Documented
    @interface List {
        Chinese[] value();
    }
}

