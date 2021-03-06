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
package com.google.gdt.eclipse.designer.smart.model.menu;

import org.eclipse.wb.core.model.JavaInfo;
import org.eclipse.wb.internal.core.model.creation.CreationSupport;
import org.eclipse.wb.internal.core.model.creation.VoidInvocationCreationSupport;
import org.eclipse.wb.internal.core.model.description.MethodDescription;

import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.MethodInvocation;

/**
 * {@link CreationSupport} for
 * <code>com.smartgwt.client.widgets.toolbar.ToolStrip#addSpacer()</code>,
 * <code>com.smartgwt.client.widgets.toolbar.ToolStrip#addFill()</code>,
 * <code>com.smartgwt.client.widgets.toolbar.ToolStrip#addSeparator()</code>.
 * 
 * @author sablin_aa
 * @coverage SmartGWT.model
 */
public class ToolStripAddItemCreationSupport extends VoidInvocationCreationSupport {
  private final String m_source;

  ////////////////////////////////////////////////////////////////////////////
  //
  // Constructor
  //
  ////////////////////////////////////////////////////////////////////////////
  public ToolStripAddItemCreationSupport(JavaInfo hostJavaInfo,
      MethodDescription description,
      MethodInvocation invocation,
      JavaInfo[] argumentInfos) {
    super(hostJavaInfo, description, invocation);
    String source = hostJavaInfo.getEditor().getSource(invocation);
    Expression expression = invocation.getExpression();
    if (expression != null) {
      String expressionSource = hostJavaInfo.getEditor().getSource(expression);
      source = source.substring(expressionSource.length() + 1);
    }
    m_source = source;
  }

  ////////////////////////////////////////////////////////////////////////////
  //
  // Access
  //
  ////////////////////////////////////////////////////////////////////////////
  @Override
  protected Object getObject(Object hostObject) throws Exception {
    /* disabled because array (until rendering) may contains strings
    Object[] canvases = (Object[]) ReflectionUtils.invokeMethodEx(hostObject, "getMembers()");
    return canvases[canvases.length - 1];*/
    return null;
  }

  ////////////////////////////////////////////////////////////////////////////
  //
  // Validation
  //
  ////////////////////////////////////////////////////////////////////////////
  @Override
  public boolean canReorder() {
    return true;
  }

  ////////////////////////////////////////////////////////////////////////////
  //
  // Adding
  //
  ////////////////////////////////////////////////////////////////////////////
  @Override
  protected String add_getMethodSource() throws Exception {
    return m_source;
  }
}
