package ley.modding.alchemycraft.alchemy;

public class DefaultResult implements IResult {

    int[] result;

    public DefaultResult(int[] result) {
        this.result = result;
    }

    @Override
    public int[] getResult() {
        return result;
    }
}
