package terkep;

import agens.Agens;
import agens.Medvetanc;
import virologus.Virologus;

public class FertozoLabor extends Labor{
    private Agens medvevirus;

    public FertozoLabor() {
        this.medvevirus = new Agens(new Medvetanc());
    }

    @Override
    public void akcio(Virologus virologus) {
        virologus.megkent(null, medvevirus);
    }
}
