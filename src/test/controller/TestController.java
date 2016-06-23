package test.controller;

import org.apache.log4j.Logger;

import com.jfinal.core.Controller;

public class TestController extends Controller {
	
	public void index() {
		Logger log = Logger.getLogger(getClass());
		log.info("index() 方法调用..");
		renderText("successful access");
	}

}
