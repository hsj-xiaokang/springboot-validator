package com.hsj.hsjValidTest.selfDefinedValidatorAnnotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hsj.hsjValidTest.vo.JSONResultWrapper;
/**
 * see:https://blog.csdn.net/dh554112075/article/details/80790464
* @ClassName: SexConstraintValidator  
* @Description: TODO(age约束自定义校验使用测试)  
* @author heshengjin-何胜金  
* @date 2019年7月10日  
*
 */
@RestController
@RequestMapping(value = "/valV4")
@Validated
public class ValidateControllerV4 {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(ValidateControllerV4.class);

	@RequestMapping(value = "/valV4_pathvariable/{age}", method = { RequestMethod.POST, RequestMethod.GET })
	public JSONResultWrapper valV4_pathvariable(@Age(max = AgeConstraintValidator.MAXDEFAULT,min = AgeConstraintValidator.MINDEFAULT,message = AgeConstraintValidator.TIP_MESSAGE) @PathVariable int age) {
		LOGGER.info("valV3_PathVariable info {}", age);
		return JSONResultWrapper.okWithObject(age, JSONResultWrapper.RESCODE_OK);
	}


	@RequestMapping(value = "/valV4_Param", method = { RequestMethod.POST, RequestMethod.GET })
	public JSONResultWrapper valV4_Param(@Age(max = AgeConstraintValidator.MAXDEFAULT,min = AgeConstraintValidator.MINDEFAULT,message = AgeConstraintValidator.TIP_MESSAGE) @PathVariable int age) {
		LOGGER.info("valV3_RequestParam_age info {}", age);
		return JSONResultWrapper.okWithObject(age, JSONResultWrapper.RESCODE_OK);
	}
}