package com.mec.about_file.test;

import java.io.*;

/**
 * @ClassName: Test
 * @Description:
 * @Author:
 * @Date: 2018/11/20 20:52
 * @Version: V1.0
 **/
public class Test {
    public static final int bufferSize = 1 << 4;

    public static void main(String[] args) {
        File resource = new File("src/resource/demo.mp4");
        File target = new File("src/resource/target/demo.mp4");
        long fileSize = resource.length();
        byte[] buffer = new byte[bufferSize];

        try {
            RandomAccessFile rafResource = new RandomAccessFile(resource, "r");
            RandomAccessFile rafTarget = new RandomAccessFile(target, "rw");

            rafTarget.seek(fileSize - 1);
            rafTarget.writeByte(0);

            rafResource.seek(16);
            rafResource.read(buffer);

            rafTarget.seek(16);
            rafTarget.write(buffer);

            rafResource.close();
            rafTarget.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*public static void main(String[] args) {
        File resource = new File("src/resource/demo.mp4");
        File target = new File("src/resource/target/demo.mp4");
        long startTime = System.currentTimeMillis();
        FileProcess.fileCopy(resource, target);
        long endTime = System.currentTimeMillis();
        System.out.println("耗时:" + (endTime - startTime));
    }*/

    /*public static final int bufferSize = 1 << 17;

    public static void main(String[] args) {
        try {
            byte[] buffer = new byte[bufferSize];

            File resource = new File("src/resource/demo.mp4");
            FileInputStream fis = new FileInputStream(resource);
            File target = new File("src/resource/target/demo.mp4");
            FileOutputStream fos = new FileOutputStream(target);

            long startTime = System.currentTimeMillis();
            long fileSize = resource.length();
            long resultLen = fileSize;
            int realLen = 0;

            while (resultLen > 0) {
                realLen = fis.read(buffer);
                fos.write(buffer, 0, realLen);
                resultLen -= realLen;
            }

            long endTime = System.currentTimeMillis();
            System.out.println("耗时:" + (endTime - startTime));

            fis.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}
