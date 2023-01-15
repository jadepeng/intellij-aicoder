package com.github.simiacryptus.aicoder.util;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface TextBlock {

    CharSequence TAB_REPLACEMENT = "  ";
    String DELIMITER = "\n";

    CharSequence[] rawString();

    default String getTextBlock() {
        return Arrays.stream(rawString()).collect(Collectors.joining(DELIMITER));
    }

    @NotNull TextBlock withIndent(CharSequence indent);

    default @NotNull Stream<CharSequence> stream() {
        return Arrays.stream(rawString());
    }
}
