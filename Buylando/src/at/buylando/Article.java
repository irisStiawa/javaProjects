package at.buylando;

import java.util.Objects;

public class Article {
    public static int nextArticleID = 1;
    private int articleID;
    private String typ;
    private String brand;
    private String article;
    private Float price;
    private Float rating;

    public Article(String typ, String brand, String article, Float price, Float rating) {
        this.articleID = nextArticleID++;
        this.typ = typ;
        this.brand = brand;
        this.article = article;
        this.price = price;
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article1 = (Article) o;
        return articleID == article1.articleID && Objects.equals(getTyp(), article1.getTyp()) && Objects.equals(getBrand(), article1.getBrand()) && Objects.equals(getArticle(), article1.getArticle()) && Objects.equals(getPrice(), article1.getPrice()) && Objects.equals(getRating(), article1.getRating());
    }

    @Override
    public int hashCode() {
        return Objects.hash(articleID, getTyp(), getBrand(), getArticle(), getPrice(), getRating());
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }



    public String printAbleArticle(){
        return articleID + " " + typ + " " + brand + " " + article + ", Price: " + price + ", Rating: " + rating;
    }
}
