import java.util.*;

public class TextQueries {
    public static List<List<Integer>> textQueries(List<String> sentences, List<String> queries) {
        List<List<Integer>> result = new ArrayList<>();
        Map<String, List<Integer>> wordIndices = new HashMap<>();

        // Indexing sentences based on words
        for (int i = 0; i < sentences.size(); i++) {
            String[] words = sentences.get(i).split(" ");
            for (String word : words) {
                wordIndices.computeIfAbsent(word, k -> new ArrayList<>()).add(i);
            }
        }

        // Processing queries
        for (int i = 0; i < queries.size(); i++) {
            String[] queryWords = queries.get(i).split(" ");
            List<Integer> indices = new ArrayList<>();

            // Finding indices of sentences containing all query words
            boolean validQuery = true;
            for (String queryWord : queryWords) {
                if (wordIndices.containsKey(queryWord)) {
                    if (indices.isEmpty()) {
                        indices.addAll(wordIndices.get(queryWord));
                    } else {
                        indices.retainAll(wordIndices.get(queryWord));
                    }
                } else {
                    validQuery = false;
                    break;
                }
            }

            // Storing the result based on the query validity
            if (validQuery) {
                result.add(indices);
            } else {
                result.add(new ArrayList<>());
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<String> sentences = Arrays.asList("it go will away", "go do art", "what to will east");
        List<String> queries = Arrays.asList("it will", "go east will", "wo;;");

        List<List<Integer>> result = textQueries(sentences, queries);

        // Printing the result
        for (List<Integer> indices : result) {
            for (int index : indices) {
                System.out.print(index + " ");
            }
            System.out.println();
        }
    }
}
