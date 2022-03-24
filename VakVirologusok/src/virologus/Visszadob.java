package virologus;

import agens.Agens;
import jdk.jshell.spi.ExecutionControl;

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
        throw new ExecutionControl.NotImplementedException("Nincs implementálva");
    }
}
