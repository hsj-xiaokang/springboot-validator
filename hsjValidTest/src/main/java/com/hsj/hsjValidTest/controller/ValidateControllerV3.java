package com.hsj.hsjValidTest.controller;

import javax.validation.constraints.Max;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hsj.hsjValidTest.vo.JSONResultWrapper;
/**
 * 博客：https://www.cnblogs.com/leechenxiang/p/5546615.html
 * @Description:TODO
 * @author:hsj qq:2356899074
 * @time:2017年11月14日 上午10:50:13
 */
@RestController
@RequestMapping(value = "/valV3")
@Validated
public class ValidateControllerV3 {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(ValidateControllerV3.class);

	@RequestMapping(value = "/valV3_PathVariable/{name}", method = { RequestMethod.POST, RequestMethod.GET })
	public JSONResultWrapper valV3_PathVariable(
			@NotBlank(message = "username不能为空") @Length(max = 6, min = 3, message = "username最小3位，最大6位") @PathVariable String name) {
		LOGGER.info("valV3_PathVariable info {}", name);
		return JSONResultWrapper.okWithObject(name, JSONResultWrapper.RESCODE_OK);
	}

	@RequestMapping(value = "/valV3_RequestParam", method = { RequestMethod.POST, RequestMethod.GET })
	public JSONResultWrapper valV3_RequestParam(
			@NotBlank(message = "username不能为空") @Length(max = 6, min = 3, message = "username最小3位，最大6位") @RequestParam("name") String name) {
		LOGGER.info("valV3_RequestParam info {}", name);
		return JSONResultWrapper.okWithObject(name, JSONResultWrapper.RESCODE_OK);
	}

	@RequestMapping(value = "/valV3_RequestParam_age", method = { RequestMethod.POST, RequestMethod.GET })
	public JSONResultWrapper valV3_RequestParam_age(@Max(value = 20, message = "最大年龄20") @RequestParam("age") int age) {
		LOGGER.info("valV3_RequestParam_age info {}", age);
		return JSONResultWrapper.okWithObject(age, JSONResultWrapper.RESCODE_OK);
	}
}