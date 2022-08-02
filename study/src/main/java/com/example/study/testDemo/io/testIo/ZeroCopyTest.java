package com.example.study.testDemo.io.testIo;

import java.io.*;
import java.nio.channels.FileChannel;


/**
 * kafka为什么能做到百万级吞吐量，靠的就是零拷贝模型，如果你仔细看过kafka源码，你会发现它最终调用了transferTo()方法
 *
 * 硬件方面，主板上增加了DMAC元件，其实不止主板，计算机发展到今天，几乎所有牵涉到io操作的地方都集成了DMAC
 *
 * 至此，我们可以做个小总结：所谓的零拷贝技术，其实可以理解成软件、硬件、语言的结合，目的在于减少cpu等待时间，提升数据传输效率
 *
 *
 * ————————————————
 * 版权声明：本文为CSDN博主「负债程序猿」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/qq_33709582/article/details/123043821
 */
public class ZeroCopyTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        long start = System.currentTimeMillis();
        File source = new File("D:/fileTest/copy.txt");
        File target = new File("D:/fileTest/copy2.txt");

        ioCopy(source, target);
//        ioCopyWithBuffer(source, target);
//        nioCopy(source, target);
        System.out.println(System.currentTimeMillis() - start);
        Thread.sleep(200);
        target.delete();
    }

    public static void ioCopy(File source, File target) throws IOException {
        try (InputStream is = new FileInputStream(source);
             OutputStream os = new FileOutputStream(target)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        }
    }

    public static void ioCopyWithBuffer(File source, File target) throws IOException {
        try (InputStream is = new BufferedInputStream(new FileInputStream(source));
             OutputStream os = new BufferedOutputStream(new FileOutputStream(target))) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        }
    }

    public static void nioCopy(File source, File target) throws IOException {
        try (FileChannel sourceChannel = new FileInputStream(source).getChannel();
             FileChannel targetChannel = new FileOutputStream(target).getChannel()) {
            for (long count = sourceChannel.size(); count > 0; ) {
                long transferred = sourceChannel.transferTo(sourceChannel.position(), count, targetChannel);
                sourceChannel.position(sourceChannel.position() + transferred);
                count -= transferred;
            }
        }
    }
}
