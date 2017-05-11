package itake.potter;

import org.junit.Test;

import javax.money.Monetary;
import javax.money.MonetaryAmount;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.junit.Assert.assertEquals;

public class PurchasingScenario {

    @Test
    public void buyNothing() {
        Basket basket = new Basket(emptyList());

        assertEquals(inEuros(0), basket.calculateCost());
    }

    @Test
    public void buyOneBook() {
        Basket basket = new Basket(asList(Book.FIRST));

        assertEquals(inEuros(8), basket.calculateCost());
    }

    @Test
    public void buyTwoDifferentBooksYouGet5PercentDiscount() {
        Basket basket = new Basket(asList(Book.FIRST, Book.SECOND));

        assertEquals(inEuros(15.2), basket.calculateCost());
    }

    @Test
    public void buyTheSameBookTwice() {
        Basket basket = new Basket(asList(Book.FIRST, Book.FIRST));

        assertEquals(inEuros(16), basket.calculateCost());
    }

    @Test
    public void buyThreeDifferentBooksYouGet10PercentDiscount() {
        Basket basket = new Basket(asList(Book.FIRST, Book.SECOND, Book.THIRD));

        assertEquals(inEuros(21.6), basket.calculateCost());
    }

    @Test
    public void buyFourDifferentBooksYouGet20PercentDiscount() {
        Basket basket = new Basket(asList(Book.FIRST, Book.SECOND, Book.THIRD, Book.FOURTH));

        assertEquals(inEuros(25.6), basket.calculateCost());
    }

    @Test
    public void buyFiveDifferentBooksYouGet25PercentDiscount() {
        Basket basket = new Basket(asList(Book.FIRST, Book.SECOND, Book.THIRD, Book.FOURTH, Book.FIFTH));

        assertEquals(inEuros(30), basket.calculateCost());
    }

    private MonetaryAmount inEuros(double number) {
        return Monetary.getDefaultAmountFactory().setNumber(number).setCurrency("EUR").create();
    }
}
