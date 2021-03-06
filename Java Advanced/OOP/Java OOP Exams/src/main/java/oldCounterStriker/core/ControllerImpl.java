package oldCounterStriker.core;

import oldCounterStriker.common.ExceptionMessages;
import oldCounterStriker.common.OutputMessages;
import oldCounterStriker.models.field.Field;
import oldCounterStriker.models.field.FieldImpl;
import oldCounterStriker.models.guns.Gun;
import oldCounterStriker.models.guns.Pistol;
import oldCounterStriker.models.guns.Rifle;
import oldCounterStriker.models.players.CounterTerrorist;
import oldCounterStriker.models.players.Player;
import oldCounterStriker.models.players.Terrorist;
import oldCounterStriker.repositories.GunRepository;
import oldCounterStriker.repositories.PlayerRepository;


public class ControllerImpl implements Controller {
    private GunRepository guns;
    private PlayerRepository players;
    private Field field;

    public ControllerImpl() {
        this.guns = new GunRepository();
        this.players = new PlayerRepository();
        this.field = new FieldImpl();
    }

    @Override
    public String addGun(String type, String name, int bulletsCount) {
        Gun gun;
        switch (type) {
            case "Pistol":
                gun = new Pistol(name, bulletsCount);
                break;
            case "Rifle":
                gun = new Rifle(name, bulletsCount);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_GUN_TYPE);
        }
        this.guns.add(gun);
        return String.format(OutputMessages.SUCCESSFULLY_ADDED_GUN, name);
    }

    @Override
    public String addPlayer(String type, String username, int health, int armor, String gunName) {
        Gun gun = this.guns.findByName(gunName);
        if (gun == null) {
            throw new NullPointerException(ExceptionMessages.GUN_CANNOT_BE_FOUND);
        }
        Player player;
        switch (type) {
            case "Terrorist":
                player = new Terrorist(username, health, armor, gun);
                break;
            case "CounterTerrorist":
                player = new CounterTerrorist(username, health, armor, gun);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_PLAYER_TYPE);
        }
        this.players.add(player);
        return String.format(OutputMessages.SUCCESSFULLY_ADDED_PLAYER, username);
    }

    @Override
    public String startGame() {
        return this.field.start(this.players.getModels());
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        this.players.getModels().stream()
                .sorted((a, b) -> {
                    int sort = a.getClass().getSimpleName().compareTo(b.getClass().getSimpleName());
                    if (sort == 0) {
                        sort = Integer.compare(b.getHealth(), a.getHealth());

                        if (sort == 0) {
                            sort = a.getUsername().compareTo(b.getUsername());
                        }
                    }

                    return sort;
                }).forEach(player -> sb.append(player.toString()).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}
