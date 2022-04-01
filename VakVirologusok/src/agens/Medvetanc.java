package agens;

import skeleton.Skeleton;
import util.Anyagok;
import util.Taska;
import virologus.MedvetancViselkedes;
import virologus.Virologus;

public class Medvetanc extends Kod{

    public Medvetanc() {
        super(-1, null, 1, -1);
    }

    @Override
    public Agens agensLetrehoz(Taska taska) {
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());

        if(this.koltsegLevon(taska)) {
            Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
            return new Agens(this);
        }
        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
        return null;
    }

    @Override
    public void hatas(Virologus virologus) {
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());

        virologus.addViselkedes(elettartam, new MedvetancViselkedes(virologus));

        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
