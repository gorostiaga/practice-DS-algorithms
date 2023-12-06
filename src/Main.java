import java.util.*;
import com.trie.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(reverser("Helloworld!"));
        System.out.println("MIERDAAAAAAAAAAAAAAAAAAAAAAAAAAa");

        System.out.println(firstRecurringCharacter(new Integer[]{2, 5, 1, 2, 3, 5, 1, 2, 4}));
        System.out.println(firstRecurringCharacter(new Integer[]{2,1,1,2,3,5,1,2,4}));
        System.out.println(firstRecurringCharacter(new Integer[]{2,3,4,5}));
        System.out.println("--------------------------------");
        BinarySearchTree bts = new BinarySearchTree(9);
        bts.insert(12);
        bts.insert(4);
        bts.insert(8);
        bts.insert(6);
        bts.insert(14);
        bts.insert(5);
        System.out.println("--------------------------------");
        System.out.println(factorial(10));
        System.out.println("--------------------------------");
        for(Integer i : fibonacci(5)) {
            System.out.println(i);
        }
        System.out.println("--------------------------------");
        String[] strs = {"flower","flower","flower","flower"};
        String pepe = Solution.longestCommonPrefix(strs);


    }


    private static String reverser(String str) {
        char[] array = str.toCharArray();
        char[] ra = new char[array.length];
        for (int i =0; i<array.length ; i++){
            ra[i] = array[array.length-1-i];
        }
        return new String(ra);
    }

    private static Integer firstRecurringCharacter(Integer[] input){
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < input.length; i++){
            if(map.get(input[i]) != null) return input[i];
            else map.put(input[i], true);
        }
        return null;
    }

    private static Integer factorial(Integer number){
        int next = number -1 ;
        if (next == 0) return number;
        return number * factorial(next);
    }

    private static Integer[] fibonacci(Integer number){
        Integer[] array = new Integer[number+1];
        int index = 0;
        while (index <= number){
            array[index] = lateralus(index);
            index++;
        }
       return array;
    }
    private static Integer lateralus (Integer index) {
        if(index == 0) return 0;
        if(index == 1) return 1;
        return lateralus(index -1 ) + lateralus(index -2);
    }

    private static List<Character> reverser(Stack<Character> s, List<Character> l){
        if(s.size() != 0){
            char last = s.pop();
            l.add(last);
            reverser(s, l);
        }
        return l;
    }

}