/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.lewuathe.dllib

import org.scalatest._

import breeze.linalg.Vector

class LabelEncoderSpec extends FlatSpec with Matchers {
  "Integer" should "be encoded into one hot vector" in {
    val label = 3
    val labelCount = 10
    val v = util.encodeLabel(3, labelCount)
    v(label) should be (1.0)
  }

  "Vector" should "be decoded into one max integer" in {
    val v = Vector[Double](0.1, 0.2, 0.3, 0.1, 0.2, 0.1, 0.3, 0.4, 0.1, 0.1)
    val label = util.decodeLabel(Blob.uni(v))
    label should be (7.0)
  }
}
