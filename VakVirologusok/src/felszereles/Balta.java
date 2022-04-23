package felszereles;

import util.Taska;
import virologus.Virologus;

public class Balta extends Felszereles{
    @Override
    public void fel(Virologus virologus, Taska taska) {
        taska.felszerelesBerak(this);
    }

    @Override
    public void le(Virologus virologus, Taska taska) {
        taska.felszerelesKivesz(this);
    }

    @Override
    public int getID() {
        return Felszereles_ID.balta_ID;
    }

    @Override
    public String toString(){
        return "balta";
    }
}
