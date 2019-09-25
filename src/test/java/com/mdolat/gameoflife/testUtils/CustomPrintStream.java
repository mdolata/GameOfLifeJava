package com.mdolat.gameoflife.testUtils;

import java.io.OutputStream;
import java.io.PrintStream;

public class CustomPrintStream extends PrintStream {
    private String content;

    public CustomPrintStream(OutputStream out) {
        super(out);
        content = "";
    }

    @Override
    public void print(String s) {
        content += s;
    }

    @Override
    public void println() {
        content += "\n";
    }

    public String getContent() {
        return content;
    }
}
