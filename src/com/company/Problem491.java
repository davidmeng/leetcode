package com.company;


import java.util.*;

public class Problem491 {
    public List<List<Integer>> findSubsequences(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        findSubsequences(nums, 0, new ArrayList<>(), result, new HashSet<>());
        return result;
    }

    private void findSubsequences(int[] nums, int index, List<Integer> list, List<List<Integer>> result, Set<String> set) {

        if (nums.length == index) {
            if (list.size() > 1) {
                String key = getKey(list);
                if (!set.contains(key)) {
                    set.add(key);
                    List<Integer> r = new ArrayList<>();
                    r.addAll(list);
                    result.add(r);
                }
            }
            return;
        }


        findSubsequences(nums, index+1, list, result, set);

        if (list.size() == 0 || list.get(list.size() - 1) <= nums[index]) {
            list.add(nums[index]);
        }
        findSubsequences(nums, index+1, list, result, set);
        if (list.size()>0) {
            list.remove(list.size() - 1);
        }
    }

    private String getKey(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (Integer i : list) {
            sb.append(i).append("_");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Problem491 p = new Problem491();
        List<List<Integer>> result = p.findSubsequences(new int[]{1,2,3,4,5,6,7,8,9,10,1,1,1,1,1});
        for (List<Integer> list : result) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
