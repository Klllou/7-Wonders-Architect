package unitTests;

import fr.isep.game7WonderArch.domain.card.ScienceCategory;
import main.Player;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTests {

    @Test
    public void testAddSymbolScience() {
        Player player = new Player();
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
}
