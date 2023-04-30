package org.adt.core.adt.implementation.normal;

import org.adt.core.adt.definition.IBinaryTree;
import org.adt.core.adt.implementation.BaseBinaryTreeTest;

public class BinaryTreeTest extends BaseBinaryTreeTest {

    @Override
    public IBinaryTree getBinaryTree() {
        return new BinaryTree();
    }
}
