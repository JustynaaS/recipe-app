package guru.springframework.recipeapp.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@EqualsAndHashCode(exclude = "recipe")
@Entity
public class Notes {

@Id
@GeneratedValue(strategy = IDENTITY)
private Long id;

@OneToOne
private Recipe recipe;

@Lob
private String recipeNotes;
}
