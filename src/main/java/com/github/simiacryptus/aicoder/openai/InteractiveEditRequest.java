package com.github.simiacryptus.aicoder.openai;

import com.github.simiacryptus.aicoder.config.Name;
import com.github.simiacryptus.aicoder.util.UITools;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.intellij.ui.components.JBScrollPane;
import com.intellij.ui.components.JBTextArea;
import com.intellij.ui.components.JBTextField;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;

public class InteractiveEditRequest {
    @SuppressWarnings("unused")
    @Name("输入")
    public final @NotNull JBScrollPane input;
    @SuppressWarnings("unused")
    @Name("指令")
    public final JBTextArea instruction;
    @SuppressWarnings("unused")

    public final @NotNull JButton testRequest;

    public InteractiveEditRequest(@NotNull EditRequest parent) {
        testRequest = new JButton(new AbstractAction("Test Request") {
            @Override
            public void actionPerformed(ActionEvent e) {
                @NotNull EditRequest request = new EditRequest();
                UITools.INSTANCE.readUI(InteractiveEditRequest.this, request);
                @NotNull ListenableFuture<CharSequence> future = OpenAI_API.INSTANCE.edit(null, request, "");
                testRequest.setEnabled(false);
                Futures.addCallback(future, new FutureCallback<>() {
                    @Override
                    public void onSuccess(@NotNull CharSequence result) {
                        testRequest.setEnabled(true);
                        @NotNull String text = result.toString();
                        int rows = Math.min(50, text.split("\n").length);
                        int columns = Math.min(200, Arrays.stream(text.split("\n")).mapToInt(String::length).max().getAsInt());
                        @NotNull JBTextArea area = new JBTextArea(rows, columns);
                        area.setText(text);
                        area.setEditable(false);
                        JOptionPane.showMessageDialog(null, area, "Test Output", JOptionPane.PLAIN_MESSAGE);
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        testRequest.setEnabled(true);
                        UITools.INSTANCE.handle(t);
                    }
                }, OpenAI_API.getPool());
            }
        });
        input = UITools.INSTANCE.wrapScrollPane(new JBTextArea(10, 120));
        instruction = UITools.INSTANCE.configureTextArea(new JBTextArea(1, 120));
    }
}
