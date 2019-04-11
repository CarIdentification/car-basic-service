package com.discern.car.util;

import com.esotericsoftware.reflectasm.ConstructorAccess;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.cglib.beans.BeanCopier;

/**
 * 类描述 :
 *
 * @Author JoeyTsai
 * @Time 11/04/2019
 */
public class BeanUtil {
    private static final Map<String, BeanCopier> BEAN_COPIER_CACHE = Maps.newConcurrentMap();
    private static final Map<String, ConstructorAccess> CONSTRUCTOR_ACCESS_CACHE = Maps.newConcurrentMap();

    /**
     * @param source 源对象
     * @param target 目标对象类
     * @return T
     * @description 类对象之间转换, 注：useConverter= false
     */
    public static <T> T copy(Object source, Class<T> target) {
        T result = null;
        if (source != null) {
            ConstructorAccess<T> constructorAccess = getConstructorAccess(target);
            result = constructorAccess.newInstance();

            BeanCopier beanCopier = getBeanCopier(source.getClass(), target);
            beanCopier.copy(source, result, null);
        }
        return result;
    }

    /**
     * @param source 源对象
     * @param target 目标对象类
     * @return T
     * @description 类对象之间转换, 注：useConverter= false
     */
    public static <T> T copyByGson(Object source, Class<T> target) {
        String gson = GsonUtil.toJsonSerializingNull(source);
        T result = GsonUtil.fromJsonSerializingNull(gson,target);
        return result;
    }

    /**
     * @param sourceList 源对象
     * @param target 目标对象类
     * @return T
     * @description 类对象之间转换, 注：useConverter= false
     */
    public static <T> List<T> copyByGson(List<?> sourceList, Class<T> target) {
        return sourceList.stream().map(val->copyByGson(val,target)).collect(Collectors.toList());
    }

    /**
     * @param sourceList 源对象
     * @param target 目标对象类
     * @description List对象之间转换, 注：useConverter= false
     */
    public static <T> List<T> copy(List<?> sourceList, Class<T> target) {
        if (CollectionUtils.isEmpty(sourceList)) {
            return Lists.newArrayList();
        }

        List<T> result = Lists.newArrayListWithCapacity(sourceList.size());
        for (Object object : sourceList) {
            T clone = copy(object, target);

            result.add(clone);
        }

        return result;
    }
    /**
     * @param source 源对象
     * @param target 目标对象类
     * @return T
     * @description 类对象之间转换, 注：useConverter= false
     */
    public static <T> T copyProperties(Object source, Class<T> target) {
        T result = null;
        if (source != null) {
            ConstructorAccess<T> constructorAccess = getConstructorAccess(target);
            result = constructorAccess.newInstance();
            BeanUtils.copyProperties(source,result);
        }
        return result;
    }

    /**
     * @description 获取构造器
     */
    private static <T> ConstructorAccess<T> getConstructorAccess(Class<T> targetClass) {
        ConstructorAccess<T> constructorAccess = CONSTRUCTOR_ACCESS_CACHE.get(targetClass.toString());
        if (constructorAccess != null) {
            return constructorAccess;
        }

        try {
            constructorAccess = ConstructorAccess.get(targetClass);
            CONSTRUCTOR_ACCESS_CACHE.putIfAbsent(targetClass.toString(), constructorAccess);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return constructorAccess;
    }

    /**
     * @return BeanCopier
     * @description 获取BeanCopier
     */
    private static BeanCopier getBeanCopier(Class<?> source, Class<?> target) {
        String beanCopierKey = generateBeanKey(source, target);
        if (BEAN_COPIER_CACHE.containsKey(beanCopierKey)) {
            return BEAN_COPIER_CACHE.get(beanCopierKey);
        } else {
            BeanCopier beanCopier = BeanCopier.create(source, target, false);
            BEAN_COPIER_CACHE.putIfAbsent(beanCopierKey, beanCopier);
        }
        return BEAN_COPIER_CACHE.get(beanCopierKey);
    }

    /**
     * @return String
     * @description 生成两个类的key
     */
    private static String generateBeanKey(Class<?> source, Class<?> target) {
        return source.getName() + "#" + target.getName();
    }

}
