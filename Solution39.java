import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        //先排序
        ArrayList<Integer> candidateList = (ArrayList<Integer>) Arrays.stream(candidates).boxed().collect(Collectors.toList());
        Comparator<Integer> comparator = (o1, o2)->{return o1 - o2;};
        Collections.sort(candidateList, comparator);


        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> res = new ArrayList<>();
        

        return results;
    }
}