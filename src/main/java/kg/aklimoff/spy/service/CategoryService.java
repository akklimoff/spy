package kg.aklimoff.spy.service;

import kg.aklimoff.spy.dto.CategoryDto;

import java.io.IOException;
import java.util.List;

public interface CategoryService {
    List<CategoryDto> getAllCategoryDtos() throws IOException;

    List<CategoryDto> getAllCategories() throws IOException;
}
