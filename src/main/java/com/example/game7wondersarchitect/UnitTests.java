package com.example.game7wondersarchitect;

import fr.isep.game7WonderArch.domain.card.*;
import fr.isep.game7WonderArch.domain.wonder.Gizeh;
import main.Game;
import main.Player;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

//import java.util.Collections;


public class UnitTests {


//    @Test
//    public void testPlay() {
//        Game game = new Game(4);
//        setPlayers(4);
//        game.play();
//    }


    //Test pour voir si les "SymbolScience" sont bien supprimés dès que le joueur sélectionne un ProgressToken
    @Test
    public void testAddSymbolScience() {
        Player player = new Player("Fares", 42);
        System.out.println(player.symbolsScience);
        Assert.assertFalse(player.addSymbolScience(ScienceCategory.Law));
        System.out.println(player.symbolsScience);
        Assert.assertTrue(player.addSymbolScience(ScienceCategory.Law));
        System.out.println(player.symbolsScience);

        Assert.assertFalse(player.addSymbolScience(ScienceCategory.Law));
        System.out.println(player.symbolsScience);
        Assert.assertFalse(player.addSymbolScience(ScienceCategory.Architect));
        System.out.println(player.symbolsScience);
        Assert.assertTrue(player.addSymbolScience(ScienceCategory.Mechanic));
        System.out.println(player.symbolsScience);

        Assert.assertFalse(player.addSymbolScience(ScienceCategory.Law));
        System.out.println(player.symbolsScience);
        Assert.assertFalse(player.addSymbolScience(ScienceCategory.Architect));
        System.out.println(player.symbolsScience);
        Assert.assertTrue(player.addSymbolScience(ScienceCategory.Law));
        System.out.println(player.symbolsScience);

        //Architect
        Assert.assertTrue(player.addSymbolScience(ScienceCategory.Architect));
        System.out.println(player.symbolsScience);

    }

    //Pour définir le nombre de joueur pour chaque test
    void setPlayers(int n){
        for (int i = 0; i < n; i++){
            Game.addPlayer(new Player("", 0));
        }

    }

    //
//    @Test
//    public void testSetWonder(){
//        Player player = new Player("", 0);
//        player.setWonder("Olympie");
//        player = new Player("", 0);
//        player.setWonder("Alexandrie");
//        player = new Player("", 0);
//        player.setWonder("Babylone");
//        player = new Player("", 0);
//        player.setWonder("Ephese");
//        player = new Player("", 0);
//        player.setWonder("Gizeh");
//        player = new Player("", 0);
//        player.setWonder("Halicarnasse");
//        player = new Player("", 0);
//        player.setWonder("Rhodes");
//
//    }

    //Vérifie le fonctionnement des Combats, la vérification du nombre
    //de boucliers puis l'assignation des Points de Victoire
    @Test
    public void testDoWar() {
        Game game = new Game(4);
        setPlayers(4);

        for(int i = 0; i < 4; i++){
            Game.players.get(0).addShields(false);
        }
        for(int i = 0; i < 3; i++){
            Game.players.get(1).addShields(false);
        }
        for(int i = 0; i < 2; i++){
            Game.players.get(2).addShields(false);
        }
        for(int i = 0; i < 3; i++){
            Game.players.get(3).addShields(false);
        }

        Game.doWar();

        Assert.assertEquals(Game.players.get(0).victoryPoints, 2*3);
        Assert.assertEquals(Game.players.get(1).victoryPoints, 1*3);
        Assert.assertEquals(Game.players.get(2).victoryPoints, 0*3);
        Assert.assertEquals(Game.players.get(3).victoryPoints, 1*3);

        Game.end();
        game = new Game(5);
        setPlayers(5);

        for(int i = 0; i < 4; i++){
            Game.players.get(0).addShields(false);
        }
        for(int i = 0; i < 3; i++){
            Game.players.get(1).addShields(false);
        }
        for(int i = 0; i < 2; i++){
            Game.players.get(2).addShields(false);
        }
        for(int i = 0; i < 3; i++){
            Game.players.get(3).addShields(false);
        }
        for(int i = 0; i < 5; i++){
            Game.players.get(4).addShields(false);
        }

        Game.doWar();

        Assert.assertEquals(Game.players.get(0).victoryPoints, 1*3);
        Assert.assertEquals(Game.players.get(1).victoryPoints, 1*3);
        Assert.assertEquals(Game.players.get(2).victoryPoints, 0*3);
        Assert.assertEquals(Game.players.get(3).victoryPoints, 1*3);
        Assert.assertEquals(Game.players.get(4).victoryPoints, 2*3);

    }

//    @Test
//    public void enoughResources(){
//        Game game = new Game(2);
//        setPlayers(2);
////        List<Card> deck = Game.players.get(0).deck;
////        for (int i=0; i<deck.size(); i++){
////            if (deck.get(0).type == CardType.CardMaterialBrick);
////        }
//        Game.players.get(0).setWonder("Gizeh");
//        Game.players.get(1).setWonder("Alexandrie");
//
//        Card card = new MaterialCard(CardType.CardMaterialWood, CardBack.Gizeh);
//        card.apply(Game.players.get(0));
//        Assert.assertFalse(Game.players.get(0).hasEnoughResources());
//        card = new MaterialCard(CardType.CardMaterialGlass, CardBack.Gizeh);
//        card.apply(Game.players.get(0));
//
//        Assert.assertTrue(
//                Game.players.get(0).hasEnoughResources()
//        );
//    }

    //Test de l'application des Cartes Matérielles, pour vérifier si elles permettent
    // bien au joueur de construire sa Merveille par la suite
    @Test
    public void testApplyMaterialCard(){
        Game game = new Game(2);
        setPlayers(1);
        Game.players.get(0).setWonder("Gizeh");

        Card card = new MaterialCard(CardType.CardMaterialWood, CardBack.Gizeh);
        card.apply(Game.players.get(0));
        Assert.assertFalse(Game.players.get(0).hasEnoughResources());
        card = new MaterialCard(CardType.CardMaterialGlass, CardBack.Gizeh);
        card.apply(Game.players.get(0));

        Assert.assertEquals(4, Game.players.get(0).wonder.parts.size());



    }

}