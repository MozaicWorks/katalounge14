package itake.potter;

import javax.money.Monetary;
import javax.money.MonetaryAmount;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Basket {

    private static final MonetaryAmount PRICE_PER_BOOK = Monetary.getDefaultAmountFactory().setNumber(8).setCurrency("EUR").create();

    private List<String> books;

    public Basket(List<String> books) {
        this.books = books;
    }

    private Map<Integer, Double> discounts = new HashMap<Integer, Double>() {{
        put(2, 0.95);
        put(3, 0.90);
        put(4, 0.80);
        put(5, 0.75);
    }};

    public MonetaryAmount calculateCost() {
        MonetaryAmount basicPrice = PRICE_PER_BOOK.multiply(books.size());

        int uniqueBookCount = new HashSet<>(books).size();
        Double discount = discounts.getOrDefault(uniqueBookCount, 1.0);
        return basicPrice.multiply(discount);
    }
}
