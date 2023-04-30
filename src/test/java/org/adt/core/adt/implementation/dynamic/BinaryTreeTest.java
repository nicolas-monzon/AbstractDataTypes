package org.adt.core.adt.implementation.dynamic;

import org.adt.core.adt.definition.IBinaryTree;
import org.adt.core.adt.implementation.BaseBinaryTreeTest;
import org.adt.core.adt.implementation.normal.BinaryTree;

public class BinaryTreeTest extends BaseBinaryTreeTest {

    @Override
    public IBinaryTree getBinaryTree() {
        return new BinaryTree();
    }
}
