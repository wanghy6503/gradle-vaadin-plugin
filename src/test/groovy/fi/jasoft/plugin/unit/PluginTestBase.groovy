/*
* Copyright 2017 John Ahlroos
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
package fi.jasoft.plugin.unit

import fi.jasoft.plugin.GradleVaadinPlugin
import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.rules.TemporaryFolder

/**
 * Base class for plugin unit tests
 */
class PluginTestBase {

    @Rule
    public TemporaryFolder testDir = new TemporaryFolder()

    protected Project project

    protected GradleVaadinPlugin plugin

    @Before
    void setUp() {
        project = ProjectBuilder.builder().withProjectDir(testDir.root).build()
        plugin = new GradleVaadinPlugin().apply(project)
    }
}
