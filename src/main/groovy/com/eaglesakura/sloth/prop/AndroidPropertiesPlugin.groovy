package com.eaglesakura.sloth.prop

import com.eaglesakura.json.JSON
import com.eaglesakura.sloth.database.property.model.PropertySource
import com.eaglesakura.util.IOUtil
import org.gradle.api.DefaultTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.TaskAction

/**
 * Androidのプロパティリストを出力するPlugin
 */
class AndroidPropertiesPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        project.extensions.create("props", AndroidPropertiesPlugin.DSL);

        // 規定のタスクを追加
        project.task('androidGenerateProperties', type: PropClassGeneratorImpl)
    }

    static class PropClassGeneratorImpl extends DefaultTask {

        /**
         * 全てのgeneratorを実行する
         */
        @TaskAction
        void build() {
            for (PropClassGenerator2 gen : project.props.generators) {
                gen.outDirectory = project.props.output
                gen.build()
            }

            for (OutConfigJson outConfig : project.props.configs) {
                def file = new File(IOUtil.mkdirs(project.props.configOutput), outConfig.name)
                file.text = outConfig.json
            }
        }
    }

    private static PropertySource loadSource(File file) {
        return JSON.decode(file.text, PropertySource.class);
    }

    /**
     * アプリ側で使用するJSON
     */
    private static class OutConfigJson {
        String name
        String json
    }

    static class DSL {
        List<PropClassGenerator2> generators = []
        List<OutConfigJson> configs = []
        File output = new File("src/main/gen/props")
        File configOutput = new File("src/main/res/raw")

        /**
         * ジェネレータを追加する
         * @param source
         * @param packageName
         */
        void property(File source, String packageName) {
            PropertySource src = loadSource(source)
            for (def group : src.groups) {
                PropClassGenerator2 gen = new PropClassGenerator2();
                gen.classPackageName = packageName
                gen.sourceJson = source
                gen.addProperties(group)

                generators.add(gen)
            }
            def out = new OutConfigJson()
            out.json = JSON.encode(src)
            out.name = source.name
            configs.add(out)
        }

        void output(File path) {
            this.output = path
        }

        void configOutput(File path) {
            this.configOutput = path
        }
    }
}
