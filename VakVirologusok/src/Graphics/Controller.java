package Graphics;

import Graphics.ActionFrames.*;
import agens.Agens;
import agens.Kod;
import felszereles.Felszereles;
import jatek.Jatek;
import jatek.Varos;
import terkep.Mezo;
import virologus.Virologus;

import javax.swing.*;

public class Controller {
    private JatekFrame MainFrame;

    private static Controller instance = null;

    /**
     * Singleton osztály privát konstruktora
     */
    private Controller(){
        MainFrame = new JatekFrame();
    }

    /**
     * Singleton osztály getInstance függvénye. Inicializál első hívásnál.
     * @return Az egyetlen controller osztály a programban
     */
    public static Controller GetInstance(){
        if(instance == null)
            instance = new Controller();
        return instance;
    }

    /**
     * Elindítja a játékot a megadott számú virológussal. Megnyitja a főképernyőt.
     * @param virologusokSzama a játékosok száma, ennyi virológust hoz létre a játék.
     */
    public void JatekIndit(int virologusokSzama){
        Jatek.jatekIndit(virologusokSzama);
        MainFrame = new JatekFrame();
        MainFrame.setVisible(true);
    }

    /**
     * Megnyitja a MozogFrame-et és láthatóvá teszi.
     */
    public void MozogEvent(){
        JFrame frame = new MozogFrame(MainFrame);
        frame.setVisible(true);
    }

    /**
     * Megnyitja a TamadFrame-et és láthatóvá teszi.
     */
    public void TamadEvent(){
        JFrame frame = new TamadFrame(MainFrame);
        frame.setVisible(true);
    }

    /**
     * Megnyitja a AgensKeszitFrame-et és láthatóvá teszi.
     */
    public void KeszitEvent(){
        JFrame frame = new AgensKeszitFrame(MainFrame);
        frame.setVisible(true);
    }

    /**
     * Megnyitja a LopasFrame-et és láthatóvá teszi.
     */
    public void LopasEvent(){
        JFrame frame = new LopasFrame(MainFrame);
        frame.setVisible(true);
    }

    /**
     * Megnyitja a KenesFrame-et és láthatóvá teszi.
     */
    public void MegkenEvent(){
        JFrame frame = new KenesFrame(MainFrame);
        frame.setVisible(true);
    }

    /**
     * Megnyitja a NyertFrame-et és láthatóvá teszi.
     */
    public void NyerEvent(){
        JFrame frame = new NyertFrame(MainFrame);
        frame.setVisible(true);
    }

    /**
     * Megnyitja a EldobFrame-et és láthatóvá teszi.
     */
    public void EldobEvent(){
        JFrame frame = new EldobFrame(MainFrame);
        frame.setVisible(true);
    }

    /**
     * A MozogFrame callback függvénye. Átlépteti a virológust.
     * A lépés után a következő játékos (virológus) jön.
     * @param m az éppen soron levő játékos új mezője, ahová lép
     * @return sikeres volt-e a lépés
     */
    public boolean MozogCallback(Mezo m){
        boolean siker =  Varos.getInstance().getActivVirologus().mozog(m);
        if(siker){
            Varos.getInstance().kovetkezoVirologus();
            Publisher.getInstance().updateKovetkezo();
        }

        return siker;
    }

    /**
     * A AgensKeszitFrame callback függvénye. Ágenst készít a soron levő virológus kódjából.
     * @param k kód amiből ágenst akar készíteni a soron levő játékos
     * @return sikeres volt-e a készítés
     */
    public boolean KeszitCallback(Kod k){
        boolean siker =  Varos.getInstance().getActivVirologus().agensEbbol(k);
        Publisher.getInstance().updateAction();
        return siker;
    }

    /**
     * A LopasFrame callback függvénye ha felszerelést akar lopni a játékos.
     * @param kitol virológus akitől felszerelést akar lopni a játékos
     * @return sikeres volt-e a lopás
     */
    public boolean LopFelszerelesCallback(Virologus kitol){
        boolean siker =  Varos.getInstance().getActivVirologus().felszerelesLop(kitol);
        Publisher.getInstance().updateAction();
        return siker;
    }

    /**
     * A LopasFrame callback függvénye ha anyaot akar lopni a játékos.
     * @param kitol virológus akitől anyagot akar lopni a játékos
     * @return sikeres volt-e a lopás
     */
    public boolean LopAnyagotCallback(Virologus kitol){
        boolean siker =  Varos.getInstance().getActivVirologus().anyagLop(kitol);
        Publisher.getInstance().updateAction();
        return siker;
    }

    /**
     * A LopasFrame callback függvénye ha ágenst akar lopni a játékos.
     * @param kitol virológus akitől ágenst akar lopni a játékos
     * @return sikeres volt-e a lopás
     */
    public boolean LopAgenstCallback(Virologus kitol){
        boolean siker = Varos.getInstance().getActivVirologus().agensLop(kitol);
        Publisher.getInstance().updateAction();
        return siker;
    }

    /**
     * A KenesFrame callback függvénye ha kenni szeretne a játékos.
     * @param kit virológus akit meg akar kenni a játékos
     * @param mivel az ágens amivel kenni akar
     * @return sikeres volt-e a kenés
     */
    public boolean MegkenCallback(Virologus kit, Agens mivel){
        boolean siker =  Varos.getInstance().getActivVirologus().ken(kit, mivel);
        Publisher.getInstance().updateAction();
        return siker;
    }

    /**
     * A TamafasFrame callback függvénye ha támadni akar a játékos.
     * @param kit virológus akit meg akar támadni a játékos
     * @return sikeres volt-e a támadás
     */
    public boolean TamadCallback(Virologus kit){
        boolean siker = Varos.getInstance().getActivVirologus().tamad(kit);
        Publisher.getInstance().updateAction();
        return siker;
    }

    /**
     * Az EldobFrame callback függvénye ha felszerelést akar eldobni a játékos.
     * @param f felszerelés amit el akar dobni a játékos
     * @return sikeres volt-e a támadás
     */
    public boolean EldobCallback(Felszereles f){
        boolean siker = Varos.getInstance().getActivVirologus().getTaska().felszerelesKivesz(f);
        Publisher.getInstance().updateAction();
        return siker;
    }

    /**
     * A következő virológus jön a játékban
     */
    public void KovetkezoVirologusCallback(){
        Varos.getInstance().kovetkezoVirologus();
        Publisher.getInstance().updateKovetkezo();
    }
}
