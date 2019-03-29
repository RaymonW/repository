package MyTest;

import java.util.concurrent.*;
import java.util.*;

public class Test {
	public static void main(String[] args) {
		int n = 100000000;
//		��������
		long[] nums = new long[n];
		for(int i=0;i<n;i++) nums[i] = i+1;
		
//		�������뷽ʽ
//		Scanner read = new Scanner(System.in);
//		int k = 0;
//		while(read.hasNext()) {
//			nums[k++] = read.nextInt();
//		}
//		read.close();
        
        long beginTime = System.currentTimeMillis(); //��ʱ��ʼ
        int maxThread = 21;
        int low = 0;
        int high = n;
        long sum = 0L;
        //��������
        List<FutureTask<Long>> tasks = new ArrayList<FutureTask<Long>>(); 
        ExecutorService executorService = Executors.newFixedThreadPool(maxThread);
        for(int i=0;i<maxThread;i++){
        	//Callable�߳�ִ�пɷ���ֵ��ÿ���߳�ƽ�����飬�ֱ���㣬���ؽ����
        	MyCallable callable = new MyCallable(nums, high-low, i, maxThread);  
        	FutureTask<Long> future = new FutureTask<Long>(callable);
        	tasks.add(future);
//        	Thread thread = new Thread(future);
//        	executorService.execute(future);
        	executorService.submit(future);
//            thread.start();
        }
        for(FutureTask<Long> task:tasks){
            try{
            	sum += task.get();  //��ȡ����ֵ
            } catch(InterruptedException e) {
            	e.printStackTrace();
            } catch(ExecutionException e) {
            	e.printStackTrace();
            }
        }
        executorService.shutdown();
        long endTime = System.currentTimeMillis();
        long totalTime = endTime-beginTime;
        
        System.out.println(sum+","+totalTime+"ms");
    }
}

class MyCallable implements Callable<Long>{
    private int low;
    private int high;
    private long[] nums;
    
    public MyCallable(long[] nums, int len, int index,int maxThread){
        low = index*len/maxThread;  //�̷ֵ߳õĲ������������
        high = (index+1)*len/maxThread-1; //�̷ֵ߳õĲ������������
        this.nums = nums;
    }

    @Override
    public Long call() throws Exception {
        long sum = 0;
//        for(int i=low;i<=high;i++){
//        	sum += 1000*nums[i]/nums[i]*nums[i]/nums[i]*nums[i]/nums[i]*nums[i]/nums[i]*nums[i]/nums[i]*nums[i]/nums[i]*nums[i];
//        }
        Thread.sleep(1000);
//        sum = sum(nums,low,high);
        
        return sum;
    }

    // ���ֵݹ���ԣ�����O(n)���Ӷȣ�ʱ���forѭ��ûʲô���
    long sum ( long n[], int l, int h) {
    	if (l==h) 
    		return 1000*n[l]/n[l]*n[l]/n[l]*n[l]/n[l]*n[l]/n[l]*n[l]/n[l]*n[l]/n[l]*n[l];
    	else {
    		int m = (l+h)/2;
    		return sum (n, l, m) + sum (n, m+1, h);
    	}
	}
}
