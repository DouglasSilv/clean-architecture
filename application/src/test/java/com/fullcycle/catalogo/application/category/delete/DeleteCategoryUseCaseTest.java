package com.fullcycle.catalogo.application.category.delete;

import com.fullcycle.catalogo.application.UseCaseTest;
import com.fullcycle.catalogo.domain.Fixture;
import com.fullcycle.catalogo.domain.category.CategoryGateway;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class DeleteCategoryUseCaseTest extends UseCaseTest {

    @InjectMocks
    private DeleteCategoryUseCase useCase;

    @Mock
    private CategoryGateway categoryGateway;

    @Test
    public void givenValidId_whenCallsDelete_shouldBeOk() {
        // given
        final var category = Fixture.Categories.aulas();
        final var expectedId = category.id();

        doNothing().when(this.categoryGateway).deleteById(anyString());

        // when
        assertDoesNotThrow(() -> this.useCase.execute(expectedId));

        // then
        verify(this.categoryGateway, times(1)).deleteById(expectedId);
    }

    @Test
    public void givenInvalidId_whenCallsDelete_shouldBeOk() {
        // given
        final String expectedId = null;

        // when
        assertDoesNotThrow(() -> this.useCase.execute(expectedId));

        // then
        verify(this.categoryGateway, never()).deleteById(expectedId);
    }
}
