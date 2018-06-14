/**
 * 
 */
package com.tz.day17;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

/**本类用来演示
 * @author 吴老师
 *
 * 2017年3月22日下午4:46:31
 */
@Retention(value=RUNTIME)
@Target(value={TYPE,METHOD})
public @interface Hello
{
	String value() default " ";
}

