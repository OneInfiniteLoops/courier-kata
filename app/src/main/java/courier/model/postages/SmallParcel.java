package courier.model.postages;

public class SmallParcel extends Parcel {
    public SmallParcel(int weight, int height, int width, int depth) {
        super(weight, height, width, depth);
    }

    @Override
    public int postageCostInDefaultCurrency() {
        return 120;
    }
}
