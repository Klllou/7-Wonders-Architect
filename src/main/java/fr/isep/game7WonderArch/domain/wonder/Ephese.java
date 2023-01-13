package fr.isep.game7WonderArch.domain.wonder;

import java.util.HashMap;

public class Ephese extends Wonder{
    Ephese(int layersAmount) {
        super(layersAmount);
    }

    @Override
    protected void SetLayers() {
        for (int i = 0; i< this.layersAmount; i++){
            this.parts.add(new HashMap<>());
        }
        parts.get(0).put(2, false);
        parts.get(1).put(2, true);
        parts.get(1).put(3, true);
        parts.get(1).put(3, false);
        parts.get(2).put(4, false);
    }
}

