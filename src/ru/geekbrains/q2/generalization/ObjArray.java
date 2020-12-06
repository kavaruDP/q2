package ru.geekbrains.q2.generalization;

import java.util.*;

public class ObjArray<T> {
        private T[] nums;

        public ObjArray(T... nums) {
            this.nums = nums;
        }

        public void printItem() {
            for (int i = 0; i < nums.length; i++) {
                System.out.println(nums[i]);
            }
        }

        public void swapArray (int a, int b) {
            T tmp;
            tmp = nums[a];
            nums[a] = nums[b];
            nums[b] = tmp;
        }

        public ArrayList<T> Array2ArrayList () {
            return new ArrayList<T>(Arrays.asList(nums));
        }
}
