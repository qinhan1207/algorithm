package class04;

import java.util.LinkedList;

public class Code01_SlidingWindowMaxArray {

    public static class WindowMax {
        private int L;
        private int R;
        private int[] arr;
        private LinkedList<Integer> qmax;

        public WindowMax(int[] a) {
            arr = a;
            L = -1;
            R = 0;
            qmax = new LinkedList<>();
        }
    }

    /**
     * 双端队列用LinkedList实现
     * offer加入 poll删除 peek查看 First头部 Last尾部
     *
     * @param arr
     * @param w
     * @return
     */

    public static int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }

        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                qmax.pollLast();
            }
            qmax.offerLast(i);
            if (qmax.peekFirst() == i - w) {    // i-w 过期的下标
                qmax.pollFirst();
            }
            if (i >= w - 1) {
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }
}
