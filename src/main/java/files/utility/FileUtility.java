package files.utility;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

 public class FileUtility {
     public static boolean createFile(String fileNamewithpath) {

        File file = new File(fileNamewithpath);
        boolean filecreated = true;

        try {
            filecreated = file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filecreated;
    }

    public static ArrayList<String> ReadFileAsList(String fileName) {

        ArrayList<String> string = new ArrayList<String>();
        Scanner scanner = null;

        File file = new File(fileName);
        try{
            scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                string.add(line);
            }
        }catch (Exception e){
            e.printStackTrace();

        }finally {
            if(scanner != null){
                scanner.close();
            }
        }
        return string;

    }

     public static void main(String[] args) {
        String nameofnewfile="C:\\Users\\Dell\\IdeaProjects\\JavaFSDpractice\\newproject\\data\\practice\\file"+"NationalAnthem.txt";
        boolean  created =createFile(nameofnewfile);
        System.out.println("file created:  "+created);
        ArrayList<String> stringArrayList= ReadFileAsList(nameofnewfile);
        for(String x: stringArrayList){
            System.out.println("line "+x);
        }
     }
 }


