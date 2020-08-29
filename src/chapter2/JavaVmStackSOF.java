package chapter2;

/**
 * 虚拟机栈和本地方法栈溢出
 * 线程请求的栈深度大于虚拟机所允许的最大深度
 * VM Args: -Xss128k
 * 设置每个线程的堆栈大小
 */
public class JavaVmStackSOF {
    private int stackLength = 1;
    public void stackLeak() {
        stackLength ++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVmStackSOF oom = new JavaVmStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length: " + oom.stackLength);
            throw e;
        }
    }
}
