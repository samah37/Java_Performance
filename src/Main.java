import java.io.IOException;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.List;

public class Main {

/**
 * <h1>Java program performances</h1>
 * @author Samah KANSAB
 * @version 1.0
 * @since 2022.02.09
 * This program is to get Java program performances : Cpu usage, Memory usage, Disk usage, execution time
 * Used Libraries:
 * @see  OperatingSystemMXBean
 *  {@link <a href="https://docs.oracle.com/javase/7/docs/jre/api/management/extension/com/sun/management/OperatingSystemMXBean.html">OperatingSystemMXBean</a>}
 * @see ThreadMXBean
 *  {@link  <a href="https://docs.oracle.com/javase/7/docs/api/java/lang/management/ThreadMXBean.html">ThreadMXBean</a>}
 * @see java.nio.file.FileStore
 *  {@link <a href="https://docs.oracle.com/javase/7/docs/api/java/nio/file/FileStore.html">FileStore</a>}
 * @see SystemInformation
 * */



    public static void main(String[] args) throws IOException {
        SystemInformation systemInformation = new SystemInformation();
        List<String> list = new ArrayList<String>();
        for (int i = 0; i <= 999900; i++) {
            list.add("JimKnopf");
        }

        System.out.println("Used memory is megabytes: "
                + systemInformation.JavaMemoryUsageMB());
        System.out.println("Global execution time (ms):"
                + systemInformation.JavaElapsedTime());
        System.out.println("Cpu execution time: "
                + systemInformation.JavaSystemProcessCpuLoad());
        System.out.println("Used CPU : "
                + systemInformation.JavaSystemCpuLoad());
        System.out.println("Used CPU by JAVA: "
                + systemInformation.JavaSystemProcessCpuLoad());
        System.out.println("CPU execution time (ms): "
                + systemInformation.JavaProcessCpuTime());
        //System.out.println("DISK Usage: "+ systemInformation.JavaSystemDiskSpace());

    }}

