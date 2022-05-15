package terkep;

import agens.Agens;
import agens.Medvetanc;
import virologus.Virologus;

import java.awt.*;

/**
 * A várost alkotó elemek egy fajtája, egy egység, amin virológusok lehetnek.
 * A labor leszármazottja, annyival tud többet nála,
 * hogy a fertőző laborban van egy medvevírus ágens, amit a virológusok elkapnak.
 */
public class FertozoLabor extends Labor{

    /**
     * A fertőző laborban lévő medvevírus, ami a belépőket megfertőzi
     */
    private Agens medvevirus;

    /**
     * konstruktor: belekerül a medvevírus a laborba
     */
    public FertozoLabor() {
        this.medvevirus = new Agens(new Medvetanc());
    }

    /**
     * A fertőző labor akció metódusa meghívja a medvevírus a hatas(virologus: Virologus)
     * metódusát, az attribútumban kapott virológus átadásával.
     * @param virologus
     */
    @Override
    public void akcio(Virologus virologus) {
        super.akcio(virologus);
        virologus.megkent(null, medvevirus);
    }

    /**
     * szöveggé alakított fertőzőlabor teszteléshez
     * @return Fertozolabor: ID
     */
    @Override
    public String toString(){
        return "Labor: " + TestNev;
    }

    @Override
    public Color color(){
        return new Color(150,50,50);
    }
}
