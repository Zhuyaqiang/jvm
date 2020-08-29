package chapter4;


public class JHSDB_TestCase {
    /**
     * VM Option: -Xmx10m -XX:+UseSerialGC -XX:-UseCompressedOops
     *
     * Windows-console命令: scanoops 0x00007fc88fc00000 0x00007fc88feb0000 chapter4.JHSDB_TestCase$ObjectHolder
     */
    static class Test {
        static ObjectHolder staticObj = new ObjectHolder();  // 方法区
        ObjectHolder instanceObj = new ObjectHolder();  // java堆
        void foo() {
            ObjectHolder localObj = new ObjectHolder(); // 局部变量表
            System.out.println("done");
        }
    }
    private static class ObjectHolder{}
    public static void main(String[] args) {
        Test test = new JHSDB_TestCase.Test();
        test.foo();
    }
}
