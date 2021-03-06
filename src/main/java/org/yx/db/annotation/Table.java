package org.yx.db.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Table {
	/**
	 * 表名。为空时，就是小写的类名
	 */
	String value() default "";

	/**
	 * 在缓存中保留的时间,单位秒。0表示使用全局设置，小于0表示不过期
	 * 
	 * @return
	 */
	int duration() default 0;

	/**
	 * 为空使用类名，一般使用默认就好
	 * 
	 * @return
	 */
	String preInCache() default "";

	/**
	 * 访问多少次之后刷新缓存，0表示使用全局默认，小于0表示不刷新
	 */
	int maxBeats() default 0;

	/**
	 * 主键缓存都是SINGLE，外键缓存一般用LIST
	 * 
	 * @return
	 */
	CacheType cacheType() default CacheType.SINGLE;
}
