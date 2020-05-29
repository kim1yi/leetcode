import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution127 solution = new Solution127();
       
        String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> words = new ArrayList<>(Arrays.asList(wordList));
        System.out.println(solution.ladderLength("hit", "cog", words));
    }
}