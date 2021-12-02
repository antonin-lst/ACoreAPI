package fr.acore.api.parser.node;

/*

Interface d'une node avec une value

 */

public interface INodeValue extends INode{

    //checker
    public boolean isNull();
    public boolean isNumber();
    public boolean isBoolean();

    //getter
    public String getAsString();
    public double getAsDouble();
    public float getAsFloat();
    public int getAsInt();
    public byte getAsByte();
    public boolean getAsBoolean();

}
