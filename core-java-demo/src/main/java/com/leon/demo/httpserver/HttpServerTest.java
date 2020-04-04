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
 *
 * @author leonwang
 */
public class HttpServerTest {
    public static void main(String[] args) {
        InetSocketAddress addr = new InetSocketAddress(8888);
        HttpServer server;
        try {
            server = HttpServer.create(addr, 0);
            server.createContext("/invoke", new MyHandler());
            server.setExecutor(Executors.newFixedThreadPool(1));
            server.start();
            System.out.println("Server is listening on port 8888");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

class MyHandler implements HttpHandler {
    public void handle(HttpExchange exchange) throws IOException {
        System.out.println("handle request >>>>>>>>>>>>>>>>>");
        String requestMethod = exchange.getRequestMethod();
        if (requestMethod.equalsIgnoreCase("GET")||requestMethod.equalsIgnoreCase("POST")) {
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
                System.out.println("key=" + key);
            }
            boolean valid = keySet.contains("X-hub-signature");
            String msg = "ok";
            if (!valid) {
                System.out.println("invalid request !!!!! ");
                msg = "error";
            } else {
                System.out.println("pull from git...");
                Process process = Runtime.getRuntime().exec("/bin/sh -c '#!/bin/sh\n" +
                        "echo \"$(date) git pull start...\"\n" +
                        "expect <<!\n" +
                        "cd /home/ops/blog/themes/cupper-hugo-theme/blog/content/post/git-doc\n" +
                        "set timeout 120\n" +
                        "spawn git pull\n" +
                        "expect \"*passphrase*\"\n" +
                        "send \"1qaz2wsx\\r\"\n" +
                        "expect eof\n" +
                        "!\n" +
                        "echo \"$(date) git pull finished\"'");
                try {
                    process.waitFor();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("pull finished ...");
            }
            System.out.println("handle request finish<<<<<<<<<<<");
            responseBody.write(msg.getBytes());
            responseBody.close();
        }
    }
}
