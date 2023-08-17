package cn.yunhe.utils;

public class FileNameUtils {
    public static String subFileName(String fileName){

        int index = fileName.lastIndexOf("/");

        return fileName.substring(index + 1);
    }
}
