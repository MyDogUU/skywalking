/*
 * Copyright 2017, OpenSkywalking Organization All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Project repository: https://github.com/OpenSkywalking/skywalking
 */

package org.skywalking.apm.agent.core.plugin;

import org.skywalking.apm.agent.core.plugin.exception.IllegalPluginDefineException;
import org.skywalking.apm.util.StringUtil;

/**
 * 插件定义
 */
public class PluginDefine {

    /**
     * 插件名
     *
     * Plugin name.
     */
    private String name;

    /**
     * 插件定义类
     * {@link AbstractClassEnhancePluginDefine}
     *
     * The class name of plugin defined.
     */
    private String defineClass;

    private PluginDefine(String name, String defineClass) {
        this.name = name;
        this.defineClass = defineClass;
    }

    /**
     * 解析字符串，创建插件定义
     *
     * @param define 插件定义字符串，格式为 "${name}=${defineClass}"
     * @return 插件定义
     * @throws IllegalPluginDefineException 格式不正确
     */
    public static PluginDefine build(String define) throws IllegalPluginDefineException {
        if (StringUtil.isEmpty(define)) {
            throw new IllegalPluginDefineException(define);
        }

        String[] pluginDefine = define.split("=");
        if (pluginDefine.length != 2) {
            throw new IllegalPluginDefineException(define);
        }

        String pluginName = pluginDefine[0];
        String defineClass = pluginDefine[1];
        return new PluginDefine(pluginName, defineClass);
    }

    public String getDefineClass() {
        return defineClass;
    }
}


