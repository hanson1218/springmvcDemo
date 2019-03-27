package com.snow.www.init;

import org.springframework.beans.factory.FactoryBean;

public class FactoryBeanTest<T> implements FactoryBean<T>{
	
	private Class<T> test;
	@Override
	public T getObject() throws Exception {
		return test.newInstance();
	}

	@Override
	public Class<?> getObjectType() {
		return this.test;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

	public Class<T> getTest() {
		return test;
	}

	public void setTest(Class<T> test) {
		this.test = test;
	}
	
	

}
