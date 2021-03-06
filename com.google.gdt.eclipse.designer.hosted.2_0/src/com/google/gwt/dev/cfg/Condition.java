/*******************************************************************************
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.google.gwt.dev.cfg;

import com.google.gwt.core.ext.PropertyOracle;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.typeinfo.TypeOracle;
import com.google.gwt.dev.util.collect.Sets;

import java.io.Serializable;
import java.util.Set;

/**
 * Abstract base class for various kinds of deferred binding conditions.
 */
public abstract class Condition implements Serializable {
  /**
   * Returns the set of property names that the Condition requires in order to
   * be evaluated.
   */
  public Set<String> getRequiredProperties() {
    return Sets.create();
  }

  public final boolean isTrue(TreeLogger logger, PropertyOracle propertyOracle,
      TypeOracle typeOracle, String testType) throws UnableToCompleteException {

    boolean logDebug = logger.isLoggable(TreeLogger.DEBUG);

    if (logDebug) {
      String startMsg = getEvalBeforeMessage(testType);
      logger = logger.branch(TreeLogger.DEBUG, startMsg, null);
    }

    boolean result = doEval(logger, propertyOracle, typeOracle, testType);

    if (logDebug) {
      String afterMsg = getEvalAfterMessage(testType, result);
      logger.log(TreeLogger.DEBUG, afterMsg, null);
    }

    return result;
  }

  protected abstract boolean doEval(TreeLogger logger,
      PropertyOracle propertyOracle, TypeOracle typeOracle, String testType)
      throws UnableToCompleteException;

  protected abstract String getEvalAfterMessage(String testType, boolean result);

  protected abstract String getEvalBeforeMessage(String testType);
}
