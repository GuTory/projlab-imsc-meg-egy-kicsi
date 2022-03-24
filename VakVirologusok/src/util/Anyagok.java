package util;

import skeleton.Skeleton;

import java.util.Dictionary;

public class Anyagok {

    private Dictionary<String, Integer> anyagok;

    public boolean bevesz(Anyagok anyagok) {
        if(Skeleton.bool("Fel tud venni ennyi anyagot?")) return true;
        return false;

    }

    public boolean kivesz(Anyagok anyagok) {
        if(Skeleton.bool("Ki tud venni ennyi anyagot?")) return true;
        return false;
    }

}
