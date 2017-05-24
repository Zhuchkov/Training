package com.training.controller.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import com.training.model.annotation.MethodAnnotation;
import com.training.model.entity.Notebook;

public class Runner {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class clazz = Notebook.class;
		System.out.println("Class name: "+clazz.getName());
		
		System.out.println("Superclass name: "+clazz.getSuperclass());
		
		System.out.print("class modifiers:");
		int modifiers = clazz.getModifiers();
		System.out.println(Modifier.toString(modifiers));
		
		Constructor[] constructors = clazz.getConstructors();
		System.out.println("Constructors:");
		for(Constructor con :constructors){
			System.out.println("\t"+con);
		}
		System.out.println("Methods:");
		Method[] methods = clazz.getMethods();
		for(Method method: methods){
			System.out.println("\t"+method.toGenericString());//+", Annotations: "+method.getAnnotations()
			if(method.getAnnotations().length>0){
			System.out.println("\t\t annotations:");
			for(Annotation annotation:method.getAnnotations()){
				System.out.println("\t\t\t"+annotation.toString());
			}
		}
		}
		Constructor con = constructors[0];
		Object obj = con.newInstance("Notebook name",1400,4,1024,2048,19,10,4200);
		System.out.println("Annotated methods invocation:");
		for(Method method: methods){
			if (method.getAnnotation(MethodAnnotation.class) != null){
				System.out.println("\t"+method.getName()+" invocation: "+method.invoke(obj));
			}
			
		}
		Field[] fields = clazz.getDeclaredFields();
		System.out.println("Fields:");
		for(Field field : fields){
			System.out.println("\t"+field.toGenericString());
		}
		System.out.println("Superclass' fields:");
		for(Field field:clazz.getSuperclass().getDeclaredFields()){
			System.out.println("\t"+field.toGenericString());
		}
		
	}

}
