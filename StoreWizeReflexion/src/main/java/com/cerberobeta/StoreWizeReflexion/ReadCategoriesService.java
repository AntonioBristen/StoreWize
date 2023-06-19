package com.cerberobeta.StoreWizeReflexion;

import java.util.ArrayList;
import java.util.List;

public class ReadCategoriesService {


    public CategoryEntity getCategories()
    {

        CategoryEntity categoryEntity = new CategoryEntity();

        List<String> lista = new ArrayList<String>();
        lista.add("home");
        lista.add("jarden");
        lista.add("toys");

        String[] categories = new String[lista.size()];
        categories = lista.toArray(categories);

        categoryEntity.setCategorys(categories);

        return categoryEntity;
    }

    public String getCategorie()
    {

        String catClean = "jarden";

        return catClean;
    }
}
