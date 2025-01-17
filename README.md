# intellij-aicoder-free

<!-- Plugin description -->

免费的AI编程助手

这是一款革命性的新代码编辑器插件，利用人工智能的力量使编程更快速、更简单。

修改自：https://github.com/SimiaCryptus/intellij-aicoder

# 文本 Actions

Plaintext actions provide text processing features for any language. The following actions are available for plaintext in the AI Coder plugin:

| Text              | Description |
|-------------------| --- |
| 补全文本              |  The `Append Text` action allows you to quickly append text to the end of the current <br/>selection. This is useful to quickly add to the document based on a user-determined prompting context. For example, if you have a document that contains a list of items, you can use the `Append Text` action to quickly add additional items to the list. Additionally, you can use the `Append Text` action to quickly add additional text to the end of a sentence or paragraph. This can be useful for quickly adding additional details or context to a document.  |
| Dictation         |  The `Dictation` action allows you to speak into the microphone and have the text automatically inserted into the document. This uses OpenAI's Whisper API.  |
| Edit Text...      |  The `Edit Text` action allows you to edit the text in the current selection based on an Ad-hoc directive. For example, you can translate, summarize, and correct errors.  |
| Insert Text       |  The `Insert Text` action allows you to quickly insert text at the cursor position. It automatically captures some preceding and following context for the text completion API to make the most accurate suggestions. For example, if you type ‘I had a day’ and place the cursor after 'a' and then use the `Insert Text` action, the API will suggest words like ‘great’, ‘bad’, or ‘delicious’.  |
| Recent Text Edits |  The `Recent Text Edits` group allows you to quickly access your most recent text edits. This is useful for quickly accessing your most recent edits.  |
| Redo Last         |  The `Redo Last` action allows you to quickly redo the last action you performed. This is useful for getting variations from the generative AI. For example, if you generate something and want to see an alternate, you can use the `Redo Last` action to quickly retry without having to start from scratch.  |
| Replace Options   |  The `Replace Options` action allows you to quickly replace selected text with one of a set of suggested options. This also captures some preceding and following context, but uses a different prompting method to suggest the options. For example, if you type ‘I had a day’ and place the cursor after 'a' and then use the `Replace Options` action, the plugin will **_provide an interactive selection UI_** to suggest words like ‘great’, ‘bad’, or ‘delicious’.  |

# Code Actions

The following actions are available for coding in the AI Coder plugin:

| Text | Description |
| --- | --- |
| Add Code Comments |  The `Add Code Comments` action allows you to quickly add comments to selected code. It will generally add a comment for each line with a description. This is useful for quickly documenting your code and making it easier to understand.  |
| Convert To... |  The `Convert To...` action allows you to quickly convert a file to a specific language. This is useful for quickly converting larger amounts of code between languages. For example, if you have a Java file and want to convert it to Kotlin, you can use the `Convert To...` action to quickly convert it.  |
| Edit Code... |  The `Edit Code...` action allows you to quickly edit your code based on a user-supplied directive. This is useful for quickly performing ad-hoc code transformations. For example, you can use this action to add logging statements or to quickly refactor your code.  |
| Describe Code and Prepend Comment |  The `Describe Code and Prepend Comment` action allows you to quickly add a comment to your code that describes the current selection. This is useful for quickly documenting your code and making it easier to understand.  |
| Add Doc Comments |  The `Add Doc Comments` action allows you to quickly add comments to your code that are formatted for documentation. In contrast to existing code tools that can generate doc comments, this action is based on the full code and can generate more accurate comments.  |
| From Text |  The `From Text` action allows you to quickly convert text into code. This is useful for quickly implementing text-based ideas into code.  |
| Implement Stub |  The `Implement Stub` action allows you to quickly implement a stub of a method. This is useful for quickly implementing a new method.  |
| Paste |  The `Paste` action allows you to quickly paste code into your project. This text will be translated into the current language. This is useful for quickly pasting code into your project.  |
| Insert Implementation |  The `Insert Implementation` action allows you to quickly insert the implementation of a comment. It attempts to process the code context and provide details about this generation context within the API call.  |
| Ask a question about the code |  The `Ask a question about the code` action allows you to quickly ask a question about the code. This is useful for quickly getting help with understanding the code. The question and response are prepended to the selected code.  |
| Recent Code Edits |  The `Recent Code Edits` group allows you to quickly access your most recent code edits. This is useful for quickly accessing your most recent edits.  |
| Rename Variables |  The `Rename Variables` action allows you to quickly rename variables in your code. An interactive dialog is provided to select any/all/none of the rename suggestions. This is useful for quickly refactoring your code and making it easier to understand.  |
| Reword Comment |  The `Reword Comment` action allows you to quickly reword a comment in your code. This is useful for quickly refactoring your code and making it easier to understand. This is useful for managing and writing code comments.  |
| To Text |  The `To Text` action allows you to quickly convert code into text. This is useful for quickly describing code in plain text.  |
| Translate Comment |  The `Translate Comment` action allows you to quickly translate a comment in your code. This is useful for quickly refactoring your code and making it easier to understand.  |

