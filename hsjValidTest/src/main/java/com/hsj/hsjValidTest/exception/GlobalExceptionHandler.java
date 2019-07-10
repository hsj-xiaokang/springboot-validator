package com.hsj.hsjValidTest.exception;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hsj.hsjValidTest.vo.JSONResultWrapper;
/**
 * 
* @ClassName: GlobalExceptionHandler  
* @Description: TODO(@RequestBody检验统一异常抛出)  
* @author heshengjin-何胜金  
* @date 2019年7月10日  
*
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
	private final static Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	/**
	 * 
	* @Title: validationErrorHandler  
	* @Description: TODO(校验异常-@RequestBody类型)  
	* @param @param ex
	* @param @return    参数  
	* @return LeeJSONResult    返回类型  
	* @throws
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public JSONResultWrapper validationErrorHandler(MethodArgumentNotValidException ex) {
		// 同样是获取BindingResult对象，然后获取其中的错误信息
		// 如果前面开启了fail_fast，事实上这里只会有一个信息
		LOGGER.info("校验异常=MethodArgumentNotValidException.class");
		// 如果没有，则可能又多个
		List<String> errorInformation = ex.getBindingResult().getAllErrors().stream()
				.map(ObjectError::getDefaultMessage).collect(Collectors.toList());
		return JSONResultWrapper.errorWithMessageAndObject(JSONResultWrapper.MESSAGE_ERROR, errorInformation,
				JSONResultWrapper.RESCODE_ERR);
	}

	/**
	 * 
	 * @Title: validationErrorHandler @Description:
	 * TODO(校验异常-@PathVariable和@RequestParam类型) @param @param ex @param @return
	 * 参数 @return LeeJSONResult 返回类型 @throws
	 */
	@ExceptionHandler(ConstraintViolationException.class)
	public JSONResultWrapper validationErrorHandlerOther(ConstraintViolationException ex) {
		List<String> errorInformation = ex.getConstraintViolations().stream().map(ConstraintViolation::getMessage)
				.collect(Collectors.toList());
		return JSONResultWrapper.errorWithMessageAndObject(JSONResultWrapper.MESSAGE_ERROR, errorInformation,
				JSONResultWrapper.RESCODE_ERR);
	}

	/**
	 * 
	 * @Title: validationErrorHandler @Description: TODO(其余异常) @param @param
	 * e @param @return 参数 @return LeeJSONResult 返回类型 @throws
	 */
	@ExceptionHandler
	public JSONResultWrapper validationErrorHandlerDefault(Exception e) {
		return JSONResultWrapper.errorWithMessageAndObject(JSONResultWrapper.MESSAGE_ERROR, e.getMessage(),
				JSONResultWrapper.RESCODE_ERR);
	}
}

