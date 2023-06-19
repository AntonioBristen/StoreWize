package com.cerberobeta.StoreWizeReflexion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ReadCategoriesService {

    @Autowired
    ReadCategoriesDAO readCategoriesDAO;

    public CategoryEntity getCategories(int val)
    {

        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.setCategorys(readCategoriesDAO.getCategories());

        return categoryEntity;
    }

    public String getCategorie(String val)
    {

        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.setCategorys(readCategoriesDAO.getCategories());

        String catClean = "undefined";

        catClean = categoryEntity.getCategorys()[0];

        return catClean;
    }
}
