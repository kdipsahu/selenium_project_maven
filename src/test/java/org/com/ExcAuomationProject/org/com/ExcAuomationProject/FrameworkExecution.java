package org.com.ExcAuomationProject.org.com.ExcAuomationProject;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;



public class FrameworkExecution {
  
	public void runReflectionMethod(String strClassName, String strMethodName, Object... inputArgs){
		
		int arg_lenth = inputArgs.length;
		Class<?> params[] = new Class[arg_lenth];

		for (int i = 0; i < arg_lenth; i++) {
			if (inputArgs[i] instanceof String) {
				params[i] = String.class;
			}
			else{
				params[i] = Integer.TYPE;
			}
		}
		
		try {
			Class<?> cls = Class.forName(strClassName);
			Object _instance = cls.newInstance();
			Method myMethod = cls.getDeclaredMethod(strMethodName, params);
			myMethod.invoke(_instance, inputArgs);

		} catch (ClassNotFoundException e) {
			System.err.format(strClassName + ":- Class not found%n");
		} catch (IllegalArgumentException e) {
			System.err
					.format("Method invoked with wrong number of arguments%n");
		} catch (NoSuchMethodException e) {
			System.err.format("In Class " + strClassName + "::" + strMethodName
					+ ":- method does not exists%n");
		} catch (InvocationTargetException e) {
			System.err.format("Exception thrown by an invoked method%n");
		} catch (IllegalAccessException e) {
			System.err
					.format("Can not access a member of class with modifiers private%n");
			e.printStackTrace();
		} catch (InstantiationException e) {
			System.err
					.format("Object cannot be instantiated for the specified class using the newInstance method%n");
		}
		
	}
}
