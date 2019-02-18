/*
 * Copyright 2013-2019 the original author or authors.
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
package org.asciidoctor.gradle.compat

import groovy.transform.CompileStatic

/**
 * Supported backends.
 *
 * @author Benjamin Muschko
 * @author Dan Allen
 */
@Deprecated
@CompileStatic
enum AsciidoctorBackend {
    HTML('html'),
    DOCBOOK('docbook'),
    HTML5('html5'),
    DOCBOOK45('docbook45'),
    DOCBOOK5('docbook5'),
    EPUB3('epub3'),
    PDF('pdf'),
    XHTML('xhtml'),
    XHTML5('xhtml5'),

    private final static Map<String, AsciidoctorBackend> ALL_BACKENDS
    private final String id

    static {
        ALL_BACKENDS = (values().collectEntries { [it.id, it] }.asImmutable()) as Map<String, AsciidoctorBackend>
    }

    private AsciidoctorBackend(String id) {
        this.id = id
    }

    String getId() {
        id
    }

    static boolean isBuiltIn(String name) {
        ALL_BACKENDS.containsKey(name)
    }
}
