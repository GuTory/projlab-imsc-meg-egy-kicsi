package virologus;

import agens.Agens;
import jdk.jshell.spi.ExecutionControl;

/**
 * A virológusnak az ágenskenés ellen százalékos védettséget biztosító osztály.
 */
public class Szazalekos extends Ellenallas{
    /**
     * Százalékos védelmi arány, hogy milyen eséllyel lesz megvédve a
     * virológus az ágenstől.
     */
    private double vedArany;

    public Szazalekos(double vedArany) {
        this.vedArany = vedArany;
    }

    /**
     * Ha az érvényesség 0, akkor hamissal visszatér. Ha az érvényesség negatív, vagy az érvényesség pozitív és
     * ellenallas.idobelyeg + ervenyesseg < Jatek.getIdobelyeg(), akkor sorsol egy random számot 0 és 100 között.
     * Ha ez a random szám kisebb mint a vedArany, akkor igazzal
     * tér vissza. Minden más esetben hamissal tér vissza.
     * @param ki a kenő virológus
     * @param kit a megkent virológus
     * @param mivel a virológusra kent ágens
     * @return a kenés sikeressége
     */
    @Override
    public boolean megkent(Virologus ki, Virologus kit, Agens mivel) {
        throw new ExecutionControl.NotImplementedException("Nincs implementálva");
    }
}
