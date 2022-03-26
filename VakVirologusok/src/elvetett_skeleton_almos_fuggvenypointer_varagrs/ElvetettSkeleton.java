package elvetett_skeleton_almos_fuggvenypointer_varagrs;

public class ElvetettSkeleton {
    static int tab = 0;

    public Object functionCaller(ProjExecutable toExecute, String functionName) {
        for (int i = 0; i < tab; i++) {
            System.out.print("\t");
        }
        System.out.println(functionName + " start");

        tab++;


        Object ret = toExecute.execute();

        for (int i = 0; i < tab; i++) {
            System.out.print("\t");
        }
        System.out.println("return: " + ret);

        tab--;

        for (int i = 0; i < tab; i++) {
            System.out.print("\t");
        }
        System.out.println(functionName + " end");

        return  ret;
    }

    public Object functionCaller(ProjExecutableParams toExecute, String functionName) {
        for (int i = 0; i < tab; i++) {
            System.out.print("\t");
        }
        System.out.println(functionName + " start");

        tab++;

        Object ret = toExecute.execute();

        for (int i = 0; i < tab; i++) {
            System.out.print("\t");
        }
        System.out.println("return: " + ret);

        tab--;

        for (int i = 0; i < tab; i++) {
            System.out.print("\t");
        }
        System.out.println(functionName + " end");

        return  ret;
    }

    public void functionCallerVoid(ProjExecutableVoid toExecute, String functionName) {
        for (int i = 0; i < tab; i++) {
            System.out.print("\t");
        }
        System.out.println(functionName + " start");

        tab++;


        toExecute.execute();

        for (int i = 0; i < tab; i++) {
            System.out.print("\t");
        }
        System.out.println("void");

        tab--;

        for (int i = 0; i < tab; i++) {
            System.out.print("\t");
        }
        System.out.println(functionName + " end");
    }

    public void functionCallerVoid(ProjExecutableVoidParams toExecute, String functionName) {
        for (int i = 0; i < tab; i++) {
            System.out.print("\t");
        }
        System.out.println(functionName + " start");

        tab++;


        toExecute.execute();

        for (int i = 0; i < tab; i++) {
            System.out.print("\t");
        }
        System.out.println("void");

        tab--;

        for (int i = 0; i < tab; i++) {
            System.out.print("\t");
        }
        System.out.println(functionName + " end");
    }
}
