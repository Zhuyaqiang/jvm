package chapter2;

import java.util.HashSet;
import java.util.Set;

/**
 * 运行时常量池溢出
 * VM Args: -Xmx6M
 */
public class RuntimeConstantPoolOOM {
    //    public static void main(String[] args) {
//        Set<String> set = new HashSet<>();
//        short i = 0;
//        while (true) {
//            set.add(String.valueOf(i++).intern());
//        }
//    }
    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("软件").toString(); // 计算机软件字符串首次出现, 所以返回的是同一个引用
        System.out.println(str1.intern() == str1);
        String str2 = new StringBuilder("ja").append("va").toString(); // java字符串在执行前就已经出现过, 字符串常量池已有引用, 因此返回的不是同一个引用
        System.out.println(str2.intern() == str2);
    }
}
