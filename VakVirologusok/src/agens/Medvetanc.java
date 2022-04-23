package agens;

import util.Taska;
import virologus.MedvetancViselkedes;
import virologus.Virologus;

public class Medvetanc extends Kod{

    public Medvetanc() {
        super(-1, null, 1, -1);
    }

    @Override
    public Agens agensLetrehoz(Taska taska) {
        if(this.koltsegLevon(taska)) {
            return new Agens(this);
        }
        return null;
    }

    @Override
    public void hatas(Virologus virologus) {
        virologus.addViselkedes(elettartam, new MedvetancViselkedes(virologus));
    }

    @Override
    public String toString(){
        return "medvetanc";
    }
}
