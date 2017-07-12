package org.sms.core;

public abstract class BeanEntity implements Cloneable{

	@Override
	protected BeanEntity clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		BeanEntity cloneBean = null;
		
		try{
			cloneBean = (BeanEntity)super.clone();
			return cloneBean;
		}catch(Exception e){
			return cloneBean;
		}
	}
	
	public BeanEntity cloneEntity(){
		try{
			return this.clone();
		}catch(Exception e){
			return null;
			
		}
	}
}
