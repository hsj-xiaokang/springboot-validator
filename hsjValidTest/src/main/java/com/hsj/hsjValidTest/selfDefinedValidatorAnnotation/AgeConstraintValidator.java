package com.hsj.hsjValidTest.selfDefinedValidatorAnnotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.Max;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * see:https://blog.csdn.net/dh554112075/article/details/80790464
* @ClassName: SexConstraintValidator  
* @Description: TODO(age约束逻辑判断)  
* @author heshengjin-何胜金  
* @date 2019年7月10日  
*
 */
public class AgeConstraintValidator implements ConstraintValidator<Age, Integer> {
	private final static Logger LOGGER = LoggerFactory.getLogger(AgeConstraintValidator.class);
	
	//Age默认参数值最大最小范围，如果用户没有指定最大最小时候使用默认参数
	public final static int MAXDEFAULT = 150;
	public final static  int MINDEFAULT = 0;
	public final static  String TIP_MESSAGE = "Age参数值最大最小范围不正确!";
	
	private int realMax = MAXDEFAULT;
	private int realMin = MINDEFAULT;
	
    @Override
    public boolean isValid(Integer realValue, ConstraintValidatorContext context) {
    	LOGGER.info("---**********SexConstraintValidator-isValid的realValue参数值{}**********---",realValue);
        return realValue == null ? false : (
        		                       (realValue >= realMin && realValue<= realMax) ? true : false
        		                     );
    }

	@Override
	public void initialize(Age constraintAnnotation) {
		//initialize
		realMax = constraintAnnotation.max();
		realMin = constraintAnnotation.min();
	}
}
