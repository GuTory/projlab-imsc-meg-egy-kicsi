package virologus;

import agens.Agens;
import agens.Benito;
import agens.Kod;
import felszereles.*;
import lombok.Getter;
import skeleton.Skeleton;
import terkep.Labor;
import terkep.Mezo;
import terkep.Ovohely;
import terkep.Raktar;
import util.Anyagok;
import util.Taska;

import java.util.List;

/**
 * A virológus cselekményeit korlátozó állapotok ősosztálya. Ebben az állapotban nincs semmilyen korlátozás a cselekményre.
 */
public class Viselkedes {
    /**
     * A viselkedés erőssége. A nagyobb prioritású viselkedés felülírja a kisebb
     * prioritásút.
     */
    @Getter
    protected int prior;

    protected Virologus gazda;

    public Viselkedes(Virologus gazda) {
        prior = ViselkedesPrior.sima_prior;
        this.gazda = gazda;
    }

    /**
     *  Ha a virológus ebben az állapotban van, nem lehet
     * elvenni tőle tárgyakat, ezért null-t ad vissza.
     * @return elvehető-e a táska
     */
    public boolean taskaElvehetoE() {
        return false;
    }

    /**
     * A virológus által kiválasztott mezőre lép.
     */
    public void mozog() {
 
        List<Mezo> szomszedok = gazda.getHely().getSzomszedok();

        int ujID = 0; //TODO: hogyan választasz új mezőt

        Mezo uj = szomszedok.get(ujID);

        atleptet(uj);
     }

    /**
     * Visszaadja az attribútumban szereplő virológustól
     * ellopható anyagokat.
     * @param kitol az a virológus akitől lopni akar
     * @return az ellopott anyag
     */
    public Anyagok anyagLop(Virologus kitol) {
 
        Taska lopott_taska = kitol.taskaElvesz();
        Anyagok lopott_anyag = null;
        //TODO: mennyit vesz ki

 
        return lopott_anyag;
    }

    /**
     *
     * @param kitol az a virológus akitől lopni akar
     * @return az ellopott felszerelés
     */
    public Felszereles felszerelesLop(Virologus kitol) {
 
        Taska lopott_taska = kitol.taskaElvesz();
        List<Felszereles> felszerelesek = null;
        if (lopott_taska != null) {
            felszerelesek = lopott_taska.getFelszerelesek();
        }
        Felszereles lopott = null;
        if (felszerelesek != null) {
            int ID = 0; //TODO: melyiket veszi ki
            lopott = felszerelesek.get(ID);
        }

        return lopott;
    }

    /**
     *
     * @param kitol az a virológus akitől lopni akar
     * @return az ellopott ágens
     */
    public Agens agensLop(Virologus kitol) {
 
        Taska lopott_taska = kitol.taskaElvesz();
        List<Agens> agensek = null;
        if (lopott_taska != null) {
            agensek = lopott_taska.getAgensek();
        }
        Agens lopott = null;
        if (agensek != null) {
            int ID = 0; //TODO: melyiket veszi ki
            lopott = agensek.get(ID);
        }

        return lopott;
    }

    /**
     * A virológus meg tud kenni valakit, aki egy mezőn áll vele.
     * @param kit a megkent virológus
     * @param mivel a virológusra kent ágens
     */
    public void ken(Virologus kit, Agens mivel) {
 
        //TODO: vegye ki a táskából az ágenst amivel megkeni.
        mivel.setTtl(3);
        kit.megkent(gazda, mivel);

     }

    /**
     * Létrehoz egy ágenst, majd visszaadja azt.
     * @param kod a kód ami alapján az ágenst létre akarja hozni
     * @return a létrehozott ágens
     */
    public Agens agensEbbol(Kod kod, Taska taska) {
        return kod.agensLetrehoz(taska);
    }

    public void tamad(Virologus kit) {
        //megkeressük a baltát a virológus táskájában
        Felszereles balta = null;
        for (Felszereles f : gazda.getTaska().getFelszerelesek()) {
            if (f.getID() == Felszereles_ID.balta_ID) {
                balta = f;
            }
        }
        if (balta == null) return;  //nem volt balta, nem lehet támadni
        //volt balta, megöli a virológust és csorbult baltára cseréli a baltát
        kit.meghal();
        balta.le(gazda, gazda.getTaska());
        new CsorbultBalta().fel(gazda, gazda.getTaska());
    }

    final protected void atleptet(Mezo uj) {
        gazda.getHely().virologusKi(gazda);
        uj.virologusBe(gazda);
        gazda.setHely(uj);
        uj.akcio(gazda);
    }

}
