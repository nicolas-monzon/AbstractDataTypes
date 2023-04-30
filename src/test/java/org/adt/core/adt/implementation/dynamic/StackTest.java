package org.adt.core.adt.implementation.dynamic;

import org.adt.core.adt.definition.IStack;
import org.adt.core.adt.implementation.BaseStackTest;

public class StackTest extends BaseStackTest {

    @Override
    public IStack getStack() {
        return new Stack();
    }
}
