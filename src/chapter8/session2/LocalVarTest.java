package chapter8.session2;

/**
 * 虚拟机参数 -verbose:gc
 */
public class LocalVarTest {
    public static void main(String[] args) {
        // 情况1 :不会回收placeholder所占的内存
//        byte[] placeholder = new byte[64 * 1024 * 1024];
//        System.gc();

        // 情况2: 不会回收placeholder所占的内存
//        {
//            byte[] placeholder = new byte[64 * 1024 * 1024];
//        }
//        System.gc();

        // 情况3: 会回收placeholder所占的内存
        {
            byte[] placeholder = new byte[64 * 1024 * 1024];
        }
        // 这个修改打断了GC Roots一部分局部变量表对placeholder的关联
        int a = 0;
        System.gc();
    }
}
