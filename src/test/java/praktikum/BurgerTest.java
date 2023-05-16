package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient1;

    @Mock
    private Ingredient ingredient2;

    private Burger burger;

    @Before
    public void setup() {
        burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
    }

    @Test
    public void getPriceTest() {
        when(bun.getPrice()).thenReturn(15.0f);
        when(ingredient1.getPrice()).thenReturn(750.65f);
        when(ingredient2.getPrice()).thenReturn(84.98f);
        assertEquals(865.63f, burger.getPrice(), 0.001f);
    }

    @Test
    public void getReceiptTest() {
        when(bun.getName()).thenReturn("Бриош");
        when(ingredient1.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient1.getName()).thenReturn("Говядина");
        when(ingredient2.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient2.getName()).thenReturn("Майонез");
        when(bun.getPrice()).thenReturn(15.0f);
        String expectedReceipt = "(==== Бриош ====)" + System.lineSeparator() +
                "= filling Говядина =" + System.lineSeparator() +
                "= sauce Майонез =" + System.lineSeparator() +
                "(==== Бриош ====)" + System.lineSeparator() + System.lineSeparator() +
                "Price: 30,000000" + System.lineSeparator();
        assertEquals(expectedReceipt, burger.getReceipt());

    }

    @Test
    public void removeIngredientTest() {
        burger.removeIngredient(1);
        assertEquals(1, burger.ingredients.size());
        assertEquals(ingredient1, burger.ingredients.get(0));
    }

    @Test
    public void moveIngredientTest() {
        burger.moveIngredient(0, 1);
        assertEquals(ingredient2, burger.ingredients.get(0));
        assertEquals(ingredient1, burger.ingredients.get(1));
    }

}
