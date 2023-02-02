package at.buylando;

import at.buylando.comparator.ComperatorPrice;
import at.buylando.comparator.ComperatorRating;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

public class OurArticles {
    private ArrayList<Article> articlesList = new ArrayList<>();

    public OurArticles() {

    }

    public ArrayList<Article> getArticlesList() {
        return articlesList;
    }

    public void setArticlesList(ArrayList<Article> articlesList) {
        this.articlesList = articlesList;
    }

    public void setArticle(Article article) {
        this.articlesList.add(article);
    }

    public Article getArticle(String typ, String brand, String article, Float price, Float rating) {
        for (Article a : this.articlesList) {
            if (a.getTyp().equals(typ) && a.getBrand().equals(brand) && a.getArticle().equals(article) && a.getPrice().equals(price) && a.getRating().equals(rating)) {
                return a;
            }
        }
        return null;
    }

    public boolean isArticleExisting(String typ, String brand, String article, Float price, Float rating) {

        for (Article a : this.articlesList) {
            if (a.getTyp().equals(typ) && a.getBrand().equals(brand) && a.getArticle().equals(article) && a.getPrice().equals(price) && a.getRating().equals(rating)) {
                return true;
            }
        }

        return false;
    }

    public ArrayList<Article> popularArticles() {
        ArrayList<Article> articles = new ArrayList<>();
        Collections.sort(this.articlesList, new ComperatorRating());

        for (int i = this.articlesList.size()-1; i > this.articlesList.size()-4; i--){
            articles.add(this.articlesList.get(i));
        }

        return articles;
    }




    public ArrayList<Article> mostExpensiveArticles() {
        ArrayList<Article> articles = new ArrayList<>();
        Collections.sort(this.articlesList, new ComperatorPrice());

        for (int i = this.articlesList.size()-1; i > this.articlesList.size()-4; i--){
            articles.add(this.articlesList.get(i));
        }

        return articles;
    }


}