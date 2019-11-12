package com.leon.demo.freemarker;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2019/7/16
 */
public class HelloWorld {
    public static void main(String[] args) throws IOException {

    }

    public static Configuration buildConfiguration() throws IOException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
        cfg.setDirectoryForTemplateLoading(new File("templates"));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
        return cfg;
    }

    public static Map buildDateModel() {
        Map<String, Object> root = new HashMap();
        root.put("user", "LeonWang");

        Product latest = new Product();
        latest.setUrl("products/greenmouse.html");
        latest.setName("green mouse");
        // and put it into the root
        root.put("latestProduct", latest);

        return root;

    }
}

class Product {

    private String url;
    private String name;

    // As per the JavaBeans spec., this defines the "url" bean property
    // It must be public!
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // As per the JavaBean spec., this defines the "name" bean property
    // It must be public!
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
