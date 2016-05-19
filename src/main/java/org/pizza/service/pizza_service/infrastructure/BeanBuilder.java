package org.pizza.service.pizza_service.infrastructure;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BeanBuilder {
	Class<?> clazz;
	private ApplicationContext applicationContext;
	Object bean;
	Object proxyBean;

	public BeanBuilder(Class<?> clazz, ApplicationContext ac) {
		this.clazz = clazz;
		applicationContext = ac;
	}

	public void createBean() throws Exception {
		createBean(clazz);
		
	}

	public void createBeanProxy() {
		if (!isThereAnnotationBenchMark()) return;
		
		ClassLoader cl = this.getClass().getClassLoader();
		Class<?>[] interfaces = clazz.getInterfaces();
		InvocationHandler ih = new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				
				Method methodOfBean = clazz.getMethod(method.getName(), method.getParameterTypes());
				
				if (methodOfBean.isAnnotationPresent(BenchMark.class)) {
					long time = System.currentTimeMillis();
					Object result = method.invoke(bean, args);
					time = System.currentTimeMillis() - time;
					System.out.println("Object " + clazz.getSimpleName() + ", Method " + method.getName() + ": " + time + "millisecconds.");
					return result;
				} else {
					return method.invoke(bean, args);
				}
			}			
		};
		
		proxyBean = Proxy.newProxyInstance(cl, interfaces, ih);
		
	}

	private boolean isThereAnnotationBenchMark() {
		Method[] methods = clazz.getMethods();
		for (Method m : methods) {
			if (m.getAnnotation(BenchMark.class) != null) {
				return true;
			}
		}
		return false;
	}
	
	public void callPostConstructor() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method[] methods = clazz.getMethods();
		for (Method m : methods) {
			if (m.getAnnotation(PostConstruct.class) != null) {
				m.invoke(bean);
			}
		}
		
	}

	public void callInitMethod() throws Exception {
		Method[] methods = clazz.getMethods();
		for (Method m : methods) {
			if (m.getName().equals("init")) {
				m.invoke(bean);
			}
		}
		
	}

	public Object build() {
		if (proxyBean != null) return proxyBean;
		return bean;
	}

	
	Object createBean(Class<?> clazz) throws Exception {
		Constructor<?> constructor = clazz.getConstructors()[0];
		Class<?>[] paramTypes = constructor.getParameterTypes();
		if (paramTypes.length == 0) {
			bean = clazz.newInstance();
		} else {
			bean = createNewInstanceWithParams(constructor);
		}
		return bean;
	}

	private Object createNewInstanceWithParams(Constructor<?> constructor) throws Exception {
		Object[] paramBeans = getParams(constructor);
		return constructor.newInstance(paramBeans);
	}
	
	private String getBeanNameByType(Class<?> paramType) {
		String paramName = paramType.getSimpleName();
		paramName = Character.toLowerCase(paramName.charAt(0)) + paramName.substring(1);
		return paramName;
	}

	private Object[] getParams(Constructor<?> constructor) throws Exception {
		Class<?>[] paramTypes = constructor.getParameterTypes();
		Object[] paramBeans = new Object[paramTypes.length];
		for (int i = 0; i < paramTypes.length; i++) {
			paramBeans[i] = getBeanByType(paramTypes[i]);
		}
		return paramBeans;
	}
	
	private Object getBeanByType(Class<?> paramType) throws Exception {
		return applicationContext.getBean(getBeanNameByType(paramType));
	}

}
