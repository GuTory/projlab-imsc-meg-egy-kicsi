package Serialization;
import jatek.Varos;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * A tesztelésben a betoltes parancsot végrehajtó osztály
 */
public class XmlLoader 
{
    /**
     * betöltés fájlból
     * @param fileName fájl neve
     * @throws Exception hiba esetén ezt dobja
     */
    public static void load(String fileName) throws Exception
    {
        XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(fileName)));
        Varos.getInstance().copy((Varos)decoder.readObject());
        decoder.close();
    }
}
