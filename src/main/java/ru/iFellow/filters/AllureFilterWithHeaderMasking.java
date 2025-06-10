package ru.iFellow.filters;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class AllureFilterWithHeaderMasking implements Filter {
    private final AllureRestAssured delegate = new AllureRestAssured();

    @Override
    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext ctx) {

        String originalApiKey = null;

        // Если есть заголовок, сохраняем его и маскируем
        if (requestSpec.getHeaders().hasHeaderWithName("x-api-key")) {
            originalApiKey = requestSpec.getHeaders().getValue("x-api-key");
            requestSpec.removeHeader("x-api-key");
            requestSpec.header("x-api-key", "[BLACKLISTED]");
        }

        // Выполняем запрос через AllureRestAssured фильтр
        Response response = delegate.filter(requestSpec, responseSpec, ctx);

        // Восстанавливаем оригинальный заголовок (важно для повторного использования объекта запроса)
        if (originalApiKey != null) {
            requestSpec.removeHeader("x-api-key");
            requestSpec.header("x-api-key", originalApiKey);

        }
        return response;
    }
}
