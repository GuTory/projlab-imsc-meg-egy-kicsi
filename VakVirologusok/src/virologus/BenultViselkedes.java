package virologus;

import agens.Agens;
import agens.Kod;
import felszereles.Felszereles;
import jdk.jshell.spi.ExecutionControl;
import util.Anyagok;

public class BenultViselkedes extends Viselkedes {
    public BenultViselkedes() {
        super.prior = 0;
    }

    @Override
    public boolean taskaElvehetoE() throws ExecutionControl.NotImplementedException {
        return super.taskaElvehetoE();
    }

    @Override
    public void mozog() throws ExecutionControl.NotImplementedException {
        super.mozog();
    }

    @Override
    public Anyagok anyagLop(Virologus kitol) throws ExecutionControl.NotImplementedException {
        return super.anyagLop(kitol);
    }

    @Override
    public Felszereles felszerelesLop(Virologus kitol) throws ExecutionControl.NotImplementedException {
        return super.felszerelesLop(kitol);
    }

    @Override
    public Agens agensLop(Virologus kitol) throws ExecutionControl.NotImplementedException {
        return super.agensLop(kitol);
    }

    @Override
    public void ken(Virologus ki, Virologus kit, Agens mivel) throws ExecutionControl.NotImplementedException {
        super.ken(ki, kit, mivel);
    }

    @Override
    public Agens agensEbbol(Kod kod) throws ExecutionControl.NotImplementedException {
        return super.agensEbbol(kod);
    }
}
