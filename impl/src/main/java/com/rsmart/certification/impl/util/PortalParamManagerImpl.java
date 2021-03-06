/**********************************************************************************
 * $Id: PortalParamManagerImpl.java 314667 2014-10-20 22:24:11Z bbiltimier@anisakai.com $
 ***********************************************************************************
 *
 * Copyright (c) 2004, 2005, 2006, 2008 The Sakai Foundation
 *
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.opensource.org/licenses/ECL-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 **********************************************************************************/

package com.rsmart.certification.impl.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.rsmart.certification.api.util.PortalParamManager;

import javax.servlet.ServletRequest;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PortalParamManagerImpl implements PortalParamManager {
   protected final transient Log logger = LogFactory.getLog(getClass());

   private List parameters = null;


   public Map getParams(ServletRequest request) {
      Map map = new Hashtable();

      for (Iterator i = getParameters().iterator(); i.hasNext();) {
         String key = (String) i.next();
         String value = request.getParameter(key);
         if (value == null) {
            value = (String) request.getAttribute(key);
         }

         if (value != null) {
            map.put(key, value);
         }
      }

      return map;
   }

   public List getParameters() {
      return parameters;
   }

   public void setParameters(List parameters) {
      this.parameters = parameters;
   }
}
