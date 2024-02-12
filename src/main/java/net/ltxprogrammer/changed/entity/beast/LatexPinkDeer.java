package net.ltxprogrammer.changed.entity.beast;


import net.ltxprogrammer.changed.entity.GooType;
import net.ltxprogrammer.changed.entity.TransfurMode;
import net.ltxprogrammer.changed.util.Color3;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;


public class LatexPinkDeer extends LatexPinkWyvern {
    public LatexPinkDeer(EntityType<? extends LatexPinkDeer> p_19870_, Level p_19871_) {
        super(p_19870_, p_19871_);
    }


    @Override
    public Color3 getDripColor() {
        return Color3.getColor(this.random.nextInt(4) < 3 ? "#f2aaba" : "#d1626d");
    }


    @Override
    public GooType getGooType() {
        return GooType.NEUTRAL;
    }


    @Override
    public TransfurMode getTransfurMode() {
        return TransfurMode.REPLICATION;
    }
}