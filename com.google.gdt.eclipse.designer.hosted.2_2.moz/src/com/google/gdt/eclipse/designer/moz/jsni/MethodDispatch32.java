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
package com.google.gdt.eclipse.designer.moz.jsni;

import com.google.gdt.eclipse.designer.moz.jsni.LowLevelMoz32.DispatchMethod32;
import com.google.gwt.dev.shell.designtime.DispatchIdOracle;
import com.google.gwt.dev.shell.designtime.JsValue;
import com.google.gwt.dev.shell.designtime.MethodAdaptor;

/**
 * Wraps an arbitrary Java Method as a Dispatchable component. The class was
 * motivated by the need to expose Java objects into JavaScript.
 */
class MethodDispatch32/*64*/ extends MethodDispatch implements DispatchMethod32/*64*/ {

  public MethodDispatch32/*64*/(ClassLoader classLoader, DispatchIdOracle dispIdOracle, MethodAdaptor method) {
	super(classLoader, dispIdOracle, method);
  }

  /**
   * Invoke a Java method from JavaScript. This is called solely from native
   * code.
   * 
   * @param jsthis JavaScript reference to Java object
   * @param jsargs array of JavaScript values for parameters
   * @param returnValue JavaScript value to return result in
   * @throws RuntimeException if improper arguments are supplied
   * 
   * TODO(jat): lift most of this interface to platform-independent code (only
   * exceptions still need to be made platform-independent)
   */
  public void invoke(int /*long*/jsthisInt, int /*long*/[] jsargsInt, int /*long*/returnValueInt) {
    JsValue jsthis = new JsValueMoz32/*64*/(jsthisInt);
    JsValue jsargs[] = new JsValue[jsargsInt.length];
    for (int i = 0; i < jsargsInt.length; ++i) {
      jsargs[i] = new JsValueMoz32/*64*/(jsargsInt[i]);
    }
    JsValue returnValue = new JsValueMoz32/*64*/(returnValueInt);
    invoke0(jsthis, jsargs, returnValue);
  }
}
