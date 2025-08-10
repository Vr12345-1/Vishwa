import java.util.HashMap;

public class ModelTrainer {
    private HashMap<String, Integer> spamWordCounts = new HashMap<>();
    private HashMap<String, Integer> hamWordCounts = new HashMap<>();
    private int spamEmailCount = 0;
    private int hamEmailCount = 0;

    public void train(String label, String text) {
        HashMap<String, Integer> wordFreq = FeatureExtractor.getWordFrequencies(text);
        if (label.equals("Spam")) {
            spamEmailCount++;
            wordFreq.forEach((word, count) -> 
                spamWordCounts.put(word, spamWordCounts.getOrDefault(word, 0) + count)
            );
        } else {
            hamEmailCount++;
            wordFreq.forEach((word, count) -> 
                hamWordCounts.put(word, hamWordCounts.getOrDefault(word, 0) + count)
            );
        }
    }

    public String predict(String text) {
        HashMap<String, Integer> wordFreq = FeatureExtractor.getWordFrequencies(text);
        double spamScore = Math.log(spamEmailCount);
        double hamScore = Math.log(hamEmailCount);

        for (String word : wordFreq.keySet()) {
            int spamCount = spamWordCounts.getOrDefault(word, 1);
            int hamCount = hamWordCounts.getOrDefault(word, 1);

            spamScore += Math.log(spamCount);
            hamScore += Math.log(hamCount);
        }

        return spamScore > hamScore ? "Spam" : "Ham";
    }
}
