package com.fullcycle.catalogo.application.category.delete;

import com.fullcycle.catalogo.application.UnitUseCase;
import com.fullcycle.catalogo.domain.category.CategoryGateway;

import static java.util.Objects.isNull;
import static java.util.Objects.requireNonNull;

public class DeleteCategoryUseCase extends UnitUseCase<String> {

    private final CategoryGateway categoryGateway;

    public DeleteCategoryUseCase(CategoryGateway categoryGateway) {
        this.categoryGateway = requireNonNull(categoryGateway);
    }

    @Override
    public void execute(final String anIn) {
        if (isNull(anIn)) {
            return;
        }

        this.categoryGateway.deleteById(anIn);
    }
}
