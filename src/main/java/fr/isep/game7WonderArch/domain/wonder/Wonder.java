package fr.isep.game7WonderArch.domain.wonder;

import java.util.List;
import java.util.Map;

public abstract class Wonder {
    int layersAmount;    List<Map<Integer, Boolean>> parts;
    Wonder(int layersAmount){
        this.layersAmount = layersAmount;        SetLayers();
    }
    protected abstract void SetLayers();
}

