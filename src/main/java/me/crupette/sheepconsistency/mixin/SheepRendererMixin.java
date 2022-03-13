package me.crupette.sheepconsistency.mixin;

import me.crupette.sheepconsistency.client.SheepShearedFeatureRenderer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.SheepModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.SheepRenderer;
import net.minecraft.world.entity.animal.Sheep;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Environment(EnvType.CLIENT)
@Mixin(SheepRenderer.class)
public abstract class SheepRendererMixin extends MobRenderer<Sheep, SheepModel<Sheep>> {

    public SheepRendererMixin(EntityRendererProvider.Context context, SheepModel<Sheep> entityModel, float f) {
        super(context, entityModel, f);
    }

    @Inject(at = @At("TAIL"), method = "<init>")
    private void init(EntityRendererProvider.Context context, CallbackInfo ci){
        this.addLayer(new SheepShearedFeatureRenderer(this));
    }
}
