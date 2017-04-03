package com.eaglesakura.sloth.dao

import com.eaglesakura.tool.log.Logger
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import org.greenrobot.greendao.generator.DaoGenerator
import org.greenrobot.greendao.generator.Schema

/**
 * Dao出力用のタスク
 */
class AndroidDaoGenTask extends DefaultTask {
    def outDirectory = new File("dao").absoluteFile
    def classPackageBase = "com.example.dao"

    /**
     * 出力対象のスキーマ
     */
    private def List<Schema> schemas = new ArrayList<>()

    /**
     * 新たなスキーマを生成する
     * @param version
     * @param packageName
     * @return
     */
    Schema newSchema(int version, String packageName) {
        Schema result = new Schema(version, "${classPackageBase}.${packageName}")
        schemas.add(result)
        return result
    }

    @TaskAction
    def generate() {
        Logger.initialize()
        Logger.outLogLevel = 0

        Logger.out "classPackageBase(${classPackageBase})"
        Logger.out "outDirectory(${outDirectory.absolutePath})"


        outDirectory.mkdirs()
        DaoGenerator gen = new DaoGenerator()
        for (Schema s : schemas) {
            gen.generateAll(s, outDirectory.absolutePath)
        }
    }
}