package com.fullcycle.catalogo.application.category.save;

import com.fullcycle.catalogo.application.UseCase;
import com.fullcycle.catalogo.domain.category.Category;
import com.fullcycle.catalogo.domain.category.CategoryGateway;
import com.fullcycle.catalogo.domain.exceptions.NotificationException;
import com.fullcycle.catalogo.domain.validation.Error;
import com.fullcycle.catalogo.domain.validation.handler.Notification;

import static java.util.Objects.isNull;
import static java.util.Objects.requireNonNull;

public class SaveCategoryUseCase extends UseCase<Category, Category> {

    private final CategoryGateway categoryGateway;

    public SaveCategoryUseCase(final CategoryGateway categoryGateway) {
        this.categoryGateway = requireNonNull(categoryGateway);
    }

    @Override
    public Category execute(final Category aCategory) {
        if (isNull(aCategory)) {
            throw NotificationException.with(new Error("'aCategory' cannot be null"));
        }
        final var notification = Notification.create();
        aCategory.validate(notification);

        if (notification.hasError()) {
            throw NotificationException.with("Invalid category", notification);
        }
        return this.categoryGateway.save(aCategory);
    }
}
