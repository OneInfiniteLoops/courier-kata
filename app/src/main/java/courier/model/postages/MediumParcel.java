package courier.model.postages;

public class MediumParcel extends Parcel {
    public MediumParcel(int weight, int height, int width, int depth) {
        super(weight, height, width, depth);
    }

    @Override
    public int postageCostInDefaultCurrency() {
        return weight * 4;
    }
}
