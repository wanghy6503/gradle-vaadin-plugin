/*
* Copyright 2012 John Ahlroos
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package fi.jasoft.plugin;

class VaadinPluginExtension{
	String widgetset										
	String version = "7+" 									
	String servletVersion = "2.5"
	String debugPort = 8000
	boolean manageWidgetset = true
	
	// GWT Compiler and DevMode
	GWT gwt = new GWT()
	class GWT{
		String style = "OBF"
		String optimize = 0
		String logLevel = "INFO"
	}

	// DevMode
	DevMode devmode = new DevMode()
	class DevMode {
		boolean noserver = false
		boolean superDevMode = false
	}


}