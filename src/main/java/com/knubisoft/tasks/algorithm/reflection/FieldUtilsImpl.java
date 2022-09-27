package com.knubisoft.tasks.algorithm.reflection;

import lombok.SneakyThrows;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class FieldUtilsImpl implements FieldUtils{
    @Override
    public Field getField(Class<?> cls, String fieldName) throws NoSuchFieldException {
        if (fieldName.isBlank() || cls == null) {
            throw new IllegalArgumentException();
        }
        return cls.getField(fieldName);
    }

    @Override
    public Field getField(Class<?> cls, String fieldName, boolean forceAccess) {
        return null;
    }

    @SneakyThrows
    @Override
    public Field getDeclaredField(Class<?> cls, String fieldName) {
        if (fieldName.isBlank() || cls == null) {
            throw new IllegalArgumentException();
        }
        return cls.getDeclaredField(fieldName);
    }

    @Override
    public Field[] getAllFields(Class<?> cls) {
        if(cls == null) {
            throw new IllegalArgumentException();
        }
        return cls.getDeclaredFields();
    }

    @Override
    public Field[] getFieldsWithAnnotation(Class<?> cls, Class<? extends Annotation> annotationCls) {
        List<Field> fieldsWithAnnotation = new ArrayList<>();
        if(cls == null || annotationCls == null) {
            throw new IllegalArgumentException();
        }
        for (Field f: cls.getDeclaredFields()) {
            if (f.isAnnotationPresent(annotationCls)) {
                fieldsWithAnnotation.add(f);
            }
        }
        return fieldsWithAnnotation.toArray(new Field[0]);
    }
}
