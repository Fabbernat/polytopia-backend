package console.app.main;

public class MapType {
    public double PERLIN_SCALE = -1;
    public double WATER_LAND_RATIO = -1;
    protected String choice;
    public MapType(String choice) {
        this.choice = choice;
        switch(choice) {
            case "Drylands":
                PERLIN_SCALE = Drylands.PERLIN_SCALE;
                WATER_LAND_RATIO = Drylands.WATER_LAND_RATIO;
                break;
            case "Lakes":
                PERLIN_SCALE = Lakes.PERLIN_SCALE;
                WATER_LAND_RATIO = Lakes.WATER_LAND_RATIO;
                break;
            case "Conti":
                PERLIN_SCALE = Conti.PERLIN_SCALE;
                WATER_LAND_RATIO = Conti.WATER_LAND_RATIO;
                break;
            case "Archi":
                PERLIN_SCALE = Archi.PERLIN_SCALE;
                WATER_LAND_RATIO = Archi.WATER_LAND_RATIO;
                break;
            case "Water World":
                PERLIN_SCALE = WaterWorld.PERLIN_SCALE;
                WATER_LAND_RATIO = WaterWorld.WATER_LAND_RATIO;
        }
    }
}
