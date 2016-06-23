package micro.config;

import com.jfinal.config.Routes;

import test.controller.TestController;

/**
 * 路由映射
 */
public class MappingRoute extends Routes {

	@Override
	public void config() {
		add("/test", TestController.class);
	}

}
