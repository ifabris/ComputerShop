package hr.algebra.computerShop.feature.category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(int id);
    Category saveCategory(Category category);

    Category updateCategory(int id, Category updatedCategory);
    void deleteCategory(int id);
}
