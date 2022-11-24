package task1.document;

import task1.DocumentVisitor;

public class PlainTextSegment extends TextSegment{
    public PlainTextSegment(String content) {
        super(content);
    }

    @Override
    public void accept(DocumentVisitor visitor) {
        visitor.visit(this);
    }
}
