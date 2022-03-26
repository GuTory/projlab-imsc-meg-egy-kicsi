import agens.Agens;
import agens.Benito;
import agens.Kod;
import agens.Vitustanc;
import util.Anyagok;
import virologus.Virologus;

public class Program {

    public static void main(String[] args) {
        testAgensEbbol();
        testKen();
    }

    private static void testAgensEbbol() {
        Virologus v1 = new Virologus();
        Kod k = new Vitustanc(1, new Anyagok(1,1), 1, 1);
        v1.agensEbbol(k);
    }

    private static void testKen() {
        Virologus v1 = new Virologus();
        Virologus v2 = new Virologus();
        Kod k = new Benito(1, new Anyagok(1,1), 1, 1);
        v1.ken(v1, v2, new Agens(k));
    }
}
