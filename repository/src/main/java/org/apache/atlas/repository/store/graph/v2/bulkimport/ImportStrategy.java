/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.atlas.repository.store.graph.v2.bulkimport;

import org.apache.atlas.exception.AtlasBaseException;
import org.apache.atlas.model.impexp.AtlasImportResult;
import org.apache.atlas.model.instance.AtlasEntity;
import org.apache.atlas.model.instance.EntityMutationResponse;
import org.apache.atlas.repository.store.graph.v2.EntityImportStream;
import org.apache.atlas.v1.typesystem.types.utils.TypesUtil;

import java.util.List;
import java.util.Set;

public abstract class ImportStrategy {
    public abstract EntityMutationResponse run(EntityImportStream entityStream, AtlasImportResult importResult) throws AtlasBaseException;

    public abstract TypesUtil.Pair<EntityMutationResponse, Float> run(AtlasEntity.AtlasEntityWithExtInfo entityWithExtInfo,
                                                                      EntityMutationResponse ret,
                                                                      AtlasImportResult importResult,
                                                                      Set<String> processedGuids,
                                                                      int entityStreamPosition,
                                                                      int streamSize,
                                                                      float currentPercent,
                                                                      List<String> residualList) throws AtlasBaseException;
}
