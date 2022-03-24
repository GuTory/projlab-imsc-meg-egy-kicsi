package virologus;

import agens.Agens;
import agens.Kod;
import felszereles.Felszereles;
import jdk.jshell.spi.ExecutionControl;
import lombok.Getter;
import terkep.Mezo;
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
    public void mozog(Virologus ki, Mezo jelenlegi) {
        List<Mezo> szomszedok = jelenlegi.getSzomszedok();
        Mezo uj = szomszedok.get(0); //TODO: döntés
        jelenlegi.virologusKi(ki);
        uj.virologusbe(ki);
        ki.setHely(uj);
        uj.akcio(ki);
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
        if (lopott_taska != null) {
            lopott_anyag = lopott_taska.anyagKivesz(null); //TODO mennyit vesz ki
        }
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
            lopott = felszerelesek.get(0); //TODO mit vesz ki
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
            lopott = agensek.get(0); //TODO mit vesz ki
        }
        return lopott;
    }

    /**
     * A virológus meg tud kenni valakit, aki egy mezőn áll vele.
     * @param ki a kenő virológus
     * @param kit a megkent virológus
     * @param mivel a virológusra kent ágens
     */
    public void ken(Virologus ki, Virologus kit, Agens mivel) {
        mivel.setTtl(2);
        kit.megkent(ki, mivel);
    }

    /**
     * Létrehoz egy ágenst, majd visszaadja azt.
     * @param kod a kód ami alapján az ágenst létre akarja hozni
     * @return a létrehozott ágens
     */
    public Agens agensEbbol(Kod kod, Taska taska) {
        return kod.agensLetrehoz(taska);
    }

    @Override
    public String toString() {
        return "Sima ";
    }
}
