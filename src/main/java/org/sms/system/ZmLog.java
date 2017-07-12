package org.sms.system;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 日志
 * @author ZMZY
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface ZmLog {
	/**
	 * 日志信息内容
	 * @return
	 */
	String message();
	
	/**
	 * 定义自己的日志 业务实现类，否则将执行默认的实现类
	 * @return
	 */
	String aspectClass() default "";
}
