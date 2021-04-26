package guru.springframework.recipeapp.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@NoArgsConstructor

@Entity
public class Ingredient {

@Id
@GeneratedValue(strategy = IDENTITY)
private Long id;
private String description;
private BigDecimal amount;

@OneToOne(fetch = EAGER)
private UnitOfMeasure unitOfMeasure;

@ManyToOne
private Recipe recipe;

public Ingredient(String description, BigDecimal amount, UnitOfMeasure unitOfMeasure) {
    this.description = description;
    this.amount = amount;
    this.unitOfMeasure = unitOfMeasure;
}

public Ingredient(String description, BigDecimal amount, UnitOfMeasure unitOfMeasure, Recipe recipe) {
    this.description = description;
    this.amount = amount;
    this.unitOfMeasure = unitOfMeasure;
    this.recipe = recipe;
}
}
