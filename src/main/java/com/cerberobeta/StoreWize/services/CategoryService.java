package com.cerberobeta.StoreWize.services;

import com.cerberobeta.StoreWize.daos.CateoryDAO;
import com.cerberobeta.StoreWize.contextbeanfactory.registry.AdapterService;
import com.cerberobeta.StoreWize.entities.category.CategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("category")
public class CategoryService implements AdapterService {
    @Autowired
    private CateoryDAO cateoryDAO;

    @Override
    public CategoryEntity getCategories()
    {
        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.setCategorys(cateoryDAO.getCategories());

        return categoryEntity;
    }

}
