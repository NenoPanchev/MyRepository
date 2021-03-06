package CounterStriker.models.guns;

import CounterStriker.common.ExceptionMessages;

public abstract class GunImpl implements Gun{
    private String name;
    private int bulletsCount;
    private int NUMBER_OF_BULLETS_PER_FIRING = 0;

    protected GunImpl(String name, int bulletsCount) {
        setName(name);
        setBulletsCount(bulletsCount);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getBulletsCount() {
        return this.bulletsCount;
    }

    @Override
    public int fire() {
        if (this.bulletsCount >= NUMBER_OF_BULLETS_PER_FIRING) {
            setBulletsCount(this.bulletsCount - NUMBER_OF_BULLETS_PER_FIRING);
            return NUMBER_OF_BULLETS_PER_FIRING;
        } else
            return 0;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.INVALID_GUN_NAME);
        }
        this.name = name;
    }

    private void setBulletsCount(int bulletsCount) {
        if (bulletsCount < 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_GUN_BULLETS_COUNT);
        }
        this.bulletsCount = bulletsCount;
    }

    protected void setNUMBER_OF_BULLETS_PER_FIRING(int number) {
        this.NUMBER_OF_BULLETS_PER_FIRING = number;
    }
}
