import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution752 {
    public int openLock(String[] deadends, String target) {
        
        Set<String> dead = new HashSet<String>(Arrays.asList(deadends));

        Set<String> qBegin = new HashSet<>();
        Set<String> qEnd = new HashSet<>();
        
        qBegin.add("0000");
        qEnd.add(target);

        int level = 0;
        //两者都为非空才有机会，如果空了说明无路可走了
        while (!qBegin.isEmpty() && !qEnd.isEmpty()) {
            
            //始终保证qBegin是比较短的那个队列
            if (qBegin.size() > qEnd.size()) {
                Set<String> tmp = qBegin;
                qBegin = qEnd;
                qEnd = tmp;
            }
            
            Set<String> tmp = new HashSet<String>();

            for (String pre : qBegin) {
                 //判断两个队列是否有重合部分
                if (qEnd.contains(pre)) {
                    return level;
                }

                if (dead.contains(pre)) {
                    continue;
                }
                //这一格已经走过了，下次不用重新走了
                dead.add(pre);

                for (int j = 0; j < pre.length(); j++) {
                    int n = pre.charAt(j) - '0';
                    String s1 = pre.substring(0, j) + String.valueOf((n+10+1)%10) + pre.substring(j+1);
                    if (!dead.contains(s1)) {
                        tmp.add(s1);
                    }
                    String s2 = pre.substring(0, j) + String.valueOf((n+10-1)%10) + pre.substring(j+1);
                    if (!dead.contains(s2)) {
                        tmp.add(s2);
                    }
                }
            }
            qBegin = tmp;

            level++;
        }

        return -1;
    }
}