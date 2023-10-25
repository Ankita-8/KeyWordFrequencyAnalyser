package files;

import java.util.Scanner;

public class ThreadExample extends Thread{

    private String threadName;
    private  int counter;
    private int waitTimewhileLoop;

    public ThreadExample(String threadName ,int counter, int waitTimewhileLoop){
        this.threadName=threadName;
        this.counter=counter;
        this.waitTimewhileLoop =waitTimewhileLoop;

    }
    public  void run(){
        while(counter<100000)
            counter++;

        try{
            Thread.sleep(waitTimewhileLoop);
        }catch (InterruptedException e){
            e.printStackTrace();
        }



        System.out.println(threadName+ " : "+counter);


    }


    public static void main(String[] args) {

        ThreadExample thread1=new ThreadExample("Thread_A : ", 0,500);
        ThreadExample thread2=new ThreadExample("Thread_B : ", 0,400);
        ThreadExample thread3=new ThreadExample("Thread_C : ", 0,300);

        thread1.start();
        thread2.start();
        thread3.start();

        System.out.println(thread1.counter);
        System.out.println(thread2.counter);
        System.out.println(thread3.counter);

        Scanner scanner =new Scanner(System.in);
        int x = scanner.nextInt();



    }
}

