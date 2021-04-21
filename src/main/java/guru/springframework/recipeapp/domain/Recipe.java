package guru.springframework.recipeapp.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity
public class Recipe {
@Id
@GeneratedValue(strategy = IDENTITY)
private Long id;

private String description;
private Integer preTime;
private Integer cookTime;
private Integer servings;
private String source;
private String url;
private String directions;

@Lob
private Byte[] image;

@OneToOne(cascade = ALL)
private Notes notes;

}
