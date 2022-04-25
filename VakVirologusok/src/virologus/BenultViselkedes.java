package virologus;

import agens.Agens;
import agens.Kod;
import felszereles.Felszereles;
import util.Anyagok;
import util.Taska;

/**
 * A virológus cselekményeit korlátozó osztály.
 * Ebben az állapotban semmilyen cselekvést nem tud a virológus végrehajtani, kimarad egy körből.
 */
public class BenultViselkedes extends Viselkedes {

    /**
     * Beállítja a viselkedés prior-ját Viselkedes_Prior.benult_prior-ra és a gazda-t a paraméterül kapott virológusra.
     * @param gazda gazda virológus
     */
    public BenultViselkedes(Virologus gazda) {
        super(gazda);
        prior = ViselkedesPrior.benult_prior;
    }

    /**
     * Megmondja, hogy ebben az állapotban a táska elvehető-e a virológustól. Mivel ez bénult viselkedés, így igen, vagyis igazzal tér vissza.
     * @return elvehető-e a táska, ebben a viselkedésmódban igen
     */
    @Override
    public boolean taskaElvehetoE() {
        return true;
    }

    /**
     * Bénult viselkedésben nem lehet mozogni, üres függvény.
     * @return
     */
    @Override
    public boolean mozog() {
        return false;
    }

    /**
     * Bénult viselkedésben nem lehet anyagot lopni, üres függvény. Null-t ad vissza.
     * @param kitol az a virológus akitől lopni akar
     * @return
     */
    @Override
    public Anyagok anyagLop(Virologus kitol) {
         return null;
    }

    /**
     * Bénult viselkedésben nem lehet felszerelést lopni, üres függvény. Null-t ad vissza.
     * @param kitol az a virológus akitől lopni akar
     * @return
     */
    @Override
    public Felszereles felszerelesLop(Virologus kitol) {
         return null;
    }

    /**
     * Bénult viselkedésben nem lehet ágenst lopni, üres függvény. Null-t ad vissza.
     * @param kitol az a virológus akitől lopni akar
     * @return
     */
    @Override
    public Agens agensLop(Virologus kitol) {
         return null;
    }

    /**
     * Bénult viselkedésben nem lehet ágenseket kenni, üres függvény.
     * @param kit az a virológus akit kenni akar
     * @return
     */
    @Override
    public boolean ken(Virologus kit, Agens mivel) {
        return false;
     }

    /**
     * Bénult viselkedésben nem lehet ágenst létrehozni, üres függvény. Null-t ad vissza.
     * @param kod a kód ami alapján az ágenst létre akarja hozni
     * @param taska a virológus táskája
     * @return
     */
    @Override
    public Agens agensEbbol(Kod kod, Taska taska) {
         return null;
    }

    /**
     * Bénult viselkedésben nem lehet támadni, üres függvény.
     * @param kit a támadott fél
     * @return hamis
     */
    @Override
    public boolean tamad(Virologus kit) {
        return false;
    }

    /**
     * állapot szöveggé írva, teszteléshez
     * @return benult
     */
    @Override
    public String toString(){
        return "benult";
    }
}
