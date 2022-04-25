package Serialization;
import jatek.Varos;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * A tesztelésben a mentes parancsot végrehajtó osztály
 */
public class XmlSaver
{
    /**
     * mentes parancs fájlba
     * @param fileName fájl neve
     * @throws Exception hiba esetén ezt dobja
     */
    public static void save(String fileName) throws Exception
    {
        Varos state = Varos.getInstance();
        XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(fileName)));
        encoder.writeObject(state);
        encoder.close();
    }
}
