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

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Manages a list of {@link com.google.gwt.dev.cfg.Script} objects.
 */
public class Scripts implements Iterable<Script> {

  private final LinkedList<Script> list = new LinkedList<Script>();

  /**
   * Append a {@link com.google.gwt.dev.cfg.Script} object.
   * 
   * @param script the script to append
   */
  public void append(Script script) {
    list.addLast(script);
  }

  public boolean isEmpty() {
    return list.isEmpty();
  }

  /**
   * An iterator over {@link Script} objects.
   */
  public Iterator<Script> iterator() {
    return list.iterator();
  }
}