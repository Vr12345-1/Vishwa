import java.util.HashMap;

public class FeatureExtractor {
    public static HashMap<String, Integer> getWordFrequencies(String text) {
        HashMap<String, Integer> wordFreq = new HashMap<>();
        String[] words = text.split("\\s+");
        for (String word : words) {
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
        }
        return wordFreq;
    }
}
