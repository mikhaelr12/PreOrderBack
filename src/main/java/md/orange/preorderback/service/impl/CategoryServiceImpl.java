package md.orange.preorderback.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import md.orange.preorderback.dto.CategoryDTO;
import md.orange.preorderback.entity.Category;
import md.orange.preorderback.repository.CategoryRepository;
import md.orange.preorderback.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryDTO> getAllCategories() {
        log.info("Try to get all categories");
        List<Category> categories = categoryRepository.findAll();
        log.info("Found {} categories", categories.size());
        return categories.stream()
                .map(category -> CategoryDTO.builder()
                        .id(category.getId())
                        .categoryName(category.getCategoryName())
                        .build()
                ).collect(Collectors.toList());
    }
}
