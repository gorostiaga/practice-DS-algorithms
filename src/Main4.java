import com.backtracking.Queens;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Main4 {
    public static void main(String[] args) {
        //Queens q = new Queens();
        //q.solveNQueens(4);
        int[] ar = new int[]{100,4,200,1,3,2};
        //longestConsecutive(ar);
        Date pepe = new Date();
        System.out.println("Hora: "+ pepe);

    }
    public static int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for(int i : nums) set.add(i);
        int ans = 0;
        for(int num : nums) {
            int left = num - 1;
            int right = num + 1;
            while(set.remove(left)) left--;
            while(set.remove(right)) right++;
            ans = Math.max(ans,right - left - 1);
            if(set.isEmpty()) return ans;//save time if there are items in nums, but no item in hashset.
        }
        return ans;
    }
}
