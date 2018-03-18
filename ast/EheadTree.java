package ast;

import visitor.*;

public class EheadTree extends AST {

    public EheadTree() {
    }

    public Object accept(ASTVisitor v) {
        return v.visitEheadTree(this);
    }
}
