package guru.springframework.recipeapp.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@EqualsAndHashCode(exclude = {"recipes"})
@Entity
public class Category {

@Id
@GeneratedValue(strategy = IDENTITY)
private Long id;

private String description;

@ManyToMany(mappedBy = "categories")
private Set<Recipe> recipes;
}
