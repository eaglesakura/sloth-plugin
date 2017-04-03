package coom.eaglesakura.sloth.firebase

import com.eaglesakura.sloth.firebase.ConfigClassGenerator

class ConfigClassGeneratorTest extends GroovyTestCase {

    /**
     * 指定されたプロパティをキャメルケースへと変換する
     */
    void testMethodNameGenerate() {
        assertEquals(ConfigClassGenerator.toCamelCase("testMethod"), "TestMethod")
        assertEquals(ConfigClassGenerator.toCamelCase("test_case_method"), "TestCaseMethod")
    }
}
