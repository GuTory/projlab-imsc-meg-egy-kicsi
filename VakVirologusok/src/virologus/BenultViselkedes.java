package virologus;

import agens.Agens;
import agens.Kod;
import felszereles.Felszereles;
import jdk.jshell.spi.ExecutionControl;
import terkep.Mezo;
import util.Anyagok;
import util.Taska;

public class BenultViselkedes extends Viselkedes {
    public BenultViselkedes() {
        super.prior = 0;
    }

    @Override
    public boolean taskaElvehetoE() {
        return true;
    }

    @Override
    public void mozog(Virologus ki, Mezo hely) {
        ;
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
    public void ken(Virologus ki, Virologus kit, Agens mivel) {
        ;
    }

    @Override
    public Agens agensEbbol(Kod kod, Taska taska) {
        return null;
    }

    @Override
    public String toString() {
        return "Benult ";
    }
}
