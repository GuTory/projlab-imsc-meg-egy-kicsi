package virologus;

import skeleton.Skeleton;
import terkep.Mezo;

import java.util.List;
import java.util.Random;

public class VitustancViselkedes extends Viselkedes{

    public VitustancViselkedes(Virologus gazda) {
        super(gazda);
        prior = Viselkedes_Prior.vitustanc_prior;
    }

    @Override
    public void mozog() {
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());

        List<Mezo> szomszedok = gazda.getHely().getSzomszedok();
        Mezo uj = szomszedok.get(new Random().nextInt(szomszedok.size()));
        gazda.getHely().virologusKi(gazda);
        uj.virologusBe(gazda);
        gazda.setHely(uj);
        uj.akcio(gazda);

        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Override
    public String toString() {
        return "Vitustanc ";
    }
}
