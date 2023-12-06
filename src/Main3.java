import java.util.*;

public class Main3 {
    public static void main(String[] args) {

        //int[] nums = {5,7,7,8,8,10};
//        int[] nums = {0,1,2,3,4,5,7,7,8,8,10};
//        System.out.println(System.currentTimeMillis());
//        int[] res = searchRange2(nums, 8);
//        System.out.println(System.currentTimeMillis());
//        Arrays.stream(res).forEach(e -> System.out.println(e +" "));
        String input = "xLeElzxgHzcWslEdgMGwEOZCXwwDMwcEhgJHLL";
        //String input = "YazaAay";
        System.out.println(System.currentTimeMillis());
        System.out.println(longestNiceSubstring(input));
        System.out.println(System.currentTimeMillis());
        //System.out.println(longestNiceSubstring2(input));
        System.out.println(System.currentTimeMillis());
        System.out.println(longestNiceSubstring4(input));
        System.out.println(System.currentTimeMillis());

    }

    public static String longestNiceSubstring(String s) {
        return pepe(s.substring(0, s.length()));

    }
    private static String pepe(String s){
        if(s.length()<2) return "";
        Set<Character> set = new HashSet<>();
        String subL = s, subR ="";
        for(char i : s.toCharArray()){
            set.add(i);
        }
        for(int i=0; i<s.length();i++){
            if(!set.contains(Character.toLowerCase(s.charAt(i))) || !set.contains(Character.toUpperCase(s.charAt(i)))){
                subL = pepe(s.substring(0,i));
                subR = pepe(s.substring(i+1, s.length()));
            }
        }
        return subL.length() >= subR.length() ? subL : subR;
    }

    public static String longestNiceSubstring2(String s) {
        var sub = longestNiceSubstring2(s, 0, s.length());
        return s.substring(sub[0], sub[1]);
    }

    private static int[] longestNiceSubstring2(String s, int left, int right) {
        var charSet = getCharSet(s, left, right);

        for (var i = left; i < right; i++)
            if (!charSet.contains(Character.toLowerCase(s.charAt(i)))
                    || !charSet.contains(Character.toUpperCase(s.charAt(i)))) {

                var prefix = longestNiceSubstring2(s, left, i);
                var suffix = longestNiceSubstring2(s, i + 1, right);
                return prefix[1] - prefix[0] >= suffix[1] - suffix[0]
                        ? prefix
                        : suffix;
            }

        return new int[]{left, right};
    }

    private static Set<Character> getCharSet(String s, int left, int right) {
        var charSet = new HashSet<Character>();

        for (var i = left; i < right; i++)
            charSet.add(s.charAt(i));

        return charSet;
    }

    public static String longestNiceSubstring3(String s) {
        return pepe(s, 0, s.length());

    }
    private static String pepe(String s, int l, int r){
        // if(r-l+1<2) return "";
        Set<Character> set = new HashSet<>();
        String subL = "", subR ="";
        for(int i=l; i<r;i++){
            set.add(s.charAt(i));
        }
        for(int i=l; i<r;i++){
            if(!set.contains(Character.toLowerCase(s.charAt(i))) || !set.contains(Character.toUpperCase(s.charAt(i)))){
                subL = pepe(s, l, i);
                subR = pepe(s, l+1, r);
                return subL.length() >= subR.length() ? subL : subR;
            }

        }
        return s.substring(l,r);

    }

    public static String longestNiceSubstring4(String s) {
        return pepe2(s.substring(0, s.length()));

    }
    private static String pepe2(String s){
        if(s.length()<2) return "";
        Set<Character> set = new HashSet<>();
        String subL = "", subR ="";
        for(char i : s.toCharArray()){
            set.add(i);
        }
        for(int i=0; i<s.length();i++){
            if(!set.contains(Character.toLowerCase(s.charAt(i))) || !set.contains(Character.toUpperCase(s.charAt(i)))){
                subL = pepe2(s.substring(0,i));
                subR = pepe2(s.substring(i+1, s.length()));
                return subL.length() >= subR.length() ? subL : subR;
            }


        }
        return s;
    }


/////////////////////////////////////////////////////////////

    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        return result;
    }

    private static int findFirst(int[] nums, int target){
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] >= target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
            if(nums[mid] == target) idx = mid;
        }
        return idx;
    }

    private static int findLast(int[] nums, int target){
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] <= target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
            if(nums[mid] == target) idx = mid;
        }
        return idx;
    }

    public static int[] searchRange2 (int[] nums, int target){
        int i=0, j=nums.length-1;
        int[] res = new int[2];
        while(i<j){
            int mid = (i+j)/2;
            if(nums[mid]<target) i=mid+1;
            else j=mid;
        }
        if(nums[i] != target) return res;
        else res[0] = i;

        j = nums.length -1;
        while(i<j){
            int mid = (i+j)/2 +1;
            if(nums[mid] >target) j=mid-1;
            else i =mid;
        }
        res[1] = j;
        return res;
    }

    public static int[] mySearchRange(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int[] res = {-1, -1};
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;

            } else if (nums[mid] > target) {
                r = mid - 1;

            } else {
                if (nums[mid + 1] == target) {
                    res[0] = mid;
                    res[1] = mid + 1;

                }
                if (nums[mid - 1] == target) {
                    res[0] = mid - 1;
                    res[1] = mid;

                }

            }
        }
        return res;
    }

    }
