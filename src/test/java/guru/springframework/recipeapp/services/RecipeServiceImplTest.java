package guru.springframework.recipeapp.services;

import guru.springframework.recipeapp.domain.Recipe;
import guru.springframework.recipeapp.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


class RecipeServiceImplTest {
RecipeServiceImpl recipeService;

@Mock
RecipeRepository recipeRepository;

@BeforeEach
void setUp() {
    MockitoAnnotations.openMocks(this);

    recipeService = new RecipeServiceImpl(recipeRepository);
}

@Test
void getRecipes() {
    Recipe recipe = new Recipe();
    HashSet recipesData = new HashSet();
    recipesData.add(recipe);
    when(recipeRepository.findAll()).thenReturn(recipesData);


    Set<Recipe> recipes = recipeService.getRecipes();

    assertEquals(1, recipes.size());
    verify(recipeRepository, times(1)).findAll();
}
}