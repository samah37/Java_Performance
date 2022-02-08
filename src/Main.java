import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {





    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        SystemInformation systemInformation = new SystemInformation();
        List<String> list = new ArrayList<String>();
        for (int i = 0; i <= 999900; i++) {
            list.add("JimKnopf");
        }

        System.out.println("Used memory is megabytes: "
                + systemInformation.JavaMemoryUsageMB());
       // long stopTime = System.currentTimeMillis();
       // long elapsedTime = stopTime - startTime;
        System.out.println(systemInformation.JavaElapsedTime());
        System.out.println("test ");

        System.out.println(systemInformation.JavaProcessCpuTime());
    }}

