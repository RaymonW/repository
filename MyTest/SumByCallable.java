package MyTest;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SumByCallable {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int n = 10;//�߳���
        long start=1L;//��ʼֵ
        long end=1000000L;//����ֵ
        long sum = 0L;
        ExecutorService threads = Executors.newFixedThreadPool(n);
        CompletionService<Long> cs = new ExecutorCompletionService<Long>(threads);
        for(int i=0;i<n;i++){
            cs.submit(new SumCallable(start, end, n, i));
        }
        threads.shutdown();//�ر�service
        for(int i=0;i<n;i++){
            try {
                sum += cs.take().get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("�ͣ�"+sum+",��ʱ��"+(endTime-startTime)+"ms");
    }

}

class SumCallable implements Callable<Long>{
    private long start;
    private long end;
    public SumCallable(long start, long end, int n, int index){
        this.start = index * (end-start)/n;
        this.end = (index+1) * (end-start)/n-1;
        if(index==0){
            this.start = start;
        }
        if(index == n-1){
            this.end = end;
        }
    }

    @Override
    public Long call() throws Exception {
        long sum = 0;
        for(long i=start;i<=end;i++){
            sum +=i;
        }
        Thread.sleep(400);
    //    System.out.println(Thread.currentThread().getName()+":"+sum);
        return sum;
    }
    
}