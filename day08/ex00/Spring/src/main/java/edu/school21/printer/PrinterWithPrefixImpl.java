package edu.school21.printer;


import edu.school21.renderer.Renderer;

public class PrinterWithPrefixImpl implements Printer{
    private String prefix;
    Renderer renderer;

    public PrinterWithPrefixImpl(Renderer renderer) {
        this.renderer = renderer;
        this.prefix="";
    }

    @Override
    public void print(String msg) {
        renderer.render(prefix + msg);
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}
