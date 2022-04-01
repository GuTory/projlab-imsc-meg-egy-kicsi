package virologus;

import agens.Agens;
import felszereles.Felszereles;
import felszereles.Felszereles_ID;
import skeleton.Skeleton;

/**
 * Ha a virológusnak van kesztyűje, akkor képes visszadobni a rákent ágenst.
 * Ez az osztály egy példánya belekerül a virológus cselekménypufferébe, így biztosítva azt, hogy az ágens visszadobható.
 */
public class Visszadob extends Ellenallas{

    /**
     * Paraméterként kapja, hogy melyik virológus kit és milyen ágenssel kent meg, itt a játékos eldöntheti,
     * hogy visszadobja-e az ágenst, vagy hogy hatna-e egyáltalán rá.
     * @param ki a kenő virológus
     * @param kit a megkent virológus
     * @param mivel a virológusra kent ágens
     * @return a kenés sikeressége
     */
    @Override
    public boolean megkent(Virologus ki, Virologus kit, Agens mivel) {
        Skeleton.metodusEleje(Thread.currentThread().getStackTrace()[1].getMethodName());

        //megkeressük a kesztyűt a virológus táskájában, hogy csökenthessük az élettartamát
        Felszereles kesztyu = null;
        for (Felszereles f : ki.getTaska().getFelszerelesek()) {
            if (f.getID() == Felszereles_ID.kesztyu_ID) {
                kesztyu = f;
            }
        }
        if (kesztyu == null) this.ervenyesseg = 0;  //nem volt kesztyű, nem is lehet érvényes ez a védelem
        else {  //volt kesztyű
            //csökkentjük az élettartamát
            if (!kesztyu.hasznal()) {
                //a kesztyű elkopott, kivesszük a táskából
                kesztyu.le(ki, ki.getTaska());
            }
        }

        if (!this.ervenyesE()) {
            Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
            return true;
        }

        if (!mivel.ttlCsokkent()) { //már nem dobható vissza
            return true;
        }

        boolean choice = Skeleton.igenNem("Visszadobod?");
        if (choice) {
            ki.megkent(kit, mivel);
        }

        Skeleton.metodusVege(Thread.currentThread().getStackTrace()[1].getMethodName());
        return !choice;
    }
}
