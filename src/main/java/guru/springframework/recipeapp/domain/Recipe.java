package guru.springframework.recipeapp.domain;

import lombok.Data;

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
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
public class Recipe {
@Id
@GeneratedValue(strategy = IDENTITY)
private Long id;

private String description;
private Integer prepTime;
private Integer cookTime;
private Integer servings;
private String source;
private String url;

@Lob
private String directions;

@Lob
private Byte[] image;

@Enumerated(value = STRING)
private Difficulty difficulty;

@OneToOne(cascade = ALL)
private Notes notes;

@OneToMany(cascade = ALL, mappedBy = "recipe")
private Set<Ingredient> ingredients = new HashSet<>();

@ManyToMany
@JoinTable(name = "recipe_category",
    joinColumns = @JoinColumn(name = "recipe_id"),
    inverseJoinColumns = @JoinColumn(name = "category_id"))
private Set<Category> categories = new HashSet<>();

public void setNotes(Notes notes) {
    this.notes = notes;
    notes.setRecipe(this);
}

public Recipe addIngredient(Ingredient ingredient) {
    ingredient.setRecipe(this);
    this.ingredients.add(ingredient);
    return this;
}
}
