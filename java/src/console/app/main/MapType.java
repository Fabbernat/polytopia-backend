package console.app.main;

enum MapType {
    DRYLANDS(0.4, 0.0),
    LAKES(0.1, 0.4),
        CONTI(.15,.5),
    ARCHI(0.4, 0.56),
        WATER_WORLD(.4,.85);

    public final double perlinScale;     // lower = larger regions
    public final double waterAndLandRatio;

    MapType(double ps, double walr) {
        this.perlinScale = ps;
        this.waterAndLandRatio = walr;
    }
}
