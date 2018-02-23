package com.plugin.second

import org.gradle.api.Plugin
import org.gradle.api.Project

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