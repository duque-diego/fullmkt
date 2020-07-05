package app.fullmkt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String title;
	private String disccount;
	private String urlImage;

	protected Produto() {}

	public Produto(Long id, String title, String disccount, String urlImage) {
		this.id = id;
		this.title = title;
		this.disccount = disccount;
		this.urlImage = urlImage;
	}

	@Override
	public String toString() {
		return "Produto{" +
				"id=" + id +
				", title='" + title + '\'' +
				", disccount='" + disccount + '\'' +
				", urlImage='" + urlImage + '\'' +
				'}';
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDisccount() {
		return disccount;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDisccount(String disccount) {
		this.disccount = disccount;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
}
