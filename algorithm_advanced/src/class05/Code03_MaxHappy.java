package class05;

import java.util.List;

public class Code03_MaxHappy {

    public static class Employee {
        public int happy;
        public List<Employee> nexts;
    }


    public static class Info {
        public int laiMaxHappy;
        public int buMaxHappy;

        public Info(int lai, int bu) {
            this.laiMaxHappy = lai;
            this.buMaxHappy = bu;
        }
    }

    public static Info process(Employee x) {
        if (x.nexts.isEmpty()) {  // x是最基层的员工
            return new Info(x.happy, 0);
        }

        int lai = x.happy;
        int bu = 0;

        for (Employee next : x.nexts){
            Info nextInfo = process(next);
            lai += nextInfo.buMaxHappy;
            bu += Math.max(nextInfo.laiMaxHappy, nextInfo.buMaxHappy);
        }
        return new Info(lai,bu);
    }

    public static int maxHappy(Employee boss){
        Info headInfo = process(boss);
        return Math.max(headInfo.laiMaxHappy, headInfo.buMaxHappy);
    }
}
