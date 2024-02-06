package net.msk.adventOfCode2022;

import net.msk.adventOfCode2022.model.Command;

import java.util.List;

public class Day10_CathodeRayTube {

    private List<Command> pipeline;

    private int commandPointer = 0;

    private Command currentCommand;

    private int registerValue = 1;

    private int cycle = 0;

    public enum BaseCommand {
        ADDX, NOOP
    }

    public Day10_CathodeRayTube(final List<Command> commandPipeline) {
        this.pipeline = commandPipeline;
    }

    public void executeTicks(final int numberOfTicks) {
        for(int i = 0; i <= numberOfTicks; i++) {
            this.tick();
        }
    }

    private void tick() {
        if(this.currentCommand == null) {
            final Command nextCommand = this.pipeline.get(this.commandPointer);
            if(nextCommand.baseCommand() == BaseCommand.ADDX) {
                this.currentCommand = nextCommand;
            }

            this.commandPointer++;
        }
        else {
            this.registerValue += this.currentCommand.value();
            this.currentCommand = null;
        }

        this.cycle++;
    }
}
