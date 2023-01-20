package unitTests;

import fr.isep.game7WonderArch.domain.ProgressTokens;
import fr.isep.game7WonderArch.domain.card.ScienceCategory;
import main.Game;
import main.Player;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static fr.isep.game7WonderArch.domain.ProgressTokens.TOKENS;

public class UnitTests {

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

    @Test
    public void testDoWar() {
        Game game = new Game(4);
        for (int i = 0; i < 4; i++){
            Game.addPlayer(new Player("", 0));
        }

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
        for (int i = 0; i < 5; i++){
            Game.addPlayer(new Player("", 0));
        }

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
}
