import java.util.Arrays;
import java.util.List;

public class EmailPreprocessor {
    public static String cleanText(String text) {
        // Convert to lowercase
        text = text.toLowerCase();

        // Remove special characters
        text = text.replaceAll("[^a-zA-Z0-9\\s]", "");

        // Remove stopwords (simplified)
        List<String> stopwords = Arrays.asList("the", "and", "is", "in", "to", "of", "a");
        for (String stopword : stopwords) {
            text = text.replaceAll("\\b" + stopword + "\\b", "");
        }

        return text.trim();
    }
}
