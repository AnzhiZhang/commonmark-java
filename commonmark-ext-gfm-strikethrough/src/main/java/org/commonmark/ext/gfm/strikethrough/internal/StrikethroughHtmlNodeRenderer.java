package org.commonmark.ext.gfm.strikethrough.internal;

import org.commonmark.node.Node;
import org.commonmark.renderer.html.HtmlNodeRendererContext;
import org.commonmark.renderer.html.HtmlWriter;

import java.util.Map;

public class StrikethroughHtmlNodeRenderer extends StrikethroughNodeRenderer {

    private final HtmlNodeRendererContext context;
    private final HtmlWriter html;

    public StrikethroughHtmlNodeRenderer(HtmlNodeRendererContext context) {
        this.context = context;
        this.html = context.getWriter();
    }

    @Override
    public void render(Node node) {
        Map<String, String> attributes = context.extendAttributes(node, "del", Map.of());
        html.tag("del", attributes);
        renderChildren(node);
        html.tag("/del");
    }

    private void renderChildren(Node parent) {
        Node node = parent.getFirstChild();
        while (node != null) {
            Node next = node.getNext();
            context.render(node);
            node = next;
        }
    }
}
