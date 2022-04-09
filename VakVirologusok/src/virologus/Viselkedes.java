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
        prior = Viselkedes_Prior.sima_prior;
        this.gazda = gazda;
    }

    /**
     *  Ha a virológus ebben az állapotban van, nem lehet
     * elvenni tőle tárgyakat, ezért null-t ad vissza.
     * @return elvehető-e a táska
     */
    public boolean taskaElvehetoE() {
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());
        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
        return false;
    }

    /**
     * A virológus által kiválasztott mezőre lép.
     */
    public void mozog() {
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());

        List<Mezo> szomszedok = gazda.getHely().getSzomszedok();
        int ujID = Integer.parseInt(Skeleton.dontes("Hanyadik Mezo-t választod (csak a szám)? 0-" + (szomszedok.size()-1)));

        Mezo uj = szomszedok.get(ujID);

        String mezoTipus = Skeleton.dontes("Milyen típusú mező ez? (m: SIMA MEZO/l: labor/o: ovohely/r: raktar)");
        switch (mezoTipus) {
            case "l":
                Labor labor = new Labor();
                labor.setKod(new Benito(1, new Anyagok(1, 1), 1, 1));
                uj = labor;
                break;
            case "o":
                Ovohely ovohely = new Ovohely();
                Felszereles f;
                String mit = Skeleton.dontes("Mit veszel fel? (z: zsák/o: köpeny/e: kesztyű");
                switch (mit) {
                    case "o":
                        f = new Kopeny();
                        break;
                    case "z":
                        f = new Zsak();
                        break;
                    default:
                        f = new Kesztyu();
                        break;
                }
                ovohely.setFelszereles(f);
                uj = ovohely;
                break;
            case "r":
                Raktar raktar = new Raktar();
                raktar.setAnyagok(new Anyagok(1, 1));
                uj = raktar;
                break;
            default:
                uj = new Mezo();
                break;
        }

        gazda.getHely().virologusKi(gazda);
        uj.virologusBe(gazda);
        gazda.setHely(uj);
        uj.akcio(gazda);

        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    /**
     * Visszaadja az attribútumban szereplő virológustól
     * ellopható anyagokat.
     * @param kitol az a virológus akitől lopni akar
     * @return az ellopott anyag
     */
    public Anyagok anyagLop(Virologus kitol) {
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());

        Taska lopott_taska = kitol.taskaElvesz();
        Anyagok lopott_anyag = null;
        if (lopott_taska != null) {
            do {
                int n = Integer.parseInt(Skeleton.dontes("Mennyi nukleotidot veszel ki? (csak a szám)?"));
                int a = Integer.parseInt(Skeleton.dontes("Mennyi aminosavat veszel ki? (csak a szám)?"));
                lopott_anyag = new Anyagok(n, a);
            } while(!lopott_taska.anyagKivesz(lopott_anyag));
        }

        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());

        return lopott_anyag;
    }

    /**
     *
     * @param kitol az a virológus akitől lopni akar
     * @return az ellopott felszerelés
     */
    public Felszereles felszerelesLop(Virologus kitol) {
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());

        Taska lopott_taska = kitol.taskaElvesz();
        List<Felszereles> felszerelesek = null;
        if (lopott_taska != null) {
            felszerelesek = lopott_taska.getFelszerelesek();
        }
        Felszereles lopott = null;
        if (felszerelesek != null) {
            int ID = Integer.parseInt(Skeleton.dontes("Melyik Felszereles-t választod (csak a szám)? 0-" + (felszerelesek.size()-1)));
            lopott = felszerelesek.get(ID);
        }

        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());

        return lopott;
    }

    /**
     *
     * @param kitol az a virológus akitől lopni akar
     * @return az ellopott ágens
     */
    public Agens agensLop(Virologus kitol) {
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());

        Taska lopott_taska = kitol.taskaElvesz();
        List<Agens> agensek = null;
        if (lopott_taska != null) {
            agensek = lopott_taska.getAgensek();
        }
        Agens lopott = null;
        if (agensek != null) {
            int ID = Integer.parseInt(Skeleton.dontes("Melyik Agens-t választod (csak a szám)? 0-" + (agensek.size()-1)));
            lopott = agensek.get(ID);
        }

        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());

        return lopott;
    }

    /**
     * A virológus meg tud kenni valakit, aki egy mezőn áll vele.
     * @param kit a megkent virológus
     * @param mivel a virológusra kent ágens
     */
    public void ken(Virologus kit, Agens mivel) {
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());

        mivel.setTtl(3);
        kit.megkent(gazda, mivel);

        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    /**
     * Létrehoz egy ágenst, majd visszaadja azt.
     * @param kod a kód ami alapján az ágenst létre akarja hozni
     * @return a létrehozott ágens
     */
    public Agens agensEbbol(Kod kod, Taska taska) {
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());

        Agens uj = kod.agensLetrehoz(taska);

        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());

        return uj;
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

}
