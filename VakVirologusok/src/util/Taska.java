package util;

import agens.Agens;
import felszereles.Felszereles;
import jdk.jshell.spi.ExecutionControl;
import lombok.Getter;
import virologus.Virologus;

import java.util.List;

public class Taska {

    private int maxAnyagok;

    private Anyagok anyagok;

    @Getter
    private List<Agens> agensek;

    private Virologus virologus;

    @Getter
    private List<Felszereles> felszerelesek;


    public void felszerelesBerak(Felszereles felszereles) {

    }

    public void felszerelesKivesz(Felszereles felszereles) {

    }

    public void anyagBerak(Anyagok anyagok) {

    }

    public boolean anyagKivesz(Anyagok anyagok) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Nincs implementálva");
    }

    public void kapacitasNovel(int ertek) {

    }

    public boolean agensBerak(Agens agens) {
        return false;
    }

    public void agensKivesz(Agens agens) {

    }

    public void agensLep() {

    }


}
