package me.crupette.sheepconsistency.client;

import com.mojang.blaze3d.vertex.PoseStack;
import me.crupette.sheepconsistency.SheepConsistency;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.SheepModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.item.DyeColor;

@Environment(EnvType.CLIENT)
public class SheepShearedFeatureRenderer extends RenderLayer<Sheep, SheepModel<Sheep>> {

    private final SheepModel<Sheep> model = new SheepModel<>(SheepModel.createBodyLayer().bakeRoot());
    private static final ResourceLocation SKIN = new ResourceLocation(SheepConsistency.MOD_ID, "textures/entity/sheep/sheep_sheared.png");

    public SheepShearedFeatureRenderer(RenderLayerParent<Sheep, SheepModel<Sheep>> renderLayerParent) {
        super(renderLayerParent);
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int i, Sheep sheep, float f, float g, float h, float j, float k, float l) {
        float v;
        float w;
        float x;
        if (sheep.hasCustomName() && "jeb_".equals(sheep.getCustomName().getString())) {
            int n = sheep.tickCount / 25 + sheep.getId();
            int o = DyeColor.values().length;
            int p = n % o;
            int q = (n + 1) % o;
            float r = ((float) (sheep.tickCount % 25) + h) / 25.0F;
            float[] fs = Sheep.getColorArray(DyeColor.byId(p));
            float[] gs = Sheep.getColorArray(DyeColor.byId(q));
            v = fs[0] * (1.0F - r) + gs[0] * r;
            w = fs[1] * (1.0F - r) + gs[1] * r;
            x = fs[2] * (1.0F - r) + gs[2] * r;
        } else {
            float[] hs = Sheep.getColorArray(sheep.getColor());
            v = hs[0];
            w = hs[1];
            x = hs[2];
        }
        coloredCutoutModelCopyLayerRender(this.getParentModel(), this.model, SKIN, poseStack, multiBufferSource, i, sheep, f, g, j, k, l, h, v, w, x);
    }
}
