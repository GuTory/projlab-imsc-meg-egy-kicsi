package virologus;

import agens.Agens;
import jatek.Jatek;

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
    protected int ervenyesseg = 0;

    /**
     * Ha csak bizonyos körig érvényes a védekezés, akkor a megkent az alapján fogja eldönteni, hogy érvényes-e,
     * hogy a beállított időbélyeghez hozzáadja az ervenyesseg-et és ez nagyobb-e,
     * mint a jatek.Jatek-tól lekérdezett jelenlegi időbélyeg.
     */
    protected int idobelyeg = 0;

    /**
     * Absztrakt, leszármazottak máshogy valósítják meg milyen, ha megkenik a virológust és hogyan védekezik ellene.
     * @param ki a kenő virológus
     * @param kit a megkent virológus
     * @param mivel a virológusra kent ágens
     * @return a kenés sikeressége
     */
    abstract public boolean megkent(Virologus ki, Virologus kit, Agens mivel);

    /**
     * Beállítja az ellenállás érvényességét egy megfelelő szintre.
     * <li>-1: végtelen körig érvényes az ellenállás</li>
     * <li>0: nem érvényes az ellenállás</li>
     * <li>>0: csak ennyi körig érvényes az ellenállás</li>
     * @param szint az érvényesség szintje
     */
    public void setErvenyesseg(int szint) {
 
        ervenyesseg = szint;
        setIdobelyeg();

     }

    /**
     * Lekérdezi és beállítja az időbélyeg értékét.
     */
    public void setIdobelyeg() {
 
        idobelyeg = Jatek.getIdobelyeg();

     }

    /**
     * Megmondja érvényes-e az ellenállás.
     * @return visszaadja, hogy érvényes-e (végtelen ideig, vagy adott körig és még ezen belül van) az ágens
     */
    protected boolean ervenyesE() {
        //Érvényes volt, de csak adott ideig és már nem érvényes. Érvénytelenítjük.
        if (this.ervenyesseg > 0 && this.idobelyeg + this.ervenyesseg < Jatek.getIdobelyeg()) {
            this.ervenyesseg = 0;
        }
        //-1 végtelen ideig
        //>0 csak ha még érvényes az adott körben

         return this.ervenyesseg != 0;
    }

}
