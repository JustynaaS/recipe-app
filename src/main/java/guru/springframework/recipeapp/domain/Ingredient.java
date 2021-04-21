package guru.springframework.recipeapp.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity
public class Ingredient {

@Id
@GeneratedValue(strategy = IDENTITY)
private Long id;
private String description;
private BigDecimal amount;

@ManyToOne
private Recipe recipe;
}
