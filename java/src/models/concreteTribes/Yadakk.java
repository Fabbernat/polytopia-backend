package models.concreteTribes;

import models.AbstractTribe;
import models.Tech;

public class Yadakk extends AbstractTribe {
    protected Yadakk() {
        super(Tech.STRATEGY, 7, false, 1.5, 1, .5, 1, .5, 1, 1);
    }
}
