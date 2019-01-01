package com.leon.demo.httpserver;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executors;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

/**
 * jdk1.6后httpserver轻量级实现
 * @author leonwang
 *
 */
public class HttpServerTest {
	public static void main(String[] args) {
		InetSocketAddress addr = new InetSocketAddress(8080);
		HttpServer server;
		try {
			server = HttpServer.create(addr, 0);
			server.createContext("/server", new MyHandler());
			server.setExecutor(Executors.newCachedThreadPool());
			server.start();
			System.out.println("Server is listening on port 8080");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

class MyHandler implements HttpHandler {
	public void handle(HttpExchange exchange) throws IOException {
		String requestMethod = exchange.getRequestMethod();
		if (requestMethod.equalsIgnoreCase("GET")) {
			Headers responseHeaders = exchange.getResponseHeaders();
			responseHeaders.set("Content-Type", "text/plain");
			responseHeaders.set("Content-Type", "text/html; charset=utf-8");
			exchange.sendResponseHeaders(200, 0);
			System.out.println("in====");
			OutputStream responseBody = exchange.getResponseBody();
			Headers requestHeaders = exchange.getRequestHeaders();
			Set<String> keySet = requestHeaders.keySet();
			Iterator<String> iter = keySet.iterator();
			while (iter.hasNext()) {
				String key = iter.next();
				System.out.println("key="+key);
//				List<String> values = requestHeaders.get(key);
//				String s = key + " = " + values.toString() + "\n";
//				responseBody.write(s.getBytes());
			}
			responseBody.write("jdk自带轻量级http server例子".getBytes());
			responseBody.close();
		}
	}
}