package virologus;

import skeleton.Skeleton;
import terkep.Mezo;

import java.util.List;
import java.util.Random;

public class VitustancViselkedes extends Viselkedes{
    public VitustancViselkedes() {
        super.prior = 1;
    }

    @Override
    public void mozog(Virologus ki, Mezo jelenlegi) {
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());

        List<Mezo> szomszedok = jelenlegi.getSzomszedok();
        Mezo uj = szomszedok.get(new Random().nextInt(szomszedok.size()));
        jelenlegi.virologusKi(ki);
        uj.virologusBe(ki);
        ki.setHely(uj);
        uj.akcio(ki);

        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Override
    public String toString() {
        return "Vitustanc ";
    }
}
