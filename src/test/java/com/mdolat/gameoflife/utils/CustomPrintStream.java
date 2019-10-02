package com.mdolat.gameoflife.utils;

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

    public void print(int i) {
        content += String.valueOf(i);
    }

    @Override
    public void println() {
        content += "\n";
    }

    public String getContent() {
        return content;
    }
}
