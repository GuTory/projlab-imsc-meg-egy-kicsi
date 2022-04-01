package virologus;

import agens.Agens;
import agens.Kod;
import felszereles.Felszereles;
import skeleton.Skeleton;
import terkep.Mezo;
import util.Anyagok;
import util.Taska;

public class BenultViselkedes extends Viselkedes {
    public BenultViselkedes(Virologus gazda) {
        super(gazda);
        prior = ViselkedesPrior.benult_prior;
    }

    @Override
    public boolean taskaElvehetoE() {
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());
        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
        return true;
    }

    @Override
    public void mozog() {
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());
        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
        ;
    }

    @Override
    public Anyagok anyagLop(Virologus kitol) {
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());
        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
        return null;
    }

    @Override
    public Felszereles felszerelesLop(Virologus kitol) {
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());
        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
        return null;
    }

    @Override
    public Agens agensLop(Virologus kitol) {
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());
        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
        return null;
    }

    @Override
    public void ken(Virologus kit, Agens mivel) {
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());
        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Override
    public Agens agensEbbol(Kod kod, Taska taska) {
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());
        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
        return null;
    }

    @Override
    public void tamad(Virologus kit) {
        ;
    }

    @Override
    public String toString() {
        return "Benult ";
    }
}
