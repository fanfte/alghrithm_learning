package com.fanfte.designPattern.decorator;

public class PacketHTMLHeaderCreator extends PacketDecorator{

    public PacketHTMLHeaderCreator(IPackeetCreator component) {
        super(component);
    }

    @Override
    public String handleContent() {
        StringBuffer sb = new StringBuffer();
        sb.append("<html>").append("<head>");
        sb.append(component.handleContent());
        sb.append("</body>").append("</html>");
        return sb.toString();
    }
}
