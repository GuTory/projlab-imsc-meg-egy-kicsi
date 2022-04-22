package virologus;

import agens.Agens;
import agens.Kod;
import felszereles.*;
import terkep.Mezo;
import test.TestIO;
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
    protected int prior;

    public int getPrior(){ return prior; }

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

        int ujID = Integer.parseInt(TestIO.input());

        Mezo uj = szomszedok.get(ujID % szomszedok.size());

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


        if (lopott_taska != null) {
            boolean lehetA = true;
            boolean lehetN = true;
            boolean ilyen = true;
            int n = 0;
            int a = 0;
            while ((lehetA || lehetN) && n + a < gazda.getTaska().szabadHely()) {
                if (ilyen) {
                    lehetN = lopott_taska.anyagKivesz(new Anyagok(1,0));
                    n++;
                }
                else  {
                    lehetA = lopott_taska.anyagKivesz(new Anyagok(0,1));
                    a++;
                }
                ilyen = !ilyen;
            }
            lopott_anyag = new Anyagok(n, a);
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
            int ID = Integer.parseInt(TestIO.input());
            lopott = felszerelesek.get(ID % felszerelesek.size());
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
            int ID = Integer.parseInt(TestIO.input());
            lopott = agensek.get(ID % agensek.size());
        }

        return lopott;
    }

    /**
     * A virológus meg tud kenni valakit, aki egy mezőn áll vele.
     * @param kit a megkent virológus
     * @param mivel a virológusra kent ágens
     */
    public void ken(Virologus kit, Agens mivel) {
 
        kit.getTaska().agensKivesz(mivel);
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
