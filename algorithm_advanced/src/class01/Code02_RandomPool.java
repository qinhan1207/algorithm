package class01;

import java.util.*;

public class Code02_RandomPool {

    class RandomizedSet {
        private List<Integer> nums; // 存储元素值
        private Map<Integer, Integer> valToIndex; // 值到索引的映射
        private Random random;  // 用于生成随机数

        public RandomizedSet() {
            nums = new ArrayList<>();
            valToIndex = new HashMap<>();
            random = new Random();
        }

        public boolean insert(int val) {
            if (valToIndex.containsKey(val)) {
                return false;
            }
            valToIndex.put(val, nums.size());
            nums.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!valToIndex.containsKey(val)){
                return false;
            }

            int index = valToIndex.get(val); // 要删除元素的索引
            int lastVal = nums.get(nums.size()-1); // 获得数组中的最后一个元素

            if (val==lastVal){
                // 如果要删除的是最后一个元素，直接删除
                valToIndex.remove(val);
                nums.remove(nums.size()-1);
            } else {
                // 将要删除的的元素与最后一个元素交换位置
                nums.set(index,lastVal);
                valToIndex.put(lastVal,index);

                // 删除最后一个元素
                nums.remove(nums.size()-1);
                valToIndex.remove(val);
            }
            return true;

        }

        public int getRandom() {
            int randomIndex = random.nextInt(nums.size());
            return nums.get(randomIndex);
        }
    }

    public static void main(String[] args) {
        System.out.println("11");
    }

}
