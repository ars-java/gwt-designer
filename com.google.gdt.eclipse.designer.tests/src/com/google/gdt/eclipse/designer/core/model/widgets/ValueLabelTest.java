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
package com.google.gdt.eclipse.designer.core.model.widgets;

import com.google.gdt.eclipse.designer.core.model.GwtModelTest;
import com.google.gdt.eclipse.designer.model.widgets.WidgetInfo;

/**
 * Test for <code>com.google.gwt.user.client.ui.ValueLabel</code>.
 * 
 * @author scheglov_ke
 */
public class ValueLabelTest extends GwtModelTest {
  ////////////////////////////////////////////////////////////////////////////
  //
  // Exit zone :-) XXX
  //
  ////////////////////////////////////////////////////////////////////////////
  public void _test_exit() throws Exception {
    System.exit(0);
  }

  ////////////////////////////////////////////////////////////////////////////
  //
  // Tests
  //
  ////////////////////////////////////////////////////////////////////////////
  /**
   * Some default <code>ValueLabel</code> without <code>Renderer</code>.
   */
  public void test_parse_noRenderer() throws Exception {
    parseJavaInfo(
        "// filler filler filler filler filler",
        "public class Test extends FlowPanel {",
        "  public Test() {",
        "    ValueLabel<Integer> valueLabel = new ValueLabel<Integer>((Renderer) null);",
        "    add(valueLabel);",
        "  }",
        "}");
    refresh();
    WidgetInfo valueLabelModel = getJavaInfoByName("valueLabel");
    //
    assertEquals("ValueLabel(null)", getValueLabelText(valueLabelModel));
  }

  /**
   * Uses <code>IntegerRenderer</code>.
   */
  public void test_parse_IntegerRenderer() throws Exception {
    parseJavaInfo(
        "// filler filler filler filler filler",
        "public class Test extends FlowPanel {",
        "  public Test() {",
        "    ValueLabel<Integer> valueLabel = new ValueLabel<Integer>(IntegerRenderer.instance());",
        "    add(valueLabel);",
        "  }",
        "}");
    refresh();
    WidgetInfo valueLabelModel = getJavaInfoByName("valueLabel");
    // has Renderer name in text
    assertEquals("ValueLabel(IntegerRenderer)", getValueLabelText(valueLabelModel));
  }

  /**
   * @return the inner text of given <code>ValueLabel</code> element.
   */
  private static String getValueLabelText(WidgetInfo valueLabelModel) throws Exception {
    Object element = valueLabelModel.getElement();
    return valueLabelModel.getDOMUtils().getInnerText(element);
  }
}