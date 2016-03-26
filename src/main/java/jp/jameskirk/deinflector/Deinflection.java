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
 * This class stores data related to a deinflection.
 *
 * @author James Kirk
 */
public class Deinflection {

    /**
     * The original inflected term.
     */
    private final String inflectedWord;
    /**
     * The deinflected base form of the word.
     */
    private final String baseForm;
    /**
     * The inflection (passive, past, causative, etc.)
     */
    private final int form;
    /**
     * The class of inflection (adjective, godan, kuru, etc.)
     */
    private final int inflectionType;

    public Deinflection(String inflectedWord, String baseForm,
                        int form, int inflectionType) {
        this.inflectedWord = inflectedWord;
        this.baseForm = baseForm;
        this.form = form;
        this.inflectionType = inflectionType;
    }

    public String getInflectedWord() {
        return inflectedWord;
    }

    public String getBaseForm() {
        return baseForm;
    }

    public int getForm() {
        return form;
    }

    public int getInflectionType() {
        return inflectionType;
    }

    @Override
    public int hashCode() {
        return baseForm.hashCode() * 7;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Deinflection) &&
                ((Deinflection)obj).getBaseForm().equals(baseForm);
    }

    @Override
    public String toString() {
        return String.format("%s [%d]", baseForm, inflectionType);
    }
}
