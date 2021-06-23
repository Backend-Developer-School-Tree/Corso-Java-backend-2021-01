package tweets_parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TweetsParser {

    Map<String, Integer> countMap = new HashMap<>();
    Map<Integer, Set<String>> frequencyMap = new TreeMap<>(Collections.reverseOrder());
    //Queue<WordObject> wordsByFrequency = new PriorityQueue<>(Collections.reverseOrder());

    Set<String> getMostFrequentWords(int n) throws IOException {
        Set<String> result = new HashSet<>();
        for(Integer count : frequencyMap.keySet()) {
            Set<String> words = frequencyMap.get(count);
            for(String s : words)
                if(result.size() < n)
                    result.add(s);
                else
                    return result;
        }
        return result;
    }

    public void buildMap(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine(); //skip first
            while ((line = br.readLine()) != null) {
                processLine(line);
            }
        }

        /*for(String word : countMap.keySet()) {
            wordsByFrequency.add(new WordObject(word, countMap.get(word)));
        }*/

    }

    private void processLine(String line) {
        String[] components = line.split(",");
        String content = "";
        for(int i=0; i<components.length; i++)
            if((i >= 2 && i < components.length-3))
                content += components[i];

        for(String word : content.split(" ")){
            String cleanWord = cleanData(word);
            if(cleanWord.isEmpty())
                continue;
            int count = countMap.getOrDefault(cleanWord, 1) + 1;
            countMap.put(cleanWord, count);

            if(frequencyMap.containsKey(count))
                frequencyMap.get(count).add(cleanWord);
            else {
                Set<String> s = new HashSet<>();
                s.add(cleanWord);
                frequencyMap.put(count, s);
            }

            if(frequencyMap.containsKey(count-1))
                frequencyMap.get(count-1).remove(cleanWord);
        }
    }

    private static String cleanData(String tweet) {
            //convert tweet to lower case
            tweet = tweet.toLowerCase();

            //remove # from hash tag
            tweet = tweet.replaceAll("#", "");

            //remove punctuation
            tweet = tweet.replaceAll("[-+.^:,()&%$\"\'!;=<=/#@?^_]", "");

            //remove only numbers text
            tweet = tweet.replaceAll("[0-9]", "");

        return tweet;
    }

    public static void main(String[] args) throws IOException {
        String path = "/Users/mel/Desktop/tmp/realdonaldtrump.csv";
        TweetsParser tweetsParser = new TweetsParser();
        tweetsParser.buildMap(path);
        System.out.println(tweetsParser.getMostFrequentWords(10));
    }
}
