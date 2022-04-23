package Serialization;
import jatek.Varos;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class XmlLoader 
{
    public static void load(String fileName) throws Exception
    {
        XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(fileName)));
        Varos varos = (Varos)decoder.readObject();
    }
}
