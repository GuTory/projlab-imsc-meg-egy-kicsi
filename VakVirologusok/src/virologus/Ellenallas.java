package virologus;

import agens.Agens;
import jdk.jshell.spi.ExecutionControl;

/**
 * Virológusok ágensek elleni védettségét menedzselő segédosztály.
 */
public abstract class Ellenallas {
    /**
     * Azt mutatja, hogy hatásos-e az adott védekezési mód és ha igen, akkor mennyi ideig hat.
     * <li>-1: végtelen körig érvényes az ellenállás</li>
     * <li>0: nem érvényes az ellenállás</li>
     * <li>>0: csak ennyi körig érvényes az ellenállás</li>
     */
    protected int ervenyesseg;

    /**
     * Ha csak bizonyos körig érvényes a védekezés, akkor a megkent az alapján fogja eldönteni, hogy érvényes-e,
     * hogy a beállított időbélyeghez hozzáadja az ervenyesseg-et és ez nagyobb-e,
     * mint a Jatek-tól lekérdezett jelenlegi időbélyeg.
     */
    protected int idobelyeg;

    /**
     * Absztrakt, leszármazottak máshogy valósítják meg milyen, ha megkenik a virológust és hogyan védekezik ellene.
     * @param ki a kenő virológus
     * @param kit a megkent virológus
     * @param mivel a virológusra kent ágens
     * @return a kenés sikeressége
     */
    abstract public boolean megkent(Virologus ki, Virologus kit, Agens mivel) throws ExecutionControl.NotImplementedException;

    /**
     * Beállítja az ellenállás érvényességét egy megfelelő szintre.
     * <li>-1: végtelen körig érvényes az ellenállás</li>
     * <li>0: nem érvényes az ellenállás</li>
     * <li>>0: csak ennyi körig érvényes az ellenállás</li>
     * @param szint az érvényesség szintje
     */
    public void setErvenyesseg(int szint) throws ExecutionControl.NotImplementedException { //TODO: ne felejtsük el a setIdobelyeg()-et meghívni benne
        throw new ExecutionControl.NotImplementedException("Nincs implementálva");
    }

    /**
     * Lekérdezi és beállítja az időbélyeg értékét.
     */
    public void setIdobelyeg() throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Nincs implementálva");
    }

}
