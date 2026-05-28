package study.concurrentHashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapRaceConditionExample {
    static Map<String,Integer> map = new ConcurrentHashMap<>();
    public static void main(String[] args) throws InterruptedException{
        int threadCount = 10;
        int repeatCount = 100_000;

        Thread[] threads = new Thread[threadCount];

        for(int i =0;i<threadCount;i++){
            threads[i] = new Thread(()->{
                for(int j=0;j<repeatCount;j++){
                    map.compute("apple",(key,oldValue)->{
                        if(oldValue==null){
                            return 1;
                        }
                        return oldValue+1;
                    });
                }
            });
        }
        for( Thread thread : threads){
            thread.start();
        }
        for(Thread thread : threads){
            thread.join();
        }
        System.out.println("Excepted: "+(threadCount*repeatCount));
        System.out.println("Actual: "+map.get("apple"));
    }
}
