package test;

/**
 * Created by miha on 24.11.2016.
 */
public class Article {
    private String article;
    private String[] images;
    public Article(){}
    public Article(String article, String[] images) {
        this.article = article;
        this.images = images;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }
}
