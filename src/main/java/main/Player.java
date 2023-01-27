package main;

import fr.isep.game7WonderArch.domain.ProgressToken;
import fr.isep.game7WonderArch.domain.card.*;
import fr.isep.game7WonderArch.domain.wonder.*;

import java.util.*;

public class Player {
    private String name;
    public int age;

    public Map<ScienceCategory, Integer> symbolsScience;
    public Map<Material, Integer> resources;
    public Wonder wonder;
    public List<Card> deck;
    private Boolean hasCat;
    public int victoryPoints;
    private int shieldsWithHorns;
    private int shieldsWithoutHorns;

    public Player(String playerName, int playerAge) {
        this.hasCat = false;
        name = playerName;
        age = playerAge;
//        setWonder(ChooseYourWonderController.getChosenWonder());
        this.symbolsScience = new HashMap<>();
        this.symbolsScience.put(ScienceCategory.Law, 0);
        this.symbolsScience.put(ScienceCategory.Architect, 0);
        this.symbolsScience.put(ScienceCategory.Mechanic, 0);
        this.resources = new HashMap<>();
        this.resources.put(Material.Brick, 0);
        this.resources.put(Material.Wood, 0);
        this.resources.put(Material.Stone, 0);
        this.resources.put(Material.Glass, 0);
        this.resources.put(Material.Paper, 0);
        this.resources.put(Material.Gold, 0);
    }

    //Lorsque un jouer choisit une merveille, On lui assigne le deck correspondant à cette Merveille
    void SetDeck() {
        List<CardDecks.CardTypeQuantity> cardTypeQuantity = null;
        CardBack cardBack = null;
        switch (wonder.name) {
            case "Gizeh":
                cardTypeQuantity = CardDecks.deckCardQuantities_Gizeh;
                cardBack = CardBack.Gizeh;
                break;
            case "Ephese":
                cardTypeQuantity = CardDecks.deckCardQuantities_Ephese;
                cardBack = CardBack.Ephese;
                break;
            case "Rhodes":
                cardTypeQuantity = CardDecks.deckCardQuantities_Rhodes;
                cardBack = CardBack.Rhodes;
                break;
            case "Olympie":
                cardTypeQuantity = CardDecks.deckCardQuantities_Olympie;
                cardBack = CardBack.Olympie;
                break;
            case "Babylone":
                cardTypeQuantity = CardDecks.deckCardQuantities_Babylone;
                cardBack = CardBack.Babylone;
                break;
            case "Alexandrie":
                cardTypeQuantity = CardDecks.deckCardQuantities_Alexandrie;
                cardBack = CardBack.Alexandrie;
                break;
            case "Halicarnasse":
                cardTypeQuantity = CardDecks.deckCardQuantities_Halicarnasse;
                cardBack = CardBack.Halicarnasse;
        }
        this.deck = new ArrayList<>();
        for (CardDecks.CardTypeQuantity a : cardTypeQuantity) {
            for (int i = 0; i < a.quantity; i++) {
                deck.add(Game.makeCard(a.cardType, cardBack));
            }
        }
        Game.shuffleDeck(this.deck);
    }

    //On assigne au joueur la Merveille que ce dernier a choisi
    public void setWonder(String name) {
        switch (name) {
            case "Gizeh":
                this.wonder = new Gizeh();
                break;
            case "Ephese":
                this.wonder = new Ephese();
                break;
            case "Rhodes":
                this.wonder = new Rhodes();
                break;
            case "Olympie":
                this.wonder = new Olympie();
                break;
            case "Babylone":
                this.wonder = new Babylone();
                break;
            case "Alexandrie":
                this.wonder = new Alexandrie();
                break;
            case "Halicarnasse":
                this.wonder = new Halicarnasse();
                break;
        }
        SetDeck();
    }

    Wonder getWonder() {
        return this.wonder;
    }

    //les Actions effectuées par le joueur lorsque c'est son tour de jouer
    public void makeMove(Game game, int currentPlayer) {

        checkCardsIfHasCat();
        //TODO ChooseCard GUI
        Card chosenCard = Game.getFirstCard(game.centralDeck); //card from central deck
        //chosenCard = Game.getFirstCard(this.deck); //card from the left deck
        //chosenCard = Game.getFirstCard(players.get(currentPlayer + 1).deck); //card from the right deck

        if (chosenCard == null){
            //TODO GUI (inform user that there are no cards in the deck anymore)
        }
        else{
            chosenCard.apply(this);
        }
    }

    //le joueur "prend" le chat lorsqu'il tire une carte PoliticCard avec le symbole chat
    public void takeCat() {
        this.hasCat = true;
    }

    public void giveCat() {
        this.hasCat = false;
    }

    public void addVictoryPoints(int vp) {
        this.victoryPoints += vp;
    }

