package com.leon.demo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2019/8/23
 */
public class JSoupDemo {
    private static HashSet<String> links = new HashSet<>();

    public static void main(String[] args) throws IOException {
//        grabUrl("https://www.baidu.com");
        grabImage("https://ztg-uat.zhongan.com/promote/entrance/promoteEntrance.do?redirectType=h5&promotionCode=INST190842828010&productCode=PRD190390008002&promoteCategory=multi_product&token=&returnUrl=https%253a%252f%252frelease.mingzebx.com%252feshop%252f%2523%252forders");
    }

    public static void grabUrl(String url) {
        Document document = null;
        try {
            document = Jsoup.connect(url).get();
            System.out.println(document.title());

            Elements links = document.select("a[href]");
            for (Element link : links) {
                String href = link.attr("href");
                if (!href.startsWith("http") || !(JSoupDemo.links.add(href))) {
                    continue;
                }
                System.out.println(link.text() + " : " + link.attr("href"));
                grabUrl(link.attr("href"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void grabImage(String url){
        try
        {
            Document document = Jsoup.connect(url).get();
            Elements images = document.select("img[src~=(?i)\\.(png|jpe?g|gif)]");
            for (Element image : images)
            {
                System.out.println("src : " + image.attr("src"));
                System.out.println("height : " + image.attr("height"));
                System.out.println("width : " + image.attr("width"));
                System.out.println("alt : " + image.attr("alt"));
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


    }

}
