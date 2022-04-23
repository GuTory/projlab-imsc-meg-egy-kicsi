package Serialization;
import jatek.Varos;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class XmlSaver
{
    public static void save(String fileName) throws Exception
    {

        Varos state = Varos.getInstance();
        XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(fileName)));
        encoder.writeObject(state);
        encoder.close();
    }
}
