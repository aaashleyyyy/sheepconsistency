package me.crupette.sheepconsistency;

import com.mojang.logging.LogUtils;
import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SheepConsistency implements ClientModInitializer {

    public static final String MOD_ID = "sheepconsistency";
    public static final String MOD_NAME = "Sheep Consistency";

    public static Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    @Override
    public void onInitializeClient() {

    }
}