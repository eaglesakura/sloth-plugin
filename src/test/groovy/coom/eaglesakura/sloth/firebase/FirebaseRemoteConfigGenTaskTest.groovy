package coom.eaglesakura.sloth.firebase

import com.eaglesakura.sloth.firebase.FirebaseRemoteConfigGenTask
import org.gradle.testfixtures.ProjectBuilder

class FirebaseRemoteConfigGenTaskTest extends GroovyTestCase {

    void testGenClasses() {
        def project = ProjectBuilder.builder().build()
        def task = (FirebaseRemoteConfigGenTask) project.task("genConofig", type: FirebaseRemoteConfigGenTask)
        task.outDirectory = new File("gen")

        def GeneratedProp = task.newConfig("com.eaglesakura.GeneratedFirebaseConfig")
        GeneratedProp.stringConfig("string_value", "nil")
        GeneratedProp.doubleConfig("double_value", 1.2345)
        GeneratedProp.doubleConfig("floatValue", 1.23f)
        GeneratedProp.longConfig("longValue", 12345)
        GeneratedProp.intConfig("intValue", 123)

        def SettingClass = task.newConfig("com.eaglesakura.db.GeneratedFirebaseConfig")
        SettingClass.booleanConfig("boolValue", false)
        SettingClass.enumConfig("enumValue", TestEnum.class.getName(), TestEnum.Hoge.name())

        task.execute()
    }
}
