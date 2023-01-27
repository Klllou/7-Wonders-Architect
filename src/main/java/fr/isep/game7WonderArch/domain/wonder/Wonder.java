package fr.isep.game7WonderArch.domain.wonder;

import java.util.List;
import java.util.Map;

public abstract class Wonder {

    public String name;
    int layersAmount;
    public List<Map<Integer, Integer>> parts;
    int layer;

    Wonder(String name, int layersAmount){
        this.name = name;
        SetLayers(layersAmount);

    }

    public int getLayer(){
        return this.layer;
    }

    //On définit le nombre de ressources nécessaire à la création de chaque niveau des Merveilles, ainsi que
    //Le nombre de "part" de la Merveille il y a par étage
    protected abstract void SetLayers(int layersAmount);

    public void SetCurrentLayer(){
        if (parts.get(0).isEmpty()){
            parts.remove(0);
        }


    }

}
