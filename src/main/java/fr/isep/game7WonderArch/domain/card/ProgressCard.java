package fr.isep.game7WonderArch.domain.card;

import main.Player;

public class ProgressCard extends Card{
    ScienceCategory scienceCategory;
    public ProgressCard(CardType type, CardBack back) {
        super(type, back);
        scienceCategory = type.scienceCategory;
    }

    //Si le joueur possède suffisament de SymbolScience, le joeur peut choisir un ProgressToken.
    // Il perd alors ses SymbolScience
    @Override
    public void apply(Player player) {
        if(player.addSymbolScience(this.scienceCategory)){
            player.takeToken();
        }
    }
}
