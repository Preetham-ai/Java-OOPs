import java.util.*;

public class CollectionAnalyzer {
    public static <T> List<T> removeDuplicates(List<T> list) {
        return new ArrayList<>(new LinkedHashSet<>(list));
    }
    
    public static <T> Map<T, Integer> countOccurrences(List<T> list) {
        Map<T, Integer> counts = new HashMap<>();
        for(T item : list) {
            counts.put(item, counts.getOrDefault(item, 0) + 1);
        }
        return counts;
    }

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Alice", "Charlie", "Bob");
        
        System.out.println("Original list: " + names);
        System.out.println("Without duplicates: " + removeDuplicates(names));
        System.out.println("Counts: " + countOccurrences(names));
    }
}
