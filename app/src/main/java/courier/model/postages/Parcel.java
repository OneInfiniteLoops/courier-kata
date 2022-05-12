package courier.model.postages;

import courier.model.finance.Chargeable;

public abstract class Parcel implements Chargeable {
    public final int weight;
    public final int height;
    public final int width;
    public final int depth;

    public Parcel(int weight, int height, int width, int depth) {
        this.weight = weight;
        this.height = height;
        this.width = width;
        this.depth = depth;
    }

    public static Parcel withDimensions(int weight, int height, int width, int depth) {
        if (isBig(weight, height, width, depth)) {
            return new BigParcel(weight, height, width, depth);
        }
        if (isMedium(weight, height, width, depth)) {
            return new MediumParcel(weight, height, width, depth);
        }
        return new SmallParcel(weight, height, width, depth);
    }

    public static boolean isBig(int weight, int height, int width, int depth) {
        return weight > 500 || height > 324 || width > 229 || depth > 99;
    }

    public static boolean isMedium(int weight, int height, int width, int depth) {
        return weight > 60 || height > 229 || width > 162 || depth > 25;
    }
}
