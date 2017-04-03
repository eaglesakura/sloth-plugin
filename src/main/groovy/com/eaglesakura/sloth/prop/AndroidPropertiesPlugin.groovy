package com.eaglesakura.sloth.prop

import com.eaglesakura.json.JSON
import com.eaglesakura.sloth.database.property.model.PropertySource
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
                gen.outDirectory = project.props.output;
                gen.build();
            }
        }
    }

    private static PropertySource loadSource(File file) {
        return JSON.decode(file.text, PropertySource.class);
    }

    static class DSL {
        List<PropClassGenerator2> generators = [];
        File output = new File("src/main/gen/props");

        /**
         * ジェネレータを追加する
         * @param source
         * @param packageName
         */
        void property(File source, String packageName) {
            PropertySource src = loadSource(source);
            for (def group : src.groups) {
                PropClassGenerator2 gen = new PropClassGenerator2();
                gen.classPackageName = packageName;
                gen.addProperties(group);

                generators.add(gen);
            }
        }

        void output(File path) {
            this.output = path;
        }
    }
}
