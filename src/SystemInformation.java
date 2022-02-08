import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import com.sun.management.OperatingSystemMXBean;
import java.nio.file.FileStore;

public class SystemInformation {
    public long startTime;
    public long endTime;
    private static final long KILOBYTE = 1024L;
    private static final long MEGABYTE = 1024L * 1024L;
    private static final long GEGABYTE = 1024L * 1024L * 1024L;
    public OperatingSystemMXBean operatingSystemMXBean =
            (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
    public ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
    private java.nio.file.FileStore FileStore;
    public FileStore fileStore= FileStore;
    /**
     * This contructer  helps to */

    public SystemInformation() throws IOException {
        this.startTime = System.currentTimeMillis();
    }

    public static long bytesTokilobytes(long bytes) {
        return bytes / KILOBYTE;
    }

    public static long bytesToMegabytes(long bytes) {
        return bytes / MEGABYTE;
    }

    public static long bytesToGegabytes(long bytes) {
        return bytes / GEGABYTE;
    }

    public long JavaElapsedTime() {
        this.endTime = System.currentTimeMillis();
        return this.endTime - this.startTime;
    }

    public long JavaMemoryUsageMB() {
        // Get the Java runtime
        Runtime runtime = Runtime.getRuntime();
        // Run the garbage collector
        runtime.gc();
        // Calculate the used memory
        long memory = runtime.totalMemory() - runtime.freeMemory();
        return bytesToMegabytes(memory);

    }

    public long JavaMemoryUsageGB() {
        // Get the Java runtime
        Runtime runtime = Runtime.getRuntime();
        // Run the garbage collector
        runtime.gc();
        // Calculate the used memory
        long memory = runtime.totalMemory() - runtime.freeMemory();
        return bytesToGegabytes(memory);
    }

    public long JavaSystemCpuLoad() {
        return (long) this.operatingSystemMXBean.getCpuLoad();
    }

    public long JavaSystemProcessCpuLoad() {
        return (long) this.operatingSystemMXBean.getProcessCpuLoad();
    }

    public long JavaProcessCpuTime() {
        long[] allThreadIds = threadMXBean.getAllThreadIds();
        long nano = 0;
        for (long id : allThreadIds) {
            nano += threadMXBean.getThreadCpuTime(id);
        }
        return (long) (nano / 1E6);
    }
   /* public long JavaSystemDiskSpace() throws IOException {
        long totalSpace = fileStore.getTotalSpace();
        long unusableSpace = fileStore.getUnallocatedSpace();
        return totalSpace-unusableSpace;
    }*/


}

