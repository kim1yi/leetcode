import java.util.ArrayList;
import java.util.List;

public class Solution60 {

    private boolean[] serial;
    public List<String> generateSequence(int n) {
        serial = new boolean[n+1];
        List<String> results = new ArrayList<>();
        StringBuilder res = new StringBuilder("");
        generator(results, res, n);
        return results;
    }
    private void generator(List<String> results, StringBuilder res, int n) {
        if (res.length() == n) {
            results.add(res.toString());
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!serial[i]) {
                res.append(i);
                serial[i] = true;
                generator(results, res, n);
                serial[i] = false;
                res.setLength(res.length()-1);
            }
        }
    }

    public String getPermutation(int n, int k) {      

        serial = new boolean[n+1];
        int factor = 1;
        for (int i = 2; i < n; i++) {
            factor *= i;
        }
        StringBuilder builder = new StringBuilder("");
        int index = 1, reminder = k % factor, num = k / factor;
        while (reminder != 0) {
            int position = getNthNumber(num+1);
            builder.append(position);
            serial[position] = true;
            if (index == n) {
                return builder.toString();
            }
            factor /= (n-index);
            index++;
            num = reminder / factor;
            reminder = reminder % factor;
        }   
        int position = getNthNumber(num);
        builder.append(position);
        serial[position] = true;
        for (int i = n; i >= 1; i--) {
            if (!serial[i])
                builder.append(i);
        }
        return builder.toString();
    }
    private int getNthNumber(int n) {
        int i = 1, count = 0;
        while (i < serial.length) {
            if (!serial[i]) {
                count++;
            }
            if (count == n) {
                break;
            }
            i++;
        }
        return i;
    }
}