package virologus;

/**
 * A virológusok prioritása.
 * Később a viselkedések ez alapján írják felül egymást.
 * Amelyik viselkedés erősebb, azt a gyengébb nem írja felül.
 * Minél kisebb szám a prioritás, annál fontosabb az állapot.
 */
public class ViselkedesPrior {
    public static int vitustanc_prior = 3;
    public static int medvetanc_prior = 1;
    public static int benult_prior = 2;
    public static int halott_prior = 0;
    public static int sima_prior = 10000;
}
