package at.buylando.comparator;

import at.buylando.Article;

import java.util.Comparator;

public class ComperatorRating implements Comparator<Article> {
    @Override
    public int compare(Article a1, Article a2) {

        return a1.getRating().compareTo(a2.getRating());
    }
}
