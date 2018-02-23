package com.plugin.second

/**
 * 所谓Groovy脚本的Extension，实际上就是类似于Gradle的配置信息，在主项目使用自定义的Gradle插件时，可以在主项目的build.gradle脚本中通过Extension来传递一些配置、参数。
 */
class MyExtension {
    String message

}