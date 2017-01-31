package test;

/**
 * Created by miha on 18.12.2016.
 */
public class FilterArticle{
    private Integer countLike;
    private Integer countPost;

    public FilterArticle(Integer countLike, Integer countPost) {
        this.countLike = countLike;
        this.countPost = countPost;
    }

    public Integer getCountLike() {
        return countLike;
    }

    public void setCountLike(Integer countLike) {
        this.countLike = countLike;
    }

    public Integer getCountPost() {
        return countPost;
    }

    public void setCountPost(Integer countPost) {
        this.countPost = countPost;
    }
}
