package com.knubisoft.base.reflection;


import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class ReflectionTasksImpl implements ReflectionTasks {

    @Override
    public Object createNewInstanceForClass(Class<?> cls) {
        try {
            return cls.getDeclaredConstructor(String.class).newInstance("Vlad");
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public <T> Class<? extends T> findImplementationForInterface(Class<T> cls) {

        return null;
    }

    @Override
    public Map<String, Object> findAllFieldsForClass(Class<?> cls) {
        if (cls == null)
            throw new NoSuchElementException();
        HashMap<String, Object> map = new HashMap<>();
        Class sup = cls.getSuperclass();
        if (sup != null) {
            Field[] supfields = sup.getDeclaredFields();
            for (Field f : supfields) {
                f.setAccessible(true);
                try {
                    map.put(f.getName(), sup.getDeclaredField(f.getName()));
                } catch (NoSuchFieldException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        Field[] fields = cls.getDeclaredFields();
        for (Field f : fields) {
            f.setAccessible(true);
            try {
                map.put(f.getName(), cls.getDeclaredField(f.getName()));
            } catch (NoSuchFieldException e) {
                throw new RuntimeException(e);
            }
        }
        return map;
    }

    @Override
    public int countPrivateMethodsInClass(Class<?> cls) {
        int counter = 0;
        Method[] methods = cls.getDeclaredMethods();
        for (Method m : methods) {
            if (Modifier.isPrivate(m.getModifiers())) {
                counter++;
            }
        }
        return counter;
    }

    @Override
    public boolean isMethodHasAnnotation(Method method, Class<?> annotationUnderMethod) {

        Annotation[] annotations = method.getDeclaredAnnotations();
        if (annotations.length > 0)
            return true;
        return false;
    }

    @Override
    public Object evaluateMethodByName(Class<?> cls, String name) {

        return null;
    }

    @Override
    public Object evaluateMethodWithArgsByName(Object obj, String name, Object... args) {
        try {
            Method[] methods = obj.getClass().getDeclaredMethods();
            for (Method m: methods) {
                if (m.getName().equals(name))
                    return m.invoke(obj,args);
            }

        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Object changePrivateFieldValue(Object instance, String name, Object newValue) {
        try {
            Field field = instance.getClass().getDeclaredField(name);
            field.setAccessible(true);
            field.set(instance, newValue);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
