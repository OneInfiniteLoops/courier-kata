package courier.model.postages;

public class BigParcel extends Parcel {
    public BigParcel(int weight, int height, int width, int depth) {
        super(weight, height, width, depth);
    }

    @Override
    public int postageCostInDefaultCurrency() {
        return Math.max(((height * width * depth) / 1000) * 6, weight * 6);
    }
}
