package org.commonmark.parser;

import org.commonmark.node.LinkReferenceDefinition;
import org.commonmark.parser.beta.InlineContentParserFactory;
import org.commonmark.parser.delimiter.DelimiterProcessor;

import java.util.List;

/**
 * Context for inline parsing.
 */
public interface InlineParserContext {

    /**
     * @return custom inline content parsers that have been configured with
     * {@link Parser.Builder#customInlineContentParserFactory(InlineContentParserFactory)}
     */
    List<InlineContentParserFactory> getCustomInlineContentParserFactories();

    /**
     * @return custom delimiter processors that have been configured with
     * {@link Parser.Builder#customDelimiterProcessor(DelimiterProcessor)}
     */
    List<DelimiterProcessor> getCustomDelimiterProcessors();

    /**
     * Look up a {@link LinkReferenceDefinition} for a given label.
     * <p>
     * Note that the label is not normalized yet; implementations are responsible for normalizing before lookup.
     *
     * @param label the link label to look up
     * @return the definition if one exists, {@code null} otherwise
     */
    LinkReferenceDefinition getLinkReferenceDefinition(String label);
}
