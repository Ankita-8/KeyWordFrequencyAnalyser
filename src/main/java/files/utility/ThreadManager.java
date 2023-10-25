package files.utility;

import files.RunnableExample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class ThreadManager {
    public static void main(String[] args) {

        TaskManager taskManager =new TaskManager(100);

        for(int i=0; i<1000 ;i++){
            RunnableExample temp =new RunnableExample("Thraed-A ", 0,500+i);
            taskManager.waitTillQueueIsFreeAndAddTask(temp);

            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$"+ i);
        }
        System.out.println("#########################################################");
    }

}

