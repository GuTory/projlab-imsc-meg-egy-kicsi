package virologus;

import agens.Agens;
import jatek.Jatek;
import jdk.jshell.spi.ExecutionControl;
import skeleton.Skeleton;

import java.util.Random;

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
     * Visszatér azzal, hogy ezen az ellenálláson áttört-e az ágens.
     * Ha az ervenyesE() hamissal tér vissza, akkor igazzal visszatér.
     * Ha az érvényesség negatív, vagy az érvényesség pozitív és
     * ellenallas.idobelyeg + ervenyesseg < Jatek.getIdobelyeg(), akkor sorsol egy random számot 0 és 100 között.
     * Ha ez a random szám kisebb mint a vedArany, akkor hamissal tér vissza. Minden más esetben igazzal tér vissza.
     * @param ki a kenő virológus
     * @param kit a megkent virológus
     * @param mivel a virológusra kent ágens
     * @return a kenés sikeressége
     */
    @Override
    public boolean megkent(Virologus ki, Virologus kit, Agens mivel) {
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());

        if (!this.ervenyesE()) {
            Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
            return true;
        }

        //return new Random().nextDouble()*100 <= this.vedArany;

        boolean choice = Skeleton.igenNem("Megvédje a százalékos?");
        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
        return !choice;
    }
}
