/*
 * Copyright (C) 2016 James Kirk
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jp.jameskirk.deinflector;

/**
 * This class stores the before and after of an inflection
 * and the form it represents, e.g. past tense.
 *
 * @author James Kirk
 */
public class Inflection {
    /**
     * The inflected end of the word.
     */
    private final String inflection;
    /**
     * The uninflected end of the word.
     */
    private final String base;
    /**
     * The class of the inflection (passive, past, negative, etc.)
     */
    private final int form;

    public Inflection(String inflection, String base, int form) {
        this.inflection = inflection;
        this.base = base;
        this.form = form;
    }

    public String getInflection() {
        return inflection;
    }

    public String getBase() {
        return base;
    }

    public int getForm() {
        return form;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s (%s) ",
                inflection, base, form);
    }
}
