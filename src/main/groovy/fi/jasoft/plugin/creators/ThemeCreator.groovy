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
package fi.jasoft.plugin.creators

import fi.jasoft.plugin.TemplateUtil
import groovy.transform.Canonical
import org.gradle.util.VersionNumber

import java.nio.file.Files
import java.nio.file.StandardCopyOption

/**
 * Created by john on 9/12/16.
 */
@Canonical
class ThemeCreator implements Runnable {

    static final String STYLES_SCSS_FILE = 'styles.scss'
    static final String FAVICON_FILENAME = 'favicon.ico'

    private String themeName
    private File themesDirectory
    private String vaadinVersion

    @Override
    void run() {

        themeName = themeName ?: project.name

        File themeDir = new File(themesDirectory, themeName)
        themeDir.mkdirs()

        Map substitutions = [:]
        substitutions['themeName'] = themeName
        substitutions['theme'] = themeName.toLowerCase()

        String themeScssFile = themeName.toLowerCase() + '.scss'
        substitutions['themeImport'] = themeScssFile

        VersionNumber version = VersionNumber.parse(vaadinVersion)
        substitutions['basetheme'] = (version.major < 8 && version.minor < 3) ? 'reindeer' : 'valo'

        TemplateUtil.writeTemplate(STYLES_SCSS_FILE, themeDir, STYLES_SCSS_FILE, substitutions)
        TemplateUtil.writeTemplate('MyTheme.scss', themeDir, themeScssFile, substitutions)

        URL favicon = ThemeCreator.classLoader.getResource(FAVICON_FILENAME)
        File faviconFile = new File(themeDir, FAVICON_FILENAME)

        Files.copy(favicon.openStream(), faviconFile.toPath(), StandardCopyOption.REPLACE_EXISTING)
    }
}
