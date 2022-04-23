package virologus;

import agens.Agens;
import agens.Kod;
import felszereles.Felszereles;
import util.Anyagok;
import util.Taska;

public class BenultViselkedes extends Viselkedes {
    public BenultViselkedes(Virologus gazda) {
        super(gazda);
        prior = ViselkedesPrior.benult_prior;
    }

    @Override
    public boolean taskaElvehetoE() {
        return true;
    }

    @Override
    public boolean mozog() {
        return false;
    }

    @Override
    public Anyagok anyagLop(Virologus kitol) {
         return null;
    }

    @Override
    public Felszereles felszerelesLop(Virologus kitol) {
         return null;
    }

    @Override
    public Agens agensLop(Virologus kitol) {
         return null;
    }

    @Override
    public boolean ken(Virologus kit, Agens mivel) {
        return false;
     }

    @Override
    public Agens agensEbbol(Kod kod, Taska taska) {
         return null;
    }

    @Override
    public boolean tamad(Virologus kit) {
        return false;
    }

    @Override
    public String toString(){
        return "benult";
    }
}
