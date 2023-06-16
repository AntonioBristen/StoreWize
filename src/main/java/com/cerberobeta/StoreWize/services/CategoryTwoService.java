package com.cerberobeta.StoreWize.services;

import com.cerberobeta.StoreWize.contextbeanfactory.registry.AdapterService;
import com.cerberobeta.StoreWize.daos.CateoryDAO;
import com.cerberobeta.StoreWize.entities.category.CategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service("categorytwo")
public class CategoryTwoService implements AdapterService {
    @Autowired
    private CateoryDAO cateoryDAO;

    @Override
    public CategoryEntity getCategories()
    {
        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.setCategorys(cateoryDAO.getCategories());

        List<String> oneCategori = new ArrayList<>();
        oneCategori = Arrays.asList(categoryEntity.getCategorys()[1]);

        String[] catClean = new String[oneCategori.size()];

        catClean = oneCategori.toArray(catClean);

        categoryEntity.setCategorys(catClean);

        return categoryEntity;
    }

}
