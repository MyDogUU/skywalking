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

package org.skywalking.apm.collector.storage.table.register;

import org.skywalking.apm.collector.core.data.Column;
import org.skywalking.apm.collector.core.data.Data;
import org.skywalking.apm.collector.core.data.operator.CoverOperation;
import org.skywalking.apm.collector.core.data.operator.NonOperation;

/**
 * 应用实例
 *
 * @author peng-yongsheng
 */
public class Instance extends Data {

    private static final Column[] STRING_COLUMNS = {
        new Column(InstanceTable.COLUMN_ID, new NonOperation()),
        new Column(InstanceTable.COLUMN_AGENT_UUID, new CoverOperation()),
        new Column(InstanceTable.COLUMN_OS_INFO, new CoverOperation()),
    };

    private static final Column[] LONG_COLUMNS = {
        new Column(InstanceTable.COLUMN_REGISTER_TIME, new CoverOperation()),
        new Column(InstanceTable.COLUMN_HEARTBEAT_TIME, new CoverOperation()),
    };
    private static final Column[] DOUBLE_COLUMNS = {};
    private static final Column[] INTEGER_COLUMNS = {
        new Column(InstanceTable.COLUMN_APPLICATION_ID, new CoverOperation()),
        new Column(InstanceTable.COLUMN_INSTANCE_ID, new CoverOperation()),
    };

    private static final Column[] BOOLEAN_COLUMNS = {};
    private static final Column[] BYTE_COLUMNS = {};

    public Instance(String id) {
        super(id, STRING_COLUMNS, LONG_COLUMNS, DOUBLE_COLUMNS, INTEGER_COLUMNS, BOOLEAN_COLUMNS, BYTE_COLUMNS);
    }

    public String getId() {
        return getDataString(0);
    }

    public int getApplicationId() {
        return getDataInteger(0);
    }

    public void setApplicationId(Integer applicationId) {
        setDataInteger(0, applicationId);
    }

    public String getAgentUUID() {
        return getDataString(1);
    }

    public void setAgentUUID(String agentUUID) {
        setDataString(1, agentUUID);
    }

    public long getRegisterTime() {
        return getDataLong(0);
    }

    public void setRegisterTime(Long registerTime) {
        setDataLong(0, registerTime);
    }

    public int getInstanceId() {
        return getDataInteger(1);
    }

    public void setInstanceId(Integer instanceId) {
        setDataInteger(1, instanceId);
    }

    public long getHeartBeatTime() {
        return getDataLong(1);
    }

    public void setHeartBeatTime(Long heartBeatTime) {
        setDataLong(1, heartBeatTime);
    }

    public String getOsInfo() {
        return getDataString(2);
    }

    public void setOsInfo(String osInfo) {
        setDataString(2, osInfo);
    }
}
