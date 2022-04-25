package felszereles;

/**
 * Egy CsorbultBalta tárgy, ha egy baltát használnak, ilyen balta lesz belőle.
 */
public class  CsorbultBalta extends Balta{

    /**
     * Csorbult balta ID-ja
     * @return csorbult balta ID
     */
    @Override
    public int getID() {
        return Felszereles_ID.csorbultBalta_ID;
    }

    /**
     * szöveggé alakított csorbult balta, a teszteléshez
     * @return csorbultbalta
     */
    @Override
    public String toString(){
        return "csorbultbalta";
    }
}
