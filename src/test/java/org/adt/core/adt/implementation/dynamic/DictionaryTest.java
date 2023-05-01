package org.adt.core.adt.implementation.dynamic;

import org.adt.core.adt.definition.IDictionary;
import org.adt.core.adt.implementation.BaseDictionaryTest;

public class DictionaryTest extends BaseDictionaryTest {

    @Override
    public IDictionary getDictionary() {
        return new Dictionary();
    }
}
