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
        super.akcio(virologus);
        virologus.megkent(null, medvevirus);
    }

    @Override
    public String toString(){
        return "FertozoLabor: " + TestNev;
    }
}
