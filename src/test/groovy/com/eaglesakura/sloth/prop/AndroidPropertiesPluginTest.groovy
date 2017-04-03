package com.eaglesakura.sloth.prop

import org.gradle.testfixtures.ProjectBuilder

/**
 * プロパティ出力のテスト
 */
class AndroidPropertiesPluginTest extends GroovyTestCase {

    void test_Applyが成功する() {
        def project = ProjectBuilder.builder().build()
        project.apply plugin: AndroidPropertiesPlugin

        project.props.output(new File("src/test/gen"))

        project.tasks.androidGenerateProperties.execute()
    }

    void test_JSONからプロパティ出力が成功する() {
        def project = ProjectBuilder.builder().build()
        project.apply plugin: AndroidPropertiesPlugin

        project.props.output(new File("src/test/gen"))
        project.props.property(new File("src/test/assets/properties.json"), "com.example.unit.test")

        project.tasks.androidGenerateProperties.execute()
    }
}