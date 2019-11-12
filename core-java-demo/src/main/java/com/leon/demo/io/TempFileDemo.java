package com.leon.demo.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2018/11/12
 */
public class TempFileDemo {
    public static void main(String[] args) throws IOException {
        File dir = new File("/Users/leonwang/Documents/workspace/github/demo/");
        File file = File.createTempFile("test", ".txt", dir);
        file.deleteOnExit();
        FileOutputStream fos = new FileOutputStream(file);
        fos.write("Hello TempFile!".getBytes("UTF-8"));
        fos.flush();
        fos.close();
        System.out.println("文件存储位置：" + file.getAbsolutePath());
        file.deleteOnExit();
    }
}
