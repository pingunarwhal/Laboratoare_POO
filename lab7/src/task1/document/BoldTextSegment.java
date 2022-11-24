package task1.document;

import task1.DocumentVisitor;

public class BoldTextSegment extends TextSegment{
    public BoldTextSegment(String content) {
        super(content);
    }

    @Override
    public void accept(DocumentVisitor visitor) {
        visitor.visit(this);
    }
}
