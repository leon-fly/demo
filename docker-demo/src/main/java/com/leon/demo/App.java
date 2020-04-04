package com.leon.demo;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        int port = 9999;
        InetSocketAddress addr = new InetSocketAddress(port);
        HttpServer server;
        try {
            server = HttpServer.create(addr, 0);
            server.createContext("/server", new MyHandler());
            server.setExecutor(Executors.newCachedThreadPool());
            server.start();
            System.out.println("Server is listening on port " + port);
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
            System.out.println("request in====");
            OutputStream responseBody = exchange.getResponseBody();
            Headers requestHeaders = exchange.getRequestHeaders();
            Set<String> keySet = requestHeaders.keySet();
            Iterator<String> iter = keySet.iterator();
//            while (iter.hasNext()) {
//                String key = iter.next();
//                System.out.println("key="+key);
//				List<String> values = requestHeaders.get(key);
//				String s = key + " = " + values.toString() + "\r\n";
//				responseBody.write(s.getBytes());
//            }
            responseBody.write(("hello,this is server.." + new Date()).getBytes());
            responseBody.close();
        }
    }
}