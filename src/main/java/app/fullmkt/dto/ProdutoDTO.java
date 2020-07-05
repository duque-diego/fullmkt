package app.fullmkt.dto;

public class ProdutoDTO {
    private int id;
    private String title;
    private String disccount;
    private String urlImage;

    public ProdutoDTO(int id, String title, String disccount, String urlImage) {
        this.id = id;
        this.title = title;
        this.disccount = disccount;
        this.urlImage = urlImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDisccount() {
        return disccount;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setDisccount(String disccount) {
        this.disccount = disccount;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
