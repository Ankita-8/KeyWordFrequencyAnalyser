package files.utility;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class TopkeywordAnalyser implements Runnable {

    private final String filepath;
    public TopkeywordAnalyser(String filepath){
        this.filepath=filepath;
    }

    @Override
    public void run() {
        ArrayList<String> keywordsFiledata = FileUtility.ReadFileAsList(filepath);
        HashMap<String, Integer> KeywordCounter = new HashMap<String, Integer>();

        for (String row : keywordsFiledata) {
            String[] keywords = row.split(" ");
            for (String keyword : keywords) {

                String str = keyword.toLowerCase();
                if (!KeywordCounter.containsKey(str)) {
                    KeywordCounter.put(str, 1);
                } else {
                    Integer value = KeywordCounter.get(str);
                    KeywordCounter.put(str, value + 1);

                }
            }
        }
        ArrayList<KeywordCount> keywordCountArrayList = new ArrayList<KeywordCount>();
        for (String keyword : KeywordCounter.keySet()) {
            KeywordCount keywordCount = new KeywordCount(keyword, KeywordCounter.get(keyword));
            keywordCountArrayList.add(keywordCount);
        }
        Collections.sort(keywordCountArrayList, new Comparator<KeywordCount>() {
            @Override
            public int compare(KeywordCount o1, KeywordCount o2) {
                return o2.count - o1.count;
            }
        });
        for (KeywordCount keywordCount : keywordCountArrayList) {
            System.out.println(keywordCount.keyword + ":" + keywordCount.count);
        }


    }


     public static void main(String[] args) {
        TaskManager taskManager = new TaskManager(1);
        taskManager.waitTillQueueIsFreeAndAddTask(new TopkeywordAnalyser("C:\\Users\\Dell\\IdeaProjects\\JavaFSDpractice\\newproject\\data\\practice\\fileNationalAnthem.txt"));
      }
}

