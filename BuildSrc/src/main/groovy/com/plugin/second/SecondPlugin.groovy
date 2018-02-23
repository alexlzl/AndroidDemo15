package com.plugin.second

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * 开发Gradle插件可以在IDEA中进行开发，也可以在Android Studio中进行开发，它们唯一的不同，就是IDEA提供了Gradle开发的插件，比较方便创建文件和目录，而Android Studio中，开发者需要手动创建（但实际上，这些目录并不多，也不复杂，完全可以手动创建）。
 * 在buildSrc中创建自定义Gradle插件只能在当前项目中使用，因此，对于具有普遍性的插件来说，通常是建立一个独立的Module来创建自定义Gradle插件。
 *
 * buildSrc就是Gradle提供的在项目中配置自定义插件的默认目录，开发Gradle要创建的目录，也就是RootProject/src/main/groovy和RootProject/src/main/resources两个目录。
 */
public class SecondPlugin implements Plugin<Project> {

    void apply(Project project) {
        //在创建了Extension之后，需要修改下之前创建的Groovy类来加载Extension，修改后的脚本如下所示：
        //通过project.extensions.create方法，来将一个Extension配置给Gradle即可。
        project.extensions.create('ExtensionBuildSrc', MyExtension)
        System.out.println("========================");
        System.out.println("这是第二种类型的插件!");
        System.out.println("========================");
        project.task('testPlugin') << {
            println project.ExtensionBuildSrc.message
        }
    }
}