package com.op;

import java.util.*;
import java.util.stream.Collectors;

public class Solutions {

    public static void main(String[] args) {

    }

    private static void printer(String[] a, String[] b){
        //turn the arrays to lists
        List<String> listA = Arrays.stream(a).collect(Collectors.toList());
        List<String> listB = Arrays.stream(b).collect(Collectors.toList());

        Collections.shuffle(listA);
        Collections.shuffle(listB);

        Deque<String> dqA = listA.stream().collect(Collectors.toCollection(ArrayDeque::new));
        Deque<String> dqB = listB.stream().collect(Collectors.toCollection(ArrayDeque::new));

        Map<String, List<String>> map = new HashMap<>();

        while(dqB.size() > 0){
            List<String> tempReceiver = new ArrayList<>();
            String donator;
            String receiver;
          if(dqA.size() > 0){
              if(dqA.peek() != dqB.peek()){
                   donator = dqA.poll();
                   receiver = dqB.poll();
              } else {
                  donator = dqA.poll();
                  receiver = dqB.pollLast();
              }

              tempReceiver.add(receiver);
              map.put(donator, tempReceiver);
          }
          else {
              if(a[0] != dqB.peek()){
                  map.get(a[0]).add(dqB.poll());
              } else {
                  map.get(a[0]).add(dqB.pollLast());
              }
          }
        }

        for(var i : map.entrySet()){

        }
    }

}
