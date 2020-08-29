package chapter3;

/**
 * 1. 对象可以在被GC时自我拯救
 * 2. 这种自救机会只有一次, 因为一个对象的finalize()方法最多只会被系统自动调用一次
 */
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("alive");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws Throwable {
        SAVE_HOOK = new FinalizeEscapeGC();
        // 第一次自救
        SAVE_HOOK  = null;
        System.gc();
        // 因为Finalizer方法优先级很低, 暂停0.5s等待
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("dead");
        }


        SAVE_HOOK  = null;
        System.gc();
        // 因为Finalizer方法优先级很低, 暂停0.5s等待
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("dead");
        }
    }
}
