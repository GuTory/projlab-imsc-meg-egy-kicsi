package virologus;

import skeleton.Skeleton;
import terkep.Mezo;

import java.util.List;
import java.util.Random;

public class MedvetancViselkedes extends Viselkedes{

    public MedvetancViselkedes(Virologus gazda) {
        super(gazda);
        prior = Viselkedes_Prior.medvetanc_prior;
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
        uj.tombol();

        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
