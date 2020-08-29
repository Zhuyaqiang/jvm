package chapter3;

public class EdenAllocation {
    private static final int _1MB = 1024 * 1024;
    /**
     * VM
     * 参数: -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -verbose:gc  -XX:+UseSerialGC
     *   限制Java堆大小为20MB, 10M给新生代, 10M给老年代, 打印内存回收日志以及各区域分配情况, Eden:Survivor = 8:1
     */
    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];
    }

    /**
     * VM
     * 参数: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseSerialGC
     *      -XX:PretenureSizeThreshold=3145728
     */
    public static void testPretenureSizeThreshold() {
        byte[] allocation;
        allocation = new byte[4 * _1MB];
    }

    /**
     * 动态对象年龄判定
     * VM参数: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseSerialGC
     * -XX:MaxTenuringThreshold=15   -XX:+PrintTenuringDistribution
     */
    public static void testTenuringThreshold2() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[_1MB / 4];
        allocation2 = new byte[_1MB / 4];
        allocation3 = new byte[_1MB * 4];
        allocation4 = new byte[_1MB * 4];

        allocation4 = null;
        allocation4 = new byte[_1MB * 4];
    }

    public static void main(String[] args) {
        testTenuringThreshold2();
    }
}
