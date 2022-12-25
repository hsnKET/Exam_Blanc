package me.ketlas.commands.radar;

import lombok.Getter;
import me.ketlas.commands.BaseCommand;

public class DeleteRadarCommand extends BaseCommand<String> {
    public DeleteRadarCommand(String id) {
        super(id);
    }
}
