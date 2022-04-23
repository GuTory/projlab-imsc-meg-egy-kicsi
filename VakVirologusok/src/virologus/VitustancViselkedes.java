package virologus;

import terkep.Mezo;

import java.util.List;
import java.util.Random;

public class VitustancViselkedes extends Viselkedes{

    public VitustancViselkedes(Virologus gazda) {
        super(gazda);
        prior = ViselkedesPrior.vitustanc_prior;
    }

    @Override
    public boolean mozog() {
        List<Mezo> szomszedok = gazda.getHely().getSzomszedok();
        Mezo uj = szomszedok.get(new Random().nextInt(szomszedok.size()));
        atleptet(uj);
        return true;
    }

}
