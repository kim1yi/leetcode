import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> words = new HashSet<>(wordList);
        Set<String> begin = new HashSet<>();
        Set<String> end = new HashSet<>();

        begin.add(beginWord);
        if (words.contains(endWord)) {
            end.add(endWord);
        }
        else {
            return 0;
        }

        Set<String> visited = new HashSet<>();

        int length = 1;
        Set<String> tmp;
        int wordSize = beginWord.length();
        char[] arr = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t',
                        'u','v','w','x','y','z'};
        while (!begin.isEmpty() && !end.isEmpty()) {
            if (begin.size() > end.size()) {
                tmp = begin;
                begin = end;
                end = tmp;
            }
            
            tmp = new HashSet<>();
            for (String pre : begin) {
                if (end.contains(pre)) {
                    return length;
                }

                visited.add(pre);

                for (int i = 0; i < wordSize; i++) {
                    StringBuilder builder = new StringBuilder(pre);
                    int n = pre.charAt(i) - 'a';
                    for (int j = 0; j < 26; j++) {
                        if (j!=n) {
                            builder.setCharAt(i, arr[j]);
                            String str = builder.toString();
                            if (words.contains(str) && !visited.contains(str)) {
                                tmp.add(str);
                            //    words.remove(str);不能移除它，因为要求最后两者能相遇
                            }
                        }
                    }
                }
            }
            length++;
            begin = tmp;
        }

        return 0;
    }
}