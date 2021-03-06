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
package com.google.gwt.dev.jjs.ast;

/**
 * Instances are shared.
 */
public class JArrayType extends JReferenceType {

  private static String calcName(JType leafType, int dims) {
    String name = leafType.getName();
    for (int i = 0; i < dims; ++i) {
      name = name + "[]";
    }
    return name;
  }

  private int dims;
  private JType elementType;
  private JType leafType;

  /**
   * These are only supposed to be constructed by JProgram.
   */
  JArrayType(JType elementType, JType leafType, int dims) {
    super(leafType.getSourceInfo().makeChild(JArrayType.class, "Array type"),
        calcName(leafType, dims));
    this.elementType = elementType;
    this.leafType = leafType;
    this.dims = dims;
  }

  @Override
  public String getClassLiteralFactoryMethod() {
    return "Class.createForArray";
  }

  public int getDims() {
    return dims;
  }

  public JType getElementType() {
    return elementType;
  }

  public String getJavahSignatureName() {
    String s = leafType.getJavahSignatureName();
    for (int i = 0; i < dims; ++i) {
      s = "_3" + s;
    }
    return s;
  }

  public String getJsniSignatureName() {
    String s = leafType.getJsniSignatureName();
    for (int i = 0; i < dims; ++i) {
      s = "[" + s;
    }
    return s;
  }

  public JType getLeafType() {
    return leafType;
  }

  public boolean isAbstract() {
    return false;
  }

  public boolean isFinal() {
    return leafType.isFinal();
  }

  public void traverse(JVisitor visitor, Context ctx) {
    if (visitor.visit(this, ctx)) {
    }
    visitor.endVisit(this, ctx);
  }

}
