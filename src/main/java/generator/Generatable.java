package generator;

import model.BaseModel;

public interface Generatable<T extends BaseModel> {

    void generate();

    T[] getObjects();

}
