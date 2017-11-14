package com.hsj.hsjValidTest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hsj.hsjValidTest.vo.LeeJSONResult;
/**
 * 测试
 * @Description:TODO
 * @author:hsj qq:2356899074
 * @time:2017年11月14日 下午1:35:14
 */
@RestController
@RequestMapping(value = "/restTest")
public class restTest {
	    @RequestMapping(value = "/test", method=RequestMethod.GET)
	    public LeeJSONResult test() throws Exception {            
	        return LeeJSONResult.ok();
	    }
}
