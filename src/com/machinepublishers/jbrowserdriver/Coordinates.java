/* 
 * jBrowserDriver (TM)
 * Copyright (C) 2014-2016 Machine Publishers, LLC
 * 
 * Sales and support: ops@machinepublishers.com
 * Updates: https://github.com/MachinePublishers/jBrowserDriver
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.machinepublishers.jbrowserdriver;

import java.rmi.RemoteException;

class Coordinates implements org.openqa.selenium.interactions.internal.Coordinates {
  final CoordinatesRemote remote;

  Coordinates(CoordinatesRemote remote) {
    this.remote = remote;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public org.openqa.selenium.Point onScreen() {
    try {
      return remote == null ? null : remote.remoteOnScreen().toSelenium();
    } catch (RemoteException e) {
      Util.handleException(e);
      return null;
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public org.openqa.selenium.Point inViewPort() {
    try {
      return remote == null ? null : remote.remoteInViewPort().toSelenium();
    } catch (RemoteException e) {
      Util.handleException(e);
      return null;
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public org.openqa.selenium.Point onPage() {
    try {
      return remote == null ? null : remote.remoteOnPage().toSelenium();
    } catch (RemoteException e) {
      Util.handleException(e);
      return null;
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Object getAuxiliary() {
    try {
      return remote == null ? null : remote.getAuxiliary();
    } catch (RemoteException e) {
      Util.handleException(e);
      return null;
    }
  }
}
