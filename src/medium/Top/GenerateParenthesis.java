package medium.Top;

import java.util.ArrayList;
import java.util.List;

/*
* 22. 括号生成
* */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {

            /*
            //没看懂
            List<String> ans = new ArrayList();
            if (n == 0) {
                ans.add("");
            } else {
                for (int c = 0; c < n; ++c)
                    for (String left: generateParenthesis(c))
                        for (String right: generateParenthesis(n-1-c))
                            ans.add("(" + left + ")" + right);
            }
            return ans;*/

        List<String> list = new ArrayList<>();
        backTrack(list,"",0,0,n);
        return list;

    }

    public void backTrack(List<String> list,String cur,int left,int right,int count){
        if (cur.length() == count*2) {
            list.add(cur);
            return;
        }

        if (left < count)
            backTrack(list,cur+"(",left+1,right,count);

        if (right < left)
            backTrack(list,cur+")",left,right+1,count);
    }

    public static void main(String[] args) {
        new GenerateParenthesis().generateParenthesis(3);
    }
}
