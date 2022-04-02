package virologus;

public class HalottViselkedes extends BenultViselkedes{

    public HalottViselkedes(Virologus gazda) {
        super(gazda);
        prior = Viselkedes_Prior.halott_prior;
    }

    @Override
    public void mozog() {
        gazda.addViselkedes(1, this);
    }
}
