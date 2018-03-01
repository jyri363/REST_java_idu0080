package ttu.idu0080.rest.data;
import java.util.*;
import javax.persistence.Column;  
import javax.persistence.Entity;  
import javax.persistence.Id;  
import javax.persistence.Table;  
import javax.persistence.GeneratedValue;  
import javax.persistence.GenerationType;  
import javax.persistence.JoinTable;  
import javax.persistence.ManyToMany;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Max;
import javax.validation.constraints.Digits;
import javax.validation.Valid;  
import javax.validation.constraints.Size;


@Entity
@Table(name="PAINTING")
public class Painting implements java.io.Serializable  {
	//painting ( id, artname, techniques, author, yea
	@Id  
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id ;
	private String artname ;
	private String techniques ;
	private String author ;
	private int year ;


	public Painting() {
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getArtname() {
		return artname;
	}


	public void setArtname(String artname) {
		this.artname = artname;
	}


	public String getTechniques() {
		return techniques;
	}


	public void setTechniques(String techniques) {
		this.techniques = techniques;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}



}
