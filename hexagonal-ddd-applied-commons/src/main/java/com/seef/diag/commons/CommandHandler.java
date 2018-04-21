package com.seef.diag.commons;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by David on 19/03/2017.
 */

public interface CommandHandler<T extends DomainCommand> {
     void handle(T command);
     default Class<T> handles(){
          Class clazz = getClass();
          ParameterizedType parameterizedType = (ParameterizedType) clazz.getGenericInterfaces()[0];
          Type[] typeArguments = parameterizedType.getActualTypeArguments();
          return (Class<T>) typeArguments[0];
     }
}
