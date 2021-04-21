package guru.springframework.recipeapp.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.EnumType.STRING;
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

@Enumerated(value = STRING)
private Difficulty difficulty;

@OneToOne(cascade = ALL)
private Notes notes;

@OneToMany(cascade = ALL, mappedBy = "recipe")
private Set<Ingredient> ingredients;

@ManyToMany
@JoinTable(name = "recipe_category",
    joinColumns = @JoinColumn(name = "recipe_id"),
    inverseJoinColumns = @JoinColumn(name = "category_id"))
private Set<Category> categories;

}
