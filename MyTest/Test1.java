package MyTest;

import java.util.concurrent.*;

public class Test1 {
	public static void main(String[] args) {
		int n = 1000000;
//		测试输入
		long[] nums = new long[n];
		for(int i=0;i<n;i++) nums[i] = i+1;
		
//		其他输入
//		Scanner read = new Scanner(System.in);
//		int k = 0;
//		while(read.hasNext()) {
//			nums[k++] = read.nextInt();
//		}
//		read.close();
        
        long beginTime = System.currentTimeMillis(); //计时开始
        int maxThread = 10;
        int low = 0;
        int high = n;
        long sum = 0L;
        //建立固定线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(maxThread); 
        //批量处理
        for(int i=0;i<maxThread;i++){
        	//Callable线程执行可返回值，每个线程平分数组，分别计算，返回结果。
        	MyCallable1 callable = new MyCallable1(nums, high-low, i, maxThread);  
        	FutureTask<Long> future = new FutureTask<Long>(callable);
        	Thread thread = new Thread(future);
            thread.start();
            try{
            	sum += future.get();
            } catch(InterruptedException e) {
            	e.printStackTrace();
            } catch(ExecutionException e) {
            	e.printStackTrace();
            }
        }
        //关闭线程池
        threadPool.shutdown();
        long endTime = System.currentTimeMillis();
        long totalTime = endTime-beginTime;
        
        System.out.println(sum+","+totalTime+"ms");
    }
}

class MyCallable1 implements Callable<Long>{
    private int low;
    private int high;
    private long[] nums;
    
    public MyCallable1(long[] nums, int len, int index,int maxThread){
        low = index*len/maxThread;  //线程分得的部分数组低坐标
        high = (index+1)*len/maxThread-1; //线程分得的部分数组高坐标
        this.nums = nums;
    }

    @Override
    public Long call() throws Exception {
        long sum = 0;
//        for(int i=low;i<=high;i++){
//            sum += nums[i];
//        }
        sum = sum(nums,low,high);
        return sum;
    }
    
    // 二分递归测试，都是O(n)复杂度，时间和for循环没什么差别
    long sum ( long n[], int l, int h) {
    	   if ( l == h ) 
    	      return n[l];
    	   else {
    	      int m = (l+h)/2;
    	      return sum (n, l, m) + sum (n, m+1, h);
    	   }
    	}
}
