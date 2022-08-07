package gifts;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.List;

public class GiftFactoryTests {

    private static final String TYPE = "Big";
    private static final double MAGIC = 5.00;


    private Gift gift;
    private GiftFactory giftFactory;

    @Before
    public void setUp() {
        gift = new Gift(TYPE, MAGIC);
        giftFactory = new GiftFactory();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void test_GetAnimals_ShouldReturn_UnmodifiableList() {
        Collection<Gift> presents = giftFactory.getPresents();
        presents.remove(1);
    }

    @Test
    public void test_GetCount_ShouldReturnZero_WhenEmpty_And_One_When_SingleAnimalAdded() {
        Assert.assertEquals(0, giftFactory.getCount());
        giftFactory.createGift(gift);
        Assert.assertEquals(1, giftFactory.getCount());
    }

    @Test
    public void test_GetCount() {
        Assert.assertEquals(0, giftFactory.getCount());
        giftFactory.createGift(gift);
        Assert.assertEquals(1, giftFactory.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_CreateGift_ShouldThrow_ForExistsGift() {
        giftFactory.createGift(gift);
        Gift gift1 = new Gift(TYPE, 10.00);
        giftFactory.createGift(gift1);
    }

    @Test(expected = NullPointerException.class)
    public void test_RemoveGift_ShouldThrow_ForNull() {
        giftFactory.removeGift(null);
        giftFactory.removeGift("     ");
    }

    @Test
    public void test_RemoveGift_ShouldRemoveSuccess() {
        Assert.assertEquals(0, giftFactory.getCount());
        giftFactory.createGift(gift);
        Assert.assertEquals(1, giftFactory.getCount());
        giftFactory.removeGift(TYPE);
        Assert.assertEquals(0, giftFactory.getCount());
    }

    @Test
    public void test_GetPresentWithLeastMagic_ReturnGift() {
        Gift gift1 = new Gift("Small", 4.00);
        giftFactory.createGift(gift);
        giftFactory.createGift(gift1);

        Gift actual = giftFactory.getPresentWithLeastMagic();

        Assert.assertEquals(gift1, actual);
    }

    @Test
    public void test_GetPresentWithLeastMagic_ReturnNull() {
        Gift actual = giftFactory.getPresentWithLeastMagic();
        Assert.assertNull(actual);
    }

    @Test
    public void test_GetPresent_ByType_Return_Present() {
        Gift gift1 = new Gift("Small", 4.00);
        giftFactory.createGift(gift);
        giftFactory.createGift(gift1);

        Gift present = giftFactory.getPresent(TYPE);

        Assert.assertEquals(present,gift);
    }

    @Test
    public void test_GetPresent_ByType_Return_Null() {
        Gift present = giftFactory.getPresent(TYPE);
        Assert.assertNull(present);
    }
}
