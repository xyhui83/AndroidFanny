package com.ivan.androidfanny.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

/**
 * 读取流文件
 *
 * @author Ivan
 */
public class StreamTool {

    /**
     * 将字节数组保存到文件中
     *
     * @param file 文件
     * @param data 字节数组数据
     * @throws IOException io异常
     */
    public static void save(File file, byte[] data) throws IOException {
        FileOutputStream outStream = new FileOutputStream(file);
        outStream.write(data);
        outStream.close();
    }

    public static String readLine(PushbackInputStream in) throws IOException {
        char buf[] = new char[128];
        int room = buf.length;
        int offset = 0;
        int c;
        loop:
        while (true) {
            switch (c = in.read()) {
                case -1:
                case '\n':
                    break loop;
                case '\r':
                    int c2 = in.read();
                    if ((c2 != '\n') && (c2 != -1)) {
                        in.unread(c2);
                    }
                    break loop;
                default:
                    if (--room < 0) {
                        char[] lineBuffer = buf;
                        buf = new char[offset + 128];
                        room = buf.length - offset - 1;
                        System.arraycopy(lineBuffer, 0, buf, 0, offset);

                    }
                    buf[offset++] = (char) c;
                    break;
            }
        }
        if ((c == -1) && (offset == 0)) {
            return null;
        }
        return String.copyValueOf(buf, 0, offset);
    }

    /**
     * 从流中读取数据，以字节数组返回
     *
     * @param inStream 输入流
     * @return 字节数组
     * @throws IOException io异常
     */
    public static byte[] readStream(InputStream inStream) throws IOException {
        ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = -1;
        while ((len = inStream.read(buffer)) != -1) {
            outSteam.write(buffer, 0, len);
        }
        outSteam.close();
        inStream.close();
        return outSteam.toByteArray();
    }
}