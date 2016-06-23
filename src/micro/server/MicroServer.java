package micro.server;

import java.util.EnumSet;

import javax.servlet.DispatcherType;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.webapp.WebAppContext;

import com.jfinal.core.JFinalFilter;

/**
 * 启动JFinal微服务
 * @author 杨云
 */
public class MicroServer {

	public static void main(String[] args) {
		EnumSet<DispatcherType> all = EnumSet.of
				(DispatcherType.ASYNC, DispatcherType.ERROR, DispatcherType.FORWARD, DispatcherType.INCLUDE, DispatcherType.REQUEST);
		// 监听8080端口
		final Server server = new Server(8080);
		try {
			// 容器上下文
			WebAppContext context = new WebAppContext("/", "/");
			
			FilterHolder filter = new FilterHolder(new JFinalFilter());
			// 加载jfinal配置
			filter.setInitParameter("configClass", "micro.config.DemoConfig");
			// 配置filter
			context.addFilter(filter, "/*", all);
			server.setHandler(context);
			// 启动
			server.start();
			server.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
