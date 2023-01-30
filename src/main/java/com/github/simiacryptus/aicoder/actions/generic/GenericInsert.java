package com.github.simiacryptus.aicoder.actions.generic;

import com.github.simiacryptus.aicoder.config.AppSettingsState;
import com.github.simiacryptus.aicoder.openai.CompletionRequest;
import com.github.simiacryptus.aicoder.util.ComputerLanguage;
import com.github.simiacryptus.aicoder.util.StringTools;
import com.github.simiacryptus.aicoder.util.UITools;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Caret;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.util.TextRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;


/**
 * The GenericInsert IntelliJ action allows users to quickly insert a prompt at the current caret position.
 * To use, select some text and then select the GenericInsert action from the editor context menu.
 * The action will insert the completion at the current caret position.
 */
public class GenericInsert extends AnAction {

    @Override
    public void update(@NotNull AnActionEvent e) {
        e.getPresentation().setEnabledAndVisible(isEnabled(e));
        super.update(e);
    }

    @SuppressWarnings("unused")
    private static boolean isEnabled(@NotNull AnActionEvent e) {
        if (UITools.hasSelection(e)) return false;
        return true;
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {
        @Nullable Caret caret = event.getData(CommonDataKeys.CARET);
        @NotNull Document document = Objects.requireNonNull(caret).getEditor().getDocument();
        int caretPosition = caret.getOffset();
        @NotNull CharSequence before = StringTools.getSuffixForContext(document.getText(new TextRange(0, caretPosition)));
        @NotNull CharSequence after = StringTools.getPrefixForContext(document.getText(new TextRange(caretPosition, document.getTextLength())));
        AppSettingsState settings = AppSettingsState.getInstance();
        @NotNull CompletionRequest completionRequest = settings.createCompletionRequest()
                .appendPrompt(before)
                .setSuffix(after);
        UITools.redoableRequest(completionRequest, "", event,
                newText -> UITools.insertString(document, caretPosition, newText));
    }
}