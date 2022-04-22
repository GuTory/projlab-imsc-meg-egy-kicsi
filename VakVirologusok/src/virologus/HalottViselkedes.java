package virologus;

import test.TestIO;

public class HalottViselkedes extends BenultViselkedes{

    public HalottViselkedes(Virologus gazda) {
        super(gazda);
        prior = ViselkedesPrior.halott_prior;
    }

    @Override
    public void mozog() {
        gazda.addViselkedes(1, this);
    }
}
