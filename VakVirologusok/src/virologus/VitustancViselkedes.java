package virologus;

import terkep.Mezo;

import java.awt.*;
import java.util.List;
import java.util.Random;

/**
 * Ha a virológusra egy vítustánc ágenst kentek, akkor ebbe a viselkedési típusba kerül.
 * Ilyenkor, ha tovább akar lépni egy másik mezőre, akkor azt véletlenszerűen fogja megtenni.
 */
public class VitustancViselkedes extends Viselkedes{

    /**
     * Konstruktor
     * @param gazda Virológus, akinek a viselkedése
     */
    public VitustancViselkedes(Virologus gazda) {
        super(gazda);
        prior = ViselkedesPrior.vitustanc_prior;
    }

    /**
     * Mozgatja a virológust egy tetszőleges mezőre
     * @return Sikeres mozgás
     */
    @Override
    public boolean mozog(Mezo mezo) {
        List<Mezo> szomszedok = gazda.getHely().getSzomszedok();
        Mezo uj = szomszedok.get(new Random().nextInt(szomszedok.size()));
        atleptet(uj);
        uj.akcio(gazda);
        return true;
    }

    /**
     * Kiíjra a viselkedés típusát.
     * @return A viselkedés típusa.
     */
    @Override
    public String toString(){
        return "vitustanc";
    }

    @Override
    public Color color(){
        return new Color(255,165,0);
    }
}
