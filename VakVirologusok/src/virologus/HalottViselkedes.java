package virologus;

/**
 * A virológus cselekményeit korlátozó osztály.
 * Ebben az állapotban halott a virológus, vagyis  semmilyen cselekvést nem tud végrehajtani.
 */
public class HalottViselkedes extends BenultViselkedes{

    public HalottViselkedes(Virologus gazda) {
        super(gazda);
        prior = ViselkedesPrior.halott_prior;
    }

    /**
     * A virologus halott, csak annyit tesz a függvény, hogy a gazda virológus viselkedését a
     * következő körre is halott viselkedésre állítja (erre azért van szükség mert a virológus
     * felhasználta ezt a viselkedést, ezért ha nem adják újra hozzá a halott viselkedést,
     * akkor a következő körben újra mozoghatna) a virologus addViselkedes(1, this) függvényével,
     * vagyis újabb 1 körre ez a halott viselkedése lesz a virológusnak.
     * @return false
     */
    @Override
    public boolean mozog() {
        gazda.addViselkedes(1, this);
        return false;
    }

    /**
     * szöveggé alakított állapot teszteléshez
     * @return halott
     */
    @Override
    public String toString(){
        return "halott";
    }
}
