package virologus;

import agens.Agens;
import agens.Kod;
import felszereles.*;
import terkep.Mezo;
import test.TestIO;
import util.Anyagok;
import util.Taska;

import java.awt.*;
import java.util.List;

/**
 * A virológus cselekményeit korlátozó állapotok ősosztálya. Ebben az állapotban nincs semmilyen korlátozás a cselekményre.
 */
public class Viselkedes {
    /**
     * A viselkedés erőssége. A kisebb prioritású viselkedés felülírja a nagyobb
     * prioritásút.
     */
    protected int prior;

    /**
     * Virológus, akinek a viselkedése.
     */
    protected Virologus gazda;

    /**
     * Konstruktor.
     * Beállítja a gazdát és a viselkedés prioritását.
     * @param gazda Gazda virológus
     */
    public Viselkedes(Virologus gazda) {
        prior = ViselkedesPrior.sima_prior;
        this.gazda = gazda;
    }

    /**
     * Konstruktor.
     * Beállítja a viselkedés prioritsását.
     */
    public Viselkedes() {
        prior = ViselkedesPrior.sima_prior;
    }

    /**
     * Visszaadja a viselkedés prioritását
     * @return A viselkedés prioritása.
     */
    public int getPrior(){ return prior; }

    /**
     * Beállítja a viselkedés prioritását.
     * @param prior A viselkedés prioritása.
     */
    public void setPrior(int prior) {
        this.prior = prior;
    }

    /**
     * Visszaadja a viselkedés gazdáját.
     * @return A viselkedés gazdája.
     */
    public Virologus getGazda() {
        return gazda;
    }

    /**
     * Beállítja a viselkedés gazdáját.
     * @param gazda A viselkedés gazdája.
     */
    public void setGazda(Virologus gazda) {
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
    public boolean mozog(Mezo mezo) {
        atleptet(mezo);
        return true;
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
                    if(lehetN) n++;
                }
                else  {
                    lehetA = lopott_taska.anyagKivesz(new Anyagok(0,1));
                    if(lehetA) a++;
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
        if (felszerelesek != null && felszerelesek.size() != 0) {
            lopott = felszerelesek.get(0);
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
            lopott = agensek.stream().filter(a -> a.getKod().toString().equals(TestIO.parancs[3])).findAny().orElse(null);
            if(lopott != null) lopott_taska.agensKivesz(lopott);
        }

        return lopott;
    }

    /**
     * A virológus meg tud kenni valakit, aki egy mezőn áll vele.
     * @param kit a megkent virológus
     * @param mivel a virológusra kent ágens
     */
    public boolean ken(Virologus kit, Agens mivel) {
        gazda.getTaska().agensKivesz(mivel);
        mivel.setTtl(3);
        return kit.megkent(gazda, mivel);
     }

    /**
     * Létrehoz egy ágenst, majd visszaadja azt.
     * @param kod a kód ami alapján az ágenst létre akarja hozni
     * @return a létrehozott ágens
     */
    public Agens agensEbbol(Kod kod, Taska taska) {
        return kod.agensLetrehoz(taska);
    }

    public boolean tamad(Virologus kit) {
        //megkeressük a baltát a virológus táskájában
        Felszereles balta = null;
        for (Felszereles f : gazda.getTaska().getFelszerelesek()) {
            if (f.getID() == Felszereles_ID.balta_ID) {
                balta = f;
            }
        }
        if (balta == null) return false;  //nem volt balta, nem lehet támadni
        //volt balta, megöli a virológust és csorbult baltára cseréli a baltát
        kit.meghal();
        balta.le(gazda, gazda.getTaska());
        new CsorbultBalta().fel(gazda, gazda.getTaska());
        return true;
    }

    /**
     * Átlépteti a gazda virológust egy másik mezőre.
     * @param uj Mező, ahova átlépteti a virológust.
     */
    final protected void atleptet(Mezo uj) {
        gazda.getHely().virologusKi(gazda);
        uj.virologusBe(gazda);
        gazda.setHely(uj);
    }

    /**
     * Kiírja a virológus viselkedését.
     * @return Normál viselkedés
     */
    @Override
    public String toString(){
        return "normal";
    }

    public Color color(){
        return new Color(0,0,255);
    }
}
