package virologus;

import terkep.Mezo;

import java.util.List;
import java.util.Random;

public class VitustancViselkedes extends Viselkedes{
    public VitustancViselkedes() {
        super.prior = 1;
    }

    @Override
    public void mozog(Virologus ki, Mezo jelenlegi) {
        List<Mezo> szomszedok = jelenlegi.getSzomszedok();
        Mezo uj = szomszedok.get(new Random().nextInt(szomszedok.size()));
        jelenlegi.virologusKi(ki);
        uj.virologusbe(ki);
        ki.setHely(uj);
        uj.akcio(ki);
    }

    @Override
    public String toString() {
        return "Vitustanc ";
    }
}
