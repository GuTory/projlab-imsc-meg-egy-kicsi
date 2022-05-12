package Graphics;

import terkep.Mezo;
import virologus.Virologus;

import java.awt.*;
import java.util.ArrayList;

public class Rajzolo extends Canvas {

    private Virologus Aktiv;

    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Aktiv.getHely().color());
        g.fillRect(0,0, getWidth(),getHeight());
        g.setColor(new Color(0,0,0));
        g.drawString(Aktiv.getHely().toString(), getWidth()/2- g.getFontMetrics().stringWidth(Aktiv.getHely().toString()) / 2,20);

        //Virológusok kirajzolása

        int virologusokszama = Aktiv.getHely().getVirologusok().size()-1;
        ArrayList<Point> Points = new ArrayList<>();
        ArrayList<Point> TopPoints = new ArrayList<>();
        for(int i=0; i<= virologusokszama; i++){
            Points.add(new Point(i*getWidth()/virologusokszama, getHeight()));
            if(i != virologusokszama)
                TopPoints.add(new Point( (i)*getWidth()/virologusokszama + getWidth()/virologusokszama /2, getHeight()-150));
        }
        int drawn = 0;
        for(Virologus v : Aktiv.getHely().getVirologusok()){
            if (Aktiv == v) continue;
            int XP[] = {Points.get(drawn).x, Points.get(drawn+1).x, TopPoints.get(drawn).x};
            int YP[] = {Points.get(drawn).y, Points.get(drawn+1).y, TopPoints.get(drawn).y};
            Polygon p = new Polygon(XP, YP, 3);
            g.setColor(v.viselkedesColor());
            g.fillPolygon(p);
            g.setColor(new Color(255,255,255));
            g.drawString(v.Nev, TopPoints.get(drawn).x-g.getFontMetrics().stringWidth(v.Nev) / 2 , TopPoints.get(drawn).y+130);
            drawn++;
        }

        //TODO: ide kell a rajzolás
    }

    public void frissit(Virologus virologus){
        Aktiv = virologus;
        invalidate(); //meghívja a paint-et
    }
}
