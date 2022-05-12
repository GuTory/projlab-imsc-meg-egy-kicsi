package virologus;

import agens.Agens;
import agens.Medvetanc;
import terkep.Mezo;

import java.awt.*;
import java.util.List;
import java.util.Random;

/**
 * A virológus medvetánc-al lett megfertőzve, ilyenkor csak úgy gyógyulhat ki, ha megölik.
 */
public class MedvetancViselkedes extends Viselkedes{

    /**
     *
     * @param gazda
     */
    public MedvetancViselkedes(Virologus gazda) {
        super(gazda);
        prior = ViselkedesPrior.medvetanc_prior;
    }

    /**
     * A virológus jelenlegi mezőjétől lekérdezi a szomszédokat és átlépteti a játékost egy random választott mezőre.
     * A jelenlegi mezőn meghívja a virologusKi fv-t, az új mezőn meghívja a virologusBe függvényt és a virologuson a
     * setHely fv-el beállítja az új helyet. Az új mezőnek meghívja a tombol metódusát és megken minden virológust az
     * új mezőn Medvetanc kódból készült ágenssel. Majd az új mezőn meghívja az akcio függvényt.
     */
    @Override
    public boolean mozog(Mezo mezo) {
        List<Mezo> szomszedok = gazda.getHely().getSzomszedok();
        Mezo uj = szomszedok.get(new Random().nextInt(szomszedok.size()));
        atleptet(uj);
        for (Virologus mezonAllo: uj.getVirologusok()) {
            ken(mezonAllo, new Agens(new Medvetanc()));
        }
        uj.tombol();
        return true;
    }

    /**
     * A kapott ágensnek beállítja a ttl-jét a setTtl függvénnyel 2-re (ez a visszadobásokhoz fog kelleni,
     * ez maximalizálja a visszadobások számát, hogy csak 1-szer lehessen). Majd a paraméterül kapott kit
     * virológusnak meghívja a megkent függvényét a gazdával és a kapott ágenssel paraméterezve.
     * @param kit a megkent virológus
     * @param mivel a virológusra kent ágens
     * @return
     */
    @Override
    public boolean ken(Virologus kit, Agens mivel) {
        gazda.getTaska().agensKivesz(mivel);
        mivel.setTtl(2); //Csak 1-szer visszadobható (medve nem dob vissza)
        return kit.megkent(gazda, mivel);
    }

    /**
     * szöveggé alakított állapot teszteléshez
     * @return medvetanc
     */
    @Override
    public String toString(){
        return "medvetanc";
    }

    @Override
    public Color color(){
        return new Color(66, 48, 48);
    }
}
