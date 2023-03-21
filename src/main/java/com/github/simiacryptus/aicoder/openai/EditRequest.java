package com.github.simiacryptus.aicoder.openai;

import com.github.simiacryptus.aicoder.config.AppSettingsState;
import com.github.simiacryptus.aicoder.util.UITools;
import com.intellij.util.ui.FormBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * The CompletionRequest class is used to create a request for completion of a given prompt.
 */
public class EditRequest {

    @NotNull
    public String model;
    @Nullable
    public String input = null;
    @NotNull
    public String instruction;

    @SuppressWarnings("unused")
    @Nullable
    public Integer n = null;
    @Nullable
    public Double top_p = null;

    @SuppressWarnings("unused")
    public EditRequest() {
    }

    public EditRequest(@NotNull AppSettingsState settingsState) {
        this.setInstruction("");
    }

    public EditRequest(@NotNull String instruction) {
        this.setInstruction(instruction);
    }

    public EditRequest(@NotNull String instruction, @Nullable String input) {
        this.setInput(input);
        this.setInstruction(instruction);
    }

    public EditRequest(@NotNull EditRequest obj) {
        this.model = obj.model;
        this.top_p = obj.top_p;
        this.input = obj.input;
        this.instruction = obj.instruction;
        this.n = obj.n;
    }

    public @NotNull EditRequest setModel(@NotNull String model) {
        this.model = model;
        return this;
    }

    public @NotNull EditRequest setInput(String input) {
        this.input = input;
        return this;
    }

    public @NotNull EditRequest setInstruction(@NotNull String instruction) {
        this.instruction = instruction;
        return this;
    }


    public @NotNull EditRequest setN(Integer n) {
        this.n = n;
        return this;
    }


    @Override
    public @NotNull String toString() {
        @NotNull String sb = "EditRequest{" + "model='" + model + '\'' +
                ", input='" + input + '\'' +
                ", instruction='" + instruction + '\'' +
                ", n=" + n +
                ", top_p=" + top_p +
                '}';
        return sb;
    }

    public @NotNull EditRequest showModelEditDialog() {
        @NotNull FormBuilder formBuilder = FormBuilder.createFormBuilder();
        @NotNull EditRequest withModel = new EditRequest(this);
        @NotNull InteractiveEditRequest ui = new InteractiveEditRequest(withModel);
        UITools.INSTANCE.addFields(ui, formBuilder);
        UITools.INSTANCE.writeUI(ui, withModel);
        JPanel mainPanel = formBuilder.getPanel();
        if (UITools.INSTANCE.showOptionDialog(mainPanel, new Object[]{"OK"}, "Completion Request") == 0) {
            UITools.INSTANCE.readUI(ui, withModel);
            return withModel;
        } else {
            return withModel;
        }
    }

    @NotNull
    public EditRequest uiIntercept() {
        if (AppSettingsState.getInstance().devActions) {
            return showModelEditDialog();
        } else {
            return this;
        }
    }
}
