/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hadoop.yarn.server.resourcemanager.scheduler.fair;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.apache.hadoop.thirdparty.com.google.common.collect.ImmutableSet;
import org.apache.hadoop.security.GroupMappingServiceProvider;

public class SimpleGroupsMapping implements GroupMappingServiceProvider {

  @Override
  public List<String> getGroups(String user) {
    if ("admins".equals(user)) {
      return Arrays.asList("root");
    } else if ("nosecondarygroupuser".equals(user)) {
      return Arrays.asList("primarygrouponly");
    } else {
      return Arrays.asList(
          user + "group", user + "subgroup1", user + "subgroup2");
    }
  }

  @Override
  public void cacheGroupsRefresh() throws IOException {
  }

  @Override
  public void cacheGroupsAdd(List<String> groups) throws IOException {
  }

  @Override
  public Set<String> getGroupsSet(String user) throws IOException {
    return ImmutableSet.of(user + "group", user + "subgroup1",
        user + "subgroup2");
  }
}
