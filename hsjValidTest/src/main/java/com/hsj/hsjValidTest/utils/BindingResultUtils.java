package com.hsj.hsjValidTest.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public class BindingResultUtils {
	private final static Logger LOGGER = LoggerFactory.getLogger(BindingResultUtils.class);
    
	public static Map<String, String> getErrors(BindingResult result) {
        Map<String, String> map = new HashMap<String, String>();
        List<FieldError> list = result.getFieldErrors();
        for (FieldError error : list) {
        	LOGGER.info("error.getField(): {}",error.getField());
        	LOGGER.info("error.getDefaultMessage(): {}",error.getDefaultMessage());
            
            map.put(error.getField(), error.getDefaultMessage());
        }
        return map;
    }
}
