package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final Ingredient ingredient;
    private final float expectedPrice;

    public IngredientTest(Ingredient ingredient, float expectedPrice) {
        this.ingredient = ingredient;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new Ingredient(IngredientType.SAUCE, "Томатный соус", 15.5f), 15.5f},
                {new Ingredient(IngredientType.FILLING, "Грибы", 10.0f), 10.0f},
        });
    }

    @Test
    public void getPriceTest() {
        assertEquals(expectedPrice, ingredient.getPrice(), 0.001f);
    }

    @Test
    public void getNameTest() {
        assertEquals(ingredient.getName(), ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        assertEquals(ingredient.getType(), ingredient.getType());
    }
}

