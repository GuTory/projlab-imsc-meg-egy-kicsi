import agens.Agens;
import jatek.Varos;
import terkep.*;
import test.TestIO;
import virologus.Virologus;

public class ProtoProgram {
    private static String[] data;

    public static void main(String[] args) {
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
                default:
                    TestIO.output("Rossz parancs");
                    break;
            }
        }
    }

    private static Virologus keresVirologus(String nev){
        return Varos.getVirologusok().stream().filter(a -> a.TestNev.equals(nev)).findFirst().get();
    }

    private static Mezo keresMezo(String nev){
        return Varos.getMezok().stream().filter(a -> a.TestNev.equals(nev)).findFirst().get();
    }

    private static Agens keresAgens(Virologus ki, String nev){
        return ki.getTaska().getAgensek().stream().filter(a -> a.TestID.contains(nev)).findFirst().get();
    }

    public static void mozog(){
        Virologus v = keresVirologus(data[1]);
        v.mozog();
    }

    public static void betolt(){

    }

    public static void mentes(){

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
        jatekindit();
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
        for(int i=2; i< data.length;i++){
            Mezo mezo = keresMezo(data[i]);
            mezo.getSzomszedok().add(ujmezo);
            ujmezo.getSzomszedok().add(mezo);
        }
        TestIO.output(ujmezo.toString());
    }

    public static void mezoberak(){

    }

    public static void ellop(){
        Virologus ki = keresVirologus(data[1]);
        Virologus kitol = keresVirologus(data[2]);
        boolean siker = false;
        if(data[3].equals("nukleotid") || data[3].equals("aminosav")){
            siker = ki.anyagLop(kitol);
        } else if( data[3].equals("kesztyu") ||
                   data[3].equals("kopeny") ||
                   data[3].equals("balta")  ||
                   data[3].equals("csorbultbalta") ||
                   data[3].equals("zsak")) {
            siker = ki.felszerelesLop(kitol);
        } else if(data[3].equals("benito") ||
                  data[3].equals("vedelem") ||
                  data[3].equals("vitustanc") ||
                  data[3].equals("felejto")){
            siker = ki.agensLop(kitol);
        }
        TestIO.output(siker ? "sikeres lopas" : "sikertelen lopas");
    }

    public static void keszit(){

    }

    public static void effektalkalmaz(){

    }

    public static void megtanit(){

    }

    public static void elfelejt(){

    }

    public static void allapot(){

    }

    public static void taskabarak(){

    }

    public static void taskabolkivesz(){

    }

    public static void objektumlista(){
        for (Mezo m: Varos.getMezok()){
            m.toString();
        }
        for(Virologus v: Varos.getVirologusok()){
            TestIO.output(v.toString());
        }
    }

    public static void terkep(){
        for (Mezo m: Varos.getMezok()){
            m.toString();
        }
    }

    public static void holvan(){
        Virologus ki = keresVirologus(data[1]);
        Mezo m = ki.getHely();
        TestIO.output(m.toString());
    }

    public static void virologusok(){
        for(Virologus v: Varos.getVirologusok()){
            TestIO.output(v.toString());
        }
    }

    public static void taskamegnez(){
        Virologus ki = keresVirologus(data[1]);
        TestIO.output( ki.getTaska().toString());
    }
}
