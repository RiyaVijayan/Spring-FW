package com.log.record.controller;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;

@RestController
public class LogController {

	Logger logger = (Logger) LoggerFactory.getLogger(LogController.class);
	
	@RequestMapping("/")
	public String index()
	{
		logger.trace("A Trace msg");
		logger.debug("A debug msg");
		logger.info("A info msg");
		logger.warn("A warn msg");
		logger.error("A error msg");
		
		return "Logging file";
	}
}
