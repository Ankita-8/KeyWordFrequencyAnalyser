package files;

import java.util.Scanner;

public class RunnableExample implements Runnable {


    private String threadName;
    private  int counter;
    private int waitTimewhileLoop;

    public RunnableExample(String threadName ,int counter, int waitTimewhileLoop){
        this.threadName=threadName;
        this.counter=counter;
        this.waitTimewhileLoop =waitTimewhileLoop;

    }



    public static void main(String[] args) {

        files.RunnableExample runnable1=new files.RunnableExample ("Thread_A : ", 0,500);
        files.RunnableExample  runnable2=new files.RunnableExample ("Thread_B : ", 0,400);
        files.RunnableExample  runnable3=new files.RunnableExample ("Thread_C : ", 0,300);



        Thread thread1 =new Thread(runnable1);
        Thread thread2 =new Thread(runnable2);
        Thread thread3 =new Thread(runnable3);

        thread1.start();
        thread2.start();
        thread3.start();



        Scanner scanner =new Scanner(System.in);
        int x = scanner.nextInt();



    }


    @Override
    public void run() {
        while(counter<100000)
            counter++;

        try{
            Thread.sleep(waitTimewhileLoop);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(counter);
    }
}
