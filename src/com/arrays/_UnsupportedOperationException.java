package com.arrays;

import java.util.Arrays;
import java.util.List;

public class _UnsupportedOperationException {

    public static void main(String[] args) {
      int[] nums = new int[]{1,2,3,4,5};
      String[] strings = new String[]{"1","2","3"};
      List<String> list = Arrays.asList(strings);

      list.add("5");  //UnsupportedOperationException
    }
}
