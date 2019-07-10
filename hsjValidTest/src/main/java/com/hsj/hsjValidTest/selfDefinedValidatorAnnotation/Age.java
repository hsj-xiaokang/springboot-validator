package com.hsj.hsjValidTest.selfDefinedValidatorAnnotation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;

import java.lang.annotation.*;

import javax.validation.Constraint;
import javax.validation.Payload;



/**
 * see:https://blog.csdn.net/dh554112075/article/details/80790464
* @ClassName: Sex  
* @Description: TODO(自定义检验参数)  
* @author heshengjin-何胜金  
* @date 2019年7月10日  
*
 */
/**
 * 性别约束
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AgeConstraintValidator.class)
public @interface Age {

	//Age参数值最大最小范围
	int max() default AgeConstraintValidator.MAXDEFAULT;
	int min() default AgeConstraintValidator.MINDEFAULT;
	
    String message() default AgeConstraintValidator.TIP_MESSAGE;

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
