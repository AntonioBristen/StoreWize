package com.cerberobeta.StoreWizeReflexion;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ReadCategoriesDAO {
    RestTemplate restTemplate = new RestTemplate();
    public final String urlcategories = "https://fakestoreapi.com/products/categories";

    public String[] getCategories()
    {
        String[] category = restTemplate.getForObject(urlcategories, String[].class);
        return category;
    }
}
