package com.cerberobeta.StoreWize.services;

import com.cerberobeta.StoreWize.daos.CateoryDAO;
import com.cerberobeta.StoreWize.contextbeanfactory.registry.AdapterService;
import com.cerberobeta.StoreWize.entities.category.CategoryEntity;
import com.cerberobeta.StoreWize.utils.ConstantsUtil;
import com.cerberobeta.StoreWize.utils.ProcesUtil;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("category")
public class CategoryService implements AdapterService {
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

        return categoryEntity;
    }

    public void generateMDC()
    {
        String logId = ProcesUtil.generateRandomId();
        MDC.put(constantsUtil.TRACEID, logId);
        MDC.put(constantsUtil.SPANID, logId);
    }

}
