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
     * This constructor is to instantiate the SystemInformation class
     * At the same time save the program execution start time
     * @throws IOException  If an input or output exception occurred
     * */

    public SystemInformation() throws IOException {
        this.startTime = System.currentTimeMillis();
    }

    /**
     * @param bytes
     * @return bytes transformed to larger units
     */

    public static long bytesTokilobytes(long bytes) {
        return bytes / KILOBYTE;
    }

    public static long bytesToMegabytes(long bytes) {
        return bytes / MEGABYTE;
    }

    public static long bytesToGegabytes(long bytes) {
        return bytes / GEGABYTE;
    }
    /**
     * Use: startTime
     * Get: EndTime
     * @return the ElapsedTime
     * */

    public long JavaElapsedTime() {
        this.endTime = System.currentTimeMillis();
        return this.endTime - this.startTime;
    }

    /**
     * Get: totalMemory, freeMemory
     * @return usedMemory by Megabytes
     */

    public long JavaMemoryUsageMB() {
        // Get the Java runtime
        Runtime runtime = Runtime.getRuntime();
        // Run the garbage collector
        runtime.gc();
        // Calculate the used memory
        long memory = runtime.totalMemory() - runtime.freeMemory();
        return bytesToMegabytes(memory);

    }
    /**
     * Get: totalMemory, freeMemory
     * @return usedMemory by Gegabytes
     */

    public long JavaMemoryUsageGB() {
        // Get the Java runtime
        Runtime runtime = Runtime.getRuntime();
        // Run the garbage collector
        runtime.gc();
        // Calculate the used memory
        long memory = runtime.totalMemory() - runtime.freeMemory();
        return bytesToGegabytes(memory);
    }

    /**
     * @return the "recent cpu usage" for the whole system
     */

    public long JavaSystemCpuLoad() {
        return (long) this.operatingSystemMXBean.getCpuLoad();
    }

    /**
     * @return the "recent cpu usage" for the Java Virtual Machine process
     */

    public long JavaSystemProcessCpuLoad() {
        return (long) this.operatingSystemMXBean.getProcessCpuLoad();
    }

    /**
     * @return the sum of the execution times of all the threads
     */

    public long JavaProcessCpuTime() {
        long[] allThreadIds = threadMXBean.getAllThreadIds();
        long nano = 0;
        for (long id : allThreadIds) {
            nano += threadMXBean.getThreadCpuTime(id);
        }
        return (long) (nano / 1E9);
    }
    /**
     * Get: totalDisk, freeDisk
     * @return usedDISK
     */


   /* public long JavaSystemDiskSpace() throws IOException {
        long totalSpace = fileStore.getTotalSpace();
        long unusableSpace = fileStore.getUnallocatedSpace();
        return totalSpace-unusableSpace;
    }*/


}

