/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.more.hypha.beans.support;
import org.more.hypha.beans.define.PropertyType;
import org.more.hypha.beans.define.Simple_ValueMetaData;
import org.more.util.StringConvert;
/***
 * 工具类
 * @version 2010-11-11
 * @author 赵永春 (zyc@byshell.org)
 */
public class Util {
    public static Class<?> getType(String typeString) {
        //尝试转换成基本类型的枚举
        PropertyType typeEnum = (PropertyType) StringConvert.changeType(typeString, PropertyType.class);
        if (typeEnum != null)
            return Simple_ValueMetaData.getPropertyType(typeEnum);
        else
            return null;
    }
    public static Class<?> getType(String typeString, ClassLoader loader) throws ClassNotFoundException {
        //尝试转换成基本类型的枚举
        PropertyType typeEnum = (PropertyType) StringConvert.changeType(typeString, PropertyType.class);
        if (typeEnum != null)
            return Simple_ValueMetaData.getPropertyType(typeEnum);
        else
            return loader.loadClass(typeString);
    }
}