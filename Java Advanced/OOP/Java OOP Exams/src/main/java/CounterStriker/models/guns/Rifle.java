package CounterStriker.models.guns;

public class Rifle extends GunImpl{
    public Rifle(String name, int bulletsCount) {
        super(name, bulletsCount);
        setNUMBER_OF_BULLETS_PER_FIRING(10);
    }
}
