/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.thelaunchclub.StudentView;


import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Activator implements BundleActivator {

    public void start(BundleContext context)  {
        System.out.println("Starting the bundle");
//        final Properties properties = new Properties();
//        try {
//            properties.load(new FileInputStream("log.properties"));
//            PropertyConfigurator.configure(properties);
//        }catch(Exception e){
//            System.out.println(e);
//        }

        StudentManagement.selectChoice();
    }

    public void stop(BundleContext context) {
        System.out.println("Stopping the bundle");
    }

}