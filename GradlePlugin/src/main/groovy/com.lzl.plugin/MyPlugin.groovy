package com.lzl.plugin
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * http://blog.csdn.net/huachao1001/article/details/51810328
 */

public class MyPlugin implements Plugin<Project> {

    void apply(Project project) {
        project.extensions.create('pluginExt', PluginExtension)
        project.pluginExt.extensions.create('nestExt', PluginNestExtension)
        project.task('customTask', type: CustomTask)
        project.gradle.addListener(new TimeListener())
        System.out.println("========================");
        System.out.println("使用自定义gradle插件!");
        System.out.println("========================");
        project.task('testTask') << {
            System.out.println("testTask==使用自定义gradle插件!");
        }
    }
}