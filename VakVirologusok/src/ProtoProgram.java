import Serialization.XmlLoader;
import Serialization.XmlSaver;
import agens.*;
import felszereles.*;
import jatek.Jatek;
import jatek.Varos;
import terkep.*;
import test.TestIO;
import util.Anyagok;
import util.Taska;
import virologus.Virologus;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ProtoProgram {
    private static String[] data;
    private static Virologus active = null;

    public static void main(String[] args) throws FileNotFoundException {
        File folder = new File("tests/");
        for(File f : folder.listFiles()){
            if(f.getName().contains("input")){
                TestIO.setInputScanner(new Scanner( new File("tests/" + f.getName())));
                ertelmez();
                System.out.println("-------");
            }
        }
    }

    public static void ertelmez() {
        while (TestIO.hasNext()){
            data = TestIO.input().split(" ");
            switch (data[0]){
                case "mozog":
                    mozog();
                    break;
                case "betolt":
                    betolt();
                    break;
                case "mentes":
                    mentes();
                    break;
                case "megken":
                    megken();
                    break;
                case "gyujt":
                    gyujt();
                    break;
                case "tamad":
                    tamad();
                    break;
                case "jatekindit":
                    jatekindit();
                    break;
                case "mezoletrehoz":
                    mezoletrehoz();
                    break;
                case "mezoberak":
                    mezoberak();
                    break;
                case "ellop":
                    ellop();
                    break;
                case "keszit":
                    keszit();
                    break;
                case "effektalkalmaz":
                    effektalkalmaz();
                    break;
                case "megtanit":
                    megtanit();
                    break;
                case "elfelejt":
                    elfelejt();
                    break;
                case "allapot":
                    allapot();
                    break;
                case "taskabarak":
                    taskabarak();
                    break;
                case "taskabolkivesz":
                    taskabolkivesz();
                    break;
                case "objektumlista":
                    objektumlista();
                    break;
                case "terkep":
                    terkep();
                    break;
                case "holvan":
                    holvan();
                    break;
                case "virologusok":
                    virologusok();
                    break;
                case "taskamegnez":
                    taskamegnez();
                    break;
                case "virologusletrehoz":
                    virologusletrehoz();
                    break;
                default:
                    TestIO.output("Rossz parancs");
                    break;
            }
        }
    }

    public static void virologusletrehoz(){
        Virologus v = new Virologus();
        TestIO.output("Virologus: " + v.TestNev);
        Varos.getInstance().getVirologusok().add(v);
        Mezo m = keresMezo(data[1]);
        v.setHely(m);
        m.virologusBe(v);
    }

    private static Virologus keresVirologus(String nev){
        Virologus v = Varos.getInstance().getVirologusok().stream().filter(a -> a.TestNev.equals(nev)).findAny().orElse(null);
        activateVirologus(v);
        return v;
    }

    private static Mezo keresMezo(String nev){
        return Varos.getInstance().getMezok().stream().filter(a -> a.TestNev.equals(nev)).findAny().orElse(null);
    }

    private static Agens keresAgens(Virologus ki, String nev){
        return ki.getTaska().getAgensek().stream().filter(a -> a.TestID.contains(nev)).findAny().orElse(null);
    }

    private static void activateVirologus(Virologus v){
        if(v != active && Objects.equals(v.TestNev, data[1])){
            active = v;
            v.TestViselkedesInit();
        }
    }

    public static void mozog(){
        Virologus v = keresVirologus(data[1]);
        boolean siker =  v.mozog();
        TestIO.output(siker ? "sikeres mozgas" : "sikertelen mozgas");
    }

    public static void betolt(){
        try {
            XmlLoader.load(data[1]);
        } catch (Exception e){
            e.printStackTrace();
            TestIO.output("sikertelen betoltes");
        }
        TestIO.output("sikeres betoltes");
    }

    public static void mentes() {
        try {
            XmlSaver.save(data[1]);
        } catch (Exception e){
            e.printStackTrace();
        }
        TestIO.output("sikertelen mentes");
    }

    public static void megken(){
        Virologus ki = keresVirologus(data[1]);
        Virologus kit = keresVirologus(data[2]);
        Agens mivel = null;
        switch (data[3]){
            case "benito":
                mivel =  keresAgens(ki, "Benito");
                break;
            case "vedelem":
                mivel =  keresAgens(ki, "Vedelem");
                break;
            case "felejto":
                mivel =  keresAgens(ki, "Felejto");
                break;
            case "vitustanc":
                mivel =  keresAgens(ki, "Vitustanc");
                break;
            default:
                break;
        }
        boolean siker = ki.ken(kit, mivel);
        TestIO.output(siker ? "sikeres megkenes" : "sikertelen megkenes");
    }

    public static void gyujt(){
        //semmi értelme mert automatikus
        TestIO.output("sikeres gyujtes");
    }

    public static void tamad(){
        Virologus ki = keresVirologus(data[1]);
        Virologus kit = keresVirologus(data[2]);
        boolean sikerestamadas =  ki.tamad(kit);
        TestIO.output(sikerestamadas ? "sikeres tamadas" : "sikertelen tamadas");
    }

    public static void jatekindit(){
        Jatek.jatekIndit();
        TestIO.output("sikeres jatekinditas");
    }

    public static void mezoletrehoz(){
        Mezo ujmezo;
        switch (data[1]){
            case "mezo":
                ujmezo = new Mezo();
                break;
            case "ovohely":
                ujmezo = new Ovohely();
                break;
            case "raktar":
                ujmezo = new Raktar();
                break;
            case "labor":
                ujmezo = new Labor();
                break;
            case "fertozolabor":
                ujmezo = new FertozoLabor();
                break;
            default:
                return;
        }
        Varos.getInstance().getMezok().add(ujmezo);
        for(int i=2; i< data.length;i++){
            Mezo mezo = keresMezo(data[i]);
            mezo.getSzomszedok().add(ujmezo);
            ujmezo.getSzomszedok().add(mezo);
        }
        TestIO.output(ujmezo.toString());
    }

    public static void mezoberak(){
        Mezo m = keresMezo(data[1]);
        switch (data[2]) {
            case "nukleotid":
            case "aminosav": {
                Raktar r = (Raktar) m;
                if (data[2].equals("nukleotid")) {
                    r.getAnyagok().betesz(new Anyagok(Integer.parseInt(data[3]), 0));
                } else {
                    r.getAnyagok().betesz(new Anyagok(0, Integer.parseInt(data[3])));
                }
                break;
            }
            case "kesztyu":
            case "kopeny":
            case "balta":
            case "csorbultbalta":
            case "zsak": {
                Ovohely r = (Ovohely) m;
                switch (data[2]) {
                    case "kesztyu":
                        r.setFelszereles(new Kesztyu());
                        break;
                    case "kopeny":
                        r.setFelszereles(new Kopeny());
                        break;
                    case "balta":
                        r.setFelszereles(new Balta());
                        break;
                    case "csorbultbalta":
                        r.setFelszereles(new CsorbultBalta());
                        break;
                    case "zsak":
                        r.setFelszereles(new Zsak());
                        break;
                }
                break;
            }
            case "benito":
            case "vedelem":
            case "vitustanc":
            case "felejto": {
                Labor r = (Labor) m;
                Anyagok anyagok = new Anyagok(1, 1);
                Kod k = null;
                switch (data[2]) {
                    case "benito":
                        k = new Benito(anyagok, 3, 3);
                        r.setKod(k);
                        break;
                    case "vedelem":
                        k = new Vedelem(anyagok, 3, 3);
                        r.setKod(k);
                        break;
                    case "vitustanc":
                        k = new Vitustanc(anyagok, 3, 3);
                        r.setKod(k);
                        break;
                    case "felejto":
                        k = new Felejto(anyagok, 3, 3);
                        r.setKod(k);
                        break;
                }
                Varos.getInstance().getKodok().add(k);
                break;
            }
        }
    }

    public static void ellop(){
        Virologus ki = keresVirologus(data[1]);
        Virologus kitol = keresVirologus(data[2]);
        boolean siker = false;
        switch (data[3]) {
            case "nukleotid":
            case "aminosav":
                siker = ki.anyagLop(kitol);
                break;
            case "kesztyu":
            case "kopeny":
            case "balta":
            case "csorbultbalta":
            case "zsak":
                siker = ki.felszerelesLop(kitol);
                break;
            case "benito":
            case "vedelem":
            case "vitustanc":
            case "felejto":
                siker = ki.agensLop(kitol);
                break;
        }
        TestIO.output(siker ? "sikeres lopas" : "sikertelen lopas");
    }

    public static void keszit(){
        Virologus ki = keresVirologus(data[1]);
        String milyen = data[2];
        for (Kod kod : ki.getKodok()){
            if(kod.id.toLowerCase().contains(milyen)){
                ki.agensEbbol(kod);
                TestIO.output("sikeres keszites");
                return;
            }
        }
        TestIO.output("sikertelen keszites");
    }

    public static void effektalkalmaz(){
        Virologus ki = keresVirologus(data[1]);
        Kod k = null;
        switch (data[2]){
            case "benito":
                k = new Benito(new Anyagok(1,1), 3,3);
                break;
            case "vedelem":
                k = new Vedelem(new Anyagok(1,1), 3,3);
                break;
            case "vitustanc":
                k = new Vitustanc(new Anyagok(1,1), 3,3);
                break;
            case "felejto":
                k = new Felejto(new Anyagok(1,1), 3,3);
                break;
            default:
                break;
        }
        assert k != null;
        Agens a = new Agens(k);
        a.hatas(ki);
        TestIO.output("sikeres hatas");
    }

    public static void megtanit(){
        Virologus ki = keresVirologus(data[1]);
        Kod k = null;
        Anyagok a = new Anyagok(1,1);
        switch (data[2]){
            case "benito":
                k = new Benito(a, 3,3);
                break;
            case "vedelem":
                k = new Vedelem(a, 3,3);
                break;
            case "vitustanc":
                k = new Vitustanc(a, 3,3);
                break;
            case "felejto":
                k = new Felejto(a, 3,3);
                break;
            default:
                break;
        }
        assert k != null;
        ki.kodMegtanul(k);
        TestIO.output("sikeres tanulas");
    }

    public static void elfelejt(){
        Virologus ki = keresVirologus(data[1]);
        ki.getKodok().clear();
        TestIO.output("sikeres felejtes");
    }

    public static void allapot(){
        if(data[1].contains("virologus")){
            Virologus ki = keresVirologus(data[1]);
            //ki.TestViselkedesInit();
            TestIO.output(ki.toString());
        } else if(data[1].contains("mezo")){
            Mezo m = keresMezo(data[1]);
            TestIO.output(m.toString());
        }
    }

    public static void taskabarak(){
        Taska t = keresVirologus(data[1]).getTaska();
        Anyagok a = new Anyagok(1,1);
        Felszereles f;
        Agens agens;
        switch (data[2]) {
            case "nukleotid":
                t.anyagBerak(new Anyagok(Integer.parseInt( data[3]),0));
                break;
            case "aminosav":
                t.anyagBerak(new Anyagok(0,Integer.parseInt( data[3])));
                break;
            case "kesztyu":
                f = new Kesztyu();
                TestIO.output("Kesztyu: " + f.TestNev);
                t.felszerelesBerak(f);
                break;
            case "kopeny":
                f=new Kopeny();
                TestIO.output("Kopeny: " + f.TestNev);
                t.felszerelesBerak(f);
                break;
            case "balta":
                f=new Balta();
                TestIO.output("Balta: " + f.TestNev);
                t.felszerelesBerak(f);
                break;
            case "csorbultbalta":
                f=new CsorbultBalta();
                TestIO.output("Csorbultbalta: " + f.TestNev);
                t.felszerelesBerak(f);
                break;
            case "zsak":
                f=new Zsak();
                TestIO.output("Zsak: " + f.TestNev);
                t.felszerelesBerak(f);
                break;
            case "benito":
                agens = new Agens(new Benito(a, 3,3));
                TestIO.output(agens.toString());
                t.agensBerak(agens);
                break;
            case "vedelem":
                agens =new Agens(new Vedelem(a, 3,3));
                TestIO.output(agens.toString());
                t.agensBerak(agens);
                break;
            case "vitustanc":
                agens =new Agens(new Vitustanc(a, 3,3));
                TestIO.output(agens.toString());
                t.agensBerak(agens);
                break;
            case "felejto":
                agens =new Agens(new Felejto(a, 3,3));
                TestIO.output(agens.toString());
                t.agensBerak(agens);
                break;
            default:
                break;
        }
    }

    public static void taskabolkivesz(){
        Taska t = keresVirologus(data[1]).getTaska();
        Anyagok a = new Anyagok(1,1);
        Felszereles f;
        Agens agens;
        switch (data[2]) {
            case "nukleotid":
                t.anyagKivesz(new Anyagok(Integer.parseInt( data[3]),0));
                break;
            case "aminosav":
                t.anyagKivesz(new Anyagok(0,Integer.parseInt( data[3])));
                break;
            case "kesztyu":
                f = new Kesztyu();
                TestIO.output(f.toString());
                t.felszerelesKivesz(f);
                break;
            case "kopeny":
                f=new Kopeny();
                t.felszerelesKivesz(f);
                break;
            case "balta":
                f=new Balta();
                t.felszerelesKivesz(f);
                break;
            case "csorbultbalta":
                f=new CsorbultBalta();
                t.felszerelesKivesz(f);
                break;
            case "zsak":
                f=new Zsak();
                t.felszerelesKivesz(f);
                break;
            case "benito":
                agens = new Agens(new Benito(a, 3,3));
                t.agensKivesz(agens);
                break;
            case "vedelem":
                agens =new Agens(new Vedelem(a, 3,3));
                t.agensKivesz(agens);
                break;
            case "vitustanc":
                agens =new Agens(new Vitustanc(a, 3,3));
                t.agensKivesz(agens);
                break;
            case "felejto":
                agens =new Agens(new Felejto(a, 3,3));
                t.agensKivesz(agens);
                break;
            default:
                break;
        }
    }

    public static void objektumlista(){
        for (Mezo m: Varos.getInstance().getMezok()){
            TestIO.output( m.toString());
        }
        for(Virologus v: Varos.getInstance().getVirologusok()){
            TestIO.output(v.toString());
        }
    }

    public static void terkep(){
        for (Mezo m: Varos.getInstance().getMezok()){
            TestIO.output( m.toString());
        }
    }

    public static void holvan(){
        Virologus ki = keresVirologus(data[1]);
        Mezo m = ki.getHely();
        TestIO.output(m.toString());
    }

    public static void virologusok(){
        for(Virologus v: Varos.getInstance().getVirologusok()){
            TestIO.output(v.toString());
        }
    }

    public static void taskamegnez(){
        Virologus ki = keresVirologus(data[1]);
        TestIO.output( ki.getTaska().toString());
    }
}
