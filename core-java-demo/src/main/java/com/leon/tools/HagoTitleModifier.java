package com.leon.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2020/3/15
 */
public class HagoTitleModifier {
    public static void main(String[] args) throws Exception {
        /*String fileName = "/Users/leonwang/Documents/workspace/github/git-doc/study/corejava/java-annotation.md";
        File file = new File(fileName);
        System.out.println(getCreatedTime(file));
        modifierTitle(file);*/

        String path = "/Users/leonwang/Documents/workspace/github/git-doc/";
        getFilesNeedModified(path).forEach(needModifiedFile -> {
            System.out.println(needModifiedFile);
            try {
                modifierTitle(needModifiedFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private static List<File> getFilesNeedModified(String path) {
        List<File> needModifiedFile = new ArrayList<>();
        File root = new File(path);
        File[] files = root.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                needModifiedFile.addAll(getFilesNeedModified(file.getAbsolutePath()));
            } else if (file.getName().endsWith(".md")) {
                needModifiedFile.add(file);
            }
        }

        return needModifiedFile;
    }

    private static Date getCreatedTime(File file) throws Exception {
        Path path = Paths.get(file.getAbsolutePath());
        BasicFileAttributeView basicFileAttributeView = Files.getFileAttributeView(path, BasicFileAttributeView.class, LinkOption.NOFOLLOW_LINKS);
        BasicFileAttributes attributeView = basicFileAttributeView.readAttributes();
        return new Date(attributeView.creationTime().toMillis());
    }

    private static void modifierTitle(File file) throws Exception {
        String titleFormat = "---\ndate: \"%s\"\n" +
                "draft: false\n" +
                "lastmod: \"%s\"\n" +
                "publishdate: \"%s\"\n" +
                "tags:\n%s" +
                "title: %s\n---\n";
        String fileName = file.getName();

        String topTag = "study";
        StringBuilder tags = new StringBuilder();

        File parent = new File(file.getParent());
        String parentPath = parent.getAbsolutePath();
        boolean validTopTag = parentPath.contains(topTag);

        if (validTopTag) {
            String tagPath = parentPath.substring(parentPath.indexOf(topTag));
            String[] allTags = tagPath.split("/");
            for (String tag : allTags) {
                if (!topTag.equals(tag))
                    tags.append("- " + tag + "\n");
            }
        } else {
            tags.append("- " + parent.getName() + "\n");
        }

        String title = String.format(titleFormat, "2018-01-01", "2018-01-01", "2018-01-01", tags, fileName.substring(0, fileName.length() - 3));

        FileInputStream fileInputStream = new FileInputStream(file);


        byte[] bytes = new byte[10 * 1024 * 1024];
        int i = 0;
        while ((bytes[i++] = (byte) fileInputStream.read()) != -1) {

        }

        FileOutputStream fileOutputStream1 = new FileOutputStream(file);
        fileOutputStream1.write(title.getBytes("utf-8"));
        fileOutputStream1.write(bytes, 0, i - 1);
        fileOutputStream1.close();
    }


}
