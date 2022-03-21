package virologus;

import jdk.jshell.spi.ExecutionControl;

public class VitustancViselkedes extends Viselkedes{
    public VitustancViselkedes() {
        super.prior = 1;
    }

    @Override
    public void mozog() throws ExecutionControl.NotImplementedException {
        super.mozog();
    }
}
