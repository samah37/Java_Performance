import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;
public class SystemInformation {
    public long startTime;
    public long endTime;
    private static final long KILOBYTE = 1024L;
    private static final long MEGABYTE = 1024L * 1024L  ;
    private static final long GEGABYTE = 1024L * 1024L * 1024L ;
    public OperatingSystemMXBean operatingSystemMXBean =
            (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
    public static long bytesTokilobytes(long bytes) {
        return bytes / KILOBYTE;
    }
    public static long bytesToMegabytes(long bytes) {
        return bytes / MEGABYTE;
    }
    public static long bytesToGegabytes(long bytes) {
        return bytes / GEGABYTE;
    }
   public void StartTime(){
       this.startTime= System.currentTimeMillis();
   }
   public long JavaElapsedTime(){
       this.endTime = System.currentTimeMillis();
       return endTime-startTime;
   }
   public long JavaMemoryUsageMB(){
       // Get the Java runtime
       Runtime runtime = Runtime.getRuntime();
       // Run the garbage collector
       runtime.gc();
       // Calculate the used memory
       long memory = runtime.totalMemory() - runtime.freeMemory();
       return bytesToMegabytes(memory);
    }
    public long JavaMemoryUsageGB(){
        // Get the Java runtime
        Runtime runtime = Runtime.getRuntime();
        // Run the garbage collector
        runtime.gc();
        // Calculate the used memory
        long memory = runtime.totalMemory() - runtime.freeMemory();
        return bytesToGegabytes(memory);
    }
    public long JavaSystemCpuLoad(){
        return (long) this.operatingSystemMXBean.getCpuLoad();
    }
    public long JavaSystemProcessCpuLoad(){
        return (long) this.operatingSystemMXBean.getProcessCpuLoad();
    }
    public long JavaProcessCpuTime(){
        return this.operatingSystemMXBean.getProcessCpuTime();
    }





}
