package virologus;

import agens.Agens;
import agens.Medvetanc;
import terkep.Mezo;

import java.util.List;
import java.util.Random;

public class MedvetancViselkedes extends Viselkedes{

    public MedvetancViselkedes(Virologus gazda) {
        super(gazda);
        prior = ViselkedesPrior.medvetanc_prior;
    }

    @Override
    public boolean mozog() {
        List<Mezo> szomszedok = gazda.getHely().getSzomszedok();
        Mezo uj = szomszedok.get(new Random().nextInt(szomszedok.size()));
        atleptet(uj);
        for (Virologus mezonAllo: uj.getVirologusok()) {
            ken(mezonAllo, new Agens(new Medvetanc()));
        }
        uj.tombol();
        return true;
    }

    @Override
    public boolean ken(Virologus kit, Agens mivel) {
        gazda.getTaska().agensKivesz(mivel);
        mivel.setTtl(2); //Csak 1-szer visszadobható (medve nem dob vissza)
        return kit.megkent(gazda, mivel);
    }
}