    //
    public Boolean addSymbolScience(ScienceCategory scienceCategory) {
        this.symbolsScience.put(scienceCategory, symbolsScience.get(scienceCategory) + 1);
        if (this.symbolsScience.containsValue(2)) {
            this.symbolsScience.put(scienceCategory, 0);
            return true;
        } else if (this.symbolsScience.values().stream().mapToInt(Integer::intValue).sum() == 3) {
            this.symbolsScience.replaceAll((key, value) -> 0);
            return true;
        }
        return false;
    }

    //le joueur choisit un Token qu'il utilise ensuite
    public void takeToken() {
        //TODO GUI
        ProgressToken.apply();
    }

    //Si le joueur Possède suffisamment de ressources pour construire la partie de sa Merveille,
    // construit la partie
    // Nous n'avons implémenter que le cas ou les matériaux nécesssaires à la création de la
    // partie doivent être différents, Nous avions commencé à travailler sur le cas ou les
    // ressources doivent être similaires mais nous n'avons pas eu le temps de finir
    public boolean hasEnoughResources() {
        Map<Integer, Integer> resourcesNeeded = this.wonder.parts.get(this.wonder.getLayer());
        if (resourcesNeeded.containsKey(0)|| resourcesNeeded.containsKey(-1)) {
            int differentResources = 0;
            if (this.resources.get(Material.Brick) != 0) {
                differentResources += 1;
            }
            if (this.resources.get(Material.Gold) != 0) {
                differentResources += 1;
            }
            if (this.resources.get(Material.Wood) != 0) {
                differentResources += 1;
            }
            if (this.resources.get(Material.Glass) != 0) {
                differentResources += 1;
            }
            if (this.resources.get(Material.Paper) != 0) {
                differentResources += 1;
            }
            if (this.resources.get(Material.Stone) != 0) {
                differentResources += 1;
            }

            List<Integer> keysResourcesNeeded = resourcesNeeded.keySet().stream().toList();
            System.out.println(keysResourcesNeeded);

            //List<Integer> keysResources = resources.keySet().stream().toList();


            for (int i= 0 ; i < resourcesNeeded.size();i++){
                if (differentResources == resourcesNeeded.get(keysResourcesNeeded.get(i)))
                {

                    resourcesNeeded.remove(keysResourcesNeeded.get(i));
                    build();
                    return true;
                }
            }

//            for (int i = 0 ; i < resourcesNeeded.size() ; i++){
//                if (differentResources == (Integer) resourcesNeeded.get(i)) {
//                    return true;
//                }
//            }

            return false;

        }
//        if (resourcesNeeded.containsKey(1)|| resourcesNeeded.containsKey(2)) {
//            if (this.resources.get(Material.Brick) == resourcesNeeded.get(1) || this.resources.get(Material.Brick) == resourcesNeeded.get(2)) {
//                return true;
//            }
//            if (this.resources.get(Material.Gold) == resourcesNeeded.get(1) || this.resources.get(Material.Gold) == resourcesNeeded.get(2)) {
//                return true;
//            }
//            if (this.resources.get(Material.Wood) == resourcesNeeded.get(1) || this.resources.get(Material.Wood) == resourcesNeeded.get(2)) {
//                return true;
//            }
//            if (this.resources.get(Material.Glass) == resourcesNeeded.get(1) || this.resources.get(Material.Glass) == resourcesNeeded.get(2)) {
//                return true;
//            }
//            if (this.resources.get(Material.Paper) == resourcesNeeded.get(1) || this.resources.get(Material.Paper) == resourcesNeeded.get(2)) {
//                return true;
//            }
//            if (this.resources.get(Material.Stone) == resourcesNeeded.get(1) || this.resources.get(Material.Stone) == resourcesNeeded.get(2)) {
//                return true;
//            }
//            else {
//                return false;
//            }
//        }
        return false;
    }

    //supprime les ressources utilisées pour construite l'étage de la Merveille
    public void build(){

        Map<Integer, Integer> resourcesNeeded = this.wonder.parts.get(this.wonder.getLayer());
        //if (resourcesNeeded.containsKey(0)|| resourcesNeeded.containsKey(-1)) {

            List<Material> keys = resources.keySet().stream().toList();
            System.out.println(keys);

            for (int i= 0 ; i < this.resources.size();i++){
                if (resources.get(keys.get(i)) > 0)
                    this.resources.put(keys.get(i) ,resources.get(keys.get(i))-1 );
            }
            this.wonder.SetCurrentLayer();
        //}

    }

    //Ajoute un bouclier au joueur lorsqu'il tire une carte spécifique
    public void addShields(boolean withoutHorns) {
        if(withoutHorns){
            this.shieldsWithoutHorns++;
        }
        else{
            this.shieldsWithHorns++;
        }
    }


    public int getShields(){
        return (this.shieldsWithHorns + this.shieldsWithoutHorns);
    }

    public void takeVictoryToken() {
        this.victoryPoints += 3;
    }

    private void checkCardsIfHasCat(){
        if(this.hasCat){
            //TODO GUI
        }
    }

    Card getFirstCard(){
        return this.deck.remove(0);
    }
}



