package com.cerberobeta.StoreWizeReflexion;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ServiceReflexion {


    public ResultReflexionEntity processReflexion(ReadCategoriesService cla, final String me)
    {
        ResultReflexionEntity resultRelexionEntity = new ResultReflexionEntity();
        try
        {
            Class<? extends ReadCategoriesService> ob = cla.getClass();
            Method met = ob.getMethod(me);

            resultRelexionEntity.setMethod(met.getName());
            resultRelexionEntity.setParams(met.getParameterCount());
            resultRelexionEntity.setPub(Modifier.isPublic(met.getModifiers()));
            resultRelexionEntity.setPriv(Modifier.isPrivate(met.getModifiers()));
            resultRelexionEntity.setTypeReturn(met.getGenericReturnType().getTypeName());
            Object obj = met.invoke(cla);

            if(met.getName().equals("getCategories"))
            {
                if(obj instanceof CategoryEntity) {
                    resultRelexionEntity.setCategories((CategoryEntity) obj);
                    resultRelexionEntity.setCategory("Undefined");
                }
            }else
            {
                if(obj instanceof String) {
                    resultRelexionEntity.setCategory((String) obj);
                }
            }
        }catch(NoSuchMethodException ex) {
            ex.printStackTrace();
        } catch (InvocationTargetException ex) {
            throw new RuntimeException(ex);
        } catch (IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }

        return resultRelexionEntity;
    }
}
