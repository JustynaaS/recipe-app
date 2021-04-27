package guru.springframework.recipeapp.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
public class Category {

@Id
@GeneratedValue(strategy = IDENTITY)
private Long id;

private String description;

@ManyToMany(mappedBy = "categories")
private Set<Recipe> recipes;
}
