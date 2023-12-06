import java.util.*;

public class Main2 {
    public static void main(String[] args) {

        //String[] input = {"683339452288515879","7846081062003424420","4805719838","4840666580043","83598933472122816064","522940572025909479","615832818268861533","65439878015","499305616484085","97704358112880133","23861207501102","919346676","60618091901581","5914766072","426842450882100996","914353682223943129","97","241413975523149135","8594929955620533","55257775478129","528","5110809","7930848872563942788","758","4","38272299275037314530","9567700","28449892665","2846386557790827231","53222591365177739","703029","3280920242869904137","87236929298425799136","3103886291279"};

        //String s = kthLargestNumber(input, 3);
        //String s = "ADOBECODEBANC", t = "ABC";
        // String string = minWindow(s ,t);

        //System.out.println(fibonacciDP(7));

        //System.out.println(fiboDP(4));
        //topKElements();
        int [] input = {-28,81,-20,28,-29};
        System.out.println(shortestSubarray(input, 89));

    }

    public static int shortestSubarray(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int cache = 0;

        return subTrav(cache, dq, nums, 0, k, min);
        //return subTrav(cache, dq, nums, 0, k);

    }

    private static int subTrav(int cache, ArrayDeque<Integer> deque, int[] numsArray, int index, int value, int min){
    //private static int subTrav(int cache, ArrayDeque<Integer> deque, int[] numsArray, int index, int value){
        int l=0, r=index;
        for (int i=0; i<= r; i++){
            deque.add(numsArray[i]);
        }

        cache += numsArray[r];

        while(l<=r){
            int sum = 0;
//            for(int i : deque){
//               sum += i;
//            }
            if (cache < value){
                cache -= numsArray[l];
                l++;
                deque.poll();

            } else {
               //int min = Math.min(min , r-l+1);
                min = Math.min(min , r-l+1);
                cache -= numsArray[l];
                l++;
                deque.poll();
            }
        }
        //I cannot return a variable that is also a property, like this example, when r=2 is decreasing at the moment of returning the value min is overriden.
        //solution u gotta assign the result to the mentioned variable, in this example. min = subTrav.
        if(r< numsArray.length-1) min = subTrav(cache, deque, numsArray, r+1, value, min);
        if(min == Integer.MAX_VALUE) return -1;
        else return min;
    }

    ////////////////////

    public static String kthLargestNumber(String[] nums, int k) {
        double[] ints = new double[nums.length];
        for(int i = 0; i<nums.length; i++)  {
            ints[i] = Double.valueOf(nums[i]);
        }
        Arrays.sort(ints);
        System.out.println(Arrays.toString(ints));

        return String.format("%.0f",ints[nums.length-k]);

    }

    public static String minWindow(String s, String t) {

        Map<Character, Integer> tMap = new HashMap<>();
        List<Character> result = new ArrayList<>();
        String ans = "";


        for (char i : t.toCharArray()){
            tMap.put(i, tMap.getOrDefault(i, 0)+1);
        }

        char[] sArray = s.toCharArray();

        int r=0, l=0, min= Integer.MAX_VALUE, counter=0;

        while(r < sArray.length){
            tMap.put(sArray[r], tMap.getOrDefault(sArray[r], 0)-1);
            if(tMap.get(sArray[r]) >= 0) {
                result.add(sArray[r]);

                counter++; }

            while(counter == t.length()){
                //min = Math.min(min, r-l+1);
                if(r-l+1 < min){
                    min = r-l+1;
                    ans = s.substring(l, l+1);
                }
                tMap.put(sArray[l], tMap.get(sArray[l]) +1);
                if(tMap.get(sArray[l]) > 0) counter--;
                //result.remove(0);
                l++;
            }

            r++;
        }
        //StringBuilder st = new StringBuilder();
        //for (char i : result)  st.append(i);
        return ans;

    }

    public static int fibonacciDP(int n){
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i=0 ; i<=n;i++){
            if(cache.containsKey(i)){
                return cache.get(i);
            } else {
                if(i<2) cache.put(i,i);
                else cache.put(i, cache.get(i-1) + cache.get(i-2));
            }
        }
        return cache.get(n);
    }

    static  Map<Integer, Integer> globalCache = new HashMap<>();
    public static int fiboDP(int n){
        if(globalCache.containsKey(n)){
            return globalCache.get(n);
        } else {
            if(n<2) return n;
            else{
                globalCache.put(n, fiboDP(n-1)+fiboDP(n-2));
                return globalCache.get(n);
            }
        }


    }

    static void topKElements(){
        Integer[] nums = {5, 2, 8, 1, 4};

        // Sort the array in descending order
        Arrays.sort(nums, Comparator.reverseOrder());

        // Print the sorted array
        System.out.println("Sorted Array in Descending Order:");
        for (int num : nums) {
            System.out.print(num + " ");
        }
//        if(z != 0){
//
//        } else if () {
//
//        }else {
//
//        }
    }
}

//class Compa implements Comparator<Map.Entry<String,Integer>> {
//
//    public int compare(Map.Entry<String,Integer> map1, Map.Entry<String,Integer> map2) {
//        if(map1.getValue() != map2.getValue()){
//            return map2.getValue() - map1.getValue();
//        } else if(map1.getKey().charAt(0) != map2.getKey().charAt(0)) {
//            return map1.getKey().charAt(0) - map2.getKey().charAt(0); }
//    } else {
//        return map1.getKey().length() - map2.getKey().length();}
//
//
//}
