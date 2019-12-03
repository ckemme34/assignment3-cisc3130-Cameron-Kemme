
import java.util.*;
import java.io.*;

/**
 * Name: Cameron Kemme Assignment 3
 *
 * The purpose of this code is to read in lyrics and let the user know the number of occurrences. 
 * The code simple scanner to read in the lyrics and put it into an expandable list. This
 * list is then copied to an array for the ability to know its size. Finally it,
 * is added to a hash map for sorting and counting. For our test case I chose Post Malone's Better Now
 * for its repetition. 
 */
/**
 * The wordCount class checks the word frequency of a lyric text file.
 */
public class wordCount {

    public Object[] x;
    public Map<String, Integer> hm = new HashMap<>();
    public Map<String, Integer> sortedHm = new HashMap<>();
    PrintStream ps;

    /**
     * The wordCount constructor
     * @param text
     * @throws java.io.FileNotFoundException
     */
    public wordCount(Object[] text) throws FileNotFoundException {
        this.ps = new PrintStream("output.txt");
        x = text.clone();
        toHashMap();
    }

    /**
     * The toHashMap method: Puts elements of an array into a hash map
     */
    private void toHashMap() {

        for (Object x1 : x) {
            String next = x1.toString();
            if (!next.equals(" ") && !next.equals("")) {
                if (!hm.containsKey(next)) {
                    hm.put(next, 1);
                } else {
                    hm.put(next, hm.get(next) + 1);
                }
            }
        }
        sortHashMap();
    }

    /**
     * The sortHashMap method: Sorts an unsorted hash map via list by key
     */
    public void sortHashMap() {

        // Create a list from elements of HashMap
        java.util.List<Map.Entry<String, Integer>> list = new LinkedList<>(hm.entrySet());

        // Sort the list using a lambda expression
        Collections.sort(list, (Map.Entry<String, Integer> o1,
                Map.Entry<String, Integer> o2)
                -> (o2.getValue()).compareTo(o1.getValue()));

        // put data from sorted list to hashmap using a lambda expression
        list.forEach((aa) -> {
            sortedHm.put(aa.getKey(), aa.getValue());
        });

        checkFrequency();
    }

    /**
     * The checkFrequency method: Check frequencies of words in a hash map
     */
    public void checkFrequency() {
        sortedHm.keySet().forEach((s) -> {
            int count = sortedHm.get(s);
            ps.println(count + ": " + s);
        });

        System.out.println("\nTotal number of words = " + (x.length));
        System.out.println("\nTotal number of unique words = " + (sortedHm.size()));

    }

    public static void main(String args[]) throws FileNotFoundException {

        Scanner sc = new Scanner(new File("document.txt"));
        List<String> document = new ArrayList();
        String s;

        //read in raw text file to array list cleaned
        while (sc.hasNext()) {
            s = sc.next().replaceAll("[^a-zA-Z0-9']", "").toLowerCase();
            document.add(s);
        }
        Object[] text = document.toArray();
        int size = document.size();
        wordCount obj = new wordCount(text);

    }
}
