package com.cerberobeta.StoreWize.services;

import com.cerberobeta.StoreWize.contextbeanfactory.registry.AdapterService;
import com.cerberobeta.StoreWize.daos.CateoryDAO;
import com.cerberobeta.StoreWize.entities.category.CategoryEntity;
import com.cerberobeta.StoreWize.utils.ConstantsUtil;
import com.cerberobeta.StoreWize.utils.ProcesUtil;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service("categoryone")
public class CategoryOneService implements AdapterService {
    @Autowired
    private CateoryDAO cateoryDAO;

    @Autowired
    ConstantsUtil constantsUtil;

    @Override
    public CategoryEntity getCategories()
    {
        this.generateMDC();

        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.setCategorys(cateoryDAO.getCategories());

        List<String> oneCategori = new ArrayList<>();
        oneCategori = Arrays.asList(categoryEntity.getCategorys()[0]);

        String[] catClean = new String[oneCategori.size()];

        catClean = oneCategori.toArray(catClean);

        categoryEntity.setCategorys(catClean);

        return categoryEntity;
    }

    public void generateMDC()
    {
        String logId = ProcesUtil.generateRandomId();
        MDC.put(constantsUtil.TRACEID, logId);
        MDC.put(constantsUtil.SPANID, logId);
    }

}
