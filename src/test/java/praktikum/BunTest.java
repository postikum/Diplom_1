package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class BunTest {

    private final String name;
    private final float price;
    private Bun bun;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Набор {index}, параметры: {0} - {1}")
    public static Collection<Object[]> getData() {
        return Arrays.asList(new Object[][]{
                {"Черная булочка", 100},
                {"Пирожок33", 0},
                {"маминаслааааааааааааааааааааааааааааааадость", -10},
                {null, (float) 0.7689500498789050987489},
                {":?*())_((**", 30},
        });
    }

    @Before
    public void setUp() {
        bun = new Bun(name, price);
    }

    @Test
    public void getNameBun() {
        Assert.assertEquals("Неверное имя", name, bun.getName());
    }

    @Test
    public void getPriceBun() {
        Assert.assertEquals("Неверная цена", price, bun.getPrice(), 0);
    }
}


