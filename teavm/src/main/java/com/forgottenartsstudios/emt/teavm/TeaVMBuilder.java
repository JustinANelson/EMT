package com.forgottenartsstudios.emt.teavm;

import com.github.xpenatan.gdx.backends.teavm.TeaBuildConfiguration;
import com.github.xpenatan.gdx.backends.teavm.TeaBuilder;
import com.github.xpenatan.gdx.backends.teavm.plugins.TeaReflectionSupplier;
import com.github.xpenatan.gdx.backends.web.gen.SkipClass;
import java.io.File;
import java.io.IOException;
import org.teavm.tooling.TeaVMTool;

/** Builds the TeaVM/HTML application. */
@SkipClass
public class TeaVMBuilder {
    public static void main(String[] args) throws IOException {
        TeaBuildConfiguration teaBuildConfiguration = new TeaBuildConfiguration();
        teaBuildConfiguration.assetsPath.add(new File("../assets"));
        teaBuildConfiguration.webappPath = new File("build/dist").getCanonicalPath();
        // You can switch this setting during development:
        teaBuildConfiguration.obfuscate = false;

        // Register any extra classpath assets here:
        // teaBuildConfiguration.additionalAssetsClasspathFiles.add("com/forgottenartsstudios/emt/asset.extension");

        // Register any classes or packages that require reflection here:
        // TeaReflectionSupplier.addReflectionClass("com.forgottenartsstudios.emt.reflect");

        TeaVMTool tool = TeaBuilder.config(teaBuildConfiguration);
        tool.setMainClass(TeaVMLauncher.class.getName());
        TeaBuilder.build(tool);
    }
}
