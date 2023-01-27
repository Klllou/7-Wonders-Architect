package fr.isep.game7WonderArch.domain.card;

import main.Player;


public class MaterialCard extends Card{

    Material material;
    public MaterialCard(CardType type, CardBack back) {
        super(type, back);
        material = type.material;
    }

    //Fonction qui permet d'appliquer les effets des Cartes Matérielles, Construit automatiquement un niveau de la
    // merveille du joueur qui vient de piocher la Carte, s'il à suffisament de ressources pour construire l'étage à
    // lequel il est
    @Override
    public void apply(Player player) {
        player.resources.put(this.material, player.resources.get(this.material)+1);
        System.out.println(player.resources);
        player.hasEnoughResources();

        System.out.println(player.resources);



    }
}
