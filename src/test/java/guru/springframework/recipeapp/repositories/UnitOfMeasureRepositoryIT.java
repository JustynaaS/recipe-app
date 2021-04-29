package guru.springframework.recipeapp.repositories;

import guru.springframework.recipeapp.domain.UnitOfMeasure;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class UnitOfMeasureRepositoryIT {

@Autowired
UnitOfMeasureRepository unitOfMeasureRepository;

@BeforeEach
void setUp() {
}

@Test
void findByDescription() {
    Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

    Assertions.assertEquals("Teaspoon", uomOptional.get().getDescription());
}

@Test
void findByDescriptionCup() {
    Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Cup");

    Assertions.assertEquals("Cup", uomOptional.get().getDescription());
}
}