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
package com.google.gdt.eclipse.designer.gxt.model.property;

import org.eclipse.wb.internal.core.utils.reflect.ReflectionUtils;

/**
 * Wrapper for <code>Margins</code>.
 * 
 * @author scheglov_ke
 * @coverage ExtGWT.model.property
 */
public class Margins {
  public int top;
  public int left;
  public int bottom;
  public int right;

  public Margins() {
  }

  public Margins(Object margins) {
    top = ReflectionUtils.getFieldInt(margins, "top");
    left = ReflectionUtils.getFieldInt(margins, "left");
    bottom = ReflectionUtils.getFieldInt(margins, "bottom");
    right = ReflectionUtils.getFieldInt(margins, "right");
  }

  public static boolean isMargins(Object value) {
    return ReflectionUtils.isSuccessorOf(value, "com.extjs.gxt.ui.client.util.Margins");
  }
}
