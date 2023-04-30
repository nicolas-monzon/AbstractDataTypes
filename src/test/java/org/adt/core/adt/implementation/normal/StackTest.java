package org.adt.core.adt.implementation.normal;

import org.adt.core.adt.definition.IStack;
import org.adt.core.adt.implementation.BaseStackTest;

public class StackTest extends BaseStackTest {

    @Override
    public IStack getStack() {
        return new Stack();
    }
}