# Markdown Actions

Markdown Actions allow you to quickly and easily add list items, table columns, and more to your Markdown documents.

| Text | Description |
| --- | --- |
| Annotate |  The `Annotate` group allows you to transform natural language into a variety of NLP annotatation formats. This is useful for parsing and analyzing natural language.  |
| Fact Check List |  The `Fact Check List` action allows you to add fact checking links to the selected list items.  |
| Implement As... |  The `Implement As...` action allows you to quickly implement a markdown prompt in a specific language. This is useful for quickly implementing code in a specific language. For example, if select "find the largest file in the current directory" you can use the `Implement As...` action to quickly implement this idea in Bash.  |
| Add List Items |  The `Add List Items` action allows you to quickly add list items to your Markdown document. It supports both ordered and unordered lists, and nested lists.  |
| Add Table Column... |  The `Add Table Column` action allows you to quickly add a table column to your Markdown document. It will prompt you for the column name and attempt to generate new values for all rows.  |
| Add Table Columns |  The `Add Table Columns` action allows you to quickly add table columns to your Markdown document. Multiple new columns will be generated and filled with generated data.  |
| Add Table Rows |  The `Add Table Rows` action allows you to quickly add rows to a Markdown document table. The new row will be filled with generated data.  |
| To Statement List |  The `To Statement List` action allows you to convert the selected text into a list of statements.  |
| Wiki Links |  The `Wiki Links` action allows you to add wikipedia links to topics in the selected text.  |

# Developer-Mode Actions

Some actions are only available when the plugin is running in developer mode. These may be useful for debugging or development, but also contain experimental features that may not be fully functional.

| Text | Description |
| --- | --- |
| Print PSI Tree |  The `Print PSI Tree` action allows you to print the PSI tree for the current file. This is useful for debugging and understanding the PSI tree for a file. This is a developer tool and is only visible if the `Developer Mode` setting is enabled.  |
| Recursive To Statement List |  The `Recursive To Statement List` action allows you to convert the selected text into a list of statements, recursively expanding any statements in the list.  |

<!-- Plugin description end -->

## 安装


- Manually:
  下载插件包，在设置里手动安装
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>

## 使用

After installation, edit the settings and add your API key. If desired, customize your style!
![aicoder_settings.png](docs/aicoder_settings.png)

Use the context menu to access features. In this example, we use the "Insert Implementation" tool. 
_Note: After inserting, the code needs reformatting and some manual cleanup (e.g. correcting additional ending braces)_
![aicoder_implement.png](docs/aicoder_implement.png)

After reviewing the code, we can easily add documentation.
![aicoder_adddocs.png](docs/aicoder_adddocs.png)

![aicoder_final.png](docs/aicoder_final.png)

We can also iterate and use the AI to refactor the code using custom edits:
![aicoder_edit.png](docs/aicoder_edit.png)

![aicoder_editresult.png](docs/aicoder_editresult.png)

---
Plugin based on the [IntelliJ Platform Plugin Template][template].

[template]: https://github.com/JetBrains/intellij-platform-plugin-template
