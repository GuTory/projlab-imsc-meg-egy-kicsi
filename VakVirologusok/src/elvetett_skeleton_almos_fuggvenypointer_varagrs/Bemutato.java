package elvetett_skeleton_almos_fuggvenypointer_varagrs;


public class Bemutato {
    private static ElvetettSkeleton s = new ElvetettSkeleton();

    public static void elvetett_main(String[] args) {
        System.out.println(s.functionCaller(Bemutato::test1, "test1"));
    }

    public static Integer test1() {
        Integer ret = (Integer) s.functionCaller(func -> test2(), "test2");
        return ret + 2;
    }

    public static Integer test2() {
        s.functionCallerVoid(func -> test3("tesztParam", 12), "printelő szar");
        s.functionCallerVoid(func -> test4("tesztParam"), "printelő másik szar");
        return 1;
    }

    public static void test3(String s, int i) {
        System.out.println(s + " : " + i);
    }

    public static void test4(String s) {
        System.out.println(s + " : " + 69);
    }
}
