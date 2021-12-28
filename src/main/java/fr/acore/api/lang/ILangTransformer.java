package fr.acore.api.lang;

import fr.acore.api.string.IStringHelper;

import java.util.List;

public interface ILangTransformer<T extends ILangTransformerNode> extends IStringHelper {

    public List<T> getTransformerNodes();
    public void setTransformerNodes(List<T> transformerNodes);


    public default String transform(String origin){
        return transform(origin, getTransformerNodes().toArray(new ILangTransformerNode[0]));
    }

    public default String transform(String origin, ILangTransformerNode... args){

        for(ILangTransformerNode arg : args){
            origin = replace(origin, arg.getIndex(), arg.getTransformation());
        }

        return origin;
    }
}
