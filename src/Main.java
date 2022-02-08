import java.util.ArrayList;
import java.util.List;

public class Main {





    public static void main(String[] args) {
        SystemInformation systemInformation = new SystemInformation();
        systemInformation.StartTime();


        List<String> list = new ArrayList<String>();
        for (int i = 0; i <= 500000; i++) {
            list.add("JimKnopf");
        }




        System.out.println("Used memory is megabytes: "
                + systemInformation.JavaMemoryUsageMB());
       // long stopTime = System.currentTimeMillis();
       // long elapsedTime = stopTime - startTime;
        System.out.println(systemInformation.JavaElapsedTime());

        System.out.println(systemInformation.JavaSystemCpuLoad());
    }}

