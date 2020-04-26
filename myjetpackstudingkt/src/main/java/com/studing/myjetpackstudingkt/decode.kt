package com.studing.myjetpackstudingkt


/**
 * @author mengpeng
 * time   2019/11/18 10:28
 * describe	     TODO
 */


import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException

object decode {

    /*@Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        println("decode is start:$args")
//        val sourceDir = File("E:\\开发资料\\QH项目资料\\知音\\ZhiYin素材\\零售助手")
        val sourceDir = File("C:\\Users\\admin\\Desktop\\Test")
        val desDir = File("C:\\Users\\admin\\Desktop\\Test1")

        copyfile(sourceDir,desDir)
//        changeName(sourceDir)
    }*/
    @JvmStatic
    fun main(args: Array<String>) {
        try {
            val fis = FileInputStream("C:\\Users\\admin\\Desktop\\Test\\aa.java")
            val fos = FileOutputStream("C:\\Users\\admin\\Desktop\\Test\\bb.ck")
            val temp = ByteArray(1024)
            var len = -1
            while (fis.read(temp).let { len = it; it != -1}) {
                fos.write(temp, 0, len)
            }
            fis.close()
            fos.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }

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
    @Throws(IOException::class)
    private fun copyfile(inf: File, outf: File) {
        var outf = outf
        if (inf.absolutePath.contains(".svn")) {
            return
        }
        println("from " + inf.absolutePath + ", to " + outf.absolutePath)
        if (inf.isDirectory) {
            outf.mkdirs()
            val files = inf.listFiles()
            for (file in files) {
                copyfile(file, File(outf.absolutePath + "\\" + file.name))
            }
        } else {
            var isChanged = false
            if (outf.name.endsWith(".java")) {
                outf = File(outf.absolutePath.replace(".java", ".py0"))
                isChanged = true
            } else if (outf.name.endsWith(".c")) {
                outf = File(outf.absolutePath.replace(".c", ".py1"))
                isChanged = true
            } else if (outf.name.endsWith(".cpp")) {
                outf = File(outf.absolutePath.replace(".cpp", ".py2"))
                isChanged = true
            } else if (outf.name.endsWith(".so")) {
                outf = File(outf.absolutePath.replace(".so", ".py3"))
                isChanged = true
            } else if (outf.name.endsWith(".h")) {
                outf = File(outf.absolutePath.replace(".h", ".py4"))
                isChanged = true
            }else if (outf.name.endsWith(".docx")) {
                outf = File(outf.absolutePath.replace(".docx", ".py5"))
                isChanged = true
            }
            val `is` = FileInputStream(inf)
            val os = FileOutputStream(outf)
            val buf = ByteArray(1024)
            var len = 0
//            while ((len = `is`.read(buf)) != -1) {
            while ( `is`.read(buf).let { len = it;it!=-1 }) {
                os.write(buf, 0, len)
                os.flush()
            }
            os.close()
            `is`.close()
            if (isChanged) {
//                inf.delete()
//                println("delete file:" + inf.absolutePath)
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
