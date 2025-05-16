package kg.aklimoff.spy.service.impl;

import kg.aklimoff.spy.dto.CategoryDto;
import kg.aklimoff.spy.entity.Category;
import kg.aklimoff.spy.repository.CategoryRepository;
import kg.aklimoff.spy.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryDto> getAllCategoryDtos() throws IOException {
        List<Category> categories = categoryRepository.findAll();
        return convertToDtoList(categories);
    }

    @Override
    public List<CategoryDto> getAllCategories() throws IOException {
        List<Category> categories = categoryRepository.findAll();
        return convertToDtoList(categories);
    }

    private CategoryDto convertToDto(
            Category category
    ) {
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

    private List<CategoryDto> convertToDtoList(
            List<Category> categories
    ) {
        return categories.stream().map(this::convertToDto).collect(Collectors.toList());
    }
}
