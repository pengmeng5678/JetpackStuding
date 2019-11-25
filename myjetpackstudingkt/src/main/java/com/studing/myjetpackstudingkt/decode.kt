package com.studing.myjetpackstudingkt


/**
 * @author mengpeng
 * time   2019/11/18 10:28
 * describe	     TODO
 */


import java.io.File
import java.io.IOException

object decode {

    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        println("decode is start:$args")
        val sourceDir = File("E:\\开发资料\\QH项目资料\\知音\\ZhiYin素材\\零售助手")
        changeName(sourceDir)
    }

    private fun changeName(sourceDir: File) {
        if(sourceDir==null){
            return
        }
        val listFiles = sourceDir.listFiles()
        for (file in listFiles){
            if(file.name.startsWith("睡觉")){
                val replace = file.name.replace("睡觉", "")
                println("replace after file name is $replace,file")
                val newFile = File(file.parent.plus("/$replace"))
                file.renameTo(newFile)
                println("replace after file path is ${newFile.absolutePath}")
            }
        }
    }

    fun deleteDir(dir: File?): Boolean {
        if (dir == null) {
            return false
        }
        // 目录不存在返回true
        if (!dir.exists()) {
            return true
        }
        // 不是目录返回false
        if (!dir.isDirectory) {
            return false
        }
        // 现在文件存在且是文件夹
        val files = dir.listFiles()
        if (files != null && files.size != 0) {
            for (file in files) {
                if (file.isFile) {
                    if (!deleteFile(file)) {
                        return false
                    }
                } else if (file.isDirectory) {
                    if (!deleteDir(file)) {
                        return false
                    }
                }
            }
        }
        return dir.delete()
    }

    /**
     * 删除文件
     *
     * @param file 文件
     * @return `true`: 删除成功<br></br>`false`: 删除失败
     */
    fun deleteFile(file: File?): Boolean {
        return file != null && (!file.exists() || file.isFile && file.delete())
    }
}
