package fr.isep.game7WonderArch.domain.wonder;

import java.util.ArrayList;
import java.util.HashMap;

public class Halicarnasse extends Wonder {
    public Halicarnasse() {
        super("Halicarnasse",4);

    }

    @Override
    protected void SetLayers(int layersAmount) {
        this.parts = new ArrayList<>();
        for (int i = 0; i< layersAmount; i++){
            this.parts.add(new HashMap<>());
        }
        parts.get(0).put(0, 2);
        parts.get(1).put(1, 2);
        parts.get(2).put(0, 3);
        parts.get(2).put(1, 3);
        parts.get(3).put(0, 4);
    }
}

