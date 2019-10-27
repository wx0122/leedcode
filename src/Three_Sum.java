// 15. https://leetcode.com/problems/3sum/
//input:  int[] arr
//output: ArrayList<ArrayList<Integer>>

import java.util.ArrayList;
import java.util.List;

public class Three_Sum {
    // method 1: brute force
    public List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        Set<List<Integer>> set = new HashSet<List<Integer>>();

        if (nums.length < 3) {
            return ret;
        }

        Arrays.sort(nums);

        // brute force
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == target) {
                        List<Integer> arr = new ArrayList<Integer>();
                        arr.add(nums[i]);
                        arr.add(nums[j]);
                        arr.add(nums[k]);

                        if (!set.contains(arr)) {
                            set.add(arr);
                            ret.add(arr);                            
                        }
                    }
                }
            }
        }
        return ret;
    }

    // method 2: two pointers
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == -nums[i]) {
                    List<Integer> arr = new ArrayList<Integer>();
                    arr.add(nums[i]);
                    arr.add(nums[left]);
                    arr.add(nums[right]);
                    if (!set.contains(arr)) {
                        set.add(arr);
                        ret.add(arr);
                    }
                    left++;
                    right--;
                } else if (nums[left] + nums[right] > -nums[i]) {
                    right --;
                } else {
                    left++;
                }
            }
        }
        return ret;
    }


    // method 3: two pointers improvement
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (nums.length < 3) {
            return ret;
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1, right = nums.length - 1;

            while (left < right) {
                if (nums[left] + nums[right] == -nums[i]) {
                    if (left != i+1 && nums[left] == nums[left-1]) {
                        continue;
                    }

                    List<Integer> arr = new ArrayList<Integer>();
                    arr.add(nums[i]);
                    arr.add(nums[left]);
                    arr.add(nums[right]);
                    
                    ret.add(arr);
                    
                    left++;
                    right--;
                } else if (nums[left] + nums[right] > -nums[i]) {
                    right --;
                } else {
                    left++;
                }
            }
        }
        return ret;
    }

}
